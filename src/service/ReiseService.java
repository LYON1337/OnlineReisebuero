package service;

import java.util.ArrayList;
import java.util.List;

import model.Reise;
import persistence.ReiseRepository;

public class ReiseService {

    private List<Reise> alleReisen;

    public ReiseService() {
        ReiseRepository repo = new ReiseRepository();
        alleReisen = repo.ladeReisen();
    }

    public List<Reise> getAlleReisen() {
        return alleReisen;
    }

    public List<Reise> filterNachStartort(String startort) {

        List<Reise> ergebnis = new ArrayList<>();

        for (Reise r : alleReisen) {
            if (r.getStartort().equalsIgnoreCase(startort)) {
                ergebnis.add(r);
            }
        }

        return ergebnis;
    }

    public List<Reise> filterNachZielort(String zielort) {

        List<Reise> ergebnis = new ArrayList<>();

        for (Reise r : alleReisen) {
            if (r.getZielort().equalsIgnoreCase(zielort)) {
                ergebnis.add(r);
            }
        }

        return ergebnis;
    }

    public List<Reise> filterNachMaxPreis(double maxPreis) {

        List<Reise> ergebnis = new ArrayList<>();

        for (Reise r : alleReisen) {
            if (r.getPreis() <= maxPreis) {
                ergebnis.add(r);
            }
        }

        return ergebnis;
    }
}