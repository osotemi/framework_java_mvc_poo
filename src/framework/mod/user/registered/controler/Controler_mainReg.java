/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.controler;

import framework.mod.settings.model.clss.singletonProfile;
import framework.mod.settings.view.main_login;
import framework.mod.user.registered.model.BLL.BLL_Registered;
import framework.mod.user.registered.model.classes.miniSimpleTableModelReg;
import framework.mod.user.registered.model.classes.singletonReg;
import framework.mod.user.registered.model.tools.LanguageReg;
import framework.mod.user.registered.model.tools.autoComplete.AutoCompleteJComboBoxReg;
import framework.mod.user.registered.model.tools.autoComplete.StringSearchableReg;
import framework.mod.user.registered.model.tools.dummieReg_gen;
import framework.mod.user.registered.model.tools.pager.paginaReg;
import framework.mod.user.registered.view.main_Reg;
import static framework.mod.user.registered.view.main_Reg.PNL_drawForm;
import static framework.mod.user.registered.view.main_Reg.TABLA_REG;
import static framework.mod.user.registered.view.main_Reg.jPanel5;
import static framework.mod.user.registered.view.main_Reg.lbl_entries;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author osotemi
 */
public class Controler_mainReg implements ActionListener, KeyListener, MouseListener, FocusListener{
    
    public static main_Reg MainReg;
    
    public Controler_mainReg( main_Reg wdwReg){
        MainReg = ( main_Reg ) wdwReg;
    }
    
    public enum Accion{
        //PNL_menuBtn#################################
        _BTN_create,
        _BTN_createDummies,
        _BTN_modify,
        _BTN_delete,
        _BTN_deleteALL,
        _BTN_view,
        _BTN_saveXML,
        _BTN_saveTXT,
        _BTN_saveJSON,
        _BTN_back,
        
        //PNL_formAdmin#################################
        _BTN_avatar,
        _BTN_formCreate,
        _BTN_formBack,
        
        _CB_state,
        
        _DC_bornDate,
        
        _JPF_pass,
        _JPF_passConf,
        
        _TXT_userName,
        _TXT_name,
        _TXT_lastName,
        _TXT_email,
        _TXT_phone,
        _TXT_dni,
        _TXT_activity,
        
        //PNL_mainTablePager
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_primero,
        _BTN_ultimo,
        _BTN_TBL_back,
        _combo,
        
        _CB_TBL_entries,
        _TABLA,
    }
    
