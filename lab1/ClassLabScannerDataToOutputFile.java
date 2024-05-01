package lab1;

/**
 * Modify questions: 2, 5, 7, and 8 from Week 1 (you can merge all of these
 * into one main method, just use proper labels) to:
 * - use a Scanner to read in data
 * - write to an output file
 * - and use printf methods to format the output (limit any decimal places to two)
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClassLabScannerDataToOutputFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        // PrintWriter pw = new PrintWriter("classLabOputFile.txt");
        PrintWriter pw = new PrintWriter("lab1/classLabOputFile.txt");

        pw.println("Question 2:");
        // Create TWO integer variables to the values of your choice
        // (e.g. 4 and 5, 12 and 10, etc.) and computes and prints the following:
        // the sum of the two numbers
        // the difference between the two numbers
        // the product of the two numbers
        // the quotient of the two numbers
        int num1, num2;
        System.out.print("Please enter a number: ");
        num1 = in.nextInt();
        System.out.print("Please enter another number: ");
        num2 = in.nextInt();

        pw.printf("The sum of %d and %d is %d%n", num1, num2, num1 + num2);
        pw.printf("The difference between %d and %d is %d%n", num1, num2, num1 - num2);
        pw.printf("The product of %d and %d is %d%n", num1, num2, num1 * num2);
        pw.printf("The quotient of %d and %d is %.2f%n", num1, num2, (double) num1 / num2);
        pw.println("======================================");

        pw.println("Question 5:");
        // Write a Java program to print the area and perimeter of a rectangle.
        // initialize two integer variables:
        // one for length
        // one for width
        // compute the formula for area: a = wl
        // compute the formula for perimeter: p = 2(l+w)
        // print and label the results

        int length, width, area, perimeter;
        System.out.print("\nPlease enter the length of a rectangle: ");
        length = in.nextInt();
        System.out.print("Please enter the width of a rectangle: ");
        width = in.nextInt();

        area = length * width;
        perimeter = 2 * (length + width);
        pw.printf("The area of a rectangle with length %d and width %d is %d%n", length, width, area);
        pw.printf("The perimeter of a rectangle with length %d and width %d is %d%n", length, width, perimeter);
        pw.println("======================================");

        pw.println("Question 7:");
        // Write a Java program to convert temperature from Fahrenheit to Celsius
        // degrees.
        // Temperature in degrees Celsius (°C) = (Temperature in degrees Fahrenheit (°F)
        // - 32) * 5/9

        double fahrenheit, celsius;
        System.out.print("\nPlease enter the temperature in degrees Fahrenheit (°F): ");
        fahrenheit = in.nextDouble();
        celsius = (fahrenheit - 32) * ((double) 5 / 9);
        pw.printf("%.2f °F in degrees Celsius (°C) is %.2f%n", fahrenheit, celsius);

        pw.println("======================================");

        pw.println("Question 8:");
        // Write a Java program that initializes the radius of a circle
        // and computes and prints the circle's area and circumference (perimeter).
        // Formula for area: πr^2
        // Formula for circumference (perimeter): 2πr

        double radius, areaOfCircle, circumference;
        System.out.print("\nPlease the radius of a circle: ");
        radius = in.nextDouble();
        areaOfCircle = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;
        pw.printf("The area of a circle with radius %.2f is %.2f%n", radius, areaOfCircle);
        pw.printf("The circumference of a circle with radius %.2f is %.2f%n", radius, circumference);

        pw.close();
        in.close();
    }

}
