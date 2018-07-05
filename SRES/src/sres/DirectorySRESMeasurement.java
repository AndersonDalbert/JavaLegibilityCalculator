package sres;
import java.io.File;

public class DirectorySRESMeasurement {

	public static double measure(File directory) throws Exception 
	{	
		File[] directoryListing = directory.listFiles();	
		if (directoryListing == null) throw new Exception("Directory is empty");
		
		int fileCount = directoryListing.length;
		double totalSRES = 0;
		for (File file : directoryListing) {
			totalSRES = totalSRES + FileSRESMeasurement.measure(file);
		}
		
		return totalSRES / fileCount;
	}
	
}
