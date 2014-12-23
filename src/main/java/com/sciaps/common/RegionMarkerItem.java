/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author jchen
 */
public class RegionMarkerItem {

    private IntervalMarker marker_;
    private String name_;
    private String symbol_;
    private double min_;
    private double max_;
    private double value_;
    private boolean isMarkerShown_;

    public RegionMarkerItem() {
        name_ = "";
        symbol_ = "";
        min_ = 0;
        max_ = 0;
        value_ = 0;
        isMarkerShown_ = false;
        createMarker();
    }

    public RegionMarkerItem(String name, String symbol, double min, double max, double value) {
        name_ = name;
        symbol_ = symbol;
        min_ = min;
        max_ = max;
        value_ = value;

        createMarker();
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        name_ = name;
    }

    public String getSymbol() {
        return symbol_;
    }

    public void setSymbol(String symbol) {
        symbol_ = symbol;
        resetName();
        createMarker();
    }

    public double getMin() {
        return min_;
    }

    public void setMin(double min) {
        min_ = min;
        resetName();
        createMarker();
    }

    public void setMax(double max) {
        max_ = max;
        resetName();
        createMarker();
    }

    public double getMax() {
        return max_;
    }

    public void setValue(double val) {
        value_ = val;
    }

    public double getValue() {
        return value_;
    }

    public IntervalMarker getMarker() {
        return marker_;
    }

    public boolean getIsMarkerShown() {
        return isMarkerShown_;
    }

    public void setIsMarkerShown(boolean val) {
        isMarkerShown_ = val;
    }

    private void resetName() {
        if (symbol_.isEmpty()) {
            name_ = String.format("%d-%d", Math.round(min_), Math.round(max_));
        } else {
            name_ = String.format("%s-%d", symbol_, Math.round(min_));
        }
    }

    private void createMarker() {
        final Color c = new Color(8, 255, 8, 63);
        marker_ = new IntervalMarker(
                min_, max_, c,
                new BasicStroke(2.0f), null, null, 1.0f);
        String[] tmp = name_.split("-");
        marker_.setLabel(tmp[0]);
        marker_.setLabelPaint(Color.blue);
        marker_.setLabelFont(new java.awt.Font("Tahoma", 1, 14));
        marker_.setLabelOffset(new RectangleInsets(50, 10, 10, 20));
    }
}
