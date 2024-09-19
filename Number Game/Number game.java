import java.util.Scanner;
import java.util.Random;

public class EnhancedNumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        int totalScore = 0;

        do {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int numberOfTries = 0;
            int maxAttempts = 7; // Limit of attempts
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Enhanced Number Guessing Game!");
            System.out.println("I've selected a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

            while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int playerGuess = scanner.nextInt();
                numberOfTries++;

                if (playerGuess < 1 || playerGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (playerGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    int score = (maxAttempts - numberOfTries + 1) * 10; // Calculate score
                    totalScore += score; // Update total score
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + numberOfTries + " tries.");
                    System.out.println("Your score for this round: " + score);
                }

                if (numberOfTries >= maxAttempts && !hasGuessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
                }
            }

            // Show total score
            System.out.println("Your total score is: " + totalScore);

            // Prompt to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
