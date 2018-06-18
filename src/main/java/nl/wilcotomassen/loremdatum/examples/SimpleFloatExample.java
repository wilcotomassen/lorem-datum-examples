package nl.wilcotomassen.loremdatum.examples;
import nl.wilcotomassen.loremdatum.examples.util.graphing.LineChartWindow;
import nl.wilcotomassen.loremdatum.generator.numerical.FloatGenerator;

public class SimpleFloatExample {

	 public static void main(String[] args) {
	
		// Create generator
		FloatGenerator g = FloatGenerator.builder()
				.seed((int) System.currentTimeMillis()) // Add a random seed so we get a different result each time we run
				.variationLowerBound(-0.1) // Set min variation to -10% of the previously generated value
				.variationUpperBound(0.1)  // Set max variation to +10% of the previously generated value
				.initiator(50f)            // Set initial starting value to 50
				.build();

		// Use generator to generate values
		for (int i = 0; i < 100; i++) {
			
			// Get value
			float v = g.getNext();
			
			// Add to line chart series (so we can see the results)
			LineChartWindow.addDataPoint(i, v);
		}
		
		// Show line chart with the generated values
		new LineChartWindow("Float Generator Example");
	
	 }

}
