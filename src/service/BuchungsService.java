package service;

import java.util.List;

import model.Rechnung;
import model.Reise;

public class BuchungsService {

    public Rechnung buche(List<Reise> reisen) {
        return new Rechnung(reisen);
    }
}