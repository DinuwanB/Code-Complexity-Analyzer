package com.ITPM.ITPM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	
	 public static int[] MethodController(String filePath) {

	        String methData = "";
	        String forData = "";
	        int primativeReCount = 0;
	        int compositeReCount = 0;
	        int forLoop = 0;
	   	 	int compositeCount = 0;
	   	 	int primativeCount = 0;

	        ArrayList<String> identifyMethodsLine = new ArrayList<String>();
	        ArrayList<String> identifyForLine = new ArrayList<String>();
	        ArrayList<String> primativeTypes = new ArrayList<String>(Arrays.asList("int","long","double","float","boolean","String"));
	        ArrayList<String> compositeTypes = new ArrayList<String>(Arrays.asList("int[]","long[]","double[]","float[]","boolean[]","String[]"));
	        ArrayList<String> forWords = new ArrayList<String>();
	        ArrayList<String> identMethWords = new ArrayList<String>();
	        ArrayList<String> identMethWords2 = new ArrayList<String>();


	        Matcher match;
	        
	        
	        //Multiple files get to File array
	        
	        File folder = new File(filePath);
	        File[] listOfFiles = folder.listFiles();

	        for (File file : listOfFiles) {
	            if (file.isFile()) {
	                System.out.println("**************************-------------"+file.getName());
	                String fname = file.getName();

	                try {
	                    File readData = new File("D:\\Workspace\\23\\"+fname);
	                    
	            Scanner myReader = new Scanner(readData);
	            while (myReader.hasNextLine()) {
	                String data = myReader.nextLine();
	                if (data.contains("//")) {
	                    continue;
	                }

	                if (data.contains("next()")) {
	                    continue;
	                }
	                if (data.contains("parseInt(enteredYear);")) {
	                    continue;
	                }
	                if (data.contains("getMonth();")) {
	                    continue;
	                }
	                if (data.contains("Months();")) {
	                    continue;
	                }
	                if (data.contains("parseInt(enteredMonthNumber);")) {
	                    continue;
	                }
	                if (data.contains("getYear();")) {
	                    continue;
	                }
	                
	                Pattern primitiveReturnType = Pattern.compile("public.(String|int|long|double|float|boolean|char) +.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
	                match = primitiveReturnType.matcher(data);
	                while (match.find()){
	                    System.out.println("primitiveReturnType Method Count  :" + match.group() );
	                    primativeReCount++;
	                }

	                Pattern compositeReturnType = Pattern.compile(".(List<[a-zA-Z]+>|ArrayList<[a-zA-Z]+>|double\\[\\]|int\\[\\]|String\\[\\]|long\\[\\]|float\\[\\]|boolean\\[\\]|char\\[\\]+)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);");
	                match = compositeReturnType  .matcher(data);
	                while (match.find()){
	                    System.out.println("compositeReturnType Method Count  :" + match.group() );
	                    compositeReCount++;
	                }

	                Pattern getMethodLine = Pattern.compile("\\(.+\\)");
	                match = getMethodLine.matcher(data);
	                while (match.find()){
	                    methData = match.group();
	                    identifyMethodsLine.add(methData);
	                    //System.out.println("sex  " +identifyMethodsLine);
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

	        for (int counter = 0; counter < identifyForLine.size(); counter++) {
	            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
	            match = identifyinsideofForloopVariables.matcher(identifyForLine.get(counter));
	            while (match.find()){
	                String words = match.group();
	                forWords.add(words);
	            }
	        }
	        forWords.retainAll(primativeTypes);
	         forLoop = forWords.size();

	        for (int count = 0; count < identifyMethodsLine.size(); count++) {
	            Pattern insideofMethodVariablesPramCom = Pattern.compile("[a-zA-Z]+\\[\\]");
	            match = insideofMethodVariablesPramCom.matcher(identifyMethodsLine.get(count));
	            while (match.find()){
	                String words = match.group();
	                identMethWords.add(words);
	            }
	            Pattern identifyinsideofMethodVariablesPramPri = Pattern.compile("[a-zA-Z]+");
	            match = identifyinsideofMethodVariablesPramPri.matcher(identifyMethodsLine.get(count));
	            while (match.find()){
	                String words2 = match.group();
	                identMethWords2.add(words2);
	            }
	        }
	        identMethWords.retainAll(compositeTypes);
	         compositeCount = identMethWords.size();
	        identMethWords2.retainAll(primativeTypes);
	         primativeCount =  identMethWords2.size();

	            }
	        }
	        return new int[] {primativeReCount,compositeReCount, primativeCount - (forLoop+1), (compositeCount*2)};
	    }

	
}
