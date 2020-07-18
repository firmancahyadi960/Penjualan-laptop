/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian_item;

import pembelian_item.*;
import barang.Barang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import pembelian.Pembelian;
import supplier.Supplier;

/**
 *
 * @author USER
 */
public interface PembelianItemDAO {
    
    public List<Supplier> loadSupplier();
    
    public List<Barang> loadBarang();

    public void addItem(PembelianItem item);

    public void deleteItem(int index);
    
    public void editItem(int index, PembelianItem item);

    public double refreshTotal();

    public DefaultTableModel viewItem();

    public void insertPembelian(Pembelian p);

    public void reset();
}
