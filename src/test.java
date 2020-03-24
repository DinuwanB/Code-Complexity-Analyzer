import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static  void main(String[] args) {
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = operatorsans(filePath);

        System.out.println("----------------------------------------------------------");
        System.out.println("Operators Result  : "+ result[0]);
        System.out.println("Numerical Value Result  : "+ result[1]);
        System.out.println("String Literal Result  : "+ result[2]);
        System.out.println("Keywords Result  : "+ result[3]);
        System.out.println("Identifiers  : "+ (result[4]+result[5]+result[6]));
        System.out.println("----------------------------------------------------------");
        System.out.println("Class Result  : "+ result[4]);
        System.out.println("Method Result   : "+ result[5]);
        System.out.println("Method Result   : "+ result[6]);

    }
    public static int[] operatorsans(String filePath){

        int opCount = 0;
        int nuVlCount = 0;
        int strLtCount = 0;
        int keywordsCount = 0;
        int classDefObjCount = 0;
        int classCount = 0;
        int methodCount = 0;
        int inForLoopVariablesCount = 0;
        String dinu = "";
        ArrayList<String> readWords = new ArrayList<String>();
        ArrayList<String> iden = new ArrayList<>();
        Matcher match;
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readWords.add(data);
//---------------------------------------------------------------------------------------------------------------------- Operators
                Pattern operatorPattern = Pattern.compile("--|\\+\\+|==|-=|<<|>>|<<<|>>>|->|\\+=|\\*=|/=|&&|&=|%=|>=|<=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|\\|\\||!|\\||\\^|~|\\.|::");
                match = operatorPattern.matcher(data);
                while (match.find()){
                    //System.out.println("Operators  :" + match );
                    opCount++;
                }
//---------------------------------------------------------------------------------------------------------------------- Numerical
                Pattern numericalPattern = Pattern.compile("\\d+(\\.\\d+)?");
                match = numericalPattern.matcher(data);
                while (match.find()){
                    //System.out.println("Numerical Values  :" + match );
                    nuVlCount++;
                }
//---------------------------------------------------------------------------------------------------------------------- String Literals
                Pattern strLiteralPattern = Pattern.compile("\"(.*?)\"");
                match = strLiteralPattern.matcher(data);
                while (match.find()){
                    //System.out.println("String Literal  :" + match );
                    strLtCount++;
                }
//---------------------------------------------------------------------------------------------------------------------- Keywords
                Pattern keywordsPattern = Pattern.compile("abstract|assert|break|class|continue|default|enum|extends|final|finally|implements|import|instanceof|interface|native|new|null|package|private|protected|public|return|static|strictfp|super|synchronized|this|throw|throws|transient|try|void|volatile|else");
                match = keywordsPattern.matcher(data);
                while (match.find()){
                    //System.out.println("String Keywords  :" + match.group() );
                    ++keywordsCount;
                }
//---------------------------------------------------------------------------------------------------------------------- Identifiers
//---------------------------------------------------------------------------------------------------------------------- class Object
                Pattern classObjectDefined = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\([\\w]*?\\)");
                match = classObjectDefined.matcher(data);
                while (match.find()){
                    System.out.println("Defined Object of Class   :" + match.group() );
                    classDefObjCount++;
                }
//---------------------------------------------------------------------------------------------------------------------- Class
                Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+|System|out");
                match = classNamePattern.matcher(data);
                while (match.find()){
                    System.out.println("Class  :" + match.group() );
                    classCount++;
                }
//---------------------------------------------------------------------------------------------------------------------- Methods
                Pattern method = Pattern.compile(".(void|String|int|long|double|float|boolean)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);|println|print");
                match = method.matcher(data);
                while (match.find()){
                    System.out.println("Method Count  :" + match.group() );
                    methodCount++;
                }

                Pattern idnConStruPattern = Pattern.compile("(for).+");
                match = idnConStruPattern.matcher(data);
                while (match.find()){
                    dinu = match.group();
                    iden.add(dinu);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        System.out.println("iden     "+iden);
//        System.out.println( "dinu     "+ dinu);

        ArrayList<String> identWords = new ArrayList<String>();
        for (int counter = 0; counter < iden.size(); counter++) {

            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofForloopVariables.matcher(iden.get(counter));
            while (match.find()){
                System.out.println("Keys ----  " +match.group());
                String words = match.group();
                identWords.add(words);
            }
            identWords.remove("for");
            identWords.remove("int");

        }

        System.out.println(identWords);

        inForLoopVariablesCount = identWords.size();
        System.out.println(identWords);

        //int methodsNum = methodCount - classDefObjCount;
        return new int[] {opCount,nuVlCount,strLtCount,keywordsCount,classCount,methodCount,inForLoopVariablesCount};
    }

}
