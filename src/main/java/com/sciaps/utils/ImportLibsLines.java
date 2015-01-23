/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sciaps.common.LIBZLineObj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author jchen
 */
public class ImportLibsLines {

    private final Logger logger_ = LoggerFactory.getLogger(ImportLibsLines.class);

    public ArrayList<LIBZLineObj> importLibsLinesFile() throws IOException {

        logger_.info("Reading LIBSLINES.csv");

        InputStream in = ImportLibsLines.class.getResourceAsStream("/data/LIBSLINES.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        ArrayList<LIBZLineObj> libzLines = new ArrayList<LIBZLineObj>();
        try {
            String line;

            String name = "";
            double x = 0;
            double y = 0;

            while ((line = br.readLine()) != null) {
                try {
                    String[] values = line.split(",");
                    name = values[0];
                    x = Double.parseDouble(values[1].trim());
                    y = Double.parseDouble(values[2].trim());
                    LIBZLineObj lineObj = new LIBZLineObj(name, x, y);
                    libzLines.add(lineObj);

                } catch (Exception e) {
                    logger_.error("Invalid: " + line);
                }
            }
        } finally {

            br.close();
        }
        
        logger_.info("Reading LIBSLINES.csv - done");

        return libzLines;
    }

}
