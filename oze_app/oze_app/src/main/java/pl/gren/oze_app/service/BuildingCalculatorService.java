package pl.gren.oze_app.service;

import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gren.oze_app.exceptions.BuildingRequirementsNotFoundException;
import pl.gren.oze_app.model.BuildingConstants;
import pl.gren.oze_app.model.BuildingRequirements;
import pl.gren.oze_app.repository.BuildingRequirementsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;


@Service
public class BuildingCalculatorService {

    private final BuildingRequirementsRepository buildingRequirementsRepository;

    @Autowired
    public BuildingCalculatorService(BuildingRequirementsRepository buildingRequirementsRepository) {
        this.buildingRequirementsRepository = buildingRequirementsRepository;
    }



    @Transactional
    public void lost1(long buildingRequirementsID) {
        // Pobranie obiektu BuildingRequirements z bazy danych
        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new BuildingRequirementsNotFoundException("BuildingRequirements not found for id: " + buildingRequirementsID));

        // Pobranie wartości buildingTypeMultiplier1 z BuildingConstants
        double buildingTypeMultiplier1 = BuildingConstants.BUILDING_TYPE_MULTIPLIERS1.get(buildingRequirements.getBuildingType());


        double wallTypeMultiplier = BuildingConstants.WALL_TYPE_VALUES.get(buildingRequirements.getWallType());
        double wallInsulationMultiplier = BuildingConstants.ISOLATION_VALUES.get(buildingRequirements.getWallInsulation());

        double af47 = 1 / (((buildingRequirements.getWallThickness() / 100) / wallTypeMultiplier) +
                (buildingRequirements.getWallInsulationThickness() / 100) / wallInsulationMultiplier);


        // Zaokrąglenie do 6 miejsc po przecinku
        af47 = Math.round(af47 * 1e6) / 1e6;

        // Ustawienie wartości w obiekcie
        buildingRequirements.setAf47(af47);


