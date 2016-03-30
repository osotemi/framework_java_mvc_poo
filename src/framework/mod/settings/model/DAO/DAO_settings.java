/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.DAO;

import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import framework.mod.settings.view.wdwSettings;
import java.awt.Color;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class DAO_settings {
    
    public static void drawCurrency(){
        //Currency
        if( Settings.getInstance().getCurrency().equals(Locale.US) ){
            wdwSettings.btn_currDolar.setSelected(true);
            wdwSettings.JP_currDolar.setOpaque(true);
            wdwSettings.JP_currDolar.setBackground(Color.green);
            wdwSettings.JP_currEuro.setOpaque(false);
            wdwSettings.JP_currEuro.setBackground(null);
            wdwSettings.JP_currPound.setOpaque(false);
            wdwSettings.JP_currPound.setBackground(null);
        } else if (Settings.getInstance().getCurrency().equals(Locale.UK)){
            wdwSettings.btn_currPound.setSelected(true);
            wdwSettings.JP_currPound.setOpaque(true);
            wdwSettings.JP_currPound.setBackground(Color.green);
            wdwSettings.JP_currEuro.setOpaque(false);
            wdwSettings.JP_currEuro.setBackground(null);
            wdwSettings.JP_currDolar.setOpaque(false);
            wdwSettings.JP_currDolar.setBackground(null);
        } else if (Settings.getInstance().getCurrency().equals(Locale.FRANCE) ){
            wdwSettings.btn_currEuro.setSelected(true);
            wdwSettings.JP_currEuro.setOpaque(true);
            wdwSettings.JP_currEuro.setBackground(Color.green);
            wdwSettings.JP_currDolar.setOpaque(false);
            wdwSettings.JP_currDolar.setBackground(null);
            wdwSettings.JP_currPound.setOpaque(false);
            wdwSettings.JP_currPound.setBackground(null);
        } else {
            System.out.println("Error drawing currency");
        }
    }
    
    public static void drawDecimals(){
        
    }
    
    public static void drawFileType(){
        switch(Settings.getInstance().getFile_type()){
            case singleSettings.FILET_json:
                wdwSettings.btn_confJSON.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
                wdwSettings.btn_confTXT.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                wdwSettings.btn_confXML.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                break;
            case singleSettings.FILET_txt:
                wdwSettings.btn_confJSON.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                wdwSettings.btn_confTXT.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
                wdwSettings.btn_confXML.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                break;
            case singleSettings.FILET_xml:
                wdwSettings.btn_confJSON.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                wdwSettings.btn_confTXT.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
                wdwSettings.btn_confXML.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
                break;
            default:
                System.out.println("Error drawing file type settings");
                break;
        }
    }
    
    public static void drawFormatDate(){
        
    }
    
    public static void drawLanguange(){
        switch(Settings.getInstance().getLanguage()){
            case singleSettings.LANG_ES:
                wdwSettings.JP_langES.setBackground(Color.green);
                wdwSettings.JP_langGZ.setBackground(Color.white);
                wdwSettings.JP_langUK.setBackground(Color.white);
                wdwSettings.JP_langVLC.setBackground(Color.white);
                break;
            case singleSettings.LANG_GZ:
                wdwSettings.JP_langGZ.setBackground(Color.green);
                wdwSettings.JP_langES.setBackground(Color.white);
                wdwSettings.JP_langUK.setBackground(Color.white);
                wdwSettings.JP_langVLC.setBackground(Color.white);
                break;
            case singleSettings.LANG_UK:
                wdwSettings.JP_langUK.setBackground(Color.green);
                wdwSettings.JP_langES.setBackground(Color.white);
                wdwSettings.JP_langGZ.setBackground(Color.white);
                wdwSettings.JP_langVLC.setBackground(Color.white);
                break;
            case singleSettings.LANG_VLC:
                wdwSettings.JP_langVLC.setBackground(Color.green);
                wdwSettings.JP_langES.setBackground(Color.white);
                wdwSettings.JP_langGZ.setBackground(Color.white);
                wdwSettings.JP_langUK.setBackground(Color.white);
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Entrar entra mal");
                break;
        }
    }
    
    public static void drawSelectedSettings(){
        
        //Decimals
        
        //File type
        
        //Date Format
        
        //Language
        
    }
}