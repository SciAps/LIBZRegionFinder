package com.sciaps.model;

import com.sciaps.common.RegionMarkerItem;
import java.util.ArrayList;
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
public class RegionsTableModel extends AbstractTableModel {

    private List<RegionMarkerItem> data_;
    String[] columnNames_ = {"Name", "Symbol", "Min", "Max", "Value"};

    public RegionsTableModel() {
        data_ = new ArrayList<>();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data_.get(rowIndex).getName();
            case 1:
                return data_.get(rowIndex).getSymbol();
            case 2:
                return String.valueOf(data_.get(rowIndex).getMin());
            case 3:
                return String.valueOf(data_.get(rowIndex).getMax());
            case 4:
                return String.valueOf(data_.get(rowIndex).getValue());
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                data_.get(rowIndex).setName((String) aValue);
                break;
            case 1:
                data_.get(rowIndex).setSymbol((String) aValue);
                break;
            case 2:
                data_.get(rowIndex).setMin(aValue == null ? new Double(0) : Double.parseDouble(aValue.toString()));
                break;
            case 3:
                data_.get(rowIndex).setMax(aValue == null ? new Double(0) : Double.parseDouble(aValue.toString()));
                break;
            case 4:
                data_.get(rowIndex).setValue(aValue == null ? new Double(0) : Double.parseDouble(aValue.toString()));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isCellEditable(int RowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return false;
            default:
                return true;
        }
    }

    public void addRow(RegionMarkerItem markerItem) {
        data_.add(markerItem);
        fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex) {
        data_.remove(rowIndex);
    }

}
