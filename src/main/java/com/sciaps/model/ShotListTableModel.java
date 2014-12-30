package com.sciaps.model;

import com.sciaps.common.SpectrumShotItem;
import com.sciaps.view.SpectrumShotPanel.SpectrumShotPanelCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jfree.data.xy.XYSeries;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jchen
 */
public class ShotListTableModel extends AbstractTableModel {

    private final List<SpectrumShotItem> data_;
    private final String[] columnNames_ = {"Show", "Shot"};
    private final SpectrumShotPanelCallback callback_;

    public ShotListTableModel(SpectrumShotPanelCallback callback) {
        data_ = new ArrayList<SpectrumShotItem>();
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
        switch (columnIndex) {
            case 0:
                return data_.get(rowIndex).isSelected();
            case 1:
                return data_.get(rowIndex).getName();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                boolean val = (Boolean) aValue;
                if (val) {
                    showSeries(rowIndex);
                } else {
                    hideSeries(rowIndex);
                }
                break;
            case 1:
                data_.get(rowIndex).setName((String) aValue);
                break;
            default:
                break;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int RowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }

    public void addRow(int index, SpectrumShotItem shotItem) {
        data_.add(index, shotItem);
        fireTableDataChanged();
    }

    public void addRow(SpectrumShotItem shotItem) {
        data_.add(shotItem);
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        if (data_.get(rowIndex).isSelected()) {
            hideSeries(rowIndex);
        }

        data_.remove(rowIndex);
        fireTableDataChanged();
    }

    public void removeRows(int[] rowIndex) {
        if (rowIndex == null || rowIndex.length == 0) {
            return;
        }

        Arrays.sort(rowIndex);
        for (int i = rowIndex.length - 1; i >= 0; i--) {
            if (data_.get(rowIndex[i]).isSelected()) {
                hideSeries(rowIndex[i]);
            }

            data_.remove(rowIndex[i]);
        }

        fireTableDataChanged();
    }

    public SpectrumShotItem getRow(int rowIndex) {
        return data_.get(rowIndex);
    }

    public XYSeries getXYSeries(int rowIndex) {

        return data_.get(rowIndex).getXYSeries();
    }

    public void hideSeries(int rowIndex) {
        data_.get(rowIndex).setSelected(false);
        if (callback_ != null) {
            callback_.doHideShotXYSeries(data_.get(rowIndex));
        }
    }

    public void hideSeries(int[] rowIndex) {
        for (int i = 0; i < rowIndex.length; i++) {
            hideSeries(rowIndex[i]);
        }

        fireTableDataChanged();
    }

    public void showSeries(int rowIndex) {
        data_.get(rowIndex).setSelected(true);
        if (callback_ != null) {
            callback_.doShowShotXYSeries(data_.get(rowIndex));
        }
    }

    public void showSeries(int[] rowIndex) {
        for (int i = 0; i < rowIndex.length; i++) {
            showSeries(rowIndex[i]);
        }

        fireTableDataChanged();
    }

    public void deleteScan(int scanID) {
        for (int index = data_.size() - 1; index >= 0; index--) {
            if (data_.get(index).getScanID() == scanID) {
                removeRow(index);
            }
        }
    }
}
