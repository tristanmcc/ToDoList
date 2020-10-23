package ToDoLy;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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


    /**
     * This is the constructor which builds a ToDoLy.Task.
     */
    public Task(String title, String project, String date, String status) {

        if (date.trim().isEmpty()) {
            throw new IllegalStateException("You have to enter a date!");
        }
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("The format of the date is invalid, please try again.\n");
        } if (this.date.compareTo(LocalDate.now()) < 0) {
                throw new DateTimeException("The time you entered has passed, please try again.\n");
            }

        this.title = title;
        this.project = project;
        this.status = status;
    }

    /**
     * @return The task title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return The task Project
     */
    public String getProject() {
        return project;
    }

    /**
     * @return The task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return The task Date
     */
    public LocalDate getTaskDate() {
        return date;
    }

    /**
     * This method changes the existing title of a
     * task to the new input title
     *
     * @param setTaskTitle sets the task title to new title
     */
    public void setTaskTitle(String setTaskTitle) {
        title = setTaskTitle;
    }

    /**
     * This method changes the existing status of a
     * task to the new input status
     *
     * @param newStatus sets the task status to done
     */
    public void setTaskStatusDone(String newStatus) {
        status = newStatus;
    }

    /**
     * This method changes the existing project of a
     * task to the new input project
     *
     * @param newProjectGrouping sets the task project to new project
     */
    public void setProjectName(String newProjectGrouping) {
        project = newProjectGrouping;
    }

    /**
     * This method changes the existing date of a
     * task to the new input date
     *
     * @param setTaskDate sets the task date to new date
     */
    public void setTaskDate(String setTaskDate) {
        if (setTaskDate.trim().isEmpty()) {
            throw new IllegalStateException("You have to enter a date!");
        }
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = LocalDate.parse(setTaskDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("The format of the date is invalid, please try again.\n");
        }
        // check if date has passed the current time
        if (date.compareTo(LocalDate.now()) < 0) {
            throw new DateTimeException("The time you entered has passed, please try again.\n");
        }

    }
}
