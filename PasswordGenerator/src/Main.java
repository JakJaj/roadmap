import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Password password = new Password(true,true,true,true,16);
        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;
        System.out.println("Welcome to the Password Generator!");
        System.out.println("----------------------------------");
        while (appOn) {
            System.out.println("What would you like to do?");
            System.out.println("""
                    1. Show password
                    2. Generate new password
                    3. Show password settings
                    4. Change password settings
                    5. Quit""");
            int initialInput = userInput(5);

            switch (initialInput){
                case 1 -> System.out.println(password.getPassword() + "\n");
                case 2 -> password.randomizePassword();
                case 3 -> System.out.println(password);
                case 4 -> {
                    boolean changingSettings = true;
                    while (changingSettings) {
                        System.out.println("Which setting would you like to switch?");
                        System.out.println("""
                                1. Length
                                2. Upper case letters
                                3. Lower case letters
                                4. Numbers
                                5. Symbols
                                6. Exit""");
                        int input = userInput(6);
                        switch (input){
                            case 1 -> {
                                System.out.println("What would you like you password length to be: ");
                                int newLenght= userInput(Integer.MAX_VALUE);
                                password.setPasswordLength(newLenght);
                            }
                            case 2 -> password.setUpperCase(!password.isUpperCase());
                            case 3 -> password.setLowerCase(!password.isLowerCase());
                            case 4 -> password.setNumbers(!password.isNumbers());
                            case 5 -> password.setSymbols(!password.isSymbols());
                            case 6 -> changingSettings = false;
                        }
                    }
                }
                case 5 -> appOn = false;
            }
        }
        scanner.close();
    }
    public static int userInput(int bound) {
        System.out.println("Pass a number:");
        Scanner scanner = new Scanner(System.in);
        int number = 1;
        while (number > 0 && number <= bound) {
            try {
                number =  Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Pass a number!");
            }
        }
        return 0;
    }
}
