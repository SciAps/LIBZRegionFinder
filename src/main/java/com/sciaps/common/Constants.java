/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.webserver.LIBZHttpClient;
import javax.swing.JFrame;

/**
 *
 * @author jchen
 */
public class Constants {

    public static String LIBZ_URL_FILE_NAME = "libzipaddress.txt";
    public static final int MAX_SPECTROMETER = 4;
    public static final int REGION_MARKER_COL = 0;
    public static final int REGION_MIN_COL = 3;
    public static final int REGION_MAX_COL = 4;
    public static final int REGION_VAL_COL = 5;
    public static final int PEAK_INTENSITY_FUNC = 1;
    public static final int LORENTZIAN_INTENSITY_FUNC = 2;
    public static final double MARKER_THRESHOLD = 0.02;
    public static final double LG_PEAK_MIN_VAL = 0.5;
    public static JFrame MAIN_FRAME = null;

    public static LIBZHttpClient mHttpClient;

}
