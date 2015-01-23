/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import static com.sciaps.common.Constants.MARKER_THRESHOLD;
import com.sciaps.utils.Util;
import java.util.ArrayList;
import org.jfree.chart.plot.IntervalMarker;

/**
 *
 * @author jchen
 */
public class PeakMeritObj {
    
    public final String elementName_;
    private int totalPeaks_;
    private int totalPeaksFound_;
    private int totalLgPeaks_;
    private int totalLgPeaksFound_;
    private double weight_;
    private final ArrayList<Double> waveLengths_ = new ArrayList<Double>();
    private IntervalMarker[] markers_;

    public PeakMeritObj(String elementName) {
        elementName_ = elementName;
    }
            
    public ArrayList getWaveLength() {
        return waveLengths_;
    }
    
    public void addWavelength(double waveLength) {
        waveLengths_.add(waveLength);
    }
    
    public void addWavelength(ArrayList waveLengths) {
        waveLengths_.addAll(waveLengths);
    }
    
    public int getTotalPeaks() {
        return totalPeaks_;
    }
    
    public void incrementTotalPeaksByOne() {
        totalPeaks_++;
    }
        
    public int getTotalPeaksFound() {
        return totalPeaksFound_;
    }
    
    public void incrementTotalPeaksFoundByOne() {
        totalPeaksFound_++;
    }
    
    public void addTotalPeaksFound(int val) {
        totalPeaksFound_ = totalPeaksFound_ + val;
    }
    
    public int getTotalLgPeaks() {
        return totalLgPeaks_;
    }
    
    public void incrementTotalLgPeaksByOne() {
        totalLgPeaks_++;
    }
    
    public int getTotalLgPeaksFound() {
        return totalLgPeaksFound_;
    }
    
    public void incrementTotalLgPeaksFoundByOne() {
        totalLgPeaksFound_++;
    }
    
    public void addTotalLgPeaksFound(int val) {
        totalLgPeaksFound_ = totalLgPeaksFound_ + val;
    }
    
    public double getWeight() {
        return weight_;
    }
    
    public void setWeight(double weight) {
        weight_ = weight;
    }
    
    public void addWeight(double weight) {
        weight_ = weight_ + weight;
    }
    
    public double getWeightPercentage() {
        if (totalPeaks_ == 0) {
            return 0;
        }
        double weightPercentage = (weight_ / totalPeaks_) * 100;
        return weightPercentage;
    }
    
    public IntervalMarker[] getMarkers() {
        if (markers_ == null) {
            markers_ = new IntervalMarker[waveLengths_.size()];
            double min;
            double max;
            for (int i = 0 ; i < waveLengths_.size(); i++) {
                min = waveLengths_.get(i) - MARKER_THRESHOLD;
                max = waveLengths_.get(i) + MARKER_THRESHOLD;
                markers_[i] = Util.createMarker(min, max, elementName_);
            }
        }
        
        return markers_;
    }
}
