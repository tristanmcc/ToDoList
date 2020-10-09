import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * 
 * A 'ToDoList' represents the To Do list that a user populates with Tasks 
 * New Tasks can be added at the end and removed.
 * ToDoList tasks are indexed starting at 1 (not 0).
 * 
 * @Tristan McCarthy
 */

public class ToDoList {

    //instance variables
    private ArrayList<Task> toDoList; //storage of tasks
    private int count; //how many tasks have been added to todo
    private int taskNum;
    
    /*
     *  This ia the constructor which builds a ToDoList.
     */
    public ToDoList() {
        toDoList = new ArrayList<>();
        count = 0;
    }
    
    /*
     * Will refactor to use this as the application launch method 
     */
    public void start()
    {
      printWelcome();
    }
    
    /*
     * Will refactor to use this in coming days
     */
    public void printWelcome()
    {
     System.out.println();
        System.out.println("This is ToDoLy");
        System.out.println("your favourite To-do list application");
        System.out.println("You have x tasks to do and y tasks are done");
        System.out.println("pick an option: ");
        System.out.println("1) Add a Task");
        System.out.println("2) Edit a Task");
        System.out.println("3) Show Task List");
        System.out.println("4) Remove a Task");
        System.out.println("5) Save and Quit");
     System.out.println();


    }
    
    /*
     * Adds the task to this ToDoList.  
     */
    public void add(Task task) 
    {
            this.toDoList.add(task);
            count++;
    }

    /*
     * @return number of tasks are stored in toDoList.
     */
    public int getSize() 
    {
        return count;
    }

    /*
     * Removes task at the given index-1 in this Arraylist.
     * Returns the removed task, or it will return null if the given index did not correspond
     * to a task in the AL.
     */
    public Task remove(int index)
    {
        if (index < 1 || index > this.count)
        {
            return null;  //no such element
        }
        else {
            index--; //convert to 0-based indexing used by arraylist
            Task deleted = toDoList.remove(index);
            this.count--;  //removed an element
            return deleted;
        }
    }

    /*
     * Currently serving as menu based interface
     */
    public static void main(String[] args) {

         java.util.Scanner input = new java.util.Scanner(System.in);
        ArrayList<Task> simpleToDoList = new ArrayList<Task>();

        int choice = 1;
        while (choice != 0) {
            //print list
            System.out.println();
            System.out.println(simpleToDoList);  //calls toString()
            
            
            //print start menu
          System.out.println();
            System.out.println("This is ToDoLy");
            System.out.println("your favourite To-do list application");
            System.out.println("You have x tasks to do and y tasks are done");
            System.out.println("pick an option: ");
            System.out.println("1) Add a Task");
            System.out.println("2) Edit a Task");
            System.out.println("3) Show Task List");
            System.out.println("4) Remove a Task");
            System.out.println("5) Save and Quit");
          System.out.println();
      
            //Scan user's input
            try {
                choice = input.nextInt();
                input.nextLine();  //clear input stream
                switch (choice) {
                    case 1:  //ADD a Task to ArrayList
                       Scanner scanning = new Scanner(System.in);
                       System.out.println("Enter title: ");
                       String title = scanning.nextLine();
                       System.out.println("Enter project: ");
                       String project = scanning.nextLine();
                       System.out.println("Enter due date (format: yyyy-mm-dd): ");
                       String date = scanning.nextLine();
                       System.out.println("Enter task Status: ");
                       String done = scanning.nextLine();
                       Task task1 = new Task(title,date,project,done);
                       simpleToDoList.add(task1);

                    case 2:  //remove last in ArrayList
                        Task removed = simpleToDoList.remove(simpleToDoList.indexOf(choice));
                        if (removed != null) {
                            System.out.println("Removed: " + removed);
                        }else {
                            System.out.println("Nothing there to remove, sorry mate! ");
                        }
                        break;

                    case 3:  //remove
                        System.out.print("Enter the index of the item to remove: ");
                        int index = input.nextInt();
                        removed = simpleToDoList.remove(index);
                        if (removed != null) {
                            System.out.println("Removed: " + removed);
                        }else {
                            System.out.println("There is no item to be removed at index " +
                                    index + ".");
                        }
                        break;

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Sorry, but " + choice + " is not one of " +
                                "the menu choices. Please try again.");
                        break;
                }
            }catch (java.util.InputMismatchException ime) {
                System.out.println("Sorry, but you must enter a number.");
                input.nextLine();  //make sure they enter a number not a string
            }
        }
    }

}