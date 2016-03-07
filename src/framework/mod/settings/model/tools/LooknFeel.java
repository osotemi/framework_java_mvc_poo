/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.tools;

import framework.mod.settings.model.clss.Settings;
import javax.swing.UIManager;

/**
 *
 * @author osotemi
 */
public class LooknFeel {
    public static void LookFeel(){
        switch (Settings.getInstance().getLooknfeel()) {
        case "Native":
            try{//predetermminated
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception e){
                System.out.println("No se pudo establecer el Look&Feel");
            }
            break;
        case "Nimbus"://Nimbus
            try{
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            }catch(Exception e){
                System.out.println("No se pudo establecer el Look&Feel");
            }
            break;
        case "Motif"://Motif
            try{
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            }catch(Exception e){
                System.out.println("No se pudo establecer el Look&Feel");
            }
            break;
        case "Windows"://Windows
            try{
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }catch(Exception e){
                System.out.println("No se pudo establecer el Look&Feel");
            }
            break;

        case "WindowsC"://Windows Clasic
            try{
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            }catch(Exception e){
                System.out.println("No se pudo establecer el Look&Feel");
            }
            break;
        default:
            break;
        }
    }
}
