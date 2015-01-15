/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.devsmart.ThreadUtils;
import com.sciaps.common.Constants;
import com.sciaps.common.SpectrumShotItem;
import com.sciaps.common.algorithms.BackgroundModel;
import com.sciaps.common.algorithms.LorentzianIntensityValue;
import com.sciaps.common.algorithms.SimpleIntensityValue;
import com.sciaps.common.spectrum.RawDataSpectrum;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.model.ShotListTableModel;
import com.sciaps.utils.CustomDialog;
import com.sciaps.utils.ImportExportSpectrum;
import com.sciaps.utils.Util;
import static com.sciaps.utils.Util.createAverage;
import static com.sciaps.utils.Util.validateOneOrGreater;
import static com.sciaps.utils.Util.validateZeroOrGreater;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class SpectrumShotPanel extends javax.swing.JPanel {

    public interface SpectrumShotPanelCallback {

        void doShowShotXYSeries(SpectrumShotItem item);

        void doHideShotXYSeries(SpectrumShotItem item);

        void doDeleteShotXYSeries(SpectrumShotItem item);
    }

    private final Logger logger_ = LoggerFactory.getLogger(SpectrumShotPanel.class);
    private final ShotListTableModel shotListTableModel_;
    private final BaselineRemovalSettingsPanel baselineSettingPanel_;
    private final TableRowSorter<ShotListTableModel> sorter_;

    /**
     * List Creates new form LibzListPanel
     *
     * @param callback
     */
    public SpectrumShotPanel(SpectrumShotPanelCallback callback) {
        initComponents();

        baselineSettingPanel_ = new BaselineRemovalSettingsPanel();
        shotListTableModel_ = new ShotListTableModel(callback);
        tblShots_.setModel(shotListTableModel_);
        tblShots_.getTableHeader().setReorderingAllowed(false);

        tblShots_.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblShots_.getColumnModel().getColumn(0).setMinWidth(45);
        tblShots_.getColumnModel().getColumn(0).setMaxWidth(45);
        tblShots_.getColumnModel().getColumn(0).setResizable(false);

        sorter_ = new TableRowSorter<ShotListTableModel>(shotListTableModel_);
        tblShots_.setRowSorter(sorter_);
        txtFilterText_.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }
        });
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

        btnCreateAvg_ = new javax.swing.JButton();
        btnHideShot_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteScan_ = new javax.swing.JButton();
        btnDelete_ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShots_ = new JTable(){
            //Implement table cell tool tips.
            @Override
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();

                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }         
        };
        btnShowShotl_ = new javax.swing.JButton();
        btnBackgroundRemoval_ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtSampleRate_ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFilterText_ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(160, 190));
        setMinimumSize(new java.awt.Dimension(160, 190));
        setPreferredSize(new java.awt.Dimension(160, 190));
        setLayout(new java.awt.GridBagLayout());

        btnCreateAvg_.setText("Create Shot Avg");
        btnCreateAvg_.setToolTipText("Create An Avg of All Highlighted");
        btnCreateAvg_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAvg_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnCreateAvg_, gridBagConstraints);

        btnHideShot_.setText("Hide Shot(s)");
        btnHideShot_.setToolTipText("Hide Shot Series");
        btnHideShot_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideShot_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnHideShot_, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Shot List:");
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        btnDeleteScan_.setText("Delete Scan");
        btnDeleteScan_.setToolTipText("Delete All Shots In A Scan");
        btnDeleteScan_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteScan_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnDeleteScan_, gridBagConstraints);

        btnDelete_.setText("Delete Shot(s)");
        btnDelete_.setToolTipText("Delete Shot(s)");
        btnDelete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnDelete_, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Scan Data");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabel2, gridBagConstraints);

        tblShots_.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblShots_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        btnShowShotl_.setText("Show Shot(s)");
        btnShowShotl_.setToolTipText("Show Shot Series");
        btnShowShotl_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowShotl_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnShowShotl_, gridBagConstraints);

        btnBackgroundRemoval_.setText("Background Removal");
        btnBackgroundRemoval_.setToolTipText("Remove background noise for the selected shots");
        btnBackgroundRemoval_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackgroundRemoval_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnBackgroundRemoval_, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtSampleRate_.setText("30");
        txtSampleRate_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSampleRate_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        jPanel1.add(txtSampleRate_, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sample Rate:");
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel1.add(txtFilterText_, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Filter:");
        jLabel4.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAvg_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAvg_ActionPerformed

        int[] selectedRows = tblShots_.getSelectedRows();
        if (selectedRows.length < 2) {
            showErrorDialog("Need minimum of 2 shots to create an average.");
            return;
        }
        doCreateAvg();
    }//GEN-LAST:event_btnCreateAvg_ActionPerformed

    private void btnHideShot_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideShot_ActionPerformed
        doHideShots();
    }//GEN-LAST:event_btnHideShot_ActionPerformed

    private void btnDeleteScan_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteScan_ActionPerformed
        doDeleteScan();
    }//GEN-LAST:event_btnDeleteScan_ActionPerformed

    private void btnDelete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_ActionPerformed
        doDelete();
    }//GEN-LAST:event_btnDelete_ActionPerformed

    private void txtSampleRate_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSampleRate_KeyReleased
        validateOneOrGreater(txtSampleRate_);
    }//GEN-LAST:event_txtSampleRate_KeyReleased

    private void btnShowShotl_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowShotl_ActionPerformed
        doShowShots();
    }//GEN-LAST:event_btnShowShotl_ActionPerformed

    private void btnBackgroundRemoval_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackgroundRemoval_ActionPerformed
        doBackgroundRemoval();
    }//GEN-LAST:event_btnBackgroundRemoval_ActionPerformed

    private int[] getSelectedRows() {

        if (tblShots_.getSelectedRowCount() == 0) {
            showErrorDialog("Nothing is selected.");
            return null;
        }

        int[] selectedRows = tblShots_.getSelectedRows();
        int[] tmpSelectedRows = new int[selectedRows.length];
        for (int i = 0; i < tmpSelectedRows.length; i++) {
            int modelIndex = tblShots_.convertRowIndexToModel(selectedRows[i]);
            tmpSelectedRows[i] = modelIndex;
        }

        return tmpSelectedRows;
    }

    private void doShowShots() {
        shotListTableModel_.showSeries(getSelectedRows());
    }

    private void doHideShots() {
        shotListTableModel_.hideSeries(getSelectedRows());
    }

    private void doDeleteScan() {
        boolean allgood = false;

        if (tblShots_.getRowCount() == 0) {
            showErrorDialog("List is Empty. Nothing to delete.");
            return;
        }

        while (allgood == false) {

            String retval = JOptionPane.showInputDialog(null,
                    "Enter the scan number to delete:",
                    "Delete Scan",
                    JOptionPane.QUESTION_MESSAGE);

            if (retval == null) {
                allgood = true;
            } else {
                try {
                    int scanID = Integer.parseInt(retval);

                    if (scanID > 0) {
                        allgood = true;
                        shotListTableModel_.deleteScan(scanID);
                    }
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Scan #: " + retval);
                }
            }
        }
    }

    private void doDelete() {

        if (tblShots_.getSelectedRowCount() == 0) {
            showErrorDialog("Nothing is selected.");
            return;
        }

        int retval = JOptionPane.showConfirmDialog(null, "Delete Selected Row(s)?");
        if (retval != JOptionPane.YES_OPTION) {
            return;
        }

        shotListTableModel_.removeRows(getSelectedRows());
    }

    private void doCreateAvg() {

        ThreadUtils.CPUThreads.execute(new Runnable() {
            @Override
            public void run() {

                logger_.info("Creating avg from highlighted shots...");

                StringBuilder name = new StringBuilder();

                boolean gotScanID = false;
                int[] selectedList = tblShots_.getSelectedRows();
                List<Spectrum> shotDatas = new ArrayList<Spectrum>();

                for (int i = 0; i < selectedList.length; i++) {
                    int modelIndex = tblShots_.convertRowIndexToModel(selectedList[i]);
                    SpectrumShotItem shotItem = (SpectrumShotItem) shotListTableModel_.getRow(modelIndex);
                    if (gotScanID == false) {
                        name.append("Scan ").append(shotItem.getScanID()).append(" Avg: ");
                        gotScanID = true;
                    }
                    name.append(shotItem.getShotID());
                    name.append("_");

                    shotDatas.add(shotItem.getShot());
                }
                name = name.deleteCharAt(name.length() - 1);

                AverageShotsSettingPanel avgPanel = new AverageShotsSettingPanel();
                avgPanel.setAvgShotName(name.toString());
                int sampleRate = validateOneOrGreater(txtSampleRate_);
                if (sampleRate >= 1) {
                    avgPanel.setSampleRate(sampleRate);
                } else {
                    avgPanel.setSampleRate(30);
                }

                CustomDialog dialog = new CustomDialog(null,
                        "Shot Average Setting", avgPanel,
                        CustomDialog.OK_OPTION);
                dialog.setSize(400, 200);
                dialog.setVisible(true);

                int retval = dialog.getResponseValue();
                String newName = avgPanel.getAvgShotName();
                while (retval == CustomDialog.OK && shotListTableModel_.isNameAlreadyExist(newName)) {
                    avgPanel.doNameAlreadyExist(true);
                    dialog.setVisible(true);
                    retval = dialog.getResponseValue();
                    newName = avgPanel.getAvgShotName();
                }

                if (retval == CustomDialog.OK) {
                    int newSampleRate = avgPanel.getSampleRate();

                    SpectrumShotItem newShotItem = new SpectrumShotItem(newName.replace(",", "_"));
                    newShotItem.setShot(createAverage(shotDatas, newSampleRate));

                    shotListTableModel_.addRow(0, newShotItem);
                    shotListTableModel_.setValueAt(true, 0, 0); //display it

                    logger_.info("Create Avg from highlighted shots.... done");
                } else {
                    logger_.info("Create Avg aborted by user");
                }
            }
        });
    }

    private void doBackgroundRemoval() {

        int[] selectedRow = getSelectedRows();
        if (selectedRow == null || selectedRow.length == 0) {
            return;
        }

        double stepSize = baselineSettingPanel_.getStepSize();
        double wlInterval = baselineSettingPanel_.getWaveLengthInterval();

        if (stepSize < 0 || wlInterval < 0) {
            return;
        }

        ArrayList<SpectrumShotItem> tmpList = new ArrayList<SpectrumShotItem>();
        StringBuilder errMsg = new StringBuilder();

        for (int rowIndex = 0; rowIndex < selectedRow.length; rowIndex++) {
            String name = shotListTableModel_.getRow(selectedRow[rowIndex]).getName();
            name = name + "BgRm";

            if (shotListTableModel_.isNameAlreadyExist(name) == false) {
                Spectrum spectrum = shotListTableModel_.getRow(selectedRow[rowIndex]).getShot();
                BackgroundModel bgModel = new BackgroundModel();
                PolynomialSplineFunction polynomialSplinFunc = bgModel.getModelBaseline(spectrum, stepSize, wlInterval);
                double[] knots = polynomialSplinFunc.getKnots();

                double[] pixels = spectrum.getPixelLocations();
                UnivariateFunction yfun = spectrum.getIntensityFunction();
                double[] yVals = new double[pixels.length];
                for (int i = 0; i < pixels.length; i++) {

                    // if the left end of original wavelength is smaller than the left end of baseline wavelenght
                    // subtraction using the first lowest point in the baseline
                    if (pixels[i] < knots[0]) {
                        yVals[i] = yfun.value(pixels[i]) - polynomialSplinFunc.value(knots[0]);
                    } else if (pixels[i] >= knots[0] && pixels[i] <= knots[knots.length - 1]) {
                        yVals[i] = yfun.value(pixels[i]) - polynomialSplinFunc.value(pixels[i]);
                    } else {
                        // if the right end of original wavelength is greater than the right end of baseline wavelenght
                        // subtraction using the last lowest point in the baseline
                        yVals[i] = yfun.value(pixels[i]) - polynomialSplinFunc.value(knots[knots.length - 1]);
                    }
                }

                RawDataSpectrum rawSpect = new RawDataSpectrum(new double[][]{pixels, yVals});
                SpectrumShotItem shot = new SpectrumShotItem(name);
                shot.setShot(rawSpect);

                tmpList.add(shot);
            } else {
                errMsg.append(name).append("\n");
            }
        }

        for (SpectrumShotItem shot : tmpList) {
            shotListTableModel_.addRow(0, shot);
        }

        if (tmpList.isEmpty() == false) {
            shotListTableModel_.showSeries(0);
        }

        if (errMsg.length() > 0) {
            errMsg.insert(0, "The following shot(s) already exist, skipped:\n");
            showErrorDialog(errMsg.toString());
        }

    }

    private void filterTable() {
        try {
            RowFilter<ShotListTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + txtFilterText_.getText(), 1);
            sorter_.setRowFilter(rowFilter);
        } catch (java.util.regex.PatternSyntaxException ex) {
            logger_.error(ex.getMessage());
        }
    }

    public int getSampleRate() {
        int sampleRate = validateZeroOrGreater(txtSampleRate_);
        if (sampleRate < 1) {
            showErrorDialog("Invalid Sample Rate value: + " + sampleRate);
        }
        return sampleRate;
    }

    public boolean addItem(int index, SpectrumShotItem item) {
        if (shotListTableModel_.isNameAlreadyExist(item.getName())) {
            showErrorDialog("Shot can't be added due to duplicated name:\n" + item.getName());
            return false;
        } else {
            shotListTableModel_.addRow(index, item);
        }

        return true;
    }

    public boolean addItem(SpectrumShotItem item) {
        if (shotListTableModel_.isNameAlreadyExist(item.getName())) {
            showErrorDialog("Shot can't be added due to duplicated name:\n" + item.getName());
            return false;
        } else {
            shotListTableModel_.addRow(item);
        }

        return true;
    }

    public void addItems(ArrayList<SpectrumShotItem> shotItems) {
        StringBuilder errMsg = new StringBuilder();
        for (SpectrumShotItem item : shotItems) {
            if (shotListTableModel_.isNameAlreadyExist(item.getName())) {
                errMsg.append(item.getName()).append(",");
            } else {
                shotListTableModel_.addRow(item);
            }
        }

        if (errMsg.length() != 0) {
            errMsg.insert(0, "The following shot(s) can't be added due to duplicated name:\n");
            errMsg.append("\n");
            showErrorDialog(errMsg.toString());
        }
    }

    public double getIntensityOfLine(int type, double waveLength, double regionWidth) {
        double retval = -1;
        int numOfSelected = tblShots_.getSelectedRowCount();

        if (numOfSelected == 1) {
            int selectedIndex = tblShots_.getSelectedRow();
            int modelIndex = tblShots_.convertRowIndexToModel(selectedIndex);

            SpectrumShotItem shotItem = shotListTableModel_.getRow(modelIndex);

            switch (type) {
                case Constants.PEAK_INTENSITY_FUNC:
                    SimpleIntensityValue peekIntenVal = new SimpleIntensityValue();
                    retval = peekIntenVal.getIntensityOfLine(shotItem.getShot(), waveLength, regionWidth);
                    break;
                case Constants.LORENTZIAN_INTENSITY_FUNC:
                    LorentzianIntensityValue lorentzianIntenVal = new LorentzianIntensityValue();
                    retval = lorentzianIntenVal.getIntensityOfLine(shotItem.getShot(), waveLength, regionWidth);
                    break;
                default:

            }
        } else if (numOfSelected == 0) {
            showErrorDialog("No shot selected to do the region calculation.");
        } else {
            showErrorDialog("Too many shots selected to do the region calculation.\nOnly 1 shot should be selected.");
        }

        return retval;
    }

    public void exportCSV() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                if (shotListTableModel_.getRowCount() > 0) {
                    StringBuilder strBuilder = new StringBuilder();
                    for (int i = 0; i < shotListTableModel_.getRowCount() - 1; i++) {
                        strBuilder.append(shotListTableModel_.getRow(i).toString()).append("\n");
                    }

                    // add the last shot
                    strBuilder.append(shotListTableModel_.getRow(shotListTableModel_.getRowCount() - 1).toString());

                    Util.saveCSVFile(strBuilder);
                } else {
                    showErrorDialog("No data to save.");
                }
            }
        });
    }

    public void importCSV() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {
                ImportExportSpectrum importExporter = new ImportExportSpectrum();
                final ArrayList<SpectrumShotItem> shotItems = importExporter.importCSVFile();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addItems(shotItems);
                    }
                });

            }
        });
    }

    public void exportCSVAll() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                if (shotListTableModel_.getRowCount() > 0) {
                    ArrayList<SpectrumShotItem> items = new ArrayList<SpectrumShotItem>();
                    for (int index = 0; index < shotListTableModel_.getRowCount(); index++) {
                        items.add(shotListTableModel_.getRow(index));
                    }
                    ImportExportSpectrum importExporter = new ImportExportSpectrum();
                    importExporter.exportCSVFile(items);
                } else {
                    showErrorDialog("No data to save.");
                }
            }
        });
    }

    public void exportCSVSelected() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                if (tblShots_.getSelectedRows().length > 0) {
                    ArrayList<SpectrumShotItem> items = new ArrayList<SpectrumShotItem>();
                    int[] selectedRows = tblShots_.getSelectedRows();
                    for (int selectedRow : selectedRows) {
                        int modelIndex = tblShots_.convertRowIndexToModel(selectedRow);
                        items.add(shotListTableModel_.getRow(modelIndex));
                    }
                    ImportExportSpectrum importExporter = new ImportExportSpectrum();
                    importExporter.exportCSVFile(items);
                } else {
                    showErrorDialog("No data to save.");
                }
            }
        });
    }

    public void importJsonGzip() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                ImportExportSpectrum importExporter = new ImportExportSpectrum();
                final ArrayList<SpectrumShotItem> shotItems = importExporter.importJzonGzipFile();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addItems(shotItems);
                    }
                });

            }
        });

    }

    public void exportJsonGzipAll() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                if (shotListTableModel_.getRowCount() > 0) {
                    ArrayList<SpectrumShotItem> items = new ArrayList<SpectrumShotItem>();
                    for (int index = 0; index < shotListTableModel_.getRowCount(); index++) {
                        items.add(shotListTableModel_.getRow(index));
                    }
                    ImportExportSpectrum importExporter = new ImportExportSpectrum();
                    importExporter.exportJzonGzipFile(items);
                } else {
                    showErrorDialog("No data to save.");
                }
            }
        });
    }

    public void exportJsonGzipSelected() {
        ThreadUtils.CPUThreads.execute(new Runnable() {

            @Override
            public void run() {

                if (tblShots_.getSelectedRows().length > 0) {
                    ArrayList<SpectrumShotItem> items = new ArrayList<SpectrumShotItem>();
                    int[] selectedRows = tblShots_.getSelectedRows();
                    for (int selectedRow : selectedRows) {
                        int modelIndex = tblShots_.convertRowIndexToModel(selectedRow);
                        items.add(shotListTableModel_.getRow(modelIndex));
                    }
                    ImportExportSpectrum importExporter = new ImportExportSpectrum();
                    importExporter.exportJzonGzipFile(items);
                } else {
                    showErrorDialog("No data to save.");
                }
            }
        });
    }

    public void showBaselineRemovalSettings() {
        CustomDialog dialog = new CustomDialog(null,
                "Baseline Removal Parameters",
                baselineSettingPanel_, CustomDialog.OK_OPTION);

        dialog.setSize(300, 175);
        dialog.setVisible(true);
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackgroundRemoval_;
    private javax.swing.JButton btnCreateAvg_;
    private javax.swing.JButton btnDeleteScan_;
    private javax.swing.JButton btnDelete_;
    private javax.swing.JButton btnHideShot_;
    private javax.swing.JButton btnShowShotl_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblShots_;
    private javax.swing.JTextField txtFilterText_;
    private javax.swing.JTextField txtSampleRate_;
    // End of variables declaration//GEN-END:variables
}
