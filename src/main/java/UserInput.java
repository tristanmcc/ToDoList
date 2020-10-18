import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 *
 * The UserInput class handles the users inputting of information regarding
 * Tasks to be added to the actual todo List
 * the To Do list that a user populates with Tasks
 * ToDoList tasks are indexed starting at 1 (not 0).
 *
 * @Tristan_McCarthy
 */

public class UserInput {

    private int choice;
    ToDoList simpleTodoList;
    private int statusOpen = 0;
    private int statusClosed = 0;
    private String userStringDate;
    private ArrayList<Task> usersToDoList = new ArrayList<>();
    DateFormat formatterAdd = new SimpleDateFormat("yyyy-MM-dd");//date formatter for Add method
    DateFormat formatterEdit = new SimpleDateFormat("yyyy-MM-dd");//date formatter for Edit method


    public UserInput() {

        int choice = 0;
        simpleTodoList = new ToDoList();


    }

    public void displayMenu() throws ParseException {
        int choice = 1;
        ToDoList simpleToDoList = new ToDoList();
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (choice != 0) {

            //print start menu
            System.out.println();
            System.out.println("This is ToDoLy");
            System.out.println("your favourite To-do list application");
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
            choice = scanInput();
            input.nextLine();  //clear input stream


            switch (choice) {
                case 1:  //ADD a Task to ArrayList
                    add();
                    statusOpen++;
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

                case 0:
                    System.out.println("Goodbye!");
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
     * @return num of action chosen by user
     */
    public int scanInput() {
        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();
        return numInput;
    }

    /**
     * This method will be used instead of repeated scanner.nextLine(); so it
     * reads the input FileReader
     */
    public String scanString() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        return line;
    }
    /**
     * This method adds a Task to the ToDoList variable by calling the addTask method
     * in the ToDoList class and adding the task information input by the user
     */
    public void add() throws ParseException {

        DateFormat formatterAdd = new SimpleDateFormat("yyyy-MM-dd");//date formatter
        Scanner scanning = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scanning.nextLine();
        System.out.println("Enter project: ");
        String project = scanning.nextLine();
        System.out.println("Enter due date (format: yyyy-mm-dd): ");
        userStringDate = scanning.nextLine();
        System.out.println("Enter task Status: ");
        String status = scanning.nextLine();
        Date date = formatterAdd.parse(userStringDate);
        Task task1 = new Task(title,project, date, status);
        simpleTodoList.addTask(title,project,date,status);

    }



    /**
     * This method allows users to edit tasks that have already been added to the working ToDo List
     * the method calls the displayToDoList() method so that the user can the task number for the task
     * they want to edit.
     * @throws ParseException
     */
    public void editTask() throws ParseException {
        int taskNum = 0; //functions as index of tasks in simpletodolist
        int editFieldChoice = 0; //functions as index of options for fields to edit
        Task taskForEdit = this.simpleTodoList.getTask(taskNum); //task in 'todolist' accessed via get method based on task number chosen by user
        DateFormat formatterEdit = new SimpleDateFormat("yyyy-MM-dd"); //date formatter


        simpleTodoList.displayToDoList();
        Scanner scanning = new Scanner(System.in);
        System.out.println("Enter the Task No you want  to Edit");
        taskNum = scanInput();
        taskNum = taskNum - 1;

        System.out.println("Enter the field you want to Edit");
        System.out.println("1.Task Name  ");
        System.out.println("2.Project Name ");
        System.out.println("3.Status ");
        System.out.println("4.Date");
        editFieldChoice = scanInput();

        switch (editFieldChoice){
            case 1: //Change the task title

            System.out.println("Set task title to : " );
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
            userStringDate = scanning.nextLine();
                Date newDate = formatterEdit.parse(userStringDate);
                taskForEdit.setTaskDate(newDate);
            break;
        }
    }


    public void removeAnyTask() {
        {
            int taskNum = 0;
            int removeChoice = 0;
            simpleTodoList.displayToDoList();
            System.out.println("Enter the Task no. you want  to delete ");
            taskNum = scanInput();
            taskNum = taskNum - 1;
            Task taskForRemoving = simpleTodoList.getTask(taskNum);
            simpleTodoList.remove(taskNum);


        }
    }

    public static void main(String[] args) {

    }
}




