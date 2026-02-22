package model;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {

    // Liste speichert alle ausgewählten Reisen
    private List<Reise> reisen = new ArrayList<>();

    // Fügt eine Reise zum Warenkorb hinzu
    public void hinzufuegen(Reise r) {
        reisen.add(r);
    }

    // Gibt die komplette Reiseliste zurück
    public List<Reise> getReisen() {
        return reisen;
    }

    // prüft ob der Warenkorb leer ist
    public boolean istLeer() {
        return reisen.isEmpty();
    }
    
    // Leert den Warenkorb nach erfolgreicher Buchung
    public void leeren() {
        reisen.clear();
    }

    // Gibt alle Reisen im Warenkorb formatiert aus
    public void anzeigen() {

        if (reisen.isEmpty()) {
            System.out.println("Warenkorb ist leer.");
            return;
        }

        int i = 0;

        for (Reise r : reisen) {
            System.out.println(i + ": " + r);
            i++;
        }
    }
}
