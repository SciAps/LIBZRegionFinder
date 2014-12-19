/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

import com.sciaps.common.webserver.LIBZHttpClient;

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
    
    public static LIBZHttpClient mHttpClient;
    
}
