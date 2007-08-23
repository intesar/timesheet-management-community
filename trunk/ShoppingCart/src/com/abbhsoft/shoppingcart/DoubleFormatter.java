/*
 * DoubleFormatter.java
 * 
 * Created on Aug 23, 2007, 5:30:38 PM
 * 
 *  All code belongs to Abbt organization any use of this code without
 *  permission or licence is subject to fine and procecution
 */

package com.abbhsoft.shoppingcart;

import java.text.DecimalFormat;

/**
 *
 * @author Intesar.Mohammed
 */
public class DoubleFormatter {

    private DoubleFormatter() {
    }

    /**
     * 
     * @param value 
     * @return 
     */
    public static Double format ( Double value ) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
        Double d = Double.valueOf(df.format(value));
        return d;
    }
}
