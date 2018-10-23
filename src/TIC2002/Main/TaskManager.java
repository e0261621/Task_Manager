package TIC2002.Main;

import TIC2002.Exception.TaskManagerException;
import TIC2002.UI.Ui;
import TIC2002.Storage.Storage;
import TIC2002.TaskList.TaskList;
import TIC2002.Parser.Parser;

import java.io.FileNotFoundException;


@SuppressWarnings("Duplicates")
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
                    case "exit":
                    case "": // exit if user input is empty
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTasks(Parser.createTodo(fullCommand));
                        break;
                    case "deadline":
                        tasks.addTasks(Parser.createDeadLine(fullCommand));
                        break;
                    case "print":
                        tasks.printTasks();
                        break;
                    case "done":
                        tasks.markAsDone(fullCommand);
                        break;
                    case "save":
                        storage.save(tasks.getTasks());
                        break;
                    case "remove":
                        tasks.removeTask(fullCommand);
                        break;
                    default:
                        ui.printError("Unknown command! please try again");
                        break;
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        exit();
    }

    // ...

    public static void main(String[] args) {
        new TaskManager("data/tasks.txt").run();
    }

    public static void exit() {
        System.out.println(0);
    }
}
