/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.BLL;

import framework.mod.nav.model.tools.menu_gen;
import framework.mod.nav.view.main;
import framework.mod.user.admin.model.DAO.DAO_Admin;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.miniSimpleTableModel_Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.json;
import framework.mod.user.admin.model.tools.pager.pagina;
import framework.mod.user.admin.view.main_Admin;
import framework.mod.user.model.clss.singletonU;
import framework.mod.user.admin.model.tools.json;
import framework.mod.user.admin.model.tools.txt;
import framework.mod.user.admin.model.tools.xml;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author osotemi
 */
public class BLL_Admin {

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

    public static void BLL_FA_CleanPass(){
        if(singletonAdmin.currentForm.equals("Modify")){
            if(!singletonAdmin.passModf){
                DAO_Admin.DAO_cfPass();
            }
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

    /**
     * FILE SAVE BLL FUNCTIONS
     */
    
    public static void BLL_UserSaveXML() {
        xml.AdminXml_Save();
    }

    public static void BLL_UserSaveJSON() {
        json.AdminJson_Save();
    }

    public static void BLL_UserSaveTXT() {
        txt.AdminTxt_Save();
    }

    /**
     * C-R-U-D functions
     */
    
    public static void BLL_Adm_form() {
        singletonAdmin.currentForm = singletonAdmin.CREATE;
        DAO_Admin.formNew();
    }

    
    public static boolean BLL_ModifyAdm() {
        singletonAdmin.currentForm = singletonAdmin.MODIFY;
        singletonAdmin.passModf = false;
        int selec = -1, pos =0;
        String dni;
        boolean valid = false;
        
        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            selec = main_Admin.TABLA.getSelectedRow();
            
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                selec++;//Me coge uno menos no se por que
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 4);
                Admin adm = new Admin(dni);
                singletonAdmin.ephemeralAdmin = adm;
                pos = searchAL();
                singletonAdmin.ephemeralAdmin = singletonAdmin.AdminTableArray.get(selec);
                DAO_Admin.forModifyAdmin();
                valid = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacía", "Error!", 2);
        }
        return valid;
    }
    
