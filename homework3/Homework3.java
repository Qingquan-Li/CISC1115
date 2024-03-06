package homework3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) throws FileNotFoundException {
        int option;
        int textMessage;
        int minute;
        final double OPTION1_PRICE = 89;
        final double OPTION2_BASE_PRICE = 79;
        final double OPTION2_PER_TEXT_PRICE = 0.05;
        final double OPTION3_BASE_PRICE = 35;
        final double OPTION3_OVER_LIMIT_PER_MINUTE_PRICE = 0.03;
        double total;
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("homework3/monthlyBill.txt");

        System.out.print("Enter Phone Plan (Option 1, 2, or 3): ");
        option = scanner.nextInt();

        if (option == 1) {
            total = OPTION1_PRICE;
            System.out.println("\nPhone Plan: 1");
            System.out.printf("Total: $%.2f%n", total);

            printWriter.printf("Phone Plan: 1%n");
            printWriter.printf("Total: $%.2f", total);
        } else if (option == 2) {
            System.out.print("Enter number of Text Messages this month: ");
            textMessage = scanner.nextInt();
            total = OPTION2_BASE_PRICE + OPTION2_PER_TEXT_PRICE * textMessage;
            System.out.println("\nPhone Plan: 2");
            System.out.printf("Number of Text Messages this month: %d%n", textMessage);
            System.out.printf("Total: $%.2f%n", total);

            printWriter.printf("Phone Plan: 2%n");
            printWriter.printf("Number of Text Messages this month: %d%n", textMessage);
            printWriter.printf("Total: $%.2f", total);
        } else if (option == 3) {
            System.out.print("Enter number of Minutes used this month: ");
            minute = scanner.nextInt();
            System.out.println("\nPhone Plan: 3");
            System.out.printf("Number of Minutes used this month: %d%n", minute);
            
            printWriter.println("Phone Plan: 3");
            printWriter.printf("Number of Minutes used this month: %d%n", minute);
            if (minute > 50) {
                total = OPTION3_BASE_PRICE + OPTION3_OVER_LIMIT_PER_MINUTE_PRICE * (minute - 50);
                System.out.println("50 Minute Limit Exceeded! -- Additional $0.03/minute charge applied");
                System.out.printf("Total: $%.2f%n", total);

                printWriter.println("50 Minute Limit Exceeded! -- Additional $0.03/minute charge applied");
                printWriter.printf("Total: $%.2f", total);
            } else {
                total = OPTION3_BASE_PRICE;
                System.out.printf("Total: $%.2f%n", total);

                printWriter.printf("Total: $%.2f", total);
            }
        } else {
            System.out.println("Please enter ONLY 1, 2, or 3");
        }

        scanner.close();
        printWriter.close();
    }
}
