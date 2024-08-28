package manager;

import entities.Task;

import java.util.ArrayList;

public class TaskManager {

    //ArrayList
    private static ArrayList<Task> taskList = new ArrayList<>();

    //Get
    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    //METHODS

    //Add to list
    public static void addToList(Task t) {
        taskList.add(t);
    }

    //Remove to list
    public static Boolean removeToList(int id) {
        for (Task t: taskList) {
            if (t.getId() == id){
                taskList.remove(t);
                return true;
            }
        }
        return false;
    }

    //Update status by id
    public static String updateById(int id, String taskStatus) {
        boolean found = false;
        for (Task t: taskList) {
            if (t.getId() == id){
                t.setTaskStatus(taskStatus);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID not registered in the system");
        }
        return taskStatus;
    }

    //View all tasks
    public static String ViewAllTasks() {
        String saida = "";
        int i = 1;
        for (Task t: taskList) {
            saida += "========== Task N° " + i++ + " ==========";
            saida += t.print() + "\n";

        }
        return saida;
    }

    //View by status
    public static String ViewByStatus(String taskStatus) {
        String saida = "";
        int i = 1;
        for (Task t: taskList) {
            if (t.getTaskStatus().equalsIgnoreCase(taskStatus)) {
                saida += "========== Task N° " + i++ + " ==========";
                saida += t.print() + "\n";
            }
        }
        return saida;
    }

}
