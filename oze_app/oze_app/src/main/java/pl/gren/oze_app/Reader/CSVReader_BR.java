package pl.gren.oze_app.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVReader_BR {

        public void readCSVFile() {

            String line = "";

            ClassLoader classLoader = CSVReader_BR.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("Dane_meteo.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            try {

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException exception) {
                exception.printStackTrace();
                System.out.println("Wystąpił błąd podczas odczytu pliku.");
            } finally {
                try {
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }