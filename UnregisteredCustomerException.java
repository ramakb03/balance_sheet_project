package myBalanceSheetProject;

public class UnregisteredCustomerException extends Exception {

	private int customerNumber;
	
	public UnregisteredCustomerException(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public String getMessage() {
		return "Error. Customer number " + customerNumber + " is not associated with any customers of this company.";
	}
}
