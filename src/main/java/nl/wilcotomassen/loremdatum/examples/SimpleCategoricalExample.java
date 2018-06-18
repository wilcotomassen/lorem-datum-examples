package nl.wilcotomassen.loremdatum.examples;

import nl.wilcotomassen.loremdatum.examples.util.graphing.BarChartWindow;
import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGenerator;

public class SimpleCategoricalExample {
	
	 public static void main(String[] args) {
		 
		// Create generator
		CategoricalGenerator g = CategoricalGenerator.builder()
				.seed((int) System.currentTimeMillis()) // Add a random seed so we get a different result each time we run
				
				// Add items and their probabilities (in this case the five biggest countries as 
				// values, and their respective population count as their probabilities
				.addItem(1414856513, "China")
				.addItem(1353540105, "India")
				.addItem(326687504, "USA")
				.addItem(266698528, "Indonesia")
				.addItem(210813689, "Brazil")
				.build();

		// Use generator to generate values
		for (int i = 0; i < 10000; i++) {
			
			// Get value
			String v = (String) g.getNext();
			
			BarChartWindow.updateValue(v, +1, 1);
			
		}
		
		// Show bar chart with the generated values
		BarChartWindow.sortValuesDescending();
		new BarChartWindow("Categorical Generator Example");
	
	 }

}
