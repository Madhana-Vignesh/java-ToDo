import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
  
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Welcome to Your CLI To-Do List ---");

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
            scanner.close();
            System.exit(0); 
        default:
            System.out.println("It is an wrong Input. Please enter 1, 2, 3, or 4.");
            break;
      }
    }
    private static void viewTask(){
        System.out.println("Your To-Do List :");
        int i=1;
        for(String task:tasks){
            System.out.println(i+" "+task);
            i++;
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
        System.out.println("Enter the Task Number that you need to delete:");
        if(scanner.hasNextInt()){
            int taskNo=scanner.nextInt();
            if(taskNo<=0 || taskNo>=tasks.size()){
                System.out.println("Error : Enter a valid Task Number. Please enter Number 1 to "+tasks.size()+".");
                return;
            }
            else{
                tasks.remove(taskNo-1);
                System.out.println("Task deleted successfully.");
            }
        }
        else{
            System.out.println("Error: Invalid Input. Please enter a Number.");
        }
    }
}
