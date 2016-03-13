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
import framework.mod.user.model.clss.singletonU;
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

    public static void formNew() {

        main_Admin.txt_formAdm_activity.setBorder(null);
        main_Admin.txt_formAdm_activity.setText("0");
        main_Admin.lbl_formAdm_activityERR.setText(" ");

        main_Admin.DC_formAdm_borndate.setDate(null);
        main_Admin.lbl_formAdm_borndateERR.setText(" ");
        
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_dni.setText("DNI...");
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.lbl_formAdm_dniERR.setText(" ");

        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_email.setText("E-mail...");
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_lastname.setText("Apellidos...");
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText("Crear Admin");
        
        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_name.setText("Nombre...");
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setText("");
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setText("");
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.lbl_formAdm_passconfERR.setText(" ");

        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_phone.setText("Teléfono...");
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.lbl_formAdm_photoavatar.setIcon(null);

        main_Admin.DC_formAdm_singdate.setDate(null);
        main_Admin.lbl_formAdm_singdateERR.setText(" ");

        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 2, 12));
        main_Admin.txtf_formAdm_username.setText("Nombre de usuario...");
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");

        main_Admin.btn_formAdmCreate_back.setVisible(true);
        main_Admin.btn_formAdmCreate_create.setVisible(true);
        main_Admin.jPanel2.setVisible(true);
    }

    public static void forModifyAdmin(Admin adm) {
        main_Admin.txt_formAdm_activity.setText(Integer.toString(adm.getActivity()));
        main_Admin.txt_formAdm_activity.setBorder(null);

        main_Admin.DC_formAdm_borndate.setCalendar(adm.getBorn_date().toCalendar());
        main_Admin.lbl_formAdm_borndateERR.setText("");
        
        main_Admin.btn_formAdmCreate_create.setText("Modificar");
        
        main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_dni.setText(adm.getDni());
        main_Admin.txtf_formAdm_dni.setBorder(null);
        main_Admin.lbl_formAdm_dniERR.setText(" ");
        
        main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_email.setText(adm.getEmail());
        main_Admin.txtf_formAdm_email.setBorder(null);
        main_Admin.lbl_formAdm_emailERR.setText(" ");

        main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_lastname.setText(adm.getLastname());
        main_Admin.txtf_formAdm_lastname.setBorder(null);
        main_Admin.lbl_formAdm_lastnameERR.setText(" ");

        main_Admin.lblMainform.setOpaque(false);
        main_Admin.lblMainform.setText("Modificar Admin");

        main_Admin.txtf_formAdm_name.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_name.setText(adm.getName());
        main_Admin.txtf_formAdm_name.setBorder(null);
        main_Admin.lbl_formAdm_nameERR.setText(" ");

        main_Admin.JPF_fromAdm_pass.setText(adm.getPassword());
        main_Admin.JPF_fromAdm_pass.setBorder(null);
        main_Admin.lbl_formAdm_passERR.setText(" ");

        main_Admin.JPF_fromAdm_passconf.setText("");
        main_Admin.JPF_fromAdm_passconf.setBorder(null);
        main_Admin.lbl_formAdm_passconfERR.setText(" ");

        main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_phone.setText(adm.getMovile());
        main_Admin.txtf_formAdm_phone.setBorder(null);
        main_Admin.lbl_formAdm_phoneERR.setText(" ");

        main_Admin.DC_formAdm_singdate.setCalendar(adm.getContract_data().toCalendar());
        main_Admin.lbl_formAdm_singdateERR.setText(" ");

        main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
        main_Admin.txtf_formAdm_username.setText(adm.getUser());
        main_Admin.txtf_formAdm_username.setBorder(null);
        main_Admin.lbl_formAdm_lusernameERR.setText(" ");

        main_Admin.jPanel2.setVisible(true);

    }

    /**
     *
     * @return
     */
    public static boolean createAdmin() {
        Admin adm = new Admin();
        DateO born = new DateO();
        DateO sing = new DateO();
        boolean valid = false;
        boolean chkName = askName(), chkLastname = askLastname(), chkUsername = askUsername(), chkPhone = askPhone(), chkConfPass = askConfirmPassword(), chkDNI = askDNI(), chkEmail = askEmail(), chkActivity = askActivity(), chkBorndate = askBorndate(), chkSingdate = askSingDate(), chkAvatar = false;

        if (!singletonU.PATH_formAdm.equals("")) {
            chkAvatar = true;
        }

        if (chkName && chkLastname && chkUsername && chkPhone && chkConfPass && chkDNI && chkEmail && chkActivity && chkBorndate && chkSingdate && chkAvatar) {
            born = new DateO(main_Admin.DC_formAdm_borndate.getCalendar());
            sing = new DateO(main_Admin.DC_formAdm_singdate.getCalendar());
            adm = new Admin(singletonU.PATH_formAdm, born, main_Admin.txtf_formAdm_dni.getText(), main_Admin.txtf_formAdm_email.getText(), main_Admin.txtf_formAdm_phone.getText(), main_Admin.txtf_formAdm_name.getText(), main_Admin.txtf_formAdm_lastname.getText(), singletonU.passwd_formAdm, ((String) main_Admin.CB_formAdm_state.getSelectedItem()), main_Admin.txtf_formAdm_username.getText(), Integer.parseInt(main_Admin.txt_formAdm_activity.getText()), sing);
            singletonAdmin.ephemeralAdmin = adm;
            valid = true;
        } 
        return valid;
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
            main_Admin.lbl_formAdm_nameERR.setText("Nombre necesario");
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setForeground(Color.red);
        } else if (!validate.LettersOnly(main_Admin.txtf_formAdm_name.getText())) {
            main_Admin.txtf_formAdm_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_nameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_nameERR.setText("Sólo letras");

        } else {

            main_Admin.txtf_formAdm_name.setBorder(null);
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
            main_Admin.lbl_formAdm_lastnameERR.setText("Apellido necesario");
            main_Admin.lbl_formAdm_lastnameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersOnly(main_Admin.txtf_formAdm_lastname.getText())) {
            main_Admin.txtf_formAdm_lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_lastname.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_lastnameERR.setText("Sólo letras");
            main_Admin.lbl_formAdm_lastnameERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_lastname.setBorder(null);
            main_Admin.lbl_formAdm_lastnameERR.setText("");
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
            main_Admin.lbl_formAdm_lusernameERR.setText("Nombre de usuario necesario");
            main_Admin.lbl_formAdm_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lusernameERR.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_Admin.txtf_formAdm_username.getText())) {
            main_Admin.txtf_formAdm_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_username.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_lusernameERR.setText("Sólo letras");
            main_Admin.lbl_formAdm_lusernameERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_lusernameERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_username.setBorder(null);
            main_Admin.lbl_formAdm_lusernameERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askPhone() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_phone.getText().isEmpty()) {
            main_Admin.txtf_formAdm_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_phoneERR.setText("Teléfono necesario");
            main_Admin.lbl_formAdm_phoneERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_phoneERR.setForeground(Color.red);
        } else if (!validate.Phone(main_Admin.txtf_formAdm_phone.getText())) {
            main_Admin.txtf_formAdm_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_phone.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_phoneERR.setText("Teléfono no valido");
            main_Admin.lbl_formAdm_phoneERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_phone.setBorder(null);
            main_Admin.lbl_formAdm_phoneERR.setText("");
            valid = true;
        }
        return valid;

    }

    public static boolean askPassword() {
        boolean valid = false;
        String pass = "";
        for (int i = 0; i < main_Admin.JPF_fromAdm_pass.getPassword().length; i++) {
            pass += main_Admin.JPF_fromAdm_pass.getPassword()[i];
        }

        if (pass.equals("")) {
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passERR.setText("Minusculas, mayúsusculas y números");
            main_Admin.lbl_formAdm_passERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passERR.setText("Contraseña no valida");
            main_Admin.lbl_formAdm_passERR.setForeground(Color.red);
        } else {
            main_Admin.JPF_fromAdm_pass.setBorder(null);
            main_Admin.lbl_formAdm_passERR.setText("");
            singletonU.passwd_formAdm = pass;
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
            main_Admin.lbl_formAdm_passconfERR.setText("La contraseña debe contener minuscula, mayúsculas, números y carácteres especiales");
            main_Admin.lbl_formAdm_passconfERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passconfERR.setText("Contraseña no valida");
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);
        } else if (!pass.equals(conf_pass)) {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_passconfERR.setText("no coinciden " + Boolean.toString(pass.equals(conf_pass)));
            main_Admin.lbl_formAdm_passconfERR.setForeground(Color.red);

        } else {
            main_Admin.JPF_fromAdm_passconf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.JPF_fromAdm_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 0), 2));
            main_Admin.lbl_formAdm_passconfERR.setText("");
            valid = true;

        }
        return valid;
    }

    public static boolean askDNI() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_dni.getText().isEmpty()) {
            main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_dniERR.setText("DNI necesario");
            main_Admin.lbl_formAdm_dniERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
        } else if (!validate.DNI(main_Admin.txtf_formAdm_dni.getText())) {
            main_Admin.txtf_formAdm_dni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_dni.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_dniERR.setText("DNI no valido");
            main_Admin.lbl_formAdm_dniERR.setForeground(Color.red);
        } else {
            main_Admin.txtf_formAdm_dni.setBorder(null);
            main_Admin.lbl_formAdm_dniERR.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean askEmail() {
        boolean valid = false;

        if (main_Admin.txtf_formAdm_email.getText().isEmpty()) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_emailERR.setText("E-mail necesario");
            main_Admin.lbl_formAdm_emailERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_emailERR.setForeground(Color.red);
        } else if (!validate.Email(main_Admin.txtf_formAdm_email.getText())) {
            main_Admin.txtf_formAdm_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.txtf_formAdm_email.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_emailERR.setText("E-mail no valido");
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
            main_Admin.lbl_formAdm_activityERR.setText("Teléfono no valido");
            main_Admin.lbl_formAdm_activityERR.setForeground(Color.red);
        } else {
            main_Admin.txt_formAdm_activity.setBorder(null);
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
            //main_Admin.DC_formAdm_borndate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_borndateERR.setForeground(Color.red);
            return valid;
        }
        if (!bornDate.isValid_workage()) {
            //main_Admin.DC_formAdm_borndate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_borndateERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_borndateERR.setText("Fecha de nacimento no valida");
            main_Admin.lbl_formAdm_borndateERR.setForeground(Color.red);
        } else {
            //main_Admin.DC_formAdm_borndate.setBorder(null);
            main_Admin.lbl_formAdm_borndateERR.setText("");
            singletonU.born_date = bornDate;
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
            //main_Admin.DC_formAdm_borndate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 1, 12));
            main_Admin.lbl_formAdm_singdateERR.setForeground(Color.red);
            return valid;
        }
        if (!singDate.isValid_singdate(bornDate)) {
            //main_Admin.DC_formAdm_borndate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_Admin.lbl_formAdm_singdateERR.setFont(new java.awt.Font("Dialog", 0, 12));
            main_Admin.lbl_formAdm_singdateERR.setText("Fecha de contratación no valida");
            main_Admin.lbl_formAdm_singdateERR.setForeground(Color.red);
        } else {
            //main_Admin.DC_formAdm_singdate.setBorder(null);
            main_Admin.lbl_formAdm_singdateERR.setText("");
            singletonU.born_date = bornDate;
            singletonU.sing_date = singDate;
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
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //DAO_Admin.SaveImage(file);
            //Se coloca el nuevo icono modificado
            main_Admin.lbl_formAdm_photoavatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            main_Admin.lbl_formAdm_photoavatar.setSize(140, 170);
            //Guardo el Path en el singleton
            singletonU.PATH_formAdm = file;
        }

        return valid;
    }
    /*public static void SaveImage(String path) {
        BufferedImage bi, biFiltered;
        int w, h;
        try {
            bi = ImageIO.read(new File(path));
            w = bi.getWidth(null);
            h = bi.getHeight(null);
            if (bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(bi, 0, 0, null);
                biFiltered = bi = bi2;
            }
        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }*/
    
    public static void DAO_FA_mainBack() {
        //main_Admin.DISPOSE_ON_CLOSE;
        new main().setVisible(true);
    }

    public static void DAO_FA_hideFormPanel() {
        main_Admin.jPanel2.setVisible(false);
    }

    /**
     * Clen Fields functions
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
}
