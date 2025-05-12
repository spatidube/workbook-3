import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the game score
        System.out.print("Please enter a game score: ");
        String input = scanner.nextLine().trim();  // Read and remove extra spaces

        // Split the input into teams and scores
        String[] parts = input.split("\\|");  // Split by the pipe character
        String[] teams = parts[0].split(":");  // Split team names by colon

        // Extract the teams and scores
        String homeTeam = teams[0];
        String visitorTeam = teams[1];
        String[] scores = parts[1].split(":");  // Split the scores by colon
        int homeScore = Integer.parseInt(scores[0]);
        int visitorScore = Integer.parseInt(scores[1]);

        // Determine the winner based on the scores
        if (homeScore > visitorScore) {
            System.out.println("Winner: " + homeTeam);  // Home team wins
        } else if (visitorScore > homeScore) {
            System.out.println("Winner: " + visitorTeam);  // Visitor team wins
        } else {
            System.out.println("It's a tie!");  // In case of a tie
        }
    }
}
