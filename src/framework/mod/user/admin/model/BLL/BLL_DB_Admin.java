/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.BLL;

import framework.clss.ConnectionBD;
import framework.mod.user.admin.model.DAO.DAO_Admin;
import framework.mod.user.admin.model.DAO.DAO_DB_Admin;
import framework.mod.user.admin.view.main_Admin;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**BLL_DB_Admin
 *
 * @author osotemi
 */
public class BLL_DB_Admin {
    /**BLL_DB_newAdmin
     * Ask for connection and INSERTs an array list
     * 
     * @return ERROR
     */
    public static int BLL_DB_newAdmin() {
        Connection _con = null;

        //ConnectionBD _conexion_DB = new ConnectionBD();
        //_con = _conexion_DB.OpenConnection();
        _con = ConnectionBD.getConexion();

        int output = DAO_DB_Admin.DAO_newAdmin(_con);
        
        ConnectionBD.liberaConexion(_con);

        return output;
    }
    /**BLL_DB_lisAdmin
     * Loads all the admins from DB to array list 
     * 
     */

    public static void BLL_DB_listAdmin() {

        Connection _con = null;
        
        _con = ConnectionBD.getConexion();
        
        DAO_DB_Admin _adminDAO = new DAO_DB_Admin();

        try {
            _adminDAO.DAO_listAdmin(_con);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
        
        ConnectionBD.liberaConexion(_con);
    }

    /**BLL_DB_modifyAdmin
     * BLL function get a connection and calls DAO_modifyAdmin 
     * 
     * return @param
     */
    public static int BLL_DB_modifyAdmin() {
        
        Connection _con;

        _con = ConnectionBD.getConexion();
        int error = DAO_DB_Admin.DAO_modifyAdmin(_con);
        
        ConnectionBD.liberaConexion(_con);
        return error;
    }

    /**BLL_DB_deleteAdmin
     * BLL function that calls DAOO_deleteAdmin to DELETE an admin from DB
     * 
     * @return ERROR
     */
    public static int BLL_DB_deleteAdmin() {

        Connection _con;
        
        _con = ConnectionBD.getConexion();
        int correcto = DAO_DB_Admin.DAO_deleteAdmin(_con);
        ConnectionBD.liberaConexion(_con);

        return correcto;
    }

    /**BLL_DB_searchByDni
     * Search an Admin on array list and saves it on singletonAdmin.ephemeralAdmin
     * 
     * @return ERROR
     */
    public static int BLL_DB_searchByDni() {

        Connection _con;
        
        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = ConnectionBD.getConexion();
        int correcto = DAO_DB_Admin.DAO_searchAdminBYdni(_con);
        ConnectionBD.liberaConexion(_con);

        return correcto;
    }
    
    /**BLL_DB_searchByUserName
     * Search an Admin on DB and return true/false if exists
     * If exists, saves it on singletoAdmin.ephemeralAdmin
     * 
     * @return boolean
     */
    public static boolean BLL_DB_searchByUserName(String userName) {

        Connection _con;
        userName = main_Admin.txtf_formAdm_username.getText();
        _con = ConnectionBD.getConexion();
        boolean valid = DAO_DB_Admin.DAO_srcAdminBYname(_con, userName);
        ConnectionBD.liberaConexion(_con);

        return valid;
    }
}
