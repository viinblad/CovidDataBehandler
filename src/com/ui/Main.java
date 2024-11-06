package com.ui;

import com.datasource.FileHandler;
import com.domainmodel.RegionComparator;
import com.domainmodel.AldersGruppeComparator;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        // Filsti til CSV-filen
        String filePath = "11_noegletal_pr_region_pr_aldersgruppe.csv";

        // Læs data
        fileHandler.readData(filePath);

        // Opret Scanner for at få input fra brugeren
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Vis valgmuligheder til brugeren
            System.out.println("\nVælg en handling:");
            System.out.println("1 - Sorter efter region");
            System.out.println("2 - Sorter efter aldersgruppe");
            System.out.println("3 - Udskriv aktuel liste");
            System.out.println("4 - Udskriv totalsum");
            System.out.println("0 - Afslut");
            System.out.print("Indtast valg (0, 1, 2, 3 eller 4): ");

            int choice = scanner.nextInt();

            // Sortér data baseret på brugerens valg
            switch (choice) {
                case 1:
                    fileHandler.sortData(new RegionComparator());
                    System.out.println("\nData sorteret efter region:");
                    break;
                case 2:
                    fileHandler.sortData(new AldersGruppeComparator());
                    System.out.println("\nData sorteret efter aldersgruppe:");
                    break;
                case 3:
                    System.out.println("\nAktuel liste:");
                    fileHandler.printData(); // Udskriv dataene
                    break;
                case 4:
                    System.out.println("\nTotalsum:");
                    fileHandler.printTotals(); // Udskriv totalsum
                    break;
                case 0:
                    System.out.println("Afslutter programmet...");
                    running = false; // Afslut løkken
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }

        // Luk Scanner
        scanner.close();
    }
}