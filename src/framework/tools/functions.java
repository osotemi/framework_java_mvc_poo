/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.tools;

import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class functions {
    /**	Show a message dialog with Information message
	 * 
	 */
	public static void showString( String message, String title){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Show ERROR message
	 */
	public static void showERR(String error){
		JOptionPane.showMessageDialog(null,"ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}
