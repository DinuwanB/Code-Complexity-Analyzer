import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        ArrayList<String> readWords = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(
                "abstract","assert","break" ,"class" ,"continue" ,"default" ,"enum", "extends" ,"final" ,
                "finally" ,"implements" ,"import" ,"instanceof" ,"instanceof" ,"interface", "native", "new", "null" ,
                "package", "private" ,"protected" ,"public", "return" ,"static" ,"strictfp" ,"super" ,"synchronized",
                "this", "throw" , "throws" ,"transient" ,"try" ,"void" ,"volatile", "else","catch", "true", "else", "default", "return", "null", "this"
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
                String data = myReader.nextLine();
//                System.out.println("-----------------------------  " +data);
                readWords.add(data);
                CharSequence cs = readWords.toString();
                //System.out.println(cs);
                Matcher mt;

                Pattern p = Pattern.compile("\"(.*?)\"");
                mt = p.matcher(data);
                while (mt.find()) {
                     System.out.println("What is this : "+ mt);
                }

                Pattern p2 = Pattern.compile("\\d+");
                mt = p2.matcher(data);
                int count = 0;
                while (mt.find()) {

                    // System.out.println("Find num  :"+ mt );
                }
                /**/


                Pattern p3 = Pattern.compile("--|\\+\\+|==|-=|\\+=|\\*=|/=|&&|&=|%=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|>=|<=|\\|\\||!|\\||\\^|~|<<|>>|<<<|>>>|->|\\.|::");
                mt = p3.matcher(data);
                count = 0;
                while (mt.find()) {
                   // System.out.println("Find 3  :" + mt );
                }
                //System.out.println(readWords );
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //numbersCount(readWords);
        //my1(readWords,keywords);
        //my2(readWords,operators);




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


}



