/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import framework.clss.singletonGen;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;

/**
 *
 * @author osotemi
 */
public class DAO_DB_Client {
    
    /**LOAD MONGO CLIENT DB
     * 
     * Function that count the elements on singletonGen.table. 
     * Reads his content one by one, saving client on document, 
     * transform and saves it on singletonClient.ephemeralClient.
     * Finally adds singletonClient.ephemeralClient on singletonClient.ClienTableArray
     * 
     * @return void
     */
    public static void mongoDB_load_clientAL() {
        DBCursor index = null;
        
        try {
            index = singletonGen.collection.find();
            if(index.count()!=0){
                while(index.hasNext()){
                    BasicDBObject document = (BasicDBObject) index.next();
                    //singletonClient.ephemeralClient = singletonClient.ephemeralClient.DB_to_Client(document);
                    singletonClient.ClienTableArray.add(singletonClient.ephemeralClient.DB_to_Client(document));
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (index != null){
		index.close();
            }
	}
    }
    
    /**INSERT CLIENT
     * 
     * Inserts Client on collection
     * 
     */
    public static void insert_Client() {
        singletonGen.collection.insert(singletonClient.ephemeralClient.Client_to_DB());
    }
    
    public static void update_Client( ) {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateAtribute = new BasicDBObject();
        updateAtribute.append("$set", singletonClient.ephemeralClient.Client_to_DB());
        
        //look for register with primariKey
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", singletonClient.dniClt);
        
        //update
        singletonGen.collection.updateMulti(searchById, updateAtribute);
    }
    
    /**
     * Remove a Client dni gived from collection Client mongo DB
     */   
    public static void delete_Client_by_dni() {
        singletonGen.collection.remove(new BasicDBObject().append("dni", singletonClient.dniClt));
    }
    /**Search on mongo client collection for a client with usernam gived
     * 
     * @return boolean
     */
    public static boolean DAO_searchONclientBYuserName(){
        boolean valid=false;
        DBCursor cursor = null;
        Client clt = new Client();
        
        try {
            BasicDBObject query = new BasicDBObject();
            query.put("user", singletonClient.userName);
            
            cursor = singletonGen.collection.find(query);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    clt = singletonClient.ephemeralClient.DB_to_Client(document);
                    
                    if(clt.getPassword().equals(singletonClient.ephemeralClient)){
                        valid=true;
                        System.out.println("ERROR Login for while!!!");
                    }
                }
                
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        return valid;
    }
    
    
    /*
    public static void delete_Client_in_list(DB db, DBCollection table, List lista) {
        BasicDBObject query = new BasicDBObject();
        query.put("apellidos", new BasicDBObject("$in", lista));
        table.remove(query);
    }
    */
}
