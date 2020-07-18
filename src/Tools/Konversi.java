/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author USER
 */
public class Konversi {
    
     public static String konversi (double harga){
        DecimalFormat c =(DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols f = new DecimalFormatSymbols();
        f.setMonetaryDecimalSeparator(',');
        f.setGroupingSeparator(',');
        c.setDecimalFormatSymbols(f);
        return c.format(harga).substring(1);
    }
}
