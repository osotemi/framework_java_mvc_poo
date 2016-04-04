/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.tools;

import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author osotemi
 */
public class Language extends Properties{
    private static final long serialVersionUID = 1L;
	private static Language instance;
	
	public static Language getInstance(){
            if(instance==null) {
                    instance = new Language();
            }

            return instance;
	}
	
	protected Language(){
		
            switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                    this.getProperties("prop/spanish.properties");
                    break;
            case singleSettings.LANG_VLC:
                    this.getProperties("prop/valencia.properties");
                    break;
            case singleSettings.LANG_GZ:
                    this.getProperties("prop/galician.properties");
                    break;
            default://UK
                    this.getProperties("prop/english.properties");
                    break;	
            }
	}
	
	public void loadProperties(){
            switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                    this.getProperties("prop/spanish.properties");
                    break;
            case singleSettings.LANG_VLC:
                    this.getProperties("prop/valencia.properties");
                    break;
            case singleSettings.LANG_GZ:
                    this.getProperties("prop/galician.properties");
                    break;
            default://UK
                    this.getProperties("prop/english.properties");
                    break;	
            }
		
	}
	
	public void getProperties(String prop_file){
            try {
                this.load( getClass().getResourceAsStream(prop_file) );
            } catch (IOException ex) {
        	ex.printStackTrace();
            }
	}	
}
