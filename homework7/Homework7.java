package homework7;

import java.util.Scanner;

public class Homework7 {

    public static void main(String[] args) {
        String password, confirmPassword;
        Scanner scanner = new Scanner(System.in);
        int attempts = 0; // count the number of attempts
        final int MAX_ATTEMPTS = 3; // maximum number of attempts
        
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Please enter password: ");
            password = scanner.nextLine();
            System.out.print("Please re-enter password to confirm: ");
            confirmPassword = scanner.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("Password Invalid --- Passwords DO NOT Match.");
            } else {
                boolean hasCorrectLength = false;
                boolean hasSpace = false;
                boolean hasDigit = false;
                boolean hasLowercasse = false;
                boolean hasUppercase = false;
                boolean hasSpecialCharacter = false;
                if (password.length() >= 8 && password.length() <= 15) {
                    hasCorrectLength = true;
                }
                for (int i = 0; i < password.length(); i++) {
                    char ch = password.charAt(i);
                    if (Character.isWhitespace(ch)) {
                        hasSpace = true;
                    }
                    if (Character.isDigit(ch)) {
                        hasDigit = true;
                    }
                    if (Character.isLowerCase(ch)) {
                        hasLowercasse = true;
                    }
                    if (Character.isUpperCase(ch)) {
                        hasUppercase = true;
                    }
                    if (ch == '@' || ch == '#' || ch == '%' || ch == '&' || ch == '!' || ch == '$') {
                        hasSpecialCharacter = true;
                    }
                }
                if (!hasCorrectLength) {
                    System.out.println("Password Invalid  --- Password Length NOT Between 8 to 15 Characters.");
                }
                if (hasSpace) {
                    System.out.println("Password Invalid --- Password Contains Space.");
                }
                if (!hasDigit) {
                    System.out.println("Password Invalid --- Password Does NOT Contain Digit.");
                }
                if (!hasLowercasse) {
                    System.out.println("Password Invalid --- Password Does NOT Contain Lowercase Character.");
                }
                if (!hasUppercase) {
                    System.out.println("Password Invalid --- Password Does NOT Contain Uppercase Character.");
                }
                if (!hasSpecialCharacter) {
                    System.out.println("Password Invalid --- Password Does NOT Contain Special Character.");
                }
                if (hasCorrectLength && !hasSpace && hasDigit && hasLowercasse && hasUppercase && hasSpecialCharacter) {
                    System.out.println("Password Accepted --- WELCOME!");
                    break;
                }
            }

            attempts++;
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("**ERROR** Too Many Attempts --- Account is Locked");
            }
        }

        scanner.close();
    }
}