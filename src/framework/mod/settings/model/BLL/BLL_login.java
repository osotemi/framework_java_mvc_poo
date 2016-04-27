/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.BLL;

import framework.clss.ConnectionBD;
import framework.mod.settings.model.DAO.DAO_login;
import framework.mod.settings.model.clss.singletonProfile;
import framework.mod.user.admin.model.DAO.DAO_DB_Admin;
import java.sql.Connection;

/**
 *
 * @author osotemi
 */
public class BLL_login {
    /**BLL_DB_srchAdminBYname()
     * Check LoginFrame txt_fields user and password 
     * ands looks for it on MySQL database admin table
     * 
     * @return 
     */
    public static boolean BLL_DB_srchAdminBYname() {
        boolean valid = false;
        Connection _con;
        if(DAO_login.askUsername() && DAO_login.askPassword()){
            _con = ConnectionBD.getConexion();
            int correcto = DAO_login.DAO_srcAdminBYname(_con);
            ConnectionBD.liberaConexion(_con);
            if(correcto == 0){
               valid = true;
            }
        }
        
        return valid;
    }
    public static boolean BLL_DB_searchClientBYname() {
        if(DAO_login.askUsername() && DAO_login.askPassword())
            return DAO_login.DAO_searchONclient();
                
        return false;
    }
    
    public static boolean BLL_DB_searchReguBYname() {
        if(DAO_login.askUsername() && DAO_login.askPassword())      
            return DAO_login.DAO_searchONreg();
        
        return false;
    }
    /**logIN()
     * Checks BLL_DB_srchAdminBYname() , BLL_DB_srchClientBYname(), BLL_DB_srchReguBYname()
     * Return if the user it's found and saves type on singletonProfile.userType
     * 
     * @return boolean
     */
    public static boolean logIN(){
        boolean valid = false;
        
        if ( BLL_DB_srchAdminBYname() ){
            valid = true;
            singletonProfile.userType = "Admin";
        }
        else if( DAO_login.DAO_searchONclient() ){
            valid = true;
            singletonProfile.userType = "Client";
        } 
        else if( DAO_login.DAO_searchONreg() ){
            valid = true;
            singletonProfile.userType = "RegU";
        }
        
        return valid;
    }
}
