import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private String designation;
    private double salary;
    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class Exp7 {
    private static final String FILE_NAME = "employee_data.dat";
    private static LinkedList<Employee> employeeList = new LinkedList<>();
    public static void main(String[] args) {
        loadEmployeeDataFromFile();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    saveEmployeeDataToFile();
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    private static void addEmployee(Scanner scanner) {
        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Employee Designation:");
        String designation = scanner.nextLine();
        System.out.println("Enter Employee Salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        Employee employee = new Employee(name, id, designation, salary);
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }
    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee details:");
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
    private static void loadEmployeeDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream(FILE_NAME))) {
            employeeList = (LinkedList<Employee>) ois.readObject();
            System.out.println("Employee data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data from file: " +
                    e.getMessage());
        }
    }
    private static void saveEmployeeDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream(FILE_NAME))) {
            oos.writeObject(employeeList);
            System.out.println("Employee data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employee data to file: " + e.getMessage());
        }
    }
}