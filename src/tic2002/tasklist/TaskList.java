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
        for (int i = 0; i < tasks.size(); i++) {
            tasksDescription += tasks.get(i).getDescription().trim();
            if (i == tasks.size() - 1) {

            } else {
                tasksDescription += "|";
            }
        }
        return tasksDescription;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void addTask(Task task) {
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

    public static String getTaskCount() {
        return "Tasks in the list: " + tasks.size();
    }

    public static int getNumberOfTasks() {
        return tasks.size();
    }

    public void markAsDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
        tasks.get(index - 1).setDone(true);
//        System.out.println("Tasks in the list: " + tasks.size());
    }

    public void removeTask(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("remove".length()).trim());
        tasks.remove(index - 1);
    }

    public String modifyDescription(String newDescription) {
        String oldDesc = "";

        return oldDesc;
    }

}
