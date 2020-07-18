/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

import penjualan.*;
import Tools.Konversi;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pembelian_item.PembelianItem;

/**
 *
 * @author USER
 */
public class PembelianDAOImp implements PembelianDAO{
      
    private Dao<Pembelian, Integer> daoPenjualan;
    private Dao<PembelianItem, Integer> daoPembelianitem;

    public PembelianDAOImp() {
        try {
            daoPenjualan = DaoManager.createDao(Koneksi.cs(), Pembelian.class);
            daoPembelianitem = DaoManager.createDao(Koneksi.cs(), PembelianItem.class);
        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[] kolom = {"ID", "Tanggal"," Total","bayar","kembalian","user","sales"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<Pembelian> penjualan = daoPenjualan.queryForAll();
            for (Pembelian p : penjualan) {
                Object[] isi = new Object[7];
                isi[0] = p.getId();
                isi[1] = p.getTanggal();
                isi[2] = Konversi.konversi(p.getTotal());
                isi[3] = Konversi.konversi(p.getBayar());
                isi[4] = Konversi.konversi(p.getKembalian());
                isi[5] = p.getUser().getNama();
                isi[6] = p.getSupplier().getNama();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
    String[] kolom = {"ID", "Tanggal"," Total","bayar","kembalian","user","sales"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
             List<Pembelian> penjualan = daoPenjualan.queryBuilder().where().
                    like("Tanggal", "%" + key + "%").query();
            for (Pembelian p : penjualan) {
               Object[] isi = new Object[7];
                isi[0] = p.getId();
                isi[1] = p.getTanggal();
                isi[2] = Konversi.konversi(p.getTotal());
                isi[3] = Konversi.konversi(p.getBayar());
                isi[4] = Konversi.konversi(p.getKembalian());
                isi[5] = p.getUser().getNama();
                isi[6] = p.getSupplier().getNama();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel detail(int id) {
         String[] kolom = {"ID Barang", "Nama Barang", "Harga Beli", "Qty", "Sub Total"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<PembelianItem> item = daoPembelianitem.queryForEq("pembelian_id", id);
            for (PembelianItem p : item) {
                Object[] isi = new Object[5];
                isi[0] = p.getBarang().getIdbarang();
                isi[1] = p.getBarang().getNamabarang();
                isi[2] = Konversi.konversi(p.getBarang().getHargabeli());
                isi[3] = p.getQty();
                isi[4] = Konversi.konversi(p.getSubTotal());
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembelianItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public void cetak(String id) {
     try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters.put("id", id);
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\StrukPembelian.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, kon.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}


