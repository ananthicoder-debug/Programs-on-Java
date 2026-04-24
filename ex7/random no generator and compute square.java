import java.util.Random;

// Thread 1: Generate random numbers
class RandomNumberThread extends Thread {
    public int number; // shared number for demonstration
    int i;
    public void run() {
        Random rand = new Random();
        while (i<=5) {
            number = rand.nextInt(100); // generate number 0-99
            System.out.println("Generated Number: " + number);
            i++;
            try {
                Thread.sleep(1000); // wait 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Thread 2: Compute square
class SquareThread extends Thread {
    private RandomNumberThread randomThread;
    int i;
    public SquareThread(RandomNumberThread randomThread) {
        this.randomThread = randomThread;
    }

    public void run() {
        while (i<=5) {
            int num = randomThread.number; // read the number
            System.out.println("Square of " + num + " = " + (num * num));
            i++;
            try {
                Thread.sleep(1000); // wait 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Thread 3: Compute cube
class CubeThread extends Thread {
    private RandomNumberThread randomThread;
    int i;
    public CubeThread(RandomNumberThread randomThread) {
        this.randomThread = randomThread;
    }

    public void run() {
        while (i<=5) {
            int num = randomThread.number; // read the number
            System.out.println("Cube of " + num + " = " + (num * num * num));
            i++;
            try {
                Thread.sleep(1000); // wait 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class MultiThread {
    public static void main(String[] args) {
        RandomNumberThread randomThread = new RandomNumberThread();
        SquareThread squareThread = new SquareThread(randomThread);
        CubeThread cubeThread = new CubeThread(randomThread);
        randomThread.start();
        squareThread.start();
        cubeThread.start();
    }
