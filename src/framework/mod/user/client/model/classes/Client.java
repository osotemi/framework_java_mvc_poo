/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.user.client.model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.clss.DateO;
import framework.mod.user.model.clss.User;
import framework.tools.format;
import java.io.Serializable;

/**					CLASS Client
* 
* Class user java file contains the definition of the son class Client: the client object and his methods 
* -getters, setters, constructors and toString 
* @author OscarOtero
* @version 2.1
*/
@SuppressWarnings("unused")
@XStreamAlias("Client")
public class Client extends User implements Serializable{
	/**----------------------------------
	 * Definition of Client object
	 * --------------------------------*/
	@XStreamAlias("antiqueness")
	private int antiqueness;
	@XStreamAlias("client_type")
	private String client_type;//chrome sliver gold platinium
	@XStreamAlias("premium")
	private boolean premium;
	@XStreamAlias("register_date")
	private DateO register_date;
	@XStreamAlias("shop_acount")
	private float shop_acount;//compras
	
	/**----------------------------------
	 * Public methods of the Client class
	 * --------------------------------*/

	/**
	 * <<<----------constructors--------->>>
	 * */
	
	/**empty constructor-->Generate an empty Client object*/
	public Client(){
		super();
	}
	
	/**Primary key constructor-->Generate an Client object with the primary key*/
	public Client( String dni ){
		super(dni);
		
	}
	
	/**constructor choice --> generate an object with one value choosed by the user
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
	 *  
	 * 12->client_type_
	 * 13->premium_
	 * 14->register_date_
	 * 15->account_
	 *  */
	public Client( Object value, int choice ){
		super(value, choice);
		
		switch( choice ){
		case 11:
			this.setClient_type((String)value);
			break;
		case 12:
			this.setPremium((boolean)(value));
			break;
		case 13:
			this.setRegister_date((DateO)(value));
			break;
		case 14:
			this.setShop_acount((int)( value ));
			break;		
		}
	}
	
	/**full constructor-->Generate an complete Client object*/
	public Client ( String avatar, DateO born_date, String DNI, String email, String movile, String name, String lastname, String password, String state, String user, String clientpe, boolean premium, DateO register_date, float account){
		super( avatar, born_date, DNI, email, movile, name, lastname, password, state, user );
		this.setRegister_date(register_date);
		this.setShop_acount(account);
		this.setClient_type(clientpe);
		this.setPremium(premium);	
	}

	/**
	* <<<----------getters--------->>>
	*/
	
	public int getAntiqueness() {
		return antiqueness;
	}

	public String getClient_type() {
		return client_type;
	}

	public boolean isPremium() {
		return premium;
	}

	public DateO getRegister_date() {
		return register_date;
	}

	public float getShop_acount() {
		return shop_acount;
	}


	/**
	 * <<<----------setters--------->>>
	 * */
	
	public void setAntiqueness(int antiqueness) {
		this.antiqueness = antiqueness;
		super.setBenefit(calculateBenefit());
	}

	public void setClient_type(String client_type) {
		this.client_type = client_type;
		super.setBenefit(calculateBenefit());
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
		super.setBenefit(calculateBenefit());
	}

	public void setRegister_date(DateO register_date) {
		this.register_date = register_date;
		this.setAntiqueness(this.calculateAntiquieness());
	}

	public void setShop_acount(float shop_acount) {
		this.shop_acount = shop_acount;
	}

	/**
	* <<<----------toString--------->>>
	 * */
	
