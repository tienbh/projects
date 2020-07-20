package com.techelevator;

public class UpdateBalances {
	public static double customerBalance=0.0;
	public static double customerTotalPurchased=0.0;
	public static double totalVendingMachineRevenue=0.0;
	
	public static void updateBalances(double priceOfItem) {
		customerBalance -= priceOfItem;
		customerTotalPurchased += priceOfItem;
		totalVendingMachineRevenue += priceOfItem;
	}
	
	public static void resetBalancesToZeros() {
		customerBalance = 0.0;
		customerTotalPurchased = 0.0;
		//totalVendingMachineRevenue = 0.0;
	}
	
	public static String returnUpdateBalancesInCurrencyFormat(double updateBalance) {
		
		float balanceAmountFloat = (float)updateBalance;
		String balanceAmountString = String.format("%.02f", balanceAmountFloat);
		return balanceAmountString;
		
	}
	
}
