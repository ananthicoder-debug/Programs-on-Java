import java.util.Scanner;

class Book {
    int bookId;
    String bookName;
    String authorName;
    short daysBorrowed;
    double fine;

    // Default constructor
    Book() {
        bookId = 0;
        bookName = "Unknown";
        authorName = "Unknown";
        daysBorrowed = 0;
        fine = 0.0;
    }

    // Parameterized constructor
    Book(int bookId, String bookName, String authorName, short daysBorrowed) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.daysBorrowed = daysBorrowed;
        calculateFine();
    }

    // Calculate fine
    void calculateFine() {
        if (daysBorrowed > 15) {
            fine = (daysBorrowed - 15) * 2.0;
        } else {
            fine = 0.0;
        }
    }

    // Display book details
    void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author Name: " + authorName);
        System.out.println("Days Borrowed: " + daysBorrowed);
        System.out.println("Fine Amount: Rs." + fine);
    }
}

class Student {
    int studentId;
    String name;
    String department;
    String studentClass;
    String section;
    Book borrowedBook;

    // Default constructor
    Student() {
        studentId = 0;
        name = "Unknown";
        department = "Unknown";
        studentClass = "Unknown";
        section = "Unknown";
        borrowedBook = new Book();
    }

    // Parameterized constructor
    Student(int studentId, String name, String department, String studentClass, String section, Book borrowedBook) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.studentClass = studentClass;
        this.section = section;
        this.borrowedBook = borrowedBook;
    }

    // Display student details
    void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Class: " + studentClass);
        System.out.println("Section: " + section);
        System.out.println("Borrowed Book Details:");
        borrowedBook.displayBook();
        System.out.println("--------------------------------");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            System.out.print("Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Class: ");
            String cls = sc.nextLine();

            System.out.print("Section: ");
            String sec = sc.nextLine();

            System.out.print("Has the student borrowed a book? (yes/no): ");
            String hasBorrowed = sc.nextLine().trim().toLowerCase();

            Book book;
            if (hasBorrowed.equals("yes")) {
                System.out.print("Book ID: ");
                int bookId = sc.nextInt();
                sc.nextLine();

                System.out.print("Book Name: ");
                String bName = sc.nextLine();

                System.out.print("Author Name: ");
                String author = sc.nextLine();

                System.out.print("Number of Days Borrowed: ");
                short days = sc.nextShort();
                sc.nextLine();

                book = new Book(bookId, bName, author, days);
            } else {
                // Use default constructor if no book borrowed
                book = new Book();
            }

            // Create Student object
            students[i] = new Student(id, name, dept, cls, sec, book);
        }

        // Display all records
        System.out.println("\n--- Student and Book Details ---");
        for (int i = 0; i < n; i++) {
            students[i].displayStudent();
        }
    }
}
