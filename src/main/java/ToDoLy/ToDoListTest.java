package ToDoLy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    ToDoList testToDo = new ToDoList();
    ArrayList<Task> testArrayList = new ArrayList<>();

    @Test
    void addTask()
    {
        testToDo.addTask("t1","Project1","2020-12-12","Open");
        assertEquals("t1",testToDo.getTask(0).getTitle());
    }

    @Test
    void remove()
    {
        Task task = new Task("t1","Project1","2020-12-12","Open");
        testArrayList.add(task);
        testArrayList.remove(0);
        assertEquals(0,testArrayList.size());
    }


    @Test
    void getTask()
    {
        testToDo.addTask("t1","p1","2020-12-12","Open");
        assertEquals("p1",testToDo.getTask(0).getProject());
    }
}

