/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

/**
 *
 * @author jchen
 */
public class IdentifiedPeakObj {
    
    private String elementName_;
    private double waveLength_;

    
    public IdentifiedPeakObj(String elementName, double waveLength) {
        elementName_ = elementName;
        waveLength_ = waveLength;
    }
    
    public String getElementName() {
        return elementName_;
    }
    
    public void setElementName(String name) {
        elementName_ = name;
    }
    
    public double getWaveLength() {
        return waveLength_;
    }
    
    public void setWavelength(double waveLength) {
        waveLength_ = waveLength;
    }
    
}
