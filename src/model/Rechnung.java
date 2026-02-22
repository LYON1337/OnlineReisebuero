package model;

import model.Reise;
import java.math.BigDecimal;
import java.util.List;

public class Rechnung {

    private List<Reise> reisen;

    public Rechnung(List<Reise> reisen) {
        this.reisen = reisen;
    }

    // Berechnet Gesamtpreis mit BigDecimal
    public BigDecimal berechneGesamtpreis() {

        BigDecimal summe = BigDecimal.ZERO;

        for (Reise r : reisen) {
            summe = summe.add(r.getPreis());
        }

        return summe;
    }

    public void drucken() {

        System.out.println("----- RECHNUNG -----");

        for (Reise r : reisen) {
            System.out.println(r);
        }

        System.out.println("Gesamtpreis: " + berechneGesamtpreis() + " EUR");
    }
}
