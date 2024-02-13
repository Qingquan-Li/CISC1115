package homework1;

public class Homework1 {

    public static void main(String[] args) {
        System.out.println("Medical Dosage Log:\n");

        double weightInPound;
        double weightInKilogram;
        double dosage; // mg

        weightInPound = 140;
        weightInKilogram = weightInPound * 0.45359237;
        dosage = 30 * weightInKilogram;
        System.out.println("Patient 1:");
        System.out.println("Weight: " + weightInPound + "lbs");
        System.out.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        System.out.printf("Required Dosage: %.2f mg%n%n", dosage);

        weightInPound = 200;
        weightInKilogram = weightInPound * 0.45359237;
        dosage = 30 * weightInKilogram;
        System.out.println("Patient 2:");
        System.out.println("Weight: " + weightInPound + "lbs");
        System.out.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        System.out.printf("Required Dosage: %.2f mg%n%n", dosage);

        weightInPound = 100;
        weightInKilogram = weightInPound * 0.45359237;
        dosage = 30 * weightInKilogram;
        System.out.println("Patient 3:");
        System.out.println("Weight: " + weightInPound + "lbs");
        System.out.printf("Converted to kilos: %.2f kg%n", weightInKilogram);
        System.out.printf("Required Dosage: %.2f mg%n%n", dosage);
    }
}
