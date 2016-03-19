/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.DAO;

import framework.clss.DateO;
import framework.mod.nav.view.main;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.validate;
import framework.mod.user.admin.view.main_Admin;
import framework.tools.imageSaver;
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
public class DAO_Admin {
    public static final String ERROR = "Error";
    public static final String ERROR_CREATE = "Error en la creación de el Administrador\n";

    
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
        boolean chkName = askName(), chkLastname = askLastname(), chkUsername = askUsername(), chkPhone = askPhone(), chkConfPass = askConfirmPassword(), chkDNI = askDNI(), chkEmail = askEmail(), chkActivity = askActivity(), chkBorndate = askBorndate(), chkSingdate = askSingDate(), chkAvatar = false;

        if (!singletonAdmin.PATH_formAdm.equals("")) {
            chkAvatar = true;
        }

        if (chkName && chkLastname && chkUsername && chkPhone && chkConfPass && chkDNI && chkEmail && chkActivity && chkBorndate && chkSingdate && chkAvatar) {
            born = new DateO(main_Admin.DC_formAdm_borndate.getCalendar());
            sing = new DateO(main_Admin.DC_formAdm_singdate.getCalendar());
            adm = new Admin(singletonAdmin.PATH_formAdm, born, main_Admin.txtf_formAdm_dni.getText(), main_Admin.txtf_formAdm_email.getText(), main_Admin.txtf_formAdm_phone.getText(), main_Admin.txtf_formAdm_name.getText(), main_Admin.txtf_formAdm_lastname.getText(), singletonAdmin.passwd_formAdm, ((String) main_Admin.CB_formAdm_state.getSelectedItem()), main_Admin.txtf_formAdm_username.getText(), Integer.parseInt(main_Admin.txt_formAdm_activity.getText()), sing);
            singletonAdmin.ephemeralAdmin = adm;
            valid = true;
        }
        else{
            error = ERROR_CREATE;
            
            if(chkActivity){
                error+= "-Error actividad\n";
            }else if(chkAvatar){
                error+= "-Error avatar\n";
            }else if(chkBorndate){
                error+= "-Error en la fecha de nacimento\n";
            }else if(chkConfPass){
                error+= "-Error en la confirmación de la contraseño\n";
            }else if(chkDNI){
                error+= "-Error en el dni\n";
            }else if(chkEmail){
                error+= "-Error en el email\n";
            }else if(chkLastname){
                error+=  "-Error en los apellidos\n";
            }else if(chkName){
                error+=  "-Error en el nombre\n";
            }else if(chkPhone){
                error+=  "-Error en el teléfono\n";
            }else if(chkSingdate){
                error+= "-Error en la fecha de contratación\n";
            }else if(chkUsername){
                error+= "-Error en el nombre de usuario\n";
            }
            main_Admin.lblMainform.setText(error);
        }
        return valid;
    }

    public static void formNew() {

        main_Admin.txt_formAdm_activity.setEnabled(true);
        main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Dialog", 2, 12));
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
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_dni.setText("DNI...");
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.lbl_formAdm_dniERR.setText(" ");

        main_Admin.txtf_formAdm_email.setEnabled(true);
        main_Admin.txtf_formAdm_email.setBackground( Color.white);
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_email.setText("E-mail...");
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setEnabled(true);
        main_Admin.txtf_formAdm_lastname.setBackground( Color.white);
        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_lastname.setText("Apellidos...");
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        
        main_Admin.lblMainform.setBackground( Color.white);
        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText("Crear Admin");
        main_Admin.lblMainform.setToolTipText("");
        main_Admin.lblMainform.setFont(new java.awt.Font("Free Mono", 1, 24));
        
        main_Admin.txtf_formAdm_name.setEnabled(true);
        main_Admin.txtf_formAdm_name.setBackground( Color.white);
        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_name.setText("Nombre...");
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setEnabled(true);
        main_Admin.JPF_fromAdm_pass.setBackground( Color.white);
        main_Admin.JPF_fromAdm_pass.setText("");
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setEnabled(true);
        main_Admin.JPF_fromAdm_passconf.setBackground( Color.white);
        main_Admin.JPF_fromAdm_passconf.setText("");
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.lbl_formAdm_passconfERR.setText(" ");

        main_Admin.txtf_formAdm_phone.setEnabled(true);
        main_Admin.txtf_formAdm_phone.setBackground( Color.white);
        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_phone.setText("Teléfono...");
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.lbl_formAdm_photoavatar.setIcon(null);

        main_Admin.DC_formAdm_singdate.setDate(null);
        main_Admin.lbl_formAdm_singdateERR.setText(" ");

        main_Admin.txtf_formAdm_username.setEnabled(true);
        main_Admin.txtf_formAdm_username.setBackground( Color.white);
        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_username.setText("Nombre de usuario...");
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");

        main_Admin.btn_formAdmCreate_back.setBackground( Color.lightGray);
        main_Admin.btn_formAdmCreate_back.setVisible(true);
        main_Admin.btn_formAdmCreate_create.setEnabled(true);
        main_Admin.btn_formAdmCreate_create.setBackground( Color.lightGray);
        main_Admin.btn_formAdmCreate_create.setVisible(true);
        main_Admin.btn_formAdmCreate_create.setText("Crear");
        
        main_Admin.jPanel2.setBackground(Color.green);
        main_Admin.jPanel2.setVisible(true);
    }

    public static void forModifyAdmin() {
        main_Admin.txt_formAdm_activity.setText(Integer.toString(singletonAdmin.ephemeralAdmin.getActivity()));
        main_Admin.txt_formAdm_activity.setBorder(null);
        main_Admin.txt_formAdm_activity.setBackground(Color.white);
        main_Admin.txt_formAdm_activity.setEnabled(true);
        main_Admin.txt_formAdm_activity.setToolTipText("");
        main_Admin.lbl_formAdm_activityERR.setText("");

        main_Admin.btn_formA_Avatar.setEnabled(true);
        main_Admin.btn_formA_Avatar.setVisible(true);
        try {
            main_Admin.lbl_formAdm_photoavatar.setIcon(new ImageIcon(singletonAdmin.ephemeralAdmin.getAvataring()));
        } catch (Exception e) {
            main_Admin.btn_formA_Avatar.setToolTipText("Imposible cargar imágen");
        }
        
        main_Admin.DC_formAdm_borndate.setCalendar(singletonAdmin.ephemeralAdmin.getBorn_date().toCalendar());
        main_Admin.lbl_formAdm_borndateERR.setToolTipText("");
        main_Admin.lbl_formAdm_borndateERR.setText("");
        
        main_Admin.btn_formAdmCreate_create.setText("Modificar");
        
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
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_lastname.setText(singletonAdmin.ephemeralAdmin.getLastname());
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.txtf_formAdm_lastname.setToolTipText("");
        main_Admin.txtf_formAdm_lastname.setEnabled(true);
        main_Admin.txtf_formAdm_lastname.setBackground(Color.white);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText("Modificar Admin");
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
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.JPF_fromAdm_passconf.setEnabled(true);
        main_Admin.JPF_fromAdm_passconf.setBackground(Color.white);
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

        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_username.setText(singletonAdmin.ephemeralAdmin.getUser());
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.txtf_formAdm_username.setEnabled(true);
        main_Admin.txtf_formAdm_username.setToolTipText("");
        main_Admin.txtf_formAdm_username.setBackground(Color.white);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");
        
        main_Admin.btn_formAdmCreate_create.setEnabled(true);
        main_Admin.btn_formAdmCreate_create.setVisible(true);
        main_Admin.btn_formAdmCreate_back.setBackground(Color.red);
        main_Admin.jPanel2.setBackground(null);
        main_Admin.jPanel2.setVisible(true);

    }

    /**
     * Draw the View Admin form
     */
    public static void formViewAdmin() {
        main_Admin.txt_formAdm_activity.setEnabled(false);
        main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txt_formAdm_activity.setBackground( new Color(0,0,0,0));
        main_Admin.txt_formAdm_activity.setText(Integer.toString(singletonAdmin.ephemeralAdmin.getActivity()));
        main_Admin.txt_formAdm_activity.setToolTipText("");
        main_Admin.txt_formAdm_activity.setBorder(null);

        try {
            main_Admin.lbl_formAdm_photoavatar.setIcon(new ImageIcon(singletonAdmin.ephemeralAdmin.getAvataring()));
        } catch (Exception e) {
            main_Admin.btn_formA_Avatar.setToolTipText("Imposible cargar imágen");
        }
        
        main_Admin.DC_formAdm_borndate.setCalendar(singletonAdmin.ephemeralAdmin.getBorn_date().toCalendar());
        main_Admin.lbl_formAdm_borndateERR.setText("");
        main_Admin.lbl_formAdm_borndateERR.setToolTipText("");
        
        main_Admin.btn_formAdmCreate_create.setVisible(false);
        
        main_Admin.txtf_formAdm_dni.setEnabled(false);
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_dni.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_dni.setText(singletonAdmin.ephemeralAdmin.getDni());
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.txtf_formAdm_dni.setToolTipText("");
        main_Admin.lbl_formAdm_dniERR.setText(" ");
        
        main_Admin.txtf_formAdm_email.setEnabled(false);
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_email.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_email.setText(singletonAdmin.ephemeralAdmin.getEmail());
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.txtf_formAdm_email.setToolTipText("");
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setEnabled(false);
        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Serif", 1, 14));
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
        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_name.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_name.setText(singletonAdmin.ephemeralAdmin.getName());
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.txtf_formAdm_name.setToolTipText("");
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setBackground( new Color(0,0,0,0));
        main_Admin.JPF_fromAdm_pass.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.lbl_formAdm_passERR.setText(" ");
        main_Admin.lbl_formAdm_passERR.setToolTipText("");
        
        main_Admin.JPF_fromAdm_passconf.setBackground( new Color(0,0,0,0));
        main_Admin.JPF_fromAdm_passconf.setText(singletonAdmin.ephemeralAdmin.getPassword());
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.lbl_formAdm_passconfERR.setText(" ");
        main_Admin.lbl_formAdm_passconfERR.setToolTipText("");
        
        main_Admin.txtf_formAdm_phone.setEnabled(false);
        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_phone.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_phone.setText(singletonAdmin.ephemeralAdmin.getMovile());
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.txtf_formAdm_phone.setToolTipText("");
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.DC_formAdm_singdate.setCalendar(singletonAdmin.ephemeralAdmin.getContract_data().toCalendar());
        main_Admin.lbl_formAdm_singdateERR.setText(" ");
        main_Admin.lbl_formAdm_singdateERR.setToolTipText("");

        main_Admin.txtf_formAdm_username.setEnabled(false);
        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Serif", 1, 14));
        main_Admin.txtf_formAdm_username.setBackground( new Color(0,0,0,0));
        main_Admin.txtf_formAdm_username.setText(singletonAdmin.ephemeralAdmin.getUser());
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.txtf_formAdm_username.setToolTipText("");
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");
        
        main_Admin.btn_formA_Avatar.setEnabled(false);
        main_Admin.btn_formAdmCreate_back.setBackground(new Color(0,0,0,0));
        main_Admin.jPanel2.setVisible(true);
        main_Admin.jPanel2.setBackground(Color.WHITE);
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
            main_Admin.txtf_formAdm_name.setToolTipText("Nómbre necesario");
            main_Admin.lbl_formAdm_nameERR.setText(ERROR);
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setForeground(Color.red);
        } else if (!validate.LettersOnly(main_Admin.txtf_formAdm_name.getText())) {
            main_Admin.txtf_formAdm_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_name.setToolTipText("Sólo létras");
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setText(ERROR);
        } else {
            main_Admin.txtf_formAdm_name.setBorder(null);
            main_Admin.txtf_formAdm_name.setToolTipText("Correcto!");
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
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText("Apellido necesario");
            main_Admin.lbl_formAdm_lastnameERR.setText(ERROR);
            main_Admin.lbl_formAdm_lastnameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersOnly(main_Admin.txtf_formAdm_lastname.getText())) {
            main_Admin.txtf_formAdm_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText("Sólo létras");
            main_Admin.lbl_formAdm_lastnameERR.setText(ERROR);
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_lastname.setBorder(null);
            main_Admin.lbl_formAdm_lastnameERR.setText("Correcto!");
            main_Admin.lbl_formAdm_lastnameERR.setToolTipText("Sólo létras");
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
            main_Admin.txtf_formAdm_username.setToolTipText("Nombre de usuario necesario");
            main_Admin.lbl_formAdm_lusernameERR.setText(ERROR);
            main_Admin.lbl_formAdm_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lusernameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_Admin.txtf_formAdm_username.getText())) {
            main_Admin.txtf_formAdm_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_username.setToolTipText("Sólo letras");
            main_Admin.lbl_formAdm_lusernameERR.setText(ERROR);
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
            main_Admin.txtf_formAdm_phone.setToolTipText("Teléfono necesario");
            main_Admin.lbl_formAdm_phoneERR.setText(ERROR);
            main_Admin.lbl_formAdm_phoneERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_phoneERR.setForeground(Color.red);
        } else if (!validate.Phone(main_Admin.txtf_formAdm_phone.getText())) {
            main_Admin.txtf_formAdm_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txtf_formAdm_phone.setToolTipText("Teléfono no válido");
            main_Admin.lbl_formAdm_phoneERR.setText(ERROR);
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
            main_Admin.lbl_formAdm_passERR.setToolTipText("Contraseña requerida");
            main_Admin.lbl_formAdm_passERR.setText(ERROR);
            main_Admin.lbl_formAdm_passERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passERR.setToolTipText("Debe contener minimo 8 caractéres, minúsculas, mayúsculas y números");
            main_Admin.lbl_formAdm_passERR.setText(ERROR);
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else {
            main_Admin.JPF_fromAdm_pass.setBorder(null);
            main_Admin.lbl_formAdm_passERR.setToolTipText("");
            main_Admin.lbl_formAdm_passERR.setText("");
            //singletonU.passwd_formAdm = pass;
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
            main_Admin.JPF_fromAdm_passconf.setToolTipText("Debe contener minimo 8 caractéres, minúscula, mayúsculas, números y carácteres especiales");
            main_Admin.lbl_formAdm_passconfERR.setText(ERROR);
            main_Admin.lbl_formAdm_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText("Contraseña no válida");
            main_Admin.lbl_formAdm_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passconfERR.setText(ERROR);
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!pass.equals(conf_pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText("Las contraseñas no coinciden");
            main_Admin.lbl_formAdm_passconfERR.setText(ERROR);
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);

        } else {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.JPF_fromAdm_passconf.setToolTipText("");
            main_Admin.lbl_formAdm_passconfERR.setText("");
            main_Admin.lbl_formAdm_passERR.setText("");
            valid = true;

        }
        return valid;
    }

    public static boolean askDNI() {
        boolean valid = false;
        String dni ="";
        Character dnilet;
        if (main_Admin.txtf_formAdm_dni.getText().isEmpty()) {
            main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_dni.setToolTipText("DNI necesario");
            main_Admin.lbl_formAdm_dniERR.setText(ERROR);
            main_Admin.lbl_formAdm_dniERR.setFont(new java.awt.Font("Dialog", 1, 12));
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
                    main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 1, 12));
                    main_Admin.txtf_formAdm_dni.setToolTipText("DNI no válido");
                    main_Admin.lbl_formAdm_dniERR.setText(ERROR);
                    main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
                } else {
                    main_Admin.txtf_formAdm_dni.setBorder(null);
                    main_Admin.txtf_formAdm_dni.setToolTipText("");
                    main_Admin.lbl_formAdm_dniERR.setText("");
                    valid = true;
                }
            }
            else{
                main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
                main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 1, 12));
                main_Admin.txtf_formAdm_dni.setToolTipText("DNI no válido");
                main_Admin.lbl_formAdm_dniERR.setText("");
                main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
            }
        }
        return valid;
    }

    public static boolean askEmail() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_email.getText().isEmpty()) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_emailERR.setText("Correo electriónico necesario");
            main_Admin.lbl_formAdm_emailERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_emailERR.setForeground(Color.red);
        } else if (!validate.Email(main_Admin.txtf_formAdm_email.getText())) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_emailERR.setText("Correo electriónico no valido");
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

        if (!validate.Numbers(main_Admin.txt_formAdm_activity.getText())) {
            main_Admin.txt_formAdm_activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txt_formAdm_activity.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.txt_formAdm_activity.setToolTipText("Teléfono no válido");
            main_Admin.lbl_formAdm_activityERR.setText(ERROR);
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
            main_Admin.DC_formAdm_borndate.setToolTipText("Fecha errónea");
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_borndateERR.setForeground(Color.red);
            return valid;
        }
        if (!bornDate.isValid_workage()) {
            main_Admin.DC_formAdm_borndate.setToolTipText("Fecha de nacimento no válida");
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_borndateERR.setText(ERROR);
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
            main_Admin.lbl_formAdm_singdateERR.setToolTipText("ERROR en la fecha introducida");
            main_Admin.lbl_formAdm_singdateERR.setText(ERROR);
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_singdateERR.setForeground(Color.red);
            return valid;
        }
        if (!singDate.isValid_singdate(bornDate)) {
            main_Admin.DC_formAdm_borndate.setToolTipText("Fecha de contratación no válida");
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_singdateERR.setText(ERROR);
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
            //Se modifica su tamaÃ±o
            Image newimg = img.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            imageSaver.SaveImage(file);
            //Se coloca el nuevo icono modificado
            main_Admin.lbl_formAdm_photoavatar.setIcon(newIcon);
            //Se cambia el tamaÃ±o de la etiqueta
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
        new main().setVisible(true);
    }

    public static void DAO_FA_hideFormPanel() {
        main_Admin.jPanel2.setVisible(false);
    }

    /**
     * Clean Fields functions
     */
    public static void DAO_cfName() {
        if (main_Admin.txtf_formAdm_name.getText().equals("Nombre...")) {
            main_Admin.txtf_formAdm_name.setText("");
            main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfLastName() {
        if (main_Admin.txtf_formAdm_lastname.getText().equals("Apellidos...")) {
            main_Admin.txtf_formAdm_lastname.setText("");
            main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfUserName() {
        if (main_Admin.txtf_formAdm_username.getText().equals("Nombre de usuario...")) {
            main_Admin.txtf_formAdm_username.setText("");
            main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfPhone() {
        if (main_Admin.txtf_formAdm_phone.getText().equals("Teléfono...")) {
            main_Admin.txtf_formAdm_phone.setText("");
            main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfEmail() {
        if (main_Admin.txtf_formAdm_email.getText().equals("E-mail...")) {
            main_Admin.txtf_formAdm_email.setText("");
            main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
        }
    }

    public static void DAO_cfDNI() {
        if (main_Admin.txtf_formAdm_dni.getText().equals("DNI...")) {
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
        main_Admin.lblMainform.setText("Error!!");
        main_Admin.lblMainform.setToolTipText("Error al modificar el administrador");
        main_Admin.lblMainform.setBackground(Color.red);
    }
    
    public static void DAO_OK_Modify(){
        main_Admin.lblMainform.setText("Modificado");
        main_Admin.lblMainform.setBackground(Color.green);
    }
}
