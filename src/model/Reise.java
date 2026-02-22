package model;

//Zusätzliches Importieren von LocalDate & BigDecimal, anstatt String für weniger Fehlerquellen
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Reise {

    private LocalDate datum;
    private String startort;
    private String zielort;
    private String flugstrecke;
    private BigDecimal preis;

    //Konstruktor
    public Reise(LocalDate datum, String startort, String zielort,
                 String flugstrecke, BigDecimal preis) {
        this.datum = datum;
        this.startort = startort;
        this.zielort = zielort;
        this.flugstrecke = flugstrecke;
        this.preis = preis;
    }

    public LocalDate getDatum() {
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

    public BigDecimal getPreis() {
        return preis;
    }

    @Override
    public String toString() {
    	// Formatierte Ausgabe mit 2 Nachkommastellen
        return datum + " | " + startort + " -> " + zielort +
               " | " + flugstrecke + " | " +
               preis.setScale(2, RoundingMode.HALF_UP) + " EUR";
    }
}
