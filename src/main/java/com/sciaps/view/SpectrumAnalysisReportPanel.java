/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.devsmart.swing.BackgroundTask;
import com.sciaps.common.Constants;
import static com.sciaps.common.Constants.MARKER_THRESHOLD;
import com.sciaps.common.PeakMeritObj;
import com.sciaps.common.SpectrumAnalyze;
import com.sciaps.common.SpectrumShotItem;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.model.PeakMeritTableModel;
import com.sciaps.utils.ImportLibsLines;
import com.sciaps.utils.Util;
import com.sciaps.view.SpectrumShotPanel.SpectrumShotPanelCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import org.jfree.chart.plot.IntervalMarker;

/**
 *
 * @author jchen
 */
public class SpectrumAnalysisReportPanel extends javax.swing.JPanel {

    private PeakMeritTableModel peakMeritTableModel_;
    private PeakMeritTableModel rejectedPeakMeritTableModel_;
    private SpectrumAnalyze spectrumAnalyze_;
    private SpectrumShotPanelCallback callback_;
    private ArrayList<IntervalMarker> markers_;
    private ArrayList<IntervalMarker> allMarkers_;
    private DefaultListModel listModel_;
    private SpectrumShotItem normalizedSpectrumItem_;

    /**
     * Creates new form SpectrumAnalysisReportPanel
     *
     * @param callback
     */
    public SpectrumAnalysisReportPanel(SpectrumShotPanelCallback callback) {
        doInitialization();
        callback_ = callback;
    }

    /**
     * Creates new form SpectrumAnalysisReportPanel
     */
    public SpectrumAnalysisReportPanel() {
        doInitialization();

    }

