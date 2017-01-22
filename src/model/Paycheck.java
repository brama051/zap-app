package model;


public class Paycheck {
	private int id;
	private String firstName;
	private String lastName;
	private int month;
	private float totalHours;
	private float pricePerHour;
	/*total */
	
	public Paycheck(){
		this.id = -1;
		this.firstName = "";
		this.lastName = "";
		this.month = 0;
		this.totalHours = 0;
		this.pricePerHour = 0;
	}
	
	public Paycheck(int id, String firstName, String lastName, int month, float totalHours, float pricePerHour){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.month = month;
		this.totalHours = totalHours;
		this.pricePerHour = pricePerHour;
	}
	
	public float getTotal(){
		return this.pricePerHour * this.totalHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public float getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(float totalHours) {
		this.totalHours = totalHours;
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
}
