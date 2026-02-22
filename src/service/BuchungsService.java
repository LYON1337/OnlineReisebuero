package service;

import model.Reise;
import model.Rechnung;
import java.util.List;

public class BuchungsService {

    // Erstellt eine Rechnung aus Warenkorb
    public Rechnung buche(List<Reise> reisen) {
        return new Rechnung(reisen);
    }
}
