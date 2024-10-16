package com.codsoft.intern;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int userGuess;
	private static String playAgain;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 3;
        int score = 0;

        System.err.println(" ********* Welcome To Number Guessing Game **************");
        
        String playAgain = "y";  // initialize playAgin to "y" to start the loop Again

        do {
            for (int round = 1; round <= rounds; round++) {
                int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;

                System.out.println("\nRound " + round);
                System.out.println("Guess a number between " + minRange + " and " + maxRange + 
                		". You have " + maxAttempts + " attempts.");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        score++;
                        break; // Exit the loop if the guess is correct
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low! Try again.\n");
                    } else {
                        System.out.println("Too high! Try again.\n");
                    }
                }

                if (attempts == maxAttempts && userGuess != randomNumber) {
                    System.out.println("Sorry, you ran out of attempts. The number was: " + randomNumber);
                }
            }

            System.out.println("\nGame over! Your final score is: " + score);

            // Ask for play again option
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y")); // Continue playing if user enters 'y' (case-insensitive)

        System.out.println("Thanks for playing!");
        scanner.close(); // Close the scanner resource
    }
}