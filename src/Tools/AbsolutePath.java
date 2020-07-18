/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author USER
 */
public class AbsolutePath {
    
    public static String getPathReport() {
        return System.getProperty("user.dir") + "/build/classes/Report/";
    }

    public static String getPathSaveReport() {
        return System.getProperty("user.dir") + "/build/classes/Laporan/";
    }

    public static String getPathImage() {
        return System.getProperty("user.dir") + "/build/classes/images/";
    }
}
