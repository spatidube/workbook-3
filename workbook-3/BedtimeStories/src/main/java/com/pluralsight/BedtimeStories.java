package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // for getting user input

        System.out.print("Enter the name of a story (like goldilocks.txt): ");
        String fileName = input.nextLine(); // gets the name they type

        File storyFile = new File(fileName); // points to the file

        try {
            Scanner fileScanner = new Scanner(storyFile); // tries to open the file

            int lineNumber = 1; // start at line 1

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // read one line
                System.out.println(lineNumber + ". " + line); // print with line number
                lineNumber++; // add one to the line number
            }

            fileScanner.close(); // close the file when done
        } catch (FileNotFoundException e) {
            System.out.println("Oops! That file was not found. Check the name and try again.");
        }

        input.close(); // close the user input scanner
    }
}
