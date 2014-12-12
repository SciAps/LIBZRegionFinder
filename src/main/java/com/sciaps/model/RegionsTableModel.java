package com.sciaps.model;

import com.sciaps.common.RegionMarkerItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import org.jfree.chart.plot.IntervalMarker;

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

    private final List<RegionMarkerItem> data_;
    String[] columnNames_ = {"Name", "Symbol", "Min", "Max", "Value"};

    public RegionsTableModel() {
        data_ = new ArrayList<RegionMarkerItem>();
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
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    data_.get(rowIndex).setMin(newVal);
                    checkMinAndMax(rowIndex);

                } catch (NumberFormatException ex) {
                    showErrorPopup("Invalid Min Value: " + (String) aValue);
                }
                break;
            case 3:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    data_.get(rowIndex).setMax(newVal);
                    checkMinAndMax(rowIndex);
                } catch (NumberFormatException ex) {
                    showErrorPopup("Invalid Max Value: " + (String) aValue);
                }
                break;
            case 4:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    data_.get(rowIndex).setValue(newVal);
                } catch (NumberFormatException ex) {
                    showErrorPopup("Invalid Calculated Value: " + (String) aValue);
                }
                break;
            default:
                break;
        }
        fireTableDataChanged();
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
        fireTableDataChanged();
    }

    public void removeRows(int[] rowIndex) {
        Arrays.sort(rowIndex);
        for (int i = rowIndex.length - 1; i >= 0; i--) {
            data_.remove(i);
        }

        fireTableDataChanged();
    }

    public IntervalMarker getMarker(int rowIndex) {

        return data_.get(rowIndex).getMarker();
    }

    private void checkMinAndMax(int rowIndex) {

        double min = data_.get(rowIndex).getMin();
        double max = data_.get(rowIndex).getMax();
        if (min > max) {
            showErrorPopup("ERROR: Min greater than Max");
        }
    }

    private void showErrorPopup(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }
}
