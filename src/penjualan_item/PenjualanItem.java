/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan_item;

import barang.Barang;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import penjualan.Penjualan;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "penjualan_item")
public class PenjualanItem {
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private int qty;
    
    @DatabaseField
    private double subTotal;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Penjualan penjualan;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Barang barang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    

}
