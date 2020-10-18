import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
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
    private ArrayList<Task> arrayListToDoList; //storage of tasks
    private int count; //how many tasks have been added to todo
    private int statusOpen = 0;
    private int statusClosed = 0;
    
    /**
     *  This is the constructor which builds a ToDoList.
     */
    public ToDoList() {
        arrayListToDoList = new ArrayList<Task>();
        count = 0;
    }
    
    /**
     * Adds the task to this ToDoList.
     * @param title, project, date, status
     */
    public void addTask(String title, String project, Date date, String status) throws ParseException {
          arrayListToDoList.add(new Task(title,project, date, status ));
            count++;
    }

    /**
     * @return number of tasks are stored in toDoList.
     */
    public int getSize() 
    {
        return count;
    }

    /**
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
            Task deleted = arrayListToDoList.remove(index);
            this.count--;  //removed an element
            return deleted;
        }
    }

    public void displayToDoList()
    {
        int taskNo = 0;
        int displayChoice = 0;
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
            System.out.println(String.format(format1, count, task.getTitle(), task.getProject(), task.getStatus(), formatterAdd.format(task.getTaskDate())));
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
        int numInput = sc.nextInt();
        return numInput;
    }



    public static void main(String[] args) {


        }
    }

