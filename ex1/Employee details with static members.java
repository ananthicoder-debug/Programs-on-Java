import java.util.*;
class Employee {
    private int id;
    private String name;
    static int empNo;

    // Static data member
    static String companyName="LiniLogic Technologies";

    // Constructor
    public Employee(int id, String name) {
        empNo++;
        this.id = id;
        this.name = name;
    }


    public void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Company: " + companyName);
        System.out.println("Total employees: " + empNo);
    }

    // Static method
    public static void companyPolicy() {
        System.out.println("\nCompany Policy: Work from home allowed 3 days a week.\n");

    }

}

public class EmployeePgm {
    // Static block
    static {
        System.out.println("Static block executed");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Show static info
        Employee.companyPolicy();
        int n;
        System.out.print("Enter number of employees: ");
        n = sc.nextInt();
        Employee[] emp = new Employee[n];
        for (int i = 0; i < emp.length; i++) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            // Create employee object
            emp[i] = new Employee(id, name);

        }
        for (int i = 0; i < emp.length; i++) {
            // Display details
            emp[i].displayDetails();
        }


        sc.close();
    }

}
