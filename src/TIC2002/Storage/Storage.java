package TIC2002.Storage;

//Storage storage = new Storage("data/tasks.txt");
//        List<Task> tasks = storage.load();
//        ...
//        storage.save(tasks);

import TIC2002.TaskList.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {


    public static TaskList load(String filePath) throws FileNotFoundException{
        TaskList tasks = null;
        List<String> lines = new ArrayList<String>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            lines.add(s.nextLine());
        }
        return tasks;
    }

    public static void save() {

    }
}