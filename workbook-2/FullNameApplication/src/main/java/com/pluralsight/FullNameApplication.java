package com.pluralsight; // This is like the folder where our program lives

import java.util.Scanner; // This lets us ask the user questions and get their answers

public class FullNameApplication { // This is the name of our program
    public static void main(String[] args) { // This is where our program starts
        Scanner scanner = new Scanner(System.in); // We make a "scanner" to read what the user types

        // Ask the user to tell us their name
        System.out.println("Please enter your name");

        // Ask for the first name
        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim(); // Read what they type and remove extra spaces

        // Ask for the middle name
        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim(); // Same thing for middle name

        // Ask for the last name
        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim(); // And again for last name

        // Ask for a suffix (like Jr., Sr., III, etc.)
        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim(); // Read suffix and remove spaces

        // Now we put all the pieces of the name together
        StringBuilder fullName = new StringBuilder(); // We use this to build the full name like LEGO bricks
        fullName.append(firstName); // Start with the first name

        if (!middleName.isEmpty()) { // If there is a middle name (not blank)
            fullName.append(" ").append(middleName); // Add a space and the middle name
        }

        fullName.append(" ").append(lastName); // Add a space and the last name

        if (!suffix.isEmpty()) { // If the suffix is not blank
            fullName.append(", ").append(suffix); // Add a comma and the suffix (like Jr.)
        }

        // Show the full name to the user
        System.out.println("Full name: " + fullName); // Print the final result
    }
}
