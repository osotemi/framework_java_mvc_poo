/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.controler;

import framework.clss.singletonGen;
import framework.mod.settings.model.BLL.BLL_settings;
import framework.mod.settings.model.clss.profile_json;
import framework.mod.settings.model.tools.Language;
import framework.mod.settings.view.main;
import framework.mod.settings.view.main_login;
import framework.mod.settings.view.wdwSettings;
import framework.mod.user.admin.controler.Controler_mainAdmin;
import framework.mod.user.admin.model.tools.LanguageAdm;
import framework.mod.user.admin.view.main_Admin;
import framework.mod.user.client.controler.Controler_mainClient;
import framework.mod.user.client.model.tools.LanguageClt;
import framework.mod.user.client.view.main_Client;
import framework.mod.user.registered.controler.Controler_mainReg;
import framework.mod.user.registered.model.tools.LanguageReg;
import framework.mod.user.registered.view.main_Reg;
import framework.tools.menu_gen;
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author osotemi
 */
public class Controler_Main implements ActionListener, KeyListener, MouseListener, FocusListener {

    public static wdwSettings Conf;
    public static main MainMenu;
    public static main_login LoginLayout;

    public Controler_Main(JFrame layout, int option) {
        switch(option){
            case 0://Menu principal
                MainMenu = (main) layout;
                break;
            case 1://Menu Config
                Conf = (wdwSettings) layout;
                break;
            case 2://
                LoginLayout = (main_login) layout;
                break;
            default:
                System.err.println("Error controler main");
                break;
        }
        

    }

    public enum Accion {
        //Currency
        _BTN_currDolar,
        _BTN_currEuro,
        _BTN_currPound,
        //Decimal
        _SPN_decimal,
        //FileType
        _BTN_FTjson,
        _BTN_FTtxt,
        _BTN_FTxml,
        //FormatDate
        _JC_formatDate,
        //Language
        _BTN_LNGes,
        _BTN_LNGgz,
        _BTN_LNGuk,
        _BTN_LNGvlc,
        //LookNFeel
        _BTN_Native,
        _BTN_Nimbus,
        _BTN_Motif,
        _BTN_Windows,
        _BTN_Win98,
        //___main window
        _BTN_Admin,
        _BTN_Client,
        _BTN_Reg,
        _BTN_Config,
        
    }

