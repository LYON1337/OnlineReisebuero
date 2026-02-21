package main;

import java.util.List;

import model.Reise;
import model.Warenkorb;
import model.Rechnung;
import service.BuchungsService;
import service.ReiseService;
import util.InputUtil;

public class OnlineReisebueroApp {

    public static void main(String[] args) {

        ReiseService reiseService = new ReiseService();
        Warenkorb warenkorb = new Warenkorb();
        BuchungsService buchungsService = new BuchungsService();

        boolean running = true;

        while (running) {

            System.out.println("\n1 Alle Reisen anzeigen");
            System.out.println("2 Nach Startort filtern");
            System.out.println("3 Nach Zielort filtern");
            System.out.println("4 Nach Max-Preis filtern");
            System.out.println("5 Reise in Warenkorb legen");
            System.out.println("6 Warenkorb anzeigen");
            System.out.println("7 Buchen");
            System.out.println("0 Beenden");

            int wahl = InputUtil.readInt();

            switch (wahl) {

                case 1:
                    zeigeListe(reiseService.getAlleReisen());
                    break;

                case 2:
                    System.out.print("Startort: ");
                    zeigeListe(
                        reiseService.filterNachStartort(
                            InputUtil.readString()));
                    break;

                case 3:
                    System.out.print("Zielort: ");
                    zeigeListe(
                        reiseService.filterNachZielort(
                            InputUtil.readString()));
                    break;

                case 4:
                    System.out.print("Max Preis: ");
                    zeigeListe(
                        reiseService.filterNachMaxPreis(
                            InputUtil.readDouble()));
                    break;

                case 5:
                    zeigeListe(reiseService.getAlleReisen());
                    System.out.print("Index: ");
                    int index = InputUtil.readInt();
                    warenkorb.hinzufuegen(
                        reiseService.getAlleReisen().get(index));
                    break;

                case 6:
                    warenkorb.anzeigen();
                    break;

                case 7:
                    Rechnung r = buchungsService
                            .buche(warenkorb.getReisen());
                    r.druckeRechnung();
                    break;

                case 0:
                    running = false;
                    break;
            }
        }
    }

    private static void zeigeListe(List<Reise> reisen) {

        int i = 0;
        for (Reise r : reisen) {
            System.out.println(i + ": " + r);
            i++;
        }
    }
}