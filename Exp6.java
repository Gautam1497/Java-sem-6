import java.util.ArrayList;
import java.util.Scanner;

public class Exp6 {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the string to insert:");
                    String insertString = scanner.nextLine();
                    insert(stringList, insertString);
                    break;
                case 2:
                    System.out.println("Enter the string to delete:");
                    String deleteString = scanner.nextLine();
                    delete(stringList, deleteString);
                    break;
                case 3:
                    display(stringList);
                    break;
                case 4:
                    System.out.println("Enter the string to search:");
                    String searchString = scanner.nextLine();
                    search(stringList, searchString);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    // Insert operation
    private static void insert(ArrayList<String> list, String item) {
        list.add(item);
        System.out.println(item + " inserted successfully.");
    }

    // Delete operation
    private static void delete(ArrayList<String> list, String item) {
        if (list.remove(item)) {
            System.out.println(item + " deleted successfully.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    // Display operation
    private static void display(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("List contents:");
            for (String item : list) {
                System.out.println(item);
            }
        }
    }
    private static void search(ArrayList<String> list, String item) {
        if (list.contains(item)) {
            System.out.println(item + " found in the list.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }
}
