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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.tools.functions;

@SuppressWarnings({ "deprecation" })
public class xml {
	private static final String ENCODING = "UTF-8";
	
	/**---------------------------------------------
	 * -------------------Admin---------------------
	 * ---------------------------------------------
	 */
	/**AdminXml_save() function save 
	 * from singletonU.Alist_adm 
	 * to selected file
	 * 
	 */
	public static void AdminXml_Save() {
		int seleccion =0;
		String PATH=null;
		try {
			OutputStream outstr = new ByteArrayOutputStream();
			OutputStreamWriter outstrwrt = new OutputStreamWriter(outstr);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singletonAdmin.AdminTableArray, outstrwrt);
            StringBuffer xmlbuffer = new StringBuffer();
            xmlbuffer.append(header);
            xmlbuffer.append(outstr.toString());
	    
            JFileChooser fileChooser = new JFileChooser();
            seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                if(!PATH.endsWith(".xml")){
                	PATH = PATH+".xml";
                }
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xmlbuffer.toString());
                fileXml.close();
                outstrwrt.close();
                outstr.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
	    }catch (Exception e1){
	    	functions.showERR("ERROR to save XML Admin file");
	    } 
    }
	
	/**AdminXml_load() function load 
	 * from selected file 
	 * to singletonU.Alist_adm 
	 * @return singletonU.Alist_adm
	 */
	@SuppressWarnings({ "unchecked" })
	public static void AdminXml_load() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Admin.class);
 
            JFileChooser fileChooser = new JFileChooser();
            
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
            
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                singletonAdmin.AdminTableArray  = (ArrayList <Admin>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	functions.showERR("ERROR to load xml Admin file");
        }
    }
	
	/**AdminXml_Autosave save automatically 
	 * from singletonU.Alist_adm 
	 * to admin.xml in the path /src/framework/mod/user/model/files/admin.xml 
	 * 
	 */
	public static void AdminXml_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonAdmin.PATH_XML;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (singletonAdmin.AdminTableArray.size() > 0) {
            try {
                OutputStream outStream = new ByteArrayOutputStream();
                OutputStreamWriter outStreamWrit = new OutputStreamWriter(outStream);
                XStream xstream = new XStream();

                Annotations.configureAliases(xstream, Admin.class);
                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singletonAdmin.AdminTableArray, outStreamWrit);
                StringBuffer xml = new StringBuffer();
                xml.append(header);
                xml.append(outStream.toString());

                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                outStreamWrit.close();
                outStream.close();
                System.out.println("Save XML Admin file successfully");
            } catch (IOException e) {
                System.out.println("ERROR to save XML Admin file");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }
	
	/**AdminXml_Autoload load automatically the file admin.xml 
	 * from the path /src/framework/mod/user/model/files/admin.xml
	 * to singletonU.Alist_adm 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static void AdminXml_Autoload() {
        String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Admin.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonAdmin.PATH_XML;

            File path = new File(PATH);

            if (path.exists()) {
            	singletonAdmin.AdminTableArray = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
        	functions.showERR("ERROR to load xml Admin file");
        }
    }
}