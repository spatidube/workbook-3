import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("goldilocks.txt ");
        String fileName = inputScanner.nextLine();

        File storyFile = new File(fileName); // Assumes the file is in the project directory

        try {
            Scanner fileScanner = new Scanner(storyFile);
            int lineNumber = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        inputScanner.close();
    }
}
