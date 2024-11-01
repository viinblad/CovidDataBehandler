package com.domainmodel;

public class Covid19Data {
    private String region;
    private String aldersgruppe;
    private int bekræftedeTilfælde;
    private int døde;
    private int indlagtePåIntensivAfdeling;
    private int indlagte;
    private String dato;

    public Covid19Data(String region, String aldersgruppe, int bekræftedeTilfælde, int døde, int indlagtePåIntensivAfdeling, int indlagte, String dato) {
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftedeTilfælde = bekræftedeTilfælde;
        this.døde = døde;
        this.indlagtePåIntensivAfdeling = indlagtePåIntensivAfdeling;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    public int getBekræftedeTilfælde() {
        return bekræftedeTilfælde;
    }

    public int getDøde() {
        return døde;
    }

    public int getIndlagtePåIntensivAfdeling() {
        return indlagtePåIntensivAfdeling;
    }

    public int getIndlagte() {
        return indlagte;
    }

    @Override
    public String toString() {
        return "Region: " + region +
                ", Aldersgruppe: " + aldersgruppe +
                ", Bekræftede Tilfælde: " + bekræftedeTilfælde +
                ", Døde: " + døde +
                ", Indlagte på Intensiv: " + indlagtePåIntensivAfdeling +
                ", Indlagte: " + indlagte +
                ", Dato: " + dato;
    }
}
