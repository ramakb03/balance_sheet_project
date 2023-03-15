package myBalanceSheetProject;

public class Transactions {

	private String transactionNature;
	private int transactionNumber;
	private double amountPaid;
	private int quantityOrdered;
	private double cost;
	private int discount;
	
	//creates a new Transactions object when transaction involved is a Payment
	public Transactions(String transactionNature,
			int transactionNumber, double amountPaid, int discount) {

		
		this.transactionNature = transactionNature;
		this.transactionNumber = transactionNumber;
		this.amountPaid = amountPaid;
		this.discount = discount;
	}
	
	//creates a new Transactions object when transaction involved is an Order
	public Transactions(String transactionNature,
			int transactionNumber, int quantityOrdered, double cost, int discount) {
	
		
		this.transactionNature = transactionNature;
		this.transactionNumber = transactionNumber;
		this.quantityOrdered = quantityOrdered;
		this.cost = cost;
		this.discount = discount;
	}
	
	//getters 
	
	public String getTransactionNature() {
		return transactionNature;
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public double getCost() {
		return cost;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public int getDiscount () {
		return discount;
	}
	
	/*
	 * method receives one double prevBal,
	 * and calculates and returns the current balance,
	 * based on the transaction type, "O" or "P"
	 */
	public double getCurrentBalance(double prevBal) {
		
		if(transactionNature.equals("O")) {
			
			if(discount > 0) {
			
				return prevBal + (((quantityOrdered * cost)) - (quantityOrdered * cost * (discount / 100.0)));
			}
			else {
					return prevBal + (quantityOrdered * cost);
			}
			}
		
		else {
			
			if(discount > 0) {
			
			return prevBal - amountPaid - (amountPaid * (discount / 100.0));
		}
			else {
				
			return prevBal - amountPaid;
			}
	}
	}
	
//returns a string representation of the Transaction object 
	public String toString() {																	
			
		if(transactionNature.equals("O")) {
			return "Transaction number: " + transactionNumber 
				+ " Number of items ordered: " + quantityOrdered + " Cost per item: $" + cost + " Discount applied: "
				+ discount + "%";
		}
		
			return "Transaction number: " + transactionNumber + " Payment amount: $" + amountPaid + " Discount applied: "
			+ discount + "%";

	}
	}
