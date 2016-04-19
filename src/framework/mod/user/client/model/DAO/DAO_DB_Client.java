/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import framework.mod.user.client.model.classes.Client;
import java.util.List;

/**
 *
 * @author osotemi
 */
public class DAO_DB_Client {
    
    public static void insert_Client(DB db, DBCollection table, Client clt) {
        table.insert(clt.to_DB_Worker());//Implementar en client DB_to_CLient
    }
    
    public static String print_table(DB db, DBCollection table) {
        DBCursor cursor = null;
        String rdo = "";
        Client clt = new Client();
        try {
            cursor = table.find();
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    clt = clt.Worker_to_DB(document);//Implementar en client Client_to_DB
                    rdo = rdo + (clt.getNombre() + " - " + clt.getApellidos() + " - " +clt.getEdad() + "\n");
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        return rdo;	
    }
    
    public static String print_table_where(DB db, DBCollection table, String nombre) {
        DBCursor cursor = null;
        String rdo = "";
        Client clt = new Client();
        try {
            BasicDBObject query = new BasicDBObject();
            query.put("nombre", nombre);

            cursor = table.find(query);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    clt = clt.Worker_to_DB(document);//Implementar en client Client_to_DB
                    rdo = rdo + (clt.getNombre() + " - " + clt.getApellidos() + " - " +clt.getEdad() + "\n");
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        return rdo;	
    }
    
    public static void update_Client(DB db, DBCollection table, String nombre, int nuevosAnyos) {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateAnyos = new BasicDBObject();
        updateAnyos.append("$set", new BasicDBObject().append("edad", nuevosAnyos));
 
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("nombre", nombre);
 
        //Realiza la actualización
        table.updateMulti(searchById, updateAnyos);
    }
    
        
    public static void delete_Client_by_name(DB db, DBCollection table, String nombre) {
        table.remove(new BasicDBObject().append("nombre", nombre));
    }
    
    public static void delete_Client_age_gt(DB db, DBCollection table, int anyos) {
        BasicDBObject query = new BasicDBObject();
        query.put("edad", new BasicDBObject("$gt", anyos));
        table.remove(query);
    }
    
    public static void delete_Client_in_list(DB db, DBCollection table, List lista) {
        BasicDBObject query = new BasicDBObject();
        query.put("apellidos", new BasicDBObject("$in", lista));
        table.remove(query);
    }
}
