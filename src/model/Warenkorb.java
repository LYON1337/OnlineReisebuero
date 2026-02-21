package model;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {

    private List<Reise> reisen = new ArrayList<>();

    public void hinzufuegen(Reise r) {
        reisen.add(r);
    }

    public List<Reise> getReisen() {
        return reisen;
    }

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