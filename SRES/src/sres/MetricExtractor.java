package sres;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MetricExtractor {
	
	private String filePath;
	
	public MetricExtractor(String filePath) throws IOException {
		this.filePath = filePath;
		runLexicalTools();
	}
	
	public double asl() throws IOException {
		runASLScript();
		String awl = readFile("./../../out/asl.txt");
		return Double.parseDouble(awl);
	}
	
	public double awl() throws IOException {
		runAWLScript();
		String awl = readFile("./../../out/awl.txt");
		return Double.parseDouble(awl);
	}
	
	private String readFile(String filepath) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(filepath));
		StringBuilder sb = new StringBuilder();
		while(in.hasNext()) {
		    sb.append(in.next());
		}
		in.close();
		return sb.toString();
	}
	
	private void runASLScript() throws IOException {
		Runtime.getRuntime().exec("python3 ./../../scripts/asl_script.py");
	}
	
	private void runAWLScript() throws IOException {
		Runtime.getRuntime().exec("python3 ./../../scripts/awl_script.py");
	}
	
	private void runLexicalTools() throws IOException {
		runVocabularyExtractor();
		runTermsCounter();		
	}
	
	private void runVocabularyExtractor() throws IOException {
		String command = "java -jar ./../../jar/VocabularyExtractor.jar -loc h i a p -d " + this.filePath
				+ "-n Project -r Revision -vxl ./../../out/result.vxl -csv ./../../out/result.csv -mth -msr";
		Runtime.getRuntime().exec(command);
	}

	private void runTermsCounter() throws IOException {
		String command = "java --add-modules java.xml.bind -jar ./../../jar/TermsCounter.jar -prop ./../../res/termsCounter_file.properties "
				+ "-vxl ./../../out/result.vxl -csv ./../../out/csv_result_file.csv -txt ./../../out/txt_result_file.txt";
		Runtime.getRuntime().exec(command);
	}

}
