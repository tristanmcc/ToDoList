package ToDoLy;

import java.io.Serializable;
import java.text.ParseException;
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
    private ArrayList<Task> arrayListToDoList = new ArrayList<Task>(); //storage of tasks
    private int count = 0; //how many tasks have been added to TODO
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
     * Adds the task to this ToDoLy.ToDoList.
     *
     * @param title, project, date, status
     */
    public void addTask(String title, String project, String date, String status) {
        arrayListToDoList.add(new Task(title, project, date, status));
        count++;
    }

    /**
     * Removes task at the given index-1 in this Arraylist.
     * Returns the removed task, or it will return null if the given index did not correspond
     * to a task in the AL.
     */
    public void remove(int index) {
        arrayListToDoList.remove(index);
        count--;

    }

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
        System.out.printf((format1) + "%n", "ToDoLy.Task No", "ToDoLy.Task Name", "ProjectName", "Status", " Date");


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

    public String getTasks() {
        String list = "";
        for (int i = 0; i < this.arrayListToDoList.size(); i++) {
            Task currentTask = this.arrayListToDoList.get(i);
            list += (i + 1) + ": " + currentTask.toString() + "\n";
        }

        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : arrayListToDoList) {
            sb.append(task.toString());

        }
        return sb.toString();
    }


    public void update() {
        StreamManager streamManager = new StreamManager();
        streamManager.writeAsObject(arrayListToDoList);

    }

    public static void main(String[] args) {


    }
}

