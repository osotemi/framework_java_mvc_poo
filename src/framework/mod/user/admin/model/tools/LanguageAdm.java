/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.tools;

import framework.mod.settings.model.clss.Settings;
import framework.mod.settings.model.clss.singleSettings;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

/**
 *
 * @author osotemi
 */
public class LanguageAdm extends Properties{
    private static final long serialVersionUID = 1L;
	private static LanguageAdm instance;
	
	public static LanguageAdm getInstance(){
            if(instance==null) {
                    instance = new LanguageAdm();
            }

            return instance;
	}
	
	protected LanguageAdm(){
		
            switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                    this.getProperties("propAdmin/spanishAdm.properties");
                    break;
            case singleSettings.LANG_VLC:
                    this.getProperties("propAdmin/valenciAdm.properties");
                    break;
            case singleSettings.LANG_GZ:
                    this.getProperties("propAdmin/galicianAdm.properties");
                    break;
            default://UK
                    this.getProperties("propAdmin/englishAdm.properties");
                    break;	
            }
	}
	
	public void loadProperties(){
            switch (Settings.getInstance().getLanguage()) {
            case singleSettings.LANG_ES:
                    this.getProperties("propAdmin/spanishAdm.properties");
                    break;
            case singleSettings.LANG_VLC:
                    this.getProperties("propAdmin/valenciAdm.properties");
                    break;
            case singleSettings.LANG_GZ:
                    this.getProperties("propAdmin/galicianAdm.properties");
                    break;
            default://UK
                    this.getProperties("propAdmin/englishAdm.properties");
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
