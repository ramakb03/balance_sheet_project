package myBalanceSheetProject;

public class Customer {

	private int idNumber;
	private String name;
	protected double ogBalanceDue;

	//creates a new Customer object
	public Customer(int idNumber, String name, double ogBalanceDue) {
		this.idNumber = idNumber;
		this.name = name;
		this.ogBalanceDue = ogBalanceDue;
	}
	//getters
	
	public int getIDNumber() {
		return idNumber;
	}
	public String getName() {
		return name;
	}
	public double getOGBalanceDue() {
		return ogBalanceDue;
	}
	
	//returns a string representation of the Customer object
	public String toString() {
		return "Customer name = " + name + " ID number = " + idNumber 
				+ "\n" + "\t" + "Previous Balance = $" + ogBalanceDue + "\n";
	}
}
