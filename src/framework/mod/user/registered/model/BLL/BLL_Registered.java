/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.BLL;

import framework.mod.user.admin.model.BLL.BLL_Admin;
import framework.mod.user.registered.model.DAO.DAO_Registered;
import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.miniSimpleTableModelReg;
import framework.mod.user.registered.model.classes.singletonReg;
import framework.mod.user.registered.model.tools.LanguageReg;
import framework.mod.user.registered.model.tools.jsonReg;
import framework.mod.user.registered.model.tools.pager.paginaReg;
import framework.mod.user.registered.model.tools.xmlReg;
import framework.mod.user.registered.view.main_Reg;
import static framework.mod.user.registered.view.main_Reg.CB_tbl_entries;
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
public class BLL_Registered {
    
    public static void BLL_FR_mainBack() {
        DAO_Registered.DAO_FR_mainBack();
    }

    public static void BLL_FR_HideNewFormPanel() {
        DAO_Registered.DAO_FR_hideFormPanel();
    }

    public static void BLL_FR_formCreate(){
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            try {
                BLL_Registered.FORM_BTN_createRegistered();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Reg.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (singletonReg.currentRegForm.equals(singletonReg.MODIFY_REG)) {
            try {
                BLL_Registered.FORM_BTN_modifyReg();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Reg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void BLL_FR_CleanName() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfName();
        } else {
            main_Reg.txtf_formReg_name.selectAll();
        }
    }

    public static void BLL_FR_CleanLastName() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfLastName();
        } else {
            main_Reg.txtf_formReg_lastname.selectAll();
        }
    }

