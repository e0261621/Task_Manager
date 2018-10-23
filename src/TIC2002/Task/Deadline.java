package TIC2002.Task;

public class Deadline extends Todo {
    private String deadLine;

    public Deadline(String description, String deadLine) {
        super(description);
        this.deadLine = deadLine;
    }

    public String getDeadLine() {
        return this.deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return String.format("description: %s\n is done ? %s\n  do by: %s", this.getDescription(),
                this.isIsDone() ? "Yes" : "No", this.getDeadLine());
    }

    @Override
    public String save() {
        return "D" + " | " + (this.isIsDone() ? 1 : 0) + " | " + super.getDescription()
                + " | " + this.getDeadLine() + System.lineSeparator();
    }
}
