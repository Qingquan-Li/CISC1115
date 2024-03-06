package homework4;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;
        char operation;
        double result;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        firstNumber = scanner.nextDouble();
        System.out.print("Enter second number: ");
        secondNumber = scanner.nextDouble();
        
        System.out.print("Operation: ");
        operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                }
                break;
            case '%':
                if (secondNumber == 0) {
                    System.out.println("Error: Modulus by zero");
                } else {
                    result = firstNumber % secondNumber;
                    System.out.println("Result: " + result);
                }
                break;
            case '^':
                result = Math.pow(firstNumber, secondNumber);
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid operation, please enter ONLY +, -, *, /, % or ^");
        }

        scanner.close();
    }
}
