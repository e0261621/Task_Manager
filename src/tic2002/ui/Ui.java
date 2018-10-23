package tic2002.ui;

import java.util.Scanner;

public class Ui {

    private Scanner in;

    /**
     * Constructor takes in user input
     */
    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Prints "Your task?"
     * @return the line read in after trimming trailing and leading spaces
     */
    public String readUserCommand() {
        System.out.print("Your task? ");
        return in.nextLine().trim();
    }

    /**
     * Prints "Welcome to Task Manager :D".
     */
    public static void printWelcome() {
        System.out.println("Welcome to Task Manager :D ");
    }

    /**
     * Displays to user the message passed in.
     * @param message
     */
    public static void showToUser(String message) {
        System.out.println(message);
    }

    /**
     * Displays to user the error message passed in
     * Not to be confused with showToUser().
     * @param message
     */
    public static void printError(String message) {
        System.out.println(message);
    }
}
