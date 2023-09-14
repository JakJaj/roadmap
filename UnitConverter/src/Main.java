import java.util.ArrayList;
import java.util.List;
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
                    ArrayList<String> lengthUnits = new ArrayList<>(List.of("Millimeter","Centimeter", "Meter", "Kilometer","Go back"));
                    System.out.println("----    Length    ----");
                    for(int i = 0; i < lengthUnits.size(); i++){
                        System.out.println((i + 1) + ". " + lengthUnits.get(i));
                    }
                    int baseMagnitude = magnitude(5,true);
                    if(baseMagnitude == lengthUnits.size()) break;
                    int endMagnitude = magnitude(5,false);
                    if(endMagnitude == lengthUnits.size()) break;
                    System.out.println("Converting #" + lengthUnits.get(baseMagnitude -1) + " ---> #" + lengthUnits.get(endMagnitude -1));

                    System.out.println("Pass the amount of " + lengthUnits.get(baseMagnitude -1 ) + "s:");
                    double amount = pickUnit();
                    System.out.println(amount + " " + lengthUnits.get(baseMagnitude -1 ) + "s ---> " + lengthConversion(baseMagnitude,endMagnitude,amount) + " " + lengthUnits.get(endMagnitude -1) + "s");

                }
                case 2 -> {
                    ArrayList<String> timeUnits = new ArrayList<>(List.of("Millisecond","Second", "Minute", "Hour","Day","Week","Go back"));
                    System.out.println("----    Time    ----");
                    for(int i = 0; i < timeUnits.size(); i++){
                        System.out.println((i + 1) + ". " + timeUnits.get(i));
                    }
                    int baseMagnitude = magnitude(timeUnits.size(),true);
                    if(baseMagnitude == timeUnits.size()) break;
                    int endMagnitude = magnitude(timeUnits.size(),false);
                    if(endMagnitude == timeUnits.size()) break;
                    System.out.println("Converting #" + timeUnits.get(baseMagnitude -1) + " ---> #" + timeUnits.get(endMagnitude -1));

                    System.out.println("Pass the amount of " + timeUnits.get(baseMagnitude -1 ) + "s:");
                    double amount = pickUnit();
                    System.out.println(amount + " " + timeUnits.get(baseMagnitude -1 ) + "s ---> " + timeConversion(baseMagnitude,endMagnitude,amount) + " " + timeUnits.get(endMagnitude -1) + "s");

                }
                case 3 -> {
                    System.out.println("----   Temperature    ----");
                }
                case 4 -> {
                    System.out.println("----   Mass    ----");
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
    public static double lengthConversion( int baseMagnitude, int endMagnitude, double baseAmount){
        switch (baseMagnitude) {
            case 1 -> {//mm
                if (endMagnitude == 1) return baseAmount;
                if (endMagnitude == 2) return baseAmount / 10;
                if (endMagnitude == 3) return baseAmount / 1000;
                if (endMagnitude == 4) return baseAmount / 1000000;
            }
            case 2 -> {//cm
                if (endMagnitude == 1) return baseAmount * 10;
                if (endMagnitude == 2) return baseAmount;
                if (endMagnitude == 3) return baseAmount / 100;
                if (endMagnitude == 4) return baseAmount / 100000;
            }
            case 3 -> {//m
                if (endMagnitude == 1) return baseAmount * 1000;
                if (endMagnitude == 2) return baseAmount * 100;
                if (endMagnitude == 3) return baseAmount;
                if (endMagnitude == 4) return baseAmount / 1000;
            }
            case 4 -> {//km
                if (endMagnitude == 1) return baseAmount * 1000000;
                if (endMagnitude == 2) return baseAmount * 100000;
                if (endMagnitude == 3) return baseAmount * 1000;
                if (endMagnitude == 4) return baseAmount;
            }
        }
        return 0;
    }
    public static double timeConversion( int baseMagnitude, int endMagnitude, double amount){

        switch (baseMagnitude){

            case 1 ->{
            }
            case 2 -> {

            }
            case 3 -> {
            }

            case 4 -> {
            }
        }
        return 0;
    }
    public static double temperatureConversion( int baseMagnitude, int endMagnitude){

        switch (baseMagnitude){

            case 1 ->{
            }
            case 2 -> {

            }
            case 3 -> {
            }

            case 4 -> {
            }
        }
        return 0;
    }
    public static double massConversion( int baseMagnitude, int endMagnitude){

        switch (baseMagnitude){

            case 1 ->{
            }
            case 2 -> {

            }
            case 3 -> {
            }

            case 4 -> {
            }
        }
        return 0;
    }
    public static int magnitude(int possibleMagnitude, boolean baseFlag){
        int baseMagnitude = -1;
        while (baseMagnitude < 0 || baseMagnitude > possibleMagnitude){
            System.out.println("Pick a " + (baseFlag ? "base" : "end")  + " magnitude: ");
            baseMagnitude = pickUnit();
        }
        return baseMagnitude;
    }


}
