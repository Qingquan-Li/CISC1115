package homework10;

import java.io.File;
import java.io.FileNotFoundException;
// import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Homework10
 * Create a database of TV shows.
 * 
 * Use the classList.txt file to read the TV shows.
 * 
 * Print everything except for prompts to an output file.
 * The output file should be in the following order:
 * - The entire data set, ordered by year
 * - The entire data set, ordered by title
 * - What the most popular show is
 * - The show, country, and ongoing status searched for, and the results of each search
 * - The updated data set, ordered by title
 */
public class Homework10 {

    // Create four parallel arrays to hold each show’s: startYear, title,
    // countryOfOrigin, and endYear (this may be ONGOING) respectively.
    static int[] startYear;
    static String[] title;
    static String[] countryOfOrigin;
    static String[] endYear;

    static int count; // count of the number of shows
    
    public static void main(String[] args) {
        final String INPUT_FILE = "homework10/classList.txt";
        final String OUTPUT_FILE = "homework10/classResults.txt";

        try {
            File file = new File(INPUT_FILE);
            Scanner scanner = new Scanner(file);
            count = 0;
            while (scanner.hasNextLine()) {
                count++;
                scanner.nextLine();
            }
            scanner.close();

            // Initialize the arrays
            startYear = new int[count];
            title = new String[count];
            countryOfOrigin = new String[count];
            endYear = new String[count];

            // Read data into parallel arrays
            readData(INPUT_FILE);

            // Print initial data
            // printData(OUTPUT_FILE, "[Initial Data:]", false);

            // Sort by year
            sortByYear();
            printData(OUTPUT_FILE, "[Sorted by Premiere Year (newest to oldest):]", true);

            // Sort by title
            sortByTitle();
            printData(OUTPUT_FILE, "[Sorted by Title (A-Z):]", true);

            // Remove duplicate shows
            String[] uniqueShows = new String[count];
            int uniqueCount = removeDuplicateShows(count, startYear, title, countryOfOrigin, endYear, uniqueShows);
            FileWriter fileWriter = new FileWriter(OUTPUT_FILE, true);
            fileWriter.write("[Unique Shows:]\n\n");
            for (int i = 0; i < uniqueCount; i++) {
                fileWriter.write(uniqueShows[i] + "\n");
            }
            fileWriter.write("\n");
            fileWriter.close();

            // Find the most popular show
            String mostPopularShow = mostPopular(count, title);
            fileWriter = new FileWriter(OUTPUT_FILE, true);
            fileWriter.write("[Most Popular Show:]\n");
            fileWriter.write(mostPopularShow + "\n\n");
            fileWriter.close();

            // Search by title
            searchByTitle("Game of Thrones", OUTPUT_FILE);
            // Search by country
            searchByCountry("CA", OUTPUT_FILE);
            // Search by ongoing status
            searchByOngoingStatus(OUTPUT_FILE);

            // Add a new show
            // The Night Agent, 2023 - 2023, US
            addShow(OUTPUT_FILE);

        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please check the file path.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred while writing to the file.");
        }

    }

