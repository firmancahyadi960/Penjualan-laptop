/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
//import penjualan.Penjualan;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName= "user")
public class User {
  
 @DatabaseField(generatedId = true)   
 private int id;
 
 @DatabaseField
 private String nama;

 @DatabaseField
 private String username;
 
 @DatabaseField
 private String password;

// @ForeignCollectionField
// ForeignCollection<Penjualan> penjualan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public ForeignCollection<Penjualan> getPenjualan() {
//        return penjualan;
//    }
//
//    public void setPenjualan(ForeignCollection<Penjualan> penjualan) {
//        this.penjualan = penjualan;
//    }
// 
  
}
