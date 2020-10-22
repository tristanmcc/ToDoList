package ToDoLy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTitle()
        {
            Task taskTest = new Task("Test","Project","2020-12-12","Open");
            assertEquals("Test",taskTest.getTitle());
        }

    @Test
    void getProject()
    {
        Task taskTest = new Task("Test","Project","2020-12-12","Open");
        assertEquals("Project",taskTest.getProject());
    }

    @Test
    void getStatus()
    {
        Task taskTest = new Task("Test","Project","2020-12-12","Open");
        assertEquals("Open",taskTest.getStatus());
    }


    @Test
    void setTaskTitle()
    {
        Task taskTest = new Task("Test","Project","2020-12-12","Open");
        taskTest.setTaskTitle("setTitle");
        assertEquals("setTitle",taskTest.getTitle());
    }

    @Test
    void setTaskStatusDone() {
        Task taskTest = new Task("Test","Project","2020-12-12","Open");
        taskTest.setTaskStatusDone("Done");
        assertEquals("Done",taskTest.getStatus());
    }

    @Test
    void setProjectName()
    {
        Task taskTest = new Task("Test","Project","2020-12-12","Open");
        taskTest.setProjectName("setProject");
        assertEquals("setProject",taskTest.getProject());
    }

}