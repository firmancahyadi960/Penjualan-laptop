/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import Tools.Konversi;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import penjualan_item.PenjualanItem;



/**
 *
 * @author USER
 */
public class BarangDAOImp implements DAO{

    
    private Dao<Barang, Integer> dao;
     


    public BarangDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Barang.class);
          } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public void insert(Object o) {
        try {
            dao.create((Barang) o);
     JOptionPane.showMessageDialog(null, "Tambah data berhasil !");
          
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Barang) o);
      JOptionPane.showMessageDialog(null, "Ubah data berhasil !");
        
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        JOptionPane.showMessageDialog(null, "Hapus data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
    String [] kolom = {"ID"," namabarang "," jenisbarang", " hargabeli","hargajual","stok"};
    DefaultTableModel dtm = new DefaultTableModel(null, kolom);
    
        
        try {
           
            List<Barang> list = dao.queryForAll();
             for (Barang b : list) {
                Object[] isi = new Object[6];
                isi[0] = b.getIdbarang();
                isi[1] = b.getNamabarang();
                isi[2] = b.getJenisbarang();
                isi[3] = Konversi.konversi(b.getHargabeli());
                isi[4] = Konversi.konversi(b.getHargajual());
                isi[5] = b.getStok();
                dtm.addRow(isi);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    return dtm;
        
    }

    @Override
    public DefaultTableModel search(String key) {
    DefaultTableModel dtm ;
    String [] kolom = {"ID"," namabarang "," jenisbarang ", " hargabeli","hargajual","stok"};
    dtm = new DefaultTableModel(null, kolom);
        
        try {
            
            List<Barang> list = dao.queryBuilder().where().
                    like("namabarang", "%"+key+"%").query();
             for (Barang b : list) {
                Object[] isi = new Object[6];
                isi[0] = b.getIdbarang();
                isi[1] = b.getNamabarang();
                isi[2] = b.getJenisbarang();
                isi[3] = Konversi.konversi(b.getHargabeli());
                isi[4] = Konversi.konversi(b.getHargajual());
                isi[5] = b.getStok();
                dtm.addRow(isi);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    return dtm;
        
    }

   
    }

    
   
