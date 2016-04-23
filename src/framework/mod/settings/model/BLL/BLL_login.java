/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.BLL;

import framework.mod.settings.model.DAO.DAO_login;

/**
 *
 * @author osotemi
 */
public class BLL_login {
    public static boolean logIN(){
        boolean valid = false;
        
        if ( DAO_login.DAO_searchONadmin() ){
            
        }
        else if( DAO_login.DAO_searchONclient() ){
            
        } 
        else if( DAO_login.DAO_searchONreg() ){
            
        }
        else{
            
        }
        return valid;
    }
}
