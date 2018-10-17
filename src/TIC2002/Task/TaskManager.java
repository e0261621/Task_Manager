package TIC2002.Task;

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
//                        printTasks();
//                        break;
//                    case "done":
//                        markAsDone(line);
//                        break;
//                    case "save":
//                        try {
//                            FileWriter fw = new FileWriter(filePath);
//
//                            for (Task t : tasks) {
//                                fw.write(t.save());
//                            }
//                            fw.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    break;
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
