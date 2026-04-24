import java.util.Scanner;

// Class to store patient details
class Patient {
    String name;
    int age;
    String gender;
    String disease;

    // Constructor to initialize patient data
    public Patient(String name, int age, String gender, String disease) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    // Method to display patient information
    public void displayInfo() {
        System.out.println("Patient Name : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Disease      : " + disease);
        System.out.println("--------------------------------");
    }
}

// Main class
public class PatientDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        // Create array of Patient objects
        Patient[] patients = new Patient[n];

        // Input details for each patient
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for patient " + (i + 1));
            System.out.print("Name    : ");
            String name = sc.nextLine();
            System.out.print("Age     : ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Gender  : ");
            String gender = sc.nextLine();
            System.out.print("Disease : ");
            String disease = sc.nextLine();

            // Create patient object and store in array
            patients[i] = new Patient(name, age, gender, disease);
        }

        // Display all patients
        System.out.println("\n---- Patient Records ----");
        for (int i = 0; i < n; i++) {
            System.out.println("Patient " + (i + 1) + " Details:");
            patients[i].displayInfo();
        }

        sc.close();
    }
}
