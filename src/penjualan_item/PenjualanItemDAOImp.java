/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan_item;

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
import penjualan.Penjualan;
import sales.Sales;

/**
 *
 * @author USER
 */
public class PenjualanItemDAOImp implements PenjualanItemDAO{
    
    private Dao<Barang, Integer> daoBarang;
    private Dao<Sales, Integer> daoSales;
    private Dao<Penjualan, Integer> daopenjualan;
    private Dao<PenjualanItem, Integer> daopenjualanitem;
    
     private List<PenjualanItem> items = new ArrayList<>();

   
   
    public PenjualanItemDAOImp() {
        try {

            daoBarang = DaoManager.createDao(Koneksi.cs(), Barang.class);
            daoSales = DaoManager.createDao(Koneksi.cs(), Sales.class);
            daopenjualan = DaoManager.createDao(Koneksi.cs(), Penjualan.class);
            daopenjualanitem = DaoManager.createDao(Koneksi.cs(), PenjualanItem.class);
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Barang> loadBarang() {
        List<Barang> barang = null;

        try {
            barang = daoBarang.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barang;
    }

    @Override
    public List<Sales> loadSales() {
   List<Sales> sales = null;

        try {
            sales = daoSales.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }
    
    @Override
    public void addItem(PenjualanItem item) {
        items.add(item);
    }

    @Override
    public void deleteItem(int index) {
        items.remove(index);
    }

    @Override
    public double refreshTotal() {
        double total = 0;
        for (PenjualanItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public DefaultTableModel viewItem() {
        DefaultTableModel dtm;
        String[] title = {"ID", "Nama", "Harga Jual", "Qty","Sub Total"};
        dtm = new DefaultTableModel(null, title);

        for (PenjualanItem item : items) {
            Object[] isi = new Object[5];
            isi[0] = item.getBarang().getIdbarang();
            isi[1] = item.getBarang().getNamabarang();
            isi[2] = Konversi.konversi(item.getBarang().getHargajual());
            isi[3] = item.getQty();
            isi[4] = Konversi.konversi(item.getSubTotal());
            dtm.addRow(isi);
        }
        return dtm;
    }

    @Override
    public void insertPenjualan(Penjualan p) {
        try {
            daopenjualan.create(p);

            for (PenjualanItem i : items) {
                PenjualanItem penjualanitem = new PenjualanItem();
                //set penjualan
                penjualanitem.setPenjualan(p);
                penjualanitem.setQty(i.getQty());
                penjualanitem.setSubTotal(i.getSubTotal());
                
                //setbarang
                penjualanitem.setBarang(i.getBarang());
                daopenjualanitem.create(penjualanitem);
            }
            JOptionPane.showMessageDialog(null, "Transaksi Penjualan telah tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItemDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void reset() {
        items.removeAll(items);
    }
    
    @Override
    public void editItem(int index, PenjualanItem item) {
        items.set(index, item);
    }
}