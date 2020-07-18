/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import database.DAO;

/**
 *
 * @author USER
 */
public class BarangTest {
    
    public static void main(String[] args) {
        
    DAO dao = new BarangDAOImp();
    
    Barang b = new Barang();
    
    b.setNamabarang("MACBOOK PRO");
    b.setJenisbarang("APPLE");
    b.setHargabeli(50000);
    b.setHargajual(60000);
    b.setStok(5);
    dao.insert(b);
            }
}
