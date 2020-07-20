package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintLogFileAndReport {
	
	public static String auditLog = "";
	public static String logFile = "Log.txt";
	public static String salesReportFile = "SalesReport.txt";
	
	
	public static String auditLog(String typeOfTransaction, double moneyType, double customerBalance ) {
		
		float balanceAmountFloat = (float)customerBalance;
		String balanceAmountString = String.format("%.02f", balanceAmountFloat);
		float moneyTypeFloat = (float)moneyType;
		String moneyTypeString = String.format("%.02f", moneyTypeFloat);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); 
		LocalDateTime now = LocalDateTime.now(); 
		String printAuditLog = dtf.format(now) +" "+ typeOfTransaction + moneyTypeString + " $" + balanceAmountString + '\n';
		
		return auditLog+=printAuditLog;
		
	}
	
	
	//Prints out the auditLog string to "Log.txt"
	public static void printToLogFile(String auditLog) {
		File newDesFile = new File(logFile);
		PrintWriter writer;
		try {
			writer = new PrintWriter(newDesFile);
			writer.println(auditLog);
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Prints Sales Report
	public static void printToSalesReport(double totalVendingMachineRevenue) {
		File newDesFile = new File(salesReportFile);
		PrintWriter writer;
		try {
			writer = new PrintWriter(newDesFile);
			for (String item : VendingMachine.totalItemSoldMap.keySet()) {
				writer.println(item + "|" + VendingMachine.totalItemSoldMap.get(item));
			}
			
			String totalVendingMachineRevenueString = String.format("%.02f", (float)totalVendingMachineRevenue);
			
			writer.println("\n**TOTAL SALES** $" + totalVendingMachineRevenueString);
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
