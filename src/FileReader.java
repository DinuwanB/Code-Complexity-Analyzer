import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        try {
            File readData = new File("../Dinu/dinu.txt");
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                System.out.println(data);
            }
            myReader.close();
            System.out.println("----------------End of the reading-----------------");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
