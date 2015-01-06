/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sciaps.common.spectrum.LIBZPixelSpectrum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jchen
 */
public class ImportExportSpectrumJsonGzip {
 
    private final Logger logger_ = LoggerFactory.getLogger(ImportExportSpectrumJsonGzip.class);

    public void ImportExportSpectrumData() {
        
    }
            
    public void exportSpectrumFile(File saveFile, LIBZPixelSpectrum spectrum) throws IOException {
        if(spectrum == null || saveFile == null){
            logger_.warn("", "will not save spectrum file");
            return;
        }

        OutputStream out = new FileOutputStream(saveFile);
        out = new GZIPOutputStream(out);
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out));
        Gson gson = new GsonBuilder().create();
        try {
            gson.toJson(spectrum, spectrum.getClass(), writer);
        } finally {
            writer.close();
        }
        logger_.info("", "saved GZIP spectrum file to " + saveFile.getAbsolutePath());
    }

    public LIBZPixelSpectrum importSpectrumFile(File spectrumFile) throws IOException {
        InputStream in = new FileInputStream(spectrumFile);
        in = new GZIPInputStream(in);
        JsonReader reader = new JsonReader(new InputStreamReader(in));
        try {
            Gson gson = new GsonBuilder().create();
            final LIBZPixelSpectrum obj = gson.fromJson(reader, LIBZPixelSpectrum.class);
            return obj;
        } finally {
            reader.close();
        }
    }
}
