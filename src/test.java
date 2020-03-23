import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static  void main(String[] args) {
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = operatorsans(filePath);


        System.out.println("Operators Result  : "+ result[0]);
        System.out.println("Numerical Value Result  : "+ result[1]);
        System.out.println("String Literal Result  : "+ result[2]);
        System.out.println("Keywords Result  : "+ result[3]);
        System.out.println("Class Result  : "+ result[4]);
        System.out.println("Method Result   : "+ result[5]);
    }

    public static ArrayList<String> ReadClass(String filePath) {
        ArrayList<String> readWords = new ArrayList<String>();
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                if(data == "for"){
                    readWords.add(data);
                }
                System.out.println(readWords);

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return readWords;
    }

    public static int[] operatorsans(String filePath){

        int opCount = 0;
        int nuVlCount = 0;
        int strLtCount = 0;
        int keywordsCount = 0;
        int classDefObjCount = 0;
        int classCount = 0;
        int methodCount = 0;

        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            Matcher match;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern operatorPattern = Pattern.compile("--|\\+\\+|==|-=|<<|>>|<<<|>>>|->|\\+=|\\*=|/=|&&|&=|%=|>=|<=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|\\|\\||!|\\||\\^|~|\\.|::");
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

                Pattern keywordsPattern = Pattern.compile("abstract|assert|break|class|continue|default|enum|extends|final|finally|implements|import|instanceof|interface|native|new|null|package|private|protected|public|return|static|strictfp|super|synchronized|this|throw|throws|transient|try|void|volatile|else");
                match = keywordsPattern.matcher(data);
                while (match.find()){
                    //System.out.println("String Keywords  :" + match.group() );
                    ++keywordsCount;
                }

                Pattern classObjectDefined = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\([\\w]*?\\)");
                match = classObjectDefined.matcher(data);
                while (match.find()){
                    System.out.println("Defined Object of Class   :" + match.group() );
                    classDefObjCount++;
                }

                Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+|System|out|println|print");
                match = classNamePattern.matcher(data);
                while (match.find()){
                    System.out.println("Class  :" + match.group() );
                    classCount++;
                }

                Pattern method = Pattern.compile(".(void|String|int|long|double|float|boolean)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = method.matcher(data);
                while (match.find()){
                    System.out.println("Method Count  :" + match.group() );
                    methodCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int methodsNum = methodCount - classDefObjCount;
        return new int[] {opCount,nuVlCount,strLtCount,keywordsCount,classCount,methodsNum};
    }

}
