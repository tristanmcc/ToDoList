import java.util.*;

/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * <p>
 * A 'Task' represents the actual task that a user needs to
 * remember to do thus an instance of 'Task' is added to the ToDo list.
 * A 'Task' stores its name, date of expected completion, its status
 * and the project this task belongs to;
 *
 * @Tristan_McCarthy
 */


public class Task {

    private String title;
    private String status;
    private Date date;
    private String project;

    public Task(String title,String project,Date date, String status) {
        this.title = title;
        this.project = project;
        this.date = date;
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
    public Date getTaskDate() {
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
    public void setTaskDate(Date setTaskDate) {
        date = setTaskDate;
    }
}