    public static boolean modifyAdmAL() throws InterruptedException{
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.jPanel2.isVisible()){
                    main_Admin.jPanel2.setVisible(false);
                }
            }
        };
        boolean valid = false;
        int pos;
        if( DAO_Admin.askConfirmPassword() ){
            singletonAdmin.ephemeralAdmin = new Admin( main_Admin.txtf_formAdm_dni.getText() );
            pos = searchAL();
            if(pos != -1){
                if(DAO_Admin.formCreateAdmin()){
                    singletonAdmin.AdminTableArray.set(pos, singletonAdmin.ephemeralAdmin);
                    json.AdminJson_Autosave();
                    main_Admin.runTABLE();
                    main_Admin.lblMainform.setOpaque(true);
                    main_Admin.lblMainform.setBackground(Color.GREEN);
                    main_Admin.lblMainform.setText("Administrador modificado con exito!!");
                    valid = true;
                }
                else{
                    DAO_Admin.DAO_ERR_Modify();
                    main_Admin.lblMainform.setOpaque(true);
                    main_Admin.lblMainform.setBackground(Color.red);
                    main_Admin.lblMainform.setText("Error al crear");
                }
            }
            else{
                if(singletonAdmin.passModf){
                    //seguro que desa guardar con nuevo dni
                }
                else{
                    DAO_Admin.DAO_ERR_Modify();
                }
            }
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(2000);
            timer.setRepeats(false);
            timer.start();
            //main_Admin.jPanel2.setVisible(!valid);
            
        }
            
        return valid;
    }
    
       
    public static void BLL_FA_CreateAdmin() throws InterruptedException {
        boolean visible=true;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.jPanel2.isVisible()){
                    main_Admin.jPanel2.setVisible(false);
                }
            }
        };
        if (DAO_Admin.formCreateAdmin()) {
            if (createAdmAL()) {

                main_Admin.lblMainform.setOpaque(true);
                main_Admin.lblMainform.setBackground(Color.green);
                main_Admin.lblMainform.setText("Admin creation succesfully");
                visible = false;

                //pager
            } else {
                main_Admin.lblMainform.setOpaque(true);
                main_Admin.lblMainform.setBackground(Color.red);
                main_Admin.lblMainform.setText("Admin Save fail");
                visible=true;
            }
        } else {
            main_Admin.lblMainform.setOpaque(true);
            main_Admin.lblMainform.setBackground(Color.red);
            main_Admin.lblMainform.setText("Admin Save fail");
            //Control de errores de Admin
        }
        if(!visible){
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(2000);
            timer.setRepeats(false);
            timer.start();
        }
    }

    
    /**
     * Function that create an user object in his singletonU Array list
     *
     * @param int optfull -> if == 1-> create full object else -> creates a PK
     * object
     */
    public static boolean createAdmAL() {
        String tryagain[] = {"Try again", "Exit"};
        String dni = "";
        int pos = 0, opt_tryagain = 0;
        boolean valid = false;

        //ask first DNI
        pos = searchAL();
        JOptionPane.showMessageDialog(null, ""+pos);
        if (pos == -1) {
            singletonAdmin.AdminTableArray.add(singletonAdmin.ephemeralAdmin);
            json.AdminJson_Autosave();
            main_Admin.runTABLE();
            valid = true;
        } else {
            main_Admin.lbl_formAdm_dniERR.setText("Dni already exist");
            valid = false;
        }
        return valid;
    }

    public static boolean deleteAdmAL() {
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.jPanel2.isVisible()){
                    main_Admin.jPanel2.setVisible(false);
                }
            }
        };
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Admin.TABLA.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 4);
                name = (String) main_Admin.TABLA.getModel().getValueAt(selec, 0);
                lastname = (String) main_Admin.TABLA.getModel().getValueAt(selec, 1);
                Admin adm = new Admin(dni);
                singletonAdmin.ephemeralAdmin = adm;
                pos = searchAL();
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a " + lastname + ", " + name + " con dni " + dni, "Atención!", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).removeRow(selec);
                    adm = singletonAdmin.AdminTableArray.get(pos);
                    singletonAdmin.AdminTableArray.remove(adm);
                    miniSimpleTableModel_Admin.datosaux.remove(adm);
                    main_Admin.runTABLE();
                    json.AdminJson_Autosave();
                    Timer timer = new Timer(1000, task);
                    timer.setInitialDelay(2000);
                    timer.setRepeats(false);
                    timer.start();
                    
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
        }
        return false;
    }
    
    public static void viewAdmAL() {
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Admin.TABLA.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
                main_Admin.btn_viewAdmin.requestFocus();
                return;
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 4);
                Admin adm = new Admin(dni);
                singletonAdmin.ephemeralAdmin = adm;
                pos = searchAL();
                singletonAdmin.ephemeralAdmin = singletonAdmin.AdminTableArray.get(pos);
                DAO_Admin.formViewAdmin();
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
        }
    }
    
    /**
     * Searchs for the actual singletonAdmin.ephemeral Admin on
     * singletonU.Alist_adm
     */
    public static int searchAL() {
        int pos = -1;
        if (singletonAdmin.AdminTableArray != null) {
            for (int i = 0; i < singletonAdmin.AdminTableArray.size(); i++) {
                if (singletonAdmin.AdminTableArray.get(i).getDni().equals(singletonAdmin.ephemeralAdmin.getDni())) {//search by dni
                    pos = i;
                    i = singletonAdmin.AdminTableArray.size();
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

        al_size = singletonAdmin.AdminTableArray.size();
        if (al_size == 0) {//Non users on string
            pos = -1;
        } else {
            users = new String[al_size + 1];
            for (int i = 0; i < al_size; i++) {
                adm = singletonAdmin.AdminTableArray.get(i);
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
        singletonAdmin.loadSingletonAdmin();
        json.AdminJson_Autoload();
    }

}
