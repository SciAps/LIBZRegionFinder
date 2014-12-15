/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.CheckListShotItem;
import com.sciaps.common.ThreadUtils;
import com.sciaps.common.spectrum.Spectrum;
import static com.sciaps.utils.Util.createAverage;
import static com.sciaps.utils.Util.validateOneOrGreater;
import static com.sciaps.utils.Util.validateZeroOrGreater;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class LibzShotCheckListPanel extends javax.swing.JPanel {

    public interface LibzShotItemClickListenerCallback {

        void doShowShotXYSeries(CheckListShotItem item);

        void doRemoveShotXYSeries(CheckListShotItem item);
    }

    private final Logger logger_ = LoggerFactory.getLogger(LibzShotCheckListPanel.class);
    private final DefaultListModel<CheckListShotItem> listModel_;
    private LibzShotItemClickListenerCallback callbackListener_;

    /**
     * List Creates new form LibzListPanel
     *
     * @param callback
     */
    public LibzShotCheckListPanel(LibzShotItemClickListenerCallback callback) {
        initComponents();

        callbackListener_ = callback;

        listModel_ = new DefaultListModel<CheckListShotItem>();

        lstOfShots_.setCellRenderer(new CheckboxListCellRenderer());
        lstOfShots_.setModel(listModel_);

        lstOfShots_.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {

                if (!event.isControlDown() && !event.isShiftDown()) {

                    JList list = (JList) event.getSource();

                    // Get index of item clicked
                    int index = list.locationToIndex(event.getPoint());

                    // return if nothing selected
                    if (index == -1) {
                        return;
                    }

                    CheckListShotItem item = (CheckListShotItem) list.getModel().getElementAt(index);

                    // Toggle selected state
                    item.setSelected(!item.isSelected());

                    if (callbackListener_ != null) {
                        if (item.isSelected()) {
                            callbackListener_.doShowShotXYSeries(item);
                        } else {
                            callbackListener_.doRemoveShotXYSeries(item);
                        }
                    }

                    // Repaint cell
                    list.repaint(list.getCellBounds(index, index));

                    btnCreateAvg_.setEnabled(false);
                    btnDeleteHighlightedItems_.setEnabled(false);
                } else {
                    btnCreateAvg_.setEnabled(true);
                    btnDeleteHighlightedItems_.setEnabled(true);
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstOfShots_ = new javax.swing.JList();
        btnCreateAvg_ = new javax.swing.JButton();
        btnUncheckAll_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteScan_ = new javax.swing.JButton();
        btnDeleteHighlightedItems_ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSampleRate_ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(160, 190));
        setMinimumSize(new java.awt.Dimension(160, 190));
        setPreferredSize(new java.awt.Dimension(160, 190));
        setLayout(new java.awt.GridBagLayout());

        lstOfShots_.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstOfShots_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        btnCreateAvg_.setText("Create Avg");
        btnCreateAvg_.setToolTipText("Create An Avg of All Highlighted");
        btnCreateAvg_.setEnabled(false);
        btnCreateAvg_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAvg_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnCreateAvg_, gridBagConstraints);

        btnUncheckAll_.setText("Uncheck All");
        btnUncheckAll_.setToolTipText("Uncheck All and Remove Graph");
        btnUncheckAll_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUncheckAll_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnUncheckAll_, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Shot List:");
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        btnDeleteScan_.setText("Del Scan");
        btnDeleteScan_.setToolTipText("Delete All Shots In A Scan");
        btnDeleteScan_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteScan_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnDeleteScan_, gridBagConstraints);

        btnDeleteHighlightedItems_.setText("Del Highlighted");
        btnDeleteHighlightedItems_.setToolTipText("Delete All Hightlighted");
        btnDeleteHighlightedItems_.setEnabled(false);
        btnDeleteHighlightedItems_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHighlightedItems_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(btnDeleteHighlightedItems_, gridBagConstraints);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAvg_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAvg_ActionPerformed
        doCreateAvg();
    }//GEN-LAST:event_btnCreateAvg_ActionPerformed

    private void btnUncheckAll_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUncheckAll_ActionPerformed
        doUncheckAll();
    }//GEN-LAST:event_btnUncheckAll_ActionPerformed

    private void btnDeleteScan_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteScan_ActionPerformed
        doDeleteScan();
    }//GEN-LAST:event_btnDeleteScan_ActionPerformed

    private void btnDeleteHighlightedItems_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHighlightedItems_ActionPerformed
        doDeleteHighLigtedItems();
    }//GEN-LAST:event_btnDeleteHighlightedItems_ActionPerformed

    private void txtSampleRate_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSampleRate_KeyReleased
        validateOneOrGreater(txtSampleRate_);
    }//GEN-LAST:event_txtSampleRate_KeyReleased

    private void doDeleteScan() {
        boolean allgood = false;

        if (listModel_.getSize() == 0) {
            showErrorDialog("List is Empty. Nothing to remove.");
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
                        doRemoveScan(scanID);
                    }
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Scan #: " + retval);
                }
            }
        }
    }

    private void doDeleteHighLigtedItems() {
        int highLightedIndex = lstOfShots_.getSelectedIndex();
        while (highLightedIndex >= 0) {
            listModel_.removeElementAt(highLightedIndex);
            highLightedIndex = lstOfShots_.getSelectedIndex();
        }
    }

    private void doUncheckAll() {

        for (int i = 0; i < listModel_.getSize(); i++) {
            CheckListShotItem shotItem = (CheckListShotItem) listModel_.getElementAt(i);
            shotItem.setSelected(false);
            if (callbackListener_ != null) {
                callbackListener_.doRemoveShotXYSeries(shotItem);
            }
        }

        lstOfShots_.repaint();
    }

    private void doCreateAvg() {

        ThreadUtils.CPUThreads.execute(new Runnable() {
            @Override
            public void run() {

                logger_.info("Creating avg from highlighted shots...");

                StringBuilder name = new StringBuilder();

                CheckListShotItem newShotItem = new CheckListShotItem();

                boolean gotScanID = false;
                int[] selectedList = lstOfShots_.getSelectedIndices();
                List<Spectrum> shotDatas = new ArrayList<Spectrum>();

                for (int i = 0; i < selectedList.length; i++) {
                    CheckListShotItem shotItem = (CheckListShotItem) listModel_.getElementAt(selectedList[i]);
                    if (gotScanID == false) {
                        name.append("Scan " + shotItem.getScanID() + ": ");
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
                avgPanel.showPopup();

                String newName = avgPanel.getAvgShotName();
                int newSampleRate = avgPanel.getSampleRate();

                newShotItem.setName(newName);
                newShotItem.setShot(createAverage(shotDatas, newSampleRate));

                listModel_.add(0, newShotItem);
                if (callbackListener_ != null) {
                    newShotItem.setSelected(true);
                    callbackListener_.doShowShotXYSeries(newShotItem);
                }

                logger_.info("Create Avg from highlighted shots.... done");
            }
        });
    }

    public void doRemoveScan(int scanID) {
        logger_.info("Removing scan " + scanID + " ....");
        
        if (listModel_.getSize() == 0)
            return;
        
        int index = 0;
        int i = 0;
        while (index != (listModel_.getSize() - 1)) {
            for (i = 0; i < listModel_.getSize(); i++) {
                index = i;
                CheckListShotItem shotItem = (CheckListShotItem) listModel_.getElementAt(i);

                if (shotItem.getScanID() == scanID) {
                    listModel_.removeElement(shotItem);
                    i--;
                }
            }
        }
        logger_.info("Removing scan " + scanID + " .... done");

    }

    public int getSampleRate() {
        int sampleRate = validateZeroOrGreater(txtSampleRate_);
        if (sampleRate < 1) {
            showErrorDialog("Invalid Sample Rate value: + " + sampleRate);
        }
        return sampleRate;
    }

    public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            setComponentOrientation(list.getComponentOrientation());
            setFont(list.getFont());
            setOpaque(true);
            if (isSelected) {
                setBackground(Color.LIGHT_GRAY);
            } else {
                setBackground(list.getBackground());
            }
            setForeground(list.getForeground());

            setSelected(((CheckListShotItem) value).isSelected());

            setEnabled(list.isEnabled());

            setText(value == null ? "" : value.toString());

            return this;
        }
    }

    public void addItem(int index, CheckListShotItem item) {
        listModel_.add(index, item);
    }

    public void addItem(CheckListShotItem item) {
        listModel_.addElement(item);
    }

    public void removeAllItem() {
        listModel_.removeAllElements();
    }

    public void addShotItemClickListener(LibzShotItemClickListenerCallback callback) {
        callbackListener_ = callback;
    }

    public int getNumberOfSelectedItem() {
        return lstOfShots_.getSelectedIndices().length;
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAvg_;
    private javax.swing.JButton btnDeleteHighlightedItems_;
    private javax.swing.JButton btnDeleteScan_;
    private javax.swing.JButton btnUncheckAll_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstOfShots_;
    private javax.swing.JTextField txtSampleRate_;
    // End of variables declaration//GEN-END:variables
}
