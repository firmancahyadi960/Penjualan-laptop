/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

/**
 *
 * @author USER
 */
public interface AuthDao {
    
    public void login(String username, String password);

    public void logout();
}
