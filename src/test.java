import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

        test cls = new test();
        Class c = cls.getClass();

        Method[] m = c.getDeclaredMethods();
        for(int i = 0; i < m.length; i++) {
            System.out.println("method = " + m[i].toString());
        }


        try {
            File readData = new File("../Dinu/dinu.txt");
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println("-----------------------------  " +data);
                readWords.add(data);

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }






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



