/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class DAO_DB_Admin {

    //Dar de alta a un empleado
    public static int nuevoEmpleadoDAO(Connection con) {

        PreparedStatement stmt = null;
        int correcto = 0;
        try {

            stmt = con.prepareStatement("INSERT INTO gestionbbdd.empleadosfijos"
                    + "(Nombre, Apellidos, DNI, Edad, Telefono, fechaNacimiento, fechaContrac, "
                    + "Usuario, Password, Email, Estado, Tipo, Avatar, Antiguedad, SueldoFijo, SueldoHoras) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            /*
            stmt.setString(1, Singletons.e.getNombre());
            stmt.setString(2, Singletons.e.getApellidos());
            stmt.setString(3, Singletons.e.getDni());
            stmt.setInt(4, Singletons.e.getEdad());
            stmt.setString(5, Singletons.e.getTelefono());
            stmt.setString(6, Singletons.e.getFechaNacimiento().toStringFecha());
            stmt.setString(7, Singletons.e.getFechaContrac().toStringFecha());
            stmt.setString(8, Singletons.e.getUsuario());
            stmt.setString(9, Singletons.e.getPassword());
            stmt.setString(10, Singletons.e.getEmail());
            stmt.setInt(11, Singletons.e.getEstado());
            stmt.setString(12, Singletons.e.getTipo());
            stmt.setString(13, Singletons.e.getAvatar());
            stmt.setInt(14, Singletons.e.getAntiguedad());
            stmt.setFloat(15, Singletons.e.getSueldofijo());
            stmt.setFloat(16, Singletons.e.getSueldohoras());

            correcto = stmt.executeUpdate();
            */
            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return correcto;
    }

    //Listamos todos los empleados y los metemos en su array
    public void listarEmpleadoDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        /*
        Singletons.efi.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM gestionbbdd.empleadosfijos");
            rs = stmt.executeQuery();

            EmpleadoFijo _efijo = null;

            while (rs.next()) {

                _efijo = new EmpleadoFijo();
                _efijo.setNombre(rs.getString("Nombre"));
                _efijo.setApellidos(rs.getString("Apellidos"));
                _efijo.setDni(rs.getString("DNI"));
                _efijo.setEdad(rs.getInt("Edad"));
                _efijo.setTelefono(rs.getString("Telefono"));
                _efijo.setFechaNacimiento(DAOEmpleado.sacaFecha(rs.getString("fechaNacimiento")));
                _efijo.setFechaContrac(DAOEmpleado.sacaFecha(rs.getString("fechaContrac")));
                _efijo.setUsuario(rs.getString("Usuario"));
                _efijo.setPassword(rs.getString("Password"));
                _efijo.setEmail(rs.getString("Email"));
                _efijo.setEstado(rs.getInt("Estado"));
                _efijo.setTipo(rs.getString("Tipo"));
                _efijo.setAvatar(rs.getString("Avatar"));
                _efijo.setAntiguedad(rs.getInt("Antiguedad"));
                _efijo.setSueldofijo(rs.getFloat("SueldoFijo"));
                _efijo.setSueldohoras(rs.getFloat("SueldoHoras"));
                Singletons.efi.add(_efijo);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        */
    }

    //Modificamos un empleado
    public void modificarEmpleadoDAO(Connection con) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE gestionbbdd.empleadosfijos SET Nombre=?, "
                    + "Apellidos=?, DNI=?, Edad=?, Telefono=?, fechaNacimiento=?, fechaContrac=?, Usuario=?, Password=?,"
                    + "Email=?, Estado=?, Tipo=?, Avatar=?, "
                    + "Antiguedad=?, SueldoFijo=?, SueldoHoras=? WHERE DNI=?");
            /*
            stmt.setString(1, Singletons.e.getNombre());
            stmt.setString(2, Singletons.e.getApellidos());
            stmt.setString(3, Singletons.e.getDni());
            stmt.setInt(4, Singletons.e.getEdad());
            stmt.setString(5, Singletons.e.getTelefono());
            stmt.setString(6, Singletons.e.getFechaNacimiento().toStringFecha());
            stmt.setString(7, Singletons.e.getFechaContrac().toStringFecha());
            stmt.setString(8, Singletons.e.getUsuario());
            stmt.setString(9, Singletons.e.getPassword());
            stmt.setString(10, Singletons.e.getEmail());
            stmt.setInt(11, Singletons.e.getEstado());
            stmt.setString(12, Singletons.e.getTipo());
            stmt.setString(13, Singletons.e.getAvatar());
            stmt.setInt(14, Singletons.e.getAntiguedad());
            stmt.setFloat(15, Singletons.e.getSueldofijo());
            stmt.setFloat(16, Singletons.e.getSueldohoras());

            stmt.setString(17, Singletons.e.getDni());
            stmt.executeUpdate();
            */
            JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }

    }

    //Borramos un empleado
    public boolean borrarEmpleadoDAO(Connection con) {

        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("DELETE FROM gestionbbdd.empleadosfijos WHERE DNI=?");
            //stmt.setString(1, Singletons.e.getDni());
            stmt.executeUpdate();
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return correcto;
    }

    //Buscamos por dni un empleado
    public boolean buscarPorDniDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM gestionbbdd.empleadosfijos WHERE DNI=?");
            //stmt.setString(1, Singletons.e.getDni());
            rs = stmt.executeQuery();
            while (rs.next()) {

                obtenEmpleadoFila(rs);
            }
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por DNI");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
        }
        return correcto;
    }

    private void obtenEmpleadoFila(ResultSet rs) {
        /*
        try {
            
            Singletons.e.setNombre(rs.getString("Nombre"));
            Singletons.e.setApellidos(rs.getString("Apellidos"));
            Singletons.e.setDni(rs.getString("DNI"));
            Singletons.e.setEdad(rs.getInt("Edad"));
            Singletons.e.setTelefono(rs.getString("Telefono"));
            Singletons.e.setFechaNacimiento(DAOEmpleado.sacaFecha(rs.getString("fechaNacimiento")));
            Singletons.e.setFechaContrac(DAOEmpleado.sacaFecha(rs.getString("fechaContrac")));
            Singletons.e.setUsuario(rs.getString("Usuario"));
            Singletons.e.setPassword(rs.getString("Password"));
            Singletons.e.setEmail(rs.getString("Email"));
            Singletons.e.setEstado(rs.getInt("Estado"));
            Singletons.e.setTipo(rs.getString("Tipo"));
            Singletons.e.setAvatar(rs.getString("Avatar"));
            Singletons.e.setAntiguedad(rs.getInt("Antiguedad"));
            Singletons.e.setSueldofijo(rs.getFloat("SueldoFijo"));
            Singletons.e.setSueldohoras(rs.getFloat("SueldoHoras"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }*/
    }
}
