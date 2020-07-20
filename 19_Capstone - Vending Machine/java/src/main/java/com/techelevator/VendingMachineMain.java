package com.techelevator;

import java.util.Scanner;

import com.techelevator.view.Menu;


public class VendingMachineMain {

	//variable declarations 
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase\n    1)Feed Money\n    2)Select\n    3)Finish Transaction";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_UPDATE_INVENTORY = "Sales Report";
	private static final String MAIN_MENU_OPTION_SUBMENU1 = " Feed Money";
	private static final String MAIN_MENU_OPTION_SUBMENU2 = " Select Product";
	private static final String MAIN_MENU_OPTION_SUBMENU3 = " Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,MAIN_MENU_OPTION_UPDATE_INVENTORY};
	
	
	private Menu menu;

	public VendingMachineMain(Menu menu) {
		this.menu = menu;
	}


	public void run(){

		//Initialize and Start Up the Vending Machine
		VendingMachine startUpVendingMachine = new VendingMachine();
		startUpVendingMachine.getAllItemsIntoAllMaps();
		
		Scanner commandLineScanner = new Scanner(System.in);

		while (true) {
			
			//call the MAIN MENU
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			//1)Display Vending Machine Items...on MAIN MENU
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				startUpVendingMachine.printOutMenuOfItemsAndInventory(); //prints out the menu of all the items and their updated inventory

			} 
			
			
			//Display SUB-MENU options
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				
				String[] purchaseOptions = { MAIN_MENU_OPTION_SUBMENU1, MAIN_MENU_OPTION_SUBMENU2, MAIN_MENU_OPTION_SUBMENU3 };
				
				
				

				///SUBMENU////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///WHILE LOOP FOR SUBMENU: "2) Purchase"/////////////////////////////////////////////////////////////////////////////////////////////
				while(true) {
					//confirm the user input for menu choice is correct
					String purchaseOptionsString = (String) menu.getChoiceFromOptions(purchaseOptions);

					
					// 1)Feed Money/////////////////////////
					if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU1)) {				
						System.out.println("Please enter amount you want to deposit >>>");
						String customerInputMoney = commandLineScanner.nextLine();
						
						//Calling static method here.//check to see if customer input whole dollar money amount and not some strings or negative numbers.
						while(!VendingMachine.customerInputCorrectMoneyAmount(customerInputMoney)) {
							System.out.println("Please enter CORRECT amount you want to deposit, OR do you want to exit? (ENTTER 'Y' or 'y' to exit) >>>");
							customerInputMoney = commandLineScanner.nextLine();
							if(customerInputMoney.equals("Y") || customerInputMoney.equals("y")) {break;}
							VendingMachine.customerInputCorrectMoneyAmount(customerInputMoney);
						}
						
						if(VendingMachine.customerInputCorrectMoneyAmount(customerInputMoney)) {
							UpdateBalances.customerBalance += Double.parseDouble(customerInputMoney);	
							//making logs in the audit log file
							PrintLogFileAndReport.auditLog("FEED MONEY: $", Double.parseDouble(customerInputMoney), UpdateBalances.customerBalance);
							System.out.println("Your Current Balance is: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerBalance));
						}
						
					}
					
					
					
					// 2)Select Product//////////////////////////
					else if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU2)) {
						
						if (UpdateBalances.customerBalance > 0) {
							
							startUpVendingMachine.printOutMenuOfItemsAndInventory(); //prints out the menu of all the items and their updated inventory
							System.out.println("Please enter the item slot you want to purchase >>>");
							String customerInputItemSlot = commandLineScanner.nextLine();
							
							//if customer select correct item slot on the menu then go ahead and let them purchase it
							if(startUpVendingMachine.customerInputCorrectItemSlot(customerInputItemSlot.toUpperCase())) {
								//check further if the customer has enough money in their balance to buy the specific selected item AND if the item slot they selected has enough inventory
								if(startUpVendingMachine.checkIfBalanceAmountEnoughToBuyItem(UpdateBalances.customerBalance, customerInputItemSlot.toUpperCase()) && VendingMachine.itemInventoryMap.get(customerInputItemSlot.toUpperCase())>0) {
									//the customer now buys the selected item, and the inventory for that item is decremented down by 1 in the itemInventory Map.
									VendingMachine.itemInventoryMap.put(customerInputItemSlot.toUpperCase(), VendingMachine.itemInventoryMap.get(customerInputItemSlot.toUpperCase()) - 1);
									//This is for the optional Sales Report. It updates how many a specific item has been sold in the Map.
									VendingMachine.totalItemSoldMap.put(VendingMachine.itemNameMap.get(customerInputItemSlot.toUpperCase()), VendingMachine.totalItemSoldMap.get(VendingMachine.itemNameMap.get(customerInputItemSlot.toUpperCase())) + 1);
									//updates customer balance, how much the total the customer had purchased, and how much the vending machine took in revenue
									UpdateBalances.updateBalances(VendingMachine.itemPriceMap.get(customerInputItemSlot.toUpperCase()));
									//audit log string to record every transaction the customer made (feed in money, buy items)
									PrintLogFileAndReport.auditLog(VendingMachine.itemNameMap.get(customerInputItemSlot.toUpperCase()) + " " + customerInputItemSlot.toUpperCase() + " $", VendingMachine.itemPriceMap.get(customerInputItemSlot.toUpperCase()), UpdateBalances.customerBalance);
									//prints out the sound of the item bought and customer's current updated balance
									System.out.println("\n" + startUpVendingMachine.printItemSound(customerInputItemSlot.toUpperCase()) + "\nYour current balance is: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerBalance) + "\nYour total purchased: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerTotalPurchased));
								}
								//prompt user they don't have enough money to buy the specific item, or ask them to select another item that they have enough money for
								else if(!startUpVendingMachine.checkIfBalanceAmountEnoughToBuyItem(UpdateBalances.customerBalance, customerInputItemSlot.toUpperCase())) {
									System.out.println("You don't have enough money. Please insert more money or select another item.\nYour current balance is: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerBalance));
								}
								//check inside the inventory Map to see if the item has zero inventory, then that item is SOULD OUT!
								else if(VendingMachine.itemInventoryMap.get(customerInputItemSlot.toUpperCase())==0) {
									System.out.println("Item is SOLD OUT!\nYour current balance is: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerBalance) + "\nYour total purchased: $" + UpdateBalances.returnUpdateBalancesInCurrencyFormat(UpdateBalances.customerTotalPurchased));
								}
							}
							//if customer input invalid item slot, then prompt them that it's not a valid item slot on the menu
							else {
								System.out.println("Item is not in the list. Please select again.");
							}
							
						}
						//this is for when user first come in and decided to select to buy an item without even first feed in any amount of money
						else {
							System.out.println("You have a balance of $0.00. Please feed money first before purchasing.");
						}
						
					}
					
					
					
					// 3)Finish Transaction////////////////////////////////
					else if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU3)) {
						//this section gathers and prints out the customer's given by the vending machine
						GiveChangeToCustomer giveChange = new GiveChangeToCustomer(UpdateBalances.customerBalance);
						giveChange.getDollarAmount(); //initiate this method to separate out the dollar amount
						giveChange.getCentsAmmount(); //initiate this method to separate out the cents amount
						System.out.println("Your Change is: " + giveChange.getDollarAmount() + " Dollar(s), " + giveChange.printOutChangeAmount());
						//update or add to the audit log file the change amount give and the customer now has zero money balance
						PrintLogFileAndReport.auditLog("GIVE CHANGE: $", UpdateBalances.customerBalance,0.0);
						//startUpVendingMachine.printToLogFile(auditLog); //print the audit log to the Log.txt file
						PrintLogFileAndReport.printToLogFile(PrintLogFileAndReport.auditLog);				
						//reset customerBalance, their totalPurchased, auditLog to zero; since now they decide to Finish Transaction and get out of Sub-Menu
						UpdateBalances.resetBalancesToZeros();
						PrintLogFileAndReport.auditLog = ""; //reset the audit log string to ""
						break;
					}
					
				}
				///END OF SUBMENU///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
			} 
			
			
			
			
			
			// 3) Exit
			//customer chose to end the transaction
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you!  Have a great day.");
				break;
			} 
			
			// 4)Sales Report
			//owner update the vending machine inventory
			else if (choice.equals(MAIN_MENU_OPTION_UPDATE_INVENTORY)){

				
				System.out.println("\nPlease enter password to print out Sales Report >>>");
				String password = commandLineScanner.nextLine();
				
				//This is a hidden option, so user needs to input correct password (which is "123") in able to print the Sales Report
				if(password.equals("123")) {
					PrintLogFileAndReport.printToSalesReport(UpdateBalances.totalVendingMachineRevenue);
					System.out.println("\nTHE SALES REPORT HAS BEEN PRINTED!");
					
				}
				else {
					System.out.println("\nWRONG PASSWORD! Please choose Option 4 again and re-enter password if want to print out Sales Report.");
				}
				
			}
			
		}
		

		commandLineScanner.close();
	}
	

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineMain cli = new VendingMachineMain(menu);
		cli.run(); 
	}
}
