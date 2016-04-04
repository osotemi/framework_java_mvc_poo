/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.tools;


import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.tools.functions;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author osotemi
 */
public class txtClt {

    @SuppressWarnings("unused")
    private static final String ENCODING = "UTF-8";

    /**
     * ---------------------------------------------
     * -------------------Registered user---------------------
     * ---------------------------------------------
     */
    /**
     * RegTxt_save() function save from singletonReg.RegTableArray to selected file
     *
     */
    public static void ClientTxt_Save() {
        String PATH;
        FileWriter file;
        PrintWriter prntw;

        try {
            //File f;

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));

            int selct = fileChooser.showSaveDialog(null);

            if (selct == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".txt")) {
                    PATH = PATH + ".txt";
                }

                //f = new File(PATH);
                file = new FileWriter(PATH);
                prntw = new PrintWriter(file);

                for (int i = 0; i < singletonClient.ClienTableArray.size(); i++) {
                    prntw.println(singletonClient.ClienTableArray.get(i).toString());
                    prntw.println("\n----------------------------------------\n");
                }

                file.close();

                functions.showString("Client saved sucesfully on txt", "Client txt save");
            }
        } catch (HeadlessException | IOException e) {
            functions.showString("ERR saving Admin", "Client save ERR");
        }
    }

    /**
     * ClientTxt_Autosave save automatically from singletonClient.ClienTableArray to
     * txtCltDB.txt in the path /src/framework/mod/user/model/files/txtCltDB.txt
     *
     */
    public static void ClienTxt_Autosave() {
        String PATH;
        FileWriter file;
        PrintWriter prntw;

        try {

            PATH = new java.io.File(".").getCanonicalPath() + singletonClient.PATH_TXT;

            if (!PATH.endsWith(".txt")) {
                PATH = PATH + ".txt";
            }

            file = new FileWriter(PATH);
            prntw = new PrintWriter(file);

            for (int i = 0; i < singletonClient.ClienTableArray.size(); i++) {
                prntw.println(singletonClient.ClienTableArray.get(i).toString());
                prntw.println("\n----------------------------------------\n");
            }

            file.close();

            System.out.println("Client txt save");

        } catch (HeadlessException | IOException e) {
            functions.showString("ERR saving Client", "Client save ERR");
        }
    }

    /**
     * CltTxt_load() function load from selected file to singletonClient.ClienTableArray
     *
     * @return singletonClient.ClienTableArray
     */
    @SuppressWarnings({"unchecked"})
    public static void ClientTxt_load() {
        String PATH;

        try {
            File file;

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));

            int selct = fileChooser.showOpenDialog(null);

            if (selct == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                file = new File(PATH);

                FileInputStream file_input = new FileInputStream(file);
                ObjectInputStream obj_input = new ObjectInputStream(file_input);

                singletonClient.ClienTableArray = (ArrayList<Client>) obj_input.readObject();
                obj_input.close();

                functions.showString("Registered users loaded from .txt sucesfully", "Registered users txt load");

            }
        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            functions.showString("ERR loading Registered users from .txt", "Registered users .txt load");
        }
    }

    /**
     * ClientTxt_Autoload load automatically from singletonClient.ClienTableArray to
     * clientDB.xml in the path /src/framework/mod/user/registered/model/files/clientDB.txt
     *
     */
    @SuppressWarnings("unchecked")
    public static void ClientTxt_Autoload() {
        String PATH;

        try {
            File file;

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonClient.PATH_TXT;
            file = new File(PATH);

            FileInputStream file_input = new FileInputStream(file);
            ObjectInputStream obj_input = new ObjectInputStream(file_input);

            singletonClient.ClienTableArray = (ArrayList<Client>) obj_input.readObject();
            obj_input.close();

            functions.showString("Client load from .txt sucesfully", "Client txt load");

        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            functions.showString("ERR loading Client from .txt", "Client .txt Autoload");
        }
    }
}
