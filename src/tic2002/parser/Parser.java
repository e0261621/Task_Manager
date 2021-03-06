package tic2002.parser;

import tic2002.task.Deadline;
import tic2002.exception.TaskManagerException;
import tic2002.task.Todo;

/**
 * public static getCommandWord(String fullCommand): Returns a the command word i.e., the first word of the given fullCommand
 * e.g., Parser.getCommandWord("todo read book") "todo"
 * public static createTodo(String fullCommand): Returns a Todo object to match the fullCommand. Assumption: the fullCommand is for creating a Todo object.
 * e.g., Parser.createTodo("todo read book") a Todo object containing the description "read book"
 */
public class Parser {

    public static String getCommandWord(String fullCommand) {
        String command = fullCommand.trim().split(" ")[0];
        return command;
    }

    public static Todo createTodo(String fullCommand) throws TaskManagerException {
        String description = fullCommand.substring("todo".length()).trim();
        assert (("todo " + description).equals(fullCommand)) : "Something went wrong during the substring for todo description";
        if (description.isEmpty()) {
            throw new TaskManagerException("Empty description for TODO");
        } else {
            return new Todo(description);
        }
    }

    public static Deadline createDeadLine(String fullCommand) throws TaskManagerException {
        int idxOfBy = fullCommand.indexOf("/by");
        if (idxOfBy < 0) {
            throw new TaskManagerException("Deadline does not contain /by");
        }

        String description = fullCommand.substring(0, idxOfBy).substring("deadline".length()).trim();
        assert (fullCommand.contains(description)) : "Something went wrong during the substring for deadline description";
        if (description.isEmpty() || description.equals("")) {
            throw new TaskManagerException("Empty description for DEADLINE");
        }
        String deadline = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/by".length()).trim();
        if (deadline.isEmpty() || deadline.equals("")) {
            throw new TaskManagerException("Empty deadline for DEADLINE");
        }
        return new Deadline(description, deadline);
    }
}
