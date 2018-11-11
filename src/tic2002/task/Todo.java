package tic2002.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " is done ? %s", this.isIsDone() ? "Yes" : "No");
    }

    @Override
    public String save() {
        return "T" + " | " + (this.isIsDone() ? 1 : 0) + " | " + super.save() + System.lineSeparator();
    }
}
