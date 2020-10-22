package ToDoLy;

import java.io.*;
import java.util.ArrayList;


/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 * <p>
 * This StreamManager is in the form of C.R.U.D.
 * in that it has the ability to:
 * Create a file
 * Read a file (input reader)
 * Update a file (output writer)
 * Delete a file
 *
 * @Tristan_McCarthy
 */

public class StreamManager {
    //TODO change the path
    private final String path = "/Users/tristanmccarthy/Desktop/ToDoListMASTER/";
    public String filename = "simpleToDoList.txt";


    /**
     * This method creates a new file for data to be saved in or indicates that a file already exists
     */
    public void createFile() {
        try {
            File newFile = new File(filename);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * This Object Stream write method, writes the data input by the user into program,
     * to a file. As the todolist is saved in an arraylist the method writes
     * the arraylist to file as an object. If a file doesn't exit, it creates one with the
     * name simpleToDoList.txt.
     */
    public void writeAsObject(ArrayList<Task> list) {
        try {
            FileOutputStream file = new FileOutputStream(path + "simpleToDoList.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File not found " + e);
        }

    }

    /**
     * This Object Stream read method, reads the data in the file
     * As the todolist is saved as an arraylist the method reads
     * the arraylist from the file as an object. The arraylist in
     * the file goes on to populate the 'working' arraylist used as
     * the todolist in the project at the initial running of
     * the program.
     */
    public ArrayList<Task> readAsObject() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "simpleToDoList.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read object from the stream
            list = (ArrayList<Task>) stream.readObject();

            stream.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File not found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("problems inside the file " + e);
        }
        return list;
    }
}







































