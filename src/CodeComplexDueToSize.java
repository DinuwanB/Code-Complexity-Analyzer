import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComplexDueToSize {
    public static void main(String[] args) {
        ArrayList<String> readWords = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
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
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                readWords.add(data);

                Matcher mt;
                Pattern p2 = Pattern.compile("[0-9][0-9]*");
                mt = p2.matcher(data);
                int count = 0;
                while (mt.find()) {
                    ++count;
                    System.out.println("Find num  :" + count *5);

                }


            }


            System.out.println(readWords);
            //System.out.println(count);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        numbersCount(readWords);
        my1(readWords,keywords);
        my2(readWords,operators);




    }

    public static void my1(ArrayList<String> readwords, ArrayList<String> keywords){
        System.out.println("my1  "+readwords);
        readwords.retainAll(keywords);
        System.out.println(readwords);
    }

    public static void my2(ArrayList<String> readwords, ArrayList<String> operators){
        System.out.println("my2  " +readwords);
        readwords.retainAll(operators);
        int a = readwords.size();
        System.out.println(readwords);
        System.out.println(a);
    }

    public static void numbersCount(ArrayList<String> readwords){

    }


}



