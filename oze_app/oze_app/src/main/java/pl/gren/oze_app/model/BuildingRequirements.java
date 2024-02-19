package pl.gren.oze_app.model;

import jakarta.persistence.*;

@Entity
public class BuildingRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private double locationTemperature;
    private String buildingType;
    private double buildingDimensionsX;
    private double buildingDimensionsY;
    private double buildingDimensionsSum;
    private double heatedArea;
    private double roomHeight;
    private double roomHeatingTemperature;
    private double heatingPumpSetTemperature;
    private double roomCoolingTemperature;
    private double coolingPumpSetTemperature;
    private boolean basementPresent;
    private String wallType;
    private double wallThickness;
    private String wallInsulation;
    private double wallInsulationThickness;
    private String roofInsulation;
    private double roofInsulationThickness;
    private String floorInsulation;
    private double floorInsulationThickness;
    private String windowBlindType;
    private double windowBlindAmount;
    private double entranceDoorsAmount;
    private String ventilationType;
    private String currentFuelType;
    private double fuelUsageAmount;
    private String fuelUsageUnit;
    private double fuelEnergyValue;
    private String fuelEnergyValueUnit;
    private int peopleCountWater;
    private double waterDemand;
    private String waterUsageMethod;
    private double heatingSourceEfficiency;


    private double af47;
    private double lost1, lost2, lost3, lost4, lost5, lost6;
    private double af48, af49;
    private double af51, aj51, ah51;
    private double ag52, ah58, ai55, aj58, aj55;

    public BuildingRequirements() {

    }

    public double getFuelEnergyValue() {
        return fuelEnergyValue;
    }

    public double getHeatingSourceEfficiency() {
        return heatingSourceEfficiency;
    }

    public void setFuelEnergyValue(double fuelEnergyValue) {
        this.fuelEnergyValue = fuelEnergyValue;
    }

    public String getFuelEnergyValueUnit() {
        return fuelEnergyValueUnit;
    }

    public void setFuelEnergyValueUnit(String fuelEnergyValueUnit) {
        this.fuelEnergyValueUnit = fuelEnergyValueUnit;
    }

    public void setHeatingSourceEfficiency(double heatingSourceEfficiency) {
        this.heatingSourceEfficiency = heatingSourceEfficiency;
    }

    public double getLost5() {
        return lost5;
    }

    public void setLost5(double lost5) {
        this.lost5 = lost5;
    }

    public double getLost6() {
        return lost6;
    }

    public void setLost6(double lost6) {
        this.lost6 = lost6;
    }

    public double getAg52() {
        return ag52;
    }

    public void setAg52(double ag52) {
        this.ag52 = ag52;
    }

    public double getAh58() {
        return ah58;
    }

    public void setAh58(double ah58) {
        this.ah58 = ah58;
    }

    public double getAi55() {
        return ai55;
    }

    public void setAi55(double ai55) {
        this.ai55 = ai55;
    }

    public double getAj58() {
        return aj58;
    }

    public void setAj58(double aj58) {
        this.aj58 = aj58;
    }

    public double getAj55() {
        return aj55;
    }

    public void setAj55(double aj55) {
        this.aj55 = aj55;
    }

    public double getLost4() {
        return lost4;
    }

    public void setLost4(double lost4) {
        this.lost4 = lost4;
    }

    public double getAf49() {
        return af49;
    }

    public void setAf49(double af49) {
        this.af49 = af49;
    }

    public double getLost3() {
        return lost3;
    }

    public void setLost3(double lost3) {
        this.lost3 = lost3;
    }

    public double getAf51() {
        return af51;
    }

    public void setAf51(double af51) {
        this.af51 = af51;
    }

    public double getAj51() {
        return aj51;
    }

    public void setAj51(double aj51) {
        this.aj51 = aj51;
    }

    public double getAh51() {
        return ah51;
    }

    public void setAh51(double ah51) {
        this.ah51 = ah51;
    }

    public double getLost2() {
        return lost2;
    }

    public void setLost2(double lost2) {
        this.lost2 = lost2;
    }

    public double getAf48() {
        return af48;
    }

    public void setAf48(double af48) {
        this.af48 = af48;
    }


    //    @PostPersist
