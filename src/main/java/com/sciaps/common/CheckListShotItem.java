/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.spectrum.Spectrum;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author jchen
 */
public class CheckListShotItem {

    private int scanID_;
    private int shotID_;
    private String name_;
    private Spectrum shot_;
    private boolean isSelected_ = false;
    private XYSeries xySeries_;

    public CheckListShotItem(String name) {
        scanID_ = 0;
        shotID_ = 0;
        name_ = name;
        xySeries_ = new XYSeries(name_);
    }

    public CheckListShotItem(int scanID, int shotID) {
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
        return name_;
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
