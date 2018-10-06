package tic2002.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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
