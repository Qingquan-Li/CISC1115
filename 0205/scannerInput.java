import java.util.Scanner;

public class scannerInput {
    public static void main(String[] args) {
        System.out.print("What's your name: ");
        // Create a Scanner object to read input from the keyboard
        Scanner kybd = new Scanner(System.in);
        // Read a line of text from the user
        String name = kybd.nextLine();
        System.out.println("Hi, " + name);
        
        System.out.print("What's your age: ");
        Scanner in = new Scanner(System.in); // System.in is a standard input stream
        int age = in.nextInt();
        System.out.println("You are " + age + " years old.");
        
        // Close the Scanner object
        kybd.close();
        in.close();
    }
}
