/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.CheckListShotItem;
import com.sciaps.common.Constants;
import com.sciaps.common.RegionMarkerItem;
import com.sciaps.view.LibzShotCheckListPanel.LibzShotItemClickListenerCallback;
import com.sciaps.common.ThreadUtils;
import com.sciaps.common.data.Region;
import com.sciaps.common.spectrum.LIBZPixelSpectrum;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.common.swing.view.JFreeChartWrapperPanel;
import com.sciaps.common.webserver.ILaserController.RasterParams;
import com.sciaps.listener.JFreeChartMouseListener;
import com.sciaps.utils.CustomDialogUtils;
import static com.sciaps.utils.Util.createAverage;
import static com.sciaps.utils.Util.populateXYSeriesData;
import com.sciaps.view.RegionsPanel.RegionsPanelCallback;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class SpectrometerStackPanel extends javax.swing.JPanel
        implements RegionsPanelCallback, LibzShotItemClickListenerCallback {

    private final Logger logger_ = LoggerFactory.getLogger(SpectrometerStackPanel.class);

    private final XYSeriesCollection xySeriesCollection_;
    private final JFreeChartWrapperPanel jFreeChartPanel_;
    private final JFreeChartMouseListener chartMouseListener_;
    private final RegionsPanel regionPanels_;
    private final LibzShotCheckListPanel shotCheckListPanel_;
    private final SpecialRasterPanel specialRasterPanel_;
    private final PlotRangeSetterPanel plotRangeSetterPanel_;
    private int scanCount_ = 0;

    /**
     * Creates new form SpecktrometerStackPanel
     */
    public SpectrometerStackPanel() {
        initComponents();

        regionPanels_ = new RegionsPanel(this);
        regionContainerPanel_.add(regionPanels_);

        specialRasterPanel_ = new SpecialRasterPanel();
        rasterSettingPanel_.add(specialRasterPanel_);

        xySeriesCollection_ = new XYSeriesCollection();
        jFreeChartPanel_ = new JFreeChartWrapperPanel();
        jFreeChartPanel_.populateSpectrumChartWithAbstractXYDataset(
                xySeriesCollection_, "Spectrometer", "Wave Length", "Intensity");
        charDisplayPanel_.add(jFreeChartPanel_);

        chartMouseListener_ = new JFreeChartMouseListener(
                jFreeChartPanel_.getJFreeChart(),
                jFreeChartPanel_.getChartPanel(),
                regionPanels_);
        jFreeChartPanel_.getChartPanel().addChartMouseListener(chartMouseListener_);

        XYPlot plot = jFreeChartPanel_.getJFreeChart().getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        StandardXYToolTipGenerator ttG
                = new StandardXYToolTipGenerator("{1}, {2}", new DecimalFormat("#0.00"), new DecimalFormat("#0.00"));
        renderer.setBaseToolTipGenerator(ttG);

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);

        plotRangeSetterPanel_ = new PlotRangeSetterPanel(plot);
        chartRangeControlPanel_.add(plotRangeSetterPanel_);

        shotCheckListPanel_ = new LibzShotCheckListPanel(this);
        shotListContainerPanel_.add(shotCheckListPanel_);

        // disable them by default
        shotListContainerPanel_.setVisible(false);
        rasterSettingPanel_.setVisible(false);
        regionContainerPanel_.setVisible(false);

        // ==== start of testing code
        CheckListShotItem item = new CheckListShotItem("Test1");
        item.getXYSeries().add(200, 200);
        item.getXYSeries().add(450, 300);
        item.getXYSeries().add(900, 1);
        shotCheckListPanel_.addItem(item);

        CheckListShotItem item2 = new CheckListShotItem("Test2");
        item2.getXYSeries().add(200, 20);
        item2.getXYSeries().add(400, 300);
        item2.getXYSeries().add(900, 900);
        shotCheckListPanel_.addItem(item2);

        CheckListShotItem item3 = new CheckListShotItem("Test3");
        item3.getXYSeries().add(250, 20);
        item3.getXYSeries().add(450, 300);
        item3.getXYSeries().add(950, 900);
        shotCheckListPanel_.addItem(item3);

        // ==== end of testing code
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        regionContainerPanel_ = new javax.swing.JPanel();
        controlPanel_ = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        toggleShotList_ = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        toggleRasterSetting_ = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        toggleRegion_ = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnScan_ = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rasterSettingPanel_ = new javax.swing.JPanel();
        shotListContainerPanel_ = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        charDisplayPanel_ = new javax.swing.JPanel();
        chartRangeControlPanel_ = new javax.swing.JPanel();

        setName(""); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        regionContainerPanel_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        regionContainerPanel_.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(regionContainerPanel_, gridBagConstraints);

        controlPanel_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        controlPanel_.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        controlPanel_.add(jLabel1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        toggleShotList_.setText("Show");
        toggleShotList_.setToolTipText("Show/Hide Shot List Panel");
        toggleShotList_.setMaximumSize(new java.awt.Dimension(120, 30));
        toggleShotList_.setMinimumSize(new java.awt.Dimension(120, 30));
        toggleShotList_.setPreferredSize(new java.awt.Dimension(120, 30));
        toggleShotList_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleShotList_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(toggleShotList_, gridBagConstraints);

        jLabel2.setText("Shot List");
        jPanel1.add(jLabel2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        controlPanel_.add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        toggleRasterSetting_.setText("Show");
        toggleRasterSetting_.setToolTipText("Show/Hide Raster Setting Panel");
        toggleRasterSetting_.setMaximumSize(new java.awt.Dimension(120, 30));
        toggleRasterSetting_.setMinimumSize(new java.awt.Dimension(120, 30));
        toggleRasterSetting_.setPreferredSize(new java.awt.Dimension(120, 30));
        toggleRasterSetting_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRasterSetting_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(toggleRasterSetting_, gridBagConstraints);

        jLabel3.setText("Raster Setting");
        jPanel2.add(jLabel3, new java.awt.GridBagConstraints());

        controlPanel_.add(jPanel2, new java.awt.GridBagConstraints());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        toggleRegion_.setText("Show");
        toggleRegion_.setToolTipText("Show/Hide Region Panel");
        toggleRegion_.setMaximumSize(new java.awt.Dimension(120, 30));
        toggleRegion_.setMinimumSize(new java.awt.Dimension(120, 30));
        toggleRegion_.setPreferredSize(new java.awt.Dimension(120, 30));
        toggleRegion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleRegion_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel3.add(toggleRegion_, gridBagConstraints);

        jLabel4.setText("Region List");
        jPanel3.add(jLabel4, new java.awt.GridBagConstraints());

        controlPanel_.add(jPanel3, new java.awt.GridBagConstraints());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnScan_.setBackground(new java.awt.Color(0, 255, 51));
        btnScan_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnScan_.setText("SCAN");
        btnScan_.setToolTipText("Start Raster Test");
        btnScan_.setMaximumSize(new java.awt.Dimension(120, 30));
        btnScan_.setMinimumSize(new java.awt.Dimension(120, 30));
        btnScan_.setPreferredSize(new java.awt.Dimension(120, 30));
        btnScan_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScan_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(btnScan_, gridBagConstraints);

        jLabel5.setText("Raster Test");
        jPanel4.add(jLabel5, new java.awt.GridBagConstraints());

        controlPanel_.add(jPanel4, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        add(controlPanel_, gridBagConstraints);

        rasterSettingPanel_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rasterSettingPanel_.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(rasterSettingPanel_, gridBagConstraints);

        shotListContainerPanel_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        shotListContainerPanel_.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(shotListContainerPanel_, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        charDisplayPanel_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        charDisplayPanel_.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(charDisplayPanel_, gridBagConstraints);

        chartRangeControlPanel_.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(chartRangeControlPanel_, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnScan_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScan_ActionPerformed
        prepareForRasterTest();
    }//GEN-LAST:event_btnScan_ActionPerformed

    private void toggleShotList_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleShotList_ActionPerformed
        setShotListPanelVisible(toggleShotList_.isSelected());
    }//GEN-LAST:event_toggleShotList_ActionPerformed

    private void toggleRasterSetting_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRasterSetting_ActionPerformed

        setRasterSettingPanelVisible(toggleRasterSetting_.isSelected());
    }//GEN-LAST:event_toggleRasterSetting_ActionPerformed

    private void toggleRegion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleRegion_ActionPerformed
        setRegionPanelVisible(toggleRegion_.isSelected());
    }//GEN-LAST:event_toggleRegion_ActionPerformed

    private void setRegionPanelVisible(boolean val) {
        regionContainerPanel_.setVisible(val);
        toggleRegion_.setSelected(val);
        if (val == true) {
            toggleRegion_.setText("Hide");
        } else {
            toggleRegion_.setText("Show");
        }
    }

    private void setRasterSettingPanelVisible(boolean val) {
        rasterSettingPanel_.setVisible(val);
        toggleRasterSetting_.setSelected(val);
        if (val == true) {
            toggleRasterSetting_.setText("Hide");
        } else {
            toggleRasterSetting_.setText("Show");
        }
    }

    private void setShotListPanelVisible(boolean val) {
        shotListContainerPanel_.setVisible(val);
        toggleShotList_.setSelected(val);
        if (val == true) {
            toggleShotList_.setText("Hide");
        } else {
            toggleShotList_.setText("Show");
        }
    }

    private void prepareForRasterTest() {

        final int sampleRate = shotCheckListPanel_.getSampleRate();
        if (sampleRate < 1) {
            showErrorDialog("Sample Rate can not be less than 1");
            return;
        }

        if (Constants.mHttpClient == null) {
            showErrorDialog("Can't find LIBZ IP Address.");
            return;
        }

        final RasterParams rasterData = specialRasterPanel_.getRasterData();

        if (rasterData != null) {

            setShotListPanelVisible(true);
            setRasterSettingPanelVisible(false);
            setRegionPanelVisible(false);

            ThreadUtils.IOThreads.execute(new Runnable() {

                @Override
                public void run() {
                    startRasterTest(rasterData, sampleRate);
                }
            });
        }
    }

    // This function is call from a in house IOThread
    private void startRasterTest(RasterParams rasterData, int sampleRate) {
        logger_.info("Starting a raster test");

        StringBuilder errMsg = new StringBuilder();

        // Reset the bounds incase it is zoomed in/out
        jFreeChartPanel_.getChartPanel().restoreAutoBounds();
        ProgressStatusPanel progressbar = new ProgressStatusPanel();
        final JDialog progressDialog = CustomDialogUtils.createDialog(null,
                "Raster Test In Progress", progressbar,
                CustomDialogUtils.NONE_OPTION);
        progressDialog.setSize(400, 100);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                progressDialog.setVisible(true);
            }
        });

        try {

            List<LIBZPixelSpectrum> shots = Constants.mHttpClient.rasterTest(rasterData);

            if (shots != null && !shots.isEmpty()) {

                scanCount_++;

                int shotCount = 1;
                for (LIBZPixelSpectrum shot : shots) {

                    final CheckListShotItem item = new CheckListShotItem(scanCount_, shotCount);
                    item.setShot(shot);

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            shotCheckListPanel_.addItem(item);
                        }
                    });

                    shotCount++;
                }

                Spectrum avgSpectrum = createAverage(shots, sampleRate);
                String name = "Scan " + scanCount_ + ": Avg";
                final CheckListShotItem avgShotItem = new CheckListShotItem(name);
                avgShotItem.setShot(avgSpectrum);
                populateXYSeriesData(avgShotItem);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        shotCheckListPanel_.addItem(0, avgShotItem);
                        avgShotItem.setSelected(true);
                        xySeriesCollection_.addSeries(avgShotItem.getXYSeries());
                    }
                });

                logger_.info("Raster test completed.");

            } else {
                errMsg.append("Raster test failed, no data returned from Libz unit.");
            }

        } catch (Exception ex) {
            errMsg.append("Raster test failed: ");
            errMsg.append(ex.getMessage());
        }

        progressDialog.dispose();

        if (errMsg.length() != 0) {
            showErrorDialog(errMsg.toString());
        }
    }

    public void getRegionTextFile() {

        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showOpenDialog(null);

        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                FileReader fr = new FileReader(file.getAbsoluteFile());
                BufferedReader br = new BufferedReader(fr);

                StringBuilder text = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                }

                br.close();

                createRegionItem(text.toString());

            } catch (FileNotFoundException ex) {
                showErrorDialog(ex.getMessage());
            } catch (IOException ex) {
                showErrorDialog(ex.getMessage());
            }

        }

    }

    public void getRegionTextFromUser() {

        String retval = JOptionPane.showInputDialog(null,
                "Enter region string (ex. Fe371.76-372.16,Co257.88-258.12):",
                "");

        if (retval != null && !retval.isEmpty()) {
            createRegionItem(retval);
        }
    }

    private void createRegionItem(String regionStr) {
        boolean iValide = true;
        StringBuilder errText = new StringBuilder();

        if (regionStr != null && !regionStr.isEmpty()) {
            String[] regions = regionStr.split(",");

            for (String region : regions) {

                try {
                    Region r = Region.parse(region);
                    if (r != null) {

                        RegionMarkerItem markerItem = new RegionMarkerItem();

                        markerItem.setName(r.name);
                        if (r.getElement() != null && r.getElement().symbol != null) {
                            markerItem.setSymbol(r.getElement().symbol);
                        } else {
                            markerItem.setSymbol("");
                        }
                        markerItem.setMin(r.wavelengthRange.getMinimumDouble());
                        markerItem.setMax(r.wavelengthRange.getMaximumDouble());
                        markerItem.setValue(0);

                        regionPanels_.addRow(markerItem);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    errText.append(region);
                    errText.append(" ");
                    iValide = false;
                }
            }

            if (iValide == false) {
                showErrorDialog("Input contains invalid data:\n" + errText);
            }
            setRegionPanelVisible(true);
        }
    }

    @Override
    public void doShowShotXYSeries(com.sciaps.common.CheckListShotItem item) {
        logger_.info("Displaying selected shot");

        if (item.getXYSeries().isEmpty()) {
            populateXYSeriesData(item);
        }

        try {

            int index = xySeriesCollection_.indexOf(item.getXYSeries());

            if (index < 0) {
                xySeriesCollection_.addSeries(item.getXYSeries());
            } else {
                XYPlot plot = jFreeChartPanel_.getJFreeChart().getXYPlot();
                plot.getRenderer().setSeriesVisible(index, true);
            }
        } catch (Exception ex) {
            logger_.error("Failed to show XYSeries: " + ex.getMessage());
        }
    }

    @Override
    public void doHideShotXYSeries(com.sciaps.common.CheckListShotItem item) {
        try {
            int index = xySeriesCollection_.indexOf(item.getXYSeries());
            if (index >= 0) {
                XYPlot plot = jFreeChartPanel_.getJFreeChart().getXYPlot();
                plot.getRenderer().setSeriesVisible(index, false);
            }
        } catch (Exception ex) {
            logger_.error("Failed to hide XYSeries: " + ex.getMessage());
        }
    }

    @Override
    public void doDeleteShotXYSeries(com.sciaps.common.CheckListShotItem item) {
        try {
            xySeriesCollection_.removeSeries(item.getXYSeries());
        } catch (Exception ex) {
            logger_.error("Failed to delete XYSeries: " + ex.getMessage());
        }
    }

    @Override
    public void addRegionMarker(IntervalMarker marker) {
        jFreeChartPanel_.getJFreeChart().getXYPlot().addDomainMarker(marker);
    }

    @Override
    public void removeRegionMarker(IntervalMarker marker) {
        jFreeChartPanel_.getJFreeChart().getXYPlot().removeDomainMarker(marker);
    }

    @Override
    public int getNumberOfSelectedShots() {
        return shotCheckListPanel_.getNumberOfSelectedItem();
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnScan_;
    private javax.swing.JPanel charDisplayPanel_;
    private javax.swing.JPanel chartRangeControlPanel_;
    private javax.swing.JPanel controlPanel_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel rasterSettingPanel_;
    private javax.swing.JPanel regionContainerPanel_;
    private javax.swing.JPanel shotListContainerPanel_;
    private javax.swing.JToggleButton toggleRasterSetting_;
    private javax.swing.JToggleButton toggleRegion_;
    private javax.swing.JToggleButton toggleShotList_;
    // End of variables declaration//GEN-END:variables

}
