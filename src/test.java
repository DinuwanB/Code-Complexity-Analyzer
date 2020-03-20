import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        ArrayList<String> readWords = new ArrayList<String>();

        int classcount = 0;
        try {
            Matcher match;
            File readData = new File("../Dinu/dinu.txt");
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println("-----------------------------  " +data);
                readWords.add(data);

//       added         Pattern classObject = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\(\\)");
//                match = classObject.matcher(data);
//                while (match.find()){
//                    System.out.println("String Keywords  :" + match.group() );
//                    readWords.add(match.group());
//                }

//                Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+|System|out|println|print");
//                match = classNamePattern.matcher(data);
//                while (match.find()){
//                    System.out.println("String Keywords  :" + match.group() );
//                    readWords.add(match.group());
//                    System.out.println("Class  :"+ (++classcount) );
//
//                }

//                Pattern methodPattern = Pattern.compile("\\b(public|private|internal|protected)\\s*" + "\\b(static|virtual|abstract)?\\s*[a-zA-Z]*(?<method>\\s[a-zA-Z]+\\s*)+");
//                match = methodPattern.matcher(data);
//                while (match.find()){
//                    System.out.println("String Keywords  :" + match.group() );
//                }

                Pattern method = Pattern.compile(".(void|String|int|long|double|float|boolean)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = method.matcher(data);
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

class Car{
    public static void main(String[]args){

        }
        }



