/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.view;

import com.sciaps.common.RegionMarkerItem;
import com.sciaps.model.RegionsTableModel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class RegionsPanel extends JPanel {

    public interface RegionsPanelCallback {

        void onRegionDeleted(String regionName);

        void onRegionClicked(String regionName);

        void addRegionMarker(Marker marker);

        void removeRegionMarker(Marker marker);

        int getNumberOfSelectedShots();
    }

    private final org.slf4j.Logger logger_ = LoggerFactory.getLogger(RegionsPanel.class);
    private RegionsPanelCallback callback_;
    private RegionsTableModel tableModel_;
    private TableRowSorter<RegionsTableModel> sorter_;
    private List<IntervalMarker> listOfMarkers_;
    private Vector data_;

    public RegionsPanel() {
        initComponents();

        callback_ = null;
        initializePanel();

    }

    /**
     * Creates new form RegionFinderRegionsPanel
     *
     * @param callback
     * @param columnNames
     */
    public RegionsPanel(RegionsPanelCallback callback) {
        initComponents();

        callback_ = callback;
        initializePanel();
    }

    private void initializePanel() {
        listOfMarkers_ = new ArrayList<>();

        tableModel_ = new RegionsTableModel();
        /*if (columnNames_ != null) {
            for (String colname : columnNames_) {
                tableModel_.addColumn(colname);
            }
        }*/

        sorter_ = new TableRowSorter<>(tableModel_);
        tblRegions_.setRowSorter(sorter_);
        tblRegions_.setModel(tableModel_);
        
        tblRegions_.getColumnModel().getColumn(2).setCellRenderer(new TableCellDoubleTypeRenderer());
        tblRegions_.getColumnModel().getColumn(3).setCellRenderer(new TableCellDoubleTypeRenderer());

        tblRegions_.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int col = tblRegions_.getSelectedColumn();
                int row = tblRegions_.getSelectedRow();
                System.out.println(tblRegions_.getValueAt(row, col));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

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

    public void addCallbackListener(RegionsPanelCallback callback) {
        callback_ = callback;
    }

    public void addRow(RegionMarkerItem markerItem) {
        tableModel_.addRow(markerItem);
    }

    private int getMarkerIndex(double min, double max) {
        int index = -1;
        for (int i = 0; i < listOfMarkers_.size(); i++) {
            IntervalMarker marker = listOfMarkers_.get(i);
            if (min == marker.getStartValue() && max == marker.getEndValue()) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void removeSelectedRows() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int selectedRow = tblRegions_.getSelectedRow();
                while (selectedRow >= 0) {

                    double min = Double.parseDouble((String) tableModel_.getValueAt(selectedRow, 2));
                    double max = Double.parseDouble((String) tableModel_.getValueAt(selectedRow, 3));
                    int index = getMarkerIndex(min, max);
                    if (index > -1) {
                        IntervalMarker marker = listOfMarkers_.get(index);
                        if (callback_ != null) {
                            callback_.removeRegionMarker(marker);
                        }
                        listOfMarkers_.remove(index);
                    }

                    int modelIndex = tblRegions_.convertRowIndexToModel(selectedRow);
                    tableModel_.removeRow(modelIndex);

                    selectedRow = tblRegions_.getSelectedRow();
                }
            }
        });
    }

    private void filterTable() {
        try {
            RowFilter<RegionsTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + txtFilterText_.getText(), 0);
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
        btnCalculateValue_ = new javax.swing.JButton();
        btnAddMarker_ = new javax.swing.JButton();
        btnRemoveMarker_ = new javax.swing.JButton();
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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(txtFilterText_, gridBagConstraints);

        jLabel2.setText("Filter");
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
        btnDelete_.setMaximumSize(new java.awt.Dimension(100, 23));
        btnDelete_.setMinimumSize(new java.awt.Dimension(100, 23));
        btnDelete_.setPreferredSize(new java.awt.Dimension(100, 23));
        btnDelete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete_, new java.awt.GridBagConstraints());

        btnCalculateValue_.setText("Calculate");
        btnCalculateValue_.setMaximumSize(new java.awt.Dimension(100, 23));
        btnCalculateValue_.setMinimumSize(new java.awt.Dimension(100, 23));
        btnCalculateValue_.setPreferredSize(new java.awt.Dimension(100, 23));
        btnCalculateValue_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateValue_ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalculateValue_, new java.awt.GridBagConstraints());

        btnAddMarker_.setText("Set Marker");
        btnAddMarker_.setMaximumSize(new java.awt.Dimension(100, 23));
        btnAddMarker_.setMinimumSize(new java.awt.Dimension(100, 23));
        btnAddMarker_.setPreferredSize(new java.awt.Dimension(100, 23));
        btnAddMarker_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMarker_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(btnAddMarker_, gridBagConstraints);

        btnRemoveMarker_.setText("Undo Marker");
        btnRemoveMarker_.setMaximumSize(new java.awt.Dimension(100, 23));
        btnRemoveMarker_.setMinimumSize(new java.awt.Dimension(100, 23));
        btnRemoveMarker_.setPreferredSize(new java.awt.Dimension(100, 23));
        btnRemoveMarker_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMarker_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(btnRemoveMarker_, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
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
        doDelete();
    }//GEN-LAST:event_btnDelete_ActionPerformed

    private void btnCalculateValue_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateValue_ActionPerformed
        doCalculate();
        for (int i = 0; i < data_.size(); i++) {
            System.out.println(data_.get(i));
        }
    }//GEN-LAST:event_btnCalculateValue_ActionPerformed

    private void btnAddMarker_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMarker_ActionPerformed

        int[] selectedRows = tblRegions_.getSelectedRows();

        for (int i = 0; i < selectedRows.length; i++) {
            try {
                double min = Double.parseDouble((String) tableModel_.getValueAt(selectedRows[i], 2));
                double max = Double.parseDouble((String) tableModel_.getValueAt(selectedRows[i], 3));
                doAddMarker(min, max);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid region min/max");
            }
        }
    }//GEN-LAST:event_btnAddMarker_ActionPerformed

    private void btnRemoveMarker_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMarker_ActionPerformed
        int[] selectedRows = tblRegions_.getSelectedRows();

        for (int i = 0; i < selectedRows.length; i++) {
            try {
                double min = Double.parseDouble((String) tableModel_.getValueAt(selectedRows[i], 2));
                double max = Double.parseDouble((String) tableModel_.getValueAt(selectedRows[i], 3));
                doRemoveMarker(min, max);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid region min/max");
            }
        }
    }//GEN-LAST:event_btnRemoveMarker_ActionPerformed

    private void doAddMarker(double min, double max) {

        int index = getMarkerIndex(min, max);
        // index == -1 means theres no marker object for this region yet
        if (index == -1) {
            if (callback_ != null) {
                //final Color c = new Color(255, 60, 24, 63);
                final Color c = new Color(255, 0, 0, 63);
                IntervalMarker marker = new IntervalMarker(
                        min, max, c,
                        new BasicStroke(2.0f), null, null, 1.0f);

                listOfMarkers_.add(marker);
                callback_.addRegionMarker(marker);
            }
        } else {
            // this region marker already create, therefore, just display it
            IntervalMarker marker = listOfMarkers_.get(index);
            callback_.addRegionMarker(marker);
        }

    }

    private void doRemoveMarker(double min, double max) {

        int index = getMarkerIndex(min, max);
        if (index != -1) {
            IntervalMarker marker = listOfMarkers_.get(index);
            callback_.removeRegionMarker(marker);
        }

    }

    private void doDelete() {

        if (tblRegions_.getSelectedRowCount() > 0) {
            int retval = JOptionPane.showConfirmDialog(null, "Delete Selected Row(s)?");
            if (retval == JOptionPane.YES_OPTION) {
                removeSelectedRows();
            }
        }
    }

    private void doCalculate() {
        if (callback_ != null) {
            int numOfSelected = callback_.getNumberOfSelectedShots();
            if (numOfSelected == 1) {
                //TODO
            } else if (numOfSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select a shot and continue.");
            } else {
                JOptionPane.showMessageDialog(null, "Only one shot should be selected.");
            }
        }
    }

    class TableCellDoubleTypeRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            if (value != null) {
                editor.setText(value.toString());
            }
            
            try {
                Double.parseDouble((String)value);
                if (isSelected) {
                    editor.setBackground(table.getSelectionBackground());
                } else {
                    editor.setBackground(table.getBackground());
                }
            } catch (NumberFormatException ex) {
                editor.setBackground(Color.red);
                btnDelete_.setEnabled(false);
            }
            return editor;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMarker_;
    private javax.swing.JButton btnCalculateValue_;
    private javax.swing.JButton btnDelete_;
    private javax.swing.JButton btnRemoveMarker_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegions_;
    private javax.swing.JTextField txtFilterText_;
    // End of variables declaration//GEN-END:variables
}
