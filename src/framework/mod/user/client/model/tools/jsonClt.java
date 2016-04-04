/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.tools.functions;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author osotemi
 */
public class jsonClt {

    /**
     * -------------------Client---------------------
     * ---------------------------------------------
     */
    /**
     * ClientJson_Save() function save from singletonU.Alist_clt to selected
     * file
     *
     */

    public static void ClientJson_Save() {
        int seleccion = 0;
        String PATH = null;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Client", Client.class);

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
                //singletonU.AliClientst_adm.addAll((ArrayList<Admin>)xstreamjson.fromXML(new FileReader(PATH)));
                Gson gson = new Gson();
                String json = gson.toJson(singletonClient.ClienTableArray);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();
                System.out.println("JSON File saved");
                functions.showString("JSON saved successfully", "JSON File");
            }
        } catch (Exception e) {
            functions.showString("ERROR saving JSON file", "JSON save file ERROR");
        }
    }

    @SuppressWarnings({})

    /**
     * ClientJson_Autosave save automatically from singletonU.Alist_clt to
     * client_dummies.json in the path
     * /src/framework/mod/user/model/files/admin.json
     *
     */
    public static void ClientJson_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonClient.PATH_JSON;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (singletonClient.ClienTableArray.size() > 0) {
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("Client", Client.class);

                Gson gson = new Gson();
                String json = gson.toJson(singletonClient.ClienTableArray);
                FileWriter fileJson = new FileWriter(PATH);
                fileJson.write(json);
                fileJson.close();

                functions.showString("JSON file saved sucsefully", "JSON file");
            } catch (HeadlessException | IOException e) {
                System.out.println("ERR autosaving JSON");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }

    /**
     * ClientJson_load() function load from selected file to
     * singletonU.Alist_clt
     *
     * @return singletonU.Alist_clt
     */
    public static ArrayList<Client> ClientJson_load() {
        String PATH = null;
        Client clt = new Client();

        try {

            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Client", Client.class);

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                singletonClient.ClienTableArray.clear();
                JsonReader jreader = new JsonReader(new FileReader(PATH));
                JsonParser jparser = new JsonParser();
                JsonElement raiz = jparser.parse(jreader);

                Gson json = new Gson();
                JsonArray list = raiz.getAsJsonArray();
                for (JsonElement elem : list) {
                    clt = json.fromJson(elem, Client.class);
                    singletonClient.ClienTableArray.add(clt);
                }
            }
        } catch (Exception e) {
            functions.showString("ERROR reading JSON file", "JSON file read ERROR");
        }
        return singletonClient.ClienTableArray;
    }

    /**
     * ClientJson_Autoload load automatically the file client_dummies.json from
     * the path /src/framework/mod/user/model/files/client_dummies.json to
     * singletonU.Alist_clt
     *
     */
    public static void ClientJson_Autoload() {
        String PATH;
        Client clt = new Client();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Client", Client.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonClient.PATH_JSON;

            JsonReader read = new JsonReader(new FileReader(PATH));
            JsonParser parseator = new JsonParser();
            JsonElement root = parseator.parse(read);

            Gson json = new Gson();

            JsonArray list = root.getAsJsonArray();
            for (JsonElement elem : list) {
                clt = json.fromJson(elem, Client.class);
                singletonClient.ClienTableArray.add(clt);
            }
        } catch (Exception e) {
            System.out.println("ERR auto-loading Json");
        }
    }

}
