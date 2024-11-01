package java.domainmodel;

public class Covid19Data {
    // Attributter, der matcher kolonneoverskrifterne i CSV-filen
    private String region;                // Region kolonnen
    private String aldersgruppe;          // Aldersgruppe kolonnen
    private int bekræftedeTilfældeIAlt;   // Bekræftede tilfælde i alt kolonnen
    private int døde;                     // Døde kolonnen
    private int indlagteIntensiv;         // Indlagte på intensiv afdeling kolonnen
    private int indlagte;                 // Indlagte kolonnen
    private String dato;                  // Dato kolonnen

    // Constructor
    public Covid19Data(String region, String aldersgruppe, int bekræftedeTilfældeIAlt, int døde, int indlagteIntensiv, int indlagte, String dato) {
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftedeTilfældeIAlt = bekræftedeTilfældeIAlt;
        this.døde = døde;
        this.indlagteIntensiv = indlagteIntensiv;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    // Gettere for hver attribut
    public String getRegion() {
        return region;
    }

    public String getAldersgruppe() {
        return aldersgruppe;
    }

    public int getBekræftedeTilfældeIAlt() {
        return bekræftedeTilfældeIAlt;
    }

    public int getDøde() {
        return døde;
    }

    public int getIndlagteIntensiv() {
        return indlagteIntensiv;
    }

    public int getIndlagte() {
        return indlagte;
    }

    public String getDato() {
        return dato;
    }

    // Overriding toString metoden for at gøre udskriften lettere
    @Override
    public String toString() {
        return "Region: " + region + ", Aldersgruppe: " + aldersgruppe +
                ", Bekræftede tilfælde i alt: " + bekræftedeTilfældeIAlt +
                ", Døde: " + døde +
                ", Indlagte på intensiv afdeling: " + indlagteIntensiv +
                ", Indlagte: " + indlagte +
                ", Dato: " + dato;
    }
}
