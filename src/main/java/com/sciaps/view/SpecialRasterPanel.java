/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import com.sciaps.common.webserver.ILaserController.RasterParams;
import com.sciaps.utils.Util;
import static com.sciaps.utils.Util.validateOneOrGreater;
import static com.sciaps.utils.Util.validateZeroOrGreater;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class SpecialRasterPanel extends javax.swing.JPanel {

    private final Logger logger_ = LoggerFactory.getLogger(SpecialRasterPanel.class);

    private int iLocationsVal_ = 0;
    private int iDataShotsVal_ = 0;
    private int iArgonPreflushVal_ = 0;
    private int iStepSizeVal_ = 0;
    private int iPulsePeriodVal_ = 0;
    private int iIntegrationDelayVal_ = 0;
    private int iIntegrationPeriodVal_ = 0;
    private int iStartPositionXVal_ = 0;
    private int iStartPositionYVal_ = 0;
    private int iStartPositionZVal_ = 0;
    private int iStopPositionXVal_ = 0;
    private int iStopPositionYVal_ = 0;
    private boolean chkGatingVal_ = false;
    private boolean chkResetStageVal_ = false;

    /**
     * Creates new form SpecialRasterPanel
     */
    public SpecialRasterPanel() {
        initComponents();
        
        ImageIcon icon = createImageIcon("/images/help.png");
        btnDataShotHelp_.setIcon(icon);
        btnArgonPreflushHelp_.setIcon(icon);
        btnStepSizeHelp_.setIcon(icon);
        btnPulsePeriodHelp_.setIcon(icon);
        btnIntegrationDelayHelp_.setIcon(icon);
        btnIntegrationPeriodHelp_.setIcon(icon);
        btnStartPositionHelp_.setIcon(icon);
        btnStopPositionHelp_.setIcon(icon);
        
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

        txtDataShots_ = new javax.swing.JTextField();
        txtArgonPreflush_ = new javax.swing.JTextField();
        txtIntegrationDelay_ = new javax.swing.JTextField();
        txtLocations_ = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chkGating_ = new javax.swing.JCheckBox();
        chkResetStage_ = new javax.swing.JCheckBox();
        txtPulsePeriod_ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStopPosition_ = new javax.swing.JTextField();
        txtStartPosition_ = new javax.swing.JTextField();
        txtIntegrationPeriod_ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtStepSize_ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnArgonPreflushHelp_ = new javax.swing.JButton();
        btnDataShotHelp_ = new javax.swing.JButton();
        lblHelp_ = new javax.swing.JLabel();
        btnStartPositionHelp_ = new javax.swing.JButton();
        btnIntegrationPeriodHelp_ = new javax.swing.JButton();
        btnIntegrationDelayHelp_ = new javax.swing.JButton();
        btnPulsePeriodHelp_ = new javax.swing.JButton();
        btnStepSizeHelp_ = new javax.swing.JButton();
        btnStopPositionHelp_ = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(260, 380));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.GridBagLayout());

        txtDataShots_.setText("5");
        txtDataShots_.setToolTipText("Shots per location");
        txtDataShots_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtDataShots_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtDataShots_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataShots_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtDataShots_, gridBagConstraints);

        txtArgonPreflush_.setText("0");
        txtArgonPreflush_.setToolTipText("0 turns off argon");
        txtArgonPreflush_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtArgonPreflush_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtArgonPreflush_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArgonPreflush_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtArgonPreflush_, gridBagConstraints);

        txtIntegrationDelay_.setText("0");
        txtIntegrationDelay_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtIntegrationDelay_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtIntegrationDelay_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIntegrationDelay_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtIntegrationDelay_, gridBagConstraints);

        txtLocations_.setText("1");
        txtLocations_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLocations_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtLocations_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocations_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtLocations_, gridBagConstraints);

        jLabel1.setText("Locations");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel1, gridBagConstraints);

        jLabel4.setText("Data Shots");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Integ. Delay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Argon Preflush");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel6, gridBagConstraints);

        chkGating_.setSelected(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(chkGating_, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(chkResetStage_, gridBagConstraints);

        txtPulsePeriod_.setText("100");
        txtPulsePeriod_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPulsePeriod_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtPulsePeriod_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPulsePeriod_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtPulsePeriod_, gridBagConstraints);

        jLabel8.setText("Pulse Period");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel8, gridBagConstraints);

        txtStopPosition_.setText("80,80");
        txtStopPosition_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStopPosition_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStopPosition_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStopPosition_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 1);
        add(txtStopPosition_, gridBagConstraints);

        txtStartPosition_.setText("60,60,80");
        txtStartPosition_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStartPosition_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStartPosition_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStartPosition_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtStartPosition_, gridBagConstraints);

        txtIntegrationPeriod_.setText("0");
        txtIntegrationPeriod_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtIntegrationPeriod_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtIntegrationPeriod_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIntegrationPeriod_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtIntegrationPeriod_, gridBagConstraints);

        jLabel9.setText("Gating");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel9, gridBagConstraints);

        jLabel10.setText("Start Pos. X,Y,Z");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel10, gridBagConstraints);

        jLabel11.setText("Integ. Period");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel11, gridBagConstraints);

        jLabel12.setText("Step Size");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel12, gridBagConstraints);

        txtStepSize_.setText("20");
        txtStepSize_.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStepSize_.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStepSize_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStepSize_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtStepSize_, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Raster Setting");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 6, 0);
        add(jLabel2, gridBagConstraints);

        btnArgonPreflushHelp_.setToolTipText("0 turns off argon");
        btnArgonPreflushHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnArgonPreflushHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnArgonPreflushHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnArgonPreflushHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnArgonPreflushHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArgonPreflushHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnArgonPreflushHelp_, gridBagConstraints);

        btnDataShotHelp_.setToolTipText("Shots per location");
        btnDataShotHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDataShotHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnDataShotHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnDataShotHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnDataShotHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataShotHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnDataShotHelp_, gridBagConstraints);

        lblHelp_.setForeground(new java.awt.Color(0, 51, 255));
        lblHelp_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(lblHelp_, gridBagConstraints);

        btnStartPositionHelp_.setToolTipText("");
        btnStartPositionHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnStartPositionHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnStartPositionHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnStartPositionHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnStartPositionHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartPositionHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnStartPositionHelp_, gridBagConstraints);

        btnIntegrationPeriodHelp_.setToolTipText("");
        btnIntegrationPeriodHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnIntegrationPeriodHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnIntegrationPeriodHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnIntegrationPeriodHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnIntegrationPeriodHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrationPeriodHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnIntegrationPeriodHelp_, gridBagConstraints);

        btnIntegrationDelayHelp_.setToolTipText("");
        btnIntegrationDelayHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnIntegrationDelayHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnIntegrationDelayHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnIntegrationDelayHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnIntegrationDelayHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrationDelayHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnIntegrationDelayHelp_, gridBagConstraints);

        btnPulsePeriodHelp_.setToolTipText("");
        btnPulsePeriodHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPulsePeriodHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnPulsePeriodHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnPulsePeriodHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnPulsePeriodHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulsePeriodHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnPulsePeriodHelp_, gridBagConstraints);

        btnStepSizeHelp_.setToolTipText("");
        btnStepSizeHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnStepSizeHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnStepSizeHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnStepSizeHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnStepSizeHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStepSizeHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnStepSizeHelp_, gridBagConstraints);

        btnStopPositionHelp_.setToolTipText("");
        btnStopPositionHelp_.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnStopPositionHelp_.setMaximumSize(new java.awt.Dimension(25, 25));
        btnStopPositionHelp_.setMinimumSize(new java.awt.Dimension(25, 25));
        btnStopPositionHelp_.setPreferredSize(new java.awt.Dimension(25, 25));
        btnStopPositionHelp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopPositionHelp_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(btnStopPositionHelp_, gridBagConstraints);

        jLabel13.setText("Reset Stage");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel13, gridBagConstraints);

        jLabel14.setText("Stop Pos. X,Y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel14, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocations_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocations_KeyReleased
        validateOneOrGreater(txtLocations_);
    }//GEN-LAST:event_txtLocations_KeyReleased

    private void txtDataShots_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataShots_KeyReleased
        validateOneOrGreater(txtDataShots_);
    }//GEN-LAST:event_txtDataShots_KeyReleased

    private void txtArgonPreflush_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArgonPreflush_KeyReleased
        validateZeroOrGreater(txtArgonPreflush_);
    }//GEN-LAST:event_txtArgonPreflush_KeyReleased

    private void txtPulsePeriod_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPulsePeriod_KeyReleased
        validateZeroOrGreater(txtPulsePeriod_);
    }//GEN-LAST:event_txtPulsePeriod_KeyReleased

    private void txtIntegrationDelay_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntegrationDelay_KeyReleased
        validateZeroOrGreater(txtIntegrationDelay_);
    }//GEN-LAST:event_txtIntegrationDelay_KeyReleased

    private void txtIntegrationPeriod_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntegrationPeriod_KeyReleased
        validateZeroOrGreater(txtIntegrationPeriod_);
    }//GEN-LAST:event_txtIntegrationPeriod_KeyReleased

    private void txtStepSize_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStepSize_KeyReleased
        validateZeroOrGreater(txtStepSize_);
    }//GEN-LAST:event_txtStepSize_KeyReleased

    private void txtStartPosition_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartPosition_KeyReleased
        if (Util.validePositionXYZ(txtStartPosition_.getText())) {
            txtStartPosition_.setBackground(Color.white);
        } else {
            txtStartPosition_.setBackground(Color.red);
        }
    }//GEN-LAST:event_txtStartPosition_KeyReleased

    private void txtStopPosition_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStopPosition_KeyReleased
        if (Util.validePositionXY(txtStopPosition_.getText())) {
            txtStopPosition_.setBackground(Color.white);
        } else {
            txtStopPosition_.setBackground(Color.red);
        }
    }//GEN-LAST:event_txtStopPosition_KeyReleased

    private void btnDataShotHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataShotHelp_ActionPerformed
        showHint("Data shot: shots per location");
    }//GEN-LAST:event_btnDataShotHelp_ActionPerformed

    private void btnArgonPreflushHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArgonPreflushHelp_ActionPerformed
        showHint("Argon Preflush: 0 turns off argon");
    }//GEN-LAST:event_btnArgonPreflushHelp_ActionPerformed

    private void btnStartPositionHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartPositionHelp_ActionPerformed
        showHint("Start Position");
    }//GEN-LAST:event_btnStartPositionHelp_ActionPerformed

    private void btnIntegrationPeriodHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrationPeriodHelp_ActionPerformed
        showHint("Integration Period");
    }//GEN-LAST:event_btnIntegrationPeriodHelp_ActionPerformed

    private void btnIntegrationDelayHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrationDelayHelp_ActionPerformed
        showHint("Integration Delay");
    }//GEN-LAST:event_btnIntegrationDelayHelp_ActionPerformed

    private void btnPulsePeriodHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulsePeriodHelp_ActionPerformed
        showHint("Pulse Period");
    }//GEN-LAST:event_btnPulsePeriodHelp_ActionPerformed

    private void btnStepSizeHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStepSizeHelp_ActionPerformed
        showHint("Step Size");
    }//GEN-LAST:event_btnStepSizeHelp_ActionPerformed

    private void btnStopPositionHelp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopPositionHelp_ActionPerformed
        showHint("Stop Position");
    }//GEN-LAST:event_btnStopPositionHelp_ActionPerformed

    private void showHint(String hint) {
        
        if (lblHelp_.getText().compareTo(hint) != 0) {
            lblHelp_.setText(hint);
        } else {
           lblHelp_.setText("");
        }
    }
    private boolean setXYZ(String str) {
        boolean isGood = true;

        String[] tmp = str.split(",");

        try {
            iStartPositionXVal_ = Integer.parseInt(tmp[0].trim());
            iStartPositionYVal_ = Integer.parseInt(tmp[1].trim());
            iStartPositionZVal_ = Integer.parseInt(tmp[2].trim());
        } catch (Exception ex) {
            isGood = false;
            showErrorDialog("Invalid Start Position.");
        }

        return isGood;
    }

    private boolean setXY(String str) {
        boolean isGood = true;

        String[] tmp = str.split(",");

        try {

            iStopPositionXVal_ = Integer.parseInt(tmp[0].trim());
            iStopPositionYVal_ = Integer.parseInt(tmp[1].trim());

        } catch (Exception ex) {
            isGood = false;
            showErrorDialog("Invalid Stop Position.");
        }

        return isGood;
    }

    private boolean validateAll() {
        boolean bAllValid = true;

        iStartPositionXVal_ = 0;
        iStartPositionYVal_ = 0;
        iStartPositionZVal_ = 0;
        iStopPositionXVal_ = 0;
        iStopPositionYVal_ = 0;

        if (setXYZ(txtStartPosition_.getText()) == false) {
            return false;
        }

        if (setXY(txtStopPosition_.getText()) == false) {
            return false;
        } else {

            if ((iStopPositionXVal_ <= iStartPositionXVal_) || (iStopPositionYVal_ <= iStartPositionYVal_)) {

                showErrorDialog("Invalid Stop Position. It must be larger than Start Position");
                return false;
            }
        }

        try {

            iLocationsVal_ = validateOneOrGreater(txtLocations_);
            iDataShotsVal_ = validateOneOrGreater(txtDataShots_);
            iArgonPreflushVal_ = validateZeroOrGreater(txtArgonPreflush_);
            iStepSizeVal_ = validateZeroOrGreater(txtStepSize_);
            iPulsePeriodVal_ = validateZeroOrGreater(txtPulsePeriod_);
            iIntegrationDelayVal_ = validateZeroOrGreater(txtIntegrationDelay_);
            iIntegrationPeriodVal_ = validateZeroOrGreater(txtIntegrationPeriod_);

            if (iLocationsVal_ < 1
                    || iDataShotsVal_ < 1
                    || iArgonPreflushVal_ < 0
                    || iStepSizeVal_ < 0
                    || iPulsePeriodVal_ < 0
                    || iIntegrationDelayVal_ < 0
                    || iIntegrationPeriodVal_ < 0) {
                throw new NumberFormatException("");
            }

            chkGatingVal_ = chkGating_.isSelected();

            chkResetStageVal_ = chkResetStage_.isSelected();

        } catch (NumberFormatException ex) {
            bAllValid = false;
            showErrorDialog("Raster Setting Contains Invalid Data.\nOnly Positive Integer Is Accepted.");
        }

        return bAllValid;
    }

    public RasterParams getRasterData() {

        RasterParams retval = new RasterParams();
        if (validateAll() == true) {
            retval.startLocation = new int[]{
                iStartPositionXVal_,
                iStartPositionYVal_,
                iStartPositionZVal_};
            retval.endLocation = new int[]{iStopPositionXVal_, iStopPositionYVal_};
            retval.argonpreflush = iArgonPreflushVal_;
            retval.intergrationDelay = iIntegrationDelayVal_;
            retval.intergrationPeriod = iIntegrationPeriodVal_;
            retval.numdatashotperlocation = iDataShotsVal_;
            retval.numlocations = iLocationsVal_;
            retval.pulsePeriod = iPulsePeriodVal_;
            retval.resetStage = chkResetStageVal_;
            retval.stepSize = iStepSizeVal_;
            retval.useGating = chkGatingVal_;
        } else {
            retval = null;
        }

        return retval;
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(Constants.MAIN_FRAME, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    private ImageIcon createImageIcon(String path) {
        
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);         
        }
        
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArgonPreflushHelp_;
    private javax.swing.JButton btnDataShotHelp_;
    private javax.swing.JButton btnIntegrationDelayHelp_;
    private javax.swing.JButton btnIntegrationPeriodHelp_;
    private javax.swing.JButton btnPulsePeriodHelp_;
    private javax.swing.JButton btnStartPositionHelp_;
    private javax.swing.JButton btnStepSizeHelp_;
    private javax.swing.JButton btnStopPositionHelp_;
    private javax.swing.JCheckBox chkGating_;
    private javax.swing.JCheckBox chkResetStage_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblHelp_;
    private javax.swing.JTextField txtArgonPreflush_;
    private javax.swing.JTextField txtDataShots_;
    private javax.swing.JTextField txtIntegrationDelay_;
    private javax.swing.JTextField txtIntegrationPeriod_;
    private javax.swing.JTextField txtLocations_;
    private javax.swing.JTextField txtPulsePeriod_;
    private javax.swing.JTextField txtStartPosition_;
    private javax.swing.JTextField txtStepSize_;
    private javax.swing.JTextField txtStopPosition_;
    // End of variables declaration//GEN-END:variables
}
