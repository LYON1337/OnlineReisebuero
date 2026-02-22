package persistence;

import model.Reise;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class ReiseRepository {

    private static final String DATEINAME = "reisen.txt";

    public List<Reise> ladeReisen() {

        List<Reise> reisen = new ArrayList<>();

        // try-with-resources → Datei wird automatisch geschlossen
        try (BufferedReader reader = new BufferedReader(new FileReader(DATEINAME))) {

            String zeile;

            while ((zeile = reader.readLine()) != null) {

                String[] teile = zeile.split(";");

                LocalDate datum = LocalDate.parse(teile[0]);
                String startort = teile[1];
                String zielort = teile[2];
                String flugstrecke = teile[3];
                BigDecimal preis = new BigDecimal(teile[4]);

                Reise reise = new Reise(datum, startort, zielort, flugstrecke, preis);
                reisen.add(reise);
            }

        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Reisen!");
        }

        return reisen;
    }
}
