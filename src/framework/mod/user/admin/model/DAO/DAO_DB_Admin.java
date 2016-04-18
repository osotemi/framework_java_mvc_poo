/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.DAO;

import framework.clss.DateO;
import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
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
    public static int DAO_newAdmin(Connection _con) {
        PreparedStatement stmt = null;
        int correcto = 0;
        
        try {
            stmt = _con.prepareStatement("INSERT INTO db_framework.admin "
                    + "(age,avatar,date_birthday,dni,email,phone,name,lastname,password,state,user,benefit,activity,antiqueness,date_hiredate,salary) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, singletonAdmin.ephemeralAdmin.getAge());
            stmt.setString(2, singletonAdmin.ephemeralAdmin.getAvataring());
            stmt.setString(3, singletonAdmin.ephemeralAdmin.getBorn_date().toString());
            stmt.setString(4, singletonAdmin.ephemeralAdmin.getDni());
            stmt.setString(5, singletonAdmin.ephemeralAdmin.getEmail());
            stmt.setString(6, singletonAdmin.ephemeralAdmin.getMovile());
            stmt.setString(7, singletonAdmin.ephemeralAdmin.getName());
            stmt.setString(8, singletonAdmin.ephemeralAdmin.getLastname());
            stmt.setString(9, singletonAdmin.ephemeralAdmin.getPassword());
            stmt.setString(10,singletonAdmin.ephemeralAdmin.getState()); 
            stmt.setString(11,singletonAdmin.ephemeralAdmin.getUser()); 
            stmt.setFloat(12,singletonAdmin.ephemeralAdmin.getBenefit()); 
            stmt.setInt(13,singletonAdmin.ephemeralAdmin.getActivity()); 
            stmt.setInt(14, singletonAdmin.ephemeralAdmin.getAntiqueness());
            stmt.setString(15, singletonAdmin.ephemeralAdmin.getContract_data().toString());
            stmt.setFloat(16, singletonAdmin.ephemeralAdmin.getSalary());

            int executeUpdate = stmt.executeUpdate();
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
        
        System.out.println("ERROR creando admin");
        
        return correcto;
    }

    //Listamos todos los empleados y los metemos en su array
    public void DAO_listAdmin(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        DateO birth_date = null;
        DateO hire_date = null;
        
        singletonAdmin.AdminTableArray.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM db_framework.admin");
            rs = stmt.executeQuery();
            
            Admin _adm = null;
            
            while (rs.next()) {
                birth_date = new DateO(rs.getString("date_birthday"));
                hire_date = new DateO(rs.getString("date_hiredate"));        
                
                _adm = new Admin();
                _adm.setAge(rs.getInt("age"));
                _adm.setAvataring(rs.getString("avatar"));
                _adm.setBorn_date(birth_date);
                _adm.setDni(rs.getString("dni"));
                _adm.setEmail(rs.getString("email"));
                _adm.setMovile(rs.getString("phone"));
                _adm.setName(rs.getString("name"));
                _adm.setLastname(rs.getString("lastname"));
                _adm.setPassword(rs.getString("password"));
                _adm.setState(rs.getString("state"));
                _adm.setUser(rs.getString("user"));
                //benefit se autocalcula
                _adm.setActivity(rs.getInt("activity"));
                //antiqueness se recalcula
                _adm.setContract_data(hire_date);
                _adm.setSalary(rs.getFloat("salary"));
                
                singletonAdmin.AdminTableArray.add(_adm);

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
        
    }

    //Modificamos un empleado
    public static int DAO_modifyAdmin(Connection con) {
        int valid = 0;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE db_framework.admin SET age=?, "
                    + "avatar=?, date_birthday=?, dni=?, email=?, phone=?, name=?, lastname=?, password=?,"
                    + "state=?, user=?, benefit=?, activity=?, "
                    + "antiqueness=?, date_hiredate=?, salary=? WHERE dni=?");
            //(age,avatar,date_birthday,dni,email,phone,name,lastname,password,state,user,benefit,activity,antiqueness,date_hiredate,salary)
            stmt.setInt(1, singletonAdmin.ephemeralAdmin.getAge());
            stmt.setString(2, singletonAdmin.ephemeralAdmin.getAvataring());
            stmt.setString(3, singletonAdmin.ephemeralAdmin.getBorn_date().toString());
            stmt.setString(4, singletonAdmin.ephemeralAdmin.getDni());
            stmt.setString(5, singletonAdmin.ephemeralAdmin.getEmail());
            stmt.setString(6, singletonAdmin.ephemeralAdmin.getMovile());
            stmt.setString(7, singletonAdmin.ephemeralAdmin.getName());
            stmt.setString(8, singletonAdmin.ephemeralAdmin.getLastname());
            stmt.setString(9, singletonAdmin.ephemeralAdmin.getPassword());
            stmt.setString(10, singletonAdmin.ephemeralAdmin.getState());
            stmt.setString(11, singletonAdmin.ephemeralAdmin.getUser());
            stmt.setFloat(12, singletonAdmin.ephemeralAdmin.getBenefit());
            stmt.setInt(13, singletonAdmin.ephemeralAdmin.getActivity());
            stmt.setInt(14, singletonAdmin.ephemeralAdmin.getAntiqueness());
            stmt.setString(15, singletonAdmin.ephemeralAdmin.getContract_data().toString());
            stmt.setFloat(16, singletonAdmin.ephemeralAdmin.getSalary());

            stmt.setString(17, singletonAdmin.ephemeralAdmin.getDni());
            valid = stmt.executeUpdate();
           
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
        return valid;
    }

    //Borramos un empleado
    public static int DAO_deleteAdm(Connection con) {

        PreparedStatement stmt = null;
        int valid = 0;

        try {
            stmt = con.prepareStatement("DELETE FROM db_framework.admin WHERE dni=?");
            stmt.setString(1, singletonAdmin.ephemeralAdmin.getDni());
            valid = stmt.executeUpdate();
            
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
        return valid;
    }

    //Buscamos por dni un empleado
    public static int DAO_searchAdminBYdni(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        int valid = 0;

        try {
            stmt = con.prepareStatement("SELECT * FROM db_framework.admin WHERE DNI=?");
            //stmt.setString(1, Singletons.e.getDni());
            rs = stmt.executeQuery();
            while (rs.next()) {

                getAdminRow(rs);
            }
            valid = 1;
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
        return valid;
    }

    private static void getAdminRow(ResultSet rs) {
        DateO birth_date = null;
        DateO hire_date = null;    
        //(age,avatar,date_birthday,dni,email,phone,name,lastname,password,state,user,benefit,activity,antiqueness,date_hiredate,salary)
        try {
            birth_date = new DateO(rs.getString("date_birthday"));
            hire_date = new DateO(rs.getString("date_hiredate"));
            singletonAdmin.ephemeralAdmin.setAge(rs.getInt("age"));
            singletonAdmin.ephemeralAdmin.setLastname(rs.getString("lastname"));
            singletonAdmin.ephemeralAdmin.setBorn_date(birth_date);
            singletonAdmin.ephemeralAdmin.setDni(rs.getString("dni"));
            singletonAdmin.ephemeralAdmin.setEmail(rs.getString("email"));
            singletonAdmin.ephemeralAdmin.setMovile(rs.getString("phone"));
            singletonAdmin.ephemeralAdmin.setName(rs.getString("name"));
            singletonAdmin.ephemeralAdmin.setLastname(rs.getString("lastname"));
            singletonAdmin.ephemeralAdmin.setPassword(rs.getString("password"));
            singletonAdmin.ephemeralAdmin.setState(rs.getString("state"));
            singletonAdmin.ephemeralAdmin.setUser(rs.getString("user"));
            //benefit se autocalcula
            singletonAdmin.ephemeralAdmin.setActivity(rs.getInt("activity"));
            singletonAdmin.ephemeralAdmin.setContract_data(hire_date);
            singletonAdmin.ephemeralAdmin.setSalary(rs.getFloat("salary"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }
    }
}
