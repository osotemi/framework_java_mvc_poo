/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.singletonReg;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author osotemi
 */
public class jsonReg {

    @SuppressWarnings("unused")
    private static final String ENCODING = "UTF-8";

    /**
     * -------------------------------------------------------
     * -------------------Registered User---------------------
     * -------------------------------------------------------
     */
    /**
     * RegJson_Save() function save from singletonReg.RagTableArray to selected file
     *
     */
    public static void RegJson_Save() {
        int seleccion = 0;
        String PATH = null;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("RegU", RegisteredU.class);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
            seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".json")) {
                    PATH = PATH + ".json";
                }
               
                Gson gson = new Gson();
                String json = gson.toJson(singletonReg.RegTableArray);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                //functions.showString("JSON saved successfully", "JSON File");
            }
        } catch (Exception e) {
            //functions.showString("ERROR saving JSON file", "JSON save file ERROR");
        }
    }

    @SuppressWarnings({})

    /**
     * RegJson_Autosave save automatically from singletonReg.RegTableArray to
     * admin.json in the path /src/framework/mod/user/model/files/jsonRegDB.json
     *
     */
    public static void RegJson_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonReg.PATH_REG;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (singletonReg.RegTableArray.size() > 0) {
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("RegU", RegisteredU.class);

                Gson gson = new Gson();
                String json = gson.toJson(singletonReg.RegTableArray);
                FileWriter fileJson = new FileWriter(PATH);
                fileJson.write(json);
                fileJson.close();
                System.out.println("JSON file saved sucsefully");
            } catch (HeadlessException | IOException e) {
                System.out.println("ERR autosaving JSON");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }

    /**
     * RegJson_load() function load from selected file to singletonReg.RegTableArray
     *
     * @return singletonU.Alist_adm
     */
    public static ArrayList<RegisteredU> RegJson_load() {
        String PATH = null;
        RegisteredU regu = new RegisteredU();

        try {

            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("RegU", RegisteredU.class);

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                singletonReg.RegTableArray.clear();
                
                JsonReader jreader = new JsonReader(new FileReader(PATH));
                JsonParser jparser = new JsonParser();
                JsonElement raiz = jparser.parse(jreader);

                Gson json = new Gson();
                JsonArray list = raiz.getAsJsonArray();
                for (JsonElement elem : list) {
                    regu = json.fromJson(elem, RegisteredU.class);
                    singletonReg.RegTableArray.add(regu);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR reading JSON file", "JSON file read ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return singletonReg.RegTableArray;
    }

    /**
     * RegJson_Autoload load automatically the file jsonRegDB.json from the path
     * /src/framework/mod/user/model/files/jsonRegDB.json to singletonReg.RegTableArray
     *
     */
    public static void RegJson_Autoload() {
        String PATH;
        RegisteredU regu = new RegisteredU();
        singletonReg.RegTableArray.clear();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("RegU", RegisteredU.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonReg.PATH_REG;

            JsonReader read = new JsonReader(new FileReader(PATH));
            JsonParser parseator = new JsonParser();
            JsonElement root = parseator.parse(read);

            Gson json = new Gson();

            JsonArray list = root.getAsJsonArray();
            for (JsonElement elem : list) {
                regu = json.fromJson(elem, RegisteredU.class);
                singletonReg.RegTableArray.add(regu);
            }
        } catch (Exception e) {
            System.out.println("ERR auto-loading Json");
        }
    }
}
