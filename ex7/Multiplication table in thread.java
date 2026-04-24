class MultiplicationTable {
    // Synchronized method to ensure only one thread prints at a time
    synchronized void printTable(int number) {
        System.out.println("Multiplication Table for: " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Small delay for better readability
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        System.out.println(); // Blank line between tables
    }
}

// Thread class for each number
class TableThread extends Thread {
    MultiplicationTable table;
    int number;

    TableThread(MultiplicationTable table, int number) {
        this.table = table;
        this.number = number;
    }

    public void run() {
        table.printTable(number);
    }
}

public class MultiplicationMain {
    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();

        // Create threads for three different numbers
        TableThread t1 = new TableThread(table, 5);
        TableThread t2 = new TableThread(table, 7);
        TableThread t3 = new TableThread(table, 9);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}
