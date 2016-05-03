/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.clss;

import framework.mod.settings.model.tools.Language;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.clss.MongoDB;
import framework.clss.singletonGen;
import framework.mod.settings.model.tools.LooknFeel;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.client.model.classes.singletonClient;
import framework.mod.user.registered.model.classes.singletonReg;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osotemi
 */
@XStreamAlias("Settings")
public class Settings implements Serializable {

    /**
     * Settings attribute
     */
    @XStreamAlias("Name")
    private static String name;
    @XStreamAlias("decimal")
    private static int decimal;
    @XStreamAlias("language")
    private static String language;
    @XStreamAlias("fdate")
    private static String fdate;
    @XStreamAlias("currency")
    private static Locale currency;
    @XStreamAlias("looknfeel")
    private static String looknfeel;
    @XStreamAlias("file_type")
    private static String file_type;
    @XStreamAlias("instance")
    private static Settings instance;

    /**
     * Setting Constructor
     *
     *  initialization of Setting singleton object at decimal = 2/
     * language = "ES"/ fdate = "dd/MM/yyyy"/ currency = Locale.FRANCE/
     * file_type = ".xml"/ looknfeel = "Motif";
     * 
     */
    protected Settings(){
            name = "Default";
            decimal = 2;
            language = singleSettings.LANG_ES;
            fdate = "dd/MM/yyyy";
            currency = Locale.FRANCE;
            file_type = ".json";
            looknfeel = "WindowsC";
    }
    
    /**
     * If instance == null; initiates the default values of settings
     * Then, return settings
     * If not null; return settings
     * 
     * @return Settings
     */
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
            try {
                singletonGen.mongo = new MongoDB();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            singletonProfile.Alist_Profile = new ArrayList<>();
            profile_json.Profiles_Autoload();
            singletonProfile.Alist_Profile.get(0).ProfilesTOSettings();
            //LooknFeel.LookFeel();
            //Language.getInstance();
            singletonAdmin.loadSingletonAdmin();
            singletonClient.loadSingletonClient();
            singletonReg.loadSingletonReg();
            singletonProfile.loadProfile();
            fdate = "dd/MM/yyyy";//Temporally
        }
        return instance;
    }

    public String getLooknfeel() {
        return looknfeel;
    }

    public String getFile_type() {
        return file_type;
    }

    public int getDecimal() {
        return decimal;
    }

    public String getLanguage() {
        return language;
    }

    public String getFdate() {
        return fdate;
    }

    public Locale getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Settings.name = name;
    }

    public void setInstance(Settings instance) {
        Settings.instance = instance;
    }

    public void setLooknfeel(String looknfeel) {
        Settings.looknfeel = looknfeel;
    }

    public void setFile_type(String file_type) {
        Settings.file_type = file_type;
    }

    public void setDecimal(int decimal) {
        Settings.decimal = decimal;
    }

    public void setLanguage(String lenguage) {
        Settings.language = lenguage;
        Language.getInstance().loadProperties();
    }

    public void setFdate(String fdate) {
        Settings.fdate = fdate;
    }

    public void setCurrency(Locale currency) {
        Settings.currency = currency;
    }

    public void setLookfeel(String lookfeel) {
        Settings.looknfeel = lookfeel;
        LooknFeel.LookFeel();
    }

    @Override
    public String toString() {
        StringBuffer outline = new StringBuffer();
        try {
            outline.append("Decimal: " + this.getDecimal() + "\n");
            outline.append("Language: " + this.getLanguage() + "\n");
            outline.append("Date format: " + this.getFdate() + "\n");
            outline.append("Currency" + this.getCurrency() + "\n");
            outline.append("File format: " + this.getFile_type() + "\n");
            outline.append("Look & feel theme: " + this.getLooknfeel() + "\n");
            outline.append("Profile name " + this.getName() + "\n");
        } catch (Exception e) {
            try {
                outline.append("ERR showing " + this.getName() + "profile" + "\n");
            } catch (Exception e2) {
                outline.append("EMPTY");
            }
        }
        return outline.toString();
    }
}
