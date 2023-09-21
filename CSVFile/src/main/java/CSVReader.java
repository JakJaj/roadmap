import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----    Welcome to reading csv file program    ----");
        boolean app_on = true;
        while (app_on) {
            System.out.println("Input an absolute path to your csv file: ");
            printCSVFileContent(scanner.nextLine());

            boolean again = true;
            while (again) {
                System.out.println("Would you like to print another file? (Y/N)");
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("no") || decision.equalsIgnoreCase("n")){
                    app_on = false;
                    again = false;
                }
                else if ( !(decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("y"))) {
                    System.out.println("Invalid input");
                }
                else {
                    System.out.println("Here we go again");
                    again = false;
                }
            }
        }

    }

    public static Reader readFile(String filePath){
        try {
            return new FileReader(filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void printCSVFileContent(String filePath) throws IOException {
        List<String> headers = new ArrayList<>();
        Reader reader = readFile(filePath);
        if(reader != null) {

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            CSVRecord headerRow = csvParser.iterator().next();
            for (String header : headerRow) {
                headers.add(header);
            }

            for (CSVRecord csvRecord : csvParser) {
                for (int i = 0; i < csvRecord.size(); i++) {
                    System.out.println(headers.get(i) + ": " + csvRecord.get(i));
                }
            }
        }
        }
}

