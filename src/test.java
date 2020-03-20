import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        ArrayList<String> readWords = new ArrayList<String>();
        try {
            Matcher match;
            File readData = new File("../Dinu/dinu.txt");
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println("-----------------------------  " +data);
                readWords.add(data);

                Pattern classObject = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\(\\)");
                match = classObject.matcher(data);
                while (match.find()){
                    System.out.println("String Keywords  :" + match.group() );
                    readWords.add(match.group());
                }

                Pattern classPattern = Pattern.compile("(class)+.[a-zA-Z]+");
                match = classPattern.matcher(data);
                while (match.find()){
                    System.out.println("String Keywords  :" + match.group() );
                    readWords.add(match.group());
                }

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



