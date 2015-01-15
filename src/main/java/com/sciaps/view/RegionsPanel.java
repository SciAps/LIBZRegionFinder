/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.Constants;
import static com.sciaps.common.Constants.REGION_MARKER_COL;
import static com.sciaps.common.Constants.REGION_MAX_COL;
import static com.sciaps.common.Constants.REGION_MIN_COL;
import com.sciaps.common.RegionMarkerItem;
import com.sciaps.listener.JFreeChartMouseListener.JFreeChartMouseListenerCallback;
import com.sciaps.model.RegionsTableModel;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.plot.IntervalMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class RegionsPanel extends JPanel implements JFreeChartMouseListenerCallback {

    public interface RegionsPanelCallback {

        void addRegionMarker(IntervalMarker marker);

        void removeRegionMarker(IntervalMarker marker);

        double getIntensityOfLine(int type, double waveLength, double regionWidth);
    }

    private final Logger logger_ = LoggerFactory.getLogger(RegionsPanel.class);
    private RegionsTableModel tableModel_;
    private TableRowSorter<RegionsTableModel> sorter_;

    public RegionsPanel() {
        initComponents();

        initializePanel();
    }

    /**
     * Creates new form RegionFinderRegionsPanel
     *
     * @param callback
     */
    public RegionsPanel(RegionsPanelCallback callback) {
        initComponents();

        tableModel_ = new RegionsTableModel(callback);
        initializePanel();
    }

    private void initializePanel() {

        sorter_ = new TableRowSorter<RegionsTableModel>(tableModel_);
        tblRegions_.setRowSorter(sorter_);
        tblRegions_.setModel(tableModel_);

        tblRegions_.getColumnModel().getColumn(REGION_MIN_COL).setCellRenderer(new TableCellDoubleTypeRenderer());
        tblRegions_.getColumnModel().getColumn(REGION_MAX_COL).setCellRenderer(new TableCellDoubleTypeRenderer());

        tblRegions_.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblRegions_.getColumnModel().getColumn(0).setMinWidth(45);
        tblRegions_.getColumnModel().getColumn(0).setMaxWidth(45);
        tblRegions_.getColumnModel().getColumn(0).setResizable(false);

        tblRegions_.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblRegions_.getColumnModel().getColumn(2).setMinWidth(50);
        tblRegions_.getColumnModel().getColumn(2).setMaxWidth(50);
        tblRegions_.getColumnModel().getColumn(2).setResizable(false);

        tblRegions_.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblRegions_.getColumnModel().getColumn(3).setMinWidth(50);
        tblRegions_.getColumnModel().getColumn(3).setMaxWidth(50);
        tblRegions_.getColumnModel().getColumn(3).setResizable(false);

        tblRegions_.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblRegions_.getColumnModel().getColumn(4).setMinWidth(50);
        tblRegions_.getColumnModel().getColumn(4).setMaxWidth(50);
        tblRegions_.getColumnModel().getColumn(4).setResizable(false);

        tblRegions_.getTableHeader().setReorderingAllowed(false);

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

    public void addRow(RegionMarkerItem markerItem) {
        tableModel_.addRow(markerItem);
    }

    private void filterTable() {
        try {
            RowFilter<RegionsTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + txtFilterText_.getText(), 1);
            sorter_.setRowFilter(rowFilter);
        } catch (java.util.regex.PatternSyntaxException ex) {
            logger_.error(ex.getMessage());
        }
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
        tblRegions_ = new javax.swing.JTable();
        txtFilterText_ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDelete_ = new javax.swing.JButton();
        btnAddMarker_ = new javax.swing.JButton();
        btnRemoveMarker_ = new javax.swing.JButton();
        btnInsertNew_ = new javax.swing.JButton();
        cmboCalculate_ = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(350, 759));
        setMinimumSize(new java.awt.Dimension(350, 759));
        setPreferredSize(new java.awt.Dimension(350, 759));
        setLayout(new java.awt.GridBagLayout());

        tblRegions_.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegions_);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 223;
        gridBagConstraints.ipady = 315;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtFilterText_, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Filter");
        jLabel2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel2, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Regions");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnDelete_.setText("Delete");
        btnDelete_.setToolTipText("Delete Selected Region(s)");
        btnDelete_.setMaximumSize(new java.awt.Dimension(150, 23));
        btnDelete_.setMinimumSize(new java.awt.Dimension(150, 23));
        btnDelete_.setPreferredSize(new java.awt.Dimension(150, 23));
        btnDelete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(btnDelete_, gridBagConstraints);

        btnAddMarker_.setText("Set Marker(s)");
        btnAddMarker_.setToolTipText("Set A Marker for Selected Region(s)");
        btnAddMarker_.setMaximumSize(new java.awt.Dimension(150, 23));
        btnAddMarker_.setMinimumSize(new java.awt.Dimension(150, 23));
        btnAddMarker_.setPreferredSize(new java.awt.Dimension(150, 23));
        btnAddMarker_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMarker_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(btnAddMarker_, gridBagConstraints);

        btnRemoveMarker_.setText("Remove Marker(s)");
        btnRemoveMarker_.setToolTipText("Remove Selected Region Marker(s)");
        btnRemoveMarker_.setMaximumSize(new java.awt.Dimension(150, 23));
        btnRemoveMarker_.setMinimumSize(new java.awt.Dimension(150, 23));
        btnRemoveMarker_.setPreferredSize(new java.awt.Dimension(150, 23));
        btnRemoveMarker_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMarker_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(btnRemoveMarker_, gridBagConstraints);

        btnInsertNew_.setText("Insert New");
        btnInsertNew_.setToolTipText("Insert A New Region");
        btnInsertNew_.setMaximumSize(new java.awt.Dimension(150, 23));
        btnInsertNew_.setMinimumSize(new java.awt.Dimension(150, 23));
        btnInsertNew_.setPreferredSize(new java.awt.Dimension(150, 23));
        btnInsertNew_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertNew_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(btnInsertNew_, gridBagConstraints);

        cmboCalculate_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~ Select Intensity Calculation Type ~", "Use Peak Intensity", "Use Lorentzian Intensity" }));
        cmboCalculate_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboCalculate_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(cmboCalculate_, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jPanel1, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Region List:");
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_ActionPerformed
        int[] selectedRows = tblRegions_.getSelectedRows();
        if (selectedRows.length == 0) {
            showErrorDialog("No region selected to delete.");
            return;
        }

        int retval = JOptionPane.showConfirmDialog(null, "Delete Selected Row(s)?");
        if (retval != JOptionPane.YES_OPTION) {
            return;
        }

        int[] tmpSelectedRows = new int[selectedRows.length];
        for (int i = 0; i < tmpSelectedRows.length; i++) {
            int modelIndex = tblRegions_.convertRowIndexToModel(selectedRows[i]);
            tmpSelectedRows[i] = modelIndex;
        }

        tableModel_.removeRows(tmpSelectedRows);
    }//GEN-LAST:event_btnDelete_ActionPerformed

    private void btnAddMarker_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMarker_ActionPerformed
        doAddRemoveMarker(true);
    }//GEN-LAST:event_btnAddMarker_ActionPerformed

    private void btnRemoveMarker_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMarker_ActionPerformed
        doAddRemoveMarker(false);
    }//GEN-LAST:event_btnRemoveMarker_ActionPerformed

    private void btnInsertNew_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertNew_ActionPerformed
        RegionMarkerItem item = new RegionMarkerItem();
        tableModel_.addRow(item);
    }//GEN-LAST:event_btnInsertNew_ActionPerformed

    private void cmboCalculate_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboCalculate_ActionPerformed

        if (tblRegions_.getRowCount() == 0) {
            return;
        }

        String header = "";
        switch (cmboCalculate_.getSelectedIndex()) {
            case Constants.PEAK_INTENSITY_FUNC:
                header = "Peak Val.";
                break;
            case Constants.LORENTZIAN_INTENSITY_FUNC:
                header = "Lorent. Val.";
                break;
            default:
                return;
        }

        int selectedRow = tblRegions_.getSelectedRow();
        tableModel_.doCalculate(cmboCalculate_.getSelectedIndex());

        JTableHeader th = tblRegions_.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(Constants.REGION_VAL_COL);
        tc.setHeaderValue(header);
        th.repaint();

        if (selectedRow >= 0) {
            tblRegions_.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }//GEN-LAST:event_cmboCalculate_ActionPerformed

    private void doAddRemoveMarker(boolean val) {
        int[] selectedRows = tblRegions_.getSelectedRows();

        if (selectedRows.length == 0) {
            showErrorDialog("No region selected to set marker.");
            return;
        }

        for (int i = 0; i < selectedRows.length; i++) {
            int modelIndex = tblRegions_.convertRowIndexToModel(selectedRows[i]);
            tableModel_.setValueAt(val, modelIndex, REGION_MARKER_COL);
        }
        
        tblRegions_.repaint();
    }

    @Override
    public void jFreeChartOnClicked(double x, double y) {
        int selectedRow = tblRegions_.getSelectedRow();
        int selectedCol = tblRegions_.getSelectedColumn();
        if (selectedRow > -1 && (selectedCol == REGION_MIN_COL || selectedCol == REGION_MAX_COL)) {
            int modelRow = tblRegions_.convertRowIndexToModel(selectedRow);
            int modelCol = tblRegions_.convertColumnIndexToModel(selectedCol);

            NumberFormat formatter = new DecimalFormat("#0.00");
            String tmp = formatter.format(x);
            try {
                double newX = Double.parseDouble(tmp);
                tableModel_.setValueAt(newX, modelRow, modelCol);
                tblRegions_.setRowSelectionInterval(selectedRow, selectedRow);
                tblRegions_.setColumnSelectionInterval(selectedCol, selectedCol);
            } catch (Exception ex) {

            }
        }
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    class TableCellDoubleTypeRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JLabel editor = new JLabel();
            editor.setFont(table.getFont());
            editor.setOpaque(true);
            if (value != null) {
                editor.setText(value.toString());
            }
            if (isSelected) {
                editor.setBackground(table.getSelectionBackground());
            } else {
                editor.setBackground(table.getBackground());
            }

            if (hasFocus) {
                //editor.setBackground(Color.LIGHT_GRAY);
                editor.setBorder(LineBorder.createGrayLineBorder());
            }

            try {
                double min = Double.parseDouble((String) table.getValueAt(row, REGION_MIN_COL));
                double max = Double.parseDouble((String) table.getValueAt(row, REGION_MAX_COL));

                if (min > max) {
                    editor.setBackground(Color.red);
                }
            } catch (NumberFormatException ex) {
                editor.setBackground(Color.red);
            }
            return editor;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMarker_;
    private javax.swing.JButton btnDelete_;
    private javax.swing.JButton btnInsertNew_;
    private javax.swing.JButton btnRemoveMarker_;
    private javax.swing.JComboBox cmboCalculate_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegions_;
    private javax.swing.JTextField txtFilterText_;
    // End of variables declaration//GEN-END:variables
}