    public void run(int optionFrame) {
        Image icono = null;
        switch(optionFrame){
            case 0:
                MainMenu.setVisible(true);
                
                //Inicia la vista
                MainMenu.setTitle("Servicios farmaceúticos");
                MainMenu.setLocationRelativeTo(null);//centrado
                try {
                    icono = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
                } catch (IOException e) {

                }
                MainMenu.setIconImage(icono);
                MainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

                MainMenu.addWindowFocusListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        MainMenu.dispose();
                    }
                });
                MainMenu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.MainMenu.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        MainMenu.dispose();                        
                        singletonGen.mongo.disconnect();
                    }
                });
                
                drawMain();
                MainMenu.btn_conf.setOpaque(false);

                //Inicia los componentes
                MainMenu.btn_AdminGOTO_mainAdmin.setActionCommand("_BTN_Admin");
                MainMenu.btn_AdminGOTO_mainAdmin.setName("_BTN_Admin");
                MainMenu.btn_AdminGOTO_mainAdmin.addActionListener(this);

                MainMenu.btn_ClientGOTO_mainClient.setActionCommand("_BTN_Client");
                MainMenu.btn_ClientGOTO_mainClient.setName("_BTN_Client");
                MainMenu.btn_ClientGOTO_mainClient.addActionListener(this);

                MainMenu.btn_RegGOTO_mainReg.setActionCommand("_BTN_Reg");
                MainMenu.btn_RegGOTO_mainReg.setName("_BTN_Reg");
                MainMenu.btn_RegGOTO_mainReg.addActionListener(this);

                MainMenu.btn_conf.setActionCommand("_BTN_Config");
                MainMenu.btn_conf.setName("_BTN_Config");
                MainMenu.btn_conf.addActionListener(this);
                break;
            case 1: 
                Conf.setVisible(true);
                Conf.setTitle(Language.getInstance().getProperty("wdwSettings_title"));
                Conf.setSize(770, 425);//ancho x alto
                Conf.setResizable(false);
                try {
                    icono = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
                } catch (IOException e) {

                }
                Conf.setLocationRelativeTo(null);//centrado
                Conf.setIconImage(icono);
                //Conf.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

                Conf.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.Conf.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        Conf.dispose();                        
                        Controler_Main.drawMain();
                    }
                });

                writeConfigFrame();

                BLL_settings.BLL_drawSettingsPanel();

                //Inicia los componentes del menu de configuración
                //Currency tab
                Conf.btn_currDolar.setActionCommand("_BTN_currDolar");
                Conf.btn_currDolar.setName("_BTN_currDolar");
                Conf.btn_currDolar.addActionListener(this);

                Conf.btn_currEuro.setActionCommand("_BTN_currEuro");
                Conf.btn_currEuro.setName("_BTN_currEuro");
                Conf.btn_currEuro.addActionListener(this);

                Conf.btn_currPound.setActionCommand("_BTN_currPound");
                Conf.btn_currPound.setName("_BTN_currPound");
                Conf.btn_currPound.addActionListener(this);
                //Decimal tab
                Conf.JSP_decimals.setName("_SPN_decimal");
                //File Type tab
                Conf.btn_confJSON.setActionCommand("_BTN_FTjson");
                Conf.btn_confJSON.addActionListener(this);

                Conf.btn_confTXT.setActionCommand("_BTN_FTtxt");
                Conf.btn_confTXT.addActionListener(this);

                Conf.btn_confXML.setActionCommand("_BTN_FTxml");
                Conf.btn_confXML.addActionListener(this);
                //Format Date tab
                Conf.JCB_formatDate.setActionCommand("_JC_formatDate");
                Conf.JCB_formatDate.addActionListener(this);
                //Language
                Conf.btn_galiza.setActionCommand("_BTN_LNGgz");
                Conf.btn_galiza.addActionListener(this);

                Conf.btn_spain.setActionCommand("_BTN_LNGes");
                Conf.btn_spain.addActionListener(this);

                Conf.btn_unitedk.setActionCommand("_BTN_LNGuk");
                Conf.btn_unitedk.addActionListener(this);

                Conf.btn_valencia.setActionCommand("_BTN_LNGvlc");
                Conf.btn_valencia.addActionListener(this);
                
                Conf.btn_native.setActionCommand("_BTN_Native");
                Conf.btn_native.addActionListener(this);
                        
                Conf.btn_nimbus.setActionCommand("_BTN_Nimbus");
                Conf.btn_nimbus.addActionListener(this);
                        
                Conf.btn_motive.setActionCommand("_BTN_Motif");
                Conf.btn_motive.addActionListener(this);
                
                Conf.btn_windows.setActionCommand("_BTN_Windows");
                Conf.btn_windows.addActionListener(this);
                        
                Conf.btn_win98.setActionCommand("_BTN_Win98");
                Conf.btn_win98.addActionListener(this);
                break;
            default:
                break;
        }
        
    }

    public static void writeConfigFrame(){
        //Inicializa los mensajes de properties
        Conf.setTitle(Language.getInstance().getProperty("wdwSettings_title"));
        //Currency tab
        Conf.LBL_currency.setFont(new java.awt.Font("Dialog", 1, 14));
        Conf.LBL_currency.setText(Language.getInstance().getProperty("curr_mess"));
        Conf.TABgen.setTitleAt(0, Language.getInstance().getProperty("TABcurrency"));
        
        //Date format
        Conf.lbl_fdate.setFont(new java.awt.Font("Dialog", 1, 14));
        Conf.lbl_fdate.setText(Language.getInstance().getProperty("date_mess"));
        
        Conf.TABgen.setTitleAt(1, Language.getInstance().getProperty("TABdateform"));
        
        //Decimal tab
        Conf.lbl_decimal.setFont(new java.awt.Font("Dialog", 1, 14));
        Conf.lbl_decimal.setText(Language.getInstance().getProperty("dec_mess"));
        Conf.TABgen.setTitleAt(2, Language.getInstance().getProperty("TABdecimal"));
        
        //File type
        Conf.LBL_fileType.setFont(new java.awt.Font("Dialog", 1, 14));
        Conf.LBL_fileType.setText(Language.getInstance().getProperty("fileform_mess"));
        Conf.TABgen.setTitleAt(3, Language.getInstance().getProperty("TABfileType"));
        
        //Language
        Conf.LBL_selectLanguage.setFont(new java.awt.Font("Dialog", 1, 14));
        Conf.LBL_selectLanguage.setText(Language.getInstance().getProperty("lang_mess"));
        Conf.TABgen.setTitleAt(4, Language.getInstance().getProperty("TABlanguage"));
        
        
        //Look&feel
        Conf.TABgen.setTitleAt(5, Language.getInstance().getProperty("TABlookNfeel"));
        Conf.TABgen. setFont(new java.awt.Font("Dialog", 2, 14));
    }
    
    public static void drawMain(){
        MainMenu.setTitle(Language.getInstance().getProperty("main_title"));
        MainMenu.btn_AdminGOTO_mainAdmin.setText(Language.getInstance().getProperty("BTN_Admin"));
        MainMenu.btn_ClientGOTO_mainClient.setText(Language.getInstance().getProperty("BTN_Client"));
        MainMenu.btn_RegGOTO_mainReg.setText(Language.getInstance().getProperty("BTN_Reg"));
        MainMenu.btn_conf.setText(Language.getInstance().getProperty("LBL_Config"));
    }
    
    public static void drawLogin (){
        LoginLayout.lbl_userName.setText("");
        LoginLayout.lbl_passWord.setText("");
        
        
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch ( Accion.valueOf(evt.getActionCommand()) ){
            case _BTN_Admin:     
                LanguageAdm.getInstance().loadProperties();
                
                new Controler_mainAdmin(new main_Admin()).run();
                MainMenu.dispose();
                
                break;
             case _BTN_Client:     
                LanguageClt.getInstance().loadProperties();
                new Controler_mainClient(new main_Client()).run();
                MainMenu.dispose();
                
                break;
             case _BTN_Reg:     
                LanguageReg.getInstance().loadProperties();
                new Controler_mainReg(new main_Reg()).run();
                MainMenu.dispose();
                
                break;
            case _BTN_Config:
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
                
            case _BTN_currDolar:
                BLL_settings.BLL_BTN_currDolar();
                break;
            case _BTN_currEuro:
                BLL_settings.BLL_BTN_currEuros();
                break;
            case _BTN_currPound:
                BLL_settings.BLL_BTN_currPounds();
                break;
            case _SPN_decimal:
                
                break;
            case _BTN_FTjson:
                BLL_settings.BLL_BTN_FTjson();
                break;
            case _BTN_FTtxt:
                BLL_settings.BLL_BTN_FTtxt();
                break;
            case _BTN_FTxml:
                BLL_settings.BLL_BTN_FTxml();
                break;
            case _JC_formatDate:
                BLL_settings.BLL_JC_FD();
                break;
            case _BTN_LNGes: 
                BLL_settings.BLL_BTN_lang_spanish();
                Language.getInstance().loadProperties();
                writeConfigFrame();
                break;
            case _BTN_LNGgz: 
                BLL_settings.BLL_BTN_lang_galiza();
                Language.getInstance().loadProperties();
                writeConfigFrame();
                break;
            case _BTN_LNGuk: 
                BLL_settings.BLL_BTN_lang_english();
                Language.getInstance().loadProperties();
                writeConfigFrame();
                break;
            case _BTN_LNGvlc: 
                BLL_settings.BLL_BTN_lang_valencia();
                Language.getInstance().loadProperties();
                writeConfigFrame();
                break;
            case _BTN_Native:
                BLL_settings.BLL_BTN_thm_native();
                MainMenu.dispose();
                Conf.dispose();
                new Controler_Main(new main(), 0).run(0);
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
            case _BTN_Nimbus:
                BLL_settings.BLL_BTN_thm_nimbus();
                MainMenu.dispose();
                Conf.dispose();
                new Controler_Main(new main(), 0).run(0);
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
            case _BTN_Motif:
                BLL_settings.BLL_BTN_thm_motif();
                MainMenu.dispose();
                Conf.dispose();
                new Controler_Main(new main(), 0).run(0);
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
            case _BTN_Windows:
                BLL_settings.BLL_BTN_thm_win();
                MainMenu.dispose();
                Conf.dispose();
                new Controler_Main(new main(), 0).run(0);
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
            case _BTN_Win98:
                BLL_settings.BLL_BTN_thm_win98();
                MainMenu.dispose();
                Conf.dispose();
                new Controler_Main(new main(), 0).run(0);
                new Controler_Main(new wdwSettings(), 1).run(1);
                break;
            default:
                break;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void mouseEntered(MouseEvent evt) {
        switch ( Accion.valueOf(evt.getComponent().getName()) ){
            case _BTN_currDolar:
                
                Conf.btn_currDolar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(155, 155, 155), 2));
                Conf.btn_currDolar.setOpaque(true);
                Conf.btn_currDolar.setBackground(Color.lightGray);
                break;
            case _BTN_currEuro:
                
                break;
            case _BTN_currPound:
                
                break;
            case _SPN_decimal:
                break;
            case _BTN_FTjson:
                break;
            case _BTN_FTtxt:
                break;
            case _BTN_FTxml:
                break;
            case _JC_formatDate:
                break;
            case _BTN_LNGes: 
                break;
            case _BTN_LNGgz: 
                break;
            case _BTN_LNGuk: 
                break;
            case _BTN_LNGvlc: 
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
