import java.util.*;
abstract class Shapes
{
    abstract double calculatearea();
    abstract void display();
}
class Rectangle extends Shapes
{
    int area;
    int length;
    int breadth;
    public Rectangle( int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    double calculatearea()
    {
        area=length*breadth;
        return area;
    }
    void display()
    {
        System.out.println("Area ="+calculatearea());
    }
}
class Triangle extends Shapes
{
    double area;
    int length;
    int height;
    public Triangle( int length, int height) {
        this.length = length;
        this.height = height;
    }
    double calculatearea()
    {
        area=(length*height*(0.5));
        return area;
    }
    void display()
    {
        System.out.println("Area ="+calculatearea());
    }
}
public class ShapesMain {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Shapes s;
        System.out.println("Rectangle details:");
        System.out.println("Enter length:");
        int l=sc.nextInt();
        System.out.println("Enter breadth:");
        int b=sc.nextInt();
        s=new Rectangle(l,b);
        s.display();
        System.out.println("Triangle details:");
        System.out.println("Enter base:");
        int len=sc.nextInt();
        System.out.println("Enter height:");
        int h=sc.nextInt();
        s=new Triangle(len,h);
        s.display();

    }

}
