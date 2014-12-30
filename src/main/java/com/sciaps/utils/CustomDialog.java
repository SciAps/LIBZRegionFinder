package com.sciaps.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jchen
 */
public class CustomDialog extends JDialog {

    public static final int DEFAULT_OPTION = -1;
    public static final int OK_OPTION = 0;
    public static final int OK_CANCEL_OPTION = 1;
    public static final int NONE_OPTION = 2;
    public static final int NONE = -1;
    public static final int CANCEL = 0;
    public static final int OK = 1;

    private int responseValue_ = NONE;

    public interface CustomDialogCallback {

        boolean getDialogCloseConfirmation();
    }

    public CustomDialog(JFrame frame, String title, final JPanel customPanel, int optionType) {
        super(frame, title, true);

        this.setResizable(false);

        JPanel container = new JPanel();
        container.setLayout(new java.awt.GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        container.add(customPanel, gridBagConstraints);

        JPanel controlOptionPanel = new JPanel();
        switch (optionType) {
            case OK_CANCEL_OPTION:
                JButton btnCancel = new JButton("Cancel");
                btnCancel.setPreferredSize(new Dimension(100, 30));
                btnCancel.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        responseValue_ = CANCEL;
                        dispose();
                    }
                });

                this.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        responseValue_ = CANCEL;
                        e.getWindow().dispose();
                    }
                });
                controlOptionPanel.add(btnCancel);
            // it is design to not have a break in here, so the OK button can added
            case OK_OPTION:

                JButton btnOK = new JButton("OK");
                btnOK.setPreferredSize(new Dimension(100, 30));
                btnOK.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        responseValue_ = OK;
                        if (customPanel instanceof CustomDialogCallback) {
                            CustomDialogCallback custom = (CustomDialogCallback) customPanel;
                            if (custom.getDialogCloseConfirmation()) {
                                dispose();
                            }
                        }
                    }
                });
                this.getRootPane().setDefaultButton(btnOK);
                controlOptionPanel.add(btnOK);

                // Because the previous case statement has not break point, 
                // this check is required so to avoid having two listeners that 
                // checking on two different things
                if (optionType == OK_OPTION) {
                    this.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            responseValue_ = CANCEL;
                            if (customPanel instanceof CustomDialogCallback) {
                                CustomDialogCallback custom = (CustomDialogCallback) customPanel;
                                if (custom.getDialogCloseConfirmation()) {
                                    dispose();
                                }
                            }
                        }
                    });
                }
                break;
            case NONE_OPTION:
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                break;
            default:

        }

        if (optionType == OK_OPTION || optionType == OK_CANCEL_OPTION) {
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 0;
            container.add(controlOptionPanel, gridBagConstraints);
        }

        this.add(BorderLayout.CENTER, container);
        this.setLocationRelativeTo(frame);
    }

    public int getResponseValue() {
        return responseValue_;
    }
}
