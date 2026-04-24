class Pair<T, U> {
    T first;   // first value of type T
    U second;  // second value of type U

    // Constructor
    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Method to display the values
    void display() {
        System.out.println("First value: " + first);
        System.out.println("Second value: " + second);
    }
}

public class GenericTwoTypes {
    public static void main(String[] args) {
        // Example 1: Integer and String
        Pair<Integer, String> pair1 = new Pair<>(101, "Ravi");
        pair1.display();

        // Example 2: String and Double
        Pair<String, Double> pair2 = new Pair<>("Price", 99.99);
        pair2.display();
    }
}
