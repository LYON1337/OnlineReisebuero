package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Reise;

public class ReiseRepository {

    public List<Reise> ladeReisen() {

        List<Reise> reisen = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(
            		//new FileReader("X:\\Eclipse\\workspace\\OnlineReisebuero\\reisen.txt"));
            		new FileReader("OnlineReisebuero/reisen.txt"));

            String zeile;

            while ((zeile = reader.readLine()) != null) {

                String[] teile = zeile.split(";");

                Reise r = new Reise(
                        teile[0],
                        teile[1],
                        teile[2],
                        teile[3],
                        Double.parseDouble(teile[4])
                );

                reisen.add(r);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Fehler beim Laden der Reisen!");
        }

        return reisen;
    }
}