    private void doInitialization() {
        initComponents();

        listModel_ = new DefaultListModel();
        lstIdentifiedPeaks_.setModel(listModel_);

        peakMeritTableModel_ = new PeakMeritTableModel(callback_);
        tblPeakMeritSummary_.setModel(peakMeritTableModel_);

        rejectedPeakMeritTableModel_ = new PeakMeritTableModel(callback_);
        tblRejectedPeakMerit_.setModel(rejectedPeakMeritTableModel_);

        markers_ = new ArrayList<IntervalMarker>();
        allMarkers_ = new ArrayList<IntervalMarker>();
        spectrumAnalyze_ = new SpectrumAnalyze();
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

        lblSpectrumName_ = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPeakMeritSummary_ = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstIdentifiedPeaks_ = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRejectedPeakMerit_ = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        lblSpectrumName_.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(lblSpectrumName_, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Spectrum Analysis");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabel4, gridBagConstraints);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Spectrum:");
        jLabel5.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabel5, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        tblPeakMeritSummary_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeakMeritSummary_.setPreferredSize(null);
        tblPeakMeritSummary_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeakMeritSummary_MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPeakMeritSummary_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        jPanel1.add(jScrollPane3, gridBagConstraints);

        lstIdentifiedPeaks_.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstIdentifiedPeaks_.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstIdentifiedPeaks_.setMaximumSize(new java.awt.Dimension(200, 85));
        lstIdentifiedPeaks_.setMinimumSize(new java.awt.Dimension(200, 85));
        lstIdentifiedPeaks_.setPreferredSize(null);
        lstIdentifiedPeaks_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstIdentifiedPeaks_MouseClicked(evt);
            }
        });
        lstIdentifiedPeaks_.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstIdentifiedPeaks_ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstIdentifiedPeaks_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Rejected (weight < 10%):");
        jLabel2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        tblRejectedPeakMerit_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRejectedPeakMerit_.setMinimumSize(null);
        tblRejectedPeakMerit_.setPreferredSize(null);
        tblRejectedPeakMerit_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRejectedPeakMerit_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRejectedPeakMerit_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Identified Peaks");
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Summary (weight >= 10%):");
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tblRejectedPeakMerit_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRejectedPeakMerit_MouseClicked
        int selectedRow = tblRejectedPeakMerit_.getSelectedRow();
        int modelIndex = tblRejectedPeakMerit_.convertRowIndexToModel(selectedRow);
        doShowMarker(rejectedPeakMeritTableModel_, modelIndex);
    }//GEN-LAST:event_tblRejectedPeakMerit_MouseClicked

    private void lstIdentifiedPeaks_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstIdentifiedPeaks_MouseClicked
        doShowMarkerFromIdentifiedList();
    }//GEN-LAST:event_lstIdentifiedPeaks_MouseClicked

    private void lstIdentifiedPeaks_ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstIdentifiedPeaks_ValueChanged
        doShowMarkerFromIdentifiedList();
    }//GEN-LAST:event_lstIdentifiedPeaks_ValueChanged

    private void tblPeakMeritSummary_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeakMeritSummary_MouseClicked
        int selectedRow = tblPeakMeritSummary_.getSelectedRow();
        int modelIndex = tblPeakMeritSummary_.convertRowIndexToModel(selectedRow);
        doShowMarker(peakMeritTableModel_, modelIndex);
    }//GEN-LAST:event_tblPeakMeritSummary_MouseClicked

    private void doShowMarkerFromIdentifiedList() {
        int selectedIndex = lstIdentifiedPeaks_.getSelectedIndex();
        try {
            doRemoveExitingMarkers();
            callback_.addMarker(allMarkers_.get(selectedIndex));
        } catch (Exception e) {
            
        }
    }
    private void doRemoveExitingMarkers() {
        // remove existing marker
        for (IntervalMarker marker : allMarkers_) {
            callback_.removeMarker(marker);
        }
        
        // remove existing marker
        for (IntervalMarker marker : markers_) {
            callback_.removeMarker(marker);
        }
    }
    
    private void doShowMarker(PeakMeritTableModel tableModel, int modelIndex)  {
        doRemoveExitingMarkers();
        
        // show the new marker
        PeakMeritObj obj = tableModel.getRow(modelIndex);
        for (IntervalMarker marker : obj.getMarkers()) {
            markers_.add(marker);
            callback_.addMarker(marker);
        }
    }
    
    public void doAnalysis(final SpectrumShotItem spectrumShotItem) {

        BackgroundTask.runBackgroundTask(new BackgroundTask() {

            private JDialog mDialog;
            private JProgressBar mProgress;

            @Override
            public void onBefore() {
                mProgress = new JProgressBar();
                mProgress.setIndeterminate(true);

                mDialog = new JDialog(Constants.MAIN_FRAME);
                mDialog.setLocationRelativeTo(Constants.MAIN_FRAME);
                mDialog.setAlwaysOnTop(true);
                mDialog.setResizable(false);
                mDialog.setContentPane(mProgress);
                mDialog.setSize(400, 100);
                mDialog.setVisible(true);
            }

            @Override
            public void onBackground() {

                Spectrum tmp = null;
                final double[] peaksOnX_;
                if (spectrumShotItem.getSeriesDataType() == SpectrumShotItem.NORMALIZED) {
                    tmp = spectrumShotItem.getShot();
                    peaksOnX_ = spectrumAnalyze_.doPeakFinding(tmp);
                } else if (spectrumShotItem.getSeriesDataType() == SpectrumShotItem.BG_REMOVED) {

                    tmp = spectrumAnalyze_.doSpectrumNormalization(spectrumShotItem.getShot());
                    peaksOnX_ = spectrumAnalyze_.doPeakFinding(tmp);
                } else {

                    tmp = spectrumAnalyze_.doBackgroundRemoval(spectrumShotItem.getShot());
                    tmp = spectrumAnalyze_.doSpectrumNormalization(tmp);
                    peaksOnX_ = spectrumAnalyze_.doPeakFinding(tmp);
                }

                // Create a marker for each peaks and show them
                if (peaksOnX_.length > 0) {

                    normalizedSpectrumItem_ = new SpectrumShotItem("analysis");
                    normalizedSpectrumItem_.setShot(tmp, SpectrumShotItem.NORMALIZED);
                    
                    final HashMap<String, PeakMeritObj> mapOfPeaks = new HashMap<String, PeakMeritObj>();

                    // Merge all the identified peak into one object
                    // this for loop will set the found value
                    for (int i = 0; i < peaksOnX_.length; i++) {
                        double y = tmp.getIntensityFunction().value(peaksOnX_[i]);
                        
                        PeakMeritObj retMeritObj = spectrumAnalyze_.identifiedPeaks(peaksOnX_[i], y);
                        if (retMeritObj != null) {
                            PeakMeritObj meritObjInTheMap = mapOfPeaks.get(retMeritObj.elementName_);
                            if (meritObjInTheMap == null) {
                                // not in the list, add it
                                mapOfPeaks.put(retMeritObj.elementName_, retMeritObj);
                            } else {
                                // in the list already, update it
                                meritObjInTheMap.addWavelength(retMeritObj.getWaveLength());
                                meritObjInTheMap.addTotalPeaksFound(retMeritObj.getTotalPeaksFound());
                                meritObjInTheMap.addTotalLgPeaksFound(retMeritObj.getTotalLgPeaksFound());
                                meritObjInTheMap.addWeight(retMeritObj.getWeight());
                            }
                        }
                    }

                    //Now we have a list of identified peaks, going to get the element info on the libzlines library
                    for (PeakMeritObj obj : mapOfPeaks.values()) {
                        spectrumAnalyze_.getElementLineData(obj);
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                            // Remove all previous data
                            listModel_.removeAllElements();
                            lblSpectrumName_.setText(spectrumShotItem.getName());
                            markers_.clear();
                            peakMeritTableModel_.clearAllData();
                            rejectedPeakMeritTableModel_.clearAllData();

                            callback_.doShowShotXYSeries(normalizedSpectrumItem_);
                            
                            double min;
                            double max;
                            for (PeakMeritObj obj : mapOfPeaks.values()) {
                                for (Object wl : obj.getWaveLength()) {
                                    String item = String.format("%.5g, %s", wl, obj.elementName_);
                                    listModel_.addElement(item);
                                    
                                    min = (Double) wl - MARKER_THRESHOLD;
                                    max = (Double) wl + MARKER_THRESHOLD;
                                    IntervalMarker marker = Util.createMarker(min, max, obj.elementName_);
                                    callback_.addMarker(marker);
                                    allMarkers_.add(marker);
                                }

                                if (obj.getWeightPercentage() >= 10) {
                                    peakMeritTableModel_.addRow(obj);
                                } else {
                                    rejectedPeakMeritTableModel_.addRow(obj);
                                }
                            }

                            /*double min;
                            double max;
                            for (int i = 0; i < peaksOnX_.length; i++) {

                                min = peaksOnX_[i] - MARKER_THRESHOLD;
                                max = peaksOnX_[i] + MARKER_THRESHOLD;
                                IntervalMarker marker = Util.createMarker(min, max);
                                markers_.add(marker);
                                callback_.addMarker(marker);
                            }*/
                        }
                    });
                }
            }

            @Override
            public void onAfter() {
                mDialog.setVisible(false);
            }
        });

    }

    public void doCleanUp() {

        for (IntervalMarker marker : markers_) {
            callback_.removeMarker(marker);
        }
        
        for (IntervalMarker marker : allMarkers_) {
            callback_.removeMarker(marker);
        }
        callback_.doDeleteShotXYSeries(normalizedSpectrumItem_);

        markers_.clear();
        allMarkers_.clear();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSpectrumName_;
    private javax.swing.JList lstIdentifiedPeaks_;
    private javax.swing.JTable tblPeakMeritSummary_;
    private javax.swing.JTable tblRejectedPeakMerit_;
    // End of variables declaration//GEN-END:variables
}
