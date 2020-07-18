/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan_item;

import barang.Barang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import penjualan.Penjualan;
import sales.Sales;

/**
 *
 * @author USER
 */
public interface PenjualanItemDAO {
    
    public List<Sales> loadSales();
    
    public List<Barang> loadBarang();

    public void addItem(PenjualanItem item);

    public void deleteItem(int index);
    
    public void editItem(int index, PenjualanItem item);

    public double refreshTotal();

    public DefaultTableModel viewItem();

    public void insertPenjualan(Penjualan p);

    public void reset();
}
