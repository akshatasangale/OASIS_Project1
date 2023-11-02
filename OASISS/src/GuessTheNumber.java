import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + " - Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
            } else {
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
        }

        scanner.close();
    }
}
