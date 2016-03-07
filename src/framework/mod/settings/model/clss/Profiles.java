/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.clss;

/**
 *
 * @author osotemi
 */
import java.io.Serializable;
import java.util.Locale;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.tools.format;
@XStreamAlias("Profiles")
public class Profiles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("Name")
	private String name;
	@XStreamAlias("decimal")
	private int decimal;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("fdate")
	private String fdate;
	@XStreamAlias("currency")
	private Locale currency;
	@XStreamAlias("looknfeel")
	private String looknfeel;
	@XStreamAlias("file_type")
	private String file_type;
	
	public Profiles(){
		
	}
	
	public Profiles(String name, String language, String fdate, Locale currency, String looknfeel, String file_type, int decimals){
		this.setName(name);
		this.setDecimal(decimals);
		this.setLanguage(language);
		this.setFdate(fdate);
		this.setLooknfeel(looknfeel);
		this.setFile_type(file_type);
		
	}
	
	public String getName() {
		return name;
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
	public String getLooknfeel() {
		return looknfeel;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public void setCurrency(Locale currency) {
		this.currency = currency;
	}
	public void setLooknfeel(String looknfeel) {
		this.looknfeel = looknfeel;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	@Override
	public String toString() {
		StringBuffer outline = new StringBuffer();
		try {
			outline.append("Name: "+ this.getName()+"\n");
			outline.append("Language: "+ this.getLanguage()+"\n");
			outline.append("Currency: "+ this.getCurrency() +"\n");
			outline.append("Format date = " + this.getFdate() +"\n");
			outline.append("Look & Feel = "+ this.getLooknfeel() + "\n");
			outline.append("File type = "+ this.getFile_type() + "\n");
			outline.append("Decimal = "+ this.getDecimal() + "\n");
		} catch (Exception e) {
			try {
				outline.append( "Name -> "+ this.getName());
			} catch (Exception e2) {
				outline.append("EMPTY");
			}
		}
		return outline.toString();
	}
	
	public void SettingsTOProfiles(String name){
		this.setName(name);
		this.setCurrency(Settings.getInstance().getCurrency());
		this.setDecimal(Settings.getInstance().getDecimal());
		this.setFdate(Settings.getInstance().getFdate());
		this.setFile_type(Settings.getInstance().getFile_type());
		this.setLanguage(Settings.getInstance().getLanguage());
		this.setLooknfeel(Settings.getInstance().getLooknfeel());
		
	}
	
	public void ProfilesTOSettings(){
		Settings.getInstance().setName(this.getName());
		Settings.getInstance().setCurrency(this.getCurrency());
		Settings.getInstance().setDecimal(this.getDecimal());
		Settings.getInstance().setFdate(this.getFdate());
		Settings.getInstance().setFile_type(this.getFile_type());
		Settings.getInstance().setLanguage(this.getLanguage());
		Settings.getInstance().setLooknfeel(this.getLooknfeel());
				
	}
}