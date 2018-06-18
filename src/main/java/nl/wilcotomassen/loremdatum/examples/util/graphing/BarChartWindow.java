package nl.wilcotomassen.loremdatum.examples.util.graphing;

import java.awt.Color;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class BarChartWindow extends ApplicationFrame {
	
	private JFreeChart chart;
	private static LinkedHashMap<String, Double> values = new LinkedHashMap<String, Double>();
	
	public static void setValue(String key, double value) {
		values.put(key, value);
	}
	
	public static void updateValue(String key, double value, double initalValue) {
		
		double newValue = values.containsKey(key) 
			? values.get(key) + value
			: initalValue;
		
		values.put(key, newValue);
		
	}
	
	public static void sortValues(boolean ascending) {
		
		Comparator<Map.Entry<String, Double>> c = ascending 
				? (e1, e2) -> e2.getValue().compareTo(e1.getValue())
				: (e1, e2) -> e1.getValue().compareTo(e2.getValue());
		
		values = values.entrySet().stream()
			.sorted(c)
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	
	}
	
	public static void sortValuesAscending() {
		sortValues(true);
	}
	
	public static void sortValuesDescending() {
		sortValues(true);
	}

	public BarChartWindow(String title) {
		super(title);

		chart = createChart(title);
		final ChartPanel chartPanel = new ChartPanel(chart);
		
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
		
		pack();
		setVisible(true);

	}
	
	private JFreeChart createChart(String title) {
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (HashMap.Entry<String, Double> entry : values.entrySet()) {
			String key = entry.getKey();
			double value = entry.getValue();
			dataset.addValue(value, "Occurrences", key);
		}
		
		JFreeChart chart = ChartFactory.createBarChart(title, "Case", "Generated value", dataset);
		chart.setBackgroundPaint(Color.white);
		chart.removeLegend();

		return chart;
		
	}

}
