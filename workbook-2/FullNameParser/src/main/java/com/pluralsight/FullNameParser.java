package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // This helps us get text typed by the person using the program

        System.out.print("Please enter your name: "); // Ask the user to type their full name
        String fullName = scanner.nextLine().trim(); // Save what they typed and remove extra spaces

        String[] parts = fullName.split(" "); // Break the name into parts wherever there's a space

        String firstName = parts[0]; // The first part is always the first name
        String middleName = "(none)"; // We'll start with no middle name, just in case
        String lastName; // We’ll figure out the last name next

        if (parts.length == 2) {
            // If there are 2 parts, it means there's only a first and last name
            lastName = parts[1]; // So the second part is the last name
        } else if (parts.length == 3) {
            // If there are 3 parts, it means we have first, middle, and last
            middleName = parts[1]; // Second part is middle name
            lastName = parts[2]; // Third part is last name
        } else {
            // If the name doesn't have 2 or 3 parts, it might be typed wrong
            System.out.println("Hmm... that doesn't look like a name I understand.");
            return; // Stop running the program
        }

        // Now we show the pieces of the name
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}
