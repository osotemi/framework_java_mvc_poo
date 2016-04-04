/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.BLL;

import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import framework.mod.settings.model.DAO.DAO_settings;
import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import framework.mod.settings.model.clss.singletonProfile;
import framework.mod.settings.model.tools.LooknFeel;
import framework.mod.settings.view.wdwSettings;
import framework.mod.user.admin.controler.Controler_mainAdmin;
import java.util.Locale;
import javax.swing.LookAndFeel;

/**
 *
 * @author osotemi
 */
public class BLL_settings {
    
    public static void BLL_drawSettingsPanel(){
        DAO_settings.drawCurrency();
        DAO_settings.drawFileType();
        DAO_settings.drawLanguange();
        
    }
    
    //Buttons BLLs
    //Currency buttoms
    public static void BLL_BTN_currDolar(){
        Settings.getInstance().setCurrency(Locale.US);
        //guardar settings
        DAO_settings.drawCurrency();
    }
    
    public static void BLL_BTN_currPounds(){
        Settings.getInstance().setCurrency(Locale.UK);
        //guardar settings
        DAO_settings.drawCurrency();
    }
    
    public static void BLL_BTN_currEuros(){
        Settings.getInstance().setCurrency(Locale.FRANCE);
        //guardar settings
        DAO_settings.drawCurrency();
    }
    
    //File Type
    public static void BLL_BTN_FTjson(){
        Settings.getInstance().setFile_type(singleSettings.FILET_json);
        //guardar settings
        DAO_settings.drawFileType();
    }
    
    public static void BLL_BTN_FTtxt(){
        Settings.getInstance().setFile_type(singleSettings.FILET_txt);
        //guardar settings
        DAO_settings.drawFileType();
    }
    
    public static void BLL_BTN_FTxml(){
        Settings.getInstance().setFile_type(singleSettings.FILET_xml);
        //guardar settings
        DAO_settings.drawFileType();
    }
    
    //Format date
    public static void BLL_JC_FD(){
        Settings.getInstance().setFdate((String)wdwSettings.JCB_formatDate.getSelectedItem());
    }
    
    //Language
    public static void BLL_BTN_lang_galiza(){
        Settings.getInstance().setLanguage(singleSettings.LANG_GZ);
        //guardar settings
        DAO_settings.drawLanguange();
    }
    
    public static void BLL_BTN_lang_spanish(){
        Settings.getInstance().setLanguage(singleSettings.LANG_ES);
        //guardar settings
        DAO_settings.drawLanguange();
    }
    
    public static void BLL_BTN_lang_english(){
        Settings.getInstance().setLanguage(singleSettings.LANG_UK);
        //guardar settings
        DAO_settings.drawLanguange();
    }
    
    public static void BLL_BTN_lang_valencia(){
        Settings.getInstance().setLanguage(singleSettings.LANG_VLC);
        //guardar settings
        DAO_settings.drawLanguange();
    }
    
    public static void BLL_BTN_thm_native(){
        Settings.getInstance().setLookfeel(singletonProfile.THM_native);
        LooknFeel.LookFeel();
    }
            
    public static void BLL_BTN_thm_nimbus(){
        Settings.getInstance().setLookfeel(singletonProfile.THM_nimbus);
        LooknFeel.LookFeel();
    }    
    
    public static void BLL_BTN_thm_motif(){
        Settings.getInstance().setLookfeel(singletonProfile.THM_motif);
        LooknFeel.LookFeel();
    }
    
    public static void BLL_BTN_thm_win(){
        Settings.getInstance().setLookfeel(singletonProfile.THM_windows);
        LooknFeel.LookFeel();
    }
    
    public static void BLL_BTN_thm_win98(){
        Settings.getInstance().setLookfeel(singletonProfile.THM_win98);
        LooknFeel.LookFeel();
    }
    
}
