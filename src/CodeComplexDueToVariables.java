import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CodeComplexDueToVariables {
    public static void main (String[] args){
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = VariableController(filePath);
    }

    public static int[] VariableController(String filePath){
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            System.out.println("here"+myReader);
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
