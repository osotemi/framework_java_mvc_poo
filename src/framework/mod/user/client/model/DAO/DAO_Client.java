/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.DAO;

import framework.clss.DateO;
import framework.mod.settings.controler.Controler_Main;
import framework.mod.settings.view.main_login;
import static framework.mod.user.client.controler.Controler_mainClient.MainClient;
import framework.mod.user.client.model.BLL.BLL_DB_Client;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.mod.user.client.model.tools.LanguageClt;
import framework.mod.user.client.model.tools.dummieClt_gen;
import framework.mod.user.client.view.main_Client;
import framework.tools.format;
import framework.tools.imageSaver;
import framework.tools.validate;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author osotemi
 */
public class DAO_Client {
       
    /**
     * Creates an Admin checking for all the fields are OK; saves in on singleton.ephimeralAdmin and returns true when done
     * If the fields are not ok, shows an error and returns false
     * @return
     */
    public static boolean formCreateClient() {
        Client clt = new Client();
        DateO born = new DateO();
        DateO sing = new DateO();
        String error = "";
        boolean valid = false;
        boolean chkName = askName(), chkLastname = askLastname(), chkUsername = askUsername(), chkPhone = askPhone(), chkConfPass = askConfirmPassword(), chkDNI = askDNI(), chkEmail = askEmail(), chkActivity = askAccount(), chkBorndate = askBorndate(), chkSingdate = askSingDate(), chkAvatar = true;
        try {
            if(singletonClient.PATH_formClt.equals(""))
            singletonClient.PATH_formClt = singletonClient.ephemeralClient.getAvataring();

        } catch (Exception e) {
            singletonClient.PATH_formClt = dummieClt_gen.rdmAvatar();
        }
        
        if (chkName && chkLastname && chkUsername && chkPhone && chkConfPass && chkDNI && chkEmail && chkActivity && chkBorndate && chkSingdate && chkAvatar) {
            born = new DateO(main_Client.DC_formClt_borndate.getCalendar());
            sing = new DateO(main_Client.DC_formClt_singdate.getCalendar());
            clt = new Client(singletonClient.PATH_formClt, born, main_Client.txtf_formClt_dni.getText(), main_Client.txtf_formClt_email.getText(),
                    main_Client.txtf_formClt_phone.getText(), main_Client.txtf_formClt_name.getText(), main_Client.txtf_formClt_lastname.getText(), 
                    singletonClient.passwd_formClt, ((String) main_Client.CB_formClt_state.getSelectedItem()), main_Client.txtf_formClt_username.getText(), 
                    ((String) main_Client.CB_formCLT_type.getSelectedItem()), main_Client.JCK_form_premium.isSelected(), sing, Float.parseFloat(main_Client.txt_formClt_shopAccount.getText()));
            singletonClient.ephemeralClient = clt;
            valid = true;
        }
        else{
            error = LanguageClt.getInstance().getProperty("err_createAdm") + "\n";
            
            if(chkActivity){
                error+= "-Error actividad\n";
            }
            if(chkAvatar){
                error+= "-Error avatar\n";
            }
            if(chkBorndate){
                error+= "-Error en la fecha de nacimento\n";
            }
            if(chkConfPass){
                error+= "-Error en la confirmaciÛn de la contraseÒo\n";
            }
            if(chkDNI){
                error+= "-Error en el dni\n";
            }
            if(chkEmail){
                error+= "-Error en el email\n";
            }
            if(chkLastname){
                error+=  "-Error en los apellidos\n";
            }
            if(chkName){
                error+=  "-Error en el nombre\n";
            }
            if(chkPhone){
                error+=  "-Error en el telÈfono\n";
            }
            if(chkSingdate){
                error+= "-Error en la fecha de contrataciÛn\n";
            }
            if(chkUsername){
                error+= "-Error en el nombre de usuario\n";
            }
            main_Client.lblMainform.setToolTipText(error);
            main_Client.lblMainform.setOpaque(true);
            main_Client.lblMainform.setBackground(Color.red);
            main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("error"));
        }
        return valid;
    }
    
    
    public static void formNew() {
        main_Client.lbl_form_shopAccount.setText(LanguageClt.getInstance().getProperty("DRW_lblShopAccount"));
        main_Client.txt_formClt_shopAccount.setEnabled(true);
        main_Client.txt_formClt_shopAccount.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txt_formClt_shopAccount.setBackground( Color.white);
        main_Client.txt_formClt_shopAccount.setBorder(null);
        main_Client.txt_formClt_shopAccount.setText("0");
        main_Client.lbl_formClt_shopAccountERR.setText(" ");

        main_Client.btn_formClt_Avatar.setEnabled(true);
        main_Client.lbl_formClt_photoavatar.setText("");
        
        main_Client.DC_formClt_borndate.setDate(null);
        main_Client.lbl_formClt_borndateERR.setText(" ");
        
        main_Client.txtf_formClt_dni.setEnabled(true);
        main_Client.txtf_formClt_dni.setBackground( Color.white);
        main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_dni.setText(LanguageClt.getInstance().getProperty("new_dni"));
        main_Client.txtf_formClt_dni.setBorder(null);
        main_Client.lbl_formClt_dniERR.setText(" ");

        main_Client.txtf_formClt_email.setEnabled(true);
        main_Client.txtf_formClt_email.setBackground( Color.white);
        main_Client.txtf_formClt_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_email.setText(LanguageClt.getInstance().getProperty("new_email"));
        main_Client.txtf_formClt_email.setBorder(null);
        main_Client.lbl_formClt_emailERR.setText(" ");

        main_Client.txtf_formClt_lastname.setEnabled(true);
        main_Client.txtf_formClt_lastname.setBackground( Color.white);
        main_Client.txtf_formClt_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_lastname.setText(LanguageClt.getInstance().getProperty("new_lastName"));
        main_Client.txtf_formClt_lastname.setBorder(null);
        main_Client.lbl_formClt_lastnameERR.setText(" ");

        
        main_Client.lblMainform.setBackground( Color.white);
        main_Client.lblMainform.setOpaque(false);
        main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("new_titleCreate"));
        main_Client.lblMainform.setToolTipText("");
        main_Client.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        
        main_Client.txtf_formClt_name.setEnabled(true);
        main_Client.txtf_formClt_name.setBackground( Color.white);
        main_Client.txtf_formClt_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_name.setText(LanguageClt.getInstance().getProperty("new_name"));
        main_Client.txtf_formClt_name.setBorder(null);
        main_Client.lbl_formClt_nameERR.setText(" ");

        main_Client.JPF_fromClt_pass.setEnabled(true);
        main_Client.JPF_fromClt_pass.setBackground( Color.white);
        main_Client.JPF_fromClt_pass.setText("");
        main_Client.JPF_fromClt_pass.setBorder(null);
        main_Client.JPF_fromClt_pass.setEchoChar('*');
        main_Client.lbl_formClt_passERR.setText(" ");

        main_Client.JPF_fromClt_passconf.setEnabled(true);
        main_Client.JPF_fromClt_passconf.setBackground( Color.white);
        main_Client.JPF_fromClt_passconf.setText("");
        main_Client.JPF_fromClt_passconf.setBorder(null);
        main_Client.JPF_fromClt_passconf.setEchoChar('*');
        main_Client.lbl_formClt_passconfERR.setText(" ");

        main_Client.txtf_formClt_phone.setEnabled(true);
        main_Client.txtf_formClt_phone.setBackground( Color.white);
        main_Client.txtf_formClt_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_phone.setText(LanguageClt.getInstance().getProperty("new_phone"));
        main_Client.txtf_formClt_phone.setBorder(null);
        main_Client.lbl_formClt_phoneERR.setText(" ");

        main_Client.lbl_formClt_photoavatar.setIcon(null);

        main_Client.DC_formClt_singdate.setDate(null);
        main_Client.lbl_formClt_singdateERR.setText(" ");

        main_Client.txtf_formClt_username.setEnabled(true);
        main_Client.txtf_formClt_username.setBackground( Color.white);
        main_Client.txtf_formClt_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_username.setText(LanguageClt.getInstance().getProperty("new_userName"));
        main_Client.txtf_formClt_username.setBorder(null);
        main_Client.lbl_formClt_lusernameERR.setText(" ");

        main_Client.btn_formCltCreate_back.setBackground( Color.lightGray);
        main_Client.btn_formCltCreate_back.setVisible(true);
        main_Client.btn_formCltCreate_back.setText(LanguageClt.getInstance().getProperty("DRW_btnBack"));
        main_Client.btn_formCltCreate_create.setBackground( Color.lightGray);
        main_Client.btn_formCltCreate_create.setVisible(true);
        main_Client.btn_formCltCreate_create.setText(LanguageClt.getInstance().getProperty("new_BTMcreate"));
        
        main_Client.CB_formCLT_type.setSelectedIndex(0);
        
        main_Client.JCK_form_premium.setSelected(false);
        
        main_Client.lbl_form_shopAccount.setText("");
        main_Client.lbl_form_benefit.setText("");
        
        main_Client.PNL_drawForm.setBackground(Color.lightGray);
        main_Client.PNL_drawForm.setVisible(true);
        main_Client.txtf_formClt_username.requestFocus();
        main_Client.txtf_formClt_username.selectAll();
    }

    public static void forModifyClient() {
        main_Client.lbl_form_shopAccount.setText(LanguageClt.getInstance().getProperty("DRW_lblShopAccount"));
        main_Client.txt_formClt_shopAccount.setText(""+singletonClient.ephemeralClient.getShop_acount());
        main_Client.txt_formClt_shopAccount.setBorder(null);
        main_Client.txt_formClt_shopAccount.setBackground(Color.white);
        main_Client.txt_formClt_shopAccount.setEnabled(true);
        main_Client.txt_formClt_shopAccount.setToolTipText("");
        main_Client.lbl_formClt_shopAccountERR.setText("");

        main_Client.btn_formClt_Avatar.setEnabled(true);
        main_Client.btn_formClt_Avatar.setVisible(true);
        try {
            main_Client.lbl_formClt_photoavatar.setIcon(new ImageIcon(singletonClient.ephemeralClient.getAvataring()));
        } catch (Exception e) {
            main_Client.btn_formClt_Avatar.setToolTipText("Imposible cargar im·gen");//err_avatar
        }
        
        main_Client.DC_formClt_borndate.setCalendar(singletonClient.ephemeralClient.getBorn_date().toCalendar());
        main_Client.lbl_formClt_borndateERR.setToolTipText("");
        main_Client.lbl_formClt_borndateERR.setText("");
        
        main_Client.btn_formCltCreate_create.setText(LanguageClt.getInstance().getProperty("new_BTMmodify"));
        
        main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_dni.setText(singletonClient.ephemeralClient.getDni());
        main_Client.txtf_formClt_dni.setBorder(null);
        main_Client.txtf_formClt_dni.setToolTipText("");
        main_Client.txtf_formClt_dni.setEnabled(true);
        main_Client.txtf_formClt_dni.setBackground(Color.white);
        main_Client.lbl_formClt_dniERR.setText(" ");
        
        main_Client.txtf_formClt_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_email.setText(singletonClient.ephemeralClient.getEmail());
        main_Client.txtf_formClt_email.setBorder(null);
        main_Client.txtf_formClt_email.setToolTipText("");
        main_Client.txtf_formClt_email.setEnabled(true);
        main_Client.txtf_formClt_email.setBackground(Color.white);
        main_Client.lbl_formClt_emailERR.setText("");

        main_Client.CB_formClt_state.setSelectedItem(singletonClient.ephemeralClient.getState());
        
        main_Client.txtf_formClt_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_lastname.setText(singletonClient.ephemeralClient.getLastname());
        main_Client.txtf_formClt_lastname.setBorder(null);
        main_Client.txtf_formClt_lastname.setToolTipText("");
        main_Client.txtf_formClt_lastname.setEnabled(true);
        main_Client.txtf_formClt_lastname.setBackground(Color.white);
        main_Client.lbl_formClt_lastnameERR.setText(" ");

        main_Client.lblMainform.setOpaque(false);
        main_Client.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("new_titleModify"));
        main_Client.lblMainform.setToolTipText("");

        main_Client.txtf_formClt_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_name.setText(singletonClient.ephemeralClient.getName());
        main_Client.txtf_formClt_name.setBorder(null);
        main_Client.txtf_formClt_name.setToolTipText("");
        main_Client.txtf_formClt_name.setEnabled(true);
        main_Client.txtf_formClt_name.setBackground(Color.white);
        main_Client.lbl_formClt_nameERR.setText(" ");

        main_Client.JPF_fromClt_pass.setText(singletonClient.ephemeralClient.getPassword());
        main_Client.JPF_fromClt_pass.setBorder(null);
        main_Client.JPF_fromClt_pass.setEnabled(true);
        main_Client.JPF_fromClt_pass.setToolTipText("");
        main_Client.JPF_fromClt_pass.setBackground(Color.white);
        main_Client.JPF_fromClt_pass.setEchoChar((char) 0);
        main_Client.lbl_formClt_passERR.setText(" ");

        main_Client.JPF_fromClt_passconf.setText(singletonClient.ephemeralClient.getPassword());
        main_Client.JPF_fromClt_passconf.setBorder(null);
        main_Client.JPF_fromClt_passconf.setEnabled(true);
        main_Client.JPF_fromClt_passconf.setToolTipText("");
        main_Client.JPF_fromClt_passconf.setBackground(Color.white);
        main_Client.JPF_fromClt_passconf.setEchoChar((char) 0);
        main_Client.lbl_formClt_passconfERR.setText(" ");

        main_Client.txtf_formClt_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_phone.setText(singletonClient.ephemeralClient.getMovile());
        main_Client.txtf_formClt_phone.setBorder(null);
        main_Client.txtf_formClt_phone.setEnabled(true);
        main_Client.txtf_formClt_phone.setBackground(Color.white);
        main_Client.txtf_formClt_phone.setToolTipText("");
        main_Client.lbl_formClt_phoneERR.setText(" ");

        main_Client.DC_formClt_singdate.setCalendar(singletonClient.ephemeralClient.getRegister_date().toCalendar());
        main_Client.lbl_formClt_singdateERR.setText(" ");

        main_Client.CB_formClt_state.setSelectedItem(singletonClient.ephemeralClient.getState());
        
        main_Client.txtf_formClt_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Client.txtf_formClt_username.setText(singletonClient.ephemeralClient.getUser());
        main_Client.txtf_formClt_username.setBorder(null);
        main_Client.txtf_formClt_username.setEnabled(true);
        main_Client.txtf_formClt_username.setToolTipText("");
        main_Client.txtf_formClt_username.setBackground(Color.white);
        main_Client.lbl_formClt_lusernameERR.setText(" ");
        
        main_Client.lbl_form_benefit.setText("");
        
        main_Client.btn_formCltCreate_back.setBackground( Color.lightGray);
        main_Client.btn_formCltCreate_back.setVisible(true);
        main_Client.btn_formCltCreate_back.setEnabled(true);
        main_Client.btn_formCltCreate_back.setText(LanguageClt.getInstance().getProperty("DRW_btnBack"));
        main_Client.btn_formCltCreate_create.setEnabled(true);
        main_Client.btn_formCltCreate_create.setVisible(true);
        main_Client.btn_formCltCreate_create.setText(LanguageClt.getInstance().getProperty("new_BTMmodify"));
        main_Client.PNL_drawForm.setBackground(null);
        main_Client.PNL_drawForm.setVisible(true);
        main_Client.txtf_formClt_username.requestFocus();
        main_Client.txtf_formClt_username.selectAll();
    }

    /**
     * Draw the View Admin form
     */
    public static void formViewClient() {
        main_Client.lbl_form_shopAccount.setText(LanguageClt.getInstance().getProperty("DRW_lblShopAccount"));
        main_Client.txt_formClt_shopAccount.setEnabled(false);
        main_Client.txt_formClt_shopAccount.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txt_formClt_shopAccount.setBackground( new Color(0,0,0,0));
        main_Client.txt_formClt_shopAccount.setText(format.formMoneyOut(singletonClient.ephemeralClient.getShop_acount()));
        main_Client.txt_formClt_shopAccount.setToolTipText("");
        main_Client.txt_formClt_shopAccount.setBorder(null);

        try {
            main_Client.lbl_formClt_photoavatar.setIcon(new ImageIcon(singletonClient.ephemeralClient.getAvataring()));
        } catch (Exception e) {
            main_Client.btn_formClt_Avatar.setToolTipText("Imposible cargar im·gen");
        }
        
        main_Client.DC_formClt_borndate.setCalendar(singletonClient.ephemeralClient.getBorn_date().toCalendar());
        main_Client.lbl_formClt_borndateERR.setText("");
        main_Client.lbl_formClt_borndateERR.setToolTipText("");
        
        
        main_Client.txtf_formClt_dni.setEnabled(false);
        main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txtf_formClt_dni.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_dni.setText(singletonClient.ephemeralClient.getDni());
        main_Client.txtf_formClt_dni.setBorder(null);
        main_Client.txtf_formClt_dni.setToolTipText("");
        main_Client.lbl_formClt_dniERR.setText(" ");
        
        main_Client.txtf_formClt_email.setEnabled(false);
        main_Client.txtf_formClt_email.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txtf_formClt_email.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_email.setText(singletonClient.ephemeralClient.getEmail());
        main_Client.txtf_formClt_email.setBorder(null);
        main_Client.txtf_formClt_email.setToolTipText("");
        main_Client.lbl_formClt_emailERR.setText(" ");

        main_Client.txtf_formClt_lastname.setEnabled(false);
        main_Client.txtf_formClt_lastname.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txtf_formClt_lastname.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_lastname.setText(singletonClient.ephemeralClient.getLastname());
        main_Client.txtf_formClt_lastname.setBorder(null);
        main_Client.txtf_formClt_lastname.setToolTipText("");
        main_Client.lbl_formClt_lastnameERR.setText(" ");

        main_Client.lblMainform.setOpaque(false);
        main_Client.lblMainform.setText("Ficha");
        main_Client.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 14));
        main_Client.lblMainform.setToolTipText("");

        main_Client.txtf_formClt_name.setEnabled(false);
        main_Client.txtf_formClt_name.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txtf_formClt_name.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_name.setText(singletonClient.ephemeralClient.getName());
        main_Client.txtf_formClt_name.setBorder(null);
        main_Client.txtf_formClt_name.setToolTipText("");
        main_Client.lbl_formClt_nameERR.setText(" ");

        main_Client.JPF_fromClt_pass.setBackground( new Color(0,0,0,0));
        main_Client.JPF_fromClt_pass.setText(singletonClient.ephemeralClient.getPassword());
        main_Client.JPF_fromClt_pass.setBorder(null);
        main_Client.JPF_fromClt_pass.setToolTipText("");
        main_Client.JPF_fromClt_pass.setEchoChar('*');
        main_Client.lbl_formClt_passERR.setText(" ");
        main_Client.lbl_formClt_passERR.setToolTipText("");
        
        main_Client.JPF_fromClt_passconf.setBackground( new Color(0,0,0,0));
        main_Client.JPF_fromClt_passconf.setText(singletonClient.ephemeralClient.getPassword());
        main_Client.JPF_fromClt_passconf.setBorder(null);
        main_Client.JPF_fromClt_passconf.setEchoChar('*');
        main_Client.JPF_fromClt_passconf.setToolTipText("");
        main_Client.lbl_formClt_passconfERR.setText(" ");
        main_Client.lbl_formClt_passconfERR.setToolTipText("");
        
        main_Client.txtf_formClt_phone.setEnabled(false);
        main_Client.txtf_formClt_phone.setFont(new java.awt.Font("Serif", 1, 14));
        main_Client.txtf_formClt_phone.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_phone.setText(format.formPhone(singletonClient.ephemeralClient.getMovile()));
        main_Client.txtf_formClt_phone.setBorder(null);
        main_Client.txtf_formClt_phone.setToolTipText("");
        main_Client.lbl_formClt_phoneERR.setText(" ");

        main_Client.DC_formClt_singdate.setCalendar(singletonClient.ephemeralClient.getRegister_date().toCalendar());
        main_Client.lbl_formClt_singdateERR.setText(" ");
        main_Client.lbl_formClt_singdateERR.setToolTipText("");

        main_Client.txtf_formClt_username.setEnabled(false);
        main_Client.txtf_formClt_username.setFont(new java.awt.Font("Serif", 0, 14));
        main_Client.txtf_formClt_username.setBackground( new Color(0,0,0,0));
        main_Client.txtf_formClt_username.setText(singletonClient.ephemeralClient.getUser());
        main_Client.txtf_formClt_username.setBorder(null);
        main_Client.txtf_formClt_username.setToolTipText("");
        main_Client.lbl_formClt_lusernameERR.setText(" ");
        
        main_Client.JCK_form_premium.setSelected(singletonClient.ephemeralClient.isPremium());
        main_Client.CB_formCLT_type.setSelectedItem(singletonClient.ephemeralClient.getClient_type());
        main_Client.lbl_form_benefit.setText(LanguageClt.getInstance().getProperty("view_benefit")+ " -> " + Float.toString(singletonClient.ephemeralClient.getBenefit()));
        main_Client.lbl_form_benefit.setFont(new java.awt.Font("Serif", 1, 14));
        
        main_Client.btn_formClt_Avatar.setEnabled(false);
        main_Client.btn_formCltCreate_create.setVisible(false);
        main_Client.btn_formCltCreate_back.setBackground(new Color(0,0,0,0));
        main_Client.PNL_drawForm.setVisible(true);
        main_Client.PNL_drawForm.setBackground(Color.WHITE);
        
        main_Client.CB_formClt_state.setSelectedItem(singletonClient.ephemeralClient.getState());
    }
 
       
    /**
     * askName function check if the main_Client.txtf_formClt_name text field is
     * valid
     *
     *
     * @return
     */
    public static boolean askName() {
        boolean valid = false;

        if (main_Client.txtf_formClt_name.getText().isEmpty()) {
            main_Client.txtf_formClt_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_name.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_name"));
            main_Client.txtf_formClt_name.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.lbl_formClt_nameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_nameERR.setForeground(Color.red);
        } else if (!validate.LettersOnly(main_Client.txtf_formClt_name.getText())) {
            main_Client.txtf_formClt_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_name.setToolTipText("SÛlo lÈtras");
            main_Client.lbl_formClt_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_nameERR.setText(LanguageClt.getInstance().getProperty("error"));
        } else {
            main_Client.txtf_formClt_name.setBorder(null);
            main_Client.txtf_formClt_name.setToolTipText("");
            main_Client.lbl_formClt_nameERR.setText("");
            valid = true;
        }
        return valid;
    }

    /**
     * askLastname function check if the main_Client.txtf_formClt_lastname text
     * field is valid
     *
     *
     * @return
     */
    public static boolean askLastname() {
        boolean valid = false;

        if (main_Client.txtf_formClt_lastname.getText().isEmpty()) {
            main_Client.txtf_formClt_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.lbl_formClt_lastnameERR.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_lastName"));
            main_Client.lbl_formClt_lastnameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_lastnameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_lastnameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersOnly(main_Client.txtf_formClt_lastname.getText())) {
            main_Client.txtf_formClt_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.lbl_formClt_lastnameERR.setToolTipText(LanguageClt.getInstance().getProperty("errVal_letters"));
            main_Client.lbl_formClt_lastnameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_lastnameERR.setForeground(Color.red);
        } else {
            main_Client.txtf_formClt_lastname.setBorder(null);
            main_Client.lbl_formClt_lastnameERR.setText("");
            main_Client.lbl_formClt_lastnameERR.setToolTipText(LanguageClt.getInstance().getProperty("errVal_letters"));
            valid = true;
        }
        return valid;
    }

    /**
     * askUsername function check if the main_Client.txtf_formClt_username text
     * field is valid
     *
     *
     * @return
     */
    public static boolean askUsername() {
        boolean valid = false;

        if (main_Client.txtf_formClt_username.getText().isEmpty()) {
            main_Client.txtf_formClt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_username.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_userName"));
            main_Client.lbl_formClt_lusernameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_lusernameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_Client.txtf_formClt_username.getText())) {
            main_Client.txtf_formClt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txtf_formClt_username.setToolTipText(LanguageClt.getInstance().getProperty("errVal_letters"));
            main_Client.lbl_formClt_lusernameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_lusernameERR.setForeground(Color.red);
        } else if(!BLL_DB_Client.BLL_DB_serachBYuserName()){
            main_Client.txtf_formClt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txtf_formClt_username.setToolTipText(LanguageClt.getInstance().getProperty("errVal_user"));
            main_Client.lbl_formClt_lusernameERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_lusernameERR.setForeground(Color.red);
        }else {
            main_Client.txtf_formClt_username.setBorder(null);
            main_Client.txtf_formClt_username.setToolTipText("");
            main_Client.lbl_formClt_lusernameERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askPhone() {
        boolean valid = false;

        if (main_Client.txtf_formClt_phone.getText().isEmpty()) {
            main_Client.txtf_formClt_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_phone.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_phone"));
            main_Client.lbl_formClt_phoneERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_phoneERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_phoneERR.setForeground(Color.red);
        } else if (!validate.Phone(main_Client.txtf_formClt_phone.getText())) {
            main_Client.txtf_formClt_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_phone.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txtf_formClt_phone.setToolTipText(LanguageClt.getInstance().getProperty("errVal_phone"));
            main_Client.lbl_formClt_phoneERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_phoneERR.setForeground(Color.red);
        } else {
            main_Client.txtf_formClt_phone.setBorder(null);
            main_Client.txtf_formClt_phone.setToolTipText("");
            main_Client.lbl_formClt_phoneERR.setText("");
            valid = true;
        }
        return valid;

    }

    public static boolean askPassword() {
        boolean valid = false;
        String pass = "";
        for (int i = 0; i < main_Client.JPF_fromClt_pass.getPassword().length; i++) {
            if(main_Client.JPF_fromClt_pass.getPassword()[i] != '-'){
                pass += main_Client.JPF_fromClt_pass.getPassword()[i];
            }   
        }
        if (pass.equals("")) {
            main_Client.JPF_fromClt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.lbl_formClt_passERR.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_pass"));
            main_Client.lbl_formClt_passERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_passERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_passERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Client.JPF_fromClt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.lbl_formClt_passERR.setToolTipText(LanguageClt.getInstance().getProperty("errVal_pass"));
            main_Client.lbl_formClt_passERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_passERR.setForeground(Color.red);
        } else {
            main_Client.JPF_fromClt_pass.setBorder(null);
            main_Client.lbl_formClt_passERR.setToolTipText("");
            main_Client.lbl_formClt_passERR.setText("");
            askConfirmPassword();
            valid = true;
        }
        return valid;

    }

    public static boolean askConfirmPassword() {
        boolean valid = false;
        String pass = new String(main_Client.JPF_fromClt_pass.getPassword());
        String conf_pass = new String(main_Client.JPF_fromClt_passconf.getPassword());

        if (pass.equals("")) {
            main_Client.JPF_fromClt_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.JPF_fromClt_passconf.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_pass"));
            main_Client.lbl_formClt_passconfERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_passconfERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Client.JPF_fromClt_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.JPF_fromClt_passconf.setToolTipText(LanguageClt.getInstance().getProperty("errVal_pass"));
            main_Client.lbl_formClt_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_passconfERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_passconfERR.setForeground(Color.red);
        } else if (!pass.equals(conf_pass)) {
            main_Client.JPF_fromClt_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.JPF_fromClt_passconf.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_confPass"));
            main_Client.lbl_formClt_passconfERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_passconfERR.setForeground(Color.red);

        } else {
            main_Client.JPF_fromClt_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Client.JPF_fromClt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Client.JPF_fromClt_passconf.setToolTipText("");
            main_Client.lbl_formClt_passconfERR.setText("");
            main_Client.lbl_formClt_passERR.setText("");
            singletonClient.passwd_formClt = pass;
            valid = true;

        }
        return valid;
    }

    public static boolean askDNI() {
        boolean valid = false;
        String dni ="";
        Character dnilet;
        main_Client.lbl_formClt_dniERR.setFont(new java.awt.Font("Dialog", 1, 12));
        
        
        if (main_Client.txtf_formClt_dni.getText().isEmpty()) {
            main_Client.txtf_formClt_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_dni.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_dni"));
            main_Client.lbl_formClt_dniERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_dniERR.setForeground(Color.red);
        } else {
            dni = main_Client.txtf_formClt_dni.getText();
            if(dni.length()>=9){
                if (dni.charAt(8) == '-') {
                    dnilet = dni.charAt(9);
                    dni = dni.substring(0, 8);
                    dni+=dnilet;
                }

                if (!validate.DNI(dni)) {
                    main_Client.txtf_formClt_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                    main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Client.txtf_formClt_dni.setToolTipText(LanguageClt.getInstance().getProperty("errVal_dni"));
                    main_Client.lbl_formClt_dniERR.setText(LanguageClt.getInstance().getProperty("error"));
                    main_Client.lbl_formClt_dniERR.setForeground(Color.red);
                } else {
                    main_Client.txtf_formClt_dni.setBorder(null);
                    main_Client.txtf_formClt_dni.setToolTipText("");
                    main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Client.lbl_formClt_dniERR.setText("");
                    singletonClient.passCltModf = true;
                    valid = true;
                }
            }
            else{
                main_Client.txtf_formClt_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                main_Client.txtf_formClt_dni.setToolTipText(LanguageClt.getInstance().getProperty("errVal_dni"));
                main_Client.lbl_formClt_dniERR.setText(LanguageClt.getInstance().getProperty("error"));
                main_Client.lbl_formClt_dniERR.setForeground(Color.red);
            }
        }
        return valid;
    }

    public static boolean askEmail() {
        boolean valid = false;

        if (main_Client.txtf_formClt_email.getText().isEmpty()) {
            main_Client.txtf_formClt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_email.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_email"));
            main_Client.lbl_formClt_emailERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_emailERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.lbl_formClt_emailERR.setForeground(Color.red);
        } else if (!validate.Email(main_Client.txtf_formClt_email.getText())) {
            main_Client.txtf_formClt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txtf_formClt_email.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txtf_formClt_email.setToolTipText(LanguageClt.getInstance().getProperty("errVal_email"));
            main_Client.lbl_formClt_emailERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_emailERR.setForeground(Color.red);
        } else {
            main_Client.txtf_formClt_email.setBorder(null);
            main_Client.lbl_formClt_emailERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askAccount() {
        boolean valid = false;

        if (!validate.Float(main_Client.txt_formClt_shopAccount.getText())) {
            main_Client.txt_formClt_shopAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Client.txt_formClt_shopAccount.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txt_formClt_shopAccount.setToolTipText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_shopAccountERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_shopAccountERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.lbl_formClt_shopAccountERR.setForeground(Color.red);
        } else {
            main_Client.txt_formClt_shopAccount.setBorder(null);
            main_Client.txt_formClt_shopAccount.setToolTipText("");
            main_Client.lbl_formClt_shopAccountERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askBorndate() {
        boolean valid = false;
        int day, month, year;
        DateO bornDate = new DateO("0/0/0000");

        try {
            bornDate = new DateO(main_Client.DC_formClt_borndate.getCalendar());
            bornDate.setSdate(DateO.formDate(bornDate.getSdate()));

        } catch (Exception e) {
            main_Client.DC_formClt_borndate.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_bornDate"));
            main_Client.lbl_formClt_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_borndateERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_borndateERR.setForeground(Color.red);
            return valid;
        }
        if (!bornDate.isValid_workage()) {
            main_Client.DC_formClt_borndate.setToolTipText(LanguageClt.getInstance().getProperty("errVal_bornDate"));
            main_Client.lbl_formClt_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_borndateERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_borndateERR.setForeground(Color.red);
        } else {
            main_Client.DC_formClt_borndate.setToolTipText("");
            main_Client.lbl_formClt_borndateERR.setText("");
            singletonClient.born_dateClt = bornDate;
            valid = true;
        }
        return valid;
    }

    public static boolean askSingDate() {
        boolean valid = false;
        int day, month, year;
        DateO singDate = new DateO("0/0/0000");
        DateO bornDate = new DateO("0/0/0000");
        try {
            singDate = new DateO(main_Client.DC_formClt_singdate.getCalendar());
            singDate.setSdate(DateO.formDate(singDate.getSdate()));
            bornDate = new DateO(main_Client.DC_formClt_borndate.getCalendar());
            bornDate.setSdate(DateO.formDate(bornDate.getSdate()));

        } catch (Exception e) {
            main_Client.DC_formClt_singdate.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_bornDate"));
            main_Client.lbl_formClt_singdateERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_singdateERR.setForeground(Color.red);
            return valid;
        }
        if (!singDate.isValid_singdate(bornDate)) {
            main_Client.DC_formClt_borndate.setToolTipText(LanguageClt.getInstance().getProperty("errVal_singDate"));
            main_Client.lbl_formClt_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Client.lbl_formClt_singdateERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Client.lbl_formClt_singdateERR.setForeground(Color.red);
        } else {
            main_Client.DC_formClt_singdate.setToolTipText("");
            main_Client.lbl_formClt_singdateERR.setText("");
            singletonClient.born_dateClt = bornDate;
            singletonClient.sing_dateClt = singDate;
            valid = true;
        }
        return valid;
    }

    public static boolean askAvatar() {
        boolean valid = false;
        File outputfile;
        JFileChooser jfileChoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.PNG", "png");
        jfileChoose.setFileFilter(filter);
        int option = jfileChoose.showOpenDialog(main_Client.btn_formClt_Avatar);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = jfileChoose.getSelectedFile().getPath();
            main_Client.lbl_formClt_photoavatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tama√±o
            Image newimg = img.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            imageSaver.SaveImage(file);
            //Se coloca el nuevo icono modificado
            main_Client.lbl_formClt_photoavatar.setIcon(newIcon);
            //Se cambia el tama√±o de la etiqueta
            main_Client.lbl_formClt_photoavatar.setSize(140, 170);
            //Guardo el Path en el singleton
            singletonClient.PATH_formClt = file;
            valid=true;
        }

        return valid;
    }
    
       
    /**
     * Functions of Form Admin Panel
     */
    
    public static void DAO_FC_mainBack() {
        MainClient.dispose();
        new Controler_Main(new main_login(), 2).run(2);
    }

    public static void DAO_FC_hideFormPanel() {
        main_Client.PNL_drawForm.setVisible(false);
    }

    /**
     * Clean Fields functions
     */
    public static void DAO_cfName() {
        if (main_Client.txtf_formClt_name.getText().equals(LanguageClt.getInstance().getProperty("new_name"))) {
            main_Client.txtf_formClt_name.setText("");
            main_Client.txtf_formClt_name.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfLastName() {
        if (main_Client.txtf_formClt_lastname.getText().equals(LanguageClt.getInstance().getProperty("new_lastName"))) {
            main_Client.txtf_formClt_lastname.setText("");
            main_Client.txtf_formClt_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfUserName() {
        if (main_Client.txtf_formClt_username.getText().equals(LanguageClt.getInstance().getProperty("new_userName"))) {
            main_Client.txtf_formClt_username.setText("");
            main_Client.txtf_formClt_username.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfPhone() {
        if (main_Client.txtf_formClt_phone.getText().equals(LanguageClt.getInstance().getProperty("new_phone"))) {
            main_Client.txtf_formClt_phone.setText("");
            main_Client.txtf_formClt_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfEmail() {
        if (main_Client.txtf_formClt_email.getText().equals(LanguageClt.getInstance().getProperty("new_email"))) {
            main_Client.txtf_formClt_email.setText("");
            main_Client.txtf_formClt_email.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfDNI() {
        if (main_Client.txtf_formClt_dni.getText().equals(LanguageClt.getInstance().getProperty("new_dni"))) {
            main_Client.txtf_formClt_dni.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Client.txtf_formClt_dni.setText("");
        }
    }
    
    public static void DAO_cfPass(){
        main_Client.JPF_fromClt_pass.setText("");
        main_Client.JPF_fromClt_passconf.setText("");
    }

    public static void DAO_cfPassConf(){
        main_Client.JPF_fromClt_passconf.setText("");
    }
    
    /**
     * Error paint messages
     */
    
    public static void DAO_ERR_Modify(){
        main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("error"));
        main_Client.lblMainform.setToolTipText(LanguageClt.getInstance().getProperty("error_modify"));
        main_Client.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_ERR_View(){
        main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("error"));
        main_Client.lblMainform.setToolTipText(LanguageClt.getInstance().getProperty("error_view"));
        main_Client.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_OK_Modify(){
        main_Client.lblMainform.setText(LanguageClt.getInstance().getProperty("ok_modify"));
        main_Client.lblMainform.setBackground(Color.green);
    }

}
