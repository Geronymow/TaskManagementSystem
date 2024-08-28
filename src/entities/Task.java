package entities;

public class Task {

    private int id;
    private String taskName, taskDescription, taskStatus;

    //Builders
    public Task() {
    }
    public Task(int id, String taskName, String taskDescription, String taskStatus) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    //Get & set methods
    public int getId() {
        return id;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    //Method to print
    public String print() {
        return "\nId: " + id + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Status: " + taskStatus;
    }

}
