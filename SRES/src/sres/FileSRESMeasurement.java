package sres;
import java.io.File;

public class FileSRESMeasurement {

	public static double measure(File file) {
		
		MetricExtractor extractor = new MetricExtractor(file);
		double asl = extractor.asl();		
		double awl = extractor.awl();
		
		return asl - 0.1 * awl;
	}

}
