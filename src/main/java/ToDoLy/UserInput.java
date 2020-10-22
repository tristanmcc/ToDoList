package ToDoLy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * <p>
 * The ToDoLy.UserInput class handles the users inputting of information regarding
 * Tasks to be added to the actual todo List
 * the To Do list that a user populates with Tasks
 * ToDoLy.ToDoList tasks are indexed starting at 1 (not 0).
 *
 * @Tristan_McCarthy
 */

public class UserInput implements Serializable {

    ToDoList simpleTodoList;
    private Scanner intScan = new Scanner(System.in);
    private Scanner normalScan = new Scanner(System.in);
    private boolean setQuit = false;


    public UserInput() {

        simpleTodoList = new ToDoList();
        new StreamManager();
    }

    /**
     * This method displays the primary menu interface that the user engages with.
     * It offers the user action options including: add, edit, remove, display and save/quit.
     * The method keeps track of how many outstanding tasks there are and how many are yet to be done.
     * The method continue to loop until setQuit is true thus terminating the program.
     */
    public void displayMenu() {
        int choice;
        //ToDoList simpleTodoList = new ToDoList();
        new Scanner(System.in);
        System.out.println("This is ToDoLy");
        System.out.println("your favourite To-do list application");
        while (!setQuit) {


            int statusOpen = simpleTodoList.checkOutstanding();
            int statusClosed = simpleTodoList.checkClosedTasks();
            System.out.println();
            //print menu
            System.out.println("You have " + statusOpen + " tasks to do and " + statusClosed + " tasks are done");
            System.out.println("pick an option: ");
            System.out.println("1) Add a Task");
            System.out.println("2) Edit a Task");
            System.out.println("3) Show Task List");
            System.out.println("4) Remove a Task");
            System.out.println("5) Save and Quit");
            System.out.println();

            System.out.println("Please input your desired action then double click enter: ");


            //Scan user's input
            choice = intScan.nextInt();//scanInput();
            //input.nextLine();  //clear input stream


            switch (choice) {
                case 1:  //ADD a ToDoLy.Task to ArrayList
                    add();
                    break;

                case 2:  //remove last in ArrayList
                    editTask();
                    break;

                case 3:  //Display all tasks in ArrayList
                    simpleTodoList.displayToDoList();
                    break;

                case 4:  //remove any task in ArrayList
                    removeAnyTask();
                    break;

                case 5:
                    saveExitTask();
                    System.out.println("Goodbye!");
                    setQuit = true;
                    break;

                default:
                    System.out.println("Sorry, but " + choice + " is not one of " +
                            "the menu choices. Please try again.");
                    break;

            }
        }
    }

    /**
     * This method scans the users choice of action by determining the number they input
     *
     * @return num of action chosen by user
     */
    public int scanInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * This method adds a ToDoLy.Task to the ToDoLy.ToDoList variable by calling the addTask method
     * in the ToDoLy.ToDoList class and adding the task information input by the user
     */
    public void add() {

        new SimpleDateFormat("yyyy-MM-dd");
        //Scanner scanning = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = normalScan.nextLine();//scanning.nextLine();
        System.out.println("Enter project: ");
        String project = normalScan.nextLine();//scanning.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        String date = normalScan.nextLine();//scanning.nextLine();
        System.out.println("Enter task Status: ");
        String status = normalScan.nextLine();// scanning.nextLine();
        simpleTodoList.addTask(title, project, date, status);

    }


    /**
     * This method allows users to edit tasks that have already been added to the working ToDo List
     * the method calls the displayToDoList() method so that the user can the task number for the task
     * they want to edit.
     */
    public void editTask() {
        int taskNum = 0; //functions as index of tasks in simpletodolist
        int editFieldChoice; //functions as index of options for fields to edit
        Task taskForEdit = this.simpleTodoList.getTask(taskNum); //task in 'todolist' accessed via get method based on task number chosen by user
        new SimpleDateFormat("yyyy-MM-dd");


        simpleTodoList.displayToDoList();
        Scanner scanning = new Scanner(System.in);
        System.out.println("Enter the Task No you want  to Edit");
        scanInput();

        System.out.println("Enter the field you want to Edit");
        System.out.println("1.Task Name  ");
        System.out.println("2.Project Name ");
        System.out.println("3.Status ");
        System.out.println("4.Date");
        editFieldChoice = scanInput();

        switch (editFieldChoice) {
            case 1: //Change the task title

                System.out.println("Set task title to : ");
                String newTitle = scanning.nextLine();
                taskForEdit.setTaskTitle(newTitle);
                break;

            case 2: //Change the tasks 'Project' assignment

                System.out.println("Edit the Project Name : ");
                String newProjectName = scanning.nextLine();
                taskForEdit.setProjectName(newProjectName);
                break;

            case 3: //Change the tasks 'Status' assignment

                System.out.println("Edit the status : ");
                String newStatus = scanning.nextLine();
                taskForEdit.setTaskStatusDone(newStatus);
                break;

            case 4: //Change the tasks 'Date' assignment

                System.out.println("Edit the TaskDate(yyyy-MM-dd) : ");
                String userStringDate = scanning.nextLine();
                taskForEdit.setTaskDate(userStringDate);
                break;
        }
    }

    /**
     * This method allows users to remove tasks that have already been added to the working ToDo List
     * the method calls the displayToDoList() method so that the user can see the task number for the task
     * they want to remove then input that number to access said task.
     */
    public void removeAnyTask() {
        {
            int taskNum;
            simpleTodoList.displayToDoList();
            System.out.println("Enter the Task no. you want  to delete ");
            taskNum = scanInput();
            taskNum = taskNum - 1;
            simpleTodoList.getTask(taskNum);
            simpleTodoList.remove(taskNum);


        }
    }

    /**
     * This method initiates the closing of the program by ending the loop in the displayMenu() method
     * when setQuit is set to true. The method also begins the process of saving the task list by
     * calling update on an instance of ToDoList
     */
    private void saveExitTask() {
        simpleTodoList.update();
        setQuit = true;
    }

    public static void main(String[] args) {

    }
}







