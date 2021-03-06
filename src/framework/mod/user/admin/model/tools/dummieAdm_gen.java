/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.tools;

/**
 * Library of functions of Users sons objects Dummies
 *
 * @author Oscar Otero
 * @version 2.0 19/03/2016
 *
 */
import framework.clss.ConnectionBD;
import java.io.IOException;

import framework.clss.DateO;
import framework.mod.settings.model.clss.Settings;
import framework.mod.user.admin.model.BLL.BLL_Admin;

import framework.mod.user.admin.model.classes.Admin;
import framework.mod.user.admin.model.classes.singletonAdmin;
import framework.tools.menu_gen;
import framework.mod.user.admin.controler.Controler_mainAdmin;
import framework.mod.user.admin.model.BLL.BLL_DB_Admin;
import framework.tools.format;
import framework.tools.functions;
import framework.tools.validate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dummieAdm_gen {

    public static final String NIF_STRING_CHAR = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static void menu_dummie() {
        String num_dummies = "";

        int num_dum = 0;
        boolean back = false;

        do {
            String[] num = {"1", "5", "10", "20", "50", "100", "Atr�s"};
            num_dummies = menu_gen.menucombo(num, "Atr�s", "C�antos dummies quiere generar?", "Dummie Generator");

            if (num_dummies.equals(null)) {
                back = true;
            } else if (num_dummies.equals("Atr�s")) {
                back = true;
            } else {
                try {
                    num_dum = Integer.parseInt(num_dummies);
                    for (int i = 0; i < num_dum; i++) {
                        dummieAdm_gen.dummieAdmin();
                    }
                    if (BLL_DB_Admin.BLL_DB_searchByDni() != 0){
                        BLL_DB_Admin.BLL_DB_newAdmin();
                        Controler_mainAdmin.runTABLE();
                        back = true;
                    }
                } catch (Exception e) {
                    functions.showERR("ERR on dummie creation. Please try again");
                }
            }
        } while (!back);
    }

    public static void Dum_loader() throws SQLException {
        Connection _con = null;
        ConnectionBD _connection_DB = new ConnectionBD();
        PreparedStatement stmt = null;
        String name, lastname, dni;
        int valid_dni = 0, valid_update = 0, state=0;

        DateO born = dummieAdm_gen.rdmBorndate();
        DateO sing = dummieAdm_gen.rdmSingdate(born);
        name = rdmName();
        lastname = rdmLastName();

        do {
            dni = rdmDNI();
            singletonAdmin.ephemeralAdmin = new Admin(dni);
            valid_dni = BLL_Admin.searchAL();
        } while (valid_dni != -1);
        
        
        
        _con = ConnectionBD.getConexion();
        JOptionPane.showMessageDialog(null, "Hola DB!!");
        for (int i = 0; i < 1; i++) {
            singletonAdmin.ephemeralAdmin = new Admin(rdmAvatar(), born, dni, rdmEmail(name, lastname), rdmPhone(), name, lastname + " " + rdmLastName(), rdmPasswd(), rdmState(), dummieAdm_gen.rdmUser(name, lastname), rdmActivity(sing), dummieAdm_gen.rdmSingdate(born));
            singletonAdmin.ephemeralAdmin.toString();
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
        }
        ConnectionBD.liberaConexion(_con);
    }

    /**
     * Function dummieAdmin creates a random validate Admin user and adds it to
     * singletonU.Alist_adm
     *
     */
    public static void dummieAdmin() {
        String name, lastname, dni;
        int valid_dni = 0;

        DateO born = dummieAdm_gen.rdmBorndate();
        DateO sing = dummieAdm_gen.rdmSingdate(born);
        name = rdmName();
        lastname = rdmLastName();

        do {
            dni = rdmDNI();
            singletonAdmin.ephemeralAdmin = new Admin(dni);
            valid_dni = BLL_Admin.searchAL();
        } while (valid_dni != -1);

        singletonAdmin.ephemeralAdmin = new Admin(rdmAvatar(), born, dni, rdmEmail(name, lastname), rdmPhone(), name, lastname + " " + rdmLastName(), rdmPasswd(), rdmState(), dummieAdm_gen.rdmUser(name, lastname), rdmActivity(sing), dummieAdm_gen.rdmSingdate(born));
        try {
            singletonAdmin.AdminTableArray.add(singletonAdmin.ephemeralAdmin);
        } catch (Exception ex) {
            System.out.println("ERR dummie generation");
        }
    }

    public static String rdmAvatar() {
        String avatar = "";
        try {
            avatar = new java.io.File(".").getCanonicalPath() + "/src/framework/img/profile_pictures/people-";
        } catch (IOException e) {
            e.printStackTrace();
        }
        int pos = 0;

        do {
            pos = (int) (Math.random() * 27);
        } while (pos >= 28);
        avatar += pos + ".png";

        return avatar;
    }

    public static String rdmEmail(String name, String lastname) {
        String[] spltName = name.split(" ");
        String[] spltLastname = lastname.split(" ");
        String email = "";
        float opt_com = (float) (Math.random() * 2);
        email = spltName[0] + ".";
        email += spltLastname[0];

        email = email.toLowerCase();
        email = format.formRmAccent(email);
        if (opt_com > 0.5f) {
            email += "@gmail.com";
        } else if (opt_com > 1.0f) {
            email += "@hotmail.com";
        } else if (opt_com > 1.5f) {
            email += "@yahoo.com";
        } else {
            email += "@omail.com";
        }
        return email;
    }

    public static String rdmPasswd() {
        String abc = "abcdefghijklmnopkrstuvwz";
        String pass = "";
        int lenght;
        do {
            lenght = (int) (Math.random() * 160);
        } while ((lenght < 8) || (lenght > 16));

        for (int i = 0; i < lenght; i++) {
            int chss = ((int) (Math.random() * 3));

            switch (chss) {
                case 0:
                    pass += abc.charAt((int) (Math.random() * abc.length()));
                    break;
                case 1:
                    pass += Character.toUpperCase(abc.charAt((int) (Math.random() * abc.length())));
                    break;
                default:
                    pass += ((int) (Math.random() * 10));
                    break;
            }
        }
        return pass;
    }

    public static String rdmDNI() {
        String strDNI_char = "TRWAGMYFPDXBNJZSQVHLCKET";

        String DNI = "";
        boolean valid = false;

        do {
            int dec = 10, num = 0;
            for (int i = 0; i < 8; i++) {
                num += (int) (Math.random() * (dec));
                dec += dec * 10;
            }
            DNI = ((String) (Integer.toString(num) + strDNI_char.charAt(num % 23)));
            if (validate.DNI(DNI)) {
                valid = true;
                DNI = format.formDni(DNI);
            }
        } while (!valid);
        return DNI;
    }

    public static String rdmName() {
        String[] lsname = {"Vicent", "Xorx", "Joan", "Ana Mar�a", "Daniel", "Pepo", "Sara", "Pepa", "Felip", "Guillermo", "Marc", "David",
            "Guillem", "Uxia", "Marcos", "Ramon", "Jorge", "Teresa", "Aroa", "Manuel", "Alba", "In�s", "Consolaci�n", "Maruja", "Emilia", "Sonia",
            "Jaume", "Sergio", "Paco", "Emilio", "Nando", "Alfons", "Natalia", "Ver�nica", "Fina", "Pepe", "Rosendo", "Joey", "Jhonny", "Tommy", "Jim", "Michael",
            "Oscar", "Lorelay", "Jim", "Lola", "Laia", "Ismael", "Jordi", "Dami�n", "Carolina", "Yolanda", "Pep", "Joan", "Araceli", "Javier", "N�ria", "Roser", "Elena", "Pablo", "Juanjo"};
        int pos = 0;
        do {
            pos = (int) (Math.random() * lsname.length);
        } while (pos >= lsname.length);

        return lsname[pos];
    }

    public static String rdmLastName() {
        String[] lslast_name = {"Otero", "Mill�n", "Parra", "Pav�a", "Paz", "Rebate", "Castell�", "Teruel", "Gargallo", "Plaza", "Mart�nez", "Sanz", "Falc�", "Mar�n", "Nebot", "Ban�s", "Zorrilla",
            "Giadas", "De Las Mulas", "Navarro", "Gay�", "Calla�", "Rabadan", "R�bio", "Beltr�n", "Serrano", "Pag�s", "Cobain", "Hendrix", "Mercado", "M�rquez", "Puente", "Rodr�guez", "Ramone",
            "Buenafuente", "Salvador", "De Castro"};
        int pos = 0;
        do {
            pos = (int) (Math.random() * lslast_name.length);
        } while (pos >= lslast_name.length);

        return lslast_name[pos];
    }

    /**
     * Function that generates a valid date for user born date bbetween 
     * ((today date -65)  (today date - 18))
     *
     * @return DateO
     */
    public static DateO rdmBorndate() {
        DateO newdate = new DateO();
        DateO todaydate = new DateO();
        todaydate.getTodaydate();
        String askedate = "";
        boolean valid = false;

        do {
            askedate = "";
            askedate += (int) ((Math.random() * 30) + 1) + "/" + ((int) (Math.random() * 11) + 1) + "/" + (1951 + ((int) (Math.random() * 65)));
            valid = newdate.valDateSform(askedate);
            if (valid) {//we confirm if is real date
                newdate = new DateO(askedate);
                valid = newdate.isValid();
                if (valid) {
                    if ((newdate.getYear() + 18) < todaydate.getYear()) {
                        valid = true;
                    } else if ((newdate.getYear() + 18) > todaydate.getYear()) {
                        valid = false;
                    } else if (newdate.getMonth() > todaydate.getMonth()) {
                        valid = false;
                    } else if (newdate.getMonth() < todaydate.getMonth()) {
                        valid = true;
                    } else if (newdate.getDay() > todaydate.getDay()) {
                        valid = false;
                    } else if (newdate.getDay() < todaydate.getDay()) {
                        valid = true;
                    } else {
                        valid = true;//born Day
                    }
                }
            } else {
                functions.showString("Non valid date\nUse format " + Settings.getInstance().getFdate(), "Date valid error");
            }
        } while (!valid);

        return newdate;
    }

    public static DateO rdmSingdate(DateO birthday) {
        DateO dsing = new DateO();
        DateO tdydate = new DateO();
        tdydate.getTodaydate();
        boolean valid = false;
        String rdm_sing = "";
        int[] agesplit = tdydate.diffTime(birthday);
        int age = agesplit[0], workage = 18;

        do {
            rdm_sing = "";
            rdm_sing += (int) ((Math.random() * 30) + 1) + "/" + ((int) (Math.random() * 11) + 1) + "/" + ((birthday.getYear() + 18) + ((int) (Math.random() * (tdydate.getYear() - (birthday.getYear() + 18)))));
            dsing = new DateO(rdm_sing);
            valid = dsing.isValid_singdate(birthday);

        } while (!valid);

        return dsing;
    }

    public static String rdmPhone() {
        String phone = "6";
        for (int i = 0; i < 8; i++) {
            phone += (int) (Math.random() * 10);
        }
        return phone;
    }

    public static String rdmState() {
        int option = (int) (Math.random() * 3);
        String state = "";
        switch (option) {
            case 0:
                state = "Logged";
                break;
            case 1:
                state = "Online";
                break;
            default:
                state = "Offline";
                break;
        }
        return state;
    }

    public static String rdmUser(String name, String lastname) {
        String userName = "" + name.charAt(0) + name.charAt(1) + name.charAt(2) + lastname.charAt(0) + lastname.charAt(1) + lastname.charAt(2);
        
        while(BLL_DB_Admin.BLL_DB_searchByUserName(userName)){
            userName += (int) (Math.random() * 3);
        }
        return userName;
    }

    public static int rdmActivity(DateO singDate) {
        DateO today = new DateO();
        int diff = 0;
        today.getTodaydate();
        diff = today.getYear() - singDate.getYear();
        int activity = (int) ((Math.random() * 1000) * diff);
        return activity;
    }
}
