import java.util.*;
@FunctionalInterface
interface Addable {
    int add(int a, int b);
}
@FunctionalInterface
interface Subtractable {
    int subtract(int a, int b);
}
interface Multiplyable {
    int multiply(int a, int b);
}
@FunctionalInterface
interface Divideable {
    int divide(int a, int b);
}
public class CalMain {
    public static void main(String[] args) {
        Addable add = (a, b) -> a + b;
        Subtractable sub = (a, b) -> a - b;
        Multiplyable m = (a, b) -> a * b;
        Divideable d = (a, b) -> a / b;
        System.out.println("Addition="+add.add(1, 2));
        System.out.println("Subtraction="+sub.subtract(5, 6));
        System.out.println("Multiplication="+m.multiply(7, 5));
        System.out.println("Division="+d.divide(10, 5));
    }
}
