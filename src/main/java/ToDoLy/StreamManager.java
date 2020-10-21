package ToDoLy;
import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is part of the ToDoly to-do list application.
 * ToDoly is a very simple to-do list application.
 *
 * This StreamManager is in the form of C.R.U.D.
 * in that it has the ability to:
 * Create a file
 * Read a file (input reader)
 * Update a file (output writer)
 * Delete a file
 *
 * @Tristan_McCarthy
 */


public class StreamManager
{
    //TODO change the path
    private String path = "/Users/tristanmccarthy/Desktop/ToDoListMASTER/";
    public String filename = "simpleToDoList.txt";

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

    //Data Stream :
   /* public void writeAsData(ArrayList<Task> list)
    {

        try {
            FileWriter fileWriter = new FileWriter(new File(path + "simpleToDoList.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Task task: list)
            {
                bufferedWriter.write(list.toString() + "\n");
            }
            bufferedWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }

    }

    public ArrayList<Task> readAsData()
    {
        ArrayList<Task> list = new ArrayList<>();

        try
        {
            FileReader fileReader = new FileReader(new File("\"/Users/tristanmccarthy/Desktop/ToDoListMASTER/"));
            BufferedReader br = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ( (line = br.readLine()) != null )
            {
                data = line.split("\\*\\*");
                Task task = new Task(data[0],data[1], data[2], data[3]);
                list.add(task);
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found " +  e);
        }


        return list;
    } */


    //--------------------------

    //Object Stream
    public void writeAsObject(ArrayList<Task> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "simpleToDoList.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found " +  e);
        }

    }

    public ArrayList<Task> readAsObject()
    {
        ArrayList<Task> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "simpleToDoList.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            list = (ArrayList<Task>) stream.readObject();

            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File not found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return list;
    }
}








































/*public class StreamManager {

    public void create()
    {
        File newFile = new File("simpleToDoList.txt");
    }

    public void read(ToDoList simpleToDoList) throws IOException {
        try {
            File file = new File("simpleToDoList.txt");
            Scanner reader = new Scanner(file);
            DateFormat formatterAdd = new SimpleDateFormat("yyyy-MM-dd");

            while (reader.hasNextLine()) {
                String tasks = reader.nextLine();

                String title = "";
                String project= "";
                String status = "";
                Date date = null;

                //replace comma for dot


                Pattern titlePattern;
                titlePattern = Pattern.compile("([a-zA-Z\\s]+)");
                Matcher match1 = titlePattern.matcher(tasks);

                Pattern projectPattern;
                projectPattern = Pattern.compile("(?<=project: ).*");
                Matcher match2 = projectPattern.matcher(tasks);

                Pattern datePattern;
                datePattern = Pattern.compile("([\\d-]+(?!:))");
                Matcher match3 = datePattern.matcher(tasks);

                Pattern statusPattern;
                statusPattern = Pattern.compile("(?<=status: ).*");
                Matcher match4 = statusPattern.matcher(tasks);

                if (match1.find()) {
                    title = match1.group().trim();
                }

                if (match2.find()) {
                    project = match2.group();
                }

                if (match3.find()) {
                    String d = match3.group();
                    date = formatterAdd.parse(match3.group());
                }

                if (match4.find()) {
                    status = match4.group();
                }

                simpleToDoList.addTask(title,project,date,status);

            }
            reader.close();
        } catch(IOException | ParseException e) {
            e.getMessage();
        }
    }

    public void update(ToDoList simpleToDoList) {
        try {
            FileWriter writer = new FileWriter("simpleToDoList.txt");
            writer.write(simpleToDoList.getTasks());
            writer.close();
        } catch(IOException e) {
            e.getMessage();
        }
    }



}
*/
