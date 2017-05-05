package com.noveria.charts.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class RSIChart extends JFrame {

    public RSIChart() {

        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {

        XYSeries series1 = new XYSeries("Lower Threshold");
        series1.add(5, 20);
        series1.add(10, 20);
        series1.add(15, 20);
        series1.add(20, 20);
        series1.add(25, 20);
        series1.add(30, 20);

        XYSeries series2 = new XYSeries("Upper Threshold");
        series2.add(5, 80);
        series2.add(10, 80);
        series2.add(15, 80);
        series2.add(20, 80);
        series2.add(25, 80);
        series2.add(30, 80);

        XYSeries series3= new XYSeries("RSI");
        series3.add(5, 0);
        series3.add(10, 10);
        series3.add(15, 30);
        series3.add(20, 60);
        series3.add(25, 100);
        series3.add(30, 30);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "RSI",
                "Time",
                "RSI",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        renderer.setSeriesPaint(1, Color.BLACK);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("RSI",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            RSIChart ex = new RSIChart();
            ex.setVisible(true);
        });
    }
}
