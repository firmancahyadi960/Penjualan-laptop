/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import database.DAO;

/**
 *
 * @author USER
 */
public class SalesTest {
    
    public static void main(String[] args) {
    DAO dao = new SalesDAOImp();
    
    Sales s = new Sales();
    
   // s.setId(1);
    s.setNama(" PT SIDO MUNCUL");
    s.setAlamat(" AMPENAN");
    s.setTelpon("15017");
    dao.insert(s);
    }
}
