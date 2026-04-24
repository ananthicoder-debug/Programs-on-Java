import java.util.*;

class VolumeP{
    double volume(double a)
    {
        return a*a*a;
    }

    double volume(double l, double b, double h)
    {
        return l*b*h;
    }
    double volume(double r, double h)
    {
        return ((3.14*0.33)*r*r*h);
    }
}
public class Volume{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        VolumeP obj = new VolumeP();
        System.out.println("Cuboid details:");
        System.out.println("Enter length breadth and height with space:");
        double l=sc.nextDouble();
        double b=sc.nextDouble();
        double h=sc.nextDouble();
        System.out.println("Cube details:");
        System.out.println("Enter side of cube: ");
        double a=sc.nextDouble();
        System.out.println("Cone details:");
        System.out.println("Enter radius and height with space:");
        double r=sc.nextDouble();
        double height=sc.nextDouble();
        System.out.printf("Volume of cuboid:%.2f\n",obj.volume(l,b,h));
        System.out.printf("Volume of cube:%.2f\n",obj.volume(a));
        System.out.printf("Volume of cone:%.2f\n",obj.volume(r,height));
    }
}
