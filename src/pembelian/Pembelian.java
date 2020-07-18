/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

import penjualan.*;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import supplier.Supplier;
import user.User;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "pembelian")
public class Pembelian {
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String tanggal;
  
    @DatabaseField
    private double total;
    
   
    @DatabaseField 
    private double bayar;
    
    @DatabaseField
    private double kembalian;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBayar() {
        return bayar;
    }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

  
}
