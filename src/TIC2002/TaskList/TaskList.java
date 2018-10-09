package TIC2002.TaskList;

//private TaskList tasks = new TaskList(storage.load());
//        ...
//        t = Parser.createTodo(fullCommand);
//        tasks.addTask(t);
//        ...
//        Sting taskListDescription = tasks.getDescription();
//        ui.showToUser(taskListDescription);

import TIC2002.Task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private static List<Task> tasks = new ArrayList<>();

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        String tasksDescription = "";
        for (Task t : tasks) {
            if()
        }
    }
}
