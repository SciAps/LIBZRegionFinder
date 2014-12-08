/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import java.util.regex.Pattern;

/**
 *
 * @author jchen
 */
public class Util {

    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    private static final String POSITION_XYZ_PATTERN = "^\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*$";
    
    private static final String POSITION_XY_PATTERN = "^\\s*(\\-?\\d+?)\\s*,\\s*(\\-?\\d+?)\\s*$";

    
    public static boolean validateIPAddress(final String ipAddress) {
        
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        
        return pattern.matcher(ipAddress).matches();
    }
    
    public static boolean validePositionXYZ(final String xyz) {
        Pattern pattern = Pattern.compile(POSITION_XYZ_PATTERN);
        return pattern.matcher(xyz).matches();    
    }
    
    public static boolean validePositionXY(final String xy) {
        Pattern pattern = Pattern.compile(POSITION_XY_PATTERN);
        return pattern.matcher(xy).matches();    
    }
}
