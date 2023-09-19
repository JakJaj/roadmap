import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Password {
    private String password;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean numbers;
    private boolean symbols;
    private int passwordLength;
    private PasswordCharacters allowedCharacters;

    @Override
    public String toString() {
        return "Your password settings \n" +
            "Length: " + getPasswordLength() + "\n" +
            "Upper case: " + (isUpperCase() ? "\u2713" : "\u2717") + "\n" +
            "Lower case: " + (isLowerCase() ? "\u2713" : "\u2717") + "\n" +
            "Numbers: " + (isNumbers() ? "\u2713" : "\u2717") + "\n" +
            "Symbols: " + (isSymbols() ? "\u2713" : "\u2717") + "\n";

    }
    public String getPassword() {
        return password;
    }
    public Password(boolean upperCase, boolean lowerCase, boolean numbers, boolean symbols, int passwordLength) {
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
        this.numbers = numbers;
        this.symbols = symbols;
        this.passwordLength = passwordLength;
        randomizePassword();
    }


    public void randomizePassword(){
        Random random = new Random();
        this.allowedCharacters = new PasswordCharacters(isUpperCase(), isLowerCase(), isNumbers(), isSymbols());
        List<Character> characters = allowedCharacters.getPasswordIncluded();
        String tempPassword = "";
        for(int i = 0; i< passwordLength;i++) {
            String randomCharacter = String.valueOf(characters.get(random.nextInt(characters.size())));
            tempPassword = tempPassword.concat(randomCharacter);
        }
        this.password = tempPassword;
    }
    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        if(!(isSymbols() || isLowerCase() || isNumbers())){
            System.out.println("Turning off all settings is forbidden");
        }
        else this.upperCase = upperCase; }

    boolean isLowerCase() {
        return lowerCase;
    }
    public void setLowerCase(boolean lowerCase) {
        if(!(isSymbols() || isUpperCase() || isNumbers())){
            System.out.println("Turning off all settings is forbidden");
        }
        else this.lowerCase = lowerCase;
    }
    boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        if(!(isSymbols() || isLowerCase() || isUpperCase())){
            System.out.println("Turning off all settings is forbidden");
        }
        else this.numbers = numbers;
    }

    boolean isSymbols() {
        return symbols;
    }

    void setSymbols(boolean symbols) {
        if(!(isUpperCase() || isLowerCase() || isNumbers())){
            System.out.println("Turning off all settings is forbidden");
        }
        else this.symbols = symbols;
    }

    private int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        if(passwordLength < 1){
            System.out.println("You used number that is below zero");
            System.out.println("Password length is set to 1");
            this.passwordLength = 1;
        }
        else this.passwordLength = passwordLength;
    }
}
