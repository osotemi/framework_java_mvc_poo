/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.clss;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class ConnectionBD {
    /**
     * Open conection with Data Base
     *
     * @return
     */
    public Connection OpenConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/db_framework";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
            JOptionPane.showMessageDialog(null, "EUREKA!!!!!");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }

    /**
     * Close DB connection
     *
     * @param con
     */
    public void CloseConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }
}