	/**String toString()-->return all the values of an Client Object*/
	@Override
	public String toString(){
		StringBuffer outline = new StringBuffer();
		try {
			outline.append("Antiqueness: "+ format.formMonthAntique(getAntiqueness())+"\n");
			outline.append("Client type"+ this.getClient_type()+"\n");
			outline.append("Premium: "+ this.isPremium()+"\n");
			outline.append("Register Date: "+ format.formDate(this.getRegister_date().getSdate())+"\n");
			outline.append("Shop acount: "+ format.formMoneyIn(this.getShop_acount())+"\n");
		} catch (Exception e) {
			try {
				
				outline.append( "Primary key (DNI) -> "+ this.getDni());
			} catch (Exception e2) {
				outline.append("EMPTY");
			}
		}
		return super.toString() + outline.toString();
	}
	/*public String toString() {
		String outline;
		
		outline = super.toString();
		
		try {
			outline += "antiqueness = " + format.formMonthAntique(getAntiqueness()) + "\nclient type = " + getClient_type() + "\npremium = " + isPremium()
			+ "\nregister date = " + format.formDate(getRegister_date().getSdate()) + "\nshoping acount = " + format.formMoneyEuro(getShop_acount()) +"\n";
	
		} catch (Exception e) {
			
		}	
		return outline;
	}
	
	public String toString(Settings conf) {
		String outline;
		
		outline = super.toString_set();
		
		switch (conf.getLanguage()) {
		case "UK":
			try {
				outline += "Antiqueness = " + format.formMonthAntique(getAntiqueness()) + "\nClient type = " + getClient_type() + "\nPremium = " + isPremium()
				+ "\nRegister date = " + format.formDate(getRegister_date().getSdate(), conf.getFdate()) + "\nShoping acount = " + format.formMoneyOut(getShop_acount(), conf.getCurrency()) +"\n";
		
			} catch (Exception e) {
				
			}	
			break;
		case "ES":
			try {
				outline += "Antiguedad = " + format.formMonthAntique(getAntiqueness()) + "\nTipo de cliente = " + getClient_type() + "\nPremium = " + isPremium()
				+ "\nFecha de registro = " + format.formDate(getRegister_date().getSdate(), conf.getFdate()) + "\nCompras = " + format.formMoneyOut(getShop_acount(), conf.getCurrency()) +"\n";
		
			} catch (Exception e) {
				
			}	
			break;
		case "VLC":
			try {
				outline += "Antiguitat = " + format.formMonthAntique(getAntiqueness()) + "\nTipo de client = " + getClient_type() + "\nPremium = " + isPremium()
				+ "\nData de registre = " + format.formDate(getRegister_date().getSdate(), conf.getFdate()) + "\nCompres = " + format.formMoneyOut(getShop_acount(), conf.getCurrency()) +"\n";
		
			} catch (Exception e) {
				
			}	
			break;
		case "GZ":
			try {
				outline += "Antiguidade = " + format.formMonthAntique(getAntiqueness()) + "\nTipo do cliente = " + getClient_type() + "\nPremium = " + isPremium()
				+ "\nData do rexistro = " + format.formDate(getRegister_date().getSdate(), conf.getFdate()) + "\nCompras = " + format.formMoneyOut(getShop_acount(), conf.getCurrency()) +"\n";
		
			} catch (Exception e) {
				
			}	
			break;
		default:
			break;
		}
		
		
		return outline;
	}
	*/
	/**String toStringPK()-->return primary key value of an Client Object*/
	@Override
	public String toStringPK(){
		return "Primary key (DNI) -> " + format.formDni(super.getDni());
	}
	
	/**String toString( int choice) --> return an atribute of the Client class chosen by the user 
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
	 * 11->Antiquess
	 * 12->Amount
	 * 13->Client type
	 * 14->premium
	 * 15->register date
	 *  */
	@Override
	public String toString( int choice ){
		String outline = "";
		
		if( choice<12){
			outline = super.toString(choice);
		}
		else{
			switch( choice ){
			case 12:
				outline = Integer.toString(getAntiqueness());
				break;
			case 13:
				outline = getClient_type();
				break;
			case 14:
				outline = Boolean.toString(isPremium());
				break;
			case 15:
				outline = format.formDate(getRegister_date().getSdate());
				break;
			case 16:
				outline = format.formMoneyEuro(getShop_acount());
				break;
			}
		}	
		return outline;
	}
	/**calculateantiquieness -> returns the time that the client is registered in months
	 * 
	 * @return int in months
	 */
	public int calculateAntiquieness(){
		int ant=0;
		DateO today = new DateO();
		today.getTodaydate();
		ant= today.diffDates(this.getRegister_date(), 1);
				
		return ant;
	}
	/**calculatebenefit -> returns the benefit that earns the client
	 * 
	 * @return float benefit
	 */
	public float calculateBenefit(){
		float benefit = 0.0f;
		
		if(isPremium()){
			benefit = (getAntiqueness()/10);
			if(!getClient_type().equals(null)){
				switch(getClient_type()){
				case "chrome":
					benefit*= 1.3;
					break;
				case "silver":
					benefit*= 1.5;
					break;
				case "gold":
					benefit*=1.75;
					break;
				case "platinium":
					benefit*=2;
					break;
				}
			}
		}else{
			benefit = (getAntiqueness()/100);
		}
		
		return benefit; 
	}
}