package tic2002.tasklist;

import tic2002.task.Task;

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
            tasksDescription += t.getDescription() + "|";
        }
        return tasksDescription;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void addTasks(Task task) {
        this.tasks.add(task);
    }

    public void printTasks() {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : this.tasks) {
            System.out.println("[" + (i) + "] " + t);
            i++;
        }
    }

    public void printTaskCount() {
        System.out.println("Tasks in the list: " + tasks.size());
    }

    public void markAsDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
        tasks.get(index - 1).setDone(true);
        this.printTaskCount();
//        System.out.println("Tasks in the list: " + tasks.size());
    }

    public void removeTask(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("remove".length()).trim());
        tasks.remove(index - 1);
        this.printTaskCount();
    }

}
