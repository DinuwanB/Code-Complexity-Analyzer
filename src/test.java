import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class test {
    public static  void main(String[] args) {
        String filePath = "../Dinu/dinu.txt" ;
        ArrayList<String> keywordsAnalyzer = new ArrayList<String>();
        ArrayList<String> operatorAnalyzer = new ArrayList<String>();

        keywordsAnalyzer  = ReadClass(filePath);
        operatorAnalyzer  = ReadClass(filePath);

        keywordsans(keywordsAnalyzer);
        operatorsans(operatorAnalyzer);

    }

    public static ArrayList<String> ReadClass(String filePath) {
        ArrayList<String> readWords = new ArrayList<String>();
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                readWords.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return readWords;
    }

    public static int keywordsans(ArrayList<String> readWords){
        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(
                "abstract", "assert", "break", "break", "class", "continue", "default", "enum", "extends", "final", "finally", "implements", "import", "instanceof", "instanceof", "interface", "native", "new", "null", "package", "private", "protected", "public", "return", "static", "strictfp", "super", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "else"
        ));
        readWords.retainAll(keywords);
        int keywordsCount = readWords.size();
        System.out.println(readWords);
        System.out.println(keywordsCount);
        return keywordsCount;
    }

    public static int operatorsans(ArrayList<String> readWords){
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList(
                "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "|", "^", "~", "<<", ">>", ">>>", "<<<", "->", ".", "::", "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^="
        ));
        readWords.retainAll(operators);
        int OperatorsCount = readWords.size();
        System.out.println(readWords);
        System.out.println(OperatorsCount);
        return OperatorsCount;
    }
}
