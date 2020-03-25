import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CodeComplexDueToMethods {
    public static void main(String[] args){
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = MethodController(filePath);
    }
    public static int[] MethodController(String filePath) {
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("An error occurred.");
        System.out.println("An error occurred.");
        System.out.println("An error occurred.");
        System.out.println("An error occurred.");
        return null;
    }
}
