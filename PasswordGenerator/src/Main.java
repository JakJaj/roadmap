import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean upperCase = true;
        boolean lowerCase = true;
        boolean numbers = true;
        boolean symbols = true;
        int passwordLength = 16;
        List<Character> allowedCharacters = new ArrayList<>();
        System.out.println("Welcome to the Password Generator!");
        System.out.println("----------------------------------");
        printSettings(passwordLength,upperCase,lowerCase,numbers,symbols);
        allowedCharacters = includedCharacters(upperCase,lowerCase,numbers,symbols);
        String password = "";
        //TODO: SETTINGS MANIPULATION
        // VERY WEAK - WEAK - GOOD - STRONG - VERY STRONG

        for(int i = 0; i < passwordLength; i++){
            Random random = new Random();
            int roll = random.nextInt(allowedCharacters.size());
            password = password.concat(String.valueOf(allowedCharacters.get(roll)));
        }
        System.out.println("Your password: " + password);

    }
    public static void printSettings(int length, boolean upperCase, boolean lowerCase, boolean numbers, boolean symbols){
        System.out.println("Your password settings: ");
        System.out.println("Length: " + length);
        System.out.println("Upper case: " + (upperCase ? "\u2713" : "\u2717"));
        System.out.println("Lower case: " + (lowerCase ? "\u2713" : "\u2717"));
        System.out.println("Numbers: " + (numbers ? "\u2713" : "\u2717"));
        System.out.println("Symbols: " + (symbols ? "\u2713" : "\u2717"));
    }
    public static ArrayList<Character> includedCharacters(boolean upperCase, boolean lowerCase, boolean numbers, boolean symbols){
        List<Character> lowerCaseAlphabet = new ArrayList<>(List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        List<Character> upperCaseAlphabet = new ArrayList<>(List.of('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        List<Character> numbersArray = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6','7', '8','9'));
        List<Character> symbolsArray = new ArrayList<>(List.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')','{','}','[',']','?','/','<','>',';',':','\\','|'));
        ArrayList<Character> passwordIncluded = new ArrayList<>();

        if(upperCase) passwordIncluded.addAll(upperCaseAlphabet);
        if(lowerCase) passwordIncluded.addAll(lowerCaseAlphabet);
        if(numbers) passwordIncluded.addAll(numbersArray);
        if(symbols) passwordIncluded.addAll(symbolsArray);
        return passwordIncluded;
    }
}
