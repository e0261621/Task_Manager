package TIC2002.Storage;

//Storage storage = new Storage("data/tasks.txt");
//        List<Task> tasks = storage.load();
//        ...
//        storage.save(tasks);

import TIC2002.Task.Deadline;
import TIC2002.Task.Todo;
import TIC2002.Task.Task;
import TIC2002.TaskList.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Storage {

    private String filePath = "";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> load() throws FileNotFoundException {
        List<Task> loadedTasks = new ArrayList<>();

        List<String> lines = getLines(this.filePath);
        for (String line : lines) {
            if (line.trim().isEmpty()) { //ignore empty lines
                continue;
            }
            loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
        }
        return loadedTasks;
    }

    private Task createTask(String line) {
        Task task = null;
        String[] s = line.split("\\|");
        if (s[0].trim().equals("T")) {
            task = new Todo(s[2].trim());
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.setDone(true);
            }
        } else if (s[0].trim().equals("D")) {
            task = new Deadline(s[2], s[3]);
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.setDone(true);
            }
        } else {
            System.out.println("Error");
        }
        return task;
    }

    private List<String> getLines(String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            lines.add(s.nextLine());
        }
        return lines;
    }


    private void save(List<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(this.filePath);

        File f = new File(this.filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        for (Task task : tasks) {
            if (s.hasNext()) {
                fw.write("\r\n");
            }
            fw.write(task.save());
        }
        fw.close();
    }

    private static void printTasks(TaskList tasks) {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : tasks.getTasks()) {
            System.out.println("[" + (i) + "] " + t);
            i++;
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage("data/tasks.txt");
//        List<Task> tasks = new ArrayList<>();
        TaskList tasks = null;
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printTasks(tasks);
//        tasks.add(new Todo("Add this"));
//        tasks.add(new Deadline("Add that", "Friday Shit"));
//        try {
//            storage.save(tasks);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}