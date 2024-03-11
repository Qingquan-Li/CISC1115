package homework5;

import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        int guess;
        int attempts = 0;
        final int TARGET_NUMBER = (int) (Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?\n");

        do {
            System.out.print("Enter you guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess > TARGET_NUMBER) {
                System.out.println("Too high! Try again");
            } else if (guess < TARGET_NUMBER) {
                System.out.println("Too low! Try again");
            } else {
                System.out.printf("%nCongratulations! You guessed the number in %d attempts.%n", attempts);
            }
        } while (guess != TARGET_NUMBER);

        scanner.close();
    }
}