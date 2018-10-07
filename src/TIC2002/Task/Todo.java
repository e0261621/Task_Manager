package TIC2002.Task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("description: %s\n is done ? %s", this.getDescription(), this.isIsDone() ? "Yes" : "No");
    }

    @Override
    public String save() {
        return "T" + " | " + (this.isIsDone() ? 1 : 0) + " | " + super.save() + System.lineSeparator();
    }
}
