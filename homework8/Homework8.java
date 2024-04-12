package homework8;

import java.util.Scanner;

/**
 * A program that gives an estinmate to a customer on how much carpet would
 * cost for a room.
 */
public class Homework8 {

    /**
     * printMenu() to welcome the user to the store
     * and displays the menu for the carpet types.
     */
    private static void printMenu() {
        System.out.println("Welcome to the carpet store!");
        System.out.println("=== Carpet Types ===");
        System.out.println("1. Nylon: $5 per square foot");
        System.out.println("2. Polyester: $4 per square foot");
        System.out.println("3. Polypropylene: $3 per square foot");
        System.out.println("4. Acrylic: $6 per square foot");
        System.out.println("5. Wool: $12 per square foot");
    }

    /**
     * calculateCost() to receive the user’s selection and the dimensions of
     * their room and calculates and returns the cost
     */
    private static double calculateCost(int carpetType, int length, int width) {
        double cost = 0;
        double area = length * width;
        switch (carpetType) {
            case 1:
                cost = area * 5;
                break;
            case 2:
                cost = area * 4;
                break;
            case 3:
                cost = area * 3;
                break;
            case 4:
                cost = area * 6;
                break;
            case 5:
                cost = area * 12;
                break;
            default:
                System.out.println("Invalid carpet type");
                break;
        }
        return cost;
    }

    /**
     * printReceipt() to print a receipt containing all the necessary
     * information (carpet type, room dimensions, total cost, etc.)
     */
    private static void printReceipt(int carpetType, int length, int width, double cost) {
        System.out.println("\n=== Receipt ===");
        System.out.println("You chose option: ");
        switch (carpetType) {
            case 1:
                System.out.println("1. Nylon: $5 per square foot");
                break;
            case 2:
                System.out.println("2. Polyester: $4 per square foot");
                break;
            case 3:
                System.out.println("3. Polypropylene: $3 per square foot");
                break;
            case 4:
                System.out.println("4. Acrylic: $6 per square foot");
                break;
            case 5:
                System.out.println("5. Wool: $12 per square foot");
                break;
            default:
                System.out.println("Invalid carpet type. Please enter only 1-5.");
                break;
        }
        System.out.println("\nRoom dimensions: " + length + " x " + width);
        System.out.println("Area: " + length * width + " square ft");
        System.out.println("==============================");
        System.out.println("Total cost: $" + cost);
        System.out.println("Thank you for shopping at the Carpet Store!");
    }

    /**
     * A main method that calls the printMenu() method to display the menu
     * and then  prompts the user for their selection and their room
     * dimensions and determines the cost by calling the calculateCost() method
     * and then neatly prints everything at the end by calling printReceipt(). 
     * @param args
     */
    public static void main(String[] args) {
        final int COST_NYLON = 5;
        final int COST_POLYESTER = 4;
        final int COST_POLYPROPYLENE = 3;
        final int COST_ACRYLIC = 6;
        final int COST_WOOL = 12;
        int carpetType;
        int length; // The length of the room
        int width; // The width of the room
        double cost; // The cost of the carpet
        Scanner Scanner = new Scanner(System.in);

        // Display the menu
        printMenu();

        // Prompt the user for their selection
        System.out.print("\nEnter the number of the type of carpet would you like: ");
        carpetType = Scanner.nextInt();

        // Prompt the user for the room dimensions
        System.out.println("\nGreat! Please enter the dimensions of your room (in ft): ");
        System.out.print("Enter length: ");
        length = Scanner.nextInt();
        System.out.print("Enter width: ");
        width = Scanner.nextInt();

        // Calculate the cost
        cost = calculateCost(carpetType, length, width);
        
        // Print the receipt
        printReceipt(carpetType, length, width, cost);

        Scanner.close();
    }
    
}