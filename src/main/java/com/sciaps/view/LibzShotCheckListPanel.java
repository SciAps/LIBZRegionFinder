/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.CheckListShotItem;
import com.sciaps.common.ThreadUtils;
import com.sciaps.common.spectrum.Spectrum;
import com.sciaps.model.ShotListTableModel;
import com.sciaps.utils.CustomDialogUtils;
import static com.sciaps.utils.Util.createAverage;
import static com.sciaps.utils.Util.validateOneOrGreater;
import static com.sciaps.utils.Util.validateZeroOrGreater;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class LibzShotCheckListPanel extends javax.swing.JPanel {

    public interface LibzShotItemClickListenerCallback {

        void doShowShotXYSeries(CheckListShotItem item);

        void doHideShotXYSeries(CheckListShotItem item);
        
        void doDeleteShotXYSeries(CheckListShotItem item);
    }

    private final Logger logger_ = LoggerFactory.getLogger(LibzShotCheckListPanel.class);
    private final ShotListTableModel shotListTableModel_;

    /**
     * List Creates new form LibzListPanel
     *
     * @param callback
     */
    public LibzShotCheckListPanel(LibzShotItemClickListenerCallback callback) {
        initComponents();

        shotListTableModel_ = new ShotListTableModel(callback);
        tblShots_.setModel(shotListTableModel_);
        tblShots_.getTableHeader().setReorderingAllowed(false);

        tblShots_.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblShots_.getColumnModel().getColumn(0).setMinWidth(45);
        tblShots_.getColumnModel().getColumn(0).setMaxWidth(45);
        tblShots_.getColumnModel().getColumn(0).setResizable(false);
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
        txtSampleRate_ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShots_ = new javax.swing.JTable();
        btnShowShotl_ = new javax.swing.JButton();

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
        gridBagConstraints.gridy = 9;
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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnHideShot_, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Shot List:");
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
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
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.gridy = 8;
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

        txtSampleRate_.setText("30");
        txtSampleRate_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSampleRate_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtSampleRate_, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sample Rate:");
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jLabel3, gridBagConstraints);

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
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnShowShotl_, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAvg_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAvg_ActionPerformed

        int[] selectedRows = tblShots_.getSelectedRows();
        if (selectedRows.length == 0) {
            showErrorDialog("No region selected to create average.");
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
                    CheckListShotItem shotItem = (CheckListShotItem) shotListTableModel_.getRow(modelIndex);
                    if (gotScanID == false) {
                        name.append("Scan " + shotItem.getScanID() + " Avg: ");
                        gotScanID = true;
                    }
                    name.append(shotItem.getShotID());
                    name.append(",");

                    shotDatas.add(shotItem.getShot());
                }

                AverageShotsSettingPanel avgPanel = new AverageShotsSettingPanel();
                avgPanel.setAvgShotName(name.toString());
                int sampleRate = validateOneOrGreater(txtSampleRate_);
                if (sampleRate >= 1) {
                    avgPanel.setSampleRate(sampleRate);
                } else {
                    avgPanel.setSampleRate(30);
                }

                JDialog dialog = CustomDialogUtils.createDialog(null,
                        "Shot Average Setting", avgPanel,
                        CustomDialogUtils.OK_OPTION);
                dialog.setSize(400, 180);
                dialog.setVisible(true);

                String newName = avgPanel.getAvgShotName();
                int newSampleRate = avgPanel.getSampleRate();

                CheckListShotItem newShotItem = new CheckListShotItem(newName);
                newShotItem.setShot(createAverage(shotDatas, newSampleRate));

                shotListTableModel_.addRow(0, newShotItem);
                shotListTableModel_.setValueAt(true, 0, 0); //display it

                logger_.info("Create Avg from highlighted shots.... done");
            }
        });
    }

    public int getSampleRate() {
        int sampleRate = validateZeroOrGreater(txtSampleRate_);
        if (sampleRate < 1) {
            showErrorDialog("Invalid Sample Rate value: + " + sampleRate);
        }
        return sampleRate;
    }

    public void addItem(int index, CheckListShotItem item) {
        shotListTableModel_.addRow(index, item);
    }

    public void addItem(CheckListShotItem item) {
        shotListTableModel_.addRow(item);
    }

    public int getNumberOfSelectedItem() {
        return tblShots_.getSelectedRowCount();
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAvg_;
    private javax.swing.JButton btnDeleteScan_;
    private javax.swing.JButton btnDelete_;
    private javax.swing.JButton btnHideShot_;
    private javax.swing.JButton btnShowShotl_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblShots_;
    private javax.swing.JTextField txtSampleRate_;
    // End of variables declaration//GEN-END:variables
}
