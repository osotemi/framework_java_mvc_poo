/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.BLL;

import framework.mod.nav.model.tools.menu_gen;
import framework.mod.user.admin.model.DAO.DAO_Admin;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.miniSimpleTableModel_Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.json;
import framework.mod.user.admin.view.main_Admin;
import framework.mod.user.model.clss.singletonU;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class BLL_Admin {

    public static void BLL_Adm_form() {
        DAO_Admin.formNew();
    }

    public static void BLL_FA_mainBack() {
        DAO_Admin.DAO_FA_mainBack();
    }

    public static void BLL_FA_HideNewFormPanel() {
        DAO_Admin.DAO_FA_hideFormPanel();
    }

    public static void BLL_FA_CleanName() {
        DAO_Admin.DAO_cfName();
    }

    public static void BLL_FA_CleanLastName() {
        DAO_Admin.DAO_cfLastName();
    }

    public static void BLL_FA_CleanUserName() {
        DAO_Admin.DAO_cfUserName();
    }

    public static void BLL_FA_CleanPhone() {
        DAO_Admin.DAO_cfPhone();
    }

    public static void BLL_FA_CleanEmail() {
        DAO_Admin.DAO_cfEmail();
    }

    public static void BLL_FA_CleanDNI() {
        DAO_Admin.DAO_cfDNI();
    }

    public static void BLL_FA_CreateAdmin() {
        if (DAO_Admin.createAdmin()) {
            if (createUser_onAL()) {
                //Guardar en JSON
                //settext
                //verd
                //sleep 3000

                //dispose
                //pager
            } else {
                //settext
                //roig
                //sleep 3000
                //errro
            }
            JOptionPane.showMessageDialog(null, singletonU.Alist_adm.get(0));
            main_Admin.lblMainform.setBackground(Color.green);
            main_Admin.lblMainform.setText("Admin creation succesfully");
        } else {

        }

    }

    public static void BLL_txtName() {
        DAO_Admin.askName();
    }

    public static void BLL_txtLastname() {
        DAO_Admin.askLastname();
    }

    public static void BLL_txtUsername() {
        DAO_Admin.askUsername();
    }

    public static void BLL_txtPhone() {
        DAO_Admin.askPhone();
    }

    public static void BLL_JPF_Password() {
        DAO_Admin.askPassword();
    }

    public static void BLL_JPF_PassConfirm() {
        DAO_Admin.askConfirmPassword();
    }

    public static void BLL_txtEmail() {
        DAO_Admin.askEmail();
    }

    public static void BLL_txtDNI() {
        DAO_Admin.askDNI();
    }

    public static void BLL_Activity() {
        DAO_Admin.askActivity();
    }

    public static void BLL_DCBornDate() {
        DAO_Admin.askBorndate();

    }

    public static void BLL_DCSingDate() {
        DAO_Admin.askSingDate();
    }

    public static void BLL_Avatar() {
        DAO_Admin.askAvatar();
    }

    public static void BLL_ModifyAdm() {
        int ALpos = -1;
        if (singletonU.Alist_adm.isEmpty()) {
            main_Admin.lblMainform.setText("No hay ningún Administrador cargado");
        } else {
            ALpos=searchALcombo();
            if(ALpos>=0){
                singletonAdmin.ephemeralAdmin = singletonU.Alist_adm.get(ALpos);
                DAO_Admin.forModifyAdmin(singletonAdmin.ephemeralAdmin);
            }
        }
    }

    /**
     * Function that create an user object in his singletonU Array list
     *
     * @param int optfull -> if == 1-> create full object else -> creates a PK
     * object
     */
    public static boolean createUser_onAL() {
        String tryagain[] = {"Try again", "Exit"};
        int pos = 0, opt_tryagain = 0;
        boolean valid = false;

        //ask first DNI
        pos = searchAL();
        if (pos == -1) {
            singletonU.Alist_adm.add(singletonAdmin.ephemeralAdmin);
            ((miniSimpleTableModel_Admin)main_Admin.TABLA.getModel()).cargar();
            valid = true;
        } else {
            //main_Admin..setText("Dni already exist");
            valid = false;
        }
        return valid;
    }

    /**
     * Searchs for the actual singletonAdmin.ephemeral Admin on
     * singletonU.Alist_adm
     */
    public static int searchAL() {
        int pos = -1;
        if (singletonU.Alist_adm != null) {
            for (int i = 0; i < singletonU.Alist_adm.size(); i++) {
                if (singletonU.Alist_adm.get(i).getDni().equals(singletonAdmin.ephemeralAdmin.getDni())) {//search by dni
                    pos = i;
                    i = singletonU.Alist_adm.size();
                }
            }
        }
        return pos;
    }

    /**
     * function that search in an array list for an User selected in an combo
     * box
     *
     * @return int position or -1 if the newuser is not on the array or -2 if
     * select Cancel option
     */
    public static int searchALcombo() {
        Admin adm = new Admin();
        String sltUser = "", dni = "";
        int pos = -3, al_size;
        String users[];

        al_size = singletonU.Alist_adm.size();
        if (al_size == 0) {//Non users on string
            pos = -1;
        } else {
            users = new String[al_size + 1];
            for (int i = 0; i < al_size; i++) {
                adm = singletonU.Alist_adm.get(i);
                users[i] = adm.getDni() + " - " + adm.getLastname() + " - " + adm.getName();
            }
            users[al_size] = "Back";
            sltUser = menu_gen.menucombo(users, "Back", "Select a user form the list", "Search in users list");
            if (sltUser.equals("Back")) {//Back Option
                pos = -2;

            } else if (sltUser.equals(null)) {//Cross/Cancel Option
                pos = -2;
            } else {
                for (int j = 0; j < 10; j++) {
                    dni += sltUser.charAt(j);
                }
                singletonAdmin.ephemeralAdmin = new Admin(dni);
                pos = searchAL();
            }
        }

        return pos;
    }

    public static void loadArray() {
        json.AdminJson_Autoload();
        singletonAdmin.AdminTableArray = singletonU.Alist_adm;
    }
}
