/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.clss;

import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.registered.model.classes.RegisteredU;
import java.util.ArrayList;

/**singletonProfile
 * variables used for user and configuration profile
 *
 * @author osotemi
 */
public class singletonProfile {
    //Configuration profile
    public static final String THM_native = "Native";
    public static final String THM_nimbus = "Nimbus";
    public static final String THM_motif = "Motif";
    public static final String THM_windows = "Windows";
    public static final String THM_win98 = "WindowsC";
    public static ArrayList<Profiles> Alist_Profile;
    //User profile
    public static String userType;
    public static String userName;
    public static String userPass;
    public static Admin adm;
    public static Client clt;
    public static RegisteredU RegU;
}
