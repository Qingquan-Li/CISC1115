package homework9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// This homework will give you practice creating, populating, searching,
// modifying, and  printing arrays, and writing and calling methods.

// Write a complete Java program to  process several transactions for a bank
// account:
// 1. Read the sets of account numbers and their corresponding balances from
// an input file named  “initialBank.txt”  into a set of parallel arrays.
// 2. Prompt the user to enter their account number.
// - If the account number does not exist, the program should print out an error.
// - If the account exists, your program should allow the user to choose from
// a menu that  gives options to (1) withdraw, (2) deposit, (3) check balance,
// or (4) exit.

public class Homework9 {
    
    public static void main(String[] args) {
        // Read the sets of account numbers and their corresponding balances from
        // an input file named  “initialBank.txt”  into a set of parallel arrays.
        final int SIZE = 15;
        int[] accounts = new int[SIZE];
        double[] balances = new double[SIZE];
        int accountNumber;
        int choice;

        final String INPUT_FILE = "homework9/initialBank.txt";
        final String OUTPUT_FILE = "homework9/modifiedBank.txt";

        File inputFile = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        try {
            Scanner scanner = new Scanner(inputFile);
            // Read the account numbers and balances into the parallel arrays
            for (int i = 0; i < SIZE; i++) {
                accounts[i] = scanner.nextInt();
                balances[i] = scanner.nextDouble();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + INPUT_FILE);
            return;
        }

        // Prompt the user to enter their account number.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        accountNumber = scanner.nextInt();

        // If the account number does not exist, the program should print out
        // an error.
        int index = findAccount(accountNumber, accounts);
        if (index == -1) {
            System.out.println("Account not found.");
            scanner.close();
            return;
        }
        // If the account exists, your program should allow the user to choose
        // from a menu that  gives options to (1) withdraw, (2) deposit,
        // (3) check balance, or (4) exit.
        do {
            choice = menu(scanner);
            switch (choice) {
                case 1:
                    withdraw(accountNumber, accounts, balances, scanner);
                    break;
                case 2:
                    deposit(accountNumber, accounts, balances, scanner);
                    break;
                case 3:
                    checkBalance(accountNumber, accounts, balances);
                    break;
                case 4: // Exit
                    try {
                        PrintWriter printWriter = new PrintWriter(outputFile);
                        printAccounts(accounts, balances, printWriter);
                        printWriter.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + OUTPUT_FILE);
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }

    /**
     * findAccount() to accept the account number and the accountNumber array.
     * Return the index of the account number in the array or -1 if the account
     * number is not found.
     */
    public static int findAccount(int accountNumber, int[] accts) {
        for (int i = 0; i < accts.length; i++) {
            if (accts[i] == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    /**
     * menu() to take the keyboard scanner from the main method, and display
     * a menu to read the user's choice, and return the choice entered.
     */
    public static int menu(Scanner sc) {
        System.out.println("\nMenu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    /**
     * withdraw() to acccept the account number, the two arrays, and the
     * Scanner object.
     * The method prompts the user for the amount to withdraw.
     * If the amount is less than the balance, the method subtracts the amount
     * and updates the balances array with the new balance.
     * Otherwise it prints out an error.
     */
    public static void withdraw(int accountNumber, int[] accts,
            double[] balances, Scanner sc) {
        int index = findAccount(accountNumber, accts);
        System.out.print("\nEnter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balances[index]) {
            balances[index] -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    /**
     * deposit() to accept the account number, the two arrays, and the Scanner
     * object.
     * The method prompts the user for the amount to deposit.
     * The method adds the amount to the balance and updates the balances array
     * with the new balance.
     */
    public static void deposit(int accountNumber, int[] accts,
            double[] balances, Scanner sc) {
        int index = findAccount(accountNumber, accts);
        System.out.print("\nEnter the amount to deposit: ");
        double amount = sc.nextDouble();
        balances[index] += amount;
        System.out.println("Deposit successful.");
    }

    /**
     * checkBalance() to accept the account number, the two arrays, and
     * print the corresponding balance.
     */
    public static void checkBalance(int accountNumber, int[] accts,
            double[] balances) {
        int index = findAccount(accountNumber, accts);
        System.out.printf("\nBalance: %.2f\n", balances[index]);
    }

    /**
     * printAccounts() to accept the two arrays and a PrintWriter object
     * and print them out in a two-column format.
     */
    public static void printAccounts(int[] accts, double[] balances,
            PrintWriter pw) {
        pw.println("Account \tBalance");
        pw.println("------- \t-------");
        for (int i = 0; i < accts.length; i++) {
            // pw.printf("%d\t\t%.2f\n", accts[i], balances[i]);
            // Format the account number as a 6-digit integer with leading 0s
            pw.printf("%06d\t\t%.2f\n", accts[i], balances[i]);
        }
    }

}
