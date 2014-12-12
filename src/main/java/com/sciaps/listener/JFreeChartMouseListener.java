/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.listener;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;

/**
 *
 * @author jchen
 */
public class JFreeChartMouseListener implements ChartMouseListener {

    public interface JFreeChartMouseListenerCallback {

        public void jFreeChartOnClicked(double x, double y);
    }

    private final JFreeChart jFreeChart_;
    private final ChartPanel chartPanel_;
    private final JFreeChartMouseListenerCallback callback_;

    public JFreeChartMouseListener(JFreeChart jFreeChart, ChartPanel chartPanel, JFreeChartMouseListenerCallback callback) {

        jFreeChart_ = jFreeChart;
        chartPanel_ = chartPanel;
        callback_ = callback;
    }

    @Override
    public void chartMouseClicked(ChartMouseEvent cme) {

        if (cme.getTrigger().isControlDown()) {

            Point2D p = cme.getTrigger().getPoint();
            Rectangle2D plotArea = chartPanel_.getScreenDataArea();
            XYPlot plot = (XYPlot) jFreeChart_.getPlot();
            double chartX = plot.getDomainAxis().java2DToValue(p.getX(), plotArea, plot.getDomainAxisEdge());
            double chartY = plot.getRangeAxis().java2DToValue(p.getY(), plotArea, plot.getRangeAxisEdge());

            if (callback_ != null) {
                callback_.jFreeChartOnClicked(chartX, chartY);
            }
        }
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent cme) {

    }

}
