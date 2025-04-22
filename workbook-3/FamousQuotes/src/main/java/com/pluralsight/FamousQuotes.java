import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        String[] quotes = {
                "Do or do not. There is no try.",
                "Be yourself; everyone else is already taken.",
                "The only way out is through.",
                "You miss 100% of the shots you don't take.",
                "Stay hungry, stay foolish.",
                "Simplicity is the ultimate sophistication.",
                "The best way to predict the future is to invent it.",
                "In the middle of difficulty lies opportunity.",
                "Life is what happens when you're busy making other plans.",
                "Happiness depends upon ourselves."
        };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Pick a quote (1-10): ");
            int choice = scanner.nextInt();
            System.out.println(quotes[choice - 1]);
        } catch (Exception e) {
            System.out.println("Oops! That number is out of range!");
        }

        scanner.close();
    }
}
