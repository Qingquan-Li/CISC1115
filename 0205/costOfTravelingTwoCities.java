import java.util.Scanner;

public class costOfTravelingTwoCities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Name of city A: ");
        String cityA = in.nextLine();

        System.out.print("Name of city B: ");
        String cityB = in.nextLine();

        System.out.print("Distance between the two cities: ");
        double distance = in.nextDouble();

        System.out.print("Per mile cost: ");
        double cost = in.nextDouble();

        double totalCost = distance * cost;
        System.out.println("The cost of traveling from " + cityA + " to " + cityB + " is " + totalCost);

        in.close();
    }
}
