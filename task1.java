import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN = 1; 
    private static final int MAX = 100; 
    private static final int MAX_TRIES = 5; 
    private static final int ROUNDS_TO_WIN = 3; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int roundsWon = 0;

        do {
            int targetNumber = random.nextInt(MAX - MIN) + MIN; 
            int attempts = 0;

            System.out.println("Welcome to the number guessing game!");
            System.out.println("Guess a number between " + MIN + " and " + MAX + ".");

            while (attempts < MAX_TRIES) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " tries.");
                    score += MAX_TRIES - attempts; 
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts++;
            }

            if (attempts == MAX_TRIES) {
                System.out.println("Sorry, you ran out of guesses. The number was " + targetNumber + ".");
            }

            System.out.println("Current score: " + score);
            System.out.println("Rounds won: " + roundsWon);

            System.out.print("Do you want to play again? (y/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("y") && roundsWon < ROUNDS_TO_WIN);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
