/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import com.sciaps.common.spectrum.RawDataSpectrum;
import com.sciaps.common.spectrum.Spectrum;
import java.util.Collection;
import java.util.regex.Pattern;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;

/**
 *
 * @author jchen
 */
public class Util {

    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    private static final String POSITION_XYZ_PATTERN = "^\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*$";
    
    private static final String POSITION_XY_PATTERN = "^\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*$";

    
    public static boolean validateIPAddress(final String ipAddress) {
        
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        
        return pattern.matcher(ipAddress).matches();
    }
    
    public static boolean validePositionXYZ(final String xyz) {
        Pattern pattern = Pattern.compile(POSITION_XYZ_PATTERN);
        return pattern.matcher(xyz).matches();    
    }
    
    public static boolean validePositionXY(final String xy) {
        Pattern pattern = Pattern.compile(POSITION_XY_PATTERN);
        return pattern.matcher(xy).matches();    
    }
    
    public static Spectrum createAverage(Collection<? extends Spectrum> shots, double sampleRate) {
        
        Min minWL = new Min();
        Max maxWL = new Max();
        for(Spectrum shot : shots) {
            minWL.increment(shot.getValidRange().getMinimumDouble());
            maxWL.increment(shot.getValidRange().getMaximumDouble());
        }
        
        double range = maxWL.evaluate() - minWL.evaluate();
        int numSamples = (int) Math.floor(range * sampleRate);
        double[][] data = new double[2][numSamples];
        Mean avgy = new Mean();
        for(int i=0;i<numSamples;i++) {
            double x = minWL.evaluate() + 1/sampleRate;
            avgy.clear();
            for(Spectrum shot : shots) {
                if(shot.getValidRange().containsDouble(x)){
                    UnivariateFunction iv = shot.getIntensityFunction();
                    double y = iv.value(x);
                    avgy.increment(y);
                }
            }
            
            data[0][i] = x;
            data[1][i] = avgy.getResult();
        }
        
        RawDataSpectrum newSpectrum = new RawDataSpectrum(data);
        
        return newSpectrum;
    }
}
