/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

import database.DAO;

/**
 *
 * @author USER
 */
public class SupplierTest {
    public static void main(String[] args) {
    DAO dao = new SupplierDAOImp();
    
    Supplier s = new Supplier();
    
   // s.setId(1);
    s.setNama(" PT SIDO ");
    s.setAlamat(" AMPENAN");
    s.setNo_telepon("15017");
    dao.insert(s);
    }
}
