/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import com.google.common.primitives.Doubles;
import com.sciaps.common.spectrum.PiecewiseSpectrum;
import com.sciaps.common.spectrum.RawDataSpectrum;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.apache.commons.lang.math.DoubleRange;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class ImportExportSpectrumCSV {

    private final Logger logger_ = LoggerFactory.getLogger(ImportExportSpectrumCSV.class);
    public static final double EXPORT_SAMPLE_RATE = 30.0;

    public void ExportSpectrumCSVData() {

    }

    public void exportSpectrumFile(File saveFile, PiecewiseSpectrum spectrum) throws IOException {
        if (spectrum == null || saveFile == null) {
            logger_.warn("", "will not save spectrum csv file");
            return;
        }

        final UnivariateFunction intensity = spectrum.getIntensityFunction();

        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile)));
        try {
            bout.append("wavelength, intensity");
            bout.newLine();
            final DoubleRange range = spectrum.getValidRange();

            for (double x = range.getMinimumDouble(); x <= range.getMaximumDouble(); x += 1.0 / EXPORT_SAMPLE_RATE) {
                double y = intensity.value(x);
                if (Double.isNaN(y)) {
                    y = 0;
                }
                bout.append(Double.toString(x));
                bout.append(", ");
                bout.append(Double.toString(y));
                bout.newLine();
            }
        } finally {
            bout.close();
        }
        
        logger_.info("saved spectrum csv file to " + saveFile.getAbsolutePath());
    }

    public RawDataSpectrum importSpectrumFile(File spectrumFile) throws IOException {

        FileReader fr = new FileReader(spectrumFile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        
        ArrayList<Double> xVals = new ArrayList<Double>();
        ArrayList<Double> yVals = new ArrayList<Double>();
        
        // Skip the first line, it is the header
        if ((line = br.readLine()) != null) {
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                xVals.add(Double.parseDouble(values[0].trim()));
                yVals.add(Double.parseDouble(values[1].trim()));
            }
        }
        br.close();

        RawDataSpectrum data = new RawDataSpectrum(new double[][]{Doubles.toArray(xVals), Doubles.toArray(yVals)});

        return data;
    }
}
