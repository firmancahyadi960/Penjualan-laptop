/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

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
import penjualan_item.PenjualanItem;

/**
 *
 * @author USER
 */
public class PenjualanDAOImp implements PenjualanDAO {

    private Dao<Penjualan, Integer> daoPenjualan;
    private Dao<PenjualanItem, Integer> daoPenjualanitem;

    public PenjualanDAOImp() {
        try {
            daoPenjualan = DaoManager.createDao(Koneksi.cs(), Penjualan.class);
            daoPenjualanitem = DaoManager.createDao(Koneksi.cs(), PenjualanItem.class);
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[] kolom = {"ID", "Tanggal", " Total", "bayar", "kembalian", "user", "sales"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<Penjualan> penjualan = daoPenjualan.queryForAll();
            for (Penjualan p : penjualan) {
                Object[] isi = new Object[7];
                isi[0] = p.getId();
                isi[1] = p.getTanggal();
                isi[2] = Konversi.konversi(p.getTotal());
                isi[3] = Konversi.konversi(p.getBayar());
                isi[4] = Konversi.konversi(p.getKembalian());
                isi[5] = p.getUser().getNama();
                isi[6] = p.getSales().getNama();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
        String[] kolom = {"ID", "Tanggal", " Total", "bayar", "kembalian", "user", "sales"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<Penjualan> penjualan = daoPenjualan.queryBuilder().where().
                    like("Tanggal", "%" + key + "%").query();
            for (Penjualan p : penjualan) {
                Object[] isi = new Object[7];
                isi[0] = p.getId();
                isi[1] = p.getTanggal();
                isi[2] = Konversi.konversi(p.getTotal());
                isi[3] = Konversi.konversi(p.getBayar());
                isi[4] = Konversi.konversi(p.getKembalian());
                isi[5] = p.getUser().getNama();
                isi[6] = p.getSales().getNama();
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel detail(int id) {
        String[] kolom = {"ID Barang", "Nama Barang", "Harga Jual", "Qty", "Sub Total"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<PenjualanItem> item = daoPenjualanitem.queryForEq("penjualan_id", id);
            for (PenjualanItem p : item) {
                Object[] isi = new Object[5];
                isi[0] = p.getBarang().getIdbarang();
                isi[1] = p.getBarang().getNamabarang();
                isi[2] = Konversi.konversi(p.getBarang().getHargajual());
                isi[3] = p.getQty();
                isi[4] = Konversi.konversi(p.getSubTotal());
                dtm.addRow(isi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanItem.class.getName()).log(Level.SEVERE, null, ex);
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
            File file = new File("src\\report\\StrukPenjualan.jrxml");

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
