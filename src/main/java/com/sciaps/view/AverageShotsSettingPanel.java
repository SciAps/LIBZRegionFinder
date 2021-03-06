/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import com.sciaps.utils.CustomDialog.CustomDialogCallback;
import static com.sciaps.utils.Util.validateZeroOrGreater;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class AverageShotsSettingPanel extends javax.swing.JPanel implements CustomDialogCallback {

    private final Logger logger_ = LoggerFactory.getLogger(AverageShotsSettingPanel.class);
    private int sampleRate_;
    private String avgShotName_;

    /**
     * Creates new form HTTPConfigPanel
     */
    public AverageShotsSettingPanel() {
        initComponents();
        sampleRate_ = 30;
        avgShotName_ = "No Name";
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

        jLabel1 = new javax.swing.JLabel();
        txtName_ = new javax.swing.JTextField();
        lblNameExistWarning_ = new javax.swing.JLabel();
        txtSampleRate_ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Enter Name For This Average:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(jLabel1, gridBagConstraints);

        txtName_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtName_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 4);
        add(txtName_, gridBagConstraints);

        lblNameExistWarning_.setForeground(new java.awt.Color(255, 0, 0));
        lblNameExistWarning_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        add(lblNameExistWarning_, gridBagConstraints);

        txtSampleRate_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSampleRate_.setText("30");
        txtSampleRate_.setMaximumSize(new java.awt.Dimension(77, 21));
        txtSampleRate_.setMinimumSize(new java.awt.Dimension(77, 21));
        txtSampleRate_.setPreferredSize(new java.awt.Dimension(77, 21));
        txtSampleRate_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSampleRate_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(txtSampleRate_, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Shot Average Setting");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 6, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Enter Sample Rate Per Nanometer:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(jLabel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSampleRate_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSampleRate_KeyReleased
        validateZeroOrGreater(txtSampleRate_);
    }//GEN-LAST:event_txtSampleRate_KeyReleased

    private void txtName_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtName_KeyReleased
        avgShotName_ = txtName_.getText();
        if (avgShotName_.isEmpty()) {
            txtName_.setBackground(Color.red);
        } else {
            txtName_.setBackground(Color.white);
            lblNameExistWarning_.setText("");
        }
    }//GEN-LAST:event_txtName_KeyReleased

    private boolean validateData() {
        boolean allGood = true;

        try {
            sampleRate_ = validateZeroOrGreater(txtSampleRate_);
            if (sampleRate_ < 1) {
                allGood = false;
                showErrorDialog("Sample rate must be greater than 0");
            }
            avgShotName_ = txtName_.getText();
            if (avgShotName_.isEmpty()) {
                allGood = false;
                showErrorDialog("Name field can not be blank.");
            }
        } catch (NumberFormatException ex) {
            allGood = false;
        }

        return allGood;
    }

    public void setAvgShotName(String name) {
        avgShotName_ = name;
        txtName_.setText(name);
    }

    public String getAvgShotName() {
        return avgShotName_;
    }

    public void setSampleRate(int sampleRate) {
        sampleRate_ = sampleRate;
        txtSampleRate_.setText(String.valueOf(sampleRate));
    }

    public int getSampleRate() {
        return sampleRate_;
    }

    public void doNameAlreadyExist(boolean val) {
        if (val) {
            txtName_.setBackground(Color.red);
            lblNameExistWarning_.setText("ERROR: Name already exist.");
        } else {
            txtName_.setBackground(Color.white);
            lblNameExistWarning_.setText("");
        }
    }
    
    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(Constants.MAIN_FRAME, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblNameExistWarning_;
    private javax.swing.JTextField txtName_;
    private javax.swing.JTextField txtSampleRate_;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean getDialogCloseConfirmation() {
        return validateData();
    }
}
