package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String leseString(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public static int leseInt(String text) {

        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahl!");
            }
        }
    }

    public static BigDecimal leseBigDecimal(String text) {

        while (true) {
            try {
                System.out.print(text);
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültiger Betrag!");
            }
        }
    }
}
