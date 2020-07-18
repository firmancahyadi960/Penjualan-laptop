/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Koneksi {
    
   public static String dbname = "Penjualanlaptop";
   public static String dburl = "jdbc:mysql://localhost:3306/" + dbname;
   public static String user = "root";
   public static String pass = "";
   private Connection kon = null;
   private Statement statement = null;
    
    public static ConnectionSource cs() {

       
        ConnectionSource csInit = null;

        try {
            csInit = new JdbcConnectionSource(dburl, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csInit;
    }
    
    public Koneksi(){
       try {
           
        Class.forName("com.mysql.jdbc.Driver");
        kon = DriverManager.getConnection(dburl,user,pass);
        statement = (Statement) kon.createStatement();
        
       } catch (Exception ex) {
         Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null," Gagal terkoneksi ke database "+ex.getMessage());
    }
   
    }
 
     public Connection getkoneksi(){
     return kon;
 }
}
