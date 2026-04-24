import java.util.Scanner;
class Employee{
   String empName;
   String empId;
   String address;
   String mailId;
   long mobileNo;
   short age;
   double basicPay;
   public void readEmployee() {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter employee name:");
      empName=in.next();
      System.out.print("Enter employee ID:");
      empId=in.next();
      System.out.print("Enter employee address:");
      address=in.next();
      System.out.print("Enter employee mail id:");
      mailId=in.next();
      System.out.print("Enter employee mobile no:");
      mobileNo=in.nextLong();
      System.out.print("Enter employee age:");
      age=in.nextShort();
      System.out.print("Enter employee basic pay:");
      basicPay=in.nextDouble();
   }
   public void computeSalary(){
      double da,hra,pf,sf,grossSal,netSal;
      da=0.97*basicPay;
      hra=0.1*basicPay;
      pf=0.12*basicPay;
      sf=0.001*basicPay;
      grossSal=basicPay+da+hra;
      netSal=grossSal-(pf+sf);
      System.out.println("_______________________________");
      System.out.println("     Computed Salaries");
      System.out.println("_______________________________");
      System.out.println("Employee Gross salary: Rs." + grossSal);
      System.out.println("Employee Net salary: Rs." + netSal);
   }

   public void displayEmployee(){
      System.out.println("_______________________________");
      System.out.println("     Employee Details");
      System.out.println("_______________________________");
      System.out.println("Employee name:" + empName);
      System.out.println("Employee ID:" + empId);
      System.out.println("Employee address:" + address);
      System.out.println("Employee mail id:" + mailId);
      System.out.println("Employee mobile no:" + mobileNo);
      System.out.println("Employee age:" + age);
      System.out.println("Employee basic pay:Rs." + basicPay);
   }
}
public class EmployeeMain {
   public static void main (String[] args){
      Employee e= new Employee();
      e.readEmployee();
      System.out.println();
      e.displayEmployee();
      System.out.println();
      e.computeSalary();
   }
}
