import java.lang.*;
class FibbThread extends Thread{
        public void run() {
                try {
                        int a=1,b=1;
                        int c;
                        for (int i=0;i<5;i++) {
                                c=a+b;
                                System.out.println(c);
                                a=b;
                                b=c;
                        }
                }
                catch(Exception e) {
                        System.out.println("Exception caught:"+e);
                }
        }
}

class PrimeThread extends Thread{
        public void run() {
                try {
                        for(int i=2;i<=100;i++) {
                                int f=0;
                                for(int j=2;j<=(i/2);j++) {
                                        if(i%j==0)
                                                f++;
                                        else
                                                continue;
                                }
                                if (f==0)
                                        System.out.println(i);
                        }
                }
                catch(Exception e) {
                        System.out.println("Exception caught:"+e);
                }
        }
}
public class MainThread {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                FibbThread f=new FibbThread();
                f.start();
                PrimeThread p=new PrimeThread();
                p.start();

        }

}
