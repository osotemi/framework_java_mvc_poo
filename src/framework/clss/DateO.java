/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.clss;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.mod.settings.model.clss.Settings;
import javax.swing.JOptionPane;

/**
 * @version 1.6.1 23/2/2016
 * @author osotemi
 */
@XStreamAlias("DateO")
public class DateO implements Serializable {

    private static final long serialVersionUID = -1047863216917244387L;

    @XStreamAlias("milsec")
    private int milsec;
    @XStreamAlias("second")
    private int second;
    @XStreamAlias("minute")
    private int minute;
    @XStreamAlias("hour")
    private int hour;
    @XStreamAlias("day")
    private int day;
    @XStreamAlias("month")
    private int month;
    @XStreamAlias("year")
    private int year;
    @XStreamAlias("sdate")
    private String sdate;
    @XStreamAlias("crono")
    private String crono;

    /**
     * Empty contructor of the Datecl
     */
    public DateO() {

    }

    /**
     * contructor of the Datecl string gived
     *
     * @param date
     */
    public DateO(String date) {//well format date dd/mm/yyyy
        String[] datedata = null;
        datedata = date.split("/");

        this.setDay((Integer.parseInt(datedata[0])));
        this.setMonth((Integer.parseInt(datedata[1])));
        this.setYear((Integer.parseInt(datedata[2])));
        this.setSdate(date);
    }

