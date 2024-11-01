package com.datasource;

import com.domainmodel.Covid19Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<Covid19Data> covidDataList = new ArrayList<>();

    // Metode til at læse data fra CSV-filen
    public void readData(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file, StandardCharsets.ISO_8859_1); // Angiver ';' som delimiter
            scanner.nextLine(); // Skipper første linje (header)

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");

                // Tjek om regionsnavnet mangler
                if (values[0].isEmpty()) {
                    continue; // Skipper linjer uden region
                }

                // Skaber et nyt Covid19Data objekt med værdier fra linjen
                Covid19Data data = new Covid19Data(
                        values[0],       // Region
                        values[1],       // Aldersgruppe
                        Integer.parseInt(values[2]),  // Bekræftede tilfælde i alt
                        Integer.parseInt(values[3]),  // Døde
                        Integer.parseInt(values[4]),  // Indlagte på intensiv afdeling
                        Integer.parseInt(values[5]),  // Indlagte
                        values[6]        // Dato
                );

                // Tilføjer dataobjektet til ArrayListen
                covidDataList.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Fejl i dataformatet: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Metode til at udskrive dataene i ArrayListen
    public void printData() {
        for (Covid19Data data : covidDataList) {
            System.out.println(data);
        }
    }

    // Metode til at beregne og udskrive totalsum af data
    public void printTotals() {
        int totalBekræftedeTilfælde = 0;
        int totalDøde = 0;
        int totalIndlagtePåIntensivAfdeling = 0;
        int totalIndlagte = 0;

        for (Covid19Data data : covidDataList) {
            totalBekræftedeTilfælde += data.getBekræftedeTilfælde();
            totalDøde += data.getDøde();
            totalIndlagtePåIntensivAfdeling += data.getIndlagtePåIntensivAfdeling();
            totalIndlagte += data.getIndlagte();
        }

        System.out.println("Totalsum:");
        System.out.println("Bekræftede Tilfælde: " + totalBekræftedeTilfælde);
        System.out.println("Døde: " + totalDøde);
        System.out.println("Indlagte på Intensiv: " + totalIndlagtePåIntensivAfdeling);
        System.out.println("Indlagte: " + totalIndlagte);
    }

    // Getter for ArrayListen, hvis den ønskes tilgængelig andre steder
    public ArrayList<Covid19Data> getCovidDataList() {
        return covidDataList;
    }
}
