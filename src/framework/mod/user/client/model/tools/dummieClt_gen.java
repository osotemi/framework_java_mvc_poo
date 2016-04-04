/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.tools;

import framework.clss.DateO;
import framework.mod.nav.model.tools.menu_gen;
import framework.mod.settings.model.clss.Settings;
import framework.mod.user.client.controler.Controler_mainClient;
import framework.mod.user.client.model.BLL.BLL_Client;
import framework.mod.user.client.model.classes.Client;
import framework.mod.user.client.model.classes.singletonClient;
import framework.mod.user.registered.controler.Controler_mainReg;
import framework.mod.user.registered.model.tools.jsonReg;
import framework.tools.format;
import framework.tools.functions;
import framework.tools.validate;
import java.io.IOException;



/**
 *
 * @author osotemi
 */
public class dummieClt_gen {
    
    public static final String NIF_STRING_CHAR = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static void menu_dummie() {
        String num_dummies = "";

        int num_dum = 0;
        boolean back = false;

        do {
            String[] num = {"1", "5", "10", "20", "50", "100", "Atrás"};
            num_dummies = menu_gen.menucombo(num, "Atrás", "Cúantos dummies quiere generar?", "Dummie Generator");

            if (num_dummies.equals(null)) {
                back = true;
            } else if (num_dummies.equals("Atrás")) {
                back = true;
            } else {
                try {
                    num_dum = Integer.parseInt(num_dummies);
                    for (int i = 0; i < num_dum; i++) {
                        dummieClt_gen.dummieClient();
                    }
                    jsonClt.ClientJson_Autosave();
                    Controler_mainClient.runTABLE();
                    back = true;
                } catch (Exception e) {
                    functions.showERR("ERR on dummie creation. Please try again");
                }
            }
        } while (!back);
    }

    public static void Dum_loader() {
        jsonClt.ClientJson_Autoload();

    }

    /**
     * Function dummieClient creates a random validate Admin user and adds it to
 singletonU.Alist_adm
     *
     */
    public static void dummieClient() {
        String name, lastname, dni;
        int valid_dni = 0;
        
        DateO born = dummieClt_gen.rdmBorndate();
        DateO sing = dummieClt_gen.rdmSingdate(born);
        name = rdmName();
        lastname = rdmLastName()+ " " + rdmLastName();

        do {
            dni = rdmDNI();
            singletonClient.ephemeralClient = new Client(dni);
            valid_dni = BLL_Client.searchAL();
        } while (valid_dni != -1);

        singletonClient.ephemeralClient = new Client(rdmAvatar(), born, dni, rdmEmail(name, lastname), rdmPhone(), name, lastname , rdmPasswd(), rdmState(), dummieClt_gen.rdmUser(name, lastname),  rdmClType(),rdmPremium(), sing, rdmShopAccount(sing));
        
        try {
            singletonClient.ClienTableArray.add(singletonClient.ephemeralClient);
        } catch (Exception ex) {
            System.out.println("ERR dummie generation");
        }
    }
    
    public static String rdmAvatar() {
        String avatar="";
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
        email = spltName[0] +  ".";
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
        String[] lsname = {"Vicent", "Xorx", "Joan", "Ana María", "Daniel", "Pepo", "Sara", "Pepa", "Felip", "Guillermo", "Marc", "David",
            "Guillem", "Uxia", "Marcos", "Ramon", "Jorge", "Teresa", "Aroa", "Manuel", "Alba", "Inés", "Consolación", "Maruja", "Emilia", "Sonia",
            "Jaume", "Sergio", "Paco", "Emilio", "Nando", "Alfons", "Natalia", "Verónica", "Fina", "Pepe", "Rosendo", "Joey", "Jhonny", "Tommy", "Jim", "Michael",
            "Oscar", "Lorelay", "Jim", "Lola", "Laia", "Ismael", "Jordi", "Damián", "Carolina", "Yolanda", "Pep", "Joan", "Araceli", "Javier", "Núria", "Roser", "Elena", "Pablo", "Juanjo"};
        int pos = 0;
        do {
            pos = (int) (Math.random() * lsname.length);
        } while (pos >= lsname.length);

        return lsname[pos];
    }

    public static String rdmLastName() {
        String[] lslast_name = {"Otero", "Millán", "Parra", "Pavía", "Paz", "Rebate", "Castelló", "Teruel", "Gargallo", "Plaza", "Martínez", "Sanz", "Falcó", "Marín", "Nebot", "Banús", "Zorrilla",
            "Giadas", "De Las Mulas", "Navarro", "Gayá", "Callaú", "Rabadan", "Rúbio", "Beltrán", "Serrano", "Pagés", "Cobain", "Hendrix", "Mercado", "Márquez", "Puente", "Rodríguez", "Ramone",
            "Buenafuente", "Salvador", "De Castro"};
        int pos = 0;
        do {
            pos = (int) (Math.random() * lslast_name.length);
        } while (pos >= lslast_name.length);

        return lslast_name[pos];
    }

    /**
     * Function that generates a valid date for user born date ((today date -65) <
     * > (today date - 18))
     *
     * @return date ->
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
        return "" + name.charAt(0) + name.charAt(1) + name.charAt(2) + lastname.charAt(0) + lastname.charAt(1) + lastname.charAt(2);
    }
    //Client attributes
    public static int rdmShopAccount(DateO singDate){
        DateO today = new DateO();
        int diff = 0;
        today.getTodaydate();
        diff = today.getYear() - singDate.getYear();
        int activity = (int) ((Math.random() * 10000)* diff);
        activity = (int) (activity / (Math.random() * 30));
        return activity;
    }
    
    public static boolean rdmPremium(){
        if((int)(Math.random() * 10)> 5){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String rdmClType(){
        String types[] = {"Chrome", "Silver", "Gold", "Platinum" };
        int chances = (int)(Math.random() * 10);
        String type =" ";
        
        if(chances<4){
            type = types[0];
        }else if(chances>=4 && chances <=7){
            type = types[1];
        }else if(chances>7 && chances <=9){
            type = types[2];
        }else{
            type = types[3];
        }
        return type;
    }
}
