/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author osotemi
 */
public class validate {

    /**
     * function string gived returns true contains Letters Only
     *
     * @param string valstr
     *
     * @return bool
     */
    public static boolean LettersOnly(String str) {
        String Pattern_name = "^([A-Za-z·ÈÌÛ˙¡…Õ”⁄ ]{1,60})";
        return str.matches(Pattern_name);
    }

    public static boolean LettersNumbers(String str) {
        String Pattern_name = "^([A-Za-z √ë√±√Å√Ä√â√à√ì√í√ö√†√°√©√†√≠√≥√†√∫0123456789]{1,60})";
        return str.matches(Pattern_name);
    }

    public static boolean Numbers(String str) {
        String Pattern_name = "^([0-9]{1,9} .)";
        return str.matches(Pattern_name);
    }

    public static boolean Phone(String phone_num) {
        String Pattern_phone = "^([6|9]{1})[0-9]{8}$";
        return phone_num.matches(Pattern_phone);
    }

    public static boolean Password(String pass) {
        String Pattern_pass = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

        return pass.matches(Pattern_pass);
    }

    public static boolean DNI(String dni) {
        String Pattern_dni = "^[X-Zx-z0-9]{1}[0-9]{7}[A-Za-z]{1}$";

        String controlstr = "TRWAGMYFPDXBNJZSQVHLCKET";
        char dnilet = ' ', contrlet = ' ';
        String aux;
        int dninum = 0, rest;
        boolean valid = false;

        Pattern pattern = Pattern.compile(Pattern_dni);
        Matcher match = pattern.matcher(dni);

        if (match.matches()) {
            aux = "";
            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);
            }
            dnilet = dni.charAt(8);
            dnilet = Character.toUpperCase(dnilet);
            dninum = Integer.parseInt(aux);
            rest = dninum % 23;
            contrlet = controlstr.charAt(rest);
            if (contrlet == dnilet) {
                valid = true;
            } else {
                valid = false;
            }
        }

        return valid;
    }

    public static boolean Email(String email) {
        String Pattern_email = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return email.matches(Pattern_email);
    }

}
