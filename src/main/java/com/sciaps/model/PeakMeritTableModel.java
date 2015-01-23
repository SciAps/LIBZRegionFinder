package com.sciaps.model;

import com.sciaps.common.PeakMeritObj;
import com.sciaps.view.SpectrumShotPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jchen
 */
public class PeakMeritTableModel extends AbstractTableModel {

    private final List<PeakMeritObj> data_;
    String[] columnNames_ = {"Element", "PksFound", "%Found", "LgPksFound", "Weight"};
    private SpectrumShotPanel.SpectrumShotPanelCallback callback_;

    public PeakMeritTableModel(SpectrumShotPanel.SpectrumShotPanelCallback callback) {
        data_ = new ArrayList<PeakMeritObj>();
        callback_ = callback;
    }

    @Override
    public int getRowCount() {
        return data_.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames_.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames_[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String str;
        double val;
        switch (columnIndex) {
            case 0:
                return data_.get(rowIndex).elementName_;
            case 1:
                str = String.format("%d of %d", data_.get(rowIndex).getTotalPeaksFound(), data_.get(rowIndex).getTotalPeaks());
                return str;
            case 2:
                val = (data_.get(rowIndex).getTotalPeaksFound() * 100.0 / data_.get(rowIndex).getTotalPeaks());
                str = String.format("%.2f%%", val);
                return str;
            case 3:
                str = String.format("%d of %d", data_.get(rowIndex).getTotalLgPeaksFound(), data_.get(rowIndex).getTotalLgPeaks());
                return str;
            case 4:
                str = String.format("%.2f%%", data_.get(rowIndex).getWeightPercentage());
                return str;
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // do nothing, read only
    }

    @Override
    public Class getColumnClass(int column) {

        return String.class;
    }

    @Override
    public boolean isCellEditable(int RowIndex, int columnIndex) {
        return false;
    }

    public void addRow(PeakMeritObj peakObj) {
        data_.add(peakObj);
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        data_.remove(rowIndex);
        fireTableDataChanged();
    }

    public void removeRows(int[] rowIndex) {
        Arrays.sort(rowIndex);
        for (int i = rowIndex.length - 1; i >= 0; i--) {
            data_.remove(rowIndex[i]);
        }

        fireTableDataChanged();
    }
    
    public PeakMeritObj getRow(int rowIndex) {
        return data_.get(rowIndex);
    }
    
    public void clearAllData() {
        data_.clear();
    }
}
