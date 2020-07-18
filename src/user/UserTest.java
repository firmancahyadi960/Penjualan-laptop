/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import database.DAO;

/**
 *
 * @author USER
 */
public class UserTest {
    public static void main(String[] args) {
        
        
        DAO dao = new UserDAOImp();
         
        User u = new User();
        
        u.setNama(" rian ");
        u.setUsername(" rian@gmail.com ");
        u.setPassword("12345");
        dao.insert(u);
    }
}
