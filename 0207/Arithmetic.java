import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        long num1, num2;

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        num1 = in.nextLong();
        System.out.print("Please enter another number: ");
        num2 = in.nextLong();

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));

        in.close();
    }
}
