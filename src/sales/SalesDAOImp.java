/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class SalesDAOImp implements DAO {

    private Dao<Sales, Integer> dao;
  

    public SalesDAOImp() {
        try {
            // menghubungkan dao dan cs

            dao = DaoManager.createDao(Koneksi.cs(), Sales.class);
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    @Override
    public void insert(Object o) {
        try {
            dao.create((Sales) o);
             JOptionPane.showMessageDialog(null, "Tambah data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(Object o) {
        try {
            dao.update((Sales) o);
             JOptionPane.showMessageDialog(null, "Ubah data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
             JOptionPane.showMessageDialog(null, "hapus data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[] kolom = {"ID", "Nama", "Alamat", "telpon"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        try {
            List<Sales> list = dao.queryForAll();
            for (Sales s : list) {
                Object[] isi = new Object[4];
                isi[0] = s.getIdsales();
                isi[1] = s.getNama();
                isi[2] = s.getAlamat();
                isi[3] = s.getTelpon();
                dtm.addRow(isi);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
  String[] kolom = {"ID", "Nama", "Alamat", "telpon"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        try {
             List<Sales> list = dao.queryBuilder().where().
                    like("nama", "%"+key+"%").query();
            for (Sales s : list) {
                Object[] isi = new Object[4];
                isi[0] = s.getIdsales();
                isi[1] = s.getNama();
                isi[2] = s.getAlamat();
                isi[3] = s.getTelpon();
                dtm.addRow(isi);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    

       
    }
    
    
   
    



