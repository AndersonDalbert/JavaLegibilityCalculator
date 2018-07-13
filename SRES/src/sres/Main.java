package sres;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the path for the directory which files are going to be measured");
		final String path = sc.next();	
		sc.close();
		
		final File directory = new File(path);
		try {
			calculateSRES(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static double calculateSRES(File directory) throws IOException
	{
		checkInconsistentDirectory(directory);
		SRESMeasurer measurer = new SRESMeasurer(directory.getPath());
		return measurer.measure();
	}

	private static void checkInconsistentDirectory(File directory) throws IOException 
	{
		if ( !directory.exists() || !directory.isDirectory() )
			throw new IllegalArgumentException("Invalid directory path");
		File[] directoryListing = directory.listFiles();	
		if (directoryListing == null) 
			throw new IOException("Directory is empty");
	}
	
}