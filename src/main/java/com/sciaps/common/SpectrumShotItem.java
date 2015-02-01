/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.utils.Util;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author jchen
 */
public class SpectrumShotItem {

    private int scanID_;
    private int shotID_;
    private String name_;
    private Spectrum shot_;
    private boolean isSelected_ = false;
    private final XYSeries xySeries_;

    /**
     *
     * @param name
     */
    public SpectrumShotItem(String name) {
        scanID_ = 0;
        shotID_ = 0;
        name_ = name;
        xySeries_ = new XYSeries(name_);
    }

    public SpectrumShotItem(int scanID, int shotID) {
        scanID_ = scanID;
        shotID_ = shotID;
        name_ = "Scan " + scanID_ + ": " + shotID_;
        xySeries_ = new XYSeries(name_);
    }

    public boolean isSelected() {
        return isSelected_;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected_ = isSelected;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name_).append(",");
        str.append(scanID_).append(",");
        str.append(shotID_).append(",");
       
        double[] x = shot_.getPixelLocations();
        str.append(x.length).append(",");
        for (int i = 0; i < x.length; i++) {
            str.append(x[i]).append(",");
        }
                
        if (xySeries_.isEmpty()) {
            Util.populateXYSeriesData(this);
        }
        str.append(xySeries_.getItemCount()).append(",");
        for (int i = 0; i < xySeries_.getItemCount() -1; i++) {
            str.append(xySeries_.getY(i)).append(",");
        }
        str.append(xySeries_.getY(xySeries_.getItemCount() -1));
        
        return str.toString();
    }

    public void setName(String name) {
        name_ = name;
    }

    public String getName() {
        return name_;
    }

    public void setScanID(int scanID) {
        scanID_ = scanID;
    }

    public int getScanID() {
        return scanID_;
    }

    public void setShotID(int shotID) {
        shotID_ = shotID;
    }

    public int getShotID() {
        return shotID_;
    }

    public XYSeries getXYSeries() {
        return xySeries_;
    }

    public Spectrum getShot() {
        return shot_;
    }

    public void setShot(Spectrum shot) {
        shot_ = shot;
    }
    

}