//    private void afterSave() {
//        // Wywołaj procedurę składowaną po zapisaniu do bazy danych
//        EntityManager entityManager = Persistence.createEntityManagerFactory("yourPersistenceUnitName").createEntityManager();
//        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("CountThings");
//        storedProcedure.registerStoredProcedureParameter("entityId", Integer.class, ParameterMode.IN);
//        storedProcedure.setParameter("entityId", this.getId());
//        storedProcedure.execute();
//        entityManager.close();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLocationTemperature() {
        return locationTemperature;
    }

    public void setLocationTemperature(double locationTemperature) {
        this.locationTemperature = locationTemperature;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public double getBuildingDimensionsX() {
        return buildingDimensionsX;
    }

    public void setBuildingDimensionsX(double buildingDimensionsX) {
        this.buildingDimensionsX = buildingDimensionsX;
    }

    public double getBuildingDimensionsY() {
        return buildingDimensionsY;
    }

    public void setBuildingDimensionsY(double buildingDimensionsY) {
        this.buildingDimensionsY = buildingDimensionsY;
    }

    public double getBuildingDimensionsSum() {
        return buildingDimensionsSum;
    }

    public void setBuildingDimensionsSum(double buildingDimensionsSum) {
        this.buildingDimensionsSum = buildingDimensionsSum;
    }

    public double getHeatedArea() {
        return heatedArea;
    }

    public void setHeatedArea(double heatedArea) {
        this.heatedArea = heatedArea;
    }

    public double getRoomHeight() {
        return roomHeight;
    }

    public void setRoomHeight(double roomHeight) {
        this.roomHeight = roomHeight;
    }

    public double getRoomHeatingTemperature() {
        return roomHeatingTemperature;
    }

    public void setRoomHeatingTemperature(double roomHeatingTemperature) {
        this.roomHeatingTemperature = roomHeatingTemperature;
    }

    public double getHeatingPumpSetTemperature() {
        return heatingPumpSetTemperature;
    }

    public void setHeatingPumpSetTemperature(double heatingPumpSetTemperature) {
        this.heatingPumpSetTemperature = heatingPumpSetTemperature;
    }

    public double getRoomCoolingTemperature() {
        return roomCoolingTemperature;
    }

    public void setRoomCoolingTemperature(double roomCoolingTemperature) {
        this.roomCoolingTemperature = roomCoolingTemperature;
    }

    public double getCoolingPumpSetTemperature() {
        return coolingPumpSetTemperature;
    }

    public void setCoolingPumpSetTemperature(double coolingPumpSetTemperature) {
        this.coolingPumpSetTemperature = coolingPumpSetTemperature;
    }

    public boolean isBasementPresent() {
        return basementPresent;
    }

    public void setBasementPresent(boolean basementPresent) {
        this.basementPresent = basementPresent;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public double getWallThickness() {
        return wallThickness;
    }

    public void setWallThickness(double wallThickness) {
        this.wallThickness = wallThickness;
    }

    public String getWallInsulation() {
        return wallInsulation;
    }

    public void setWallInsulation(String wallInsulation) {
        this.wallInsulation = wallInsulation;
    }

    public double getWallInsulationThickness() {
        return wallInsulationThickness;
    }

    public void setWallInsulationThickness(double wallInsulationThickness) {
        this.wallInsulationThickness = wallInsulationThickness;
    }

    public String getRoofInsulation() {
        return roofInsulation;
    }

    public void setRoofInsulation(String roofInsulation) {
        this.roofInsulation = roofInsulation;
    }

    public double getRoofInsulationThickness() {
        return roofInsulationThickness;
    }

    public void setRoofInsulationThickness(double roofInsulationThickness) {
        this.roofInsulationThickness = roofInsulationThickness;
    }

    public String getFloorInsulation() {
        return floorInsulation;
    }

    public void setFloorInsulation(String floorInsulation) {
        this.floorInsulation = floorInsulation;
    }

    public double getFloorInsulationThickness() {
        return floorInsulationThickness;
    }

    public void setFloorInsulationThickness(double floorInsulationThickness) {
        this.floorInsulationThickness = floorInsulationThickness;
    }

    public String getWindowBlindType() {
        return windowBlindType;
    }

    public void setWindowBlindType(String windowBlindType) {
        this.windowBlindType = windowBlindType;
    }

    public double getWindowBlindAmount() {
        return windowBlindAmount;
    }

    public void setWindowBlindAmount(double windowBlindAmount) {
        this.windowBlindAmount = windowBlindAmount;
    }

    public double getEntranceDoorsAmount() {
        return entranceDoorsAmount;
    }

    public void setEntranceDoorsAmount(double entranceDoorsAmount) {
        this.entranceDoorsAmount = entranceDoorsAmount;
    }

    public String getVentilationType() {
        return ventilationType;
    }

    public void setVentilationType(String ventilationType) {
        this.ventilationType = ventilationType;
    }

    public String getCurrentFuelType() {
        return currentFuelType;
    }

    public void setCurrentFuelType(String currentFuelType) {
        this.currentFuelType = currentFuelType;
    }

    public double getFuelUsageAmount() {
        return fuelUsageAmount;
    }

    public void setFuelUsageAmount(double fuelUsageAmount) {
        this.fuelUsageAmount = fuelUsageAmount;
    }

    public String getFuelUsageUnit() {
        return fuelUsageUnit;
    }

    public void setFuelUsageUnit(String fuelUsageUnit) {
        this.fuelUsageUnit = fuelUsageUnit;
    }

    public int getPeopleCountWater() {
        return peopleCountWater;
    }

    public void setPeopleCountWater(int peopleCountWater) {
        this.peopleCountWater = peopleCountWater;
    }

    public double getWaterDemand() {
        return waterDemand;
    }

    public void setWaterDemand(double waterDemand) {
        this.waterDemand = waterDemand;
    }

    public String getWaterUsageMethod() {
        return waterUsageMethod;
    }

    public void setWaterUsageMethod(String waterUsageMethod) {
        this.waterUsageMethod = waterUsageMethod;
    }



    public double getLost1() {
        return lost1;
    }

    public void setLost1(double lost1) {
        this.lost1 = lost1;
    }

    public double getAf47() {
        return af47;
    }

    public void setAf47(double af47) {
        this.af47 = af47;
    }
}