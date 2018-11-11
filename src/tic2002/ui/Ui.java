package tic2002.ui;

import java.util.Scanner;

import static tic2002.Constants.TaskManagerContants.*;

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
     *
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

    public static void printGoodBye() {
        System.out.println("Goodbye, see you soon!");
    }

    /**
     * Displays to user the message passed in.(Line by line)
     *
     * @param message
     */
    public static void showToUser(String message) {
        System.out.println(message);
    }

    /**
     * Display to user the message passed in.(No new line)
     *
     * @param message
     */
    public static void showToUserNoNewLine(String message) {
        System.out.print(message);
    }

    /**
     * Displays to user the error message passed in
     * Not to be confused with showToUser().
     *
     * @param message
     */
    public static void printError(String message) {
        System.out.println(message);
    }

    public static void helpMessage() {
        String helpMessage = String.format("%-20s%s\n%-20s%s\n%-20s%s\n%-20s%s\n", TODO, TODO_HELP_STATEMENT,
                DEADLINE, DEADLINE_HELP_STATEMENT,
                SAVE, SAVE_HELP_STATEMENT,
                PRINT, PRINT_HELP_STATEMENT);

        System.out.println(helpMessage);
    }
}
