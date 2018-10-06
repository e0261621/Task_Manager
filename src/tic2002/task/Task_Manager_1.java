package tic2002.task;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Task_Manager_1 {


    static Scanner in = new Scanner(System.in);
    static Task[] tasks = new Task[100];
    static int count = 0;  // to keep track of number of tasks in the list

    public static void main(String[] args) {
        printWelcome();
        String line;
        boolean isExit = false;
        while (!isExit) {
            printQuery();
            line = getInput();
            String command = line.split(" ")[0]; //extract the first word of the user input
            switch (command) {
                case "exit":
                case "": // exit if user input is empty
                    isExit = true;
                    break;
                case "add":
                    // todo: add code here
                    addTask(line);
                    printTaskCount();
                    break;
                case "print":
                    printTasks();
                    break;
                default:
                    printError();
            }
        }
        exit();

    }

    private static void printWelcome() {
        System.out.println("Welcome to TaskManager-Level1!");
    }

    private static void printTasks() {
        for (int i = 0; i < count; i++) {
            System.out.println("[" + (i + 1) + "] " + tasks[i].getDescription());
        }
    }

    private static void printTaskCount() {
        System.out.println("Tasks in the list: " + count);
    }

    // todo: add missing methods
    private static void printError() {
        System.out.println("Unknown command! please try again");
    }

    private static String getInput() {
        String text = in.nextLine();
        return text;
    }

    private static void printQuery() {
        System.out.print("Your task ? ");
    }

    private static void exit() {
        System.out.println("Bye!");
    }

    private static void addTask(String line) {
        Task task;
        String[] taskDescription = line.split(" ");
        String description = "";
        for (int i = 1; i < taskDescription.length; i++) {
            if (i == taskDescription.length - 1) {
                description += taskDescription[i];
            } else {
                description += taskDescription[i] + " ";
            }
        }
//        task = new Task(description);
        task = new Task(line.substring("add".length()));
        tasks[count] = task;
        count++;
    }
}