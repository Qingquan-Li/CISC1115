import java.util.Scanner;

public class ScannerInput {

    public static void main(String[] args) {
        int val;

        System.out.print("Please enter an integer: ");

        Scanner stdin = new Scanner(System.in);
        val = stdin.nextInt();

        System.out.println("Your input is " + val);

        stdin.close();
    }
}
