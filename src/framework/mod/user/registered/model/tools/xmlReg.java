/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.tools;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.singletonReg;
import framework.tools.functions;
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
import static javax.xml.transform.OutputKeys.ENCODING;

/**
 *
 * @author osotemi
 */
public class xmlReg {

    /**
     * ---------------------------------------------
     * ---------------RegisteredU-------------------
     * ---------------------------------------------
     */
    /**
     * RegUXml_save() function save from singletonU.Alist_RegU to selected file
     *
     */
    public static void RegUXml_save() {
        String PATH = null;
        try {
            OutputStream outstr = new ByteArrayOutputStream();
            OutputStreamWriter outstrwrt = new OutputStreamWriter(outstr);
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, RegisteredU.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singletonReg.RegTableArray, outstrwrt);
            StringBuffer xmlbuffer = new StringBuffer();
            xmlbuffer.append(header);
            xmlbuffer.append(outstr.toString());

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".xml";

                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xmlbuffer.toString());
                fileXml.close();
                outstrwrt.close();
                outstr.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e1) {
            functions.showERR("ERROR to save XML Registered User file");
        }
    }

    /**
     * RegUXml_load() function load from selected file to singletonU.Alist_RegU
     *
     * @return singletonU.Alist_RegU
     */
    @SuppressWarnings({"unchecked"})
    public static ArrayList<RegisteredU> RegUXml_load() {
        String PATH = null;
        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, RegisteredU.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                singletonReg.RegTableArray = (ArrayList<RegisteredU>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (Exception e1) {
            functions.showERR("ERROR to load xml Registered User file");
        }
        return singletonReg.RegTableArray;
    }

    /**
     * RegUXml_Autosave save automatically from singletonU.Alist_RegU to
     * reg_user.xml in the path /src/framework/mod/user/model/files/reg_user.xml
     *
     */
    public static void RegUXml_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonReg.PATH_XML;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (singletonReg.RegTableArray.size() > 0) {
            try {
                OutputStream outStream = new ByteArrayOutputStream();
                OutputStreamWriter outStreamWrit = new OutputStreamWriter(outStream);
                XStream xstream = new XStream();

                Annotations.configureAliases(xstream, RegisteredU.class);
                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singletonReg.RegTableArray, outStreamWrit);
                StringBuffer xml = new StringBuffer();
                xml.append(header);
                xml.append(outStream.toString());

                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                outStreamWrit.close();
                outStream.close();
            } catch (IOException e) {

                functions.showERR("ERROR to save XML Registered User file");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }

    /**
     * RegUXml_Autoload load automatically the file reg_user.xml from the path
     * /src/framework/mod/user/model/files/reg_user.xml to singletonU.Alist_RegU
     *
     */
    @SuppressWarnings("unchecked")
    public static void RegUXml_Autoload() {
        String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, RegisteredU.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonReg.PATH_XML;

            File path = new File(PATH);

            if (path.exists()) {
                singletonReg.RegTableArray = (ArrayList<RegisteredU>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
            functions.showERR("ERROR to load xml Registered User file");
        }
    }
}
