package com.sciaps.model;

import com.sciaps.common.PeakMeritObj;
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
    String[] columnNames_ = {"Element", "Merit", "PksFound", "%Found", "LgPksFound", "Weight%"};

    public PeakMeritTableModel() {
        data_ = new ArrayList<PeakMeritObj>();
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
                return (int) data_.get(rowIndex).getMerit();
            case 2:
                str = String.format("%d of %d", data_.get(rowIndex).getTotalPeaksFound(), data_.get(rowIndex).getTotalPeaks());
                return str;
            case 3:
                val = (data_.get(rowIndex).getTotalPeaksFound() * 100.0 / data_.get(rowIndex).getTotalPeaks());
                str = String.format("%.2f", val);
                return Double.valueOf(str);
            case 4:
                str = String.format("%d of %d", data_.get(rowIndex).getTotalLgPeaksFound(), data_.get(rowIndex).getTotalLgPeaks());
                return str;
            case 5:
                str = String.format("%.2f", data_.get(rowIndex).getWeightPercentage());
                return Double.valueOf(str);
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

        switch (column) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return String.class;
            case 5:
                return Double.class;
            default:
                return String.class;
        }
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
