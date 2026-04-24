import java.util.Scanner;

class Customer {
    int accountNumber;
    String name;
    String accountType;
    double balance;

    // Default constructor
    Customer() {
        accountNumber = 0;
        name = "Unknown";
        accountType = "Not specified";
        balance = 0.0;
    }

    // Parameterized constructor
    Customer(int accountNumber, String name, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Method to display details
    void displayCustomer() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: Rs." + balance);
        System.out.println("-----------------------------------");
    }
}

public class BankCustomerDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Customer[] customers = new Customer[n];

        // Input details for each customer
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Customer " + (i + 1) + ":");

            System.out.print("Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Account Type (e.g., Savings, Current): ");
            String accType = sc.nextLine();

            System.out.print("Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();

            // Create Customer object using parameterized constructor
            customers[i] = new Customer(accNo, name, accType, balance);
        }

        // Display all customers
        System.out.println("\n--- Customer Details ---");
        for (int i = 0; i < n; i++) {
            customers[i].displayCustomer();
        }

        // Example of default constructor usage
        System.out.println("\n--- Example Customer with Default Constructor ---");
        Customer defaultCustomer = new Customer();
        defaultCustomer.displayCustomer();
    }
}
