package com.ITPM.ITPM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	
	String Upload_Directory = "D:\\Workspace\\23\\dinu2.java";
	
	public static int[] operatorsans(String Upload_Directory) {

		int opCount = 0;
		int nuVlCount = 0;
		int strLtCount = 0;
		int keywordsCount = 0;
		int classDefObjCount = 0;
		int classCount = 0;
		int methodCount = 0;
		String varData = "";
		int prist = 0;

		ArrayList<String> identifiresofforloop = new ArrayList<String>();
		ArrayList<String> insideprintSt = new ArrayList<String>();

		Matcher match;

		try {
			File readData = new File(Upload_Directory);
			Scanner myReader = new Scanner(readData);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.contains("//")) {
					continue;
				}

				Pattern operatorPattern = Pattern.compile(
						"--|\\+\\+|==|-=|<<|>>|<<<|>>>|->|\\+=|\\*=|/=|&&|&=|%=|>=|<=|<<=|>>=|\\^=|\\+|-|=|\\*|/|%|!=|>|>>>=|\\|=|<|\\|\\||!|\\||\\^|~|\\.|::");
				match = operatorPattern.matcher(data);
				while (match.find()) {
					// System.out.println("Operators :" + match.group() );
					opCount++;
				}

				Pattern numericalPattern = Pattern.compile("\\d+(\\.\\d+)?");
				match = numericalPattern.matcher(data);
				while (match.find()) {
					// System.out.println("Numerical Values :" + match );
					nuVlCount++;
				}

				Pattern strLiteralPattern = Pattern.compile("\"(.*?)\"");
				match = strLiteralPattern.matcher(data);
				while (match.find()) {
					// System.out.println("String Literal :" + match );
					strLtCount++;
				}

				Pattern keywordsPattern = Pattern.compile(
						"abstract|assert|break|class|continue|default|enum|extends|final|finally|implements|import|instanceof|interface|native|new|null|package|private|protected|public|return|static|strictfp|super|synchronized|this|throw|throws|transient|try|void|volatile|else");
				match = keywordsPattern.matcher(data);
				while (match.find()) {
					// System.out.println("String Keywords :" + match.group() );
					++keywordsCount;
				}

				Pattern classObjectDefined = Pattern.compile("[^a-zA-Z]+.([\\w_-]+).=.new.[a-zA-Z]+\\([\\w]*?\\)");
				match = classObjectDefined.matcher(data);
				while (match.find()) {
					// System.out.println("Defined Object of Class :" + match.group() );
					classDefObjCount++;
				}

				Pattern classNamePattern = Pattern.compile("(class)+.[a-zA-Z]+");
				match = classNamePattern.matcher(data);
				while (match.find()) {
					// System.out.println("Class :" + match.group() );
					classCount++;
				}

				Pattern classNamePattern2 = Pattern.compile("(class)+.[a-zA-Z]+(extends)+.");
				match = classNamePattern2.matcher(data);
				while (match.find()) {
					// System.out.println("Class2 :" + match.group() );
					classCount++;
				}

				Pattern method = Pattern
						.compile(".(void)+.[a-zA-Z][a-zA-Z0-9]+\\(|[\\w_]+\\([a-zA-Z]*?\\);|println|print");
				match = method.matcher(data);
				while (match.find()) {
					// System.out.println("Method Count :" + match.group() );
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
					System.out.println("print sta " + match.group());
					prist++;
				}

				// System.out.println(prist);
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
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
		int calc = insidepri.size();

		int inForLoopVariablesCount = identWords.size();

		// int methodsNum = methodCount - classDefObjCount;
		System.out.println(classCount + prist);
		return new int[] { opCount, nuVlCount, strLtCount, keywordsCount, classCount + prist, methodCount,
				inForLoopVariablesCount + calc };
	}
}
