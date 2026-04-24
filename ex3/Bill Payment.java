import java.util.Scanner;

// Base class Payment
class Payment {
    protected static int idCounter = 100;
    protected int id;
    protected String payerName;
    protected double billAmt;
    protected String date;

    Payment(String payerName, double billAmt, String date) {
        this.id = ++idCounter;
        this.payerName = payerName;
        this.billAmt = billAmt;
        this.date = date;
    }

    double calculateFinalAmount() {
        return billAmt;
    }

    void printReceipt(double finalAmt, String mode) {
        System.out.println("\n--- Bill Receipt ---");
        System.out.println("Payment ID     : " + id);
        System.out.println("Payer Name     : " + payerName);
        System.out.println("Date           : " + date);
        System.out.println("Mode of Payment: " + mode);
        System.out.println("Bill Amount    : " + billAmt);
        System.out.println("Final Amount   : " + finalAmt);
        System.out.println("---------------------\n");
    }
}

// Card Class (adds 15% GST on any card transaction)
class Card extends Payment {
    protected String cardNo;
    protected String pin;

    Card(String payerName, double billAmt, String date, String cardNo, String pin) {
        super(payerName, billAmt, date);
        this.cardNo = cardNo;
        this.pin = pin;
    }
    double calculateFinalAmount() {
        return billAmt + (billAmt * 0.15); // 15% GST
    }
}

// DebitCard Class (10% extra + GST)
class DebitCard extends Card {
    DebitCard(String payerName, double billAmt, String date, String cardNo, String pin) {
        super(payerName, billAmt, date, cardNo, pin);
    }
    double calculateFinalAmount() {
        double baseWithGST = super.calculateFinalAmount(); // apply GST first
        return baseWithGST + (billAmt * 0.10); // then 10% extra charge
    }
}

// CreditCard Class (5% extra - 50 discount + GST)
class CreditCard extends Card {
    CreditCard(String payerName, double billAmt, String date, String cardNo, String pin) {
        super(payerName, billAmt, date, cardNo, pin);
    }
    double calculateFinalAmount() {
        double baseWithGST = super.calculateFinalAmount();
        return (baseWithGST + (billAmt * 0.05)) - 50; //  5% extra, minus Rs.50 discount
    }
}
// Cash Class (12% discount, no GST)
class Cash extends Payment {
    Cash(String payerName, double billAmt, String date) {
        super(payerName, billAmt, date);
    }
    double calculateFinalAmount() {
        return billAmt - (billAmt * 0.12); // 12% discount
    }
}

public class Bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Bill Amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
        System.out.print("Enter Mode of Payment (card/cash): ");
        String mode = sc.nextLine();

        Payment payment;
        if (mode.equalsIgnoreCase("card")) {
            System.out.print("Enter Card Type (debit/credit): ");
            String type = sc.nextLine();

            System.out.print("Enter Card Number: ");
            String cardNo = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            if (type.equalsIgnoreCase("debit")) {
                payment = new DebitCard(name, amt, date, cardNo, pin);
                double finalAmt = payment.calculateFinalAmount();
                payment.printReceipt(finalAmt, "Debit Card");
            } else if (type.equalsIgnoreCase("credit")) {
                payment = new CreditCard(name, amt, date, cardNo, pin);
                double finalAmt = payment.calculateFinalAmount();
                payment.printReceipt(finalAmt, "Credit Card");
            } else {
                System.out.println("Invalid Card Type!");
            }

        } else if (mode.equalsIgnoreCase("cash")) {
            payment = new Cash(name, amt, date);
            double finalAmt = payment.calculateFinalAmount();
            payment.printReceipt(finalAmt, "Cash");
        } else {
            System.out.println("Invalid Payment Mode!");
        }
    }
}
