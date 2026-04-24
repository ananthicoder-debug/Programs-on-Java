import java.util.Scanner;

class Customer {
    String name;
    double balance;
    String accountNo;
    int cusId;

    Customer(int cusId, String name, double balance, String accountNo) {
        this.cusId = cusId;
        this.name = name;
        this.balance = balance;
        this.accountNo = accountNo;
    }
}

// Bank class
class Bank extends Customer {
    int bankCode;
    String bName;

    Bank(int cusId, String name, double balance, String accountNo, int bankCode, String bName) {
        super(cusId, name, balance, accountNo);
        this.bankCode = bankCode;
        this.bName = bName;
    }

    double getInterestRate() {
        return balance * 0.00;
    }

    void display() {
        System.out.println("--------- CUSTOMER DETAILS ----------");
        System.out.println("Customer Id: " + cusId);
        System.out.println("Name: " + name);
        System.out.println("Account number: " + accountNo);
        System.out.println("Balance: Rs " + balance);
        System.out.printf("Interest Rate: Rs.%.2f\n", getInterestRate());
    }
}

// SBI subclass
class SBI extends Bank {
    static String bName = "SBI";
    static int bankCode = 1234;
    String city;

    SBI(int cusId, String name, double balance, String accountNo, String city) {
        super(cusId, name, balance, accountNo, bankCode, bName);
        this.city = city;
    }

    double getInterestRate() {
        return balance * 0.08;
    }

    void display() {
        System.out.println("--------- SBI BANK DETAILS ----------");
        System.out.println("Bank Name: " + bName);
        System.out.println("Bank Code: " + bankCode);
        System.out.println("City: " + city);
        super.display();
    }
}

// Canara subclass
class Canara extends Bank {
    static String bName = "Canara";
    static int bankCode = 5678;
    String city;

    Canara(int cusId, String name, double balance, String accountNo, String city) {
        super(cusId, name, balance, accountNo, bankCode, bName);
        this.city = city;
    }

    double getInterestRate() {
        return balance * 0.05; // 5% interest
    }

    void display() {
        System.out.println("--------- CANARA BANK DETAILS ----------");
        System.out.println("Bank Name: " + bName);
        System.out.println("Bank Code: " + bankCode);
        System.out.println("City: " + city);
        super.display();
    }
}

// Main class
public class BankPgm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER CUSTOMER ID:");
        int cusId = sc.nextInt();
        sc.nextLine();

        System.out.println("ENTER YOUR NAME:");
        String name = sc.nextLine();

        System.out.println("ENTER YOUR ACCOUNT NO:");
        String accountNo = sc.nextLine();

        System.out.println("ENTER YOUR BALANCE:");
        double balance = sc.nextDouble();

        System.out.println("ENTER YOUR BANK CODE (SBI-1234, CANARA-5678):");
        int bankCode = sc.nextInt();
        sc.nextLine();

        if (bankCode == SBI.bankCode) {
            System.out.println("ENTER YOUR BANK BRANCH (CITY):");
            String branch = sc.nextLine();
            SBI sb = new SBI(cusId, name, balance, accountNo, branch);
            sb.display();
        } else if (bankCode == Canara.bankCode) {
            System.out.println("ENTER YOUR BANK BRANCH (CITY):");
            String branch = sc.nextLine();
            Canara canara = new Canara(cusId, name, balance, accountNo, branch);
            canara.display();
        } else {
            System.out.println("INVALID BANK CODE");
            Bank bank = new Bank(cusId, name, balance, accountNo, 0, "Unknown Bank");
            bank.display();
        }

        sc.close();
    }
}
