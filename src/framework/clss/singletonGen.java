/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.clss;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import framework.clss.MongoDB;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author osotemi
 */
public class singletonGen {
    /** Pool de conexiones */
    public static BasicDataSource dataSource;
    
    /**Client mongo variables*/
    public static MongoDB mongo;
    public static DBCollection collection;
    public static DB db;
}
