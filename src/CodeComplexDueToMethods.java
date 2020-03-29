import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComplexDueToMethods {
    public static void main(String[] args){
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = MethodController(filePath);


    }
    public static int[] MethodController(String filePath) {

        String methData = "";
        String forData = "";

        ArrayList<String> identifyMethodsLine = new ArrayList<String>();
        ArrayList<String> identifyForLine = new ArrayList<String>();


        Matcher match;
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Pattern primitiveReturnType = Pattern.compile(".(String|int|long|double|float|boolean|char)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = primitiveReturnType.matcher(data);
                while (match.find()){
                    System.out.println("primitiveReturnType Method Count  :" + match.group() );

                }

                Pattern compositeReturnType = Pattern.compile(".(List<[a-zA-Z]+>|ArrayList<[a-zA-Z]+>|double\\[\\]|int\\[\\]|String\\[\\]|long\\[\\]|float\\[\\]|boolean\\[\\]|char\\[\\]+)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
                match = compositeReturnType  .matcher(data);
                while (match.find()){
                    System.out.println("compositeReturnType Method Count  :" + match.group() );

                }

                Pattern getMethodLine = Pattern.compile("\\(.+\\)");
                match = getMethodLine.matcher(data);
                while (match.find()){
                    methData = match.group();
                    identifyMethodsLine.add(methData);
                   // System.out.println(identifyMethodsLine);
                }

                Pattern getVarInForLoop = Pattern.compile("(for).+");
                match = getVarInForLoop.matcher(data);
                while (match.find()){
                    forData = match.group();
                    identifyForLine.add(forData);
                }

            }

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ArrayList<String> primativeTypes = new ArrayList<String>(Arrays.asList("int","long","double","float","boolean","String"));
        ArrayList<String> compositeTypes = new ArrayList<String>(Arrays.asList("int[]","long[]","double[]","float[]","boolean[]","String[]"));
        ArrayList<String> forWords = new ArrayList<String>();
        ArrayList<String> identMethWords = new ArrayList<String>();
        ArrayList<String> identMethWords2 = new ArrayList<String>();

        for (int counter = 0; counter < identifyForLine.size(); counter++) {
            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofForloopVariables.matcher(identifyForLine.get(counter));
            while (match.find()){
                String words = match.group();
                forWords.add(words);
            }
        }
        forWords.retainAll(primativeTypes);
        System.out.println("111  :" +forWords.size());


        for (int count = 0; count < identifyMethodsLine.size(); count++) {
            Pattern insideofMethodVariablesPramCom = Pattern.compile("[a-zA-Z]+\\[\\]");
            match = insideofMethodVariablesPramCom.matcher(identifyMethodsLine.get(count));
            while (match.find()){
                String words = match.group();
                identMethWords.add(words);
            }
            Pattern identifyinsideofMethodVariables2 = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofMethodVariables2.matcher(identifyMethodsLine.get(count));
            while (match.find()){
                String words2 = match.group();
                identMethWords2.add(words2);
            }
        }
        identMethWords.retainAll(compositeTypes);
        System.out.println("333  :" +identMethWords);
        identMethWords2.retainAll(primativeTypes);
        System.out.println("444  :" +identMethWords2);


        return null;
    }
}
