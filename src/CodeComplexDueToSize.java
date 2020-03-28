import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComplexDueToSize {
    public static  void main(String[] args) {
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = operatorsans(filePath);

        System.out.println("Operators Result  : "+ result[0]);
        System.out.println("Numerical Value Result  : "+ result[1]);
        System.out.println("String Literal Result  : "+ result[2]);
        System.out.println("Keywords Result  : "+ result[3]);
        System.out.println("Identifiers  : "+ (result[4]+result[5]+result[6]));
        System.out.println("CSV  : "+ (result[4]+ result[0]+ result[1]+ result[2]+result[3]+result[5]+result[6]));

    }

    public static int[] operatorsans(String filePath){

        int opCount = 0;
        int nuVlCount = 0;
        int strLtCount = 0;
        int keywordsCount = 0;
        int classDefObjCount = 0;
        int classCount = 0;
        int methodCount = 0;
        String varData = "";

        ArrayList<String> identifiresofforloop = new ArrayList<String>();

        Matcher match;

        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
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

                Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+|System|out");
                match = classNamePattern.matcher(data);
                while (match.find()){
                   // System.out.println("Class  :" + match.group() );
                    classCount++;
                }

                Pattern method = Pattern.compile(".(void|String|int|long|double|float|boolean)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);|println|print");
                match = method.matcher(data);
                while (match.find()){
                    //System.out.println("Method Count  :" + match.group() );
                    methodCount++;
                }

                Pattern getVarInForLoop = Pattern.compile("(for).+");
                match = getVarInForLoop.matcher(data);
                while (match.find()){
                    varData = match.group();
                    identifiresofforloop.add(varData);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ArrayList<String> identWords = new ArrayList<String>();
        for (int counter = 0; counter < identifiresofforloop.size(); counter++) {
            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofForloopVariables.matcher(identifiresofforloop.get(counter));
            while (match.find()){
                String words = match.group();
                identWords.add(words);
            }
            identWords.remove("for");
            identWords.remove("int");
            identWords.remove("double");
            identWords.remove("long");
        }
        System.out.println("123-  "+identWords);
        int inForLoopVariablesCount = identWords.size();

       // int methodsNum = methodCount - classDefObjCount;
        return new int[] {opCount,nuVlCount,strLtCount,keywordsCount,classCount,methodCount,inForLoopVariablesCount};
    }

}
