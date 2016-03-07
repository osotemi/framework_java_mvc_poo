/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.admin.model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.clss.DateO;
import framework.mod.user.model.clss.User;
import framework.tools.format;
import java.io.Serializable;

/**
 *
 * @author osotemi
 */
@XStreamAlias("Admin")
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = -3596670570670852827L;

    /**
     * ---------------------------------- Definition of Admin object
	 * --------------------------------
     */
    @XStreamAlias("activity")
    private int activity;
    @XStreamAlias("antiqueness")
    private int antiqueness;//months
    @XStreamAlias("contract_data")
    private DateO contract_data;
    @XStreamAlias("salary")
    private float salary;

    /**
     * ---------------------------------- Public methods of the Admin class
	 * --------------------------------
     */
    /**
     * <<<----------constructors--------->>>
	 *
     */
    /**
     * empty constructor-->Generate an empty Admin object
     */
    public Admin() {
        super();
    }

    /**
     * Primary key constructor-->Generate an Admin object with the primary key
     */
    public Admin(String dni) {
        super(dni);
    }

    /**
     * constructor choice --> generate an Admin object with one value choosed by
     * the user
     *
     * 0->avataring 1->born_date 2->DNI 3->email 4->movile 5->name 6->lastname
     * 7->password 8->state 9->User
     *
     * 10->Activity 11->contract_data; 12->salary
	 *
     */
    public Admin(Object value, int choice) {
        super(value, choice);

        switch (choice) {
            case 10:
                this.setActivity((int) value);
                break;
            case 11:
                this.setContract_data((DateO) value);
                break;
            case 12:
                this.setSalary((int) value);
                break;
            default:
                //functions.showString("Invalid atribute selection to initiate de Admin Object", "ERR selected atribute Admin constructor");
                break;
        }
    }

    /**
     * full constructor-->Generate an complete Admin object
     */
    public Admin(String avatar, DateO born_date, String DNI, String email, String movile, String name, String lastname, String password, String state, String user, int activity, DateO singdata) {
        super(avatar, born_date, DNI, email, movile, name, lastname, password, state, user);
        this.setContract_data(singdata);
        this.setActivity(activity);

    }

    /**
     * <<<----------getters--------->>>
     */
    public int getActivity() {
        return activity;
    }

    public int getAntiqueness() {
        return antiqueness;
    }

    public DateO getContract_data() {
        return contract_data;
    }

    public float getSalary() {
        return salary;
    }

    /**
     * <<<----------setters--------->>>
	 *
     */
    public void setActivity(int activity) {
        this.activity = activity;
        super.setBenefit(calculateBenefit());
    }

    public void setAntiqueness(int antiqueness) {
        this.antiqueness = antiqueness;
    }

    public void setContract_data(DateO contract_data) {
        this.contract_data = contract_data;
        this.setAntiqueness(this.calculateAntiquieness());
        this.setSalary(this.calculateSalary());
    }

    public void setSalary(float salary) {
        this.salary = salary;
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

            outline.append("Antiqueness: " + format.formMonthAntique(getAntiqueness()) + "\n");
            outline.append("Activity: " + this.getActivity() + "\n");
            outline.append("Contract data: " + format.formDate(getContract_data().getSdate()) + "\n");
            outline.append("Salary = " + format.formMoneyEuro(getSalary()) + "\n");
        } catch (Exception e) {
            try {
                outline.append("Primary key (DNI) -> " + this.getDni());
            } catch (Exception e2) {
                outline.append("EMPTY");
            }
        }

        return super.toString() + outline.toString();
    }

    /**
     * String toString( int choice) --> return an atribute of the User class
     * chosen by the user 0->Age 1->avataring 2->born_date 3->DNI 4->email
     * 5->movile 6->name 7->lastname 8->password 9->state 10->User 11->benefits
     *
     * 12->Activity 13->antiqueness 14->contract_data; 15->salary
	 *
     */
    public String toString(int chose) {
        String outline = "";

        switch (chose) {
            case 0:
                outline = super.toString(chose);
                break;
            case 1:
                outline = super.toString(chose);
                break;
            case 2:
                outline = super.toString(chose);
                break;
            case 3:
                outline = super.toString(chose);
                break;
            case 4:
                outline = super.toString(chose);
                break;
            case 5:
                outline = super.toString(chose);
                break;
            case 6:
                outline = super.toString(chose);
                break;
            case 7:
                outline = super.toString(chose);
                break;
            case 8:
                outline = super.toString(chose);
                break;
            case 9:
                outline = super.toString(chose);
                break;
            case 10:
                outline = super.toString(chose);
                break;
            case 11:
                outline = super.toString(chose);
                break;
            case 12:
                outline = Integer.toString(this.getActivity());
                break;
            case 13:
                outline = format.formMonthAntique(getAntiqueness());
                break;
            case 14:
                outline = format.formDate(getContract_data().getSdate());
                break;
            case 15:
                outline = format.formMoneyEuro(getSalary());
                break;
        }

        return outline;
    }

    public String toStringPK() {
        return "Primary key (DNI) -> " + super.getDni();
    }

    public int calculateAntiquieness() {
        int ant = 0;
        DateO today = new DateO();
        today.getTodaydate();
        ant = today.diffDates(this.getContract_data(), 1);

        return ant;
    }

    public float calculateBenefit() {
        float benefit = (((float) this.getActivity()) / 10);

        return benefit;
    }

    private float calculateSalary() {
        float salary = 1100.0f;
        float antiguityplus;
        try {
            antiguityplus = (this.getAntiqueness() * 5.25f);
            salary += antiguityplus;
        } catch (Exception e) {
            System.out.println("calculate salary err");
        }
        try {
            salary += this.getBenefit();
        } catch (Exception e) {
            System.out.println("calculate salary err");
        }
        return salary;
    }
}
