package nl.wilcotomassen.loremdatum.examples;

import nl.wilcotomassen.loremdatum.examples.util.graphing.BarChartWindow;
import nl.wilcotomassen.loremdatum.generator.categorical.BooleanGenerator;

public class SimpleBooleanExample {
	
	 public static void main(String[] args) {
		 
		// Create generator
		BooleanGenerator g = BooleanGenerator.builder()
				.seed((int) System.currentTimeMillis()) // Add a random seed so we get a different result each time we run
				.trueProbability(0.75f)					// Set probability of true to 0.75
				.build();

		// Use generator to generate values
		for (int i = 0; i < 100; i++) {
			
			// Get value
			boolean v = g.getNext();
			
			BarChartWindow.updateValue(v ? "True" : "False", +1, 1);
		}
		
		// Show bar chart with the generated values
		new BarChartWindow("Boolean Generator Example");
	
	 }

}
