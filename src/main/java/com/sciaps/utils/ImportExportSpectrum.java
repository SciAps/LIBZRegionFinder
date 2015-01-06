/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import com.sciaps.common.SpectrumShotItem;
import com.sciaps.common.spectrum.LIBZPixelSpectrum;
import com.sciaps.common.spectrum.PiecewiseSpectrum;
import com.sciaps.common.spectrum.RawDataSpectrum;
import com.sciaps.view.ProgressStatusPanel;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class ImportExportSpectrum {

    private final Logger logger_ = LoggerFactory.getLogger(ImportExportSpectrum.class);

    public ImportExportSpectrum() {

    }

    public ArrayList<SpectrumShotItem> importJzonGzipFile() {
        ArrayList<SpectrumShotItem> shotItems = new ArrayList<SpectrumShotItem>();

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileFilter(new FileNameExtensionFilter("Json Gzip files", "gz"));

        int retrival = chooser.showOpenDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(null,
                    "Importing GZIP Spectrum File", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {

                ImportExportSpectrumJsonGzip jsonImportExport = new ImportExportSpectrumJsonGzip();
                for (File file : chooser.getSelectedFiles()) {
                    //String newName = file.getName().replace(".json.gz", "");
                    LIBZPixelSpectrum shotData = jsonImportExport.importSpectrumFile(file);
                    SpectrumShotItem shot = new SpectrumShotItem(file.getName());
                    shot.setShot(shotData.createSpectrum());
                    shotItems.add(shot);
                }
            } catch (Exception ex) {
                logger_.error("Exception: " + ex.getMessage());
            }

            progressDialog.dispose();
        }

        return shotItems;
    }

    public void exportJzonGzipFile(final ArrayList<SpectrumShotItem> shotItems) {
        showErrorDialog("This function is not yet implemented");
        if (true)
            return;
        
        StringBuilder errorMsg = new StringBuilder();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(null,
                    "Exporting GZIP Spectrum File", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {
                String dir = chooser.getSelectedFile().toString();

                ImportExportSpectrumJsonGzip jsonImportExport = new ImportExportSpectrumJsonGzip();

                for (SpectrumShotItem item : shotItems) {
                    if (item.getName().endsWith(".json.gz") || item.getName().endsWith(".csv")) {
                        errorMsg.append(item.getName()).append(",");
                    } else {
                        String fileName = dir + File.separator + item.getName().replace(" ", "_") + ".json.gz";
                        File file = new File(fileName);

                        //********* TODO
                        //jsonImportExport.exportSpectrumFile(file, item.getShot());
                    }
                }

            } catch (Exception ex) {
                logger_.error(ex.getMessage());
            }

            progressDialog.dispose();

            if (errorMsg.length() != 0) {
                errorMsg.insert(0, "The following files are not saved due to already a Gzip/CSV file:\n");
                showErrorDialog(errorMsg.toString());
            }
        }
    }

    public ArrayList<SpectrumShotItem> importCSVFile() {
        ArrayList<SpectrumShotItem> shotItems = new ArrayList<SpectrumShotItem>();

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));

        int retrival = chooser.showOpenDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(null,
                    "Importing CSV Spectrum File", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {

                ImportExportSpectrumCSV csvImportExport = new ImportExportSpectrumCSV();
                for (File file : chooser.getSelectedFiles()) {
                    RawDataSpectrum shotData = csvImportExport.importSpectrumFile(file);
                    SpectrumShotItem shot = new SpectrumShotItem(file.getName());
                    shot.setShot(shotData);
                    shotItems.add(shot);
                }
            } catch (Exception ex) {
                logger_.error("Exception: " + ex.getMessage());
            }

            progressDialog.dispose();
        }

        return shotItems;
    }

    public void exportCSVFile(final ArrayList<SpectrumShotItem> shotItems) {
        StringBuilder errorMsg = new StringBuilder();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {

            ProgressStatusPanel progressbar = new ProgressStatusPanel();
            final CustomDialog progressDialog = new CustomDialog(null,
                    "Exporting CSV Spectrum File", progressbar,
                    CustomDialog.NONE_OPTION);
            progressDialog.setSize(400, 100);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    progressDialog.setVisible(true);
                }
            });

            try {
                String dir = chooser.getSelectedFile().toString();
                ImportExportSpectrumCSV csvImportExport = new ImportExportSpectrumCSV();

                for (SpectrumShotItem item : shotItems) {

                    if (item.getName().endsWith(".csv")) {
                        errorMsg.append(item.getName()).append(",");
                    } else {
                        String fileName = dir + File.separator + item.getName().replace(" ", "_") + ".csv";
                        File file = new File(fileName);
                        csvImportExport.exportSpectrumFile(file, (PiecewiseSpectrum) item.getShot());
                    }
                }
            } catch (Exception ex) {
                logger_.error(ex.getMessage());
            }

            progressDialog.dispose();

            if (errorMsg.length() != 0) {
                errorMsg.insert(0, "The following files are not saved due to already a CSV file:\n");
                showErrorDialog(errorMsg.toString());
            }
        }
    }

    private void showErrorDialog(String msg) {
        logger_.error(msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
