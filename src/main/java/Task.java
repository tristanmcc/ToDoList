import java.util.*;
/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * 
 * A 'Task' represents the actual task that a user needs to 
 * remember to do thus an instance of 'Task' is added to the ToDo list.
 * A 'Task' stores its name, date of expected completion, its status
 * and the project this task belongs to;
 * 
 * @Tristan McCarthy
 */


public class Task{
    
    private String title;
    private String status;
    private String date;
    private String project;

    public Task(String title, String date, String project, String isDone)
     {
      this.title = title;
      this.project = project;
      this.date = date;
      isDone = status;
    }
    
    /*
    * @return The task title
    */
    public String isCalled()
     {
       return this.title;
    }

    /*
    * @return The task Project
    */
    public String getProject()
     {
	 return project;
     }
     
    /*
    * @return The task status
    */
     public String getStatus()
     {
	return status;
     }
     
    /*
    * @return The task Date
    */
    public String getTaskDate()
     {
 	return date;
     }
     
      /*
      * @set the task title
      */
    public void setTaskTitle(String setTaskTitle)
     {
	title = setTaskTitle;
     }
     
     /*
      * @set the task status to done
      */
    public void setTaskStatusDone()
     {
        status = "Done";
     }
     
     /*
      * @set the task project grouping
      */
    public void setProjectName(String setProjectGrouping)
     {
  	project = setProjectGrouping;
     }
     
     /*
      * @set the task date
      */
    public void setTaskDate(String setTaskDate)
      {
	date = setTaskDate;
      }
}