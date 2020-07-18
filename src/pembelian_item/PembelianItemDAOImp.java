/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian_item;

import pembelian_item.*;
import Tools.Konversi;
import barang.Barang;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pembelian.Pembelian;
import supplier.Supplier;

/**
 *
 * @author USER
 */
public class PembelianItemDAOImp implements PembelianItemDAO{
    
    private Dao<Barang, Integer> daoBarang;
    private Dao<Supplier, Integer> daosupplier;
    private Dao<Pembelian, Integer> daopembelian;
    private Dao<PembelianItem, Integer> daopembelianitem;
    
     private List<PembelianItem> items = new ArrayList<>();

   
   
    public PembelianItemDAOImp() {
        try {

            daoBarang = DaoManager.createDao(Koneksi.cs(), Barang.class);
            daosupplier = DaoManager.createDao(Koneksi.cs(), Supplier.class);
            daopembelian = DaoManager.createDao(Koneksi.cs(), Pembelian.class);
            daopembelianitem = DaoManager.createDao(Koneksi.cs(), PembelianItem.class);
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Barang> loadBarang() {
        List<Barang> barang = null;

        try {
            barang = daoBarang.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barang;
    }

    @Override
    public List<Supplier> loadSupplier() {
        List<Supplier> supplier = null;
        try {
            supplier = daosupplier.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }
   
    @Override
    public void addItem(PembelianItem item) {
        items.add(item);
    }

    @Override
    public void deleteItem(int index) {
        items.remove(index);
    }

    @Override
    public double refreshTotal() {
        double total = 0;
        for (PembelianItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public DefaultTableModel viewItem() {
        DefaultTableModel dtm;
        String[] title = {"ID", "Nama", "Harga Beli", "Qty","Sub Total"};
        dtm = new DefaultTableModel(null, title);

        for (PembelianItem item : items) {
            Object[] isi = new Object[5];
            isi[0] = item.getBarang().getIdbarang();
            isi[1] = item.getBarang().getNamabarang();
            isi[2] = Konversi.konversi(item.getBarang().getHargabeli());
            isi[3] = item.getQty();
            isi[4] = Konversi.konversi(item.getSubTotal());
            dtm.addRow(isi);
        }
        return dtm;
    }

    @Override
    public void insertPembelian(Pembelian p) {
        try {
            daopembelian.create(p);

            for (PembelianItem i : items) {
                PembelianItem pembelianitem = new PembelianItem();
                //set pembelian
                pembelianitem.setPembelian(p);
                pembelianitem.setQty(i.getQty());
                pembelianitem.setSubTotal(i.getSubTotal());
                
                //setbarang
                pembelianitem.setBarang(i.getBarang());
                daopembelianitem.create(pembelianitem);
            }
            JOptionPane.showMessageDialog(null, "Transaksi Penjualan telah tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void reset() {
        items.removeAll(items);
    }
    
    @Override
    public void editItem(int index, PembelianItem item) {
        items.set(index, item);
    }

    
}