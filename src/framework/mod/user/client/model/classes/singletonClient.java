/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.classes;

import framework.clss.DateO;
import java.util.ArrayList;

/**
 *
 * @author osotemi
 */
public class singletonClient {
    public final static String MODIFY_CLT = "Modify";
    public final static String CREATE_CLT = "Create";
    public static ArrayList<Client> ClienTableArray;
    public static Client ephemeralClient;
    public static String PATH_CLT;
    /** buffer variables     */
    public static String currentCltForm;
    public static boolean passCltModf;//Tells if on modifay the password was prebiously changed
    public static DateO born_dateClt;
    public static DateO sing_dateClt;
    public static String passwd_formClt;
    public static String dniClt;
    public static String objtypeClt;//->admin ->client ->reg_u
    public static String PATH_formClt = "";
    public static boolean changesClt;
    public static int selectedPOSmodifyClt;
    /**
     * Initialite Array List
     */
    public static void loadSingletonClient(){
        ClienTableArray = new ArrayList<Client>();
        PATH_CLT ="/src/framework/mod/user/client/model/files/clientDB.json";
        passwd_formClt = "";
        selectedPOSmodifyClt =-1;
        changesClt = false;
    }
}
