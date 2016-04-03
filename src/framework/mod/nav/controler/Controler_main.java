/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.nav.controler;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import framework.mod.nav.view.main;
import framework.mod.settings.controler.Controler_wdwSettings;
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
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *
 * @author osotemi
 */
public class Controler_main implements ActionListener {

    public static main MainMenu;

    public Controler_main(main inicio) {
        MainMenu = (main) inicio;
    }

    public enum Accion {

        _BTN_Admin,
        _BTN_Client,
        _BTN_Reg,
        _BTN_Config,
    }

    public void run() {
        MainMenu.setVisible(true);
        Image icono = null;
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

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Accion.valueOf(evt.getActionCommand())) {
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
                new Controler_wdwSettings(new wdwSettings()).run();
                break;
            default:
                break;
        }
    }
}
