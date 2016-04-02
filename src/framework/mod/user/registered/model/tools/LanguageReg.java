/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.tools;

import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author osotemi
 */
public class LanguageReg extends Properties {

    private static LanguageReg instance;
    private static final long serialVersionUID = 3L;

    public static LanguageReg getInstance() {
        if (instance == null) {
            instance = new LanguageReg();
        }

        return instance;
    }

    protected LanguageReg() {

        switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                this.getProperties("propReg/spanishReg.properties");
                break;
            case singleSettings.LANG_VLC:
                this.getProperties("propReg/valencianReg.properties");
                break;
            case singleSettings.LANG_GZ:
                this.getProperties("propReg/galicianReg.properties");
                break;
            default://UK
                this.getProperties("propReg/englishReg.properties");
                break;
        }
    }

    public void loadProperties() {
        switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                this.getProperties("propReg/spanishReg.properties");
                break;
            case singleSettings.LANG_VLC:
                this.getProperties("propReg/valencianReg.properties");
                break;
            case singleSettings.LANG_GZ:
                this.getProperties("propReg/galicianReg.properties");
                break;
            default://UK
                this.getProperties("propReg/englishReg.properties");
                break;
        }

    }

    public void getProperties(String prop_file) {
        try {
            this.load(getClass().getResourceAsStream(prop_file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
