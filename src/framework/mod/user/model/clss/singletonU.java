/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.model.clss;

import framework.clss.DateO;
import framework.mod.user.admin.model.classes.Admin;
import java.util.ArrayList;

/**
 *
 * @author osotemi
 */
public class singletonU {
    /**----------------------------------
        * Definition of singleton object
        * --------------------------------*/

       //public static ArrayList<Admin> Alist_adm ;
       //public static ArrayList<Client> Alist_clt;
       //public static ArrayList<RegisteredU> Alist_RegU;
       public static boolean dummie_mode;
       public static boolean changes;
       public static String PATH;
       public static String PATH_formAdm;
       
       /**----------------------------------
        * Public methods of the Admin class
        * --------------------------------*/

       /**
        * <<<----------constructors--------->>>
        * */

       /**Constructor-->Generate a singleton object by default*/
       public static void loadSingletonU(){            
            //Alist_clt = new ArrayList<>();
            //Alist_RegU = new ArrayList<>();

            dummie_mode = true;
            PATH = "/src/framework/mod/user/admin/model/files/admin_dummies.json";
            
       }
}
