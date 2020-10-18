import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is part of the ToDo-ly to-do list application.
 * ToDol-y is a very simple to-do list application.
 * 
 * A 'ToDoList' represents the To Do list that a user populates with Tasks 
 * New Tasks can be added at the end and removed.
 * ToDoList tasks are indexed starting at 1 (not 0).
 * 
 * @Tristan_McCarthy
 */

public class ToDoList {

    //instance variables
    private final ArrayList<Task> arrayListToDoList; //storage of tasks
    //how many tasks have been added to todo
    private int statusOpen = 0;
    private int statusClosed = 0;
    
    /**
     *  This is the constructor which builds a ToDoList.
     */
    public ToDoList() {
        arrayListToDoList = new ArrayList<>();
    }
    
    /**
     * Adds the task to this ToDoList.
     * @param title, project, date, status
     */
    public void addTask(String title, String project, Date date, String status) {
          arrayListToDoList.add(new Task(title,project, date, status ));
    }

    public void displayToDoList()
    {
        int displayChoice;
        int count = 0;
        DateFormat formatterAdd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Please Enter your choice - for sorting");
        System.out.println("1.Sort based on Date");
        System.out.println("2.Sort based on Project");
        displayChoice = scanInput();

        switch(displayChoice){
            case 1:
                arrayListToDoList.sort(Comparator.comparing(Task::getTaskDate));
                break;
            case 2:
                arrayListToDoList.sort(Comparator.comparing(Task::getProject));
                break;
        }
        String format1 = "%-9s%-40s %-43s %-12s %-15s";
        System.out.printf((format1) + "%n", "Task No", "Task Name", "ProjectName", "Status", " Date");



        for (Task task : arrayListToDoList) {
            count++;
            System.out.printf((format1) + "%n", count, task.getTitle(), task.getProject(), task.getStatus(), formatterAdd.format(task.getTaskDate()));
            String changeCase = task.getStatus().toUpperCase();


            if (changeCase.equals("OPEN")) {
                statusOpen = statusOpen + 1;
            } else if (changeCase.equals("DONE")) {
                statusClosed = statusClosed + 1;
            }
        }
        System.out.println("Number of Tasks open : " + statusOpen + " Number of Tasks Closed " + statusClosed);
        statusOpen = 0;
        statusClosed = 0;
    }
    public int scanInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Task getTask(int index) {
        return this.arrayListToDoList.get(index);
    }



    public static void main(String[] args) {


        }
    }

