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
import framework.mod.user.admin.view.main_Admin;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osotemi
 */
public class Controler_main implements ActionListener {

    public static main MainMenu;

    public Controler_main(main menu) {
        MainMenu = (main) menu;
    }

    public enum Accion {

        _BTN_Admin,
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
        
        MainMenu.btn_conf.setActionCommand("_BTN_Config");
        MainMenu.btn_conf.setName("_BTN_Config");
        MainMenu.btn_conf.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Accion.valueOf(evt.getActionCommand())) {
            case _BTN_Admin:               
                new Controler_mainAdmin(new main_Admin()).run();
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
