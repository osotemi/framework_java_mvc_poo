/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.tools;

import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.singletonReg;
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
public class txtReg {

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
    public static void RegTxt_Save() {
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

                for (int i = 0; i < singletonReg.RegTableArray.size(); i++) {
                    prntw.println(singletonReg.RegTableArray.get(i).toString());
                    prntw.println("\n----------------------------------------\n");
                }

                file.close();

                functions.showString("Registered user saved sucesfully on txt", "Registered user txt save");
            }
        } catch (HeadlessException | IOException e) {
            functions.showString("ERR saving Registered user", "Registered user save ERR");
        }
    }

    /**
     * AdminTxt_Autosave save automatically from singletonU.Alist_adm to
     * admin.txt in the path /src/framework/mod/user/model/files/admin.txt
     *
     */
    public static void RegTxt_Autosave() {
        String PATH;
        FileWriter file;
        PrintWriter prntw;

        try {

            PATH = new java.io.File(".").getCanonicalPath() + singletonReg.PATH_TXT;

            if (!PATH.endsWith(".txt")) {
                PATH = PATH + ".txt";
            }

            file = new FileWriter(PATH);
            prntw = new PrintWriter(file);

            for (int i = 0; i < singletonReg.RegTableArray.size(); i++) {
                prntw.println(singletonReg.RegTableArray.get(i).toString());
                prntw.println("\n----------------------------------------\n");
            }

            file.close();

            System.out.println("Registered user txt save");

        } catch (HeadlessException | IOException e) {
            functions.showString("ERR saving Registered user", "Registered user save ERR");
        }
    }

    /**
     * RegTxt_load() function load from selected file to singletonReg.RegTableArray
     *
     * @return singletonReg.RegTableArray
     */
    @SuppressWarnings({"unchecked"})
    public static void RegTxt_load() {
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

                singletonReg.RegTableArray = (ArrayList<RegisteredU>) obj_input.readObject();
                obj_input.close();

                functions.showString("Registered users loaded from .txt sucesfully", "Registered users txt load");

            }
        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            functions.showString("ERR loading Registered users from .txt", "Registered users .txt load");
        }
    }

    /**
     * RegTxt_Autoload load automatically from singletonReg.RegTableArray to
     * xmlRegDB.xml in the path /src/framework/mod/user/registered/model/files/RegTxtDB.txt
     *
     */
    @SuppressWarnings("unchecked")
    public static void RegTxt_Autoload() {
        String PATH;

        try {
            File file;

            PATH = new java.io.File(".").getCanonicalPath()
                    + singletonReg.PATH_TXT;
            file = new File(PATH);

            FileInputStream file_input = new FileInputStream(file);
            ObjectInputStream obj_input = new ObjectInputStream(file_input);

            singletonReg.RegTableArray = (ArrayList<RegisteredU>) obj_input.readObject();
            obj_input.close();

            functions.showString("Registered users load from .txt sucesfully", "Registered users txt load");

        } catch (HeadlessException | IOException | ClassNotFoundException e) {
            functions.showString("ERR loading Registered users from .txt", "Registered users .txt Autoload");
        }
    }
}
