import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts= 0;
            int maxattempts= 10; // Limit the number of attempts
            boolean GuessedCorrectly = false;

            System.out.println(" ********************* Guessing Game ********************* ");
            System.out.println("I have selected a number between 1 and 100 ");
            System.out.println("You have " + maxattempts + " attempts to guess it ");

            while (attempts < maxattempts && !GuessedCorrectly) {
                System.out.print("Enter your guess : ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < 1 || userGuess > 100) {

                    System.out.println("Please guess a number between 1 and 100.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low .... Try again ");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high .... Try again ");
                } else {
                    GuessedCorrectly = true;
                    System.out.println(" Congratulations , You've guessed the number in " + attempts + " attempts ");
                }
            }

            if (!GuessedCorrectly) {
                System.out.println(" Sorry , You've used all your attempts. The number was :  " + numberToGuess);
            }

            System.out.print(" Do you want to play again (yes/no) : ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println(" Thank you for playing ");
    
    }
}