    /**
     * contructor of the Datecl int gived Fdate is recalculated on setters
     *
     * @param int day
     * @param int month
     * @param int year
     */
    public DateO(int day, int month, int year) {

        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);

    }

    /**
     * constructor Calendar gived------
     */
    public DateO(Calendar date_calendar){
                
        this.setDay(date_calendar.get(Calendar.DAY_OF_MONTH));
        this.setMonth(date_calendar.get(Calendar.MONTH) +1);
        this.setYear(date_calendar.get(Calendar.YEAR));
        
    }
    
    /**
     * Gettes & Setters
     *
     * @return void
     */
    public int getMilsec() {
        return milsec;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public String getSdate() {
        return this.sdate;
    }

    public String getCrono() {
        return crono;
    }

    public void setMilsec(int milsec) {
        this.milsec = milsec;
    }

    public void setSecond(int seconds) {
        this.second = seconds;
        this.recalCrono();
    }

    public void setMinute(int minutes) {
        this.minute = minutes;
        this.recalCrono();
    }

    public void setHour(int hours) {
        this.hour = hours;
        this.recalCrono();
    }

    public void setDay(int day) {
        this.day = day;
        this.recalDatestr();
    }

    public void setMonth(int month) {
        this.month = month;
        this.recalDatestr();
    }

    public void setYear(int year) {
        this.year = year;
        this.recalDatestr();
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public void setCrono(String crono) {
        this.crono = crono;
    }

    /**
     * -----------------------Methods-------------------
     */
    /**
     * getTodaydate method An object called attribute that fields the object
     * with the data of today date
     *
     * @param void
     *
     * @return void
     */
    public void getTodaydate() {
        GregorianCalendar dat = new GregorianCalendar();
        dat.getTime();

        this.setMilsec(dat.get(Calendar.MILLISECOND));
        this.setSecond(dat.get(Calendar.SECOND));
        this.setMinute(dat.get(Calendar.MINUTE));
        this.setHour(dat.get(Calendar.HOUR));
        this.setDay(dat.get(Calendar.DAY_OF_MONTH));
        this.setMonth(dat.get(Calendar.MONTH) + 1);
        this.setYear(dat.get(Calendar.YEAR));

    }

    /**
     * recalculate Sdate method when an int atribute change, recalculate Fdate
     * atributte
     *
     * @param void
     *
     * @return void
     */
    public void recalDatestr() {
        String date = "";

        if (Integer.toString(this.getDay()).length() == 1) {
            date += "0" + Integer.toString(this.getDay()) + "/";
        } else {
            date = Integer.toString(this.getDay()) + "/";
        }

        if (Integer.toString(this.getMonth()).length() == 1) {
            date += "0" + Integer.toString(this.getMonth()) + "/";
        } else {
            date += Integer.toString(this.getMonth()) + "/";
        }
        date += Integer.toString(year);
        this.setSdate(date);
    }

    /**
     * recalculate crono method when an int atribute change, recalculate Fdate
     * atributte
     *
     * @param void
     *
     * @return void
     */
    public void recalCrono() {
        String time = "";
        time = this.getHour() + ":" + this.getMinute() + ":" + this.getSecond();

        this.setCrono(time);
    }

    /**
     * recalculate attributes method when Sdate change, racalculate atributtes
     *
     * @param void
     *
     * @return void
     */
    public void recalAttributes() {
        String date = this.getSdate();
        String[] spltdate = date.split("/");

        this.setDay(Integer.parseInt(spltdate[0]));
        this.setMonth(Integer.parseInt(spltdate[1]));
        this.setYear(Integer.parseInt(spltdate[2]));

    }

    /**
     * ----------------------Datecl_toObject-------------------
     */
    /**
     * toString
     *
     * @param void
     *
     * @return String
     */
    @Override
    public String toString() {//EN FUNCION DE SETTING
        
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }

    /**
     * toCalendar
     *
     * @return Calendar type date
     */
    public Calendar toCalendar() {
        Calendar cdate = Calendar.getInstance();

        cdate.set(this.getYear(), this.getMonth()-1, this.getDay(), this.getHour(), this.getMinute());

        return cdate;
    }

    /**
     * toGregorianCalendarobject
     *
     * @return GC type date
     */
    public GregorianCalendar toGcalendar() {
        GregorianCalendar gcdate = new GregorianCalendar();

        gcdate.set(this.getYear(), this.getMonth(), this.getDay(), this.getHour(), getMinute());

        return gcdate;
    }

    /**
     * --------------objectTOObject methods------------+/ /**toDatecl
     *
     * @param String standard format date
     *
     * @return Datecl type date
     */
    public void stringTODatecl(String strdate) {//A well format standard string
        DateO newdatecl = new DateO(strdate);

        this.copy(newdatecl);
    }

    /**
     * string to Calendar
     *
     * @param String data
     * @return Calendar with date of string
     */
    public Calendar stringTOCalendar(String date) {
        Calendar cdate = Calendar.getInstance();
        this.setSdate(date);
        cdate.set(this.getYear(), this.getMonth(), this.getDay(), this.getHour(), getMinute());

        return cdate;
    }
    
    /**
     * Compare (is later) date where date1 is the caller object and date2 is the
     * string gived
     *
     * @param string date2
     *
     * @return 0 if date2/cal2 is later, 1 if date1/cal1 is later, 2 if equals
     */
    public int isLater(String date2) {
        int outline = 0;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        DateO aux = new DateO(date2);
        cal1 = this.toGcalendar();
        cal2 = aux.toGcalendar();

        if (cal1.before(cal2)) {
            outline = 0;
        } else if (cal1.after(cal2)) {
            outline = 1;
        } else if (cal1.equals(cal2)) {
            outline = 2;
        }
        return outline;
    }

    /**
     * Compare (is later) date where date1 is the caller object and date2 is the
     * string gived
     *
     * @param string date2
     *
     * @return -1 if date2/cal2 is later, 1 if date1/cal1 is later, 0 if equals
     */
    public int isLaterO(DateO date2) {
        int outline = 0;
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1 = this.toGcalendar();
        cal2 = date2.toGcalendar();

        if (cal1.before(cal2)) {
            outline = -1;
        } else if (cal1.after(cal2)) {
            outline = 1;
        } else if (cal1.equals(cal2)) {
            outline = 0;
        } else {
            System.out.println("isLaterO ERROR");
        }
        return outline;
    }

    /**
     * function string gived returns if contains a well format and real date
     * type string in 4 formats
     *
     * @param string Date
     *
     * @return bool-> if is a valid date
     */
    public boolean valDate(String newdate) {
        boolean valid = false;
        String[] formats = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};

        for (int i = 0; i < formats.length; i++) {
            try {
                SimpleDateFormat formdate = new SimpleDateFormat(formats[i], Locale.getDefault());
                formdate.setLenient(false);
                formdate.parse(newdate);
                valid = true;
                i = formats.length;
            } catch (Exception e) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * function string gived returns if contains a well format and real date
     * type string in 1 of the 4 valid format
     *
     * @param string Date
     * @param string format ==> 1->dd/MM/yyyy 2->dd-MM-yyyy 3->yyyy/MM/dd
     * 4->yyyy-MM-dd
     *
     * @return bool-> if is a valid date
     */
    public boolean valDateSform(String newdate) {
        boolean valid = false;

        try {
            SimpleDateFormat formdate = new SimpleDateFormat(Settings.getInstance().getFdate(), Locale.getDefault());
            formdate.setLenient(false);
            formdate.parse(newdate);
            valid = true;
        } catch (Exception e) {
            valid = false;
        }

        return valid;
    }

    /**
     * isValid check if this date is between actual year - 65 and today
     * year - 18
     *
     * @return boolean valid
     */
    public boolean isValid_workage() {
        DateO todayDate = new DateO();
        todayDate.getTodaydate();
        boolean valid = false;
        if ((this.getYear() > (todayDate.getYear() - 65)) && (this.getYear() < (todayDate.getYear() - 18)) && (this.isLater(todayDate.getSdate()) != 1)) {
            valid = true;
        }
        return valid;
    }

    /**
     * isValid check if the input date is between actual year - 65 and today
     * year - 18
     *
     * @return boolean valid
     */
    public boolean isValid_singdate(DateO bornDate) {
        DateO todayDate = new DateO();
        todayDate.getTodaydate();
        boolean valid = false;

        bornDate.setYear(bornDate.getYear() + 18);
        if ((this.isLaterO(bornDate) == 1) && (this.isLaterO(todayDate) == -1)) {
            valid = true;
        }
        bornDate.setYear(bornDate.getYear() - 18);
        return valid;
    }

    /**
     * ------------------difference between to dates---------------------------------
     */
    /**
     * Function date gived, compare with the caller method object
     *
     * @param Datecl -> date to compare with
     * @param integer unit of measure->0 = years, 1 = months, 2 = days, ->>>>
     * NEXT>>>>>3 = hours, 4=minutes, 5= seconds, 6=miliseconds
     *
     *
     * @return integer time in the indicated measure
     */
    public int diffDates(DateO indate, int time_unit) {
        int[] endmonthday = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int yeardiff = 0, monthdiff = 0, daydiff = 0, leap_year = 0, modmonths = 0, finaldiff = 0;

        GregorianCalendar date = new GregorianCalendar(this.getYear(), this.getMonth() - 1, this.getDay());
        GregorianCalendar date2 = new GregorianCalendar(indate.getYear(), indate.getMonth() - 1, indate.getDay());

        if (date.get(Calendar.YEAR) >= date2.get(Calendar.YEAR)) {
            long tiempo = date.getTimeInMillis() - date2.getTimeInMillis();//difference in miliseconds between date(caller object) & date2(input DataO)
            daydiff = (int) ((tiempo) / (1000 * 60 * 60 * 24));//milis to seconds

            for (int i = date2.get(Calendar.YEAR); i <= date.get(Calendar.YEAR); i++) {
                if (date.isLeapYear(i)) {
                    leap_year++;// leap years cont
                    i += 3;
                }
            }
            daydiff = daydiff - leap_year;

            switch (time_unit) {
                case 0:
                    yeardiff = daydiff / 365;
                    finaldiff = yeardiff;
                    break;
                case 1:
                    if (daydiff > 365) {
                        modmonths = (daydiff % 365);
                        yeardiff = daydiff / 365;
                        monthdiff = yeardiff * 12;
                        for (int i = 0; i < endmonthday.length; i++) {
                            if (endmonthday[i] > modmonths) {
                                monthdiff += i;
                                i = endmonthday.length;
                            }
                        }
                    } else {
                        for (int i = 0; i < endmonthday.length; i++) {
                            if (endmonthday[i] > daydiff) {
                                monthdiff = i;
                                i = endmonthday.length;
                            }

                        }
                    }
                    finaldiff = monthdiff;
                    break;
                case 2:
                    finaldiff = daydiff;
                    break;
                default:
                    break;
            }
        } else {
            finaldiff = -1;
        }

        return finaldiff;
    }

    /**
     * function int gived
     *
     * @param indate
     *
     * @return int [] split_time = { years, months, days, hours, minutes,
     * seconds}
     */
    public int[] diffTime(DateO indate) {
        int[] endmonday = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int[] splitime = {0, 0, 0, 0, 0, 0};
        int yeardiff = 0, monthdiff = 0, daydiff = 0, cont = 0, modmonths = 0;

        long time, secdiff, mindiff, hourdiff;
        GregorianCalendar date = new GregorianCalendar(this.getYear(), this.getMonth() - 1, this.getDay(), this.hour, this.getMinute(), this.getSecond());
        GregorianCalendar date2 = new GregorianCalendar(indate.getYear(), indate.getMonth() - 1, indate.getDay(), indate.getHour(), indate.getMinute(), indate.getSecond());

        if (this.isLater(indate.getSdate()) == 1) {
            time = date.getTimeInMillis() - date2.getTimeInMillis();//difference in milliseconds

            //Save difference in all units
            secdiff = ((time) / 1000);
            mindiff = secdiff / 60;
            splitime[5] = (int) (secdiff % 60);
            hourdiff = mindiff / 60;
            splitime[4] = (int) (mindiff % 60);
            daydiff = (int) (hourdiff / 24);
            splitime[3] = (int) (hourdiff % 24);

            for (int i = date2.get(Calendar.YEAR) + 1; i <= date.get(Calendar.YEAR); i++) {
                if (date.isLeapYear(i)) {
                    cont++;// Leap Year cont
                    i += 3;
                }
            }

            yeardiff = (daydiff - cont) / 365;
            monthdiff = yeardiff * 12;

            splitime[0] = yeardiff;/*years in string split*/
            if (daydiff > 365) {
                modmonths = ((daydiff - cont) % 365);
                yeardiff = ((daydiff - cont) / 365);
                monthdiff = yeardiff * 12;
                for (int i = 0; i < endmonday.length; i++) {
                    if (endmonday[i] > modmonths) {
                        monthdiff += i;
                        splitime[1] = i;/*months in string split*/
                        if (i == 0) {
                            splitime[2] = modmonths;/*days in string split*/
                        } else {
                            splitime[2] = modmonths - endmonday[i - 1];/*days in string split*/
                        }

                        i = endmonday.length;
                    }
                }
            } else {
                for (int i = 0; i < endmonday.length; i++) {
                    if (endmonday[i] > daydiff) {
                        monthdiff = i;
                        splitime[1] = monthdiff;//months in string split (is the higher unit)
                        if (i == 0) {
                            splitime[2] = daydiff;/*days in string split*/
                        } else {
                            splitime[2] = daydiff - endmonday[i - 1];/*days in string split*/
                        }

                        i = endmonday.length;
                    }
                }
            }
        } else {
            yeardiff = -1;
        }
        return splitime;
    }

    /**
     * function formDate String gived returns DateO with Settings format
     *
     * @param string date is a validated string date format (dd/MM/yyyy,
     * yyyy/MM/dd, yyyy-MM-dd, dd-MM-yyyy)
     *
     * @return String standart dd/MM/yyyy format
     */
    public static String formDate(String date) {
        String formdate = "";
        String[] oldformat, newformat = {"00", "00", "0000"};
        int typeform = 0, settform = 0;//type of form of string gived date & the type of conf formatdate
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
                System.err.println("ERROR formatDate");
            }
        }
        for (int j = 0; j < formats.length; j++) {
            if (formats[j].equals(Settings.getInstance().getFdate())) {
                settform = j;
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

            switch (settform) {

                case 0:
                    formdate = newformat[0] + "/" + newformat[1] + "/" + newformat[2];
                    break;
                case 1:
                    formdate = newformat[0] + "-" + newformat[1] + "-" + newformat[2];
                    break;
                case 2:
                    formdate = newformat[2] + "/" + newformat[1] + "/" + newformat[0];
                    break;
                case 3:
                    formdate = newformat[2] + "-" + newformat[1] + "-" + newformat[0];
                    break;
                default:
                    System.out.println("Data error on formDate swith");
                    break;
            }

        } else {
            System.out.println("Data error on formDate");
        }
        return formdate;
    }
    
    /**isValid check if the input date is between actual year - 65 and today
	 * 
	 * @return boolean valid
	 */
	public boolean isValid(){//for dummies
		DateO todayDate = new DateO();
		todayDate.getTodaydate();
		boolean valid=false;
		if(this.getYear() > (todayDate.getYear() - 65) && this.isLater(todayDate.getSdate()) != 1 ){
			valid = true;
		}
		return valid;
	}
    
    /**
     * copy in the caller object the values of the input DateO object
     *
     * @param DateO orgdate
     */
    public void copy(DateO orgdate) {
        this.setMilsec(orgdate.getMilsec());
        this.setSecond(orgdate.getSecond());
        this.setMinute(orgdate.getMinute());
        this.setHour(orgdate.getHour());
        this.setDay(orgdate.getDay());
        this.setMonth(orgdate.getMonth());
        this.setYear(orgdate.getYear());
    }
}
