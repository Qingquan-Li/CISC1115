package homework6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) throws FileNotFoundException {
        int numberOfClasses;
        String courseName;
        char letterGrade; // letter grade you earned in each of classes
        final double POINT_VALUE_FOR_LETTER_GRADE_A = 4;
        final double POINT_VALUE_FOR_LETTER_GRADE_B = 3;
        final double POINT_VALUE_FOR_LETTER_GRADE_C = 2;
        final double POINT_VALUE_FOR_LETTER_GRADE_D = 1;
        final double POINT_VALUE_FOR_LETTER_GRADE_F = 0;
        int courseCreditsAttempted; // number of credits the course is worth
        double courseGradePoints = 0; // courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE

        int toatlCreditsAttempted = 0; // all courseCreditsAttempted
        double totalGradePoints = 0; // all courseGradePoints you earned
        double gpa = 0; // grade point average
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("homework6/semesterTranscript.txt");

        System.out.print("Enter total number of classes for semester: ");
        numberOfClasses = scanner.nextInt();

        printWriter.println("Current Semester Transcript:");

        for (int i = 0; i < numberOfClasses; i++) {
            scanner.nextLine(); // Consume the newline character
            System.out.print("\nEnter course name: ");
            courseName = scanner.nextLine();
            printWriter.printf("%nCourse: %s%n", courseName);

            System.out.printf("Enter number of credits '%s' is worth: ", courseName);
            courseCreditsAttempted = scanner.nextInt();
            toatlCreditsAttempted += courseCreditsAttempted;
            printWriter.printf("Credits Attempted: %d%n", courseCreditsAttempted);

            System.out.printf("Enter grade received in '%s': ", courseName);
            letterGrade = scanner.next().charAt(0);
            printWriter.printf("Grade Received: %c%n", letterGrade);
            switch (letterGrade) {
                case 'A':
                    courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE_A;
                    break;
                case 'B':
                    courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE_B;
                    break;
                case 'C':
                    courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE_C;
                    break;
                case 'D':
                    courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE_D;
                    break;
                case 'F':
                    courseGradePoints = courseCreditsAttempted * POINT_VALUE_FOR_LETTER_GRADE_F;
                    break;
                default:
                    System.out.println("Invalid value, please enter ONLY A, B, C, D or F");
                    // exit the program
                    System.exit(1);
            }
            totalGradePoints += courseGradePoints;
        }

        gpa = totalGradePoints / toatlCreditsAttempted;
        printWriter.printf("%nGPA: %.2f", gpa);

        scanner.close();
        printWriter.close();
    }
    
}
