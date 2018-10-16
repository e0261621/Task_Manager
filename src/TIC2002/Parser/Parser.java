package TIC2002.Parser;

import TIC2002.Task.Todo;

/**
 * public static getCommandWord(String fullCommand): Returns a the command word i.e., the first word of the given fullCommand
 * e.g., Parser.getCommandWord("todo read book") "todo"
 * public static createTodo(String fullCommand): Returns a Todo object to match the fullCommand. Assumption: the fullCommand is for creating a Todo object.
 * e.g., Parser.createTodo("todo read book") a Todo object containing the description "read book"
 */
public class Parser {

    public static String getCommandWord(String fullCommand) throws ParserException {
        String command = fullCommand.trim().split("")[0];
        System.out.println(command);
        if (command.trim().equals("")) {
            throw new ParserException("Unknown command! please try again");
        }
        return command;
    }

    public static Todo createTodo(String description) {
        Todo t = null;
        return t;
    }


}
