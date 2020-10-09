for (int i = index; i < this.count - 1; i++) {
                toDoList.get(index) = toDoList.indexOf(i + 1);
            }
            
            
            
            
   System.out.print("Enter the Task you need to do: ");
                       
                        boolean added = simpleToDoList.add(Task task1);
                        if (!added) {
                            System.out.println("Sorry, but this to-do list is already full!");
                        }
                        break;
                        
                        
                        
                        
             public String toString()
     {
        return title + " : " + (status ? "Status" : "Done");
     }
     
     
     
     
      /**
     * Returns a String representation of this ToDoList.
     * Specifically, "TODO:" followed by a numbered list of tasks.
     */
    public String toString() 
    {
        String ToDoOutput = "TODO:\n";
        for (int i = 0; i < this.count; i++) {
            ToDoOutput += (i + 1) + ". " + this.toDoList.indexOf(i) + "\n";
        }
        return ToDoOutput;
    }