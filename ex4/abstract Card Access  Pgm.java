import java.util.*;
abstract class Creditcard
{
    String cardNo;
    String holderName;
    String cardType;
    int maxLimit=0;
    public Creditcard(String cardNo, String holderName, String cardType) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.cardType = cardType;
    }
    abstract double calculateBill();
    void display()
    {
        System.out.println("------Bill------");
        System.out.println("Card Number"+ cardNo);
        System.out.println("Holder name:"+holderName);
        System.out.println("Card Type:" + cardType);

    }
}
class SilverCard extends Creditcard{
    int payAmt;
    static int maxLimit=200000;
    public SilverCard(String cardNo, String holderName, String cardType,int payAmt) {
        super(cardNo,holderName,cardType);
        this.payAmt = payAmt;
    }
    double calculateBill()
    {
        if(payAmt>maxLimit) {
            System.out.println("Exceeded maximum limit");
            return 0.0;
        }
        else
        {
            return payAmt;//No discount
        }
    }
    void display()
    {
        super.display();
        System.out.println("Maximum Limit:"+ maxLimit);
        System.out.println("Bill Amount:Rs."+calculateBill());
    }
}
class GoldCard extends Creditcard{
    int payAmt;
    static int maxLimit=500000;
    public GoldCard(String cardNo, String holderName, String cardType,int payAmt) {
        super(cardNo,holderName,cardType);
        this.payAmt = payAmt;
    }
    double calculateBill()
    {
        if(payAmt>maxLimit) {
            System.out.println("Exceeded maximum limit");
            return 0.0;
        }
        else
        {
            return (payAmt-(payAmt*0.05));//5% discount
        }
    }
    void display()
    {
        super.display();
        System.out.println("Bill Amount:Rs."+calculateBill());
    }
}
class PlatinumCard extends Creditcard{
    int payAmt;
    static int maxLimit=1000000;
    public PlatinumCard(String cardNo, String holderName, String cardType,int payAmt) {
        super(cardNo,holderName,cardType);
        this.payAmt = payAmt;
    }
    double calculateBill()
    {
        if(payAmt>maxLimit) {
            System.out.println("Exceeded maximum limit");
            return 0.0;
        }
        else
        {
            return (payAmt-(payAmt*0.1));//10% discount
        }
    }
    void display()
    {
        super.display();
        System.out.println("Maximum Limit:"+ maxLimit);
        System.out.println("Bill Amount:Rs."+calculateBill());
    }
}
public class CardMain {
    public static void main(String[] args) {
        String acno,name,type;
        int pamt;
        Creditcard c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name:");
        name=sc.nextLine();
        System.out.println("Enter your account number:");
        acno=sc.nextLine();
        System.out.println("Enter your card type:");
        type=sc.nextLine();
        System.out.println("Enter your purchase amount:");
        pamt=sc.nextInt();
        if (type.equalsIgnoreCase("silver"))
        {
            c=new SilverCard(acno,name,type,pamt);
            c.display();
        }
        else if (type.equalsIgnoreCase("gold"))
        {
            c=new  GoldCard(acno,name,type,pamt);
            c.display();
        }
        else if (type.equalsIgnoreCase("platinum"))
        {
            c=new  PlatinumCard(acno,name,type,pamt);
            c.display();
        }
        else
        {
            System.out.println("Invalid card Type");
        }
    }

}
