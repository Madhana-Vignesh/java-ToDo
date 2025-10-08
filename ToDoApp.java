import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class ToDoApp {
  
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Welcome to Your CLI To-Do List ---");
        loadTask();
        while (true) {
            displayMenu(); 
            String choice = scanner.nextLine(); 
            processChoice(choice);
        }
    }
  
    private static void displayMenu() {
        System.out.println("\nSelect an action:");
        System.out.println("1. View Tasks");
        System.out.println("2. Add Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }
    private static void processChoice(String choice) {
      switch(choice){
        case "1":
            viewTask();
            break;
        case "2":
            addTask();
            break;
        case "3":
            deleteTask();
            break;
        case "4": 
            System.out.println("Goodbye! Tasks saved successfully (not really, but soon!).");
            saveTask();
            scanner.close();
            System.exit(0); 
        default:
            System.out.println("It is an wrong Input. Please enter 1, 2, 3, or 4.");
            break;
      }
    }
    private static void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("Your ToDo List is Empty.");
        }else{
            System.out.println("Your To-Do List :");
            int i=1;
            for(String task:tasks){
                System.out.println(i+" "+task);
                i++;    
            }
        }
    }
    
    private static void addTask(){
        System.out.println("Enter Task Description:");
        String description=scanner.nextLine();
        if(description.trim().isEmpty()){
            System.out.println("Error : Task Description cannot be empty. Please try again");
            return;
        }
        tasks.add(description);
        System.out.println("Task added successfully.");
    }
    private static void deleteTask(){
        if (tasks.isEmpty()) {
        System.out.println("The To-Do List is currently empty. Nothing to delete.");
        return;
        }
        viewTask();
        System.out.print("Enter the Task Number that you need to delete: ");
        if(scanner.hasNextInt()){
            int taskNo=scanner.nextInt();
            scanner.nextLine(); 
            if(taskNo<=0 || taskNo>tasks.size()){
                System.out.println("Error : Enter a valid Task Number. Please enter Number 1 to "+tasks.size()+".");
            }
            else{
                tasks.remove(taskNo-1);
                System.out.println("Task deleted successfully.");
            }
        }
        else{
            System.out.println("Error: Invalid Input. Please enter a Number.");
            scanner.nextLine(); 
        }
      
    }
    private static void saveTask(){
        try(PrintWriter write = new PrintWriter(new FileWriter("todo.txt"))){
            for(String task: tasks){
                write.println(task);
            }
            System.out.println("All tasks have been saved to todo.txt");
        }
        catch(IOException e){
            System.err.print("Error on saving tasks: "+e.getMessage());
        }
    }
    private static void loadTask(){
        try(BufferedReader read = new BufferedReader(new FileReader("todo.txt"))){
            String line;
            while((line=read.readLine()) != null){
                tasks.add(line);
            }
            System.out.println(tasks.size()+" tasks are loaded from file.");
        }
        catch(FileNotFoundException e){
            System.out.println("No previous task file found. Starting fresh...");
        }
        catch(IOException e){
            System.err.print("Error on loading tasks: "+e.getMessage());
        }
    }
}