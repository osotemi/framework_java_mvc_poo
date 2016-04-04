/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.DAO;

import framework.clss.DateO;
import framework.mod.nav.controler.Controler_main;
import framework.mod.nav.view.main;
import static framework.mod.user.registered.controler.Controler_mainReg.MainReg;
import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.singletonReg;
import framework.mod.user.registered.model.tools.LanguageReg;
import framework.mod.user.registered.model.tools.dummieReg_gen;
import framework.mod.user.registered.view.main_Reg;
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
public class DAO_Registered {
       
    /**
     * Creates an Admin checking for all the fields are OK; saves in on singleton.ephimeralAdmin and returns true when done
     * If the fields are not ok, shows an error and returns false
     * @return
     */
    public static boolean formCreateReg() {
        RegisteredU reg = new RegisteredU();
        DateO born = new DateO();
        DateO sing = new DateO();
        String error = "";
        boolean valid = false;
        boolean chkName = askName(), chkLastname = askLastname(), chkUsername = askUsername(), chkPhone = askPhone(), chkConfPass = askConfirmPassword(), chkDNI = askDNI(), chkEmail = askEmail(), chkActivity = askActivity(), chkBorndate = askBorndate(), chkAvatar = true;
        try {
            if(singletonReg.PATH_formReg.equals(""))
            singletonReg.PATH_formReg = singletonReg.ephemeralReg.getAvataring();

        } catch (Exception e) {
            singletonReg.PATH_formReg = dummieReg_gen.rdmAvatar();
        }
        
        if (chkName && chkLastname && chkUsername && chkPhone && chkConfPass && chkDNI && chkEmail && chkActivity && chkBorndate && chkAvatar) {
            born = new DateO(main_Reg.DC_formReg_borndate.getCalendar());
            reg = new RegisteredU(singletonReg.PATH_formReg, born, main_Reg.txtf_formReg_dni.getText(), main_Reg.txtf_formReg_email.getText(), 
                    main_Reg.txtf_formReg_phone.getText(), main_Reg.txtf_formReg_name.getText(), main_Reg.txtf_formReg_lastname.getText(), singletonReg.passwd_formReg, 
                    ((String) main_Reg.CB_formReg_state.getSelectedItem()), main_Reg.txtf_formReg_username.getText(), Integer.parseInt(main_Reg.txt_formReg_activity.getText()));
            
            singletonReg.ephemeralReg = reg;
            valid = true;
        }
        else{
            error = LanguageReg.getInstance().getProperty("err_createAdm") + "\n";
            
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
                error+= "-Error en la confirmación de la contraseño\n";
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
                error+=  "-Error en el teléfono\n";
            }
            if(chkUsername){
                error+= "-Error en el nombre de usuario\n";
            }
            main_Reg.lblMainform.setToolTipText(error);
            main_Reg.lblMainform.setOpaque(true);
            main_Reg.lblMainform.setBackground(Color.red);
            main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("error"));
        }
        return valid;
    }
    
    
    public static void formNew() {

        main_Reg.txt_formReg_activity.setEnabled(true);
        main_Reg.txt_formReg_activity.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txt_formReg_activity.setBackground( Color.white);
        main_Reg.txt_formReg_activity.setBorder(null);
        main_Reg.txt_formReg_activity.setText("0");
        main_Reg.lbl_formReg_activityERR.setText(" ");

        main_Reg.btn_formReg_Avatar.setEnabled(true);
        main_Reg.lbl_formReg_photoavatar.setText("");
        
        main_Reg.DC_formReg_borndate.setDate(null);
        main_Reg.lbl_formReg_borndateERR.setText(" ");
        
        main_Reg.txtf_formReg_dni.setEnabled(true);
        main_Reg.txtf_formReg_dni.setBackground( Color.white);
        main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_dni.setText(LanguageReg.getInstance().getProperty("new_dni"));
        main_Reg.txtf_formReg_dni.setBorder(null);
        main_Reg.lbl_formReg_dniERR.setText(" ");

        main_Reg.txtf_formReg_email.setEnabled(true);
        main_Reg.txtf_formReg_email.setBackground( Color.white);
        main_Reg.txtf_formReg_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_email.setText(LanguageReg.getInstance().getProperty("new_email"));
        main_Reg.txtf_formReg_email.setBorder(null);
        main_Reg.lbl_formReg_emailERR.setText(" ");

        main_Reg.txtf_formReg_lastname.setEnabled(true);
        main_Reg.txtf_formReg_lastname.setBackground( Color.white);
        main_Reg.txtf_formReg_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_lastname.setText(LanguageReg.getInstance().getProperty("new_lastName"));
        main_Reg.txtf_formReg_lastname.setBorder(null);
        main_Reg.lbl_formReg_lastnameERR.setText(" ");

        
        main_Reg.lblMainform.setBackground( Color.white);
        main_Reg.lblMainform.setOpaque(false);
        main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("new_titleCreate"));
        main_Reg.lblMainform.setToolTipText("");
        main_Reg.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        
        main_Reg.txtf_formReg_name.setEnabled(true);
        main_Reg.txtf_formReg_name.setBackground( Color.white);
        main_Reg.txtf_formReg_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_name.setText(LanguageReg.getInstance().getProperty("new_name"));
        main_Reg.txtf_formReg_name.setBorder(null);
        main_Reg.lbl_formReg_nameERR.setText(" ");

        main_Reg.JPF_fromReg_pass.setEnabled(true);
        main_Reg.JPF_fromReg_pass.setBackground( Color.white);
        main_Reg.JPF_fromReg_pass.setText("");
        main_Reg.JPF_fromReg_pass.setBorder(null);
        main_Reg.JPF_fromReg_pass.setEchoChar('*');
        main_Reg.lbl_formReg_passERR.setText(" ");

        main_Reg.JPF_fromReg_passconf.setEnabled(true);
        main_Reg.JPF_fromReg_passconf.setBackground( Color.white);
        main_Reg.JPF_fromReg_passconf.setText("");
        main_Reg.JPF_fromReg_passconf.setBorder(null);
        main_Reg.JPF_fromReg_passconf.setEchoChar('*');
        main_Reg.lbl_formReg_passconfERR.setText(" ");

        main_Reg.txtf_formReg_phone.setEnabled(true);
        main_Reg.txtf_formReg_phone.setBackground( Color.white);
        main_Reg.txtf_formReg_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_phone.setText(LanguageReg.getInstance().getProperty("new_phone"));
        main_Reg.txtf_formReg_phone.setBorder(null);
        main_Reg.lbl_formReg_phoneERR.setText(" ");

        main_Reg.lbl_formReg_photoavatar.setIcon(null);

        main_Reg.txtf_formReg_username.setEnabled(true);
        main_Reg.txtf_formReg_username.setBackground( Color.white);
        main_Reg.txtf_formReg_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_username.setText(LanguageReg.getInstance().getProperty("new_userName"));
        main_Reg.txtf_formReg_username.setBorder(null);
        main_Reg.lbl_formReg_usernameERR.setText(" ");

        main_Reg.btn_formRegCreate_back.setBackground( Color.lightGray);
        main_Reg.btn_formRegCreate_back.setVisible(true);
        main_Reg.btn_formRegCreate_back.setText(LanguageReg.getInstance().getProperty("new_BTMmodify"));
        main_Reg.btn_formRegCreate_create.setBackground( Color.lightGray);
        main_Reg.btn_formRegCreate_create.setVisible(true);
        main_Reg.btn_formRegCreate_create.setText(LanguageReg.getInstance().getProperty("new_BTMcreate"));
        
        main_Reg.PNL_drawForm.setBackground(Color.lightGray);
        main_Reg.PNL_drawForm.setVisible(true);
        main_Reg.txtf_formReg_username.requestFocus();
        main_Reg.txtf_formReg_username.selectAll();
    }

    public static void forModifyReg() {
        main_Reg.txt_formReg_activity.setText(Integer.toString(singletonReg.ephemeralReg.getActivity()));
        main_Reg.txt_formReg_activity.setBorder(null);
        main_Reg.txt_formReg_activity.setBackground(Color.white);
        main_Reg.txt_formReg_activity.setEnabled(true);
        main_Reg.txt_formReg_activity.setToolTipText(""+singletonReg.ephemeralReg.getActivity());
        main_Reg.lbl_formReg_activityERR.setText("");

        main_Reg.btn_formReg_Avatar.setEnabled(true);
        main_Reg.btn_formReg_Avatar.setVisible(true);
        try {
            main_Reg.lbl_formReg_photoavatar.setIcon(new ImageIcon(singletonReg.ephemeralReg.getAvataring()));
        } catch (Exception e) {
            main_Reg.btn_formReg_Avatar.setToolTipText("Imposible cargar imágen");//err_avatar
        }
        
        main_Reg.DC_formReg_borndate.setCalendar(singletonReg.ephemeralReg.getBorn_date().toCalendar());
        main_Reg.lbl_formReg_borndateERR.setToolTipText("");
        main_Reg.lbl_formReg_borndateERR.setText("");
        
        main_Reg.btn_formRegCreate_create.setText(LanguageReg.getInstance().getProperty("new_BTMmodify"));
        
        main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_dni.setText(singletonReg.ephemeralReg.getDni());
        main_Reg.txtf_formReg_dni.setBorder(null);
        main_Reg.txtf_formReg_dni.setToolTipText("");
        main_Reg.txtf_formReg_dni.setEnabled(true);
        main_Reg.txtf_formReg_dni.setBackground(Color.white);
        main_Reg.lbl_formReg_dniERR.setText(" ");
        
        main_Reg.txtf_formReg_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_email.setText(singletonReg.ephemeralReg.getEmail());
        main_Reg.txtf_formReg_email.setBorder(null);
        main_Reg.txtf_formReg_email.setToolTipText("");
        main_Reg.txtf_formReg_email.setEnabled(true);
        main_Reg.txtf_formReg_email.setBackground(Color.white);
        main_Reg.lbl_formReg_emailERR.setText("");

        main_Reg.CB_formReg_state.setSelectedItem(singletonReg.ephemeralReg.getState());
        
        main_Reg.txtf_formReg_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_lastname.setText(singletonReg.ephemeralReg.getLastname());
        main_Reg.txtf_formReg_lastname.setBorder(null);
        main_Reg.txtf_formReg_lastname.setToolTipText("");
        main_Reg.txtf_formReg_lastname.setEnabled(true);
        main_Reg.txtf_formReg_lastname.setBackground(Color.white);
        main_Reg.lbl_formReg_lastnameERR.setText(" ");

        main_Reg.lblMainform.setOpaque(false);
        main_Reg.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("new_titleModify"));
        main_Reg.lblMainform.setToolTipText("");

        main_Reg.txtf_formReg_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_name.setText(singletonReg.ephemeralReg.getName());
        main_Reg.txtf_formReg_name.setBorder(null);
        main_Reg.txtf_formReg_name.setToolTipText("");
        main_Reg.txtf_formReg_name.setEnabled(true);
        main_Reg.txtf_formReg_name.setBackground(Color.white);
        main_Reg.lbl_formReg_nameERR.setText(" ");

        main_Reg.JPF_fromReg_pass.setText(singletonReg.ephemeralReg.getPassword());
        main_Reg.JPF_fromReg_pass.setBorder(null);
        main_Reg.JPF_fromReg_pass.setEnabled(true);
        main_Reg.JPF_fromReg_pass.setToolTipText("");
        main_Reg.JPF_fromReg_pass.setBackground(Color.white);
        main_Reg.JPF_fromReg_pass.setEchoChar((char) 0);
        main_Reg.lbl_formReg_passERR.setText(" ");

        main_Reg.JPF_fromReg_passconf.setText(singletonReg.ephemeralReg.getPassword());
        main_Reg.JPF_fromReg_passconf.setBorder(null);
        main_Reg.JPF_fromReg_passconf.setEnabled(true);
        main_Reg.JPF_fromReg_passconf.setToolTipText("");
        main_Reg.JPF_fromReg_passconf.setBackground(Color.white);
        main_Reg.JPF_fromReg_passconf.setEchoChar((char) 0);
        main_Reg.lbl_formReg_passconfERR.setText(" ");

        main_Reg.txtf_formReg_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_phone.setText(singletonReg.ephemeralReg.getMovile());
        main_Reg.txtf_formReg_phone.setBorder(null);
        main_Reg.txtf_formReg_phone.setEnabled(true);
        main_Reg.txtf_formReg_phone.setBackground(Color.white);
        main_Reg.txtf_formReg_phone.setToolTipText("");
        main_Reg.lbl_formReg_phoneERR.setText(" ");

        main_Reg.CB_formReg_state.setSelectedItem(singletonReg.ephemeralReg.getState());
        
        main_Reg.txtf_formReg_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Reg.txtf_formReg_username.setText(singletonReg.ephemeralReg.getUser());
        main_Reg.txtf_formReg_username.setBorder(null);
        main_Reg.txtf_formReg_username.setEnabled(true);
        main_Reg.txtf_formReg_username.setToolTipText("");
        main_Reg.txtf_formReg_username.setBackground(Color.white);
        main_Reg.lbl_formReg_usernameERR.setText(" ");
        
        main_Reg.btn_formRegCreate_back.setBackground( Color.lightGray);
        main_Reg.btn_formRegCreate_back.setVisible(true);
        main_Reg.btn_formRegCreate_back.setEnabled(true);
        main_Reg.btn_formRegCreate_back.setText(LanguageReg.getInstance().getProperty("DRW_btnBack"));
        main_Reg.btn_formRegCreate_create.setEnabled(true);
        main_Reg.btn_formRegCreate_create.setVisible(true);
        main_Reg.btn_formRegCreate_create.setText(LanguageReg.getInstance().getProperty("new_BTMmodify"));
        main_Reg.PNL_drawForm.setBackground(null);
        main_Reg.PNL_drawForm.setVisible(true);
        main_Reg.txtf_formReg_username.requestFocus();
        main_Reg.txtf_formReg_username.selectAll();
    }

    /**
     * Draw the View Admin form
     */
    public static void formViewReg() {
        main_Reg.txt_formReg_activity.setEnabled(false);
        main_Reg.txt_formReg_activity.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txt_formReg_activity.setBackground( new Color(0,0,0,0));
        main_Reg.txt_formReg_activity.setText(Integer.toString(singletonReg.ephemeralReg.getActivity()));
        main_Reg.txt_formReg_activity.setToolTipText("");
        main_Reg.txt_formReg_activity.setBorder(null);

        try {
            main_Reg.lbl_formReg_photoavatar.setIcon(new ImageIcon(singletonReg.ephemeralReg.getAvataring()));
        } catch (Exception e) {
            main_Reg.btn_formReg_Avatar.setToolTipText("Imposible cargar imágen");
        }
        
        main_Reg.DC_formReg_borndate.setCalendar(singletonReg.ephemeralReg.getBorn_date().toCalendar());
        main_Reg.lbl_formReg_borndateERR.setText("");
        main_Reg.lbl_formReg_borndateERR.setToolTipText("");
        
        
        main_Reg.txtf_formReg_dni.setEnabled(false);
        main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txtf_formReg_dni.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_dni.setText(singletonReg.ephemeralReg.getDni());
        main_Reg.txtf_formReg_dni.setBorder(null);
        main_Reg.txtf_formReg_dni.setToolTipText("");
        main_Reg.lbl_formReg_dniERR.setText(" ");
        
        main_Reg.txtf_formReg_email.setEnabled(false);
        main_Reg.txtf_formReg_email.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txtf_formReg_email.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_email.setText(singletonReg.ephemeralReg.getEmail());
        main_Reg.txtf_formReg_email.setBorder(null);
        main_Reg.txtf_formReg_email.setToolTipText("");
        main_Reg.lbl_formReg_emailERR.setText(" ");

        main_Reg.txtf_formReg_lastname.setEnabled(false);
        main_Reg.txtf_formReg_lastname.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txtf_formReg_lastname.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_lastname.setText(singletonReg.ephemeralReg.getLastname());
        main_Reg.txtf_formReg_lastname.setBorder(null);
        main_Reg.txtf_formReg_lastname.setToolTipText("");
        main_Reg.lbl_formReg_lastnameERR.setText(" ");

        main_Reg.lblMainform.setOpaque(false);
        main_Reg.lblMainform.setText("Ficha");
        main_Reg.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 14));
        main_Reg.lblMainform.setToolTipText("");

        main_Reg.txtf_formReg_name.setEnabled(false);
        main_Reg.txtf_formReg_name.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txtf_formReg_name.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_name.setText(singletonReg.ephemeralReg.getName());
        main_Reg.txtf_formReg_name.setBorder(null);
        main_Reg.txtf_formReg_name.setToolTipText("");
        main_Reg.lbl_formReg_nameERR.setText(" ");

        main_Reg.JPF_fromReg_pass.setBackground( new Color(0,0,0,0));
        main_Reg.JPF_fromReg_pass.setText(singletonReg.ephemeralReg.getPassword());
        main_Reg.JPF_fromReg_pass.setBorder(null);
        main_Reg.JPF_fromReg_pass.setToolTipText("");
        main_Reg.JPF_fromReg_pass.setEchoChar('*');
        main_Reg.lbl_formReg_passERR.setText(" ");
        main_Reg.lbl_formReg_passERR.setToolTipText("");
        
        main_Reg.JPF_fromReg_passconf.setBackground( new Color(0,0,0,0));
        main_Reg.JPF_fromReg_passconf.setText(singletonReg.ephemeralReg.getPassword());
        main_Reg.JPF_fromReg_passconf.setBorder(null);
        main_Reg.JPF_fromReg_passconf.setEchoChar('*');
        main_Reg.JPF_fromReg_passconf.setToolTipText("");
        main_Reg.lbl_formReg_passconfERR.setText(" ");
        main_Reg.lbl_formReg_passconfERR.setToolTipText("");
        
        main_Reg.txtf_formReg_phone.setEnabled(false);
        main_Reg.txtf_formReg_phone.setFont(new java.awt.Font("Serif", 1, 14));
        main_Reg.txtf_formReg_phone.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_phone.setText(format.formPhone(singletonReg.ephemeralReg.getMovile()));
        main_Reg.txtf_formReg_phone.setBorder(null);
        main_Reg.txtf_formReg_phone.setToolTipText("");
        main_Reg.lbl_formReg_phoneERR.setText(" ");

        main_Reg.txtf_formReg_username.setEnabled(false);
        main_Reg.txtf_formReg_username.setFont(new java.awt.Font("Serif", 0, 14));
        main_Reg.txtf_formReg_username.setBackground( new Color(0,0,0,0));
        main_Reg.txtf_formReg_username.setText(singletonReg.ephemeralReg.getUser());
        main_Reg.txtf_formReg_username.setBorder(null);
        main_Reg.txtf_formReg_username.setToolTipText("");
        main_Reg.lbl_formReg_usernameERR.setText(" ");
        
        main_Reg.btn_formReg_Avatar.setEnabled(false);
        main_Reg.btn_formRegCreate_create.setVisible(false);
        main_Reg.btn_formRegCreate_back.setBackground(new Color(0,0,0,0));
        main_Reg.PNL_drawForm.setVisible(true);
        main_Reg.PNL_drawForm.setBackground(Color.WHITE);
        
        main_Reg.CB_formReg_state.setSelectedItem(singletonReg.ephemeralReg.getState());
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

        if (main_Reg.txtf_formReg_name.getText().isEmpty()) {
            main_Reg.txtf_formReg_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_name.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_name"));
            main_Reg.txtf_formReg_name.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.lbl_formReg_nameERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_nameERR.setForeground(Color.red);
        } else if (!validate.LettersOnly(main_Reg.txtf_formReg_name.getText())) {
            main_Reg.txtf_formReg_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_name.setToolTipText("Sólo létras");
            main_Reg.lbl_formReg_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_nameERR.setText(LanguageReg.getInstance().getProperty("error"));
        } else {
            main_Reg.txtf_formReg_name.setBorder(null);
            main_Reg.txtf_formReg_name.setToolTipText("");
            main_Reg.lbl_formReg_nameERR.setText("");
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

        if (main_Reg.txtf_formReg_lastname.getText().isEmpty()) {
            main_Reg.txtf_formReg_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.lbl_formReg_lastnameERR.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_lastName"));
            main_Reg.lbl_formReg_lastnameERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_lastnameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_lastnameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersOnly(main_Reg.txtf_formReg_lastname.getText())) {
            main_Reg.txtf_formReg_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.lbl_formReg_lastnameERR.setToolTipText(LanguageReg.getInstance().getProperty("errVal_letters"));
            main_Reg.lbl_formReg_lastnameERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_lastnameERR.setForeground(Color.red);
        } else {
            main_Reg.txtf_formReg_lastname.setBorder(null);
            main_Reg.lbl_formReg_lastnameERR.setText("");
            main_Reg.lbl_formReg_lastnameERR.setToolTipText(LanguageReg.getInstance().getProperty("errVal_letters"));
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

        if (main_Reg.txtf_formReg_username.getText().isEmpty()) {
            main_Reg.txtf_formReg_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_username.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_userName"));
            main_Reg.lbl_formReg_usernameERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_usernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_usernameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_Reg.txtf_formReg_username.getText())) {
            main_Reg.txtf_formReg_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.txtf_formReg_username.setToolTipText(LanguageReg.getInstance().getProperty("errVal_letters"));
            main_Reg.lbl_formReg_usernameERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_usernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_usernameERR.setForeground(Color.red);
        } else {
            main_Reg.txtf_formReg_username.setBorder(null);
            main_Reg.txtf_formReg_username.setToolTipText("");
            main_Reg.lbl_formReg_usernameERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askPhone() {
        boolean valid = false;

        if (main_Reg.txtf_formReg_phone.getText().isEmpty()) {
            main_Reg.txtf_formReg_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_phone.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_phone"));
            main_Reg.lbl_formReg_phoneERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_phoneERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_phoneERR.setForeground(Color.red);
        } else if (!validate.Phone(main_Reg.txtf_formReg_phone.getText())) {
            main_Reg.txtf_formReg_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_phone.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.txtf_formReg_phone.setToolTipText(LanguageReg.getInstance().getProperty("errVal_phone"));
            main_Reg.lbl_formReg_phoneERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_phoneERR.setForeground(Color.red);
        } else {
            main_Reg.txtf_formReg_phone.setBorder(null);
            main_Reg.txtf_formReg_phone.setToolTipText("");
            main_Reg.lbl_formReg_phoneERR.setText("");
            valid = true;
        }
        return valid;

    }

    public static boolean askPassword() {
        boolean valid = false;
        String pass = "";
        for (int i = 0; i < main_Reg.JPF_fromReg_pass.getPassword().length; i++) {
            if(main_Reg.JPF_fromReg_pass.getPassword()[i] != '-'){
                pass += main_Reg.JPF_fromReg_pass.getPassword()[i];
            }   
        }
        if (pass.equals("")) {
            main_Reg.JPF_fromReg_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.lbl_formReg_passERR.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_pass"));
            main_Reg.lbl_formReg_passERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_passERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_passERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Reg.JPF_fromReg_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.lbl_formReg_passERR.setToolTipText(LanguageReg.getInstance().getProperty("errVal_pass"));
            main_Reg.lbl_formReg_passERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_passERR.setForeground(Color.red);
        } else {
            main_Reg.JPF_fromReg_pass.setBorder(null);
            main_Reg.lbl_formReg_passERR.setToolTipText("");
            main_Reg.lbl_formReg_passERR.setText("");
            askConfirmPassword();
            valid = true;
        }
        return valid;

    }

    public static boolean askConfirmPassword() {
        boolean valid = false;
        String pass = new String(main_Reg.JPF_fromReg_pass.getPassword());
        String conf_pass = new String(main_Reg.JPF_fromReg_passconf.getPassword());

        if (pass.equals("")) {
            main_Reg.JPF_fromReg_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.JPF_fromReg_passconf.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_pass"));
            main_Reg.lbl_formReg_passconfERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_passconfERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Reg.JPF_fromReg_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.JPF_fromReg_passconf.setToolTipText(LanguageReg.getInstance().getProperty("errVal_pass"));
            main_Reg.lbl_formReg_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_passconfERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_passconfERR.setForeground(Color.red);
        } else if (!pass.equals(conf_pass)) {
            main_Reg.JPF_fromReg_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.JPF_fromReg_passconf.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_confPass"));
            main_Reg.lbl_formReg_passconfERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_passconfERR.setForeground(Color.red);

        } else {
            main_Reg.JPF_fromReg_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Reg.JPF_fromReg_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Reg.JPF_fromReg_passconf.setToolTipText("");
            main_Reg.lbl_formReg_passconfERR.setText("");
            main_Reg.lbl_formReg_passERR.setText("");
            singletonReg.PATH_formReg = pass;
            valid = true;

        }
        return valid;
    }

    public static boolean askDNI() {
        boolean valid = false;
        String dni ="";
        Character dnilet;
        main_Reg.lbl_formReg_dniERR.setFont(new java.awt.Font("Dialog", 1, 12));
        
        
        if (main_Reg.txtf_formReg_dni.getText().isEmpty()) {
            main_Reg.txtf_formReg_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_dni.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_dni"));
            main_Reg.lbl_formReg_dniERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_dniERR.setForeground(Color.red);
        } else {
            dni = main_Reg.txtf_formReg_dni.getText();
            if(dni.length()>=9){
                if (dni.charAt(8) == '-') {
                    dnilet = dni.charAt(9);
                    dni = dni.substring(0, 8);
                    dni+=dnilet;
                }

                if (!validate.DNI(dni)) {
                    main_Reg.txtf_formReg_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                    main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Reg.txtf_formReg_dni.setToolTipText(LanguageReg.getInstance().getProperty("errVal_dni"));
                    main_Reg.lbl_formReg_dniERR.setText(LanguageReg.getInstance().getProperty("error"));
                    main_Reg.lbl_formReg_dniERR.setForeground(Color.red);
                } else {
                    main_Reg.txtf_formReg_dni.setBorder(null);
                    main_Reg.txtf_formReg_dni.setToolTipText("");
                    main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Reg.lbl_formReg_dniERR.setText("");
                    singletonReg.passRegModf = true;
                    valid = true;
                }
            }
            else{
                main_Reg.txtf_formReg_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                main_Reg.txtf_formReg_dni.setToolTipText(LanguageReg.getInstance().getProperty("errVal_dni"));
                main_Reg.lbl_formReg_dniERR.setText(LanguageReg.getInstance().getProperty("error"));
                main_Reg.lbl_formReg_dniERR.setForeground(Color.red);
            }
        }
        return valid;
    }

    public static boolean askEmail() {
        boolean valid = false;

        if (main_Reg.txtf_formReg_email.getText().isEmpty()) {
            main_Reg.txtf_formReg_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_email.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_email"));
            main_Reg.lbl_formReg_emailERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_emailERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.lbl_formReg_emailERR.setForeground(Color.red);
        } else if (!validate.Email(main_Reg.txtf_formReg_email.getText())) {
            main_Reg.txtf_formReg_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txtf_formReg_email.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.txtf_formReg_email.setToolTipText(LanguageReg.getInstance().getProperty("errVal_email"));
            main_Reg.lbl_formReg_emailERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_emailERR.setForeground(Color.red);
        } else {
            main_Reg.txtf_formReg_email.setBorder(null);
            main_Reg.lbl_formReg_emailERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askActivity() {
        boolean valid = false;

        if (!validate.Numbers(main_Reg.txt_formReg_activity.getText())) {
            main_Reg.txt_formReg_activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Reg.txt_formReg_activity.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.txt_formReg_activity.setToolTipText(LanguageReg.getInstance().getProperty("errVal_letters"));
            main_Reg.lbl_formReg_activityERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_activityERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.lbl_formReg_activityERR.setForeground(Color.red);
        } else {
            main_Reg.txt_formReg_activity.setBorder(null);
            main_Reg.txt_formReg_activity.setToolTipText("");
            main_Reg.lbl_formReg_activityERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askBorndate() {
        boolean valid = false;
        int day, month, year;
        DateO bornDate = new DateO("0/0/0000");

        try {
            bornDate = new DateO(main_Reg.DC_formReg_borndate.getCalendar());

        } catch (Exception e) {
            main_Reg.DC_formReg_borndate.setToolTipText(LanguageReg.getInstance().getProperty("errAsk_bornDate"));
            main_Reg.lbl_formReg_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_borndateERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_borndateERR.setForeground(Color.red);
            return valid;
        }
        if (!bornDate.isValid_workage()) {
            main_Reg.DC_formReg_borndate.setToolTipText(LanguageReg.getInstance().getProperty("errVal_bornDate"));
            main_Reg.lbl_formReg_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_borndateERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_borndateERR.setForeground(Color.red);
        } else {
            main_Reg.DC_formReg_borndate.setToolTipText("");
            main_Reg.lbl_formReg_borndateERR.setText("");
            singletonReg.born_dateReg = bornDate;
            valid = true;
        }
        return valid;
    }
/*
    public static boolean askSingDate() {
        boolean valid = false;
        int day, month, year;
        DateO singDate = new DateO("0/0/0000");
        DateO bornDate = new DateO("0/0/0000");
        try {
            singDate = new DateO(main_Reg.DC_formClt_singdate.getCalendar());
            bornDate = new DateO(main_Reg.DC_formClt_borndate.getCalendar());

        } catch (Exception e) {
            main_Reg.DC_formClt_singdate.setToolTipText(LanguageClt.getInstance().getProperty("errAsk_bornDate"));
            main_Reg.lbl_formClt_singdateERR.setText(LanguageClt.getInstance().getProperty("error"));
            main_Reg.lbl_formClt_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formClt_singdateERR.setForeground(Color.red);
            return valid;
        }
        if (!singDate.isValid_singdate(bornDate)) {
            main_Reg.DC_formReg_borndate.setToolTipText(LanguageReg.getInstance().getProperty("errVal_singDate"));
            main_Reg.lbl_formReg_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Reg.lbl_formReg_singdateERR.setText(LanguageReg.getInstance().getProperty("error"));
            main_Reg.lbl_formReg_singdateERR.setForeground(Color.red);
        } else {
            main_Reg.DC_formReg_singdate.setToolTipText("");
            main_Reg.lbl_formReg_singdateERR.setText("");
            singletonReg.born_dateReg = bornDate;
            singletonReg.sing_dateReg = singDate;
            valid = true;
        }
        return valid;
    }
*/
    public static boolean askAvatar() {
        boolean valid = false;
        File outputfile;
        JFileChooser jfileChoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.PNG", "png");
        jfileChoose.setFileFilter(filter);
        int option = jfileChoose.showOpenDialog(main_Reg.btn_formReg_Avatar);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = jfileChoose.getSelectedFile().getPath();
            main_Reg.lbl_formReg_photoavatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaÃ±o
            Image newimg = img.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            imageSaver.SaveImage(file);
            //Se coloca el nuevo icono modificado
            main_Reg.lbl_formReg_photoavatar.setIcon(newIcon);
            //Se cambia el tamaÃ±o de la etiqueta
            main_Reg.lbl_formReg_photoavatar.setSize(140, 170);
            //Guardo el Path en el singleton
            singletonReg.PATH_formReg = file;
            valid=true;
        }

        return valid;
    }
    
       
    /**
     * Functions of Form Admin Panel
     */
    
    public static void DAO_FR_mainBack() {
        MainReg.dispose();
        new Controler_main(new main()).run();
    }

    public static void DAO_FR_hideFormPanel() {
        main_Reg.PNL_drawForm.setVisible(false);
    }

    /**
     * Clean Fields functions
     */
    public static void DAO_cfName() {
        if (main_Reg.txtf_formReg_name.getText().equals(LanguageReg.getInstance().getProperty("new_name"))) {
            main_Reg.txtf_formReg_name.setText("");
            main_Reg.txtf_formReg_name.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfLastName() {
        if (main_Reg.txtf_formReg_lastname.getText().equals(LanguageReg.getInstance().getProperty("new_lastName"))) {
            main_Reg.txtf_formReg_lastname.setText("");
            main_Reg.txtf_formReg_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfUserName() {
        if (main_Reg.txtf_formReg_username.getText().equals(LanguageReg.getInstance().getProperty("new_userName"))) {
            main_Reg.txtf_formReg_username.setText("");
            main_Reg.txtf_formReg_username.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfPhone() {
        if (main_Reg.txtf_formReg_phone.getText().equals(LanguageReg.getInstance().getProperty("new_phone"))) {
            main_Reg.txtf_formReg_phone.setText("");
            main_Reg.txtf_formReg_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfEmail() {
        if (main_Reg.txtf_formReg_email.getText().equals(LanguageReg.getInstance().getProperty("new_email"))) {
            main_Reg.txtf_formReg_email.setText("");
            main_Reg.txtf_formReg_email.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfDNI() {
        if (main_Reg.txtf_formReg_dni.getText().equals(LanguageReg.getInstance().getProperty("new_dni"))) {
            main_Reg.txtf_formReg_dni.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Reg.txtf_formReg_dni.setText("");
        }
    }
    
    public static void DAO_cfPass(){
        main_Reg.JPF_fromReg_pass.setText("");
        main_Reg.JPF_fromReg_passconf.setText("");
    }

    public static void DAO_cfPassConf(){
        main_Reg.JPF_fromReg_passconf.setText("");
    }
    
    /**
     * Error paint messages
     */
    
    public static void DAO_ERR_Modify(){
        main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("error"));
        main_Reg.lblMainform.setToolTipText(LanguageReg.getInstance().getProperty("error_modify"));
        main_Reg.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_ERR_View(){
        main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("error"));
        main_Reg.lblMainform.setToolTipText(LanguageReg.getInstance().getProperty("error_view"));
        main_Reg.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_OK_Modify(){
        main_Reg.lblMainform.setText(LanguageReg.getInstance().getProperty("ok_modify"));
        main_Reg.lblMainform.setBackground(Color.green);
    }

}
