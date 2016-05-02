/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.BLL;

import framework.mod.user.admin.controler.Controler_mainAdmin;
import framework.mod.user.admin.model.DAO.DAO_Admin;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.miniSimpleTableModel_Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.LanguageAdm;
import framework.mod.user.admin.model.tools.pager.pagina;
import framework.mod.user.admin.view.main_Admin;
import framework.mod.user.admin.model.tools.json;
import framework.mod.user.admin.model.tools.txt;
import framework.mod.user.admin.model.tools.xml;
import static framework.mod.user.admin.view.main_Admin.CB_tbl_entries;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static void BLL_FA_formCreate(){
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            try {
                BLL_Admin.FORM_BTN_createAdmin();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (singletonAdmin.currentForm.equals(singletonAdmin.MODIFY)) {
            try {
                BLL_Admin.FORM_BTN_modifyAdm();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void BLL_FA_CleanName() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfName();
        } else {
            main_Admin.txtf_formAdm_name.selectAll();
        }
    }

    public static void BLL_FA_CleanLastName() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfLastName();
        } else {
            main_Admin.txtf_formAdm_lastname.selectAll();
        }
    }

    public static void BLL_FA_CleanUserName() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfUserName();
        } else {
            main_Admin.txtf_formAdm_username.selectAll();
        }
    }

    public static void BLL_FA_CleanPhone() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfPhone();
        } else {
            main_Admin.txtf_formAdm_phone.selectAll();
        }
    }

    public static void BLL_FA_CleanEmail() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfEmail();
        } else {
            main_Admin.txtf_formAdm_email.selectAll();
        }
    }

    public static void BLL_FA_CleanDNI() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfDNI();
        } else {
            main_Admin.txtf_formAdm_dni.selectAll();
        }
    }

    public static void BLL_FA_CleanPass() {
        if (singletonAdmin.currentForm.equals(singletonAdmin.MODIFY)) {
            if (!singletonAdmin.passModf) {
                DAO_Admin.DAO_cfPass();
                singletonAdmin.passModf = true;
            } else {
                main_Admin.JPF_fromAdm_pass.selectAll();
            }
        } else if (singletonAdmin.currentForm.equals(singletonAdmin.CREATE)) {
            DAO_Admin.DAO_cfPass();
        }
    }

    public static void BLL_TBL_Previous(){
        pagina.currentPageIndex -= 1;
        pagina.initLinkBox();
    }
    
    public static void BLL_TBL_Next(){
        pagina.currentPageIndex += 1;
        pagina.initLinkBox();
    }
    
    public static void BLL_TBL_First(){
        pagina.currentPageIndex = 1;
        pagina.initLinkBox();
    }
    
    public static void BLL_TBL_Last(){
        pagina.currentPageIndex = pagina.maxPageIndex;
        pagina.initLinkBox();
    }
    
    public static void BLL_TBL_CB_entries(){
        pagina.itemsPerPage = Integer.parseInt(CB_tbl_entries.getSelectedItem().toString());
        pagina.currentPageIndex = 1;
        pagina.initLinkBox();
    }
    
    public static void BLL_TBL_combo(){
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).filtrar();
        main_Admin.combo.requestFocus();
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
     * MTableMouse Clicked actions
     */
    public static void BLL_TableMouseClick(java.awt.event.MouseEvent evt) {
        boolean modificar = false;

        if (evt.getClickCount() == 2) {
            main_Admin.PNL_drawForm.setVisible(BLL_Admin.BLL_ModifyAdm());
        } else if ((evt.getModifiers() == InputEvent.BUTTON1_MASK)) {
            BLL_ViewAdm();
            main_Admin.PNL_drawForm.setVisible(true);
        }
    }

    /**
     * C-R-U-D functions
     */
    /**
     *
     */
    public static void BLL_CreateAdm() {
        singletonAdmin.currentForm = singletonAdmin.CREATE;
        DAO_Admin.formNew();
    }

    /**
     * Deletes an Admin selected on the table and saves changes on JSON file
     *
     * @return
     */
    public static boolean BLL_DeleteAdm() {
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {

                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Admin.TABLA.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("errTbl_selectUser"), LanguageAdm.getInstance().getProperty("error"), 2);
                
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 5);
                name = (String) main_Admin.TABLA.getModel().getValueAt(selec, 0);
                lastname = (String) main_Admin.TABLA.getModel().getValueAt(selec, 1);
                singletonAdmin.ephemeralAdmin = new Admin(dni);
                pos = searchAL();
                int opc = JOptionPane.showConfirmDialog(null, LanguageAdm.getInstance().getProperty("mes_askDelet_I") + lastname + ", " + name + LanguageAdm.getInstance().getProperty("mes_askDelet_II") + dni, LanguageAdm.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).removeRow(selec);
                    singletonAdmin.ephemeralAdmin = singletonAdmin.AdminTableArray.get(pos);
                    singletonAdmin.AdminTableArray.remove(singletonAdmin.ephemeralAdmin);
                    miniSimpleTableModel_Admin.datosaux.remove(singletonAdmin.ephemeralAdmin);
                    //Guardar en base de datos
                    BLL_DB_Admin.BLL_DB_deleteAdmin();
                    //Recargar de base de datos
                    Controler_mainAdmin.runTABLE();
                    //autosaveMultiformat();
                    
                    
                    main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("mes_delok"));
                    main_Admin.lblMainform.setOpaque(true);
                    main_Admin.lblMainform.setBackground(Color.red);
                    Timer timer = new Timer(4000, task);
                    timer.setInitialDelay(2000);
                    timer.setRepeats(false);
                    timer.start();

                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("error_emptyList"), LanguageAdm.getInstance().getProperty("error"), 2);
        }
        return false;
    }

    public static boolean BLL_DeleteAllAdm() {
        int pos = 0;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {
                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };

        int opc = JOptionPane.showConfirmDialog(null, LanguageAdm.getInstance().getProperty("mes_DeletAll"), LanguageAdm.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            singletonAdmin.AdminTableArray = new ArrayList<>();
           
            //autosaveMultiformat();
            //Guardar en base de datos
            //BLL_DB_Admin.deleteAll;
            //Recargar de base de datos
            Controler_mainAdmin.runTABLE();
            main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("mes_allDelOk"));
            main_Admin.lblMainform.setBackground(Color.red);
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(2000);
            timer.setRepeats(false);
            timer.start();
            return true;
        }
        return false;
    }

    /**
     * Function looks for an Admin to modify it and calls a DAO function to draw
     * modify form
     */
    public static boolean BLL_ModifyAdm() {
        singletonAdmin.currentForm = singletonAdmin.MODIFY;
        singletonAdmin.passModf = false;
        int selec = -1, pos = 0;
        String dni;
        boolean valid = false;

        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            selec = main_Admin.TABLA.getSelectedRow();

            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("errTbl_selectUser"), "Error!", 2);
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 5);
                singletonAdmin.dni = dni;
                singletonAdmin.ephemeralAdmin = new Admin(dni);
                pos = searchAL();
                singletonAdmin.selectedPOSmodify = pos;
                singletonAdmin.PATH_formAdm = singletonAdmin.ephemeralAdmin.getAvataring();
                singletonAdmin.ephemeralAdmin = singletonAdmin.AdminTableArray.get(selec);
                DAO_Admin.forModifyAdmin();
                valid = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("error_emptyList"), LanguageAdm.getInstance().getProperty("error"), 2);
        }
        return valid;
    }

    /*
    Search for an Admin on singleton array list and draws it
     */
    public static void BLL_ViewAdm() {
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Admin) main_Admin.TABLA.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Admin.TABLA.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("errTbl_selectUser"), LanguageAdm.getInstance().getProperty("error"), 2);
                main_Admin.btn_viewAdmin.requestFocus();
                return;
            } else {
                selec += (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
                dni = (String) main_Admin.TABLA.getModel().getValueAt(selec, 5);
                Admin adm = new Admin(dni);
                singletonAdmin.ephemeralAdmin = adm;
                pos = searchAL();
                if (pos != -1) {
                    singletonAdmin.ephemeralAdmin = singletonAdmin.AdminTableArray.get(pos);
                    DAO_Admin.formViewAdmin();
                } else {
                    DAO_Admin.DAO_ERR_View();
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageAdm.getInstance().getProperty("error_emptyList"), LanguageAdm.getInstance().getProperty("error"), 2);
        }
    }

    /**
     * Creates an Admin when btn create of the form is click and saves it on
     * JSON file
     *
     * @throws InterruptedException
     */
    public static void FORM_BTN_createAdmin() throws InterruptedException {
        boolean visible = true;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {
                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };
        if (DAO_Admin.formCreateAdmin()) {
            if (createAdmAL()) {

                main_Admin.lblMainform.setOpaque(true);
                main_Admin.lblMainform.setBackground(Color.green);
                main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("OK"));
                visible = false;

                //pager
            } else {
                main_Admin.lblMainform.setOpaque(true);
                main_Admin.lblMainform.setBackground(Color.red);
                main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("error"));
                visible = true;
            }
        } else {
            main_Admin.lblMainform.setOpaque(true);
            main_Admin.lblMainform.setBackground(Color.red);;
        }
        if (!visible) {
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(2000);
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**FORM_BTN_modifyAdm
     * Modify an admin and overwrite-it on the ArrayList, save changes on DB,
     * draws it and returns
     */
    public static void FORM_BTN_modifyAdm() throws InterruptedException {      
        main_Admin.lblMainform.setToolTipText("");
        boolean valid = false;
        int pos, selec;
        Admin adm = new Admin();

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {
                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };

        if (DAO_Admin.askDNI()) {
            singletonAdmin.ephemeralAdmin = new Admin(main_Admin.txtf_formAdm_dni.getText());
            pos = searchAL();
            if (pos != -1) {
                if (DAO_Admin.formCreateAdmin()) {
                    BLL_DB_Admin.BLL_DB_modifyAdmin();
                    Controler_mainAdmin.runTABLE();
                    //singletonAdmin.AdminTableArray.set(pos, singletonAdmin.ephemeralAdmin);
                    valid = true;
                }
            } else if (DAO_Admin.formCreateAdmin()) { //ephemeralAdmin is created with form data
                BLL_DB_Admin.BLL_DB_newAdmin();
                singletonAdmin.AdminTableArray.set(singletonAdmin.selectedPOSmodify, singletonAdmin.ephemeralAdmin);//POSmodify taken from original 
                valid = true;
                
            }
        }else {
            DAO_Admin.DAO_ERR_Modify();

        }

        if (valid) {
            //autosaveMultiformat();
            //Guardar en base de datos
            BLL_DB_Admin.BLL_DB_modifyAdmin();
            
            //Recargar de base de datos
            Controler_mainAdmin.runTABLE();
            main_Admin.lblMainform.setOpaque(true);
            main_Admin.lblMainform.setBackground(Color.GREEN);
            main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("OK_modify"));
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(3000);
            timer.setRepeats(false);
            timer.start();
        }
    }
        /**
         * Function that create an user object in his AdminTableArray Array list
         *
         * @param int
         */
    public static boolean createAdmAL() {
        
        String dni = "";
        int pos = 0;
        boolean valid = false;

        pos = searchAL();
        if (pos == -1) {
            singletonAdmin.AdminTableArray.add(singletonAdmin.ephemeralAdmin);
            //autosaveMultiformat();
            BLL_DB_Admin.BLL_DB_newAdmin();
            //Recargar de base de datos
            Controler_mainAdmin.runTABLE();
            valid = true;
        } else {
            main_Admin.lbl_formAdm_dniERR.setText(LanguageAdm.getInstance().getProperty("errVal_dni"));
            main_Admin.JPF_fromAdm_pass.setToolTipText(LanguageAdm.getInstance().getProperty("mes_dniAlreadyExist"));
            main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
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
        if (singletonAdmin.AdminTableArray != null) {
            for (int i = 0; i < singletonAdmin.AdminTableArray.size(); i++) {
                if (singletonAdmin.AdminTableArray.get(i).getDni().toUpperCase().equals(singletonAdmin.ephemeralAdmin.getDni().toUpperCase())) {//search by dni
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
    /*public static int searchALcombo() {
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
    */
    /**
     * Initialite array list Admin and loads it from JSON file
     */
    public static void loadArray() {
        singletonAdmin.loadSingletonAdmin();
        BLL_DB_Admin.BLL_DB_listAdmin();
        //json.AdminJson_Autoload();
    }
    public static void autosaveMultiformat(){ 
        //BLL_DB_Admin.
        json.AdminJson_Autosave();
        xml.AdminXml_Autosave();
        txt.AdminTxt_Autosave();
    }
}
