/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import com.sciaps.common.webserver.LIBZHttpClient;
import com.sciaps.utils.Util;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author jchen
 */
public final class FrmMain extends javax.swing.JFrame {

    SpectrometerStackPanel spectrometerStackPanel_;
    HTTPConfigPanel httpConfigPanel_;

    /**
     * Creates new form frmMain
     */
    public FrmMain() {
        initComponents();
      
        try {
            ImageIcon img = new ImageIcon("sciaps_icon.png");
            this.setIconImage(img.getImage());
        } catch (Exception ex) {
            System.out.println("Can't load icon image");
        }
        
        httpConfigPanel_ = new HTTPConfigPanel();
        httpConfigPanel_.setParentFrame(this);

        spectrometerStackPanel_ = new SpectrometerStackPanel();
        setDisplayPanel(spectrometerStackPanel_);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                readIPAddress();
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

        displayPanel_ = new javax.swing.JPanel();
        mnuMainBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileExportCSV_ = new javax.swing.JMenuItem();
        mnuFileLoadRegions_ = new javax.swing.JMenuItem();
        mnuFileExit = new javax.swing.JMenuItem();
        mnuConfig = new javax.swing.JMenu();
        mnuConfigSetLibzIP = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Region Finder");

        displayPanel_.setLayout(new java.awt.BorderLayout());
        getContentPane().add(displayPanel_, java.awt.BorderLayout.CENTER);

        mnuMainBar.setToolTipText("");

        mnuFile.setText("File");

        mnuFileExportCSV_.setText("Export CSV");
        mnuFileExportCSV_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileExportCSV_ActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileExportCSV_);

        mnuFileLoadRegions_.setText("Load Region Text");
        mnuFileLoadRegions_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileLoadRegions_ActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileLoadRegions_);

        mnuFileExit.setText("Exit");
        mnuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileExit);

        mnuMainBar.add(mnuFile);

        mnuConfig.setText("Config");

        mnuConfigSetLibzIP.setText("Set LIBZ IP");
        mnuConfigSetLibzIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfigSetLibzIPActionPerformed(evt);
            }
        });
        mnuConfig.add(mnuConfigSetLibzIP);

        mnuMainBar.add(mnuConfig);

        setJMenuBar(mnuMainBar);
        mnuMainBar.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuFileExitActionPerformed

    private void mnuConfigSetLibzIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigSetLibzIPActionPerformed
        httpConfigPanel_.showPopup();
    }//GEN-LAST:event_mnuConfigSetLibzIPActionPerformed

    private void mnuFileExportCSV_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileExportCSV_ActionPerformed
        JOptionPane.showMessageDialog(this, "This function is not yet supported");
    }//GEN-LAST:event_mnuFileExportCSV_ActionPerformed

    private void mnuFileLoadRegions_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileLoadRegions_ActionPerformed
        spectrometerStackPanel_.getRegionTextFromUser();
    }//GEN-LAST:event_mnuFileLoadRegions_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                FrmMain frmMain = new FrmMain();
                frmMain.setSize(new Dimension(1200, 800));
                frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RefineryUtilities.centerFrameOnScreen(frmMain);
                frmMain.setVisible(true);
            }
        });
    }

    public void setDisplayPanel(JComponent panel) {
        displayPanel_.removeAll();
        displayPanel_.add(panel);
        displayPanel_.revalidate();
        displayPanel_.repaint();
    }

    public void displayLibzIPAddress(final String ipAddress) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Region Finder - LIBZ@" + ipAddress);
            }
        });
    }

    private void readIPAddress() {

        String address = Util.getIPAddress();
        if (address != null) {
            Constants.mHttpClient = new LIBZHttpClient("http://" + address + ":9000");
            displayLibzIPAddress(address);
        } else {
            httpConfigPanel_.showPopup();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displayPanel_;
    private javax.swing.JMenu mnuConfig;
    private javax.swing.JMenuItem mnuConfigSetLibzIP;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileExit;
    private javax.swing.JMenuItem mnuFileExportCSV_;
    private javax.swing.JMenuItem mnuFileLoadRegions_;
    private javax.swing.JMenuBar mnuMainBar;
    // End of variables declaration//GEN-END:variables
}
