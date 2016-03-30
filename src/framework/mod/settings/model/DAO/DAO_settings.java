/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.DAO;

import framework.mod.settings.controler.Controler_wdwSettings;
import static framework.mod.settings.controler.Controler_wdwSettings.Conf;
import framework.mod.settings.model.clss.Language;
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
            Conf.btn_currDolar.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
            Conf.btn_currEuro.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
            Conf.btn_currPound.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        } else if (Settings.getInstance().getCurrency().equals(Locale.UK)){
            Conf.btn_currDolar.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
            Conf.btn_currEuro.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
            Conf.btn_currPound.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
        } else if (Settings.getInstance().getCurrency().equals(Locale.FRANCE) ){
            Conf.btn_currDolar.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
            Conf.btn_currEuro.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
            Conf.btn_currPound.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
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

    public static void writeConfigFrame(){
        //Inicializa los mensajes de properties
        Conf.setTitle(Language.getInstance().getProperty("wdwSettings_title"));
        //Currency tab
        Conf.LBL_currency.setText(Language.getInstance().getProperty("curr_mess"));
        Conf.TABgen.setTitleAt(0, Language.getInstance().getProperty("TABcurrency"));
        
        //Date format
        Conf.LBL_formatDate.setText(Language.getInstance().getProperty("date_mess"));
        Conf.TABgen.setTitleAt(1, Language.getInstance().getProperty("TABdateform"));
        
        //Decimal tab
        Conf.TABgen.setTitleAt(2, Language.getInstance().getProperty("TABdecimal"));
        
        //File type
        Conf.LBL_fileType.setText(Language.getInstance().getProperty("fileform_mess"));
        Conf.TABgen.setTitleAt(3, Language.getInstance().getProperty("TABfileType"));
        
        //Language
        Conf.TABgen.setTitleAt(4, Language.getInstance().getProperty("TABlanguage"));
        
        //Look&feel
        Conf.TABgen.setTitleAt(5, Language.getInstance().getProperty("TABlookNfeel"));
    }
}
