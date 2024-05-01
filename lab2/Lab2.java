package lab2;

import java.util.Scanner;

/**
 * Modify Lab 1 so that each question (2, 5, 7, and 8) is computed and printed
 * by a respective method.
 * 
 * The main method should prompt the user for which question that they want to
 * choose, then use the conditional logic of your choice (if statements,
 * switch statements, etc.) to perform the necessary requirements for the
 * question (ex. if the user chooses question 2 the main method should prompt
 * the user for the two numbers and then call a method, questionTwo() with the
 * two numbers as parameters).
 * 
 * Each respective method (questionTwo(), questionFive(), questionSeven(), and
 * questionEight()) should take the necessary parameters (this is determined
 * by the nature of the question itself, read over the code and determine the
 * behavior of each question), compute any necessary operations, print the
 * results, and return nothing (what should the return type of these methods
 * be?)
 */

public class Lab2 {
    
    /**
     * questionTwo() to calculate
     * - the sum of the two numbers
     * - the difference between the two numbers
     * - the product of the two numbers
     * - the quotient of the two numbers
     * */
    private static void questionTwo(int num1, int num2) {
        System.out.printf("The sum of %d and %d is %d%n", num1, num2, num1 + num2);
        System.out.printf("The difference between %d and %d is %d%n", num1, num2, num1 - num2);
        System.out.printf("The product of %d and %d is %d%n", num1, num2, num1 * num2);
        System.out.printf("The quotient of %d and %d is %.2f%n", num1, num2, (double) num1 / num2);
    }

    /**
     * questionFive() to calculate
     * - the area of a rectangle
     * - the perimeter of a rectangle
     */
    private static void questionFive(int length, int width) {
        int area = length * width;
        int perimeter = 2 * (length + width);
        System.out.printf("The area of a rectangle with length %d and width %d is %d%n", length, width, area);
        System.out.printf("The perimeter of a rectangle with length %d and width %d is %d%n", length, width, perimeter);
    }

    /**
     * questionSeven() to convert a temperature in Fahrenheit to Celsius
     */
    private static void questionSeven(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius%n", fahrenheit, celsius);
    }

    /**
     * questionEight() to calculate
     * - the area of a circle
     * - the circumference of a circle
     */
    private static void questionEight(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = 2 * Math.PI * radius;
        System.out.printf("The area of a circle with radius %.2f is %.2f%n", radius, area);
        System.out.printf("The circumference of a circle with radius %.2f is %.2f%n", radius, circumference);
    }

    /**
     * main() to prompt the user for which question that they want to choose,
     * then use the conditional logic to perform the necessary requirements
     * for the question.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nChoose a question to compute:");
            System.out.println("2. The sum, difference, product, and quotient of two numbers");
            System.out.println("5. The area and perimeter of a rectangle");
            System.out.println("7. Convert temperature from Fahrenheit to Celsius");
            System.out.println("8. The area and circumference of a circle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 2:
                    System.out.print("Please enter a number: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Please enter another number: ");
                    int num2 = scanner.nextInt();
                    questionTwo(num1, num2);
                    break;
                case 5:
                    System.out.print("Please enter the length of a rectangle: ");
                    int length = scanner.nextInt();
                    System.out.print("Please enter the width of a rectangle: ");
                    int width = scanner.nextInt();
                    questionFive(length, width);
                    break;
                case 7:
                    System.out.print("Please enter the temperature in degrees Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    questionSeven(fahrenheit);
                    break;
                case 8:
                    System.out.print("Please enter the radius of a circle: ");
                    double radius = scanner.nextDouble();
                    questionEight(radius);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter only 2, 5, 7, 8, or 0.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
