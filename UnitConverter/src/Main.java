import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to unit converter app!");
        System.out.println("------------------------------");
        boolean app_on = true;
        while (app_on) {
            System.out.println("Pick a category:");
            System.out.println("""
                    1. Length
                    2. Time
                    3. Temperature
                    4. Mass
                    5. Exit""");
            int unitPicked = pickUnit();
            
            switch (unitPicked) {
                case 1 -> {
                    System.out.println("1");
                }
                case 2 -> {
                    System.out.println("2");
                }
                case 3 -> {
                    System.out.println("3");
                }
                case 4 -> {
                    System.out.println("4");
                }
                case 5 -> {
                    System.out.println("5");
                    app_on = false;
                }
                default -> {
                    System.out.println("Invalid number!");
                }
            }
        }
        scanner.close();
    }

    public static int pickUnit(){
        System.out.println("Pass a number:");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pass a number!");
            }
        }
    }
}