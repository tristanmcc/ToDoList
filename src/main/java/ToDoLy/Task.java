package ToDoLy;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * A 'ToDoLy.Task' represents the actual task that a user needs to
 * remember to do thus an instance of 'ToDoLy.Task' is added to the ToDo list.
 * A 'ToDoLy.Task' stores its name, date of expected completion, its status
 * and the project this task belongs to;
 *
 * @Tristan_McCarthy
 */


public class Task implements Serializable {

    private String title;
    private String status;
    private LocalDate date;
    private String project;

    public Task(String title,String project,String date, String status) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        this.title = title;
        this.project = project;
        this.date = LocalDate.parse(date, formatter);
        this.status = status;
    }

    /*
     * @return The task title
     */
    public String getTitle() {
        return this.title;
    }

    /*
     * @return The task Project
     */
    public String getProject() {
        return project;
    }

    /*
     * @return The task status
     */
    public String getStatus() {
        return status;
    }

    /*
     * @return The task Date
     */
    public LocalDate getTaskDate() {
        return date;
    }

    /*
     * @set the task title
     */
    public void setTaskTitle(String setTaskTitle) {
        title = setTaskTitle;
    }

    /*
     * @set the task status to done
     */
    public void setTaskStatusDone(String newStatus) {
        status = newStatus;
    }

    /*
     * @set the task project grouping
     */
    public void setProjectName(String setProjectGrouping) {
        project = setProjectGrouping;
    }

    /*
     * @set the task date
     */
    public void setTaskDate(String setTaskDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.parse(setTaskDate, formatter);
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", project='" + project + '\'' +
                '}';
    }
}