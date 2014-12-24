/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.spectrum.Spectrum;
import org.apache.commons.lang.math.DoubleRange;
import org.apache.commons.math3.analysis.UnivariateFunction;

/**
 *
 * @author jchen
 */
public class ShotSpectrum implements Spectrum{
    private final double[] x_;
    private final double[] y_;
    private final DoubleRange doubleRange_;
    
    public ShotSpectrum(double[] x, double[] y, DoubleRange doubleRange) {
        x_ = x;
        y_ = y;
        doubleRange_ = doubleRange;
    }
    
    @Override
    public UnivariateFunction getIntensityFunction() {
        return new UnivariateFunction() {
            @Override
            public double value(double x) {
                
                for (int i = 0; i < x_.length; i++) {
                    if (x == x_[i]) {
                        return y_[i];
                    }
                }
                
                return 0; 
            }
        };
    }

    @Override
    public DoubleRange getValidRange() {
        return doubleRange_;
    }

    @Override
    public double[] getPixelLocations() {
        return x_;
    }    
}
