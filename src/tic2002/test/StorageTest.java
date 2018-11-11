import org.junit.Test;
import tic2002.storage.Storage;
import tic2002.task.Deadline;
import tic2002.task.Task;
import tic2002.task.Todo;
import tic2002.tasklist.TaskList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class StorageTest {
    @Test
    public void saveTasks() throws FileNotFoundException {
        Storage storage = new Storage("data/tasks_tests.txt");
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("Task 1"));
        tasks.add(new Deadline("Task 2", "Tuesday 4PM"));
        storage.save(tasks);

        TaskList tasksList = new TaskList(storage.load());

        String[] tasksFromFile = tasksList.getDescription().split("\\|");
        System.out.println(tasksList.getDescription());
        assertEquals("Task 1", tasksFromFile[0]);
        assertEquals("Task 2", tasksFromFile[1]);
    }


//    Storage storage = new Storage("data/tasks_tests.txt");
//    List<Task> tasks = new ArrayList<>();
////        TaskList tasks = null;
////        try {
////            tasks = new TaskList(storage.load());
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////        printTasks(tasks);
//        tasks.add(newTodo("Task 1"));
//        tasks.add(newDeadline("Task 2","Tuesday 4PM"));
//        storage.save(tasks);

}