/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.BLL;

import framework.mod.user.client.model.DAO.DAO_DB_Client;

/**
 *
 * @author osotemi
 */
public class BLL_DB_Client {
    public static void BLL_DB_newClient() {
        DAO_DB_Client.insert_Client();
    }
    
    public static void BLL_DB_listClient() {
        DAO_DB_Client.mongoDB_load_clientAL();
        
    }
    
    public static void BLL_DB_modifyClient() {
        DAO_DB_Client.update_Client( );
    }
    
    public static void BLL_DB_deleteClient() {
        DAO_DB_Client.delete_Client_by_dni();
    }
    
    public static int BLL_DB_searchByDni() {
        int pos = 0;
        
        
        
        return pos;
    }
}
