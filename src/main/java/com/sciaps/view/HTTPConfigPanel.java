/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import com.sciaps.common.webserver.LIBZHttpClient;
import com.sciaps.utils.CustomDialogUtils.CustomDialogCallback;
import com.sciaps.utils.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class HTTPConfigPanel extends javax.swing.JPanel implements CustomDialogCallback {

    private final Logger logger_ = LoggerFactory.getLogger(HTTPConfigPanel.class);

    private FrmMain frmParent_;

    /**
     * Creates new form HTTPConfigPanel
     */
    public HTTPConfigPanel() {
        initComponents();

        initializeDisplay();

        frmParent_ = null;
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
        txtIPAddress_ = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Enter LIBZ IP Address (example: 10.98.100.80)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jLabel1, gridBagConstraints);

        txtIPAddress_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIPAddress_.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(txtIPAddress_, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void initializeDisplay() {

        String ip = Util.getIPAddress();

        if (ip != null) {
            txtIPAddress_.setText(ip);
            txtIPAddress_.setSelectionStart(0);
            txtIPAddress_.setSelectionEnd(ip.length());
        } else {
            txtIPAddress_.setText("127.0.0.1");
        }

    }

    private boolean doSave() {
        String ipaddress = txtIPAddress_.getText();
        if (com.sciaps.utils.Util.validateIPAddress(ipaddress)) {

            saveIPAddress(ipaddress);

            Constants.mHttpClient = new LIBZHttpClient("http://" + ipaddress + ":9000");
            return true;
        } else {
            showErrorDialog("Invalid IP Address Syntax");
            return false;
        }
    }

    private void saveIPAddress(String ipaddress) {
        logger_.info("Saving LIBZ IP Address: " + ipaddress);
        try {
            File file = new File(Constants.LIBZ_URL_FILE_NAME);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ipaddress);
            bw.close();

            if (frmParent_ != null) {
                frmParent_.displayLibzIPAddress(ipaddress);
            }

            logger_.info("Save LIBZ IP Address: Done");
        } catch (IOException ex) {
            showErrorDialog("Save LIBZ IP Address Failed. " + ex.getMessage());
        }
    }

    public void setParentFrame(FrmMain frame) {
        frmParent_ = frame;
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtIPAddress_;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean getDialogCloseConfirmation() {
        return doSave();
    }
}