    /**
     * readData() method to populate the arrays from the classList.txt file.
     * The data is in the order of startYear, title, countryOfOrigin,
     * endYear (each piece of data is separated by a comma (',').
     */
    public static void readData(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        
        int index = 0; // index to keep track of the current position in the arrays
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(","); // split the line by comma
            startYear[index] = Integer.parseInt(data[0]);
            title[index] = data[1];
            countryOfOrigin[index] = data[2];
            endYear[index] = data[3];
            index++;
        }
        scanner.close();
    }

    /**
     * printData() method to print a header and the data from the arrays to
     * an output file in a four-column table format:
     * startYear, title, countryOfOrigin, endYear
     */
    public static void printData(String fileName, String header,
            boolean appendToFile) throws IOException {
        // PrintWriter printWriter = new PrintWriter(fileName);
        // PrintWriter cannot append to a file, so use FileWriter
        FileWriter fileWriter = new FileWriter(fileName, appendToFile);
        fileWriter.write(header + "\n\n");
        fileWriter.write(String.format("%-10s %-48s %-15s %s\n", "startYear", "title",
                "countryOfOrigin", "endYear"));
        fileWriter.write(String.format("%-10s %-48s %-15s %s\n", "---------",
                "------------------------------------------------",
                "---------------", "-------"));

        for (int i = 0; i < count; i++) {
            fileWriter.write(String.format("%-10d %-48s %-15s %s\n", startYear[i], title[i],
                    countryOfOrigin[i], endYear[i]));
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    /**
     * Use the selection sort algorithm to sort the data in the following way:
     * Create a method called sortByYear() to sort the data in descending order
     * by startYear.
     * Then in the main method:
     * Call the printData() method to print to file, each with a specific header
     * of how the data is sorted (e.g. “Sorted by Premiere Year (newest to oldest):”).
     */
    public static void sortByYear() {
        for (int i = 0; i < count - 1; i++) {
            int maxIndex = i;
            // Find the index of the maximum element in the unsorted part of the array
            for (int j = i + 1; j < count; j++) {
                if (startYear[j] > startYear[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the first element of the unsorted part
            // only if the maxIndex is different from the current index i
            // to avoid swapping the same element with itself
            if (maxIndex != i) {
                int temp = startYear[i];
                startYear[i] = startYear[maxIndex];
                startYear[maxIndex] = temp;
    
                String tempStr = title[i];
                title[i] = title[maxIndex];
                title[maxIndex] = tempStr;
    
                tempStr = countryOfOrigin[i];
                countryOfOrigin[i] = countryOfOrigin[maxIndex];
                countryOfOrigin[maxIndex] = tempStr;
    
                tempStr = endYear[i];
                endYear[i] = endYear[maxIndex];
                endYear[maxIndex] = tempStr;
            }
        }
    }

    /**
     * Use the bubble sort algorithm to sort the data in the following way:
     * Create a method called sortByTitle() to sort the data in alphabetical
     * order (A-Z) by title.
     * Then in the main method:
     * Call the printData() method again to print to file, each with a specific
     * header of how the data is sorted (e.g. “Sorted by Title (A-Z):”).
     */
    public static void sortByTitle() {
        boolean swapped;
        for (int i = 0; i < count - 1; i++) {
            swapped = false;
            for (int j = 0; j < count - i - 1; j++) {
                // Compare adjacent elements
                // String.compareTo() returns `> 0` if the string is lexicographically
                // greater than the other string (more characters)
                if (title[j].compareTo(title[j + 1]) > 0) {
                    // Swap the elements
                    int temp = startYear[j];
                    startYear[j] = startYear[j + 1];
                    startYear[j + 1] = temp;

                    String tempStr = title[j];
                    title[j] = title[j + 1];
                    title[j + 1] = tempStr;

                    tempStr = countryOfOrigin[j];
                    countryOfOrigin[j] = countryOfOrigin[j + 1];
                    countryOfOrigin[j + 1] = tempStr;

                    tempStr = endYear[j];
                    endYear[j] = endYear[j + 1];
                    endYear[j + 1] = tempStr;

                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop,
            // then the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * removeDuplicateShows() method to remove duplicate shows from the data set.
     * Create a new array to hold each title only once.
     */
    public static int removeDuplicateShows(int numberOfShows, int[] startYear,
            String[] title, String[] countryOfOrigin, String[] endYears,
            String[] uniqueShows) {
        if (title.length == 0 || title.length == 1) {
            return title.length;
        }

        int uniqueCount = 0;
        boolean[] isDuplicate = new boolean[title.length];

        for (int i = 0; i < numberOfShows; i++) {
            if (!isDuplicate[i]) {
                uniqueShows[uniqueCount++] = title[i];
                for (int j = i + 1; j < numberOfShows; j++) {
                    if (!isDuplicate[j] && title[i].equals(title[j])) {
                        if (!countryOfOrigin[i].equals(countryOfOrigin[j])) {
                            uniqueShows[uniqueCount++] = title[j] + " (" + countryOfOrigin[j] + ")";
                        }
                        isDuplicate[j] = true;
                    }
                }
            }
        }

        return uniqueCount;
    }

    /**
     * Create a method called mostPopular() that will answer the following question:
     * what is the most popular show? Then print to the output file. (If more than one
     * show shows up the most, you only need to print the first one encountered.
     */
    public static String mostPopular(int count, String[] title) {
        int maxCount = 0;
        String popularShow = "";
        for (int i = 0; i < count; i++) {
            int currentCount = 1;
            for (int j = i + 1; j < count; j++) {
                if (title[i].equals(title[j])) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                popularShow = title[i];
            }
        }
        return popularShow;
    }

    /**
     * searchByTitle() method to search for a show by title.
     */
    public static void searchByTitle(String searchTitle, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.write("[Search by Title: " + searchTitle + "]\n");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (title[i].equalsIgnoreCase(searchTitle)) {
                fileWriter.write(title[i] + " (" + startYear[i] + ") " + countryOfOrigin[i] + "\n");
                found = true;
            }
        }
        if (!found) {
            fileWriter.write("Unfortunately there is no record of that show in this list.\n");
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    /**
     * searchByCountry() method to search for all shows that have the same country of origin.
     */
    public static void searchByCountry(String searchCountry, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.write("[Search by Country: " + searchCountry + "]\n");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (countryOfOrigin[i].equalsIgnoreCase(searchCountry)) {
                fileWriter.write(title[i] + " (" + startYear[i] + ") " + countryOfOrigin[i] + "\n");
                found = true;
            }
        }
        if (!found) {
            fileWriter.write("Unfortunately there is no record of that show in this list.\n");
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    /**
     * searchByOngoingStatus() method to search for all shows that are currently ongoing.
     */
    public static void searchByOngoingStatus(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.write("[Search by Ongoing Status:]\n");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (endYear[i].equalsIgnoreCase("ONGOING")) {
                fileWriter.write(title[i] + " (" + startYear[i] + ") " + countryOfOrigin[i] + "\n");
                found = true;
            }
        }
        if (!found) {
            fileWriter.write("Unfortunately there is no record of that show in this list.\n");
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    /**
     * addShow() to prompt the user to add a new show to the data:
     * - prompt the user for the show that they would like to add
     * - the show cannot be already on the list BUT can be a remake from a different country
     * - If the show is not already on the list: add title, startYear, endYear (or ONGOING), and countryOfOrigin
     * Then in the main method:
     * Call the printData() method to print the updated data set, ordered by title
     */
    public static void addShow(String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the new show: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter the start year of the new show: ");
        int newStartYear = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter the end year of the new show (or ONGOING): ");
        String newEndYear = scanner.nextLine();
        System.out.print("Enter the country of origin of the new show: ");
        String newCountry = scanner.nextLine();

        scanner.close();

        // Check if the show is already on the list
        for (int i = 0; i < count; i++) {
            if (title[i].equalsIgnoreCase(newTitle) && countryOfOrigin[i].equalsIgnoreCase(newCountry)) {
                System.out.println("This show is already on the list.");
                return;
            }
        }

        // Add the new show to the arrays
        count++;
        startYear = Arrays.copyOf(startYear, count);
        title = Arrays.copyOf(title, count);
        countryOfOrigin = Arrays.copyOf(countryOfOrigin, count);
        endYear = Arrays.copyOf(endYear, count);

        startYear[count - 1] = newStartYear;
        title[count - 1] = newTitle;
        countryOfOrigin[count - 1] = newCountry;
        endYear[count - 1] = newEndYear;

        // Print the updated data
        sortByTitle();
        printData(fileName, "[Updated Data Set:]", true);
    }

}
