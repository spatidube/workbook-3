import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TheaterReservations {
    public static void main(String[] args) {
        // Create Scanner object to get input from user
        Scanner scanner = new Scanner(System.in);

        // Get the customer's full name
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine().trim();

        // Get the show date
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String dateInput = scanner.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate showDate = LocalDate.parse(dateInput, formatter);

        // Get the number of tickets
        System.out.print("How many tickets would you like? ");
        
        //scanner.nextLine(): This part is asking the user to type something in. The "scanner" is like a tool that listens to what you type and brings it into the program.
        //
        //.trim(): This part is like a cleaner for your input. It removes any extra spaces before or after the text you typed. So if you accidentally typed a space before or after your number, this will remove it.
        //
        //Integer.parseInt(): This takes what you typed (which is a string of characters, like "5") and turns it into a number that the program can do math with (like 5). So, it’s changing the text into a real number.
        //
        //int numTickets: This is the part where the program creates a container called numTickets to hold the number it just turned into. "int" means it's going to store a whole number (like 5, 100, or 23).
        int numTickets = Integer.parseInt(scanner.nextLine().trim());

        // Extract first and last name
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // Format the date
        String formattedDate = showDate.toString(); // ISO format yyyy-MM-dd

        // Display confirmation message
        if (numTickets == 1) {
            System.out.println("1 ticket reserved for " + formattedDate + " under " + lastName + ", " + firstName);
        } else {
            System.out.println(numTickets + " tickets reserved for " + formattedDate + " under " + lastName + ", " + firstName);
        }
    }
}
