import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// 1. Prompt the user for each patient’s weight
// 2. Write output to a text file titled: “dosageLog.txt”

public class Homework2Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        double weightInPound;
        double weightInKilogram;
        final double RATE_OF_POUNT_TO_KILOGRAMS = 0.45359237;
        double dosage; // mg
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter("dosageLog.txt");

        pw.println("Medical Dosage Log:\n");

        System.out.print("Please enter patient1's weight: "); // 140
        weightInPound = in.nextDouble();
        weightInKilogram = weightInPound * RATE_OF_POUNT_TO_KILOGRAMS;
        dosage = 30 * weightInKilogram;
        pw.println("Patient 1:");
        pw.println("Weight: " + weightInPound + "lbs");
        pw.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        pw.printf("Required Dosage: %.2f mg%n%n", dosage);

        System.out.print("Please enter patient2's weight: "); // 200
        weightInPound = in.nextDouble();
        weightInKilogram = weightInPound * RATE_OF_POUNT_TO_KILOGRAMS;
        dosage = 30 * weightInKilogram;
        pw.println("Patient 2:");
        pw.println("Weight: " + weightInPound + "lbs");
        pw.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        pw.printf("Required Dosage: %.2f mg%n%n", dosage);

        System.out.print("Please enter patient3's weight: "); // 100
        weightInPound = in.nextDouble();
        weightInKilogram = weightInPound * RATE_OF_POUNT_TO_KILOGRAMS;
        dosage = 30 * weightInKilogram;
        pw.println("Patient 3:");
        pw.println("Weight: " + weightInPound + "lbs");
        pw.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        pw.printf("Required Dosage: %.2f mg", dosage);

        in.close();
        pw.close();
    }
}
