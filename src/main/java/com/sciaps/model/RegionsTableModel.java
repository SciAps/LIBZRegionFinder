package com.sciaps.model;

import com.sciaps.common.RegionMarkerItem;
import com.sciaps.view.RegionsPanel.RegionsPanelCallback;
import java.math.BigDecimal;
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
    String[] columnNames_ = {"Show", "Name", "Symbol", "Min", "Max", "Value"};
    private RegionsPanelCallback callback_;

    public RegionsTableModel(RegionsPanelCallback callback) {
        data_ = new ArrayList<RegionMarkerItem>();
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
                return data_.get(rowIndex).getIsMarkerShown();
            case 1:
                return data_.get(rowIndex).getName();
            case 2:
                return data_.get(rowIndex).getSymbol();
            case 3:
                return String.valueOf(data_.get(rowIndex).getMin());
            case 4:
                return String.valueOf(data_.get(rowIndex).getMax());
            case 5:
                return String.valueOf(data_.get(rowIndex).getValue());
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        boolean isMarkerShown = data_.get(rowIndex).getIsMarkerShown();

        switch (columnIndex) {
            case 0:
                boolean val = (Boolean) aValue;
                if (val) {
                    addMarker(rowIndex);
                } else {
                    removeMarker(rowIndex);
                }
                break;
            case 1:
                data_.get(rowIndex).setName((String) aValue);
                break;
            case 2:

                if (isMarkerShown) {
                    removeMarker(rowIndex);
                }
                data_.get(rowIndex).setSymbol((String) aValue);

                if (isMarkerShown) {
                    addMarker(rowIndex);
                }
                break;
            case 3:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    if (isMarkerShown) {
                        removeMarker(rowIndex);
                    }

                    data_.get(rowIndex).setMin(newVal);

                    if (isMarkerShown && checkMinAndMax(rowIndex)) {
                        addMarker(rowIndex);
                    }

                    fireTableDataChanged();
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Min Value: " + (String) aValue);
                }
                break;
            case 4:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    if (isMarkerShown) {
                        removeMarker(rowIndex);
                    }

                    data_.get(rowIndex).setMax(newVal);

                    if (isMarkerShown && checkMinAndMax(rowIndex)) {
                        addMarker(rowIndex);
                    }

                    fireTableDataChanged();
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Max Value: " + (String) aValue);
                }
                break;
            case 5:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    data_.get(rowIndex).setValue(newVal);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Calculated Value: " + (String) aValue);
                }
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
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
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
        if (data_.get(rowIndex).getIsMarkerShown()) {
            removeMarker(rowIndex);
        }

        data_.remove(rowIndex);
        fireTableDataChanged();
    }

    public void removeRows(int[] rowIndex) {
        Arrays.sort(rowIndex);
        for (int i = rowIndex.length - 1; i >= 0; i--) {
            if (data_.get(rowIndex[i]).getIsMarkerShown()) {
                removeMarker(rowIndex[i]);
            }

            data_.remove(rowIndex[i]);
        }

        fireTableDataChanged();
    }

    public IntervalMarker getMarker(int rowIndex) {

        return data_.get(rowIndex).getMarker();
    }

    private boolean checkMinAndMax(int rowIndex) {

        boolean retval = true;
        double min = data_.get(rowIndex).getMin();
        double max = data_.get(rowIndex).getMax();
        if (min > max) {
            showErrorDialog("ERROR: Min is greater than Max");
            retval = false;
        }

        return retval;
    }

    public void removeMarker(int rowIndex) {
        if (callback_ != null) {
            data_.get(rowIndex).setIsMarkerShown(false);
            callback_.removeRegionMarker(data_.get(rowIndex).getMarker());
        }
    }

    public void addMarker(int rowIndex) {
        if (callback_ != null) {
            if (data_.get(rowIndex).getIsMarkerShown() == false) {
                callback_.addRegionMarker(data_.get(rowIndex).getMarker());
                data_.get(rowIndex).setIsMarkerShown(true);
            }
        }
    }

    public void doCalculate(int type) {
        if (callback_ != null) {
            double retval;
            double waveLength;
            double regionWidth;

            for (RegionMarkerItem markerItem : data_) {
                regionWidth = markerItem.getMax() - markerItem.getMin();
                waveLength =  markerItem.getMin() + regionWidth/2;             
                retval = callback_.getIntensityOfLine(type, waveLength, regionWidth);

                // The -1 value identicate no shot is selected to do the calculation. 
                // Therefore, break out of this for loop
                if (retval == -1) {
                    break;
                }

                retval = (new BigDecimal(retval)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                markerItem.setValue(retval);
            }

            fireTableDataChanged();
        }
    }

    private void showErrorDialog(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }
}
