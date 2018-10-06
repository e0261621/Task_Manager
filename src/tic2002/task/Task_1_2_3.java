package tic2002.task;

public class Task_1_2_3 {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task_1_2_3(String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("description: %s\n", this.getDescription());
    }

}
