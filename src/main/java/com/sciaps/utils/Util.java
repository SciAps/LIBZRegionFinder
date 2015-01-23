/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import com.sciaps.common.SpectrumShotItem;
import com.sciaps.common.Constants;
import com.sciaps.common.MinMaxObj;
import com.sciaps.common.spectrum.RawDataSpectrum;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.view.ProgressStatusPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author jchen
 */
public class Util {

    private static final String IPADDRESS_PATTERN
            = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static final String POSITION_XYZ_PATTERN = "^\\s*(\\d+?)\\s*,\\s*(\\d+?)\\s*,\\s*(\\d+?)\\s*$";

    private static final String POSITION_XY_PATTERN = "^\\s*(\\d+?)\\s*,\\s*(\\d+?)\\s*$";

    private static final String POSITIVE_INT = "^\\s*(\\d+?)\\s*$";

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

    public static int validateZeroOrGreater(JTextField txtField) {

        Pattern pattern = Pattern.compile(POSITIVE_INT);
        if (pattern.matcher(txtField.getText()).matches()) {
            txtField.setBackground(Color.white);
            return getStringToInt(txtField.getText());
        }

        txtField.setBackground(Color.red);
        return -1;
    }

    public static int validateOneOrGreater(JTextField txtField) {

        Pattern pattern = Pattern.compile(POSITIVE_INT);
        if (pattern.matcher(txtField.getText()).matches()) {
            int val = getStringToInt(txtField.getText());
            if (val > 0) {
                txtField.setBackground(Color.white);
                return val;
            }
        }

        txtField.setBackground(Color.red);
        return -1;
    }

    private static int getStringToInt(String valStr) {
        String val = valStr.trim();
        try {
            return Integer.parseInt(val);
        } catch (Exception ex) {
            return -1;
        }
    }

    public static Spectrum createAverage(Collection<? extends Spectrum> shots, double sampleRate) {

        Min minWL = new Min();
        Max maxWL = new Max();
        for (Spectrum shot : shots) {
            minWL.increment(shot.getValidRange().getMinimumDouble());
            maxWL.increment(shot.getValidRange().getMaximumDouble());
        }

        double range = maxWL.getResult() - minWL.getResult();
        int numSamples = (int) Math.floor(range * sampleRate);
        double[][] data = new double[2][numSamples];
        Mean avgy = new Mean();
        for (int i = 0; i < numSamples; i++) {
            double x = minWL.getResult() + i * (1 / sampleRate);
            avgy.clear();
            for (Spectrum shot : shots) {
                if (shot.getValidRange().containsDouble(x)) {
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

    public static void populateXYSeriesData(SpectrumShotItem shotItem) {

        double[] x = shotItem.getShot().getPixelLocations();
        double[] y = new double[x.length];
        UnivariateFunction yfun = shotItem.getShot().getIntensityFunction();
        for (int i = 0; i < x.length; i++) {
            y[i] = yfun.value(x[i]);
        }

        for (int i = 0; i < x.length; i++) {
            shotItem.getXYSeries().add(x[i], y[i]);
        }
    }

    public static String getIPAddress() {
        String address = null;

        try {
            File file = new File(Constants.LIBZ_URL_FILE_NAME);

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            line = line.trim();
            br.close();

            // Making sure the ip address is valid
            if (com.sciaps.utils.Util.validateIPAddress(line)) {
                address = line;
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        return address;
    }

    public static void getMinMax(MinMaxObj minMaxObj, XYSeries series, double start, double end) {

        boolean inRange = false;
        for (int i = 0; i < series.getItemCount(); i++) {
            double x = series.getX(i).doubleValue();

            if (x >= start && x <= end) {
                inRange = true;
                double y = series.getY(i).doubleValue();
                if (y < minMaxObj.min_) {
                    minMaxObj.min_ = y;
                }

                if (y > minMaxObj.max_) {
                    minMaxObj.max_ = y;
                }
            } else {
                if (inRange) {
                    break;
                }
            }
        }

    }

    public static void saveCSVFile(StringBuilder strBuilder) {
        JFileChooser chooser = new JFileChooser();

        int retrival = chooser.showSaveDialog(Constants.MAIN_FRAME);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(Constants.MAIN_FRAME,
                    "Exporting CSV file", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {
                String fileName = chooser.getSelectedFile().toString();
                if (!fileName.endsWith(".csv") && !fileName.endsWith(".CSV")) {
                    fileName = fileName + ".csv";
                }
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(strBuilder.toString());
                bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }

            progressDialog.dispose();
        }
    }

    public static ArrayList<SpectrumShotItem> readCSVFile() {
        ArrayList<SpectrumShotItem> shotItems = new ArrayList<SpectrumShotItem>();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv", "CSV"));

        int retrival = chooser.showOpenDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(Constants.MAIN_FRAME,
                    "Importing CSV file", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {
                FileReader fr = new FileReader(chooser.getSelectedFile());
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    shotItems.add(packSpectrumShotItem(line));
                }
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Exception: " + ex.getMessage());
            }

            progressDialog.dispose();
        }

        return shotItems;
    }

    private static SpectrumShotItem packSpectrumShotItem(String line) {

        String[] items = line.split(",");

        int offset = 0;
        String name = items[offset];
        int scanID = Integer.parseInt(items[++offset]);
        int shotID = Integer.parseInt(items[++offset]);

        int xLength = Integer.parseInt(items[++offset]);
        double[] x = new double[xLength];
        for (int i = 0; i < xLength; i++) {
            String val = items[++offset];
            x[i] = Double.parseDouble(val);
        }

        int yLenght = Integer.parseInt(items[++offset]);
        double[] y = new double[yLenght];
        for (int i = 0; i < yLenght; i++) {
            String val = items[++offset];
            y[i] = Double.parseDouble(val);
        }

        RawDataSpectrum data = new RawDataSpectrum(new double[][]{x, y});
        SpectrumShotItem shotInfo = new SpectrumShotItem(name);
        shotInfo.setScanID(scanID);
        shotInfo.setShotID(shotID);
        shotInfo.setShot(data, SpectrumShotItem.RAW);

        return shotInfo;
    }

    public static IntervalMarker createMarker(double min, double max) {
        return createMarker(min, max, null);
    }
    
    public static IntervalMarker createMarker(double min, double max, String element) {
        IntervalMarker marker = new IntervalMarker(
                min, max);
        marker.setPaint(Color.green);

        DecimalFormat df = new DecimalFormat("#0.000");
        String label = df.format(min);

        if (element != null ) {
            label = element +":" + label;
        }
        marker.setLabel(label);
        marker.setLabelPaint(Color.blue);
        marker.setLabelFont(new java.awt.Font("Tahoma", 1, 6));
        marker.setLabelOffset(new RectangleInsets(50, 10, 10, 20));

        return marker;
    }
}
