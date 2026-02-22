package main;

import model.Reise;
import model.Warenkorb;
import service.ReiseService;
import service.BuchungsService;
import util.InputUtil;

import java.math.BigDecimal;
import java.util.List;

public class OnlineReisebueroApp {

    public static void main(String[] args) {

        // Initialisierung der zentralen Services
        ReiseService reiseService = new ReiseService();
        Warenkorb warenkorb = new Warenkorb();
        BuchungsService buchungsService = new BuchungsService();

        boolean running = true;

        // Hauptschleife des Programms
        while (running) {

            // Menü
            System.out.println("\n Online Reisebüro");
            System.out.println("1 - Alle Reisen anzeigen");
            System.out.println("2 - Nach Startort filtern");
            System.out.println("3 - Nach Max-Preis filtern");
            System.out.println("4 - Reise in Warenkorb legen");
            System.out.println("5 - Warenkorb anzeigen");
            System.out.println("6 - Buchen");
            System.out.println("0 - Beenden");

            // Benutzerauswahl einlesen
            int wahl = InputUtil.leseInt("Auswahl: ");

            switch (wahl) {

                case 1:
                    // Alle Reisen anzeigen
                    List<Reise> reisen = reiseService.getAlleReisen();
                    for (int i = 0; i < reisen.size(); i++) {
                        System.out.println(i + ": " + reisen.get(i));
                    }
                    break;

                case 2:
                    // Nach Startort filtern
                    String start = InputUtil.leseString("Startort: ");
                    List<Reise> gefiltertStart = reiseService.filterNachStartort(start);
                    gefiltertStart.forEach(System.out::println);
                    break;

                case 3:
                    // Nach maximalen Preis filtern (mit BigDecimal)
                    BigDecimal maxPreis = InputUtil.leseBigDecimal("Maximalpreis: ");
                    List<Reise> gefiltertPreis = reiseService.filterNachMaxPreis(maxPreis);
                    gefiltertPreis.forEach(System.out::println);
                    break;

                case 4:
                    // Reise in Warenkorb legen
                    List<Reise> alle = reiseService.getAlleReisen();

                    for (int i = 0; i < alle.size(); i++) {
                        System.out.println(i + ": " + alle.get(i));
                    }

                    int index = InputUtil.leseInt("Index der Reise: ");

                    try {
                        warenkorb.hinzufuegen(alle.get(index));
                        System.out.println("Reise wurde dem Warenkorb hinzugefügt.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Ungültiger Index!");
                    }

                    break;

                case 5:
                    // Warenkorb anzeigen
                    warenkorb.anzeigen();
                    break;

                case 6:
                    // Buchung durchführen
                    if (warenkorb.istLeer()) {
                        System.out.println("Warenkorb ist leer. Keine Buchung möglich.");
                        break;
                    }

                    buchungsService.buche(warenkorb.getReisen()).drucken();

                    // Warenkorb nach erfolgreicher Buchung leeren
                    warenkorb.leeren();
                    System.out.println("Warenkorb wurde geleert.");

                    break;

                case 0:
                    // Programm beenden
                    running = false;
                    System.out.println("Programm beendet.");
                    break;

                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }
}
