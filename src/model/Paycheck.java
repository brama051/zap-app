package model;

/**
 * 
 * Template class that will be a template for the ArrayList paycheckList attibute 
 * from the controller.PaycheckController class
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
	
	/**
	 * An empty constructor
	 */
	public Paycheck(){
		this.id = -1;
		this.firstName = "";
		this.lastName = "";
		this.month = 0;
		this.totalHours = 0;
		this.pricePerHour = 0;
	}
	
	/**
	 * A setter constructor
	 */
	public Paycheck(int id, String firstName, String lastName, int month, float totalHours, float pricePerHour){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.month = month;
		this.totalHours = totalHours;
		this.pricePerHour = pricePerHour;
	}
	
	/**
	 * Getter method that gets a calculated value from the existing attributes 
	 */
	public float getTotal(){
		return this.pricePerHour * this.totalHours;
	}

	/**
	 * id attribute getter
	 */
	public int getId() {
		return id;
	}

	/**
	 * id attribute setter
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * firstName attribute getter
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * firstName attribute setter
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * lastName attribute getter
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * lastName attribute setter
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * month attribute getter
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * month attribute setter
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * totalHours attribute getter
	 */
	public float getTotalHours() {
		return totalHours;
	}

	/**
	 * totalHours attribute setter
	 */
	public void setTotalHours(float totalHours) {
		this.totalHours = totalHours;
	}

	/**
	 * pricePerHour attribute getter
	 */
	public float getPricePerHour() {
		return pricePerHour;
	}

	/**
	 * pricePerHour attribute setter
	 */
	public void setPricePerHour(float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
}
