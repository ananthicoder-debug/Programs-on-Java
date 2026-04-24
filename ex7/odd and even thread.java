import java.lang.*;
class OddThread extends Thread{
        int [] arr;
        int sum=0;
                OddThread (int[] arr){
                        this.arr=arr;
                }
                public void run() {
                        try {
                                for(int n:arr) {
                                        if(n%2!=0) {
                                                sum+=n*n;

                                        }
                                }
                                System.out.println("Odd Sum: "+sum);

                        }
                        catch(Exception e) {
                                System.out.println(e);
                        }
                }
}
class EvenThread extends Thread{
        int [] arr;
        int sum=0;
        EvenThread(int [] arr){
                this.arr=arr;
        }
        public void run() {
                try {
                        for(int n:arr) {
                                if(n%2==0) {
                                        sum+=n*n;
                                }
                        }
                        System.out.println("Even Sum: "+sum);
                }
                catch(Exception e) {
                        System.out.println(e);

                }
        }
}

public class MainPgm1 {
                // TODO Auto-generated constructor stub

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                int [] arr= {11,22,33,44,55,66,77,88,99,111};
                OddThread o=new OddThread(arr);
                EvenThread e=new EvenThread(arr);
                o.start();
                e.start();



        }

}
