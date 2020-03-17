import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CodeComplexDueToSize {
    public static void main(String[] args) {

        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(
                "abstract","assert","break","break" ,"class" ,"continue" ,"default" ,"enum", "extends" ,"final" ,
                "finally" ,"implements" ,"import" ,"instanceof" ,"instanceof" ,"interface", "native", "new", "null" ,
                "package", "private" ,"protected" ,"public", "return" ,"static" ,"strictfp" ,"super" ,"synchronized",
                "this", "throw" , "throws" ,"transient" ,"try" ,"void" ,"volatile", "else"
        ));

        ArrayList<String> operators = new ArrayList<String>(Arrays.asList(
                "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!",  "|", "^",
                "~", "<<", ">>", ">>>", "<<<" , "->", ".", "::", "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=" ,
                "%=", "<<=", ">>=", "^="
        ));

        try {
            File readData = new File("../Dinu/dinu.txt");
            ArrayList<String> readWords = new ArrayList<String>();
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                readWords.add(data);
            }
            myReader.close();

            readWords.retainAll(operators);
            System.out.println(readWords);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}


