import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        System.out.println("Welcome in a number guessing game\n");

        String playAgain = "";

        while (gameOn) {

            int guess = -1;
            int amountOfTries = 0;
            int randomNumber = random.nextInt(1, 51);
            while (guess != randomNumber) {
                System.out.println("Guess a number between 1 and 50");
                System.out.println("Its your " + ++amountOfTries + " guess");

                guess = userInput(1, 50);

                if (guess > randomNumber) System.out.println("Your number is bigger then a number to guess\n");
                else if (guess < randomNumber) System.out.println("Your number is smaller then a number to guess\n");


            }
            System.out.println("You did it!");
            System.out.println("The number was: " + randomNumber);
            System.out.println("It took you " + amountOfTries + " guesses");
            System.out.println("-------------------------------------------");
            System.out.println("Would you like to play again?");

            while (!playAgain.equals("Y") && !playAgain.equals("N")) {
                System.out.println("Type 'Y' or 'N'");
                playAgain = scanner.nextLine().toUpperCase();
            }
            if (playAgain.equals("N")) {
                System.out.println("Thanks for playing!");
                gameOn = false;
            } else {
                System.out.println("Let's play again!\n");
                playAgain = "";
            }
        }
    }

    public static int userInput(int minValue, int maxValue) {

        Scanner scanner = new Scanner(System.in);
        int number = minValue - 1;

        while (number < minValue || number > maxValue) {
            System.out.println("Pass a number between " + minValue + " and " + maxValue);
            try {
                number = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("The value you passed wasn't a number");
                number = minValue - 1;
            }

        }
        return number;
    }
}
