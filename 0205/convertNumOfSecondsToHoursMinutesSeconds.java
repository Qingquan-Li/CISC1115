import java.util.Scanner;

public class convertNumOfSecondsToHoursMinutesSeconds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // System.in is a standard input stream

        System.out.print("Enter the number of seconds: ");
        int numOfSeconds = in.nextInt();

        int hours = numOfSeconds / 3600; // 4000 / 3600 = 1h
        int minutes = (numOfSeconds % 3600) / 60; // 4000 % 3600 = 400s / 60s = 6min
        int secondes = (numOfSeconds % 3600) % 60; // 4000 % 3600 = 400s % 60s = 40s

        // calculate the result
        // and use printf to display the output
        // For example:
        // "5000 seconds = 1 hours, 23 minutes, and 20 seconds".

        // printf(String format, datatype args)
        // %[flags][width][.precision]conversion-character
        // System.out.printf("Hello %s, age %d\n", name, age);
        System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds.%n",
                            numOfSeconds,
                            hours,
                            minutes,
                            secondes
        );

        in.close();
    }
}
