import java.util.Scanner;
public class PasswordValidator {

    public static boolean validate(String password) {
        boolean isValid = true;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Check length
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            isValid = false;
        }

        // Check characters
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLower = true;
                }
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("@#$%^&+=!".indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        if (!hasUpper) {
            System.out.println("Password must contain at least one uppercase letter.");
            isValid = false;
        }
        if (!hasLower) {
            System.out.println("Password must contain at least one lowercase letter.");
            isValid = false;
        }
        if (!hasDigit) {
            System.out.println("Password must contain at least one digit.");
            isValid = false;
        }
        if (!hasSpecial) {
            System.out.println("Password must contain at least one special character (@#$%^&+=!).");
            isValid = false;
        }

        return isValid;
    }
}

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String inputPassword = sc.nextLine();

        boolean result = PasswordValidator.validate(inputPassword);

        if (result) {
            System.out.println("Password is strong and valid.");
        } else {
            System.out.println("Password validation failed.");
        }

        sc.close();
    }
}
