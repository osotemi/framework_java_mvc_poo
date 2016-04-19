/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.BLL;

import framework.mod.user.client.model.DAO.DAO_Client;
import framework.mod.user.client.model.DAO.DAO_DB_Client;
import framework.mod.user.client.model.classes.singletonClient;

/**
 *
 * @author osotemi
 */
public class BLL_DB_Client {
    public static void BLL_DB_newClient() {
        DAO_DB_Client.insert_Client(clientDB, client, singletonClient.ephemeralClient);
    }
    
    public static void BLL_DB_listClient() {
        DAO_DB_Client.print_table(clientDB, client);
    }
    
    public static void BLL_DB_modifyClient() {
        DAO_DB_Client.update_Client(clientDB, client, nombre, 0);
    }
    
    public static void BLL_DB_deleteClient() {
        DAO_DB_Client.delete_Client_by_name(clientDB, client, nombre);
    }
    
    public static int BLL_DB_searchByDni() {
        int pos = 0;
        
        
        
        return pos;
    }
}