    public void run(){
        BLL_Registered.loadArray();
        LanguageReg.getInstance().loadProperties();
        //Initializate components
        Image icono = null;
        MainReg.setVisible(true);
        main_Reg.DC_formReg_borndate.getDateEditor().setEnabled(false);
        
        MainReg.setTitle(LanguageReg.getInstance().getProperty("adm_title"));
        MainReg.setLocationRelativeTo(null);//centrado
        try {
            icono = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
        } catch (IOException e) {

        }
        MainReg.setIconImage(icono);
        MainReg.setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        MainReg.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.MainReg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ventana salida
                int opc = JOptionPane.showConfirmDialog(null, LanguageReg.getInstance().getProperty("askBye"), LanguageReg.getInstance().getProperty("mes_askBye"), JOptionPane.WARNING_MESSAGE);
                if (opc == 0)
                    MainReg.dispose();                    
            }
        });
        
        
        //form Reg
        MainReg.lbl_form_avatar.setText(LanguageReg.getInstance().getProperty("DRW_lblAvatar"));
        MainReg.btn_formReg_Avatar.setActionCommand("_BTN_avatar");
        MainReg.btn_formReg_Avatar.setName("_BTN_avatar");
        MainReg.btn_formReg_Avatar.setText(LanguageReg.getInstance().getProperty("DRW_btnAvatar"));
        MainReg.btn_formReg_Avatar.addActionListener(this);

        MainReg.btn_formRegCreate_create.setActionCommand("_BTN_formCreate");
        MainReg.btn_formRegCreate_create.setName("_BTN_formCreate");
        MainReg.btn_formRegCreate_create.setText("");
        MainReg.btn_formRegCreate_create.addActionListener(this);

        MainReg.btn_formRegCreate_back.setActionCommand("_BTN_formBack");
        MainReg.btn_formRegCreate_back.setName("_BTN_formBack");
        MainReg.btn_formRegCreate_back.addActionListener(this);

        MainReg.lbl_form_state.setText(LanguageReg.getInstance().getProperty("DRW_lblState"));
        MainReg.CB_formReg_state.setActionCommand("_CB_state");
        MainReg.CB_formReg_state.setName("_CB_state");
        MainReg.CB_formReg_state.addActionListener(this);

        MainReg.lbl_form_bornDate.setText(LanguageReg.getInstance().getProperty("DRW_lblBornDate"));
        MainReg.DC_formReg_borndate.setName("_DC_bornDate");
        MainReg.DC_formReg_borndate.addKeyListener(this);

        MainReg.lbl_form_pass.setText(LanguageReg.getInstance().getProperty("DRW_lblPass"));
        MainReg.JPF_fromReg_pass.setName("_JPF_pass");
        MainReg.JPF_fromReg_pass.addKeyListener(this);

        MainReg.lbl_form_passConf.setText(LanguageReg.getInstance().getProperty("DRW_lblPassConf"));
        MainReg.JPF_fromReg_passconf.setName("_JPF_passConf");
        MainReg.JPF_fromReg_passconf.addKeyListener(this);

        MainReg.lbl_form_activity.setText(LanguageReg.getInstance().getProperty("DRW_lblActivity"));
        MainReg.txt_formReg_activity.setActionCommand("_TXT_activity");
        MainReg.txt_formReg_activity.setName("_TXT_activity");
        MainReg.txt_formReg_activity.addKeyListener(this);
        MainReg.txt_formReg_activity.addFocusListener(this);

        MainReg.lbl_form_dni.setText(LanguageReg.getInstance().getProperty("DRW_lblDni"));
        MainReg.txtf_formReg_dni.setActionCommand("_TXT_dni");
        MainReg.txtf_formReg_dni.setName("_TXT_dni");
        MainReg.txtf_formReg_dni.addActionListener(this);
        MainReg.txtf_formReg_dni.addKeyListener(this);
        MainReg.txtf_formReg_dni.addFocusListener(this);

        MainReg.lbl_form_email.setText(LanguageReg.getInstance().getProperty("DRW_lblEmail"));
        MainReg.txtf_formReg_email.setActionCommand("_TXT_email");
        MainReg.txtf_formReg_email.setName("_TXT_email");
        MainReg.txtf_formReg_email.addActionListener(this);
        MainReg.txtf_formReg_email.addKeyListener(this);
        MainReg.txtf_formReg_email.addFocusListener(this);

        MainReg.lbl_form_lastName.setText(LanguageReg.getInstance().getProperty("DRW_lblLastName"));
        MainReg.txtf_formReg_lastname.setActionCommand("_TXT_lastName");
        MainReg.txtf_formReg_lastname.setName("_TXT_lastName");
        MainReg.txtf_formReg_lastname.addActionListener(this);
        MainReg.txtf_formReg_lastname.addKeyListener(this);
        MainReg.txtf_formReg_lastname.addFocusListener(this);

        MainReg.lbl_form_name.setText(LanguageReg.getInstance().getProperty("DRW_lblName"));
        MainReg.txtf_formReg_name.setActionCommand("_TXT_name");
        MainReg.txtf_formReg_name.setName("_TXT_name");
        MainReg.txtf_formReg_name.addActionListener(this);
        MainReg.txtf_formReg_name.addKeyListener(this);
        MainReg.txtf_formReg_name.addFocusListener(this);

        MainReg.lbl_form_phone.setText(LanguageReg.getInstance().getProperty("DRW_lblPhone"));
        MainReg.txtf_formReg_phone.setActionCommand("_TXT_phone");
        MainReg.txtf_formReg_phone.setName("_TXT_phone");
        MainReg.txtf_formReg_phone.addActionListener(this);
        MainReg.txtf_formReg_phone.addKeyListener(this);
        MainReg.txtf_formReg_phone.addFocusListener(this);

        MainReg.lbl_form_userName.setText(LanguageReg.getInstance().getProperty("DRW_lblUserName"));
        MainReg.txtf_formReg_username.setActionCommand("_TXT_userName");
        MainReg.txtf_formReg_username.setName("_TXT_userName");
        MainReg.txtf_formReg_username.addActionListener(this);
        MainReg.txtf_formReg_username.addKeyListener(this);
        MainReg.txtf_formReg_username.addFocusListener(this);
        
        switch (singletonProfile.userType){
            case "Admin":
                MainReg.lbl_currprofile.setText(LanguageReg.getInstance().getProperty("DRW_lblSession") + ": " + singletonProfile.adm.getUser());
                PNL_drawForm.setVisible(false);
                MainReg.PNL_mainTablePager.setVisible(true);
                runTABLE();
                //Inicia los componentes del menu de botones
                MainReg.btn_createReg.setVisible(true);
                MainReg.btn_createReg.setActionCommand("_BTN_create");
                MainReg.btn_createReg.addActionListener(this);
                //MainAdmin.btn_createAdmin.setIcon();
                MainReg.btn_createDummies.setVisible(true);
                MainReg.btn_createDummies.setActionCommand("_BTN_createDummies");
                MainReg.btn_createDummies.addActionListener(this);

                MainReg.btn_modifyReg.setActionCommand("_BTN_modify");
                MainReg.btn_modifyReg.addActionListener(this);

                MainReg.btn_deleteReg.setActionCommand("_BTN_delete");
                MainReg.btn_deleteReg.addActionListener(this);

                MainReg.btn_deleteAllReg.setVisible(true);
                MainReg.btn_deleteAllReg.setActionCommand("_BTN_deleteALL");
                MainReg.btn_deleteAllReg.addActionListener(this);

                MainReg.btn_viewReg.setActionCommand("_BTN_view");
                MainReg.btn_viewReg.addActionListener(this);

                MainReg.btn_saveXML.setVisible(true);
                MainReg.btn_saveXML.setActionCommand("_BTN_saveXML");
                MainReg.btn_saveXML.addActionListener(this);
                MainReg.btn_saveXML.setText("XML");

                MainReg.btn_saveTXT.setVisible(true);
                MainReg.btn_saveTXT.setActionCommand("_BTN_saveTXT");
                MainReg.btn_saveTXT.addActionListener(this);
                MainReg.btn_saveTXT.setText("TXT");

                MainReg.btn_saveJSON.setVisible(true);
                MainReg.btn_saveJSON.setActionCommand("_BTN_saveJSON");
                MainReg.btn_saveJSON.addActionListener(this);
                MainReg.btn_saveJSON.setText("JSON");

                MainReg.btn_backMain.setActionCommand("_BTN_back");
                MainReg.btn_backMain.addActionListener(this);
                MainReg.btn_backMain.setText(LanguageReg.getInstance().getProperty("DRW_btnMain"));// corregir

                //Inicia los componentes de la TABLA/pagina
                MainReg.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
                MainReg.ANTERIOR.addActionListener(this);
                MainReg.ANTERIOR.setText("<");

                MainReg.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
                MainReg.SIGUIENTE.addActionListener(this);
                MainReg.SIGUIENTE.setText(">");

                MainReg.primero.setActionCommand("_BTN_primero");
                MainReg.primero.addActionListener(this);
                MainReg.primero.setText("|<");

                MainReg.ultimo.setActionCommand("_BTN_ultimo");
                MainReg.ultimo.addActionListener(this);
                MainReg.ultimo.setText(">|");

                MainReg.btn_tbl_back.setActionCommand("_BTN_TBL_back");
                MainReg.btn_tbl_back.addActionListener(this);
                MainReg.btn_tbl_back.setText(LanguageReg.getInstance().getProperty("DRW_btnBack"));//corregir

                MainReg.CB_tbl_entries.setActionCommand("_CB_TBL_entries");
                MainReg.CB_tbl_entries.addActionListener(this);

                MainReg.comboReg.setActionCommand("_combo");
                MainReg.comboReg.addActionListener(this);

                MainReg.TABLA_REG.setName("_TABLA");
                MainReg.TABLA_REG.addMouseListener(this);
                break;
                
            case "RegU":
                MainReg.lbl_currprofile.setText(LanguageReg.getInstance().getProperty("DRW_lblSession") + ": " + singletonProfile.RegU.getUser());
                PNL_drawForm.setVisible(true);
                MainReg.PNL_mainTablePager.setVisible(false);
                
                //Inicia los componentes del menu de botones
                MainReg.btn_createReg.setVisible(false);
                //MainAdmin.btn_createAdmin.setIcon();
                MainReg.btn_createDummies.setVisible(false);

                MainReg.btn_modifyReg.setActionCommand("_BTN_modify");
                MainReg.btn_modifyReg.addActionListener(this);

                MainReg.btn_deleteReg.setActionCommand("_BTN_delete");
                MainReg.btn_deleteReg.addActionListener(this);

                MainReg.btn_deleteAllReg.setVisible(false);

                MainReg.btn_viewReg.setActionCommand("_BTN_view");
                MainReg.btn_viewReg.addActionListener(this);

                MainReg.btn_saveXML.setVisible(false);

                MainReg.btn_saveTXT.setVisible(false);

                MainReg.btn_saveJSON.setVisible(false);

                MainReg.btn_backMain.setActionCommand("_BTN_back");
                MainReg.btn_backMain.addActionListener(this);
                MainReg.btn_backMain.setText(LanguageReg.getInstance().getProperty("DRW_btnLogout"));// corregir

                BLL_Registered.BLL_ViewRegProfile(); 
                break;
            default:
                break;
        }
        
    }
    
    public static void runTABLE() {
        TABLA_REG.setModel(new miniSimpleTableModelReg());
        ((miniSimpleTableModelReg) TABLA_REG.getModel()).cargar();
        TABLA_REG.setFillsViewportHeight(true);
        TABLA_REG.setRowSorter(main_Reg.sorterReg);
        paginaReg.inicializa();
        paginaReg.initLinkBox();

        main_Reg.lbl_entries.setText(String.valueOf(singletonReg.RegTableArray.size()));
        main_Reg.lbl_filtBY.setText(LanguageReg.getInstance().getProperty("tbl_filter"));
        main_Reg.lbl_rowBYpag.setText(LanguageReg.getInstance().getProperty("tbl_usrByPage"));
        main_Reg.btn_tbl_back.setText(LanguageReg.getInstance().getProperty("tbl_back"));
        
        //combo lineas
        List<String> myWords = new ArrayList<String>();
        for (int i = 0; i <= singletonReg.RegTableArray.size() - 1; i++) {
            myWords.add(singletonReg.RegTableArray.get(i).getName().toLowerCase());
            myWords.add(singletonReg.RegTableArray.get(i).getName());
        }

        StringSearchableReg searchable = new StringSearchableReg(myWords);
        main_Reg.comboReg = new AutoCompleteJComboBoxReg(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(main_Reg.comboReg);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Accion.valueOf(evt.getActionCommand())) {
            //PNL_menuBtn action buttons
            case _BTN_back:
                BLL_Registered.BLL_FR_mainBack();
                break;
            case _BTN_create:
                BLL_Registered.BLL_CreateReg();
                break;
             case _BTN_createDummies:
                dummieReg_gen.menu_dummie();
                break;
            case _BTN_delete:
                BLL_Registered.BLL_DeleteReg();
                break;
            case _BTN_deleteALL:
                BLL_Registered.BLL_DeleteAllRegistered();
                break;
            case _BTN_modify:
                if(singletonProfile.userType.equals("RegU")){
                    BLL_Registered.BLL_ModifyRegProf();
                }else{
                    BLL_Registered.BLL_ModifyReg();
                }
                break;
            case _BTN_saveJSON:
                BLL_Registered.BLL_UserSaveJSON();
                break;
            case _BTN_saveTXT:
                BLL_Registered.BLL_UserSaveTXT();
                break;
            case _BTN_saveXML:
                BLL_Registered.BLL_UserSaveXML();
                break;
            case _BTN_view:
                if(singletonProfile.userType.equals("RegU")){
                    BLL_Registered.BLL_ViewRegProfile();
                }
                else{
                    BLL_Registered.BLL_ViewReg();
                }
                break;
            //BTNs of formAdmin
            case _BTN_avatar:
                BLL_Registered.BLL_Avatar();
                break;
            case _BTN_formBack:
                BLL_Registered.BLL_FR_HideNewFormPanel();
                break;
            case _BTN_formCreate:
                BLL_Registered.BLL_FR_formCreate();
                if(!singletonProfile.userType.equals("RegU")){
                    Controler_mainReg.runTABLE();
                }
                break;
            //BTNs of TablePager
            case _BTN_ANTERIOR:
                BLL_Registered.BLL_TBL_Previous();
                break;
            case _BTN_SIGUIENTE:
                BLL_Registered.BLL_TBL_Next();
                break;
            case _BTN_primero:
                BLL_Registered.BLL_TBL_First();
                break;
            case _BTN_ultimo:
                BLL_Registered.BLL_TBL_Last();
                break;
            case _BTN_TBL_back:
                BLL_Registered.BLL_FR_mainBack();
                break;
            case _CB_TBL_entries:
                BLL_Registered.BLL_TBL_CB_entries();
                break;
            case _combo:
                BLL_Registered.BLL_TBL_combo();
                break;
            case _JPF_passConf:
                BLL_Registered.BLL_JPF_PassConfirm();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Registered.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Registered.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Registered.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Registered.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Registered.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Registered.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Registered.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Registered.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Registered.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Registered.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Registered.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Registered.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Registered.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Registered.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Registered.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Registered.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Registered.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Registered.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Registered.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Registered.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Registered.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Registered.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Registered.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Registered.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Registered.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Registered.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Registered.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TABLA:
                BLL_Registered.BLL_TableMouseClick(evt);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Registered.BLL_JPF_Password();
                break;
            case _TXT_activity:
                BLL_Registered.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Registered.BLL_FR_CleanDNI();
                break;
            case _TXT_email:
                BLL_Registered.BLL_FR_CleanEmail();
                break;
            case _TXT_lastName:
                BLL_Registered.BLL_FR_CleanLastName();
                break;
            case _TXT_name:
                BLL_Registered.BLL_FR_CleanName();
                break;
            case _TXT_phone:
                BLL_Registered.BLL_FR_CleanPhone();
                break;
            default:
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Registered.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Registered.BLL_JPF_PassConfirm();
                break;
            case _TXT_dni:
                BLL_Registered.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Registered.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Registered.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Registered.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Registered.BLL_Activity();
                break;
            case _TXT_userName:
                BLL_Registered.BLL_txtUsername();
                break;
            default:
                break;
        }
    }
    public void propertyChange(PropertyChangeEvent evt){
        switch(Accion.valueOf(evt.getPropertyName())){
            case _DC_bornDate:
                BLL_Registered.BLL_DCBornDate();
                break;
            default:
                break;
        }
    }
}
