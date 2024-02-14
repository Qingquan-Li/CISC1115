import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework2Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        final double INTEREST_RATE = 0.0231;
        double principal;
        double year;
        double amount;
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter("interest.txt");

        System.out.print("Enter current principal being invested in the savings account: ");
        principal = in.nextDouble();
        System.out.print("Enter number of years that the money will remain in the savings account: ");
        year = in.nextDouble();

        // amount = p(1 + r)^t. p stands for the initial principal,
        // r is the rate, and t is the number of years.
        amount = principal * (Math.pow((1 + INTEREST_RATE), year));

        pw.printf("Total amount calculated WITH interst: $%.2f", amount);

        in.close();
        pw.close();
    }
}
