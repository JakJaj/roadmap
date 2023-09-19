import java.util.ArrayList;
import java.util.List;

public class PasswordCharacters {
    List<Character> lowerCaseAlphabet;
    List<Character> upperCaseAlphabet;
    List<Character> numbersArray;
    List<Character> symbolsArray;
    ArrayList<Character> passwordIncluded = new ArrayList<>();

    public PasswordCharacters(boolean upperCase, boolean lowerCase, boolean numbers, boolean symbols){
        List<Character> lowerCaseAlphabet = new ArrayList<>(List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        List<Character> upperCaseAlphabet = new ArrayList<>(List.of('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        List<Character> numbersArray = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6','7', '8','9'));
        List<Character> symbolsArray = new ArrayList<>(List.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')','{','}','[',']','?','/','<','>',';',':','\\','|'));
        if(upperCase) this.passwordIncluded.addAll(upperCaseAlphabet);
        if(lowerCase) this.passwordIncluded.addAll(lowerCaseAlphabet);
        if(numbers) this.passwordIncluded.addAll(numbersArray);
        if(symbols) this.passwordIncluded.addAll(symbolsArray);

    }
    public ArrayList<Character> getPasswordIncluded() {
        return passwordIncluded;
    }
}
