package pl.gren.oze_app.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CSVReader {

    private final String filePath = "Dane_meteo.csv";

    public int countHoursWithTemperature(String month, double targetTemperature) throws IOException {
        int totalHours = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CSVReader.class.getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String currentMonth = parts[0];

                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (header)
                }

                if (month == null || month.equalsIgnoreCase(currentMonth)) {
                    int column = (int) targetTemperature + 21; // Calculate the index of the column for the target temperature
                    if (column >= 1 && column < parts.length) {
                        double temperature = Double.parseDouble(parts[column]);
                        if (temperature == targetTemperature) {
                            totalHours++;
                        }
                    }
                }
            }
        }

        System.out.println("Liczba godzin dla temperatury " + targetTemperature + " stopni w miesiącu " + month + ": " + totalHours);
        return totalHours;
    }

    public Map<String, Integer> sumHoursWithTemperature(double targetTemperature) throws IOException {
        Map<String, Integer> temperatureSum = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CSVReader.class.getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String currentMonth = parts[0];

                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (header)
                }

                int monthTotalHours = 0;
                int column = (int) targetTemperature + 21; // Calculate the index of the column for the target temperature
                if (column >= 1 && column < parts.length) {
                    for (String part : parts) {
                        double temperature = Double.parseDouble(part);
                        if (temperature == targetTemperature) {
                            monthTotalHours++;
                        }
                    }
                }
                temperatureSum.put(currentMonth, temperatureSum.getOrDefault(currentMonth, 0) + monthTotalHours);
            }
        }

        for (Map.Entry<String, Integer> entry : temperatureSum.entrySet()) {
            System.out.println("Liczba godzin dla temperatury " + targetTemperature + " stopni w miesiącu " + entry.getKey() + ": " + entry.getValue());
        }
        return temperatureSum;
    }
}


