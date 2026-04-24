import java.util.Scanner;
class Doctor{
    protected int id;
    protected String name;
    Doctor(){
        name = "";
        id = 0;
    }
    Doctor(int id, String name){
        this.id = id;
        this.name = name;
    }
}
class Surgeon extends Doctor {
    protected String department;
    Surgeon()
    {
        super();
        department=" ";
    }
    Surgeon(int id, String name, String department){
        super(id,name);
        this.department = department;
    }
    @Override
    public String toString() {
        return "Id=" +id + ", name=" + name + " ,Department=" +department;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;//same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Surgeon sur = (Surgeon) obj;//type casting
        return id==sur.id && department.equals(sur.department) && name.equals(sur.name);//same values
    }
    @Override
    public int hashCode() {
        return id;
    }
}

public class DocMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of doctors: ");
        int n = sc.nextInt();
        Surgeon[] sur=new Surgeon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter surgeon " + (i + 1) + ": ");
            System.out.println("Enter your ID: ");
            int id = sc.nextInt();
            System.out.println("Enter your Name: ");
            String name = sc.next();
            System.out.println("Enter your Department: ");
            String department = sc.next();
            sur[i] = new Surgeon(id, name, department);
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Surgeon " + (i + 1) + " Details ");
            System.out.println("Class Name:" + sur[i].getClass());
            System.out.println("Hash code:" + sur[i].hashCode());
            System.out.println("toString:" + sur[i].toString());
        }
        Surgeon Emp1=new Surgeon(1,"Ram","Ortho");
        Surgeon Emp3=new Surgeon(1,"Ram","Ortho");
        Surgeon Emp2=new Surgeon(3,"Sam","Cardio");
        Surgeon Emp4;
        Surgeon Emp5=new Surgeon();//default constructor
        Emp4=Emp2;//referring to same object
        System.out.println("Emp1 without calling  ToString :");
        System.out.println(Emp1);
        System.out.println("Emp1 equals Emp2:" + Emp1.equals(Emp2));
        System.out.println("Emp1 equals Emp3:" + Emp1.equals(Emp3));
        System.out.println("Emp2 equals Emp4:" + Emp2.equals(Emp4));
        System.out.println("Emp5 equals Emp2:"+ Emp5.equals(Emp2));
    }
}
