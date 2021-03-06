/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import com.sciaps.utils.CustomDialog.CustomDialogCallback;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class BaselineRemovalSettingsPanel extends javax.swing.JPanel implements CustomDialogCallback {

    private final Logger logger_ = LoggerFactory.getLogger(BaselineRemovalSettingsPanel.class);
    private double waveLengthInterval_ = 0;
    private double stepSize_ = 0;

    /**
     * Creates new form BaseLineRemovalSettingsPanel
     */
    public BaselineRemovalSettingsPanel() {
        initComponents();

        waveLengthInterval_ = 5;
        stepSize_ = 1;
        txtWLInterval_.setText(String.valueOf(waveLengthInterval_));
        txtStepSize_.setText(String.valueOf(stepSize_));

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
        txtWLInterval_ = new javax.swing.JTextField();
        txtStepSize_ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Wave Length Interval (nm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 0);
        add(jLabel1, gridBagConstraints);

        txtWLInterval_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtWLInterval_.setText("5");
        txtWLInterval_.setMaximumSize(new java.awt.Dimension(77, 21));
        txtWLInterval_.setMinimumSize(new java.awt.Dimension(77, 21));
        txtWLInterval_.setPreferredSize(new java.awt.Dimension(77, 21));
        txtWLInterval_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWLInterval_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 4);
        add(txtWLInterval_, gridBagConstraints);

        txtStepSize_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStepSize_.setText("1");
        txtStepSize_.setMaximumSize(new java.awt.Dimension(77, 21));
        txtStepSize_.setMinimumSize(new java.awt.Dimension(77, 21));
        txtStepSize_.setPreferredSize(new java.awt.Dimension(77, 21));
        txtStepSize_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStepSize_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(txtStepSize_, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Baseline Removal Setting");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 6, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Step Size (nm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(jLabel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtWLInterval_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWLInterval_KeyReleased
        waveLengthInterval_ = getPositiveDoubleValue(txtWLInterval_);
    }//GEN-LAST:event_txtWLInterval_KeyReleased

    private void txtStepSize_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStepSize_KeyReleased
        stepSize_ = getPositiveDoubleValue(txtStepSize_);
    }//GEN-LAST:event_txtStepSize_KeyReleased

    private double getPositiveDoubleValue(JTextField textField) {
        double retVal = Double.NaN;

        try {
            retVal = Double.parseDouble(textField.getText());
            if (retVal > 0) {
                textField.setBackground(Color.white);
            } else {
                retVal = Double.NaN;
                textField.setBackground(Color.red);
            }
        } catch (NumberFormatException e) {
            retVal = Double.NaN;
            textField.setBackground(Color.red);
        }

        return retVal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtStepSize_;
    private javax.swing.JTextField txtWLInterval_;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean getDialogCloseConfirmation() {
        return !(Double.isNaN(waveLengthInterval_) || Double.isNaN(stepSize_));
    }

    public double getWaveLengthInterval() {

        if (waveLengthInterval_ == Double.NaN) {
            showErrorDialog("Invalid Wavelength Interval.");
            return 0;
        }

        return waveLengthInterval_;
    }

    public double getStepSize() {
        if (stepSize_ == Double.NaN) {
            showErrorDialog("Invalid Wavelength Interval.");
            return 0;
        }
        return stepSize_;
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(Constants.MAIN_FRAME, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
