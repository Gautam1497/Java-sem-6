import java.util.Scanner;

class desigDetails {
    public char desig_code;
    public String designation;
    public int da;

    desigDetails(char desig_code, String designation, int da) {
        this.desig_code = desig_code;
        this.designation = designation;
        this.da = da;
    }
}

class employee {
    public int employee_id;
    public String employee_name;
    public String join_date;
    public char desig_code;
    public String department;
    public int basic;
    public int hra;
    public int it;

    employee(int employee_id, String employee_name, String join_Date, char desig_code, String department, int basic,
             int hra, int it) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.join_date = join_Date;
        this.desig_code = desig_code;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}

public class Exp1 {
    public static void main(String[] args) {

        desigDetails e = new desigDetails('e', "Engineer", 20000);
        desigDetails c = new desigDetails('c', "Consultant", 32000);
        desigDetails k = new desigDetails('k', "Clerk", 12000);
        desigDetails r = new desigDetails('r', "Receptionist", 15000);
        desigDetails m = new desigDetails('m', "Manager", 40000);

        desigDetails[] desig_details_array = { e, c, k, r, m };

        employee emp1 = new employee(5998, "Gautam", "01/01/2001", 'm', "Management", 50000, 100000, 1000);
        employee emp2 = new employee(5425, "Anish", "01/01/2001", 'e', "Engg", 40000, 10000, 1000);
        employee emp3 = new employee(5885, "Rama", "01/01/2001", 'c', "cons", 30000, 10000, 1000);
        employee emp4 = new employee(6800, "Siddhant", "01/01/2001", 'r', "Recp", 25000, 10000, 1000);
        employee emp5 = new employee(6000, "Satyam", "01/01/2001", 'k', "Clerk", 20000, 10000, 1000);
        employee[] employee_array = { emp1, emp2,emp3,emp4,emp5 };

        Scanner sc = new Scanner(System.in);

        while (true) {
            int temp;
            System.out.println("Do you want to look for employee information? ");
            System.out.print("Enter 1 to look for information and enter 0 to stop: ");
            temp = sc.nextInt();
            if (temp == 0) {
                break;
            }
            System.out.println();
            System.out.print("Enter employee id: ");
            int id = sc.nextInt();
            boolean emp_found = false;
            for (employee emp : employee_array) {
                if (emp.employee_id == id) {
                    int salary = emp.basic + emp.hra - emp.it;
                    String designation = "";
                    char desig_code = emp.desig_code;
                    for (desigDetails d : desig_details_array) {
                        if (d.desig_code == desig_code) {
                            salary += d.da;
                            designation = d.designation;
                        }
                    }
                    emp_found = true;
                    System.out.println("id: " + emp.employee_id);
                    System.out.println("Name: " + emp.employee_name);
                    System.out.println("Department: " + emp.department);
                    System.out.println("Designation: " + designation);
                    System.out.println("Salary: " + salary);
                    System.out.println();
                    break;
                }
            }
            if (!emp_found) {
                System.out.println("Employee Not Found");
                System.out.println();
            }

        }
        sc.close();
    }
}
