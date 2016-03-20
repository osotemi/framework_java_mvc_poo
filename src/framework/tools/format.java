/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.tools;

import framework.mod.settings.model.clss.Settings;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author osotemi
 */
public class format {

    /**
     * function formDecimal float gived returns select decimal format number
     *
     * @param float value
     * @param int decimals
     *
     * @return String
     */
    public static String formDecimal(double num, int dec) {
        DecimalFormat form;
        String decform = ".";

        for (int i = 0; i < dec; i++) {
            decform += "0";
        }
        form = new DecimalFormat(decform);

        return form.format(num);
    }

    /**
     * function formDNI String gived returns String dni format 1234567-8
     *
     * @param String
     *
     * @return String
     */
    public static String formDni(String dni) {
        String aux = "";
        for (int i = 0; i < dni.length(); i++) {
            if (i == 8) {
                aux += "-";
                aux += Character.toUpperCase(dni.charAt(i));
            } else {
                aux += dni.charAt(i);
            }
        }
        return aux;
    }

    /**
     * function formPercen int gived returns percentage format if is possible
     *
     * @param int
     *
     * @return String
     */
    public static String formPercen(int operc) {
        String perc = "";
        perc = Integer.toString(operc) + "%";
        return perc;
    }

    /**
     * function formPassCoverd String gived returns an equal lenght string of
     * '*'
     *
     * @param String
     *
     * @return String
     */
    public static String formPassCoverd(String password) {
        String pass = "";

        if ((password != null) && (password != "")) {
            for (int i = 0; i < password.length(); i++) {
                pass += "*";
            }
        }
        return pass;
    }

    /**
     * function formPhone String gived returns an equal lenght string of '*'
     *
     * @param String
     *
     * @return String
     */
    public static String formPhone(String phonenum) {
        String aux = "+34 ";
        if (phonenum == null) {
            aux = "";
        } else {
            for (int i = 0; i < phonenum.length(); i++) {
                aux += phonenum.charAt(i);
                if ((((i + 1) % 3) == 0)) {
                    aux += " ";
                }
            }
        }
        return aux;
    }

