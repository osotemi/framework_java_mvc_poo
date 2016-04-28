/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.registered.model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.clss.DateO;
import framework.mod.user.model.clss.User;
import java.io.Serializable;
import framework.tools.format;

/**
 *
 * @author osotemi
 */
@XStreamAlias("RegU")
public class RegisteredU extends User implements Serializable{
	/**----------------------------------
	 * Definition of RegisteredU object
	 * --------------------------------*/
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("karma")
	private String Karma;//low-medium-high
	
	/**----------------------------------
	 * Public methods of the RegisteredU class
	 * --------------------------------*/

	/**
	 * <<<----------constructors--------->>>
	 * */
	
	/**empty constructor-->Generate an empty RegisteredU object*/
	public RegisteredU(){
		super();
	}
	
	/**Primary key constructor-->Generate a RegisteredU object with the primary key*/
	public RegisteredU( String DNI ){
		super( DNI );
	}
	
	/**constructor choice --> generate a RegisteredU object with one value choosed by the user
	 * 0->Age_
	 * 1->avataring_
	 * 2->born_date_
	 * 3->DNI_
	 * 4->email_
	 * 5->movile_
	 * 6->name_
	 * 7->lastname_
	 * 8->password_
	 * 9->state_
	 * 10->User_
	 * 11->benefits_
	 *
	 * 12->activity_
	 * 13->Karma_
	 * 
	 *  */
	public RegisteredU( String value, int choice ){
		super(value, choice);
		
		switch ( choice ){
		case 12:
			this.setActivity(Integer.parseInt(value));
			break;
		case 13:
			this.setKarma(value);
			super.setBenefit(calculateBenefit());
			break;
		}
	}
	
	/**full constructor-->Generate an complete RegisteredU object*/
	public RegisteredU( String avatar, DateO born_date, String DNI, String email, String movile, String name, String lastname, String password, String state, String user, int activity){
		//(String avatar, DateO birth_date, String DNI, String email, String movile, String name, String lastname, String password, String state, String user)
		super( avatar, born_date, DNI, email, movile, name, lastname, password, state, user );
		this.setActivity(activity);
		this.setKarma(calculateKarma());
		super.setBenefit(calculateBenefit());
		
	}
	
	/**
	* <<<----------getters--------->>>
	*/
	public int getActivity() {
		return activity;
	}

	public String getKarma() {
		return Karma;
	}

	/**
	 * <<<----------setters--------->>>
	 * */
	
	public void setActivity(int activity) {
		this.activity = activity;
		this.setKarma(this.calculateKarma());
		super.setBenefit(this.calculateBenefit());
	}

	public void setKarma(String karma) {
		this.Karma = karma;
		super.setBenefit(this.calculateBenefit());
	}

	/**
	* <<<----------toString--------->>>
	 * */
	
	/**String toString()-->return all the values of an RegisteredU Object*/
	@Override
	public String toString() {
		StringBuffer outline = new StringBuffer();
		try {
			outline.append("Name: "+ this.getName()+"\n");
			outline.append("Last name: "+ this.getLastname()+"\n");
			outline.append("Age: " + format.formAge(this.getAge())+"\n");
			outline.append("DNI: " + this.getDni() +"\n");
			outline.append("User name: "+ this.getUser()+"\n");
			outline.append("Password: "+ this.getPassword()+"\n");
			outline.append("Email: " + this.getEmail()+"\n");
			outline.append("Phone: "+ format.formPhone(this.getMovile())+"\n");
			
			outline.append("Avataring: "+ this.getAvataring()+"\n");
			outline.append("Birthday date: "+ format.formDate(this.getBorn_date().getSdate())+"\n");
			outline.append("State: "+ this.getState()+"\n");
			outline.append("Points: "+ this.getBenefit()+"\n");
			outline.append("Activity: "+ this.getActivity()+"\n");
			outline.append("Karma: "+ this.getKarma()+"\n");		
		} catch (Exception e) {
			try {
				outline.append( "Primary key (DNI) -> "+ this.getDni());
			} catch (Exception e2) {
				outline.append("EMPTY");
			}
		}
		
		return outline.toString();
	}
	
	/**String toStringPK()-->return primary key value of an RegisteredU Object*/
	@Override
	public String toStringPK(){
		return "Primary key (DNI) -> " + format.formDni(super.getDni());
	}
	
	/**String toString( int choice) --> return an atribute of the Registered User class chosen by the user 
	 * 0->Age
	 * 1->avataring
	 * 2->born_date
	 * 3->DNI
	 * 4->email
	 * 5->movile
	 * 6->name
	 * 7->lastname
	 * 8->password
	 * 9->state
	 * 10->User
	 * 
	 * 11->activity
	 * 12->karma
	 *  */
	@Override
	public String toString( int choice ){
		String outline = "";
		
		if( choice<11){
			super.toString(choice);
		}
		switch ( choice ){
		case 11:
			outline = Integer.toString(getActivity());
			break;
		case 12:
			outline = this.getKarma();
			break;
		case 13:
			outline = Integer.toString((int)this.getBenefit());
		}
		
		return outline;
	}
	/**calculateBenefit function that re-calculates the points benefit of Reg User
	 * 
	 * @return float benefit
	 */
	@Override
	public float calculateBenefit(){
		float benefit = 0.0f;
		String Karma=this.getKarma();
		switch (Karma) {
		case "normal":
			benefit = 1.25f;
			break;
		case "high":
			benefit = 1.5f;
			break;
		case "Buda":
			benefit = 2;
			break;
		default:
			benefit = 1;
			break;
		}
		
		benefit*= this.getActivity();
		
		return benefit; 
	}
	/**calculateKarma function that re-calculates karma
	 * 
	 * @return String karma
	 */
	public String calculateKarma(){
		String optk [] = {"low", "normal", "high", "Buda"};
		String Karma = "";
		
		if(this.getActivity() < 10)
			Karma = optk[1];
		else if(this.getActivity() < 100)
			Karma = optk[2];	
		else
			Karma = optk[2];
		
		return Karma;
	}
}
