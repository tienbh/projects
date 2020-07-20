package com.techelevator;

public class GiveChangeToCustomer {
	
	private double customerBalance=0.0;
	private int dollarAmount=0;
	private int centsAmount=0;
	
	//Constructor receive the customer's balance
	GiveChangeToCustomer(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	
	//This method converts the exact change amount with the cents to whole integer or dollar amount..
	//so that we can separate the dollar amount from the cent amount, in able for us to give the coins change in..
	//the getCentsAmount method and printOutChangeAmount method
	public int getDollarAmount() {
		
		if(this.customerBalance >= 1.0) {
			this.dollarAmount = (int)(this.customerBalance);
		}
		
		return this.dollarAmount;
		
	}
	
	
	//This method gets the cents part from the customer's total balance amount
	public void getCentsAmmount() {
		
		double centsAmountDouble = 0.0;
		
		if(this.customerBalance - (double)this.dollarAmount > 0.0) {
			centsAmountDouble = 100*(this.customerBalance - (double)this.dollarAmount); //try to convert cents amount to whole number and non-decimal
		}
		
		this.centsAmount = (int)(Math.round(centsAmountDouble)); //convert cents amount to whole rounded integer amount, because we want to make cents amount into nice whole integer numbers instead of decimal double numbers

	}
	
	
	///this method print out the change amount in coins with the smallest amount of coins possible
	public String printOutChangeAmount() {
		
		
		int centsChange = this.centsAmount;
		
		//Find out if the total change in cents has any quarters to give, and how many to give when giving back the change
		int iQuarter = 0;
			while (centsChange >= 25) {
				centsChange -= 25;
				iQuarter++;
			}

		//Find out if the total change in cents has any dime to give, and how many to give when giving back the change
		int iDime = 0;
			while (centsChange >= 10) {
				centsChange -= 10;
				iDime++;
			}

		//Find out if the total change in cents has any nickels to give, and how many to give when giving back the change
		int iNickel = 0;
			while (centsChange >= 5) {
				centsChange -= 5;
				iNickel ++;
			}
		
		//Find out if the total change in cents has any pennies to give, and how many to give when giving back the change
		int iPenny = 0;
			while (centsChange >= 1) {
				centsChange -= 1;
				iPenny++;
			}
		
		//print out the smallest amount of coins possible
		return iQuarter + " Quarter(s), " + iDime + " Dime(s), " + iNickel + " Nickel(s)";
		//return iQuarter + " Quarter(s), " + iDime + " Dime(s), " + iNickel + " Nickel(s), " + iPenny + " Penny/Pennies";
		
	}
	
}
