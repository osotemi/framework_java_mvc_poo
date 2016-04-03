/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.controler;

import framework.mod.user.client.model.BLL.BLL_Client;
import framework.mod.user.client.model.classes.miniSimpleTableModel_Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.mod.user.client.model.tools.LanguageClt;
import framework.mod.user.client.model.tools.autoComplete.AutocompleteJComboBoxClt;
import framework.mod.user.client.model.tools.autoComplete.StringSearchableClt;
import framework.mod.user.client.model.tools.dummieClt_gen;
import framework.mod.user.client.model.tools.pager.paginaClt;
import framework.mod.user.client.view.main_Client;
import static framework.mod.user.client.view.main_Client.DC_formClt_borndate;
import static framework.mod.user.client.view.main_Client.DC_formClt_singdate;
import static framework.mod.user.client.view.main_Client.PNL_drawForm;
import static framework.mod.user.client.view.main_Client.TABLA_CLT;
import static framework.mod.user.client.view.main_Client.jPanel5;
import static framework.mod.user.client.view.main_Client.lbl_entries;
import static framework.mod.user.client.view.main_Client.sorterClt;
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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author osotemi
 */
public class Controler_mainClient implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static main_Client MainClient;

    public Controler_mainClient(main_Client wdwClient) {
        MainClient = (main_Client) wdwClient;
    }

    public enum Accion {
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

    public void run() {
        BLL_Client.loadArray();
        LanguageClt.getInstance().loadProperties();
        //Initializate components
        Image icono = null;
        MainClient.setVisible(true);
        PNL_drawForm.setVisible(false);
        DC_formClt_borndate.getDateEditor().setEnabled(false);
        DC_formClt_singdate.getDateEditor().setEnabled(false);

        MainClient.setTitle(LanguageClt.getInstance().getProperty("adm_title"));
        MainClient.setLocationRelativeTo(null);//centrado
        try {
            icono = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
        } catch (IOException e) {

        }
        MainClient.setIconImage(icono);
        MainClient.setExtendedState(JFrame.MAXIMIZED_BOTH);
        runTABLE();

        MainClient.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.MainClient.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainClient.dispose();
                BLL_Client.BLL_FC_mainBack();
            }
        });

        //Inicia los componentes del menu de botones
        MainClient.btn_createClient.setActionCommand("_BTN_create");
        MainClient.btn_createClient.addActionListener(this);
        //MainAdmin.btn_createAdmin.setIcon();
        MainClient.btn_createDummies.setActionCommand("_BTN_createDummies");
        MainClient.btn_createDummies.addActionListener(this);

        MainClient.btn_modifyClient.setActionCommand("_BTN_modify");
        MainClient.btn_modifyClient.addActionListener(this);

        MainClient.btn_deleteClient.setActionCommand("_BTN_delete");
        MainClient.btn_deleteClient.addActionListener(this);

        MainClient.btn_deleteAllClient.setActionCommand("_BTN_deleteALL");
        MainClient.btn_deleteAllClient.addActionListener(this);

        MainClient.btn_viewClient.setActionCommand("_BTN_view");
        MainClient.btn_viewClient.addActionListener(this);

        MainClient.btn_saveXML.setActionCommand("_BTN_saveXML");
        MainClient.btn_saveXML.addActionListener(this);
        MainClient.btn_saveXML.setText("XML");

        MainClient.btn_saveTXT.setActionCommand("_BTN_saveTXT");
        MainClient.btn_saveTXT.addActionListener(this);
        MainClient.btn_saveTXT.setText("TXT");

        MainClient.btn_saveJSON.setActionCommand("_BTN_saveJSON");
        MainClient.btn_saveJSON.addActionListener(this);
        MainClient.btn_saveJSON.setText("JSON");

        MainClient.btn_backMain.setActionCommand("_BTN_back");
        MainClient.btn_backMain.addActionListener(this);
        MainClient.btn_backMain.setText(LanguageClt.getInstance().getProperty("DRW_btnMain"));// corregir

        //Inicia los componentes de la TABLA/pagina
        MainClient.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
        MainClient.ANTERIOR.addActionListener(this);
        MainClient.ANTERIOR.setText("<");

        MainClient.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
        MainClient.SIGUIENTE.addActionListener(this);
        MainClient.SIGUIENTE.setText(">");

        MainClient.primero.setActionCommand("_BTN_primero");
        MainClient.primero.addActionListener(this);
        MainClient.primero.setText("|<");

        MainClient.ultimo.setActionCommand("_BTN_ultimo");
        MainClient.ultimo.addActionListener(this);
        MainClient.ultimo.setText(">|");

        MainClient.btn_tbl_back.setActionCommand("_BTN_TBL_back");
        MainClient.btn_tbl_back.addActionListener(this);
        MainClient.btn_tbl_back.setText(LanguageClt.getInstance().getProperty("DRW_btnBack"));//corregir

        MainClient.CB_tbl_entries.setActionCommand("_CB_TBL_entries");
        MainClient.CB_tbl_entries.addActionListener(this);

        MainClient.comboClt.setActionCommand("_combo");
        MainClient.comboClt.addActionListener(this);

        MainClient.TABLA_CLT.setName("_TABLA");
        MainClient.TABLA_CLT.addMouseListener(this);

        //form Admin
        MainClient.lbl_form_avatar.setText(LanguageClt.getInstance().getProperty("DRW_lblAvatar"));
        MainClient.btn_formClt_Avatar.setActionCommand("_BTN_avatar");
        MainClient.btn_formClt_Avatar.setName("_BTN_avatar");
        MainClient.btn_formClt_Avatar.setText(LanguageClt.getInstance().getProperty("DRW_btnAvatar"));
        MainClient.btn_formClt_Avatar.addActionListener(this);

        MainClient.btn_formCltCreate_create.setActionCommand("_BTN_formCreate");
        MainClient.btn_formCltCreate_create.setName("_BTN_formCreate");
        MainClient.btn_formCltCreate_create.setText("");
        MainClient.btn_formCltCreate_create.addActionListener(this);

        MainClient.btn_formCltCreate_back.setActionCommand("_BTN_formBack");
        MainClient.btn_formCltCreate_back.setName("_BTN_formBack");
        MainClient.btn_formCltCreate_back.addActionListener(this);

        MainClient.lbl_form_state.setText(LanguageClt.getInstance().getProperty("DRW_lblState"));
        MainClient.CB_formClt_state.setActionCommand("_CB_state");
        MainClient.CB_formClt_state.setName("_CB_state");
        MainClient.CB_formClt_state.addActionListener(this);

        MainClient.lbl_form_bornDate.setText(LanguageClt.getInstance().getProperty("DRW_lblBornDate"));
        MainClient.DC_formClt_borndate.setName("_DC_bornDate");
        MainClient.DC_formClt_borndate.addKeyListener(this);

        MainClient.lbl_form_hireDate.setText(LanguageClt.getInstance().getProperty("DRW_lblSingDate"));
        MainClient.DC_formClt_singdate.setName("_DC_singDate");
        MainClient.DC_formClt_singdate.addKeyListener(this);

        MainClient.lbl_form_pass.setText(LanguageClt.getInstance().getProperty("DRW_lblPass"));
        MainClient.JPF_fromClt_pass.setName("_JPF_pass");
        MainClient.JPF_fromClt_pass.addKeyListener(this);

        MainClient.lbl_form_passConf.setText(LanguageClt.getInstance().getProperty("DRW_lblPassConf"));
        MainClient.JPF_fromClt_passconf.setName("_JPF_passConf");
        MainClient.JPF_fromClt_passconf.addKeyListener(this);

        MainClient.lbl_form_shopAccount.setText(LanguageClt.getInstance().getProperty("DRW_lblActivity"));
        MainClient.txt_formClt_shopAccount.setActionCommand("_TXT_activity");
        MainClient.txt_formClt_shopAccount.setName("_TXT_activity");
        MainClient.txt_formClt_shopAccount.addKeyListener(this);
        MainClient.txt_formClt_shopAccount.addFocusListener(this);

        MainClient.lbl_form_dni.setText(LanguageClt.getInstance().getProperty("DRW_lblDni"));
        MainClient.txtf_formClt_dni.setActionCommand("_TXT_dni");
        MainClient.txtf_formClt_dni.setName("_TXT_dni");
        MainClient.txtf_formClt_dni.addActionListener(this);
        MainClient.txtf_formClt_dni.addKeyListener(this);
        MainClient.txtf_formClt_dni.addFocusListener(this);

        MainClient.lbl_form_email.setText(LanguageClt.getInstance().getProperty("DRW_lblEmail"));
        MainClient.txtf_formClt_email.setActionCommand("_TXT_email");
        MainClient.txtf_formClt_email.setName("_TXT_email");
        MainClient.txtf_formClt_email.addActionListener(this);
        MainClient.txtf_formClt_email.addKeyListener(this);
        MainClient.txtf_formClt_email.addFocusListener(this);

        MainClient.lbl_form_lastName.setText(LanguageClt.getInstance().getProperty("DRW_lblLastName"));
        MainClient.txtf_formClt_lastname.setActionCommand("_TXT_lastName");
        MainClient.txtf_formClt_lastname.setName("_TXT_lastName");
        MainClient.txtf_formClt_lastname.addActionListener(this);
        MainClient.txtf_formClt_lastname.addKeyListener(this);
        MainClient.txtf_formClt_lastname.addFocusListener(this);

        MainClient.lbl_form_name.setText(LanguageClt.getInstance().getProperty("DRW_lblName"));
        MainClient.txtf_formClt_name.setActionCommand("_TXT_name");
        MainClient.txtf_formClt_name.setName("_TXT_name");
        MainClient.txtf_formClt_name.addActionListener(this);
        MainClient.txtf_formClt_name.addKeyListener(this);
        MainClient.txtf_formClt_name.addFocusListener(this);

        MainClient.lbl_form_phone.setText(LanguageClt.getInstance().getProperty("DRW_lblPhone"));
        MainClient.txtf_formClt_phone.setActionCommand("_TXT_phone");
        MainClient.txtf_formClt_phone.setName("_TXT_phone");
        MainClient.txtf_formClt_phone.addActionListener(this);
        MainClient.txtf_formClt_phone.addKeyListener(this);
        MainClient.txtf_formClt_phone.addFocusListener(this);

        MainClient.lbl_form_userName.setText(LanguageClt.getInstance().getProperty("DRW_lblUserName"));
        MainClient.txtf_formClt_username.setActionCommand("_TXT_userName");
        MainClient.txtf_formClt_username.setName("_TXT_userName");
        MainClient.txtf_formClt_username.addActionListener(this);
        MainClient.txtf_formClt_username.addKeyListener(this);
        MainClient.txtf_formClt_username.addFocusListener(this);
    }

    public static void runTABLE() {
        TABLA_CLT.setModel(new miniSimpleTableModel_Client());
        ((miniSimpleTableModel_Client) TABLA_CLT.getModel()).cargar();
        TABLA_CLT.setFillsViewportHeight(true);
        TABLA_CLT.setRowSorter(sorterClt);
        paginaClt.inicializa();
        paginaClt.initLinkBox();

        lbl_entries.setText(String.valueOf(singletonClient.ClienTableArray.size()));
        main_Client.lbl_filtBY.setText(LanguageClt.getInstance().getProperty("tbl_filter"));
        main_Client.lbl_rowBYpag.setText(LanguageClt.getInstance().getProperty("tbl_usrByPage"));
        main_Client.btn_tbl_back.setText(LanguageClt.getInstance().getProperty("tbl_back"));

        //combo lineas
        List<String> myWords = new ArrayList<String>();
        for (int i = 0; i <= singletonClient.ClienTableArray.size() - 1; i++) {
            myWords.add(singletonClient.ClienTableArray.get(i).getName().toLowerCase());
            myWords.add(singletonClient.ClienTableArray.get(i).getName());
        }

        StringSearchableClt searchable = new StringSearchableClt(myWords);
        main_Client.comboClt = new AutocompleteJComboBoxClt(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(main_Client.comboClt);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Accion.valueOf(evt.getActionCommand())) {
            //PNL_menuBtn action buttons
            case _BTN_back:
                BLL_Client.BLL_FC_mainBack();
                break;
            case _BTN_create:
                BLL_Client.BLL_CreateClt();
                break;
            case _BTN_createDummies:
                dummieClt_gen.menu_dummie();
                break;
            case _BTN_delete:
                BLL_Client.BLL_DeleteClt();
                break;
            case _BTN_deleteALL:
                BLL_Client.BLL_DeleteAllClt();
                break;
            case _BTN_modify:
                BLL_Client.BLL_ModifyClt();
                break;
            case _BTN_saveJSON:
                BLL_Client.BLL_ClientSaveJSON();
                break;
            case _BTN_saveTXT:
                BLL_Client.BLL_ClientSaveTXT();
                break;
            case _BTN_saveXML:
                BLL_Client.BLL_ClientSaveXML();
                break;
            case _BTN_view:
                BLL_Client.BLL_ViewClt();
                break;
            //BTNs of formAdmin
            case _BTN_avatar:
                BLL_Client.BLL_Avatar();
                break;
            case _BTN_formBack:
                BLL_Client.BLL_FC_HideNewFormPanel();
                break;
            case _BTN_formCreate:
                BLL_Client.BLL_FC_formCreate();
                break;
            //BTNs of TablePager
            case _BTN_ANTERIOR:
                BLL_Client.BLL_TBL_Previous();
                break;
            case _BTN_SIGUIENTE:
                BLL_Client.BLL_TBL_Next();
                break;
            case _BTN_primero:
                BLL_Client.BLL_TBL_First();
                break;
            case _BTN_ultimo:
                BLL_Client.BLL_TBL_Last();
                break;
            case _BTN_TBL_back:
                BLL_Client.BLL_FC_mainBack();
                break;
            case _CB_TBL_entries:
                BLL_Client.BLL_TBL_CB_entries();
                break;
            case _combo:
                BLL_Client.BLL_TBL_combo();
                break;
            case _JPF_passConf:
                BLL_Client.BLL_JPF_PassConfirm();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Client.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Client.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Client.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Client.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Client.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Client.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Client.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Client.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Client.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
         switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Client.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Client.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Client.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Client.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Client.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Client.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Client.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Client.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Client.BLL_txtUsername();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Client.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Client.BLL_JPF_PassConfirm();
                break;
            case _TXT_activity:
                BLL_Client.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Client.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Client.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Client.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Client.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Client.BLL_txtPhone();
                break;
            case _TXT_userName:
                BLL_Client.BLL_txtUsername();
                break;
            
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TABLA:
                BLL_Client.BLL_TableMouseClick(evt);
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
                BLL_Client.BLL_JPF_Password();
                break;
            case _TXT_activity:
                BLL_Client.BLL_Activity();
                break;
            case _TXT_dni:
                BLL_Client.BLL_FC_CleanDNI();
                break;
            case _TXT_email:
                BLL_Client.BLL_FC_CleanEmail();
                break;
            case _TXT_lastName:
                BLL_Client.BLL_FC_CleanLastName();
                break;
            case _TXT_name:
                BLL_Client.BLL_FC_CleanName();
                break;
            case _TXT_phone:
                BLL_Client.BLL_FC_CleanPhone();
                break;
            default:
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        switch(Accion.valueOf(evt.getComponent().getName())){
            case _JPF_pass:
                BLL_Client.BLL_JPF_Password();
                break;
            case _JPF_passConf:
                BLL_Client.BLL_JPF_PassConfirm();
                break;
            case _TXT_dni:
                BLL_Client.BLL_txtDNI();
                break;
            case _TXT_email:
                BLL_Client.BLL_txtEmail();
                break;
            case _TXT_lastName:
                BLL_Client.BLL_txtLastname();
                break;
            case _TXT_name:
                BLL_Client.BLL_txtName();
                break;
            case _TXT_phone:
                BLL_Client.BLL_Activity();
                break;
            case _TXT_userName:
                BLL_Client.BLL_txtUsername();
                break;
            default:
                break;
        }
    }
    public void propertyChange(PropertyChangeEvent evt){
        switch(Accion.valueOf(evt.getPropertyName())){
            case _DC_bornDate:
                BLL_Client.BLL_DCBornDate();
                break;
            case _DC_singDate:
                BLL_Client.BLL_DCSingDate();
                break;
            default:
                break;
        }
    }
}