    /**
     * function formMoneyDollar float gived returns string with number +
     * currency Dolar symbol
     *
     * @param float
     *
     * @return String
     */
    public static String formMoneyDollar(float amount) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);//Dollar
        return coin.format(amount);
    }

    /**
     * function formMoneyDollar float gived returns string with number +
     * currency Dollar symbol
     *
     * @param float
     *
     * @return String
     */
    public static String formMoneyLibra(float amount) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);//pound
        return coin.format(amount);
    }

    /**
     * function formMoneyDollar float gived returns string with number +
     * currency Euro symbol
     *
     * @param float
     *
     * @return String
     */
    public static String formMoneyEuro(float amount) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);//Euro
        return coin.format(amount);
    }

    /**
     * function formMoneyDollar float euros gived returns string with
     * recalculate amount + currency Euro symbol
     *
     * @param float
     * @param Loacale
     *
     * @return String
     */
    public static String formMoneyOut(float amount, Locale currency) {
        if (currency == Locale.US) {
            amount *= 1.09379f;
        } else if (currency == Locale.UK) {
            amount *= 0.728932f;
        }
        NumberFormat coin = NumberFormat.getCurrencyInstance(currency);//Euro
        return coin.format(amount);
    }

    /**
     * function formMoneyDollar float gived returns string with number +
     * currency Euro symbol
     *
     * @param float
     * @param Locale
     *
     * @return String
     */
    public static float formMoneyIn(float amount) {
        if (Settings.getInstance().getCurrency() == Locale.US) {
            amount /= 1.09379f;
        } else if (Settings.getInstance().getCurrency() == Locale.UK) {
            amount /= 0.728932f;
        }

        return amount;
    }

    /**
     * function formPoints int gived returns number + points format
     *
     * @param int
     *
     * @return String
     */
    public static String formPoints(int num) {
        String outline = "";
        outline = Integer.toString(num) + " points";
        return outline;
    }

    /**
     * function formYears int gived returns age +_years format
     *
     * @param int
     *
     * @return String
     */
    public static String formAge(int age) {
        String outline = "";
        outline = Integer.toString(age) + " years old";
        return outline;
    }

    /**
     * function formMonthAntiqueness int gived that return a String with years +
     * months of antiqueness
     *
     * @param string months
     *
     * @return String outline
     */
    public static String formMonthAntique(int months) {
        String outline = "";
        if (months <= 12) {
            outline = months + " months";

        } else if ((months % 12) == 0) {
            outline = (months / 12) + " years";

        } else {
            outline = (months / 12) + " years, " + (months % 12) + " months";
        }
        return outline;
    }

    /**
     * function formDate String gived returns Datecl standart dd/MM/yyyy format
     *
     * @param string date is a validated string date format (dd/MM/yyyy,
     * yyyy/MM/dd, yyyy-MM-dd, dd-MM-yyyy)
     *
     * @return String standart dd/MM/yyyy format
     */
    public static String formDate(String date) {
        String formdate = "";
        String[] oldformat, newformat = {"00", "00", "0000"};
        int typeform = 0;//type of form of string gived date
        boolean valid = false;
        String[] formats = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};

        for (int i = 0; i < formats.length; i++) {
            try {
                SimpleDateFormat formatdate = new SimpleDateFormat(formats[i], Locale.getDefault());
                formatdate.setLenient(false);
                formatdate.parse(date);
                valid = true;//when it's here, saves the type of format (i) of the string gived
                typeform = i;
                i = formats.length;
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            switch (typeform) {

                case 0:
                    oldformat = date.split("/");
                    if (oldformat[0].length() == 1) {
                        oldformat[0] = "0" + oldformat[0];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[0];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[2];
                    break;
                case 1:
                    oldformat = date.split("-");
                    if (oldformat[0].length() == 1) {
                        oldformat[0] = "0" + oldformat[0];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[0];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[2];
                    break;
                case 2:
                    oldformat = date.split("/");
                    if (oldformat[2].length() == 1) {
                        oldformat[2] = "0" + oldformat[2];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[2];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[0];
                    break;
                case 3:
                    oldformat = date.split("-");
                    if (oldformat[2].length() == 1) {
                        oldformat[2] = "0" + oldformat[2];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[2];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[0];
                    break;
                default:
                    System.out.println("Data error on formDate swith");
                    break;
            }
            formdate = newformat[0] + "/" + newformat[1] + "/" + newformat[2];
        } else {
            System.out.println("Data error on formDate");
        }
        return formdate;
    }

    

    /**
     * function formDate String gived returns Calendar standart dd/MM/yyyy
     * format
     *
     * @param string date is a validated string date format (dd/MM/yyyy,
     * yyyy/MM/dd, yyyy-MM-dd, dd-MM-yyyy)
     *
     * @return String standart dd/MM/yyyy format
     */
    public static String formDateCalen(String date) {
        String formdate = "";
        String[] oldformat, newformat = {"00", "00", "0000"};
        int typeform = 0;//type of form of string gived date
        boolean valid = false;
        String[] formats = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};

        for (int i = 0; i < formats.length; i++) {
            try {
                SimpleDateFormat formatdate = new SimpleDateFormat(formats[i], Locale.getDefault());
                formatdate.setLenient(false);
                formatdate.parse(date);
                valid = true;//when it's here, saves the type of format (i) of the string gived
                typeform = i;
                i = formats.length;
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            switch (typeform) {

                case 0:
                    oldformat = date.split("/");
                    if (oldformat[0].length() == 1) {
                        oldformat[0] = "0" + oldformat[0];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[0];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[2];
                    break;
                case 1:
                    oldformat = date.split("-");
                    if (oldformat[0].length() == 1) {
                        oldformat[0] = "0" + oldformat[0];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[0];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[2];
                    break;
                case 2:
                    oldformat = date.split("/");
                    if (oldformat[2].length() == 1) {
                        oldformat[2] = "0" + oldformat[2];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[2];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[0];
                    break;
                case 3:
                    oldformat = date.split("-");
                    if (oldformat[2].length() == 1) {
                        oldformat[2] = "0" + oldformat[2];
                    }
                    if (oldformat[1].length() == 1) {
                        oldformat[1] = "0" + oldformat[1];
                    }

                    newformat[0] = oldformat[2];
                    newformat[1] = oldformat[1];
                    newformat[2] = oldformat[0];
                    break;
                default:
                    System.out.println("Data error on formDate swith");
                    break;
            }
            formdate = newformat[2] + "-" + newformat[1] + "-" + newformat[0];
        } else {
            System.out.println("Data error on formDate try catch");
        }
        return formdate;
    }
    
    public static String formRmAccent(String word){
        String validate = "";
        char caracter =' ';
        for(int i = 0; i< word.length(); i++){
            caracter = word.charAt(i);
            switch(caracter){
                case 'Á':
                    validate += 'a';
                    break;
                case 'á':
                    validate += 'a';
                    break;
                case 'É':
                    validate += 'e';
                    break;
                case 'é':
                    validate += 'e';
                    break;
                case 'Í':
                    validate += 'i';
                    break;
                case 'í':
                    validate += 'i';
                    break;
                case 'Ó':
                    validate += 'o';
                    break;
                case 'ó':
                    validate += 'o';
                    break;
                case 'Ú':
                    validate += 'u';
                    break;
                case 'ú':
                    validate += 'u';
                    break;
                default:
                    validate += caracter;
                    break;
            }
        }
        return validate;
    }
}
