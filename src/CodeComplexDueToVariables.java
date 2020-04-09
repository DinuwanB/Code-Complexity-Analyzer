import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComplexDueToVariables {
    public static void main (String[] args){
        String filePath = "../Dinu/dinu.txt" ;

        int result[] = VariableController(filePath);
    }

    public static int[] VariableController(String filePath){
        String forData = "";
        ArrayList<String> identifyForLine = new ArrayList<String>();
        ArrayList<String> forWords = new ArrayList<String>();
        ArrayList<String> primativeTypes = new ArrayList<String>(Arrays.asList("int","long","double","float","boolean","String"));

        Matcher match;
        try {
            File readData = new File(filePath);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("//")) {
                    continue;
                }
                //System.out.println(data);
                Pattern primitiveVaribale = Pattern.compile("(String|int|long|double|float|boolean|char).+[a-zA-Z].=.[a-zA-Z0-9]");
                match = primitiveVaribale.matcher(data);
                while (match.find()){
                    System.out.println("primitiveReturnType Variable Count  :" + match.group());
                }

                Pattern compositeVariable = Pattern.compile("(List<[a-zA-Z]+>|ArrayList<[a-zA-Z]+>|double\\[\\]|int\\[\\]|String\\[\\]|long\\[\\]|float\\[\\]|boolean\\[\\]|char\\[\\]).+[a-zA-Z].=.[a-zA-Z0-9]");
                match = compositeVariable.matcher(data);
                while (match.find()){

                }

                Pattern getVarInForLoop = Pattern.compile("(for).+");
                match = getVarInForLoop.matcher(data);
                while (match.find()){
                    forData = match.group();
                    identifyForLine.add(forData);
                }

            }

        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int counter = 0; counter < identifyForLine.size(); counter++) {
            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofForloopVariables.matcher(identifyForLine.get(counter));
            while (match.find()){
                String words = match.group();
                forWords.add(words);
            }
        }
        forWords.retainAll(primativeTypes);
        int forLoop = forWords.size();
        System.out.println(forLoop);

        return null;
    }
}
