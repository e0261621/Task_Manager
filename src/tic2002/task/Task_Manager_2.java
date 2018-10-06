package tic2002.task;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Task_Manager_2 {


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
                case "todo":
                    addTodo(line);
                    break;
                case "deadline":
                    addDeadline(line);
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
        System.out.println("Welcome to TaskManager-Level2!");
    }

    private static void printTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < count; i++) {
            System.out.println("[" + (i + 1) + "] " + tasks[i]);
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

        String[] taskDescription = line.split(" ");
        String description = "";
        for (int i = 1; i < taskDescription.length; i++) {
            if (i == taskDescription.length - 1) {
                description += taskDescription[i];
            } else {
                description += taskDescription[i] + " ";
            }
        }
        tasks[count] = new Task(description);
        count++;
    }

    private static void addTodo(String line) {
        tasks[count] = new Todo(line.substring("todo".length()).trim());
        count++;
        printTaskCount();
//        System.out.println("Tasks in the list: " + taskCount);
    }

    private static void addDeadline(String line) {
        int idxOfBy = line.indexOf("/by");
        String deadline = "";

        tasks[count] = new Deadline(line.substring(0, idxOfBy).substring("deadline".length()).trim(),
                line.substring(idxOfBy, line.length()).substring("/by".length()).trim());
        count++;
        printTaskCount();
//        System.out.println("Tasks in the list: " + taskCount);
    }
}