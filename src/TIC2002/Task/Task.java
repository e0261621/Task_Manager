package TIC2002.Task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isIsDone() {
        return this.isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String toString() {
        return String.format("description: %s\n", this.getDescription());
    }

    public String save() {
        return this.getDescription();
    }

}
