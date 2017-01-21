/**
 * 
 */
package model;

/**
 * @author brama
 *
 */
public class Paycheck {
	private int id;
	private String firstName;
	private String lastName;
	private int month;
	private float totalHours;
	private float pricePerHour;
	/*total */
	
	Paycheck(){
		this.id = -1;
		this.firstName = "";
		this.lastName = "";
		this.month = 0;
		this.totalHours = 0;
		this.pricePerHour = 0;
	}
	
	Paycheck(int id, String firstName, String lastName, int month, float totalHours, float pricePerHour){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.month = month;
		this.totalHours = totalHours;
		this.pricePerHour = pricePerHour;
	}
	
	float getTotal(){
		return this.pricePerHour * this.totalHours;
	}
	
}
