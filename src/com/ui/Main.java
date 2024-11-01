package com.ui;

import com.datasource.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        // Filsti til CSV-filen
        String filePath = "11_noegletal_pr_region_pr_aldersgruppe.csv";

        // Læs og udskriv data
        fileHandler.readData(filePath);
        fileHandler.printData();

        // Udskriv totalsum
        fileHandler.printTotals();
    }
}
