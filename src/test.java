import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class test {
    public static void main(String[] args) {
        ArrayList<String> readWords = new ArrayList<String>();
        String filePath = "../Dinu/dinu.txt" ;
        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(
                "abstract", "assert", "break", "break", "class", "continue", "default", "enum", "extends", "final",
                "finally", "implements", "import", "instanceof", "instanceof", "interface", "native", "new", "null",
                "package", "private", "protected", "public", "return", "static", "strictfp", "super", "synchronized",
                "this", "throw", "throws", "transient", "try", "void", "volatile", "else"
        ));
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList(
                "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "|", "^",
                "~", "<<", ">>", ">>>", "<<<", "->", ".", "::", "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=",
                "%=", "<<=", ">>=", "^="
        ));

        fileRead(filePath, readWords);


    }

    public static void fileRead(String fileLocation, ArrayList<String> readwords) {
        try {
            File readData = new File(fileLocation);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                readwords.add(data);
            }
            System.out.println(readwords);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
