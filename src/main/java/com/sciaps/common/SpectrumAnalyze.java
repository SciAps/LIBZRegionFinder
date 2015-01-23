/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import static com.sciaps.common.Constants.LG_PEAK_MIN_VAL;
import com.sciaps.common.algorithms.BackgroundModel;
import com.sciaps.common.algorithms.SpectrumBackgroundRemoval;
import com.sciaps.common.algorithms.SpectrumNormalization;
import com.sciaps.common.algorithms.SpectrumPeakFinding;
import com.sciaps.common.spectrum.RawDataSpectrum;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.utils.ImportLibsLines;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class SpectrumAnalyze {

    private final Logger logger_ = LoggerFactory.getLogger(SpectrumAnalyze.class);
    private final double SAMPLE_RATE = 30;
    private final double THRESHOLD = .12;

    private ArrayList<LIBZLineObj> LIBZLines_;

    public void readLIBZLines() {
        try {
            ImportLibsLines reader = new ImportLibsLines();
            LIBZLines_ = reader.importLibsLinesFile();
        } catch (IOException e) {
            logger_.error(e.getMessage());
        }
    }

    public Spectrum doBackgroundRemoval(final Spectrum spectrum) {

        double stepSize = 1;
        double wlInterval = 5;

        return doBackgroundRemoval(spectrum, stepSize, wlInterval);
    }

    public Spectrum doBackgroundRemoval(final Spectrum spectrum, double stepSize, double wlInterval) {

        if (stepSize < 0 || wlInterval < 0) {
            return null;
        }

        BackgroundModel bgModel = new BackgroundModel(stepSize, wlInterval);
        PolynomialSplineFunction polynomialSplineFunc = bgModel.getModelBaseline(spectrum);

        SpectrumBackgroundRemoval bgRemoval = new SpectrumBackgroundRemoval();

        return bgRemoval.doBackgroundRemoval(spectrum, polynomialSplineFunc);
    }

    public Spectrum doSpectrumNormalization(final Spectrum spectrum) {
        SpectrumNormalization spectrumNormalization = new SpectrumNormalization();
        RawDataSpectrum normalizedData = spectrumNormalization.normalize(spectrum);
        return normalizedData;
    }

    public double[] doPeakFinding(final Spectrum spectrum) {
        return doPeakFinding(spectrum, SAMPLE_RATE);
    }

    public double[] doPeakFinding(final Spectrum spectrum, double sampleRate) {
        SpectrumPeakFinding peakFinding = new SpectrumPeakFinding(sampleRate);
        return peakFinding.getPeaks(spectrum);
    }

    public PeakMeritObj identifiedPeaks(double waveLength, double intensity) {
        return identifiedPeaks(waveLength, intensity, THRESHOLD);
    }

    public PeakMeritObj identifiedPeaks(double waveLength, double intensity, double threshold) {

        PeakMeritObj meritObj = null;

        if (LIBZLines_ == null || LIBZLines_.isEmpty()) {
            readLIBZLines();
        }

        double min;
        double max;
        if (LIBZLines_ != null && LIBZLines_.isEmpty() == false) {

            for (LIBZLineObj libzObj : LIBZLines_) {
                min = libzObj.getWaveLength() - THRESHOLD;
                max = libzObj.getWaveLength() + THRESHOLD;

                if (min <= waveLength && waveLength <= max)  {
                    meritObj = new PeakMeritObj(libzObj.getElementName());
                    meritObj.incrementTotalPeaksFoundByOne();
                    if (libzObj.getIntensity() >= LG_PEAK_MIN_VAL) {
                        meritObj.incrementTotalLgPeaksFoundByOne();
                    }
                    meritObj.addWavelength(libzObj.getWaveLength());
                    double weight = intensity / libzObj.getIntensity();
                    meritObj.setWeight(weight);
                    break;
                }
            }

        }

        return meritObj;
    }

    public void getElementLineData(PeakMeritObj meritObj) {

        for (LIBZLineObj libzObj : LIBZLines_) {
            if (libzObj.getElementName().compareTo(meritObj.elementName_) == 0) {
                meritObj.incrementTotalPeaksByOne();
                if (libzObj.getIntensity() >= LG_PEAK_MIN_VAL) {
                    meritObj.incrementTotalLgPeaksByOne();
                }
            }
        }

    }
}