    public static void BLL_FR_CleanUserName() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfUserName();
        } else {
            main_Reg.txtf_formReg_username.selectAll();
        }
    }

    public static void BLL_FR_CleanPhone() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfPhone();
        } else {
            main_Reg.txtf_formReg_phone.selectAll();
        }
    }

    public static void BLL_FR_CleanEmail() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfEmail();
        } else {
            main_Reg.txtf_formReg_email.selectAll();
        }
    }

    public static void BLL_FR_CleanDNI() {
        if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfDNI();
        } else {
            main_Reg.txtf_formReg_dni.selectAll();
        }
    }

    public static void BLL_FR_CleanPass() {
        if (singletonReg.currentRegForm.equals(singletonReg.MODIFY_REG)) {
            if (!singletonReg.passRegModf) {
                DAO_Registered.DAO_cfPass();
                singletonReg.passRegModf = true;
            } else {
                main_Reg.JPF_fromReg_pass.selectAll();
            }
        } else if (singletonReg.currentRegForm.equals(singletonReg.CREATE_REG)) {
            DAO_Registered.DAO_cfPass();
        }
    }

    public static void BLL_TBL_Previous(){
        paginaReg.currentPageIndex -= 1;
        paginaReg.initLinkBox();
    }
    
    public static void BLL_TBL_Next(){
        paginaReg.currentPageIndex += 1;
        paginaReg.initLinkBox();
    }
    
    public static void BLL_TBL_First(){
        paginaReg.currentPageIndex = 1;
        paginaReg.initLinkBox();
    }
    
    public static void BLL_TBL_Last(){
        paginaReg.currentPageIndex = paginaReg.maxPageIndex;
        paginaReg.initLinkBox();
    }
    
    public static void BLL_TBL_CB_entries(){
        paginaReg.itemsPerPage = Integer.parseInt(CB_tbl_entries.getSelectedItem().toString());
        paginaReg.currentPageIndex = 1;
        paginaReg.initLinkBox();
    }
    
    public static void BLL_TBL_combo(){
        paginaReg.currentPageIndex = 1;
        ((miniSimpleTableModelReg) main_Reg.TABLA_REG.getModel()).filtrar();
        main_Reg.comboReg.requestFocus();
    }
    
    public static void BLL_txtName() {
        DAO_Registered.askName();
    }

    public static void BLL_txtLastname() {
        DAO_Registered.askLastname();
    }

    public static void BLL_txtUsername() {
        DAO_Registered.askUsername();

    }

    public static void BLL_txtPhone() {
        DAO_Registered.askPhone();

    }

    public static void BLL_JPF_Password() {

        DAO_Registered.askPassword();

    }

    public static void BLL_JPF_PassConfirm() {

        DAO_Registered.askConfirmPassword();
    }

    public static void BLL_txtEmail() {
        DAO_Registered.askEmail();
    }

    public static void BLL_txtDNI() {
        DAO_Registered.askDNI();

    }

    public static void BLL_Activity() {
        DAO_Registered.askActivity();

    }

    public static void BLL_DCBornDate() {
        DAO_Registered.askBorndate();

    }

    public static void BLL_Avatar() {
        DAO_Registered.askAvatar();
    }

    /**
     * FILE SAVE BLL FUNCTIONS
     */
    public static void BLL_UserSaveXML() {
        xmlReg.RegUXml_save();
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
            main_Reg.PNL_drawForm.setVisible(BLL_Admin.BLL_ModifyAdm());
        } else if ((evt.getModifiers() == InputEvent.BUTTON1_MASK)) {
            BLL_ViewReg();
            main_Reg.PNL_drawForm.setVisible(true);
        }
    }

    
    /**
     * C-R-U-D functions
     */
    /**
     *
     */
    public static void BLL_CreateReg() {
        singletonReg.currentRegForm = singletonReg.CREATE_REG;
        DAO_Registered.formNew();
    }

    /**
     * Deletes an Admin selected on the table and saves changes on JSON file
     *
     * @return
     */
    public static boolean BLL_DeleteReg() {
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

        int n = ((miniSimpleTableModelReg) main_Reg.TABLA_REG.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Reg.TABLA_REG.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("errorTBL_selectUser"), LanguageReg.getInstance().getProperty("error"), 2);
                
            } else {
                selec += (paginaReg.currentPageIndex - 1) * paginaReg.itemsPerPage;
                dni = (String) main_Reg.TABLA_REG.getModel().getValueAt(selec, 4);
                name = (String) main_Reg.TABLA_REG.getModel().getValueAt(selec, 0);
                lastname = (String) main_Reg.TABLA_REG.getModel().getValueAt(selec, 1);
                RegisteredU regu = new RegisteredU(dni);
                singletonReg.ephemeralReg = regu;
                pos = searchAL();
                int opc = JOptionPane.showConfirmDialog(null, LanguageReg.getInstance().getProperty("mes_askDelet_I") + lastname + ", " + name + LanguageReg.getInstance().getProperty("mes_askDelet_II") + dni, LanguageReg.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModelReg) main_Reg.TABLA_REG.getModel()).removeRow(selec);
                    regu = singletonReg.RegTableArray.get(pos);
                    singletonReg.RegTableArray.remove(regu);
                    miniSimpleTableModelReg.datosauxReg.remove(regu);
                    Controler_mainAdmin.runTABLE();
                    jsonReg.AdminJson_Autosave();
                    main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("mes_delok"));
                    main_Reg.lblMainform.setOpaque(true);
                    main_Reg.lblMainform.setBackground(Color.red);
                    Timer timer = new Timer(4000, task);
                    timer.setInitialDelay(2000);
                    timer.setRepeats(false);
                    timer.start();

                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("error_emptyList"), LanguageReg.getInstance().getProperty("error"), 2);
        }
        return false;
    }

    public static boolean BLL_DeleteAllRegistered() {
        int pos = 0;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Reg.PNL_drawForm.isVisible()) {
                    main_Reg.PNL_drawForm.setVisible(false);
                }
            }

        };

        int opc = JOptionPane.showConfirmDialog(null, LanguageReg.getInstance().getProperty("askDelet"), LanguageReg.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            singletonReg.RegTableArray = new ArrayList<>();
            Controler_mainAdmin.runTABLE();
            json.AdminJson_Autosave();
            main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("mes_DeletAll"));
            main_Reg.lblMainform.setBackground(Color.red);
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
    public static boolean BLL_ModifyReg() {
        singletonReg.currentRegForm = singletonReg.MODIFY_REG;
        singletonReg.passRegModf = false;
        int selec = -1, pos = 0;
        String dni;
        boolean valid = false;

        int n = ((miniSimpleTableModelReg) main_Reg.TABLA_REG.getModel()).getRowCount();
        if (n != 0) {
            selec = main_Reg.TABLA_REG.getSelectedRow();

            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("errorTBL_selectUser"), "Error!", 2);
            } else {
                selec += (paginaReg.currentPageIndex - 1) * paginaReg.itemsPerPage;
                dni = (String) main_Reg.TABLA_REG.getModel().getValueAt(selec, 4);
                singletonReg.dniReg = dni;
                singletonReg.ephemeralReg = new RegisteredU(dni);
                pos = searchAL();
                singletonReg.selectedPOSmodifyReg = pos;
                singletonReg.PATH_formReg = singletonReg.ephemeralReg.getAvataring();
                singletonReg.ephemeralReg = singletonReg.RegTableArray.get(selec);
                DAO_Registered.forModifyReg();
                valid = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("error_emptyList"), LanguageReg.getInstance().getProperty("error"), 2);
        }
        return valid;
    }

    /*
    Search for an Admin on singleton array list and draws it
     */
    public static void BLL_ViewReg() {
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModelReg) main_Reg.TABLA_REG.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Reg.TABLA_REG.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("error_emptyList"), LanguageReg.getInstance().getProperty("error"), 2);
                main_Reg.btn_viewReg.requestFocus();
                return;
            } else {
                selec += (paginaReg.currentPageIndex - 1) * paginaReg.itemsPerPage;
                dni = (String) main_Reg.TABLA_REG.getModel().getValueAt(selec, 4);
                RegisteredU regu = new RegisteredU(dni);
                singletonReg.ephemeralReg = regu;
                pos = searchAL();
                if (pos != -1) {
                    singletonReg.ephemeralReg = singletonReg.RegTableArray.get(pos);
                    DAO_Registered.formViewReg();
                } else {
                    DAO_Registered.DAO_ERR_View();
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageReg.getInstance().getProperty("error_emptyList"), LanguageReg.getInstance().getProperty("error"), 2);
        }
    }

    /**
     * Creates an Admin when btn create of the form is click and saves it on
     * JSON file
     *
     * @throws InterruptedException
     */
    public static void FORM_BTN_createRegistered() throws InterruptedException {
        boolean visible = true;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {
                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };
        if (DAO_Registered.formCreateReg()) {
            if (createRegAL()) {

                main_Reg.lblMainform.setOpaque(true);
                main_Reg.lblMainform.setBackground(Color.green);
                main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("OK"));
                visible = false;

                //pager
            } else {
                main_Reg.lblMainform.setOpaque(true);
                main_Reg.lblMainform.setBackground(Color.red);
                main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("error"));
                visible = true;
            }
        } else {
            main_Reg.lblMainform.setOpaque(true);
            main_Reg.lblMainform.setBackground(Color.red);;
        }
        if (!visible) {
            Timer timer = new Timer(1000, task);
            timer.setInitialDelay(2000);
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Modify an admin and overwrite-it on the ArrayList, save changes on Json,
     * draws it and returns
     */
    public static void FORM_BTN_modifyReg() throws InterruptedException {      
        main_Reg.lblMainform.setToolTipText("");
        boolean valid = false;
        int pos, selec;
        RegisteredU regu = new RegisteredU();

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Admin.PNL_drawForm.isVisible()) {
                    main_Admin.PNL_drawForm.setVisible(false);
                }
            }
        };

        if (DAO_Registered.askDNI()) {
            singletonReg.ephemeralReg = new RegisteredU(main_Reg.txtf_formReg_dni.getText());
            pos = searchAL();
            if (pos != -1) {
                if (DAO_Registered.formCreateReg()) {
                    singletonReg.RegTableArray.set(pos, singletonReg.ephemeralReg);
                    valid = true;
                }
            } else if (DAO_Registered.formCreateReg()) { //ephemeralAdmin is created with form data

                singletonReg.RegTableArray.set(singletonReg.selectedPOSmodifyReg, singletonReg.ephemeralReg);//POSmodify taken from original 

                if (DAO_Registered.formCreateReg()) { //ephemeralAdmin is created with form data
                    singletonReg.RegTableArray.set(singletonReg.selectedPOSmodifyReg, singletonReg.ephemeralReg);
                    valid = true;
                }
            }
        }else {
        DAO_Registered.DAO_ERR_Modify();

        }

        if (valid) {
            json.AdminJson_Autosave();
            Controler_mainAdmin.runTABLE();
            main_Reg.lblMainform.setOpaque(true);
            main_Reg.lblMainform.setBackground(Color.GREEN);
            main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("OK_modify"));
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
    public static boolean createRegAL() {
        
        String dni = "";
        int pos = 0;
        boolean valid = false;

        pos = searchAL();
        if (pos == -1) {
            singletonReg.RegTableArray.add(singletonReg.ephemeralReg);
            json.AdminJson_Autosave();
            Controler_mainAdmin.runTABLE();
            valid = true;
        } else {
            main_Reg.lbl_formReg_dniERR.setText(LanguageReg.getInstance().getProperty("errVal_dni"));
            main_Reg.JPF_fromReg_pass.setToolTipText(LanguageReg.getInstance().getProperty("mes_dniAlreadyExist"));
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
        if (singletonReg.RegTableArray != null) {
            for (int i = 0; i < singletonReg.RegTableArray.size(); i++) {
                if (singletonReg.RegTableArray.get(i).getDni().equals(singletonReg.ephemeralReg.getDni())) {//search by dni
                    pos = i;
                    i = singletonReg.RegTableArray.size();
                }
            }
        }
        return pos;
    }
    /**
     * Initialite array list Admin and loads it from JSON file
     */
    public static void loadArray() {
        singletonReg.loadSingletonReg();
        json.AdminJson_Autoload();
    }
}
