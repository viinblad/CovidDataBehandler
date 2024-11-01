package java.ui;

import java.datasource.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        // Sørg for at ændre filstien til den korrekte placering af CSV-filen i projektet
        String filePath = "11_noegletal_pr_region_pr_aldersgruppe.csv";
        fileHandler.readData(filePath);

        // Udskriv dataene
        fileHandler.printData();
    }
}
