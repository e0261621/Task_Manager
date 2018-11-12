package tic2002.Constants;

public class TaskManagerContants {
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String SAVE = "save";
    public static final String PRINT = "print";
    public static final String DONE = "done";
    public static final String UNDONE = "undone";
    public static final String REMOVE = "remove";
    public static final String BACKUP = "backup";

    public static final String TODO_HELP_STATEMENT = "Type \"todo\" \"description of task\" to create a new Todo Task." +
            " E.g. todo Return textbook";
    public static final String DEADLINE_HELP_STATEMENT = "Type \"deadline\" \"description of task\" /by \"description of deadline\" to create a new Deadline Task. E.g. deadline Hand in Homework /by Monday 10am ";
    public static final String SAVE_HELP_STATEMENT = "Type \"save\" and press enter to save the current list of tasks.";
    public static final String PRINT_HELP_STATEMENT = "Type \"print\" and press enter to print out the current list of tasks.";
    public static final String DONE_HELP_STATEMENT = "Type \"done\" and the number of the task from the list. " +
            "Use \"print\" to display the tasks and their corresponding number first. E.g. done 1\n" +
            "\t\t\t   [This will set that task's status to done/ complete]";
    public static final String UNDONE_HELP_STATEMENT = "Type \"undone\" and the number of the task from the list." +
            "Use \"print\" to display the tasks and their corresponding number first. E.g. undone 1\n" +
            "\t\t\t   [This will set that task's status to not done/ incomplete]\n" +
            "\t\t\t   Can be used when a task is mistakenly set as done or for a repeatable task";
    public static final String REMOVE_HELP_STATEMENT = "Type \"remove\" and the number of the task to be removed from the list.\n" +
            "\t\t\t   Use \"print\" to display the tasks and their corresponding number first. E.g. remove 1\n" +
            "\t\t\t   [This will remove that task from the list.]";
    public static final String BACKUP_HELP_STATEMENT = "Type \"backup\" and press 'Enter' in order to create backup file of the current list of tasks.";
}
