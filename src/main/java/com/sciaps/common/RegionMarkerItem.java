/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.data.Region;
import org.jfree.chart.plot.IntervalMarker;

/**
 *
 * @author jchen
 */
public class RegionMarkerItem  {
    
    private IntervalMarker marker_;
    private String name_;
    private String symbol_;
    private double min_;
    private double max_;
    private double value_;
    
    public RegionMarkerItem() {
        name_ = "";
        symbol_ = "";
        min_ = 0;
        max_ = 0;
        value_ = 0;
    }
    
    public RegionMarkerItem(String name, String symbol, double min, double max, double value) {
        name_ = name;
        symbol_ = symbol;
        min_ = min;
        max_ = max;
        value_ = value;
    }
    public String getName() {
        return name_;
    }
    
    public void setName(String name) {
        name_= name;
    }
    
    public String getSymbol() {
        return symbol_;
    }
    
    public void setSymbol(String symbol) {
        symbol_ = symbol;
    }
    
    public double getMin() {
        return min_;
    }
    
    public void setMin(double min) {
        min_= min;
    }
    
    public void setMax(double max) {
        max_ = max;
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
        return null;
    }
    
}
