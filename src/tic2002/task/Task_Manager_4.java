package tic2002.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Task_Manager_4 {


    static Scanner in = new Scanner(System.in);
    static List<Task> tasks = new ArrayList<>();
//    static int count = 0;  // to keep track of number of tasks in the list

    public static void main(String[] args) {
        printWelcome();
        String line;
        boolean isExit = false;
        while (!isExit) {
            try {
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
                    case "done":
                        markAsDone(line);
                        break;
                }
            } catch (TaskManagerException e) {
                printError(e.getMessage());
            }
        }
        exit();

    }

    private static void printWelcome() {
        System.out.println("Welcome to TaskManager-Level4!");
    }

    private static void printTasks() {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : tasks) {
            System.out.println("[" + (i) + "] " + t);
            i++;
        }
    }


    private static void printTaskCount() {
        System.out.println("Tasks in the list: " + tasks.size());
    }

    // todo: add missing methods
    private static void printError(String error) {
        if (!error.isEmpty() || !error.equals("")) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Unknown command! please try again");
        }
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
        tasks.add(new Task(description));
    }

    private static void addTodo(String line) throws TaskManagerException {
        String description = line.substring("todo".length()).trim();
        if (description.isEmpty()) {
            throw new TaskManagerException("Empty description for TODO");
        } else {
            tasks.add(new Todo(description));
            printTaskCount();
        }
//        System.out.println("Tasks in the list: " + taskCount);
    }

    private static void addDeadline(String line) throws TaskManagerException {
        int idxOfBy = line.indexOf("/by");
        if (idxOfBy < 0) {
            throw new TaskManagerException("Empty description and deadline for DEADLINE");
        }

        String description = line.substring(0, idxOfBy).substring("deadline".length()).trim();
        if (description.isEmpty() || description.equals("")) {
            throw new TaskManagerException("Empty description for DEADLINE");
        }
        String deadline = line.substring(idxOfBy, line.length()).substring("/by".length()).trim();
        if (deadline.isEmpty() || deadline.equals("")) {
            throw new TaskManagerException("Empty deadline for DEADLINE");
        }

        tasks.add(new Deadline(description, deadline));
        printTaskCount();
//        System.out.println("Tasks in the list: " + taskCount);
    }

    private static void markAsDone(String line) {
        int index = Integer.parseInt(line.substring("done".length()).trim());
        tasks.get(index - 1).setDone(true);
        printTaskCount();
//        System.out.println("Tasks in the list: " + tasks.size());
    }
}