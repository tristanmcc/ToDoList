package ToDoLy;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * <p>
 * A 'ToDoLy.ToDoList' represents the To Do list that a user populates with Tasks
 * New Tasks can be added at the end and removed.
 * ToDoLy.ToDoList tasks are indexed starting at 1 (not 0).
 *
 * @Tristan_McCarthy
 */

public class ToDoList implements Serializable {

    //instance variables
    private ArrayList<Task> arrayListToDoList; //storage of tasks
    private int statusOpen = 0;
    private int statusClosed = 0;

    /**
     * This is the constructor which builds a ToDoLy.ToDoList.
     */
    public ToDoList() {
        StreamManager streamManager = new StreamManager();
        arrayListToDoList = streamManager.readAsObject();
    }

    /**
     * Adds the task to this 'working' ArrayList ToDoLy.ToDoList.
     *
     * @param title, project, date, status
     */
    public void addTask(String title, String project, String date, String status) {
        arrayListToDoList.add(new Task(title, project, date, status));
    }

    /**
     * Removes task at the given index-1 in this Arraylist.
     * Returns the removed task, or it will return null if the given index did not correspond
     * to a task in the AL.
     */
    public void remove(int index) {
        arrayListToDoList.remove(index);

    }

    /**
     * This method displays all Tasks in the ToDoList. The method takes in user input
     * and sorts the list by project or date depending on the users preference.
     */
    public void displayToDoList() {
        int count = 0;
        DateTimeFormatter formatterAdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Please Enter your choice - for sorting");
        System.out.println("1.Sort based on Date");
        System.out.println("2.Sort based on Project");
        int displayChoice = scanInput();

        switch (displayChoice) {
            case 1:
                arrayListToDoList.sort(Comparator.comparing(Task::getTaskDate));
                break;
            case 2:
                arrayListToDoList.sort(Comparator.comparing(Task::getProject));
                break;
        }
        String format1 = "%-9s %-40s %-43s %-12s %-15s";
        System.out.printf((format1) + "%n", "Task No", "Task Name", "ProjectName", "Status", " Date");


        for (Task task : arrayListToDoList) {
            count++;
            System.out.printf((format1) + "%n", count, task.getTitle(), task.getProject(), task.getStatus(), formatterAdd.format(task.getTaskDate()));
        }
        statusOpen = checkOutstanding();
        statusClosed = checkClosedTasks();
        System.out.println("Number of Tasks open : " + statusOpen + " Number of Tasks Closed " + statusClosed);
        statusOpen = 0;
        statusClosed = 0;
    }

    /**
     * This method scans a users input when the user
     * is inputting an input that is an Integer
     *
     * @return int
     */
    public int scanInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * This method calls the ArrayList method get() on the working arraylist
     * that serves as the 'ToDo' list.
     * the get method then gets the task at the index that is taken in as a
     * parameter.
     *
     * @param index
     * @return Task
     */
    public Task getTask(int index) {
        return this.arrayListToDoList.get(index);
    }

    public String getTasks() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < this.arrayListToDoList.size(); i++) {
            Task currentTask = this.arrayListToDoList.get(i);
            list.append(i + 1).append(": ").append(currentTask.toString()).append("\n");
        }

        return list.toString();
    }

    /**
     * This method initiates the process of writing the 'working' arraylist
     * that serves as the Todo list
     * to file by calling the writeAsObject method on an instance of StreamManager
     */
    public void update() {
        StreamManager streamManager = new StreamManager();
        streamManager.writeAsObject(arrayListToDoList);
    }

    /**
     * This method checks how many tasks have a status denoting
     * that the task is not done. It does this by iterating through the
     * arraylisttodolist and adding 1 to the statusOpen (count) for each
     * task with a status equal to 'open'
     *
     * @return statusOpen
     */
    public int checkOutstanding() {
        statusOpen = 0;
        for (Task task : arrayListToDoList) {
            String changeCase = task.getStatus().toUpperCase();
            if (changeCase.equals("OPEN"))
                statusOpen = statusOpen + 1;
        }
        return statusOpen;
    }

    /**
     * This method checks how many tasks have a status denoting
     * that the task is done. It does this by iterating through the
     * arrayListToDoList and adding 1 to the statusClosed (count) for each
     * task with a status equal to 'done'
     *
     * @return statusOpen
     */
    public int checkClosedTasks() {
        statusClosed = 0;
        for (Task task : arrayListToDoList) {
            String changeCase = task.getStatus().toUpperCase();
            if (changeCase.equals("DONE"))
                statusClosed = statusClosed + 1;
        }
        return statusClosed;
    }

    public static void main(String[] args) {


    }
}


