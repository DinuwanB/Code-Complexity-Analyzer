import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CodeComplexDueToSize {
    public static  void main(String[] args) {
        String filePath = "../Dinu/dinu.txt" ;
        ArrayList<String> keywordsAnalyzer = new ArrayList<String>();

        //keywordsAnalyzer  = ReadClass(filePath);
        int result[] = operatorsans(filePath);


        System.out.println("Main Class Result 1 : "+result[0]);
        System.out.println("Main Class Result 2 : "+result[1]);
        System.out.println("Main Class Result 2 : "+result[2]);
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

    public static int[] operatorsans(String filePath){
        ArrayList<String> readWords = new ArrayList<>();
        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(
                "abstract", "assert", "break", "break", "class", "continue", "default", "enum", "extends", "final", "finally", "implements", "import", "instanceof", "instanceof", "interface", "native", "new", "null", "package", "private", "protected", "public", "return", "static", "strictfp", "super", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "else"
        ));
        int opCount = 0;
        int nuVlCount = 0;
        int strLtCount = 0;
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            Matcher match;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern operatorPattern = Pattern.compile("--|\\+\\+|==|-=|\\+=|\\*=|/=|&&|&=|%=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|>=|<=|\\|\\||!|\\||\\^|~|<<|>>|<<<|>>>|->|\\.|::");
                match = operatorPattern.matcher(data);
                while (match.find()){
                    //System.out.println("Operators  :" + match );
                    opCount++;
                }

                Pattern numericalPattern = Pattern.compile("\\d+(\\.\\d+)?");
                match = numericalPattern.matcher(data);
                while (match.find()){
                    //System.out.println("Numerical Values  :" + match );
                    nuVlCount++;
                }

                Pattern strLiteralPattern = Pattern.compile("\"(.*?)\"");
                match = strLiteralPattern.matcher(data);
                while (match.find()){
                    //System.out.println("String Literal  :" + match );
                    strLtCount++;
                }

                Pattern keywordsPattern = Pattern.compile("[a-zA-Z]+");
                match = keywordsPattern.matcher(data);
                while (match.find()){
                    //System.out.println("String Keywords  :" + match.group() );
                    readWords.add(match.group());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(readWords);
        readWords.retainAll(keywords);
        int keywordsCount = readWords.size();
        System.out.println(readWords);
        System.out.println(keywordsCount);
        return new int[] {opCount,nuVlCount,strLtCount};
    }

}
