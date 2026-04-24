import java.util.Scanner;

interface Shape {
    final double pi=3.14;
    void input();
    void calculateArea();
    void calculatePerimeter();
}
class Circle implements Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius of Circle: ");
        radius = input.nextInt();
    }
    public void calculateArea() {
        double area=pi*(radius*radius);
        System.out.printf("Area of Circle:%.2f\n",area);
    }
    public void calculatePerimeter() {
        double perimeter=2*(radius*radius);
        System.out.printf("Perimeter of Circle :%.2f\n",perimeter);
    }
}

class Rectangle implements Shape {
    double width;
    double height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter width of Rectangle: ");
        width = input.nextInt();
        System.out.print("Enter height of Rectangle: ");
        height = input.nextInt();
    }
    public void calculateArea() {
        double area=width*height;
        System.out.printf("Area of Rectangle :%.2f\n",area);
    }
    public void calculatePerimeter() {
        double perimeter=2*(width*height);
        System.out.printf("Perimeter of Rectangle :%.2f\n",perimeter);
    }
}
public class ShapesMain {
    public static void main(String[] args) {
        double radius,width,height;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius of Circle: ");
        radius = input.nextDouble();
        Circle circle=new Circle(radius);
        System.out.println("---------Circle Details--------- ");
        circle.calculateArea();
        circle.calculatePerimeter();
        System.out.print("Enter width of Rectangle: ");
        width = input.nextDouble();
        System.out.print("Enter height of Rectangle: ");
        height = input.nextDouble();
        Rectangle rectangle=new Rectangle(width,height);
        System.out.println("---------Rectangle Details--------- ");
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
    }
}
