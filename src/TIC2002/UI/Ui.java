package TIC2002.UI;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * ui = new Ui();
 * ...
 * ui.showWelcomeMessage();
 * ...
 * Sting fullCommand = ui.readUserCommand();
 */

public class Ui {

    private Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readUserCommand() {
        System.out.print("Your task? ");
        return in.nextLine().trim();
    }

    // ...

    public static void printWelcome() {
        System.out.println("Welcome to Task Manager :D ");
    }

    public static void showToUser(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
