/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import framework.clss.DateO;
import framework.clss.singletonGen;
import framework.mod.settings.model.clss.singletonProfile;
import framework.mod.settings.model.tools.Language;
import framework.mod.settings.view.main_login;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.registered.model.classes.RegisteredU;
import framework.mod.user.registered.model.classes.singletonReg;
import framework.mod.user.registered.model.tools.jsonReg;
import framework.tools.validate;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osotemi
 */
public class DAO_login {
  
    /**
     * DAO_srcAdminBYname Makes SELECT * FROM db_framework.admin WHERE name =
     * singletonProfile.userName 
     * AND then check if pass = singletonProfile.userPass
     *
     * @param Connection con
     * @return boolean
     */
    public static boolean DAO_srcAdminBYname(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean valid = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM db_framework.admin WHERE user=?");
            stmt.setString(1, singletonProfile.userName);
            //stmt.setString(2, singletonProfile.userPass);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                DateO birth_date = null;
                DateO hire_date = null;
                
                //(age,avatar,date_birthday,dni,email,phone,name,lastname,password,state,user,benefit,activity,antiqueness,date_hiredate,salary)
                try {
                    birth_date = new DateO(rs.getString("date_birthday"));
                    hire_date = new DateO(rs.getString("date_hiredate"));
                    singletonProfile.adm.setAge(rs.getInt("age"));
                    singletonProfile.adm.setLastname(rs.getString("lastname"));
                    singletonProfile.adm.setBorn_date(birth_date);
                    singletonProfile.adm.setDni(rs.getString("dni"));
                    singletonProfile.adm.setEmail(rs.getString("email"));
                    singletonProfile.adm.setMovile(rs.getString("phone"));
                    singletonProfile.adm.setName(rs.getString("name"));
                    singletonProfile.adm.setLastname(rs.getString("lastname"));
                    singletonProfile.adm.setPassword(rs.getString("password"));
                    singletonProfile.adm.setState(rs.getString("state"));
                    singletonProfile.adm.setUser(rs.getString("user"));
                    //benefit se autocalcula
                    singletonProfile.adm.setActivity(rs.getInt("activity"));
                    singletonProfile.adm.setContract_data(hire_date);
                    singletonProfile.adm.setSalary(rs.getFloat("salary"));
                    
                    //if(singletonProfile.adm.getPassword().equals(singletonProfile.userPass))
                        valid = true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Ha habido un problema al buscar el usuario por nombre y contraseņa");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println("Error en el Logger");
                }
            }
        }

        return valid;
    }

    
    /**Search on mongo client collection for a client with usernam and password 
     * gived on main login
     * 
     * @return boolean
     */
    public static boolean DAO_searchONclient(){
        boolean valid=false;
        DBCursor cursor = null;
        Client clt = new Client();
        
        try {
            BasicDBObject query = new BasicDBObject();
            query.put("user", singletonProfile.userName);
            
            cursor = singletonGen.collection.find(query);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    clt = singletonProfile.clt.DB_to_Client(document);
                    
                    if(clt.getPassword().equals(singletonProfile.userPass)){
                        valid=true;
                        System.out.println("ERROR Login for while!!!");
                    }
                }
                
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        return valid;
    }
    /**Look for a user reg on singletonReg.RegTableArray with usernam 
     * and password gived on main login
     * 
     * @return boolean
     */

    public static boolean DAO_searchONreg() {
        boolean valid = false;
        singletonProfile.RegU.setUser(singletonProfile.userName);
        singletonProfile.RegU.setPassword(singletonProfile.userPass);
        jsonReg.RegJson_Autoload();
        
        if (singletonReg.RegTableArray != null) {
            for (RegisteredU regu : singletonReg.RegTableArray) {
                if (regu.getUser().equals(singletonProfile.RegU.getUser()) && regu.getPassword().equals(singletonProfile.RegU.getPassword())) {//search by username/password
                    singletonProfile.RegU = regu;
                    valid = true;
                }
            }
        }
        return valid;
    }

    /**askUsername
     * Check if the main_Login.txt_userName text field is valid 
     *
     * @return boolean
     */
    public static boolean askUsername() {
        boolean valid = false;

        if (main_login.txt_userName.getText().isEmpty()) {
            main_login.txt_userName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_login.txt_userName.setToolTipText(Language.getInstance().getProperty(""));
            main_login.lbl_singINerror.setText(Language.getInstance().getProperty("error"));
            main_login.lbl_singINerror.setFont(new java.awt.Font("Dialog", 1, 12));
            main_login.lbl_singINerror.setForeground(Color.red);
        } //else if(main_Admin.txtf_formAdm_name.getText())
        else if (!validate.LettersNumbers(main_login.txt_userName.getText())) {
            main_login.txt_userName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_login.txt_userName.setFont(new java.awt.Font("Dialog", 0, 12));
            main_login.txt_userName.setToolTipText(Language.getInstance().getProperty(""));
            main_login.lbl_singINerror.setText(Language.getInstance().getProperty(""));
            main_login.lbl_singINerror.setFont(new java.awt.Font("Dialog", 1, 12));
            main_login.lbl_singINerror.setForeground(Color.red);
        } else {
            singletonProfile.userName = main_login.txt_userName.getText();
            main_login.txt_userName.setBorder(null);
            main_login.txt_userName.setToolTipText("");
            main_login.lbl_singINerror.setText("");
            valid = true;
        }
        return valid;
    }
    /**askUsername
     * Check if the main_Login.jpf_pass field is valid
     *
     * @return boolean
     */
    public static boolean askPassword() {
        boolean valid = false;
        
        String pass =  new String(main_login.jpf_pass.getPassword());
        /*
        for (int i = 0; i < main_login.jpf_pass.getPassword().length; i++) {
            if (main_login.jpf_pass.getPassword()[i] != '-') {
                pass += main_login.jpf_pass.getPassword()[i];
            }
        }
        */
        if (pass.equals("")) {
            main_login.jpf_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_login.lbl_singINerror.setToolTipText(Language.getInstance().getProperty("errAsk_pass"));
            main_login.lbl_singINerror.setText(Language.getInstance().getProperty("error"));
            main_login.lbl_singINerror.setFont(new java.awt.Font("Dialog", 1, 12));
            main_login.lbl_singINerror.setForeground(Color.red);
        } else if (!validate.Password(pass)) {
            main_login.jpf_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 2));
            main_login.lbl_singINerror.setToolTipText(Language.getInstance().getProperty("errVal_pass"));
            main_login.lbl_singINerror.setText(Language.getInstance().getProperty("error"));
            main_login.lbl_singINerror.setForeground(Color.red);
        } else {
            singletonProfile.userPass = pass;
            main_login.jpf_pass.setBorder(null);
            main_login.lbl_singINerror.setToolTipText("");
            main_login.lbl_singINerror.setText("");
            valid = true;
        }
        return valid;
    }
}
