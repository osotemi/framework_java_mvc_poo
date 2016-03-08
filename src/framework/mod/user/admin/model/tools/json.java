/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.tools;

/**
 *
 * @author osotemi
 */
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.mod.user.model.clss.singletonU;
import javax.swing.JOptionPane;

public class json {
	@SuppressWarnings("unused")
	private static final String ENCODING = "UTF-8";
	
	/**---------------------------------------------
	 * -------------------Admin---------------------
	 * ---------------------------------------------
	 */
	/**AdminJson_Save() function save 
	 * from singletonU.Alist_adm 
	 * to selected file
	 * 
	 */
	
	public static void AdminJson_Save() {
		int seleccion = 0;
        String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Admin", Admin.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          seleccion = fileChooser.showSaveDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                
	                if(!PATH.endsWith(".json")){
	                	PATH=PATH+ ".json";
	                }
	                //singletonU.Alist_adm.addAll((ArrayList<Admin>)xstreamjson.fromXML(new FileReader(PATH)));
	                Gson gson = new Gson();
		            String json = gson.toJson(singletonAdmin.AdminTableArray);
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close(); 
	                
	                //functions.showString("JSON saved successfully", "JSON File");
	          }
        } catch (Exception e) {
        	//functions.showString("ERROR saving JSON file", "JSON save file ERROR");
        }
    }
	
	
	@SuppressWarnings({ })
	
	/**AdminJson_Autosave save automatically 
	 * from singletonU.Alist_adm 
	 * to admin.json in the path /src/framework/mod/user/model/files/admin.json 
	 * 
	 */
	
	public static void AdminJson_Autosave(){
		String PATH = null;
		
		try{
			PATH = new java.io.File(".").getCanonicalPath()
					+ singletonU.PATH;
		} catch (IOException e){
			e.printStackTrace();
		}
		
		if ( singletonU.Alist_adm.size() > 0) {
			try{
				XStream xstreamjson = new XStream ( new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Admin", Admin.class);
				
				Gson gson = new Gson();
				String json = gson.toJson(singletonU.Alist_adm);
				FileWriter fileJson = new FileWriter(PATH);
				fileJson.write(json);
				fileJson.close();
				System.out.println("JSON file saved sucsefully");
			} catch (HeadlessException | IOException e){
				System.out.println("ERR autosaving JSON");
			}
		}
		else{
			File path = new File(PATH);
			
			path.delete();
		}
	}
	
	/**AdminJson_load() function load 
	 * from selected file 
	 * to singletonU.Alist_adm 
	 * @return singletonU.Alist_adm
	 */
	public static ArrayList<Admin> AdminJson_load() {
    	String PATH = null;
    	Admin adm = new Admin();
    	
        try {
        	
	    	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("Admin", Admin.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showOpenDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	               
	                singletonU.Alist_adm.clear();
	                //singletonU.Alist_adm = (ArrayList<Admin>)xstream.fromXML(new FileReader(PATH));
	                //singletonU.Alist_adm.addAll((ArrayList<Admin>)xstream.fromXML(new FileReader(PATH)));
	                	              
	                JsonReader jreader = new JsonReader(new FileReader(PATH));
	                JsonParser jparser = new JsonParser();
	                JsonElement raiz = jparser.parse(jreader);
	            		  
	            	Gson json = new Gson();
	            	JsonArray list = raiz.getAsJsonArray();
	            	for (JsonElement elem : list) {
	            		adm = json.fromJson(elem, Admin.class);
	            		singletonAdmin.AdminTableArray.add(adm);
	            	}
	          } 
        } catch (Exception e) {
        	   JOptionPane.showMessageDialog(null, "ERROR reading JSON file", "JSON file read ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return singletonU.Alist_adm;
    }
	
	/**AdminJson_Autoload load automatically the file admin.json 
	 * from the path /src/framework/mod/user/model/files/admin.json
	 * to singletonU.Alist_adm 
	 * 
	 */
	public static void AdminJson_Autoload(){
		String PATH;
		Admin adm = new Admin();
		singletonU.Alist_adm.clear();
		
		try {
			XStream xstream = new XStream( new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", Admin.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
                    + singletonU.PATH;
			
			JsonReader read = new JsonReader(new FileReader(PATH));
			JsonParser parseator = new JsonParser();
			JsonElement root = parseator.parse(read);
			
			Gson json = new Gson();
			
			JsonArray list = root.getAsJsonArray();
			for (JsonElement elem : list){
				adm = json.fromJson(elem, Admin.class);
				singletonU.Alist_adm.add(adm);
			}
		} catch (Exception e) {
			System.out.println("ERR auto-loading Json");
		}
	}   
}
