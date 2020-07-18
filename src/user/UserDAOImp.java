/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class UserDAOImp implements DAO {

    private Dao<User, Integer> dao;
    

    public UserDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), User.class);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object o) {
        try {
            dao.create((User) o);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((User) o);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[] kolom = {"ID", "nama", "username", "password"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        try {
            List<User> list = dao.queryForAll();

            for (User u : list) {
                Object[] isi = new Object[4];
                isi[0] = u.getId();
                isi[1] = u.getNama();
                isi[2] = u.getUsername();
                isi[3] = u.getPassword();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);

        }
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
     String[] kolom = {"ID", "nama", "username", "password"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        try {
             List<User> list = dao.queryBuilder().where().
                    like("nama", "%"+key+"%").query();

            for (User u : list) {
                Object[] isi = new Object[4];
                isi[0] = u.getId();
                isi[1] = u.getNama();
                isi[2] = u.getUsername();
                isi[3] = u.getPassword();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);

        }
        return dtm;
    }

   
    }


