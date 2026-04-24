import java.util.*;

// BankAccount class with synchronized methods
class BankAccount {
    private String accountNumber;
    private String password;
    private String name;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    public BankAccount(String name, String accountNumber, String password, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Deposit successful. Current Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful. Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public synchronized void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public synchronized void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }

    // synchronized transfer to another account
    public void transfer(BankAccount receiver, double amount) {
        synchronized (this) {
            if (amount <= balance) {
                balance -= amount;
                transactions.add("Transferred " + amount + " to " + receiver.getAccountNumber());
                System.out.println("Transferred " + amount + " to account " + receiver.getAccountNumber());
                synchronized (receiver) {
                    receiver.balance += amount;
                    receiver.transactions.add("Received " + amount + " from " + this.getAccountNumber());
                }
            } else {
                System.out.println("Insufficient balance to transfer!");
            }
        }
    }
}

public class BankingSystem {
    private static Scanner sc = new Scanner(System.in);
    private static List<BankAccount> accounts = new ArrayList<>();

    // Generate random 12-digit account number
    private static String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Find account by account number
    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Create default accounts
    private static void createDefaultAccounts() {
        accounts.add(new BankAccount("Rajesh", "123456789012", "pass1", 5000));
        accounts.add(new BankAccount("Shunmu", "234567890123", "pass2", 7000));
        accounts.add(new BankAccount("Navnee", "345678901234", "pass3", 10000));
    }

    // Create a new account
    private static void createAccount() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Set your password: ");
        String password = sc.nextLine();
        String accNum = generateAccountNumber();
        BankAccount newAcc = new BankAccount(name, accNum, password, 0);
        accounts.add(newAcc);
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + accNum);
    }

    // Login method
    private static BankAccount login() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        BankAccount acc = findAccount(accNum);
        if (acc != null && acc.getPassword().equals(pass)) {
            System.out.println("\nWelcome, " + acc.getName() + "!");
            return acc;
        } else {
            System.out.println("Invalid account number or password.");
            return null;
        }
    }

    // Menu for logged-in users
    private static void userMenu(BankAccount acc) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transaction History\n5. Transfer to Another Account\n6. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    sc.nextLine();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    sc.nextLine();
                    acc.withdraw(wit);
                    break;
                case 3:
                    acc.checkBalance();
                    break;
                case 4:
                    acc.showTransactions();
                    break;
                case 5:
                    System.out.print("Enter recipient account number: ");
                    String recipientAccNum = sc.nextLine();
                    BankAccount recipient = findAccount(recipientAccNum);
                    if (recipient != null) {
                        System.out.print("Enter amount to transfer: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();
                        acc.transfer(recipient, amt);
                    } else {
                        System.out.println("Recipient account not found!");
                    }
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        createDefaultAccounts();

        while (true) {
            System.out.println("\n=== Welcome to LINI Banking System ===");
            System.out.println("1. Login as Existing User");
            System.out.println("2. Create New Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    BankAccount acc = login();
                    if (acc != null) {
                        userMenu(acc);
                    }
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using Simple Banking System!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
