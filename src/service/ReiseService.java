package service;

import model.Reise;
import persistence.ReiseRepository;
import java.math.BigDecimal;
import java.util.*;

public class ReiseService {

    private List<Reise> reisen;

    // Konstruktor lädt automatisch alle Reisen
    public ReiseService() {
        ReiseRepository repository = new ReiseRepository();
        this.reisen = repository.ladeReisen();
    }

    public List<Reise> getAlleReisen() {
        return reisen;
    }

    // Filter nach Startort
    public List<Reise> filterNachStartort(String startort) {

        List<Reise> ergebnis = new ArrayList<>();

        for (Reise r : reisen) {
            if (r.getStartort().equalsIgnoreCase(startort)) {
                ergebnis.add(r);
            }
        }

        return ergebnis;
    }

    // Filter nach Maximalpreis mit BigDecimal
    public List<Reise> filterNachMaxPreis(BigDecimal maxPreis) {

        List<Reise> ergebnis = new ArrayList<>();

        for (Reise r : reisen) {
            if (r.getPreis().compareTo(maxPreis) <= 0) {
                ergebnis.add(r);
            }
        }

        return ergebnis;
    }
}
