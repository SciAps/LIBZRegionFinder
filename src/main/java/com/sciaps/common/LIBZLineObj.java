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
public class LIBZLineObj {
    
    private final String elementName_;
    private final double waveLength_;
    private final double intensity_;
    
    public LIBZLineObj(String elementName, double waveLength, double intensity) {
        elementName_ = elementName.trim();
        waveLength_ = waveLength;
        intensity_ = intensity;
    }
    
    public String getElementName() {
        return elementName_;
    }
    
    public double getWaveLength() {
        return waveLength_;
    }
    
    public double getIntensity() {
        return intensity_;
    }
}
