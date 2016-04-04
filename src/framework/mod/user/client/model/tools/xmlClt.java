/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.tools;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;
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
@SuppressWarnings({"deprecation"})
public class xmlClt {

    private static final String ENCODING_CLT = "UTF-8";

    /**
     * ---------------------------------------------
     * -------------------Client---------------------
     * ---------------------------------------------
     */
    /**
     * ClientXml_save() function save from singletonU.Alist_clt to selected file
     *
     */
    public static void ClientXml_save() {
        String PATH = null;
        try {
            OutputStream outstr = new ByteArrayOutputStream();
            OutputStreamWriter outstrwrt = new OutputStreamWriter(outstr);
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Client.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singletonClient.ClienTableArray, outstrwrt);
            StringBuffer xmlbuffer = new StringBuffer();
            xmlbuffer.append(header);
            xmlbuffer.append(outstr.toString());

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                if (!PATH.endsWith(".xml")) {
                    PATH = PATH + ".xml";
                }
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xmlbuffer.toString());
                fileXml.close();
                outstrwrt.close();
                outstr.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e1) {
            functions.showERR("ERROR to save XML Client file");
        }
    }

    /**
     * ClientXml_load() function load from selected file to singletonU.Alist_clt
     *
     * @return singletonU.Alist_clt
     */
    @SuppressWarnings({"unchecked"})
    public static void ClientXml_load() {
        String PATH = null;
        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Client.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                singletonClient.ClienTableArray = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (Exception e1) {
            functions.showERR("ERROR to load xml Client file");
        }
    }

    /**
     * ClientXml_Autosave save automatically from singletonU.Alist_clt to
     * reg_user.xml in the path /src/framework/mod/user/model/files/reg_user.xml
     *
     */
    public static void ClientXml_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonClient.PATH_XML;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (singletonClient.ClienTableArray.size() > 0) {
            try {
                OutputStream outStream = new ByteArrayOutputStream();
                OutputStreamWriter outStreamWrit = new OutputStreamWriter(outStream);
                XStream xstream = new XStream();

                Annotations.configureAliases(xstream, Client.class);
                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singletonClient.ClienTableArray, outStreamWrit);
                StringBuffer xml = new StringBuffer();
                xml.append(header);
                xml.append(outStream.toString());

                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                outStreamWrit.close();
                outStream.close();
            } catch (IOException e) {

                functions.showERR("ERROR to save XML Client file");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }

    /**
     * ClientXml_Autoload load automatically the file client.xml from the path
     * /src/framework/mod/user/model/files/client.xml to singletonU.Alist_clt
     *
     */
    @SuppressWarnings("unchecked")
    public static void ClientXml_Autoload() {
        String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Client.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonClient.PATH_XML;

            File path = new File(PATH);

            if (path.exists()) {
                singletonClient.ClienTableArray = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
            functions.showERR("ERROR to load xml Client file");
        }
    }

}
