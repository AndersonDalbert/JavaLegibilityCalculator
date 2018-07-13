package sres;

import java.io.IOException;

public class SRESMeasurer {

	private String directoryPath;
	public SRESMeasurer(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public double measure() throws IOException {
		MetricExtractor extractor = new MetricExtractor(this.directoryPath);
		double asl = extractor.asl();		
		double awl = extractor.awl();
		
		return asl - 0.1 * awl;
	}
}
