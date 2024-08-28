package application;

import entities.Task;
import manager.TaskManager;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        //Attributes
        int id;
        String taskName, taskDescription, taskStatus;
        int menu;

        //Task mention
        Task task;

        System.out.println("========== WELCOME TO TASK MANAGEMENT SYSTEM ==========");

        do {
            viewMenu();
            System.out.print("Enter an option: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("========== Add Task ==========");
                    id = rd.nextInt(9999) + 1;
                    System.out.println("=========> GENERATED ID <=========");
                    System.out.print("Give the task a name: ");
                    taskName = sc.nextLine();
                    System.out.print("Description: ");
                    taskDescription = sc.nextLine();
                    System.out.print("Current status: ");
                    taskStatus = sc.nextLine();

                    //Create object in class
                    task = new Task(id,taskName,taskDescription,taskStatus);

                    //Save to ArrayList
                    TaskManager.addToList(task);
                    break;
                case 2:
                    System.out.println("========== Remove Task ==========");
                    System.out.print("Enter the corresponding task id to be removed: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (! TaskManager.getTaskList().isEmpty()) {  //If the list is not empty
                        if (TaskManager.removeToList(id)) {
                            System.out.println("Task deleted successfully");
                        }
                        else {
                            System.out.println("Task not registered in the system");

                        }
                    }
                    else {
                        System.out.println(" ====> The task list is empty");
                    }
                    System.out.println("====================");
                    break;
                case 3:
                    System.out.println("========== Update Task Status ==========");
                    System.out.print("Enter the ID for the update to happen: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New task status: ");
                    taskStatus = sc.nextLine();
                    if (! TaskManager.getTaskList().isEmpty()) {  //If the list is not empty
                        TaskManager.updateById(id,taskStatus);
                        System.out.println("========== UPDATED!! ==========");
                    }
                    else {
                        System.out.println(" ====> The task list is empty");
                    }
                    System.out.println("====================");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("========== View All Tasks ==========");
                    System.out.println(TaskManager.ViewAllTasks());
                    System.out.println("====================");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("========== View All Tasks by Status ==========");
                    System.out.print("Which status do you want to filter?: ");
                    taskStatus = sc.nextLine();
                    System.out.println(TaskManager.ViewByStatus(taskStatus));
                    System.out.println("====================");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Leaving...");
                    break;
            }
        } while (menu != 6);

    } //End

    //View Menu
    public static void viewMenu() {
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Update Task Status");
        System.out.println("4. View All Tasks");
        System.out.println("5. View Tasks by Status");
        System.out.println("6. Leave");
    }
}
