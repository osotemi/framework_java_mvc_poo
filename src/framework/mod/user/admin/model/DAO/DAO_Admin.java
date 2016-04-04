/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.DAO;

import framework.clss.DateO;
import framework.mod.nav.controler.Controler_main;
import framework.mod.nav.view.main;
import framework.mod.settings.model.clss.Settings;
import framework.mod.user.admin.controler.Controler_mainAdmin;
import static framework.mod.user.admin.controler.Controler_mainAdmin.MainAdmin;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.LanguageAdm;
import framework.mod.user.admin.model.tools.dummieAdm_gen;
import framework.tools.validate;
import framework.mod.user.admin.view.main_Admin;
import framework.tools.format;
import framework.tools.imageSaver;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author osotemi
 */
public class DAO_Admin {
        
    /**
     * Creates an Admin checking for all the fields are OK; saves in on singleton.ephimeralAdmin and returns true when done
     * If the fields are not ok, shows an error and returns false
     * @return
     */
    public static boolean formCreateAdmin() {
        Admin adm = new Admin();
        DateO born = new DateO();
        DateO sing = new DateO();
        String error = "";
        boolean valid = false;
        boolean chkName = askName(), chkLastname = askLastname(), chkUsername = askUsername(), chkPhone = askPhone(), chkConfPass = askConfirmPassword(), chkDNI = askDNI(), chkEmail = askEmail(), chkActivity = askActivity(), chkBorndate = askBorndate(), chkSingdate = askSingDate(), chkAvatar = true;
        try {
            if(singletonAdmin.PATH_formAdm.equals(""))
            singletonAdmin.PATH_formAdm = singletonAdmin.ephemeralAdmin.getAvataring();

        } catch (Exception e) {
            singletonAdmin.PATH_formAdm = dummieAdm_gen.rdmAvatar();
        }
        
        if (chkName && chkLastname && chkUsername && chkPhone && chkConfPass && chkDNI && chkEmail && chkActivity && chkBorndate && chkSingdate && chkAvatar) {
            born = new DateO(main_Admin.DC_formAdm_borndate.getCalendar());
            sing = new DateO(main_Admin.DC_formAdm_singdate.getCalendar());
            adm = new Admin(singletonAdmin.PATH_formAdm, born, main_Admin.txtf_formAdm_dni.getText(), main_Admin.txtf_formAdm_email.getText(), main_Admin.txtf_formAdm_phone.getText(), main_Admin.txtf_formAdm_name.getText(), main_Admin.txtf_formAdm_lastname.getText(), singletonAdmin.passwd_formAdm, ((String) main_Admin.CB_formAdm_state.getSelectedItem()), main_Admin.txtf_formAdm_username.getText(), Integer.parseInt(main_Admin.txt_formAdm_activity.getText()), sing);
            singletonAdmin.ephemeralAdmin = adm;
            valid = true;
        }
        else{
            error = LanguageAdm.getInstance().getProperty("err_createAdm") + "\n";
            
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
            main_Admin.lblMainform.setToolTipText(error);
            main_Admin.lblMainform.setOpaque(true);
            main_Admin.lblMainform.setBackground(Color.red);
            main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("error"));
        }
        return valid;
    }

    public static void formNew() {

        main_Admin.txt_formAdm_activity.setEnabled(true);
        main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txt_formAdm_activity.setBackground( Color.white);
        main_Admin.txt_formAdm_activity.setBorder(null);
        main_Admin.txt_formAdm_activity.setText("0");
        main_Admin.lbl_formAdm_activityERR.setText(" ");

        main_Admin.btn_formA_Avatar.setEnabled(true);
        main_Admin.lbl_formAdm_photoavatar.setText("");
        
        main_Admin.DC_formAdm_borndate.setDate(null);
        main_Admin.lbl_formAdm_borndateERR.setText(" ");
        
        main_Admin.txtf_formAdm_dni.setEnabled(true);
        main_Admin.txtf_formAdm_dni.setBackground( Color.white);
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_dni.setText(LanguageAdm.getInstance().getProperty("new_dni"));
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.lbl_formAdm_dniERR.setText(" ");

        main_Admin.txtf_formAdm_email.setEnabled(true);
        main_Admin.txtf_formAdm_email.setBackground( Color.white);
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_email.setText(LanguageAdm.getInstance().getProperty("new_email"));
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setEnabled(true);
        main_Admin.txtf_formAdm_lastname.setBackground( Color.white);
        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_lastname.setText(LanguageAdm.getInstance().getProperty("new_lastName"));
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        
        main_Admin.lblMainform.setBackground( Color.white);
        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("new_titleCreate"));
        main_Admin.lblMainform.setToolTipText("");
        main_Admin.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        
        main_Admin.txtf_formAdm_name.setEnabled(true);
        main_Admin.txtf_formAdm_name.setBackground( Color.white);
        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_name.setText(LanguageAdm.getInstance().getProperty("new_name"));
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setEnabled(true);
        main_Admin.JPF_fromAdm_pass.setBackground( Color.white);
        main_Admin.JPF_fromAdm_pass.setText("");
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.JPF_fromAdm_pass.setEchoChar('*');
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setEnabled(true);
        main_Admin.JPF_fromAdm_passconf.setBackground( Color.white);
        main_Admin.JPF_fromAdm_passconf.setText("");
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.JPF_fromAdm_passconf.setEchoChar('*');
        main_Admin.lbl_formAdm_passconfERR.setText(" ");

        main_Admin.txtf_formAdm_phone.setEnabled(true);
        main_Admin.txtf_formAdm_phone.setBackground( Color.white);
        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_phone.setText(LanguageAdm.getInstance().getProperty("new_phone"));
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.lbl_formAdm_photoavatar.setIcon(null);

        main_Admin.DC_formAdm_singdate.setDate(null);
        main_Admin.lbl_formAdm_singdateERR.setText(" ");

        main_Admin.txtf_formAdm_username.setEnabled(true);
        main_Admin.txtf_formAdm_username.setBackground( Color.white);
        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_username.setText(LanguageAdm.getInstance().getProperty("new_userName"));
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");

        main_Admin.btn_formAdmBack.setBackground( Color.lightGray);
        main_Admin.btn_formAdmBack.setVisible(true);
        main_Admin.btn_formAdmBack.setText(LanguageAdm.getInstance().getProperty("DRW_btnBack"));
        main_Admin.btn_formAdm_Create.setBackground( Color.lightGray);
        main_Admin.btn_formAdm_Create.setVisible(true);
        main_Admin.btn_formAdm_Create.setText(LanguageAdm.getInstance().getProperty("new_BTMcreate"));
        
        main_Admin.lbl_form_salary.setText("");
        main_Admin.lbl_form_benefit.setText("");
        
        main_Admin.PNL_drawForm.setBackground(Color.lightGray);
        main_Admin.PNL_drawForm.setVisible(true);
        main_Admin.txtf_formAdm_username.requestFocus();
        main_Admin.txtf_formAdm_username.selectAll();
    }

    public static void forModifyAdmin() {
        main_Admin.txt_formAdm_activity.setText(Integer.toString(singletonAdmin.ephemeralAdmin.getActivity()));
        main_Admin.txt_formAdm_activity.setBorder(null);
        main_Admin.txt_formAdm_activity.setBackground(Color.white);
        main_Admin.txt_formAdm_activity.setEnabled(true);
        main_Admin.txt_formAdm_activity.setToolTipText(""+singletonAdmin.ephemeralAdmin.getActivity());
        main_Admin.lbl_formAdm_activityERR.setText("");

        main_Admin.btn_formA_Avatar.setEnabled(true);
        main_Admin.btn_formA_Avatar.setVisible(true);
        try {
            main_Admin.lbl_formAdm_photoavatar.setIcon(new ImageIcon(singletonAdmin.ephemeralAdmin.getAvataring()));
        } catch (Exception e) {
            main_Admin.btn_formA_Avatar.setToolTipText("Imposible cargar im·gen");//err_avatar
        }
        
        main_Admin.DC_formAdm_borndate.setCalendar(singletonAdmin.ephemeralAdmin.getBorn_date().toCalendar());
        main_Admin.lbl_formAdm_borndateERR.setToolTipText("");
        main_Admin.lbl_formAdm_borndateERR.setText("");
        
        main_Admin.btn_formAdm_Create.setText(LanguageAdm.getInstance().getProperty("new_BTMmodify"));
        
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_dni.setText(singletonAdmin.ephemeralAdmin.getDni());
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.txtf_formAdm_dni.setToolTipText("");
        main_Admin.txtf_formAdm_dni.setEnabled(true);
        main_Admin.txtf_formAdm_dni.setBackground(Color.white);
        main_Admin.lbl_formAdm_dniERR.setText(" ");
        
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_email.setText(singletonAdmin.ephemeralAdmin.getEmail());
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.txtf_formAdm_email.setToolTipText("");
        main_Admin.txtf_formAdm_email.setEnabled(true);
        main_Admin.txtf_formAdm_email.setBackground(Color.white);
        main_Admin.lbl_formAdm_emailERR.setText("");

        main_Admin.CB_formAdm_state.setSelectedItem(singletonAdmin.ephemeralAdmin.getState());
        
        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_lastname.setText(singletonAdmin.ephemeralAdmin.getLastname());
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.txtf_formAdm_lastname.setToolTipText("");
        main_Admin.txtf_formAdm_lastname.setEnabled(true);
        main_Admin.txtf_formAdm_lastname.setBackground(Color.white);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("new_titleModify"));
        main_Admin.lblMainform.setToolTipText("");

        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_name.setText(singletonAdmin.ephemeralAdmin.getName());
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.txtf_formAdm_name.setToolTipText("");
        main_Admin.txtf_formAdm_name.setEnabled(true);
        main_Admin.txtf_formAdm_name.setBackground(Color.white);
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.JPF_fromAdm_pass.setEnabled(true);
        main_Admin.JPF_fromAdm_pass.setToolTipText("");
        main_Admin.JPF_fromAdm_pass.setBackground(Color.white);
        main_Admin.JPF_fromAdm_pass.setEchoChar((char) 0);
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.JPF_fromAdm_passconf.setEnabled(true);
        main_Admin.JPF_fromAdm_passconf.setToolTipText("");
        main_Admin.JPF_fromAdm_passconf.setBackground(Color.white);
        main_Admin.JPF_fromAdm_passconf.setEchoChar((char) 0);
        main_Admin.lbl_formAdm_passconfERR.setText(" ");

        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_phone.setText(singletonAdmin.ephemeralAdmin.getMovile());
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.txtf_formAdm_phone.setEnabled(true);
        main_Admin.txtf_formAdm_phone.setBackground(Color.white);
        main_Admin.txtf_formAdm_phone.setToolTipText("");
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.DC_formAdm_singdate.setCalendar(singletonAdmin.ephemeralAdmin.getContract_data().toCalendar());
        main_Admin.lbl_formAdm_singdateERR.setText(" ");

        main_Admin.CB_formAdm_state.setSelectedItem(singletonAdmin.ephemeralAdmin.getState());
        
        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_username.setText(singletonAdmin.ephemeralAdmin.getUser());
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.txtf_formAdm_username.setEnabled(true);
        main_Admin.txtf_formAdm_username.setToolTipText("");
        main_Admin.txtf_formAdm_username.setBackground(Color.white);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");
        
        main_Admin.lbl_form_salary.setText("");
        main_Admin.lbl_form_benefit.setText("");
        
        main_Admin.btn_formAdmBack.setBackground( Color.lightGray);
        main_Admin.btn_formAdmBack.setVisible(true);
        main_Admin.btn_formAdmBack.setText(LanguageAdm.getInstance().getProperty("DRW_btnBack"));
        main_Admin.btn_formAdm_Create.setEnabled(true);
        main_Admin.btn_formAdm_Create.setVisible(true);
        main_Admin.btn_formAdm_Create.setText(LanguageAdm.getInstance().getProperty("new_BTMmodify"));
        main_Admin.PNL_drawForm.setBackground(null);
        main_Admin.PNL_drawForm.setVisible(true);
        main_Admin.txtf_formAdm_username.requestFocus();
        main_Admin.txtf_formAdm_username.selectAll();
    }

    /**
     * Draw the View Admin form
     */
    public static void formViewAdmin() {
        main_Admin.txt_formAdm_activity.setEnabled(false);
        main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txt_formAdm_activity.setBackground( new Color(0,0,0,0));
        main_Admin.txt_formAdm_activity.setText(Integer.toString(singletonAdmin.ephemeralAdmin.getActivity()));
        main_Admin.txt_formAdm_activity.setToolTipText("");
        main_Admin.txt_formAdm_activity.setBorder(null);

        try {
            main_Admin.lbl_formAdm_photoavatar.setIcon(new ImageIcon(singletonAdmin.ephemeralAdmin.getAvataring()));
        } catch (Exception e) {
            main_Admin.btn_formA_Avatar.setToolTipText("Imposible cargar im·gen");
        }
        
        main_Admin.DC_formAdm_borndate.setCalendar(singletonAdmin.ephemeralAdmin.getBorn_date().toCalendar());
        main_Admin.lbl_formAdm_borndateERR.setText("");
        main_Admin.lbl_formAdm_borndateERR.setToolTipText("");
        
        
        main_Admin.txtf_formAdm_dni.setEnabled(false);
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txtf_formAdm_dni.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_dni.setText(singletonAdmin.ephemeralAdmin.getDni());
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.txtf_formAdm_dni.setToolTipText("");
        main_Admin.lbl_formAdm_dniERR.setText(" ");
        
        main_Admin.txtf_formAdm_email.setEnabled(false);
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txtf_formAdm_email.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_email.setText(singletonAdmin.ephemeralAdmin.getEmail());
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.txtf_formAdm_email.setToolTipText("");
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setEnabled(false);
        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txtf_formAdm_lastname.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_lastname.setText(singletonAdmin.ephemeralAdmin.getLastname());
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.txtf_formAdm_lastname.setToolTipText("");
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText("Ficha");
        main_Admin.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 14));
        main_Admin.lblMainform.setToolTipText("");

        main_Admin.txtf_formAdm_name.setEnabled(false);
        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txtf_formAdm_name.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_name.setText(singletonAdmin.ephemeralAdmin.getName());
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.txtf_formAdm_name.setToolTipText("");
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setBackground( new Color(0,0,0,0));
        main_Admin.JPF_fromAdm_pass.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.JPF_fromAdm_pass.setToolTipText("");
        main_Admin.JPF_fromAdm_pass.setEchoChar('*');
        main_Admin.lbl_formAdm_passERR.setText(" ");
        main_Admin.lbl_formAdm_passERR.setToolTipText("");
        
        main_Admin.JPF_fromAdm_passconf.setBackground( new Color(0,0,0,0));
        main_Admin.JPF_fromAdm_passconf.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.JPF_fromAdm_passconf.setEchoChar('*');
        main_Admin.JPF_fromAdm_passconf.setToolTipText("");
        main_Admin.lbl_formAdm_passconfERR.setText(" ");
        main_Admin.lbl_formAdm_passconfERR.setToolTipText("");
        
        main_Admin.txtf_formAdm_phone.setEnabled(false);
        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_phone.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_phone.setText(format.formPhone(singletonAdmin.ephemeralAdmin.getMovile()));
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.txtf_formAdm_phone.setToolTipText("");
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.DC_formAdm_singdate.setCalendar(singletonAdmin.ephemeralAdmin.getContract_data().toCalendar());
        main_Admin.lbl_formAdm_singdateERR.setText(" ");
        main_Admin.lbl_formAdm_singdateERR.setToolTipText("");

        main_Admin.txtf_formAdm_username.setEnabled(false);
        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Serif", 0, 14));
        main_Admin.txtf_formAdm_username.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_username.setText(singletonAdmin.ephemeralAdmin.getUser());
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.txtf_formAdm_username.setToolTipText("");
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");
        
        main_Admin.lbl_form_salary.setText(LanguageAdm.getInstance().getProperty("view_salary") + " -> " + format.formMoneyOut(singletonAdmin.ephemeralAdmin.getSalary()) );//formato
        main_Admin.lbl_form_salary.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.lbl_form_benefit.setText(LanguageAdm.getInstance().getProperty("view_benefit")+ " -> " + Float.toString(singletonAdmin.ephemeralAdmin.getBenefit()));
        main_Admin.lbl_form_benefit.setFont(new java.awt.Font("Serif", 1, 14));
        
        main_Admin.btn_formAdmBack.setBackground( Color.lightGray);
        main_Admin.btn_formAdmBack.setVisible(true);
        main_Admin.btn_formAdmBack.setText(LanguageAdm.getInstance().getProperty("DRW_btnBack"));
        main_Admin.btn_formA_Avatar.setEnabled(false);
        main_Admin.btn_formAdm_Create.setVisible(false);
        main_Admin.btn_formAdmBack.setBackground(new Color(0,0,0,0));
        main_Admin.PNL_drawForm.setVisible(true);
        main_Admin.PNL_drawForm.setBackground(Color.WHITE);
        
        main_Admin.CB_formAdm_state.setSelectedItem(singletonAdmin.ephemeralAdmin.getState());
    }
    
    /**
     * askName function check if the main_Admin.txtf_formAdm_name text field is
     * valid
     *
     *
     * @return
     */
    public static boolean askName() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_name.getText().isEmpty()) {
            main_Admin.txtf_formAdm_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_name.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_name"));
            main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_nameERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setForeground(Color.red);
        } else if (!validate.LettersOnly(main_Admin.txtf_formAdm_name.getText())) {
            main_Admin.txtf_formAdm_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_name.setToolTipText("SÛlo lÈtras");
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setText(LanguageAdm.getInstance().getProperty("error"));
        } else {
            main_Admin.txtf_formAdm_name.setBorder(null);
            main_Admin.txtf_formAdm_name.setToolTipText("");
            main_Admin.lbl_formAdm_nameERR.setText("");
            valid = true;
        }
        return valid;
    }

    /**
     * askLastname function check if the main_Admin.txtf_formAdm_lastname text
     * field is valid
     *
     *
     * @return
     */
    public static boolean askLastname() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_lastname.getText().isEmpty()) {
            main_Admin.txtf_formAdm_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_lastName"));
            main_Admin.lbl_formAdm_lastnameERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_lastnameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersOnly(main_Admin.txtf_formAdm_lastname.getText())) {
            main_Admin.txtf_formAdm_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_letters"));
            main_Admin.lbl_formAdm_lastnameERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_lastname.setBorder(null);
            main_Admin.lbl_formAdm_lastnameERR.setText("");
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_letters"));
            valid = true;
        }
        return valid;
    }

    /**
     * askUsername function check if the main_Admin.txtf_formAdm_username text
     * field is valid
     *
     *
     * @return
     */
    public static boolean askUsername() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_username.getText().isEmpty()) {
            main_Admin.txtf_formAdm_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_username.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_userName"));
            main_Admin.lbl_formAdm_lusernameERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lusernameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_Admin.txtf_formAdm_username.getText())) {
            main_Admin.txtf_formAdm_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_username.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_letters"));
            main_Admin.lbl_formAdm_lusernameERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lusernameERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_username.setBorder(null);
            main_Admin.txtf_formAdm_username.setToolTipText("");
            main_Admin.lbl_formAdm_lusernameERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askPhone() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_phone.getText().isEmpty()) {
            main_Admin.txtf_formAdm_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_phone.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_phone"));
            main_Admin.lbl_formAdm_phoneERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_phoneERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_phoneERR.setForeground(Color.red);
        } else if (!validate.Phone(main_Admin.txtf_formAdm_phone.getText())) {
            main_Admin.txtf_formAdm_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_phone.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_phone"));
            main_Admin.lbl_formAdm_phoneERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_phoneERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_phone.setBorder(null);
            main_Admin.txtf_formAdm_phone.setToolTipText("");
            main_Admin.lbl_formAdm_phoneERR.setText("");
            valid = true;
        }
        return valid;

    }

    public static boolean askPassword() {
        boolean valid = false;
        String pass = "";
        for (int i = 0; i < main_Admin.JPF_fromAdm_pass.getPassword().length; i++) {
            if(main_Admin.JPF_fromAdm_pass.getPassword()[i] != '-'){
                pass += main_Admin.JPF_fromAdm_pass.getPassword()[i];
            }   
        }
        if (pass.equals("")) {
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passERR.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_pass"));
            main_Admin.lbl_formAdm_passERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_passERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passERR.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_pass"));
            main_Admin.lbl_formAdm_passERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else {
            main_Admin.JPF_fromAdm_pass.setBorder(null);
            main_Admin.lbl_formAdm_passERR.setToolTipText("");
            main_Admin.lbl_formAdm_passERR.setText("");
            askConfirmPassword();
            valid = true;
        }
        return valid;

    }

    public static boolean askConfirmPassword() {
        boolean valid = false;
        String pass = new String(main_Admin.JPF_fromAdm_pass.getPassword());
        String conf_pass = new String(main_Admin.JPF_fromAdm_passconf.getPassword());

        if (pass.equals("")) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_pass"));
            main_Admin.lbl_formAdm_passconfERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_pass"));
            main_Admin.lbl_formAdm_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passconfERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!pass.equals(conf_pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_confPass"));
            main_Admin.lbl_formAdm_passconfERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);

        } else {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText("");
            main_Admin.lbl_formAdm_passconfERR.setText("");
            main_Admin.lbl_formAdm_passERR.setText("");
            singletonAdmin.passwd_formAdm = pass;
            valid = true;

        }
        return valid;
    }

    public static boolean askDNI() {
        boolean valid = false;
        String dni ="";
        Character dnilet;
        main_Admin.lbl_formAdm_dniERR.setFont(new java.awt.Font("Dialog", 1, 12));
        
        
        if (main_Admin.txtf_formAdm_dni.getText().isEmpty()) {
            main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_dni.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_dni"));
            main_Admin.lbl_formAdm_dniERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
        } else {
            dni = main_Admin.txtf_formAdm_dni.getText();
            if(dni.length()>=9){
                if (dni.charAt(8) == '-') {
                    dnilet = dni.charAt(9);
                    dni = dni.substring(0, 8);
                    dni+=dnilet;
                }

                if (!validate.DNI(dni)) {
                    main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                    main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Admin.txtf_formAdm_dni.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_dni"));
                    main_Admin.lbl_formAdm_dniERR.setText(LanguageAdm.getInstance().getProperty("error"));
                    main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
                } else {
                    main_Admin.txtf_formAdm_dni.setBorder(null);
                    main_Admin.txtf_formAdm_dni.setToolTipText("");
                    main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                    main_Admin.lbl_formAdm_dniERR.setText("");
                    singletonAdmin.passModf = true;
                    valid = true;
                }
            }
            else{
                main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
                main_Admin.txtf_formAdm_dni.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_dni"));
                main_Admin.lbl_formAdm_dniERR.setText(LanguageAdm.getInstance().getProperty("error"));
                main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
            }
        }
        return valid;
    }

    public static boolean askEmail() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_email.getText().isEmpty()) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_email.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_email"));
            main_Admin.lbl_formAdm_emailERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_emailERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_emailERR.setForeground(Color.red);
        } else if (!validate.Email(main_Admin.txtf_formAdm_email.getText())) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_email.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_email"));
            main_Admin.lbl_formAdm_emailERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_emailERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_email.setBorder(null);
            main_Admin.lbl_formAdm_emailERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askActivity() {
        boolean valid = false;

        if (!validate.Float(main_Admin.txt_formAdm_activity.getText())) {
            main_Admin.txt_formAdm_activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txt_formAdm_activity.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_letters"));
            main_Admin.lbl_formAdm_activityERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_activityERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_activityERR.setForeground(Color.red);
        } else {
            main_Admin.txt_formAdm_activity.setBorder(null);
            main_Admin.txt_formAdm_activity.setToolTipText("");
            main_Admin.lbl_formAdm_activityERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askBorndate() {
        boolean valid = false;
        int day, month, year;
        DateO bornDate = new DateO("0/0/0000");

        try {
            bornDate = new DateO(main_Admin.DC_formAdm_borndate.getCalendar());

        } catch (Exception e) {
            main_Admin.DC_formAdm_borndate.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_bornDate"));
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_borndateERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_borndateERR.setForeground(Color.red);
            return valid;
        }
        if (!bornDate.isValid_workage()) {
            main_Admin.DC_formAdm_borndate.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_bornDate"));
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_borndateERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_borndateERR.setForeground(Color.red);
        } else {
            main_Admin.DC_formAdm_borndate.setToolTipText("");
            main_Admin.lbl_formAdm_borndateERR.setText("");
            singletonAdmin.born_date = bornDate;
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
            singDate = new DateO(main_Admin.DC_formAdm_singdate.getCalendar());
            bornDate = new DateO(main_Admin.DC_formAdm_borndate.getCalendar());

        } catch (Exception e) {
            main_Admin.DC_formAdm_singdate.setToolTipText(LanguageAdm.getInstance().getProperty("errAsk_bornDate"));
            main_Admin.lbl_formAdm_singdateERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_singdateERR.setForeground(Color.red);
            return valid;
        }
        if (!singDate.isValid_singdate(bornDate)) {
            main_Admin.DC_formAdm_borndate.setToolTipText(LanguageAdm.getInstance().getProperty("errVal_singDate"));
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_singdateERR.setText(LanguageAdm.getInstance().getProperty("error"));
            main_Admin.lbl_formAdm_singdateERR.setForeground(Color.red);
        } else {
            main_Admin.DC_formAdm_singdate.setToolTipText("");
            main_Admin.lbl_formAdm_singdateERR.setText("");
            singletonAdmin.born_date = bornDate;
            singletonAdmin.sing_date = singDate;
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
        int option = jfileChoose.showOpenDialog(main_Admin.btn_formA_Avatar);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = jfileChoose.getSelectedFile().getPath();
            main_Admin.lbl_formAdm_photoavatar.setIcon(new ImageIcon(file));
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
            main_Admin.lbl_formAdm_photoavatar.setIcon(newIcon);
            //Se cambia el tama√±o de la etiqueta
            main_Admin.lbl_formAdm_photoavatar.setSize(140, 170);
            //Guardo el Path en el singleton
            singletonAdmin.PATH_formAdm = file;
            valid=true;
        }

        return valid;
    }
    
    /**
     * Functions of Form Admin Panel
     */
    
    public static void DAO_FA_mainBack() {
        MainAdmin.dispose();
        new Controler_main(new main()).run();
    }

    public static void DAO_FA_hideFormPanel() {
        main_Admin.PNL_drawForm.setVisible(false);
    }

    /**
     * Clean Fields functions
     */
    public static void DAO_cfName() {
        if (main_Admin.txtf_formAdm_name.getText().equals(LanguageAdm.getInstance().getProperty("new_name"))) {
            main_Admin.txtf_formAdm_name.setText("");
            main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfLastName() {
        if (main_Admin.txtf_formAdm_lastname.getText().equals(LanguageAdm.getInstance().getProperty("new_lastName"))) {
            main_Admin.txtf_formAdm_lastname.setText("");
            main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfUserName() {
        if (main_Admin.txtf_formAdm_username.getText().equals(LanguageAdm.getInstance().getProperty("new_userName"))) {
            main_Admin.txtf_formAdm_username.setText("");
            main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfPhone() {
        if (main_Admin.txtf_formAdm_phone.getText().equals(LanguageAdm.getInstance().getProperty("new_phone"))) {
            main_Admin.txtf_formAdm_phone.setText("");
            main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfEmail() {
        if (main_Admin.txtf_formAdm_email.getText().equals(LanguageAdm.getInstance().getProperty("new_email"))) {
            main_Admin.txtf_formAdm_email.setText("");
            main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfDNI() {
        if (main_Admin.txtf_formAdm_dni.getText().equals(LanguageAdm.getInstance().getProperty("new_dni"))) {
            main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_dni.setText("");
        }
    }
    
    public static void DAO_cfPass(){
        main_Admin.JPF_fromAdm_pass.setText("");
        main_Admin.JPF_fromAdm_passconf.setText("");
    }

    public static void DAO_cfPassConf(){
        main_Admin.JPF_fromAdm_passconf.setText("");
    }
    
    /**
     * Error paint messages
     */
    
    public static void DAO_ERR_Modify(){
        main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("error"));
        main_Admin.lblMainform.setToolTipText(LanguageAdm.getInstance().getProperty("error_modify"));
        main_Admin.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_ERR_View(){
        main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("error"));
        main_Admin.lblMainform.setToolTipText(LanguageAdm.getInstance().getProperty("error_view"));
        main_Admin.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_OK_Modify(){
        main_Admin.lblMainform.setText(LanguageAdm.getInstance().getProperty("ok_modify"));
        main_Admin.lblMainform.setBackground(Color.green);
    }

}
