package tic2002.main;

import tic2002.exception.TaskManagerException;
import tic2002.ui.Ui;
import tic2002.storage.Storage;
import tic2002.tasklist.TaskList;
import tic2002.parser.Parser;

import java.io.FileNotFoundException;


@SuppressWarnings("Duplicates")

/**
 * The TaskManager program implements an application that
 * stores tasks and displays them for the user to view,modify and delete.
 *
 * @author Adi Kesava Das / A0177810A
 * @version 1.0
 * @since 2018-10-27
 */
public class TaskManager {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public TaskManager(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            ui.showToUser("Problem reading file. Starting with an empty task list");
            tasks = new TaskList(null);
        }
    }

    public void run() {
        ui.printWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readUserCommand();
                String commandWord = Parser.getCommandWord(fullCommand);
                switch (commandWord) {
                    case "":
                        ui.printError("No command input! Please enter a command or type \"help\" to view a list of commands.");
                        break;
                    case "exit":
                        isExit = true;
                        if (tasks.getNumberOfTasks() > 0) {
                            storage.save(tasks.getTasks());
                            ui.showToUserNoNewLine("Saving");
                            for (int i = 0; i < 10; i++) {
                                ui.showToUserNoNewLine(".");
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            ui.showToUserNoNewLine("complete~!");
                        } else {
                            ui.showToUser("No tasks found in the list!");
                        }
                        ui.printGoodBye();
                        break;
                    case "help":
                        ui.helpMessage();
                        break;
                    case "todo":
                        tasks.addTask(Parser.createTodo(fullCommand));
                        ui.showToUser(tasks.getTaskCount());
                        break;
                    case "deadline":
                        tasks.addTask(Parser.createDeadLine(fullCommand));
                        ui.showToUser(tasks.getTaskCount());
                        break;
                    case "print":
                        tasks.printTasks();
                        break;
                    case "done":
                        tasks.markAsDone(fullCommand);
                        ui.showToUser(tasks.getTaskCount());
                        break;
                    case "undone":
                        tasks.markAsNotDone(fullCommand);
                        ui.showToUser(tasks.getTaskCount());
                    case "save":
                        storage.save(tasks.getTasks());
                        break;
                    case "remove":
                        tasks.removeTask(fullCommand);
                        ui.showToUser(tasks.getTaskCount());
                        break;
                    case "backup":
                        storage.createBackup(tasks.getTasks());
                        break;
                    default:
                        ui.printError("Unknown command! please try again. Please type \"help\" to view a list of commands.");
                        break;
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        exit();
    }

    public static void main(String[] args) {
        new TaskManager("data/tasks.txt").run();

    }

    public static void exit() {
//        System.out.println(0);
    }
}
