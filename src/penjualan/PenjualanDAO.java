/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public interface PenjualanDAO {
    
    public DefaultTableModel selectAll();

    public DefaultTableModel search(String key);

    public DefaultTableModel detail(int id);
   
    public void cetak(String id);
    
}
