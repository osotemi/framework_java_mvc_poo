/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.controler;

import framework.mod.user.admin.model.BLL.BLL_Admin;
import framework.mod.user.admin.model.classes.miniSimpleTableModel_Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.admin.model.tools.LanguageAdm;
import framework.mod.user.admin.model.tools.autoComplete.AutocompleteJComboBox;
import framework.mod.user.admin.model.tools.autoComplete.StringSearchable;
import framework.mod.user.admin.model.tools.dummieAdm_gen;
import framework.mod.user.admin.model.tools.pager.pagina;
import framework.mod.user.admin.view.main_Admin;
import static framework.mod.user.admin.view.main_Admin.DC_formAdm_borndate;
import static framework.mod.user.admin.view.main_Admin.DC_formAdm_singdate;
import static framework.mod.user.admin.view.main_Admin.TABLA;
import static framework.mod.user.admin.view.main_Admin.combo;
import static framework.mod.user.admin.view.main_Admin.jPanel5;
import static framework.mod.user.admin.view.main_Admin.sorter;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import static framework.mod.user.admin.view.main_Admin.PNL_drawForm;
import java.beans.PropertyChangeEvent;
import static framework.mod.user.admin.view.main_Admin.lbl_entries;

/**
 *
 * @author osotemi
 */
public class Controler_mainAdmin implements ActionListener, KeyListener, MouseListener, FocusListener{
    
    public static main_Admin MainAdmin;
    
