/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "sales")
public class Sales {
   
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String alamat;
    @DatabaseField
    private String telpon;

    public int getIdsales() {
        return id;
    }

    public void setIdsales(int id) {
        this.id = id;
    }

   

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

   

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

   

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    
    
    
}
