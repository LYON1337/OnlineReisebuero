package model;

public class Reise {

    private String datum;
    private String startort;
    private String zielort;
    private String flugstrecke;
    private double preis;

    public Reise(String datum, String startort, String zielort,
                 String flugstrecke, double preis) {
        this.datum = datum;
        this.startort = startort;
        this.zielort = zielort;
        this.flugstrecke = flugstrecke;
        this.preis = preis;
    }

    public String getDatum() {
        return datum;
    }

    public String getStartort() {
        return startort;
    }

    public String getZielort() {
        return zielort;
    }

    public String getFlugstrecke() {
        return flugstrecke;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return datum + " | " + startort + " -> " + zielort +
               " | " + flugstrecke + " | " + preis + " EUR";
    }
}