        // Obliczenia dla lost1math
        double lost1math = (buildingRequirements.getBuildingDimensionsX() * 2 + buildingRequirements.getBuildingDimensionsY() * 2) *
                buildingRequirements.getRoomHeight() * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()) *
                buildingRequirements.getAf47() * (buildingTypeMultiplier1 + (buildingRequirements.isBasementPresent() ? 0.5 : 0));

        // Zaokrąglenie do 0 miejsc po przecinku
        lost1math = Math.round(lost1math);
        buildingRequirements.setLost1(lost1math);


        System.out.println("Policzone!" + "af47: " + af47 + "lost1math: " + lost1math);
        System.out.println("buildingtypemultiplier: " + buildingTypeMultiplier1);
        System.out.println("wallTypeMultiplier: " + wallTypeMultiplier);
        System.out.println("wallInsulationMultiplier: " + wallInsulationMultiplier);
    }

    @Transactional
    public void lost2(long buildingRequirementsID) {
        // Pobranie obiektu BuildingRequirements z bazy danych
        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new RuntimeException("BuildingRequirements not found for id: " + buildingRequirementsID));

        double roofInsulationMultiplier = BuildingConstants.ISOLATION_VALUES.get(buildingRequirements.getRoofInsulation());
        double af48 = 1 / ((buildingRequirements.getRoofInsulationThickness() / 100) / roofInsulationMultiplier);
        af48 = Math.round(af48 * 1000.0) / 1000.0;
        buildingRequirements.setAf48(af48);


        double buildingTypeMultiplier2 = BuildingConstants.BUILDING_TYPE_MULTIPLIERS2.get(buildingRequirements.getBuildingType());
        double lost2 = Math.round(buildingRequirements.getBuildingDimensionsSum() * buildingTypeMultiplier2 *
                af48 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()));
        buildingRequirements.setLost2(lost2);

        System.out.println("Policzone!" + "af48: " + af48 + "lost2 " + lost2);
        System.out.println("buildingtypemultiplier: " + buildingTypeMultiplier2);
        System.out.println("roofInsulationMultiplier: " + roofInsulationMultiplier);

    }

    // round to nearest higher even number - like in excel (zaokr.do.parz.)
    public static double roundUpToEven(double value) {
        double roundedValue = Math.ceil(value);
        return (roundedValue % 2 == 0) ? roundedValue : roundedValue + 1;
    }

    @Transactional
    public void lost3(long buildingRequirementsID) {

        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new RuntimeException("BuildingRequirements not found for id: " + buildingRequirementsID));

        double wallInsulationMultiplier = BuildingConstants.ISOLATION_VALUES.get(buildingRequirements.getWallInsulation());
        double floorInsulationMultiplier = BuildingConstants.ISOLATION_VALUES.get(buildingRequirements.getFloorInsulation());

        double af51 = 1 / ((buildingRequirements.getFloorInsulationThickness()/100) / floorInsulationMultiplier);


        // ah51
        double ah51 = roundUpToEven(buildingRequirements.getBuildingDimensionsSum() /
                (0.5 * (buildingRequirements.getBuildingDimensionsX() * 2 + buildingRequirements.getBuildingDimensionsY() * 2 -
                        (buildingRequirements.getWallThickness() + buildingRequirements.getWallInsulationThickness()) / 100 * 4)));


        double aj51;
        double floorInsulationThickness = buildingRequirements.getFloorInsulationThickness();

        if (buildingRequirements.isBasementPresent())
        {
            int af51Value = (floorInsulationThickness == 0) ? 2 : (int) findAF51(af51);
            aj51 = findAH51((int) ah51, af51Value, true);
        }
        else
        {
            int af51Value = (floorInsulationThickness == 0) ? 2 : (int) findAF51(af51);
            aj51 = findAH51((int) ah51, af51Value, false);
        }

        double lost3 = 1.45 * ((buildingRequirements.getRoomHeatingTemperature() - 7.6) / (buildingRequirements.getRoomHeatingTemperature()
                - buildingRequirements.getLocationTemperature())) * buildingRequirements.getBuildingDimensionsSum() *
                (buildingRequirements.getBuildingDimensionsSum() /
                        (0.5 * (buildingRequirements.getBuildingDimensionsX() * 2 + buildingRequirements.getBuildingDimensionsY() * 2))) * aj51 * 1.9;

        System.out.println("Policzone!" + "af51: " + af51);
        System.out.println("ah51: " + ah51);
        System.out.println("aj51: " + aj51);
        System.out.println("lost3: " + lost3);
        System.out.println("wallInsulationMultiplier: " + wallInsulationMultiplier);
        System.out.println("floorInsulationMultiplier: " + floorInsulationMultiplier);
        System.out.println("zAOKRAGLAM: " + roundUpToEven(4.32));

        buildingRequirements.setAf51(af51);
        buildingRequirements.setAh51(ah51);
        buildingRequirements.setAj51(aj51);
        buildingRequirements.setLost3(lost3);
    }

    public double findAH51(int ah51, int position, boolean flag) {

      double value;

      if(flag) {
          if (BuildingConstants.BASEMENT_FLOOR_VALUES.containsKey(ah51)) {
              // pobierz pozycje z rzedu w ktorej znajduje sie ah51 wedlug podanego inta
              System.out.println("Flag true");
              value = BuildingConstants.BASEMENT_FLOOR_VALUES.get(ah51).get(position);
              System.out.println("value " + value);

          } else {
              value = 0;
          }
      }
      else {
          if (BuildingConstants.BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.containsKey(ah51)) {
              // pobierz pozycje z rzedu w ktorej znajduje sie ah51 wedlug podanego inta
              System.out.println("Flag false");
              value = BuildingConstants.BASEMENT_FLOOR_VALUES_WITHOUT_INSULATION.get(ah51).get(position);
              System.out.println("value " + value);
          } else {
              value = 0;
          }
      }

        return value;
    }

    // return higher value than af51 but in revert (podaj.pozycje formula with type of compare -1)
    public double findAF51(double af51) {

        ArrayList<Double> rowValues = new ArrayList<>();
        Map<Integer, Double> innerMap = BuildingConstants.BASEMENT_FLOOR_VALUES.get(0);
        double returnValue = 0;


       // Jeśli istnieje taka mapa
        if (innerMap != null) {
            // Pętla po wartościach wewnętrznej mapy (klucze Integer i wartości Double)
            for (Double value : innerMap.values()) {
                rowValues.add(value);
                System.out.println("Wartosci rowValues w findaf51: " + value);
                System.out.println("Pozycje tych wartosci to: " + (rowValues.indexOf(value)) + 1.0);
            }
        }

        Collections.reverse(rowValues);

        for (Double value : rowValues) {
            if (value > af51) {
                System.out.println("Find AF51: ");
                System.out.println("Found value greater than af51: " + value);
                System.out.println("Pozycja to: " + rowValues.indexOf(value));

                returnValue = (double) rowValues.indexOf(value);

                returnValue = rowValues.size() - returnValue;
                System.out.println("ZWRACAM RETURN VALUE: " + returnValue);
                return returnValue;
            }
        }

        System.out.println("No value greater than af51 found, returning the last value.");
        return returnValue;
    }

    @Transactional
    public double lost4(long buildingRequirementsID) {

        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new RuntimeException("BuildingRequirements not found for id: " + buildingRequirementsID));

        double af49;

        String windowBlindType = buildingRequirements.getWindowBlindType();

        if ("doubleGlazed".equals(windowBlindType)) {
            af49 = 1.2;
        } else if ("tripleGlazed".equals(windowBlindType)) {
            af49 = 0.63;
        } else {
            af49 = 0;
        }

        double lost4 = Math.round(1.5 * 1.5 * buildingRequirements.getWindowBlindAmount() * af49 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()));

        buildingRequirements.setLost4(lost4);
        buildingRequirements.setAf49(af49);
        System.out.println("af49: " + af49);
        System.out.println("lost4: " + lost4);


        return lost4;
    }

    @Transactional
    public double lost5(long buildingRequirementsID) {

        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new RuntimeException("BuildingRequirements not found for id: " + buildingRequirementsID));

        double doorAmount = buildingRequirements.getEntranceDoorsAmount();

        double lost5 = 2 * 1 * doorAmount * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature());
        buildingRequirements.setLost5(lost5);
        System.out.println("lost 5: " + lost5);

        return lost5;
    }

    @Transactional
    public double lost6(long buildingRequirementsID) {

        BuildingRequirements buildingRequirements = buildingRequirementsRepository.findById(buildingRequirementsID)
                .orElseThrow(() -> new RuntimeException("BuildingRequirements not found for id: " + buildingRequirementsID));

      double lost6 = Math.round(calculateVentilationType(buildingRequirements));

      buildingRequirements.setLost6(lost6);

        return lost6;
    }

    public double calculateVentilationType(BuildingRequirements buildingRequirements) {

        double value;
        String ventilationType = buildingRequirements.getVentilationType();
        double entranceDoorAmount = buildingRequirements.getEntranceDoorsAmount();
        double buildingTypeMultiplier1 = BuildingConstants.BUILDING_TYPE_MULTIPLIERS1.get(buildingRequirements.getBuildingType());

        double ag52 = 2 * buildingRequirements.getHeatedArea() * buildingRequirements.getRoomHeight() * buildingTypeMultiplier1 * 3.5 * (entranceDoorAmount >= 2 ? 0.03 : 0.02) * 1;
        buildingRequirements.setAg52(ag52);
        System.out.println("ag52: " + ag52);


        if (ventilationType.equals("gravity")) {
            value = 0.34 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()) * 0.5 * buildingRequirements.getHeatedArea() * buildingRequirements.getRoomHeight() * 1.2;
        } else if (ventilationType.equals("mechanical")) {

            double ah58 = (20 - (buildingRequirements.getLocationTemperature() + 0.4 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature())) / (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()));
            buildingRequirements.setAh58(ah58);
            System.out.println("ah58: " + ah58);

            double ai55 = ag52 + 35 * ah58 + 0;
            buildingRequirements.setAi55(ai55);
            System.out.println("ai55: " + ai55);

            value = 0.34 * ai55 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature());
        } else if (ventilationType.equals("mechanicalWithHeatRecovery")) {

            double aj58 = (20 - (buildingRequirements.getLocationTemperature() + 0.8 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature())) / (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature()));
            buildingRequirements.setAj58(aj58);
            System.out.println("aj58: " + aj58);
            double aj55 = ag52 + 20 * aj58 + 0;
            buildingRequirements.setAj55(aj55);
            System.out.println("aj55: " + aj55);

            value = 0.34 * aj55 * (buildingRequirements.getRoomHeatingTemperature() - buildingRequirements.getLocationTemperature());
        } else
            value = 0;

        System.out.println("Lost6:" + value);
        return value;
    }

    public double calculateCO(BuildingRequirements buildingRequirements) {

        double lost1 = buildingRequirements.getLost1();
        double lost2 = buildingRequirements.getLost2();
        double lost3 = buildingRequirements.getLost3();
        double lost4 = buildingRequirements.getLost4();
        double lost5 = buildingRequirements.getLost5();
        double lost6 = buildingRequirements.getLost6();

        double COValue = (lost1 + lost2 + lost3 + lost4 + lost5 + lost6) / 1000;


        buildingRequirements.setCOValue(COValue);

        return COValue;
    }
    public double calculateFuel(BuildingRequirements buildingRequirements)
    {
        double fuel = buildingRequirements.getFuelUsageAmount() * buildingRequirements.getFuelEnergyValue() * buildingRequirements.getHeatingSourceEfficiency() / 2000;
        buildingRequirements.setFuelValue(fuel);
        return fuel;
    }

    public double calculateCWU(BuildingRequirements buildingRequirements)
    {
        double CWUValue = buildingRequirements.getWaterDemand() / buildingRequirements.getPeopleCountWater();
        buildingRequirements.setCWUValue(CWUValue);
        return CWUValue;
    }


    }


