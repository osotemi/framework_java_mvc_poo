/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.BLL;

import framework.mod.user.client.controler.Controler_mainClient;
import framework.mod.user.client.model.DAO.DAO_Client;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.miniSimpleTableModel_Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.mod.user.client.model.tools.LanguageClt;
import framework.mod.user.client.model.tools.jsonClt;
import framework.mod.user.client.model.tools.pager.paginaClt;
import framework.mod.user.client.model.tools.txtClt;
import framework.mod.user.client.model.tools.xmlClt;
import framework.mod.user.client.view.main_Client;
import static framework.mod.user.client.view.main_Client.CB_tbl_entries;
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
public class BLL_Client {
    
    public static void BLL_FC_mainBack() {
        DAO_Client.DAO_FC_mainBack();
    }

    public static void BLL_FC_HideNewFormPanel() {
        DAO_Client.DAO_FC_hideFormPanel();
    }

    public static void BLL_FC_formCreate(){
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            try {
                BLL_Client.FORM_BTN_createClient();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (singletonClient.currentCltForm.equals(singletonClient.MODIFY_CLT)) {
            try {
                BLL_Client.FORM_BTN_modifyClt();
            } catch (InterruptedException ex) {
                Logger.getLogger(main_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void BLL_FC_CleanName() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfName();
        } else {
            main_Client.txtf_formClt_name.selectAll();
        }
    }

    public static void BLL_FC_CleanLastName() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfLastName();
        } else {
            main_Client.txtf_formClt_lastname.selectAll();
        }
    }

    public static void BLL_FC_CleanUserName() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfUserName();
        } else {
            main_Client.txtf_formClt_username.selectAll();
        }
    }

    public static void BLL_FC_CleanPhone() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfPhone();
        } else {
            main_Client.txtf_formClt_phone.selectAll();
        }
    }

    public static void BLL_FC_CleanEmail() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfEmail();
        } else {
            main_Client.txtf_formClt_email.selectAll();
        }
    }

    public static void BLL_FC_CleanDNI() {
        if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfDNI();
        } else {
            main_Client.txtf_formClt_dni.selectAll();
        }
        
        
        
    }

    public static void BLL_FC_CleanPass() {
        if (singletonClient.currentCltForm.equals(singletonClient.MODIFY_CLT)) {
            if (!singletonClient.passCltModf) {
                DAO_Client.DAO_cfPass();
                singletonClient.passCltModf = true;
            } else {
                main_Client.JPF_fromClt_pass.selectAll();
            }
        } else if (singletonClient.currentCltForm.equals(singletonClient.CREATE_CLT)) {
            DAO_Client.DAO_cfPass();
        }
    }

    public static void BLL_TBL_Previous(){
        paginaClt.currentPageIndex -= 1;
        paginaClt.initLinkBox();
    }
    
    public static void BLL_TBL_Next(){
        paginaClt.currentPageIndex += 1;
        paginaClt.initLinkBox();
    }
    
    public static void BLL_TBL_First(){
        paginaClt.currentPageIndex = 1;
        paginaClt.initLinkBox();
    }
    
    public static void BLL_TBL_Last(){
        paginaClt.currentPageIndex = paginaClt.maxPageIndex;
        paginaClt.initLinkBox();
    }
    
    public static void BLL_TBL_CB_entries(){
        paginaClt.itemsPerPage = Integer.parseInt(CB_tbl_entries.getSelectedItem().toString());
        paginaClt.currentPageIndex = 1;
        paginaClt.initLinkBox();
    }
    
    public static void BLL_TBL_combo(){
        paginaClt.currentPageIndex = 1;
        ((miniSimpleTableModel_Client) main_Client.TABLA_CLT.getModel()).filtrar();
        main_Client.comboClt.requestFocus();
    }
    
    public static void BLL_txtName() {
        DAO_Client.askName();
    }

    public static void BLL_txtLastname() {
        DAO_Client.askLastname();
    }

    public static void BLL_txtUsername() {
        DAO_Client.askUsername();

    }

    public static void BLL_txtPhone() {
        DAO_Client.askPhone();

    }

    public static void BLL_JPF_Password() {

        DAO_Client.askPassword();

    }

    public static void BLL_JPF_PassConfirm() {

        DAO_Client.askConfirmPassword();
    }

    public static void BLL_txtEmail() {
        DAO_Client.askEmail();
    }

    public static void BLL_txtDNI() {
        DAO_Client.askDNI();

    }

    public static void BLL_Activity() {
        DAO_Client.askAccount();

    }

    public static void BLL_DCBornDate() {
        DAO_Client.askBorndate();

    }

    public static void BLL_DCSingDate() {
        DAO_Client.askSingDate();
    }

    public static void BLL_Avatar() {
        DAO_Client.askAvatar();
    }

    
    /**
     * FILE SAVE BLL FUNCTIONS
     */
    public static void BLL_ClientSaveXML() {
        xmlClt.ClientXml_save();
    }

    public static void BLL_ClientSaveJSON() {
        jsonClt.ClientJson_Save();
    }

    public static void BLL_ClientSaveTXT() {
        txtClt.ClientTxt_Save();
    }

    /**
     * MTableMouse Clicked actions
     */
    public static void BLL_TableMouseClick(java.awt.event.MouseEvent evt) {
        boolean modificar = false;

        if (evt.getClickCount() == 2) {
            main_Client.PNL_drawForm.setVisible(BLL_Client.BLL_ModifyClt());
        } else if ((evt.getModifiers() == InputEvent.BUTTON1_MASK)) {
            BLL_ViewClt();
            main_Client.PNL_drawForm.setVisible(true);
        }
    }

    /**
     * C-R-U-D functions
     */
    /**
     *
     */
    public static void BLL_CreateClt() {
        singletonClient.currentCltForm = singletonClient.CREATE_CLT;
        DAO_Client.formNew();
    }

    /**
     * Deletes an Admin selected on the table and saves changes on JSON file
     *
     * @return
     */
    public static boolean BLL_DeleteClt() {
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Client.PNL_drawForm.isVisible()) {

                    main_Client.PNL_drawForm.setVisible(false);
                }
            }
        };
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Client) main_Client.TABLA_CLT.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Client.TABLA_CLT.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("errorTBL_selectUser"), LanguageClt.getInstance().getProperty("error"), 2);
                
            } else {
                selec += (paginaClt.currentPageIndex - 1) * paginaClt.itemsPerPage;
                dni = (String) main_Client.TABLA_CLT.getModel().getValueAt(selec, 4);
                name = (String) main_Client.TABLA_CLT.getModel().getValueAt(selec, 0);
                lastname = (String) main_Client.TABLA_CLT.getModel().getValueAt(selec, 1);
                Client clt = new Client(dni);
                singletonClient.ephemeralClient = clt;
                pos = searchAL();
                int opc = JOptionPane.showConfirmDialog(null, LanguageClt.getInstance().getProperty("mes_askDelet_I") + lastname + ", " + name + LanguageClt.getInstance().getProperty("mes_askDelet_II") + dni, LanguageClt.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_Client) main_Client.TABLA_CLT.getModel()).removeRow(selec);
                    clt = singletonClient.ClienTableArray.get(pos);
                    singletonClient.ClienTableArray.remove(clt);
                    miniSimpleTableModel_Client.datosauxClt.remove(clt);
                    Controler_mainClient.runTABLE();
                    jsonClt.ClientJson_Autosave();
                    main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("mes_delok"));
                    main_Client.lblMainform.setOpaque(true);
                    main_Client.lblMainform.setBackground(Color.red);
                    Timer timer = new Timer(4000, task);
                    timer.setInitialDelay(2000);
                    timer.setRepeats(false);
                    timer.start();

                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("error_emptyList"), LanguageClt.getInstance().getProperty("error"), 2);
        }
        return false;
    }

    public static boolean BLL_DeleteAllClt() {
        int pos = 0;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Client.PNL_drawForm.isVisible()) {
                    main_Client.PNL_drawForm.setVisible(false);
                }
            }
        };

        int opc = JOptionPane.showConfirmDialog(null, LanguageClt.getInstance().getProperty("askDelet"), LanguageClt.getInstance().getProperty("warning"), JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            singletonClient.ClienTableArray = new ArrayList<>();
            Controler_mainClient.runTABLE();
            jsonClt.ClientJson_Autosave();
            main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("mes_DeletAll"));
            main_Client.lblMainform.setBackground(Color.red);
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
    public static boolean BLL_ModifyClt() {
        singletonClient.currentCltForm = singletonClient.MODIFY_CLT;
        singletonClient.passCltModf = false;
        int selec = -1, pos = 0;
        String dni;
        boolean valid = false;

        int n = ((miniSimpleTableModel_Client) main_Client.TABLA_CLT.getModel()).getRowCount();
        if (n != 0) {
            selec = main_Client.TABLA_CLT.getSelectedRow();

            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("errorTBL_selectUser"), "Error!", 2);
            } else {
                selec += (paginaClt.currentPageIndex - 1) * paginaClt.itemsPerPage;
                dni = (String) main_Client.TABLA_CLT.getModel().getValueAt(selec, 4);
                singletonClient.dniClt = dni;
                singletonClient.ephemeralClient = new Client(dni);
                pos = searchAL();
                singletonClient.selectedPOSmodifyClt = pos;
                singletonClient.PATH_formClt = singletonClient.ephemeralClient.getAvataring();
                singletonClient.ephemeralClient= singletonClient.ClienTableArray.get(selec);
                DAO_Client.forModifyClient();
                valid = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("error_emptyList"), LanguageClt.getInstance().getProperty("error"), 2);
        }
        return valid;
    }

    /*
    Search for an Admin on singleton array list and draws it
     */
    public static void BLL_ViewClt() {
        String dni, name, lastname;
        int pos;

        int n = ((miniSimpleTableModel_Client) main_Client.TABLA_CLT.getModel()).getRowCount();
        if (n != 0) {
            int selec = main_Client.TABLA_CLT.getSelectedRow();
            if (selec == -1) {
                JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("error_emptyList"), LanguageClt.getInstance().getProperty("error"), 2);
                main_Client.btn_viewClient.requestFocus();
                return;
            } else {
                selec += (paginaClt.currentPageIndex - 1) * paginaClt.itemsPerPage;
                dni = (String) main_Client.TABLA_CLT.getModel().getValueAt(selec, 4);
                Client clt = new Client(dni);
                singletonClient.ephemeralClient = clt;
                pos = searchAL();
                if (pos != -1) {
                    singletonClient.ephemeralClient = singletonClient.ClienTableArray.get(pos);
                    DAO_Client.formViewClient();
                } else {
                    DAO_Client.DAO_ERR_View();
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, LanguageClt.getInstance().getProperty("error_emptyList"), LanguageClt.getInstance().getProperty("error"), 2);
        }
    }

    /**
     * Creates an Client when btn create of the form is click and saves it on
     * JSON file
     *
     * @throws InterruptedException
     */
    public static void FORM_BTN_createClient() throws InterruptedException {
        boolean visible = true;
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Client.PNL_drawForm.isVisible()) {
                    main_Client.PNL_drawForm.setVisible(false);
                }
            }
        };
        if (DAO_Client.formCreateClient()) {
            if (createAdmAL()) {

                main_Client.lblMainform.setOpaque(true);
                main_Client.lblMainform.setBackground(Color.green);
                main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("OK"));
                visible = false;

                //pager
            } else {
                main_Client.lblMainform.setOpaque(true);
                main_Client.lblMainform.setBackground(Color.red);
                main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("error"));
                visible = true;
            }
        } else {
            main_Client.lblMainform.setOpaque(true);
            main_Client.lblMainform.setBackground(Color.red);;
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
    public static void FORM_BTN_modifyClt() throws InterruptedException {      
        main_Client.lblMainform.setToolTipText("");
        boolean valid = false;
        int pos, selec;
        Client clt = new Client();

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main_Client.PNL_drawForm.isVisible()) {
                    main_Client.PNL_drawForm.setVisible(false);
                }
            }
        };

        if (DAO_Client.askDNI()) {
            singletonClient.ephemeralClient = new Client(main_Client.txtf_formClt_dni.getText());
            pos = searchAL();
            if (pos != -1) {
                if (DAO_Client.formCreateClient()) {
                    singletonClient.ClienTableArray.set(pos, singletonClient.ephemeralClient);
                    valid = true;
                }
            } else if (DAO_Client.formCreateClient()) { //ephemeralAdmin is created with form data

                singletonClient.ClienTableArray.set(singletonClient.selectedPOSmodifyClt, singletonClient.ephemeralClient);//POSmodify taken from original 

                if (DAO_Client.formCreateClient()) { //ephemeralAdmin is created with form data
                    singletonClient.ClienTableArray.set(singletonClient.selectedPOSmodifyClt, singletonClient.ephemeralClient);
                    valid = true;
                }
            }
        }else {
        DAO_Client.DAO_ERR_Modify();

        }

        if (valid) {
            jsonClt.ClientJson_Autosave();
            Controler_mainClient.runTABLE();
            main_Client.lblMainform.setOpaque(true);
            main_Client.lblMainform.setBackground(Color.GREEN);
            main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("OK_modify"));
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
            singletonClient.ClienTableArray.add(singletonClient.ephemeralClient);
            jsonClt.ClientJson_Autosave();
            Controler_mainClient.runTABLE();
            valid = true;
        } else {
            main_Client.lbl_formClt_dniERR.setText(LanguageClt.getInstance().getProperty("errVal_dni"));
            main_Client.JPF_fromClt_pass.setToolTipText(LanguageClt.getInstance().getProperty("mes_dniAlreadyExist"));
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
        if (singletonClient.ClienTableArray != null) {
            for (int i = 0; i < singletonClient.ClienTableArray.size(); i++) {
                if (singletonClient.ClienTableArray.get(i).getDni().equals(singletonClient.ephemeralClient.getDni())) {//search by dni
                    pos = i;
                    i = singletonClient.ClienTableArray.size();
                }
            }
        }
        return pos;
    }
    
    public static void loadArray() {
        singletonClient.loadSingletonClient();
        jsonClt.ClientJson_Autoload();
    }
}
