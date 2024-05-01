package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        int totalGroups = 0;
        int validGroups = 0;
        int invalidGroups = 0;

        try {
            File file = new File("lab3/scores.txt");
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter("lab3/output.txt");

            // hasNextInt() returns true if the next token is an int
            while (scanner.hasNextInt()) {
                int score1 = scanner.nextInt();
                int score2 = scanner.nextInt();
                int score3 = scanner.nextInt();

                totalGroups++;

                if (validGroup(score1, score2, score3, writer)) {
                    validGroups++;
                    oneGameScore(score1, writer);
                    oneGameScore(score2, writer);
                    oneGameScore(score3, writer);

                    int avg = avg3Scores(score1, score2, score3);
                    writer.println("Average score: " + avg);

                    oneGameScore(avg, writer);

                    // Print three blank lines
                    writer.println();
                    writer.println();
                    writer.println();
                } else {
                    invalidGroups++;
                    // Print three blank lines
                    writer.println();
                    writer.println();
                    writer.println();
                }
            }

            // Print counters
            writer.println("The total number of groups processed: " + totalGroups);
            writer.println("The number of valid groups: " + validGroups);
            writer.println("The number of invalid groups: " + invalidGroups);

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please check the file path.");
        } catch (Exception e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean validGroup(int score1, int score2, int score3, PrintWriter writer) {
        boolean isValid = true;
        if (!isValidScore(score1)) {
            writer.println("Invalid score " + score1 + ": score must be between 0 and 300.");
            isValid = false;
        }
        if (!isValidScore(score2)) {
            writer.println("Invalid score " + score2 + ": score must be between 0 and 300.");
            isValid = false;
        }
        if (!isValidScore(score3)) {
            writer.println("Invalid score " + score3 + ": score must be between 0 and 300.");
            isValid = false;
        }

        if (isValid) {
            writer.println("Valid group: " + score1 + ", " + score2 + ", " + score3);
        } else {
            writer.println("Invalid group detected.");
        }
        return isValid;
    }

    private static boolean isValidScore(int score) {
        return score >= 0 && score <= 300;
    }

    private static void oneGameScore(int score, PrintWriter writer) {
        String rating;
        if (score >= 250) {
            rating = "professional game";
        } else if (score >= 200) {
            rating = "an excellent game";
        } else if (score >= 140) {
            rating = "a very good game";
        } else if (score >= 100) {
            rating = "a good game";
        } else if (score >= 50) {
            rating = "a poor game";
        } else {
            rating = "a horrible game";
        }
        writer.println("Score " + score + " is " + rating);
    }

    private static int avg3Scores(int score1, int score2, int score3) {
        return (score1 + score2 + score3) / 3;
    }
}
