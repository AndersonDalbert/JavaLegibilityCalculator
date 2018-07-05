package sres;
import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Select the mode (D for directory F for file)");
		final String option = sc.next().toLowerCase();
		final String path = sc.next();	
		sc.close();
		
		final File file = new File(path);
		
		try {
			if ( option.equals("d") )  calculateFromDirectory(file);
			else if ( option.equals("f") ) 	calculateFromFile(file);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void calculateFromFile(File file) 
	{
		if ( !file.exists() || !file.isFile() )
			throw new IllegalArgumentException("Invalid file path");
		double calculatedSRES = FileSRESMeasurement.measure(file);
		System.out.println(calculatedSRES);
	}

	private static void calculateFromDirectory(File file) throws Exception 
	{
		if ( !file.exists() || !file.isDirectory() )
			throw new IllegalArgumentException("Invalid directory path");
		double calculatedSRES = DirectorySRESMeasurement.measure(file);
		System.out.println(calculatedSRES);
	}
	
}