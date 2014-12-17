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
public class CustomDialogUtils {

    public static final int DEFAULT_OPTION = -1;
    public static final int OK_OPTION = 0;
    public static final int OK_CANCEL_OPTION = 1;

    public interface CustomDialogCallbackPanel {

        boolean getDialogCloseConfirmation();
    }

    public static JDialog createDialog(JFrame frame, String title, final JPanel customPanel, int optionType) {
        final JDialog dialog = new JDialog(frame, title, true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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
                        dialog.dispose();
                    }
                });

                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose();
                    }
                });
                controlOptionPanel.add(btnCancel);
            case OK_OPTION:

                JButton btnOK = new JButton("OK");
                btnOK.setPreferredSize(new Dimension(100, 30));
                btnOK.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if (customPanel instanceof CustomDialogCallbackPanel) {
                            CustomDialogCallbackPanel custom = (CustomDialogCallbackPanel) customPanel;
                            if (custom.getDialogCloseConfirmation()) {
                                dialog.dispose();
                            }
                        }
                    }
                });
                controlOptionPanel.add(btnOK);
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

        dialog.add(BorderLayout.CENTER, container);
        dialog.setLocationRelativeTo(frame);
        return dialog;
    }

}
