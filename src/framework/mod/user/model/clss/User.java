/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.model.clss;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.clss.DateO;
import framework.tools.format;
import java.io.Serializable;

/**
 *
 * @author osotemi
 */
@XStreamAlias("User")
public abstract class User implements Serializable {

    private static final long serialVersionUID = 2563778779148210607L;

    /**
     * Definition of User object
     * --------------------------------
     */
    @XStreamAlias("age")
    private int age;
    @XStreamAlias("avataring")
    private String avataring;
    @XStreamAlias("born_date")
    private DateO born_date;
    @XStreamAlias("dni")
    private String dni;
    @XStreamAlias("email")
    private String email;
    @XStreamAlias("movile")
    private String movile;
    @XStreamAlias("name")
    private String name;
    @XStreamAlias("lastname")
    private String lastname;
    @XStreamAlias("password")
    private String password;
    @XStreamAlias("state")
    private String state;
    @XStreamAlias("user")
    private String user;
    @XStreamAlias("benefit")
    private float benefit;//Common to sons

    /**
     * ---------------------------------- Public methods of the User class
	 * --------------------------------
     */
    /**
     * <<<----------constructors--------->>>
	 *
     */
    /**
     * empty constructor-->Generate an empty User object
     *
     * @param void
     * @return null
	 *
     */
    public User() {
    }

    /**
     * Primary key constructor-->Generate an User object with the primary key
     *
     * @param dni
     * @return void
     */
    public User(String dni) {
        this.setDni(dni);
    }

    /**
     * constructor choice --> generate an object with one value choosed by the
     * user
     *
     * @param object value
     * @param int choice
     * @return void choice options: 0->Avataring 1->born_date 2->DNI 3->email
     * 4->movile 5->name 6->lastname 7->password 8->state 9->User
	 *
     */
    public User(Object value, int choice) {

        switch (choice) {
            case 0:
                this.setAvataring((String) value);
                break;
            case 1:
                this.setBorn_date((DateO) value);
                break;
            case 2:
                this.setDni((String) value);
                break;
            case 3:
                this.setEmail((String) value);
                break;
            case 4:
                this.setMovile((String) value);
                break;
            case 5:
                this.setName((String) value);
                break;
            case 6:
                this.setLastname((String) value);
                break;
            case 7:
                this.setPassword((String) value);
                break;
            case 8:
                this.setState((String) value);
                break;
            case 9:
                this.setUser((String) value);
                break;

        }
    }

    /**
     * full constructor-->Generate an complete User object
     *
     * @param String avataring
     * @param String born_date
     * @param String DNI
     * @param String email
     * @param String movile
     * @param String name
     * @param String lastname
     * @param String password
     * @param String state
     * @param String User
     * @return void
	 *
     */
    public User(String avatar, DateO birth_date, String DNI, String email, String movile, String name, String lastname, String password, String state, String user) {
        this.setAvataring(avatar);
        this.setBorn_date(birth_date);
        this.setDni(DNI);
        this.setEmail(email);
        this.setMovile(movile);
        this.setName(name);
        this.setLastname(lastname);
        this.setPassword(password);
        this.setState(state);
        this.setUser(user);
    }

    /**
     * <<<----------getters--------->>>
     */
    public int getAge() {
        return age;
    }

    public String getAvataring() {
        return avataring;
    }

    public DateO getBorn_date() {
        return born_date;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getMovile() {
        return movile;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public String getUser() {
        return user;
    }

    public float getBenefit() {
        return benefit;
    }

    /**
     * <<<----------setters--------->>>
	 *
     */

    public void setAge(int age) {
        this.age = age;
    }

    public void setAvataring(String avataring) {
        this.avataring = avataring;
    }

    public void setBorn_date(DateO born_date) {
        this.born_date = born_date;
        this.setAge(this.calculateAge());
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMovile(String movile) {
        this.movile = movile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setBenefit(float benefit) {
        this.benefit = benefit;
    }

    /**
     * <<<----------toString--------->>>
	 *
     */
    /**
     * String toString()-->return all the values of an User Object
     */
    @Override
    public String toString() {
        StringBuffer outline = new StringBuffer();
        try {

            outline.append("Name: " + this.getName() + "\n");
            outline.append("Last name: " + this.getLastname() + "\n");
            outline.append("Age: " + format.formAge(this.getAge()) + "\n");
            outline.append("DNI: " + this.getDni() + "\n");
            outline.append("User name: " + this.getUser() + "\n");
            outline.append("Password: " + format.formPassCoverd(this.getPassword()) + "\n");
            outline.append("Email: " + this.getEmail() + "\n");
            outline.append("Movile: " + format.formPhone(this.getMovile()) + "\n");

            outline.append("Avataring: " + this.getAvataring() + "\n");
            outline.append("Birthday date: " + format.formDate(this.getBorn_date().getSdate()) + "\n");
            outline.append("State: " + this.getState() + "\n");
            outline.append("Benefit: " + this.getBenefit() + "\n");
        } catch (Exception e) {
            try {

                outline.append("Primary key (DNI) -> " + this.getDni());
            } catch (Exception e2) {
                outline.append("EMPTY");
            }
        }

        return outline.toString();
    }

    /**
     * String toString_PK()-->return primary key value of an User Object
     */
    public String toStringPK() {
        return this.getDni();
    }

    /**
     * String toString( int choice) --> return an atribute of the User class
     * chosen by the user 0->Age 1->avataring 2->born_date 3->DNI 4->email
     * 5->movile 6->name 7->lastname 8->password 9->state 10->User 11->benefit
	 *
     */
    public String toString(int chose) {
        String outline = "";

        switch (chose) {
            case 0:
                outline = Integer.toString(this.getAge());
                break;
            case 1:
                outline = this.getAvataring();
                break;
            case 2:
                outline = this.getBorn_date().getSdate();
                break;
            case 3:
                outline = this.getDni();
                break;
            case 4:
                outline = this.getEmail();
                break;
            case 5:
                outline = this.getMovile();
                break;
            case 6:
                outline = this.getName();
                break;
            case 7:
                outline = this.getLastname();
                break;
            case 8:
                outline = this.getPassword();
                break;
            case 9:
                outline = this.getState();
                break;
            case 10:
                outline = this.getUser();
                break;
            case 11:
                outline = format.formMoneyEuro(this.getBenefit());
        }

        return outline;
    }

    /**
     * Function calculateAge
     *
     * @return vector with time diference
     */
    public int calculateAge() {
        int[] diff;
        DateO today = new DateO();
        today.getTodaydate();
        diff = today.diffTime(this.getBorn_date());

        return diff[0];
    }

    /**
     * Function that compare two user objects by DNI
     *
     * @param user
     * @return int 1-> caller > param /$/ -1-> caller < param /$/ 0-> caller =
     * param
     */
    public int compareTo(User user) {
        if (this.getDni().compareTo(user.getDni()) > 0) {
            return 1;
        }
        if (this.getDni().compareTo(user.getDni()) < 0) {
            return -1;
        }
        return 0;
    }

    /**
     * Function that returns if two dni are equals
     *
     * @param user
     * @return caller.dni user.dni
     */
    public boolean equals(Object user) {
        return this.getDni().equals(((User) user).getDni());
    }

    public abstract float calculateBenefit();
}
