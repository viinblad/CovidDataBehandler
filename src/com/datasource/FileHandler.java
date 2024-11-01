package java.datasource;

import java.domainmodel.Covid19Data; // Importer Covid19Data fra domainmodel-pakken
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<Covid19Data> covidDataList = new ArrayList<>();

    public void readData(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath), StandardCharsets.ISO_8859_1)) {
            // Spring første linje over (kolonneoverskrifter)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Læs hver linje og opret Covid19Data-objekter
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                // Hvis der mangler regionsdata, spring linjen over
                if (data[0].isEmpty()) {
                    continue;
                }

                // Parse data og opret et Covid19Data objekt
                String region = data[0].replace("\"", "");
                String aldersgruppe = data[1].replace("\"", "");
                int bekræftedeTilfældeIAlt = Integer.parseInt(data[2]);
                int døde = Integer.parseInt(data[3]);
                int indlagteIntensiv = Integer.parseInt(data[4]);
                int indlagte = Integer.parseInt(data[5]);
                String dato = data[6].replace("\"", "");

                Covid19Data covidData = new Covid19Data(region, aldersgruppe, bekræftedeTilfældeIAlt, døde, indlagteIntensiv, indlagte, dato);
                covidDataList.add(covidData);
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet: " + e.getMessage());
        }
    }

    public void printData() {
        for (Covid19Data data : covidDataList) {
            System.out.println(data);
        }
    }
}
