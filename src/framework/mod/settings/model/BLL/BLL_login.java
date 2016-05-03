/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.BLL;

import framework.clss.ConnectionBD;
import static framework.mod.settings.controler.Controler_Main.LoginLayout;
import framework.mod.settings.model.DAO.DAO_login;
import framework.mod.settings.model.clss.singletonProfile;
import framework.mod.settings.view.main_login;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

/**
 *
 * @author osotemi
 */
public class BLL_login {
    /**BLL_DB_srchAdminBYname()
     * Check LoginFrame txt_fields user and password 
     * ands looks for it on MySQL database admin table
     * 
     * @return boolean
     */
    public static boolean BLL_DB_srchAdminBYname() {
        boolean valid = false;
        Connection _con;
        if(DAO_login.askUsername() && DAO_login.askPassword()){
            _con = ConnectionBD.getConexion();
            valid = DAO_login.DAO_srcAdminBYname(_con);
            
            ConnectionBD.liberaConexion(_con);
        }
        
        return valid;
    }
    /**BLL_DB_searchClientBYname()
     * Check LoginFrame txt_fields user and password 
     * ands looks for it on Mongo DB table client
     * 
     * @return boolean
     */
    public static boolean BLL_DB_searchClientBYname() {
        if(DAO_login.askUsername() && DAO_login.askPassword()){
           
            return DAO_login.DAO_searchONclient();
        }
        return false;
    }
    /**BLL_DB_searchReguBYname()
     * Check LoginFrame txt_fields user and password 
     * ands looks for it on registered user
     * 
     * @return boolean
     */
    public static boolean BLL_DB_searchReguBYname() {
        if(DAO_login.askUsername() && DAO_login.askPassword()){
            
            return DAO_login.DAO_searchONreg();
        }
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
        else{
            //LoginLayout.lbl_singINerror.setText("User not found");
            
        }
        
        return valid;
    }

    /**
     * 
     */
    public static boolean logOUT(){
        boolean valid=true;
        
        singletonProfile.userType = "none";;
        singletonProfile.loged = false;
        
        return valid;
    }
}
