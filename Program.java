package myBalanceSheetProject;
import java.util.Scanner;
import java.io.*;

/*
 * Program takes input from two input files:
 * masterfile.txt, 
 * which stores the information about a Customer, including ID number, name, and balance,
 * which are all printed to console
 * as well as transactionFile.txt, 
 * which stores in transactions for each customer,
 * which are also printed to console.
 * Program keeps track of the running balance for each customer and prints that out as well.
 * It throws an UnregisteredCustomerException if an ID number from transactionFile.txt does not match any ID number from masterFile.txt.
 */
public class Program {
	
	public static void main(String[] args) throws Exception {
		
		Scanner transactionFile = new Scanner(new File("transactionFile.txt"));
		Scanner masterFile = new Scanner(new File("masterFile.txt"));
		
		int idNum, 
		transactionNumber, 
		numItems, 
		discount, 
		prevID = 0000, 
		masterID = 0000;
		
		String name, 
		transactionNature;
		
		double bal = 0, 
				cost, 
				amountPaid;
		
		Transactions t;
		
		
		while(transactionFile.hasNext()) {
			
			idNum = transactionFile.nextInt();
			
			while(masterFile.hasNext()) {
				
				if(idNum == prevID) {
					//if id number doesn't change, read in following transactions
					break;
				}
				masterID = masterFile.nextInt();
				
				if(idNum == masterID) {
					
					if((idNum != 0001)) {
						
						System.out.println("\t" + "Current Balance = $" + bal);
						System.out.println();
					}
					
					name = masterFile.next();
					bal = masterFile.nextDouble();
					System.out.println(new Customer(idNum, name, bal)); 
					
					break;
				}
				else {
					//if idNum doesn't match current masterID
				masterFile.nextLine();
				masterFile.nextLine();
				masterFile.nextLine();
				}
			}
			if(idNum != masterID) {
				throw new UnregisteredCustomerException(idNum);
			}
			transactionNumber = transactionFile.nextInt();
			transactionNature = transactionFile.next();
					
			if(transactionNature.equals("O")) {
						
				numItems = transactionFile.nextInt();
				cost = transactionFile.nextDouble();
				discount = transactionFile.nextInt();
						
				t = new Transactions(transactionNature, transactionNumber, numItems, cost, discount);
			}
			else {
						
				amountPaid = transactionFile.nextDouble();
				discount = transactionFile.nextInt();
						
				t = new Transactions(transactionNature, transactionNumber, amountPaid, discount);
			}
			
			System.out.println(t);
		
			double runningBal = 0; //keeps track of running balance for customer
			
			runningBal += t.getCurrentBalance(bal);
			bal = runningBal;
			
			prevID = idNum;
				
		}
		System.out.print("\t" + "Current Balance = $" + bal);
	}
}