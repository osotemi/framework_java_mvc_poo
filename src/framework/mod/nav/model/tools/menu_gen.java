/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.nav.model.tools;

/**
 *
 * @author osotemi
 */
import javax.swing.JOptionPane;

public class menu_gen {

    /**
     * -------------------------------------MENU-------------------------------------
     */

    /**
     * -------------------------------------Menu using
     * combobox------------------------------------- This function show a
     * combobox menu with the given options
     *
     * @param string [] options ->the menu options
     * @param String ERR -> the selected option in catch case
     * @param String message
     * @param String title
     *
     *
     */
    public static String menucombo(String[] options, String ERR, String message, String title) {
        Object option = null;
        String outline = null;

        try {
            option = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            outline = option.toString();
        } catch (Exception e) {
            outline = ERR;
        }
        return outline;
    }

    /**
     * -------------------------------------Menu using
     * buttons------------------------------------- This function show a
     * combobox menu with the given options
     *
     * @param String [] options ->the menu options
     * @param String message
     * @param String title
     *
     * @return int option
	 *
     */
    public static int menubuttons(String[] options, String message, String title) {
        int option = 0;

        option = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return option;
    }

}
