/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.classes;

import framework.clss.DateO;
import java.util.ArrayList;

/**
 *
 * @author osotemi
 */
public class singletonAdmin {
    public final static String MODIFY = "Modify";
    public final static String CREATE = "Create";
    public static ArrayList<Admin> AdminTableArray;
    public static Admin ephemeralAdmin;
    public static String PATH;
    /** buffer variables     */
    public static String currentForm;
    public static boolean passModf;//Tells if on modifay the password was prebiously changed
    public static DateO born_date;
    public static DateO sing_date;
    public static String passwd_formAdm;
    public static String dni;
    public static String objtype;//->admin ->client ->reg_u
    public static String PATH_formAdm = "";
    public static boolean changes;
    public static int selectedPOSmodify;
    /**
     * Initialite Array List
     */
    public static void loadSingletonAdmin(){
        AdminTableArray = new ArrayList<Admin>();
        PATH ="/src/framework/mod/user/admin/model/files/admin_dummies.json";
        passwd_formAdm = "";
        selectedPOSmodify=-1;
        changes = false;
    }
}
