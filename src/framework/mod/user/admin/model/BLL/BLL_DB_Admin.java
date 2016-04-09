/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.BLL;

import framework.clss.ConnectionBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class BLL_DB_Admin {
    
    public static int BLL_DB_newAdmin() {
        int output=0;
        Connection _con = null;

        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = _conexion_DB.OpenConnection();

        //out = DAOBD.nuevoEmpleadoDAO(_con);

        _conexion_DB.CloseConnection(_con);

        return output;
    }
    // * obtener un arraylist con todos los empleados disponibles

    public static void BLL_DB_listAdmin() {

        Connection _con = null;
        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = _conexion_DB.OpenConnection();
        //DAOBD _empleadoDAO = new DAOBD();

        try {
            //_empleadoDAO.listarEmpleadoDAO(_con);//Recuperamos los empleados 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
        _conexion_DB.CloseConnection(_con);

    }

    // modificar un empleado existente en la BD
    public static void BLL_DB_modifyAdmin() {

        Connection _con;

        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = _conexion_DB.OpenConnection();
        //DAOBD _empleadoDAO = new DAOBD();

        //_empleadoDAO.modificarEmpleadoDAO(_con);
        _conexion_DB.CloseConnection(_con);

    }

    // eliminar un empleado de la BD
    public static boolean BLL_DB_deleteAdmin() {

        Connection _con;
        boolean correcto = false;

        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = _conexion_DB.OpenConnection();
        //DAOBD _empleadoDAO = new DAOBD();

        //correcto = _empleadoDAO.borrarEmpleadoDAO(_con);
        _conexion_DB.CloseConnection(_con);

        return correcto;
    }

    //* buscar en la BD un empleado por su DNI
    public static boolean BLL_DB_searchByDni() {

        Connection _con;
        boolean correcto = false;

        ConnectionBD _conexion_DB = new ConnectionBD();

        _con = _conexion_DB.OpenConnection();
        //DAOBD _empleadoDAO = new DAOBD();

        //correcto = _empleadoDAO.buscarPorDniDAO(_con);
        _conexion_DB.CloseConnection(_con);

        return correcto;
    }
}
