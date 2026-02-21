package model;

import java.util.List;

public class Rechnung {

    private List<Reise> reisen;

    public Rechnung(List<Reise> reisen) {
        this.reisen = reisen;
    }

    public double berechneGesamtpreis() {

        double summe = 0;

        for (Reise r : reisen) {
            summe += r.getPreis();
        }

        return summe;
    }

    public void druckeRechnung() {

        System.out.println("---- RECHNUNG ----");

        for (Reise r : reisen) {
            System.out.println(r);
        }

        System.out.println("-----------------");
        System.out.println("Gesamtpreis: " + berechneGesamtpreis() + " EUR");
    }
}