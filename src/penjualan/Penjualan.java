/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import sales.Sales;
import user.User;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "penjualan")
public class Penjualan {
    
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
    private Sales sales;

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

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

   
    
   
    
    
    
}
