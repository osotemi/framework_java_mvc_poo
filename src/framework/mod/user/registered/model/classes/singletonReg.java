/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.classes;

import framework.clss.DateO;
import java.util.ArrayList;

/**
 *
 * @author osotemi
 */
public class singletonReg {
    public final static String MODIFY_REG = "Modify";
    public final static String CREATE_REG = "Create";
    public static ArrayList<RegisteredU> RegTableArray;
    public static RegisteredU ephemeralReg;
    public static String PATH_JSON;
    public static String PATH_TXT;
    public static String PATH_XML;
    /** buffer variables     */
    public static String currentRegForm;
    public static boolean passRegModf;//Tells if on modifay the password was prebiously changed
    public static DateO born_dateReg;
    public static DateO sing_dateReg;
    public static String passwd_formReg;
    public static String dniReg;
    public static String objtypeReg;//->admin ->client ->reg_u
    public static String PATH_formReg = "";
    public static boolean changesReg;
    public static int selectedPOSmodifyReg;
    /**
     * Initialite Array List
     */
    public static void loadSingletonReg(){
        RegTableArray = new ArrayList<RegisteredU>();
        PATH_JSON ="/src/framework/mod/user/registered/model/files/RegJsonDB.json";
        PATH_TXT ="/src/framework/mod/user/registered/model/files/RegTxtDB.txt";
        PATH_XML ="/src/framework/mod/user/registered/model/files/RegXmlDB.xml";
        passwd_formReg = "";
        selectedPOSmodifyReg =-1;
        changesReg = false;
    }
}
