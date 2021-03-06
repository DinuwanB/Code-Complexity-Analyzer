package com.ITPM.ITPM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {
	
//	public String Size1() {
//		
//		String s1= SizeF(null, null, null, null, null);
//		return s1;
//		
//	}
	
	/*
	 * 1. Multiple Files Reading Method
	 * 2. Get Files Name and Return that names.
	 * 
	 */
	public static String FileMultiple() {
		
		String fname = null;
		
		String filePath = "D:\\Workspace\\23\\";
		
		File folder = new File(filePath);
	    File[] listOfFiles = folder.listFiles();

	    for (File file : listOfFiles) {
	        if (file.isFile()) {
	            System.out.println("**************************-------------"+file.getName());
	            fname = file.getName();
	        }
	    }
	    System.out.println(fname);
	    
	    return fname;
	}
	
	/*
	 * 1. Define Size Calculation Method
	 * 2. Define Variables
	 * 3. Call Multiple Files Read method
	 * 4. Using Regular Expression Catch and calculate Factors.
	 * 5. Return Output Table
	 * 
	 */
	 
	public static String SizeF() {
		
//		int keyword1 = Integer.parseInt(keyword);
//	    int identifier1 = Integer.parseInt(identifier);
//	    int operator1 = Integer.parseInt(operator);
//	    int numericalvalue1 = Integer.parseInt(numericalvalue);
//	    int stringliteral1 = Integer.parseInt(stringliteral);
		
		
		String fname = FileMultiple();
		
		String output = "";
		
		int opCount = 0;
        int nuVlCount = 0;
        int strLtCount = 0;
        int keywordsCount = 0;
        int classDefObjCount = 0;
        int classCount = 0;
        int methodCount = 0;
        String varData = "";
        int prist = 0;
        int inForLoopVariablesCount = 0;
        int calc = 0;
        
        Matcher match;

        ArrayList<String> identifiresofforloop = new ArrayList<String>();
        ArrayList<String> insideprintSt = new ArrayList<String>();
        
        try {
            File readData = new File("D:\\Workspace\\23\\"+fname);
            
            //Reading each file
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                //skip comment lines
                if (data.contains("//")) {
                    continue;
                }
                
                //RegX Pattern for find size factor functions
                
                Pattern operatorPattern = Pattern.compile("--|\\+\\+|==|-=|<<|>>|<<<|>>>|->|\\+=|\\*=|/=|&&|&=|%=|>=|<=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|\\|\\||!|\\||\\^|~|\\.|::");
                match = operatorPattern.matcher(data);
                while (match.find()) {
                    //System.out.println("Operators  :" + match.group() );
                    opCount++;
                }

                Pattern numericalPattern = Pattern.compile("\\d+(\\.\\d+)?");
                match = numericalPattern.matcher(data);
                while (match.find()) {
                    //System.out.println("Numerical Values  :" + match );
                    nuVlCount++;
                }

                Pattern strLiteralPattern = Pattern.compile("\"(.*?)\"");
                match = strLiteralPattern.matcher(data);
                while (match.find()) {
                    // System.out.println("String Literal  :" + match );
                    strLtCount++;
                }

                Pattern keywordsPattern = Pattern.compile("abstract|assert|break|class|continue|default|enum|extends|final|finally|implements|import|instanceof|interface|native|new|null|package|private|protected|public|return|static|strictfp|super|synchronized|this|throw|throws|transient|try|void|volatile|else");
                match = keywordsPattern.matcher(data);
                while (match.find()) {
                    //System.out.println("String Keywords  :" + match.group() );
                    ++keywordsCount;
                }

                Pattern classObjectDefined = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\([\\w]*?\\)");
                match = classObjectDefined.matcher(data);
                while (match.find()) {
                    // System.out.println("Defined Object of Class   :" + match.group() );
                    classDefObjCount++;
                }

                Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+");
                match = classNamePattern.matcher(data);
                while (match.find()) {
                    //System.out.println("Class  :" + match.group() );
                    classCount++;
                }

                Pattern classNamePattern2 = Pattern.compile("(class)+.[a-zA-Z]+(extends)+.");
                match = classNamePattern2.matcher(data);
                while (match.find()) {
                    // System.out.println("Class2  :" + match.group() );
                    classCount++;
                }

                Pattern method = Pattern.compile(".(void)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);|println|print");
                match = method.matcher(data);
                while (match.find()) {
                    //System.out.println("Method Count  :" + match.group() );
                    methodCount++;
                }

                Pattern getVarInForLoop = Pattern.compile("(for).+");
                match = getVarInForLoop.matcher(data);
                while (match.find()) {
                    varData = match.group();
                    identifiresofforloop.add(varData);
                }

                Pattern getMethodLine = Pattern.compile("(|print|println)+\\(.+\\)");
                match = getMethodLine.matcher(data);
                while (match.find()) {
                    insideprintSt.add(match.group());
                }

                Pattern printstat = Pattern.compile("(System|out|print|println)");
                match = printstat.matcher(data);
                while (match.find()) {
                   // System.out.println("print sta " + match.group());
                    prist++;
                }

                // System.out.println(prist);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
     // identify for loops inside variables
        
        ArrayList<String> identWords = new ArrayList<String>();
        for (int counter = 0; counter < identifiresofforloop.size(); counter++) {
            Pattern identifyinsideofForloopVariables = Pattern.compile("[a-zA-Z]+");
            match = identifyinsideofForloopVariables.matcher(identifiresofforloop.get(counter));
            while (match.find()) {
                String words = match.group();
                identWords.add(words);
            }
            identWords.remove("for");
            identWords.remove("int");
            identWords.remove("double");
            identWords.remove("long");
        }
        // System.out.println("+++++++ "+identWords);
        // System.out.println("******* "+insideprintSt);
        ArrayList<String> insidepri = new ArrayList<String>();
        for (int count = 0; count < insideprintSt.size(); count++) {
            Pattern insideofrint = Pattern.compile("[a-zA-Z]+");
            match = insideofrint.matcher(insideprintSt.get(count));
            while (match.find()) {
                String words = match.group();
                insidepri.add(words);
            }
        }
        insidepri.retainAll(identWords);
        calc = insidepri.size();


        inForLoopVariablesCount = identWords.size();

        // int methodsNum = methodCount - classDefObjCount;
        //System.out.println(classCount + prist);
        
        int classPrist = (classCount+prist+methodCount + inForLoopVariablesCount + calc);
        
        int s1 = (keywordsCount ) ; //* keyword1
        int s2 = (classPrist ) ; //* identifier1
        int s3 = (opCount ) ; //* operator1
        int s4 = (nuVlCount ) ; //* numericalvalue1
        int s5 = (strLtCount ); //* stringliteral1
    
    output = "<table class=\"table table-striped table-dark\"> <thead> <tr> <th scope=\"col\"> Due to Size</th><th scope=\"col\">Values</th>"
			+"</tr> </thead>";;
			
			output += "<tr>";
			output += "<th>Keywords</th>";
			output += "<td>" +  s1+ "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Identifiers</th>";
			output += "<td>" + s2 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Operators</th>";
			output += "<td>" + s3 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Numerical Values</th>";
			output += "<td>" + s4 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>String Literals</th>";
			output += "<td>" + s5 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Cs</th>";
			output += "<td>" +(s1+s2+s3+s4+s5) + "</td>";
			output += "</tr>";

        
		return output;
	}

	/*
	 * 1. Define Variable Calculation Method
	 * 2. Define Variables
	 * 3. Call Multiple Files Read method
	 * 4. Using Regular Expression Catch and calculate Factors.
	 * 5. Return Output Table
	 * 
	 */

	public static String Variables() {
		
//		int globalv1 = Integer.parseInt(globalv);
//	    int localv1 = Integer.parseInt(localv);
//	    int primitive1 = Integer.parseInt(primitive);
//	    int composite1 = Integer.parseInt(composite);
	   
	    
		String fname = FileMultiple();
		
		String output = "";
		
		String forData = "";
        int primeVariable = 0;
        int primeVariabl2 = 0;
        int compoVariable = 0;
        int compoVariable2 = 0;

        ArrayList<String> identifyForLine = new ArrayList<String>();
        ArrayList<String> forWords = new ArrayList<String>();
        ArrayList<String> primativeTypes = new ArrayList<String>(Arrays.asList("int","long","double","float","boolean","String"));

        Matcher match;
        try {
            File readData = new File("D:\\Workspace\\23\\"+fname);
            Scanner myReader = new Scanner(readData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("//")) {
                    continue;
                }
                if (data.contains("print(")) {
                    continue;
                }
                if (data.contains("println(")) {
                    continue;
                }
                if (data.contains("getMonth(")) {
                    continue;
                }
                if (data.contains("getYear(")) {
                    continue;
                }
                //System.out.println(data);
                Pattern primitiveVaribale = Pattern.compile(".(String|int|long|double|float|boolean|char).+[a-zA-Z].=.[a-zA-Z0-9]");
                match = primitiveVaribale.matcher(data);
                while (match.find()){
                    System.out.println("primitiveReturnType Variable Count  :" + match.group());
                    primeVariable++;
                }

                Pattern primitiveVaribale2 = Pattern.compile("(String|int|long|double|float|boolean|char).+[a-zA-Z]");
                match = primitiveVaribale2.matcher(data);
                while (match.find()){
                    //System.out.println("primitiveReturnType Variable Count 210  :" + match.group());
                    primeVariabl2++;
                }

                Pattern compositeVariable = Pattern.compile("(List<[a-zA-Z]+>|ArrayList<[a-zA-Z]+>|(double\\[\\]|int\\[\\]|String\\[\\]|long\\[\\]|float\\[\\]|boolean\\[\\]|char\\[\\])).+[a-zA-Z].=.[a-zA-Z0-9]");
                match = compositeVariable.matcher(data);
                while (match.find()){
                    //System.out.println("  :" + match.group());
                    compoVariable++;
                }

                Pattern compositeVariable2 = Pattern.compile("(double\\[\\]|int\\[\\]|String\\[\\]|long\\[\\]|float\\[\\]|boolean\\[\\]|char\\[\\])");
                match = compositeVariable2.matcher(data);
                while (match.find()){
                    //System.out.println("  :" + match.group());
                    compoVariable2++;
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

        int primat = (primeVariable+primeVariabl2);
        int compot = (compoVariable+compoVariable2)*2;

        output = "<table class=\"table table-striped table-dark\"> <thead> <tr> <th scope=\"col\"> Due to Variables</th><th scope=\"col\">Values</th>"
    			+"</tr> </thead>";;
    			
    			output += "<tr>";
    			output += "<th>Variable Scope</th>";
    			output += "<td>" +"Cannot Get Value :-(" + "</td>";
    			output += "</tr>";
    			output += "<tr>";
    			output += "<th>Primitive Variables</th>";
    			output += "<td>" +primat + "</td>";
    			output += "</tr>";
    			output += "<tr>";
    			output += "<th>Composite Variables</th>";
    			output += "<td>" +compot + "</td>";
    			output += "</tr>";
    			output += "<tr>";
    			output += "<th>Cv</th>";
    			output += "<td>" +(compot+primat) + "</td>";
    			output += "</tr>";
    			

            
    		return output;
		
	}
	
	/*
	 * 1. Define Methods Calculation Method
	 * 2. Define Variables
	 * 3. Call Multiple Files Read method
	 * 4. Using Regular Expression Catch and calculate Factors.
	 * 5. Return Output Table
	 * 
	 */

	public static String Methods() {
		
		String fname = FileMultiple();
		String output = "";
		
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

    int m1 = (primativeReCount+compositeReCount);
    int m2 = (primativeCount - (forLoop+1));
    int m3 = (compositeCount*2);
    int m4 = (m1+m2+m3);
 output = "<table class=\"table table-striped table-dark\"> <thead> <tr> <th scope=\"col\"> Due to Methods</th><th scope=\"col\">Values</th>"
			+"</tr> </thead>";;
			
			output += "<tr>";
			output += "<th>Method Return Type</th>";
			output += "<td>" + m1 +"</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Primitive Data Type Parameters</th>";
			output += "<td>" + m2 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Composite Data Type Parameters</th>";
			output += "<td>" + m3 + "</td>";
			output += "</tr>";
			output += "<tr>";
			output += "<th>Cm</th>";
			output += "<td>" + m4 + "</td>";
			output += "</tr>";
			

     
		return output;
		
	}
}
       

