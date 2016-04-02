/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.tools;

import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author osotemi
 */
public class LanguageClt extends Properties {

    private static final long serialVersionUID = 1L;
    private static LanguageClt instance;

    public static LanguageClt getInstance() {
        if (instance == null) {
            instance = new LanguageClt();
        }

        return instance;
    }

    protected LanguageClt() {

        switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                this.getProperties("propClient/spanishClt.properties");
                break;
            case singleSettings.LANG_VLC:
                this.getProperties("propClient/valencianClt.properties");
                break;
            case singleSettings.LANG_GZ:
                this.getProperties("propClient/galicianClt.properties");
                break;
            default://UK
                this.getProperties("propClient/englishClt.properties");
                break;
        }
    }

    public void loadProperties() {
        switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                this.getProperties("propClient/spanishClt.properties");
                break;
            case singleSettings.LANG_VLC:
                this.getProperties("propClient/valencianClt.properties");
                break;
            case singleSettings.LANG_GZ:
                this.getProperties("propClient/galicianClt.properties");
                break;
            default://UK
                this.getProperties("propClient/englishClt.properties");
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
