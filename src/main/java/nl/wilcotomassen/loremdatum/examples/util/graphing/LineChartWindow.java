package nl.wilcotomassen.loremdatum.examples.util.graphing;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
public class LineChartWindow extends ApplicationFrame {
	
	private JFreeChart chart;
	private static XYSeries series = new XYSeries("Generated data");
	
	public static void addDataPoint(double x, double y) {
		series.add(x, y);
	}

	public LineChartWindow(String title) {
		super(title);

		chart = createChart(title);
		final ChartPanel chartPanel = new ChartPanel(chart);
		
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
		
		pack();
		setVisible(true);

	}
	
	private JFreeChart createChart(String title) {
		
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				title, // chart title
				"Case", // x axis label
				"Generated value", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, false, // include legend
				true, // tooltips
				false // urls
		);

		chart.setBackgroundPaint(Color.white);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, true);
		renderer.setSeriesShapesVisible(1, false);
		plot.setRenderer(renderer);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
		
	}

}