    public Controler_mainAdmin( main_Admin windowAdmin){
        MainAdmin =  (main_Admin) windowAdmin;
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
        _DC_singDate,
        
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
        BLL_Admin.loadArray();
        LanguageAdm.getInstance().loadProperties();
        //Initializate components
        Image icono = null;
        MainAdmin.setVisible(true);
        PNL_drawForm.setVisible(false);
        DC_formAdm_borndate.getDateEditor().setEnabled(false);
        DC_formAdm_singdate.getDateEditor().setEnabled(false);
        
        MainAdmin.setTitle(LanguageAdm.getInstance().getProperty("adm_title"));
        MainAdmin.setLocationRelativeTo(null);//centrado
        try {
            icono = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
        } catch (IOException e) {

        }
        MainAdmin.setIconImage(icono);
        MainAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        runTABLE();

        MainAdmin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.MainAdmin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainAdmin.dispose();
                BLL_Admin.BLL_FA_mainBack();
            }
        });
                
        //Inicia los componentes del menu de botones
        MainAdmin.btn_createAdmin.setActionCommand("_BTN_create");
        MainAdmin.btn_createAdmin.addActionListener(this);
        //MainAdmin.btn_createAdmin.setIcon();
        MainAdmin.btn_createDummies.setActionCommand("_BTN_createDummies");
        MainAdmin.btn_createDummies.addActionListener(this);
        
        MainAdmin.btn_modifyAdmin.setActionCommand("_BTN_modify");
        MainAdmin.btn_modifyAdmin.addActionListener(this);
        
        MainAdmin.btn_deleteAdmin.setActionCommand("_BTN_delete");
        MainAdmin.btn_deleteAdmin.addActionListener(this);
        
        MainAdmin.btn_deleteAllAdmin.setActionCommand("_BTN_deleteALL");
        MainAdmin.btn_deleteAllAdmin.addActionListener(this);
        
        MainAdmin.btn_viewAdmin.setActionCommand("_BTN_view");
        MainAdmin.btn_viewAdmin.addActionListener(this);
        
        MainAdmin.btn_saveXML.setActionCommand("_BTN_saveXML");
        MainAdmin.btn_saveXML.addActionListener(this);
        MainAdmin.btn_saveXML.setText("XML");
        
        MainAdmin.btn_saveTXT.setActionCommand("_BTN_saveTXT");
        MainAdmin.btn_saveTXT.addActionListener(this);
        MainAdmin.btn_saveTXT.setText("TXT");
        
        MainAdmin.btn_saveJSON.setActionCommand("_BTN_saveJSON");
        MainAdmin.btn_saveJSON.addActionListener(this);
        MainAdmin.btn_saveJSON.setText("JSON");
        
        MainAdmin.btn_backMain.setActionCommand("_BTN_back");
        MainAdmin.btn_backMain.addActionListener(this);
        MainAdmin.btn_backMain.setText(LanguageAdm.getInstance().getProperty("DRW_btnMain"));// corregir
        
        //Inicia los componentes de la TABLA/pagina
        MainAdmin.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
        MainAdmin.ANTERIOR.addActionListener(this);
        MainAdmin.ANTERIOR.setText("<");
        
        MainAdmin.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
        MainAdmin.SIGUIENTE.addActionListener(this);
        MainAdmin.SIGUIENTE.setText(">");
       
        MainAdmin.primero.setActionCommand("_BTN_primero");
        MainAdmin.primero.addActionListener(this);
        MainAdmin.primero.setText("|<");
        
        MainAdmin.ultimo.setActionCommand("_BTN_ultimo");
        MainAdmin.ultimo.addActionListener(this);
        MainAdmin.ultimo.setText(">|");
        
        MainAdmin.btn_tbl_back.setActionCommand("_BTN_TBL_back");
        MainAdmin.btn_tbl_back.addActionListener(this);
        MainAdmin.btn_tbl_back.setText(LanguageAdm.getInstance().getProperty("DRW_btnBack"));//corregir
        
        MainAdmin.CB_tbl_entries.setActionCommand("_CB_TBL_entries");
        MainAdmin.CB_tbl_entries.addActionListener(this);
        
        MainAdmin.combo.setActionCommand("_combo");
        MainAdmin.combo.addActionListener(this);
        
        MainAdmin.TABLA.setName("_TABLA");
        MainAdmin.TABLA.addMouseListener(this);
        
        //form Admin
        MainAdmin.lbl_form_avatar.setText(LanguageAdm.getInstance().getProperty("DRW_lblAvatar"));
        MainAdmin.btn_formA_Avatar.setActionCommand("_BTN_avatar");
        MainAdmin.btn_formA_Avatar.setName("_BTN_avatar");
        MainAdmin.btn_formA_Avatar.setText(LanguageAdm.getInstance().getProperty("DRW_btnAvatar"));
        MainAdmin.btn_formA_Avatar.addActionListener(this);
        
        MainAdmin.btn_formAdm_Create.setActionCommand("_BTN_formCreate");
        MainAdmin.btn_formAdm_Create.setName("_BTN_formCreate");
        MainAdmin.btn_formAdm_Create.addActionListener(this);
        
        MainAdmin.btn_formAdmBack.setActionCommand("_BTN_formBack");
        MainAdmin.btn_formAdmBack.setName("_BTN_formBack");
        MainAdmin.btn_formAdmBack.addActionListener(this);

        MainAdmin.lbl_form_state.setText(LanguageAdm.getInstance().getProperty("DRW_lblState"));
        MainAdmin.CB_formAdm_state.setActionCommand("_CB_state");
        MainAdmin.CB_formAdm_state.setName("_CB_state");
        MainAdmin.CB_formAdm_state.addActionListener(this);
        
        MainAdmin.lbl_form_bornDate.setText(LanguageAdm.getInstance().getProperty("DRW_lblBornDate"));
        MainAdmin.DC_formAdm_borndate.setName("_DC_bornDate");
        MainAdmin.DC_formAdm_borndate.addKeyListener(this);
        
        MainAdmin.lbl_form_hireDate.setText(LanguageAdm.getInstance().getProperty("DRW_lblSingDate"));
        MainAdmin.DC_formAdm_singdate.setName("_DC_singDate");
        MainAdmin.DC_formAdm_singdate.addKeyListener(this);
        
        MainAdmin.lbl_form_pass.setText(LanguageAdm.getInstance().getProperty("DRW_lblPass"));
        MainAdmin.JPF_fromAdm_pass.setName("_JPF_pass");
        MainAdmin.JPF_fromAdm_pass.addKeyListener(this);
        
        MainAdmin.lbl_form_passConf.setText(LanguageAdm.getInstance().getProperty("DRW_lblPassConf"));
        MainAdmin.JPF_fromAdm_passconf.setName("_JPF_passConf");
        MainAdmin.JPF_fromAdm_passconf.addKeyListener(this);
        //TXT fielda
        MainAdmin.lbl_form_activity.setText(LanguageAdm.getInstance().getProperty("DRW_lblActivity"));
        MainAdmin.txt_formAdm_activity.setActionCommand("_TXT_activity");
        MainAdmin.txt_formAdm_activity.setName("_TXT_activity");
        MainAdmin.txt_formAdm_activity.addKeyListener(this);
        MainAdmin.txt_formAdm_activity.addFocusListener(this);
        
        MainAdmin.lbl_form_dni.setText(LanguageAdm.getInstance().getProperty("DRW_lblDni"));
        MainAdmin.txtf_formAdm_dni.setActionCommand("_TXT_dni");
        MainAdmin.txtf_formAdm_dni.setName("_TXT_dni");
        MainAdmin.txtf_formAdm_dni.addActionListener(this);
        MainAdmin.txtf_formAdm_dni.addKeyListener(this);
        MainAdmin.txtf_formAdm_dni.addFocusListener(this);
        
        MainAdmin.lbl_form_email.setText(LanguageAdm.getInstance().getProperty("DRW_lblEmail"));
        MainAdmin.txtf_formAdm_email.setActionCommand("_TXT_email");
        MainAdmin.txtf_formAdm_email.setName("_TXT_email");
        MainAdmin.txtf_formAdm_email.addActionListener(this);
        MainAdmin.txtf_formAdm_email.addKeyListener(this);
        MainAdmin.txtf_formAdm_email.addFocusListener(this);
        
        MainAdmin.lbl_form_lastName.setText(LanguageAdm.getInstance().getProperty("DRW_lblLastName"));
        MainAdmin.txtf_formAdm_lastname.setActionCommand("_TXT_lastName");
        MainAdmin.txtf_formAdm_lastname.setName("_TXT_lastName");
        MainAdmin.txtf_formAdm_lastname.addActionListener(this);
        MainAdmin.txtf_formAdm_lastname.addKeyListener(this);
        MainAdmin.txtf_formAdm_lastname.addFocusListener(this);
        
        MainAdmin.lbl_form_name.setText(LanguageAdm.getInstance().getProperty("DRW_lblName"));
        MainAdmin.txtf_formAdm_name.setActionCommand("_TXT_name");
        MainAdmin.txtf_formAdm_name.setName("_TXT_name");
        MainAdmin.txtf_formAdm_name.addActionListener(this);
        MainAdmin.txtf_formAdm_name.addKeyListener(this);
        MainAdmin.txtf_formAdm_name.addFocusListener(this);
        
        MainAdmin.lbl_form_phone.setText(LanguageAdm.getInstance().getProperty("DRW_lblPhone"));
        MainAdmin.txtf_formAdm_phone.setActionCommand("_TXT_phone");
        MainAdmin.txtf_formAdm_phone.setName("_TXT_phone");
        MainAdmin.txtf_formAdm_phone.addActionListener(this);
        MainAdmin.txtf_formAdm_phone.addKeyListener(this);
        MainAdmin.txtf_formAdm_phone.addFocusListener(this);
        
        MainAdmin.lbl_form_userName.setText(LanguageAdm.getInstance().getProperty("DRW_lblUserName"));
        MainAdmin.txtf_formAdm_username.setActionCommand("_TXT_userName");
        MainAdmin.txtf_formAdm_username.setName("_TXT_userName");
        MainAdmin.txtf_formAdm_username.addActionListener(this);
        MainAdmin.txtf_formAdm_username.addKeyListener(this);
        MainAdmin.txtf_formAdm_username.addFocusListener(this);
    }
    
    public static void runTABLE() {
        TABLA.setModel(new miniSimpleTableModel_Admin());
        ((miniSimpleTableModel_Admin) TABLA.getModel()).cargar();
        TABLA.setFillsViewportHeight(true);
        TABLA.setRowSorter(sorter);
        pagina.inicializa();
        pagina.initLinkBox();

        lbl_entries.setText(String.valueOf(singletonAdmin.AdminTableArray.size()));
        main_Admin.lbl_filtBY.setText(LanguageAdm.getInstance().getProperty("tbl_filter"));
        main_Admin.lbl_rowBYpag.setText(LanguageAdm.getInstance().getProperty("tbl_usrByPage"));
        main_Admin.btn_tbl_back.setText(LanguageAdm.getInstance().getProperty("tbl_back"));
        
        //combo lineas
        List<String> myWords = new ArrayList<String>();
        for (int i = 0; i <= singletonAdmin.AdminTableArray.size() - 1; i++) {
            myWords.add(singletonAdmin.AdminTableArray.get(i).getName().toLowerCase());
            myWords.add(singletonAdmin.AdminTableArray.get(i).getName());
        }

        StringSearchable searchable = new StringSearchable(myWords);
        combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(combo);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Accion.valueOf(evt.getActionCommand())) {
            //PNL_menuBtn action buttons
            case _BTN_back:
                BLL_Admin.BLL_FA_mainBack();
                break;
            case _BTN_create:
                BLL_Admin.BLL_CreateAdm();
                break;
             case _BTN_createDummies:
                dummieAdm_gen.menu_dummie();
                break;
            case _BTN_delete:
                BLL_Admin.BLL_DeleteAdm();
                break;
            case _BTN_deleteALL:
                BLL_Admin.BLL_DeleteAllAdm();
                break;
            case _BTN_modify:
                BLL_Admin.BLL_ModifyAdm();
                break;
            case _BTN_saveJSON:
                BLL_Admin.BLL_UserSaveJSON();
                break;
            case _BTN_saveTXT:
                BLL_Admin.BLL_UserSaveTXT();
                break;
            case _BTN_saveXML:
                BLL_Admin.BLL_UserSaveXML();
                break;
            case _BTN_view:
                BLL_Admin.BLL_ViewAdm();
                break;
            //BTNs of formAdmin
            case _BTN_avatar:
                BLL_Admin.BLL_Avatar();
                break;
            case _BTN_formBack:
                BLL_Admin.BLL_FA_HideNewFormPanel();
                break;
            case _BTN_formCreate:
                BLL_Admin.BLL_FA_formCreate();
                break;
            //BTNs of TablePager
            case _BTN_ANTERIOR:
                BLL_Admin.BLL_TBL_Previous();
                break;
            case _BTN_SIGUIENTE:
                BLL_Admin.BLL_TBL_Next();
                break;
            case _BTN_primero:
                BLL_Admin.BLL_TBL_First();
                break;
            case _BTN_ultimo:
                BLL_Admin.BLL_TBL_Last();
                break;
            case _BTN_TBL_back:
                BLL_Admin.BLL_FA_mainBack();
                break;
            case _CB_TBL_entries:
                BLL_Admin.BLL_TBL_CB_entries();
                break;
            case _combo:
                BLL_Admin.BLL_TBL_combo();
                break;
            case _JPF_passConf:
                BLL_Admin.BLL_JPF_PassConfirm();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Admin.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Admin.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Admin.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Admin.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Admin.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Admin.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Admin.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Admin.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Admin.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Admin.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Admin.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Admin.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Admin.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Admin.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Admin.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Admin.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Admin.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Admin.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Admin.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Admin.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Admin.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Admin.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Admin.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Admin.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Admin.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Admin.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Admin.BLL_txtUsername();
                break;
            
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TABLA:
                BLL_Admin.BLL_TableMouseClick(evt);
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
                BLL_Admin.BLL_JPF_Password();
                break;
            case _TXT_activity:
                BLL_Admin.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Admin.BLL_FA_CleanDNI();
                break;
            case _TXT_email:
                BLL_Admin.BLL_FA_CleanEmail();
                break;
            case _TXT_lastName:
                BLL_Admin.BLL_FA_CleanLastName();
                break;
            case _TXT_name:
                BLL_Admin.BLL_FA_CleanName();
                break;
            case _TXT_phone:
                BLL_Admin.BLL_FA_CleanPhone();
                break;
            default:
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Admin.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Admin.BLL_JPF_PassConfirm();
                break;
            case _TXT_dni:
                BLL_Admin.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Admin.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Admin.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Admin.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Admin.BLL_Activity();
                break;
            case _TXT_userName:
                BLL_Admin.BLL_txtUsername();
                break;
            default:
                break;
        }
    }
    
    public void propertyChange(PropertyChangeEvent evt){
        switch(Accion.valueOf(evt.getPropertyName())){
            case _DC_bornDate:
                BLL_Admin.BLL_DCBornDate();
                break;
            case _DC_singDate:
                BLL_Admin.BLL_DCSingDate();
                break;
            default:
                break;
        }
    }
}
