import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComplexDueToMethods {
    public static void main(String[] args){
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = MethodController(filePath);
    }
    public static int[] MethodController(String filePath) {

        Matcher match;
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern primitiveReturnType = Pattern.compile(".(String|int|long|double|float|boolean|char)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = primitiveReturnType.matcher(data);
                while (match.find()){
                    System.out.println("Method Count  :" + match.group() );

                }

                Pattern compositeReturnType = Pattern.compile(".(String|int|long|double|float|boolean|char)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = compositeReturnType.matcher(data);
                while (match.find()){
                    System.out.println("Method Count  :" + match.group() );

                }

            }

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
