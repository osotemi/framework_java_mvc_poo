/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.clss;

import com.mongodb.Mongo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author osotemi
 */
public class MongoDB {
    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String machine = null;
    private static String port = null;
    private static Mongo client = null;
    private static String nom_bd = null;
    private static String nom_table = null;
   
    /**MongoDB
     * Gets the properties of mongo data base
     * 
     * @throws IOException 
     */
    public MongoDB() throws IOException {
        try {
            input = new FileInputStream( new java.io.File(".").getCanonicalPath()
                    + "/src/framework/clss/mongo.properties"); 
            
            prop.load(input);
        } catch (Exception e) {
            System.out.println("Unable to open mongo.properties");
            e.printStackTrace();
        }
        machine = prop.getProperty("machine");
        port = prop.getProperty("port");
        nom_bd = prop.getProperty("db");
        nom_table = prop.getProperty("collection");
        if (input != null) {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to close mongo.properties");
            }
        }
    }
    /**connect
     * Open a client with mongo data base
     * 
     * @return Mongo
     */
    public static Mongo connect() {
        try {
            client = new Mongo(getMachine(), Integer.parseInt(getPort()));
            singletonGen.db = client.getDB(getNom_bd());
            singletonGen.collection = singletonGen.db.getCollection(getNom_table());
        } catch (Exception e) {
            System.out.println("Unable to open client");
            e.printStackTrace();
            if (client != null) {
		try {
                    client.close();
		} catch (Exception ex) {
                    System.out.println("Unable to close client");
                    ex.printStackTrace();
		}
            }
	}
        return client;
    }
    
    public static void disconnect() {
	client.close();
    }

    public static Properties getProp() {
        return prop;
    }

    public static InputStream getInput() {
        return input;
    }

    public static Mongo getClient() {
        return client;
    }

    public static void setProp(Properties prop) {
        MongoDB.prop = prop;
    }

    public static void setInput(InputStream input) {
        MongoDB.input = input;
    }

    public static void setClient(Mongo client) {
        MongoDB.client = client;
    }

    public static String getNom_bd() {
        return nom_bd;
    }

    public static void setNom_bd(String nom_bd) {
        MongoDB.nom_bd = nom_bd;
    }

    public static String getNom_table() {
        return nom_table;
    }

    public static void setNom_table(String nom_table) {
        MongoDB.nom_table = nom_table;
    }

    public static String getMachine() {
        return machine;
    }

    public static String getPort() {
        return port;
    }

    public static void setMachine(String machine) {
        MongoDB.machine = machine;
    }

    public static void setPort(String port) {
        MongoDB.port = port;
    }
}
