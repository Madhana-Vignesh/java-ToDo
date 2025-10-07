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
            display();
            break;
        case "2":
            addTask();
            break;
        case "3":
            deleteTask();
            break;
        case "4": 
            System.out.println("Goodbye! Tasks saved successfully (not really, but soon!).");
            System.exit(0); 
        default:
            System.out.println("It is an wrong Input");
            break;
      }
    }
}
