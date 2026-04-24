class GenericSearch {

    // Generic method to search an element in an array
    public static <T> int search(T[] arr, T key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i; // return index if found
            }
        }
        return -1; // return -1 if not found
    }

    public static void main(String[] args) {
        // Integer array
        Integer[] numbers = {10, 20, 30, 40, 50};
        int index1 = search(numbers, 30);
        System.out.println("Index of 30: " + index1);

        // String array
        String[] names = {"Amit", "Ravi", "Neha", "Priya"};
        int index2 = search(names, "Neha");
        System.out.println("Index of Neha: " + index2);
    }
}

[24bcs035@mepcolinux Generic]$java GenericSearch
Index of 30: 2
Index of Neha: 2
[24bcs035@mepcolinux Generic]$cat GenericSort.java
import java.util.Arrays;

class GenericSort {

    // Generic method to sort an array
    public static <T extends Comparable<T>> void sortArray(T[] arr) {
        Arrays.sort(arr); // built-in sort method
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Integer array
        Integer[] numbers = {50, 10, 30, 20, 40};
        System.out.println("Original Integer Array: " + Arrays.toString(numbers));
        sortArray(numbers);

        // String array
        String[] names = {"Ravi", "Amit", "Neha", "Priya"};
        System.out.println("\nOriginal String Array: " + Arrays.toString(names));
        sortArray(names);
    }
}
