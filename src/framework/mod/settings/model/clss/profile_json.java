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
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class profile_json {

    /**
     * Settings_Autoload load automatically the file settings.json from the path
     * /src/framework/clss/files/settings.json to singletonS.Alist_sett
     *
     */
    public static void Profiles_Autoload() {
        String PATH;
        Profiles sett;
        singletonProfile.Alist_Profile.clear();

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Profiles", Profiles.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/clss/prof/profiles.json";

            JsonReader read = new JsonReader(new FileReader(PATH));
            JsonParser parseator = new JsonParser();
            JsonElement root = parseator.parse(read);

            Gson json = new Gson();

            JsonArray list = root.getAsJsonArray();
            for (JsonElement elem : list) {
                sett = json.fromJson(elem, Profiles.class);
                singletonProfile.Alist_Profile.add(sett);
            }
        } catch (IOException | JsonIOException | JsonSyntaxException e) {
            System.out.println("ERR auto-loading Profiles");
        }
    }

    /**
     * Settings_Autosave save automatically from singletonS.Alist_Sett to
     * settings.json in the path /src/framework/clss/files/settings.json
     *
     */

    public static void Profiles_Autosave() {
        String PATH = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/clss/prof/profiles.json";
        } catch (IOException e) {
        }

        if (singletonProfile.Alist_Profile.size() > 0) {
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("Profiles", Profiles.class);

                Gson gson = new Gson();
                String json = gson.toJson(singletonProfile.Alist_Profile);
                FileWriter fileJson = new FileWriter(PATH);
                fileJson.write(json);
                fileJson.close();

                System.out.println("OK autosaving JSON");
            } catch (HeadlessException | IOException e) {
                System.out.println("ERR autosaving JSON");
            }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }
}
