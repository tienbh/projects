package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;


public class backup_VendingMachineCLI {

	//variable declarations 
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase\n    1)Feed Money\n    2)Select\n    3)Finish Transaction";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_UPDATE_INVENTORY = "Update Inventory";
	private static final String MAIN_MENU_OPTION_SUBMENU1 = " Feed Money";
	private static final String MAIN_MENU_OPTION_SUBMENU2 = " Select Product";
	private static final String MAIN_MENU_OPTION_SUBMENU3 = " Finish Transaction";
	private static String itemToBuy =" ";
	private static String fundBalance = " ";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,MAIN_MENU_OPTION_UPDATE_INVENTORY};
	
	
	private Menu menu;

	public backup_VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}


	public void run() {
		//scanner instantiation
		Scanner commandLineScanner = new Scanner(System.in);
		//object for vending machine class
		backup_VendingMachine firstVendingMachine = new backup_VendingMachine();
// local variables declation that will be used locally
		double balanceAmount = 0.0;
		double totalPurchased = 0.0;
		//used to print the log audit file
		String stringLog ="";
		

		firstVendingMachine.populateMapsInventory();
		
		while (true) {
			//call the main menu
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			//display menu options

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				firstVendingMachine.displayVendingMachine();

			} 
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				//display sub-menu options

				String[] purchaseOptions = { MAIN_MENU_OPTION_SUBMENU1, MAIN_MENU_OPTION_SUBMENU2, MAIN_MENU_OPTION_SUBMENU3 };

				
				while(true) {
					//confirm the user input for menu choise is correct
					String purchaseOptionsString = (String) menu.getChoiceFromOptions(purchaseOptions);
					//variable to be used to print the balance
					float balanceAmountFloat = (float)balanceAmount;
					//display the balance with two decimal point format
					String balanceAmountString = String.format("%.02f", balanceAmountFloat);				
					System.out.println("\nYour balance amount is: $" + balanceAmountString);
					//if the customer choose to feed money for a purchase
					if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU1)) {						
						System.out.println("Please enter amount you want to deposit >>>");

						fundBalance = commandLineScanner.nextLine();
						
						///This loop and exception is for when the customer input a INVALID amount of money...
						//like input a string instead of a valid number. It keeps asking until the customer input correct number format amount.
						//String exitProgram;
						//instantiate the loop
						int i = -1;
						while(i<0) {
							//Exit program option
							String exitProgram = "";
							try {
							double amountDeposit = Double.parseDouble(fundBalance);	
							//checking the deposit and making sure is not less than zero							
							if (amountDeposit <= 0) {
								System.out.println("Please enter an amount greater or equal than zero, or do you want to exit? (y/n) >>>");								
								exitProgram= commandLineScanner.nextLine();
								//ask the cutomer to choose yes to exit the program and no to stay and add fund
								if (exitProgram.toLowerCase().equals("y") || exitProgram.toLowerCase().equals("yes")) { i=1; }
								else {amountDeposit = Double.parseDouble(fundBalance);}								
							}
							
							else {
								//adding the amount deposited to the current balance
								balanceAmount += amountDeposit;									
								balanceAmountFloat = (float)balanceAmount;
								balanceAmountString = String.format("%.02f", balanceAmountFloat);
								//date and time captured from the system running the program and formatting
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); 
								LocalDateTime now = LocalDateTime.now(); 
								stringLog += dtf.format(now) + " FEED MONEY: $" + amountDeposit + " $" + balanceAmountString + '\n';
								System.out.println("Your balance amount is: $" + balanceAmountString);
								//to exit out of the loop
								i=1;
							}
							
							}
							//catch error using NumberFormatException
							catch(NumberFormatException e) {
								System.out.println("Please enter a VALID NUMBER amount you want to deposit, or do you want to exit? (y/n) >>>");
								itemToBuy = commandLineScanner.nextLine();
								if (itemToBuy.toLowerCase().equals("y") || itemToBuy.toLowerCase().equals("yes")) { i=1; }
							}							
						}					
					}
					
					//customer chose submenu option 2
					else if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU2)) {
						
						if (balanceAmount > 0) {
						firstVendingMachine.displayVendingMachine();
						System.out.println("Please choose an item to buy >>>");
						itemToBuy = commandLineScanner.nextLine().toUpperCase();

						// check if item exists in Vending Machine
						if (!firstVendingMachine.itemInventoryMap.containsKey(itemToBuy)) {
							System.out.println("\nThe item you chose is not in the list");
							//if the item is in the hashmap 
						} else if(firstVendingMachine.getInventory(itemToBuy) > -1) {
							//checking if they have enough to make the purchace
							if(balanceAmount<=0.0 || balanceAmount-firstVendingMachine.purchaseItem(itemToBuy)<0.0){
								System.out.println("\nYour balance amount is not sufficient to make a purchase\n");							
							} 
							// check if the item is SOLD				
							if (firstVendingMachine.getInventory(itemToBuy.toUpperCase())==0) {
								System.out.println("\nitem is SOLD OUT!\n");	
							}

							// check if the customer has enough money to make the purchase and the item to buy exist in the inventory
							if (balanceAmount-firstVendingMachine.purchaseItem(itemToBuy.toUpperCase())>=0 && firstVendingMachine.getInventory(itemToBuy.toUpperCase())>0){
								//update the numberOfAvailable map of items
								firstVendingMachine.numberOfItemAvailable(itemToBuy.toUpperCase()); 
								//decrement the balance of the customer
								balanceAmount = balanceAmount - firstVendingMachine.purchaseItem(itemToBuy.toUpperCase());
								//amount purchased 
								totalPurchased += firstVendingMachine.purchaseItem(itemToBuy.toUpperCase());								
								balanceAmountFloat = (float)balanceAmount;
								balanceAmountString = String.format("%.02f", balanceAmountFloat);								
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); 
								LocalDateTime now = LocalDateTime.now();  
								stringLog += dtf.format(now) + " " + firstVendingMachine.itemNameMap.get(itemToBuy) + " " + itemToBuy +" $" + firstVendingMachine.itemPriceMap.get(itemToBuy) + " $" + balanceAmountString + '\n'; 
								//print the sound of the item
								System.out.println(firstVendingMachine.getItemPurchaseSounds(itemToBuy));								
							}
							
							balanceAmountFloat = (float)balanceAmount;
							balanceAmountString = String.format("%.02f", balanceAmountFloat);
							
							float totalPurchasedFloat = (float)totalPurchased;
							String totalPurchasedString = String.format("%.02f", totalPurchasedFloat);
							
							System.out.println("Total Purchased: $" + totalPurchasedString);
							System.out.println("Your balance amount is: $" + balanceAmountString);
						}
						
						} else { System.out.println("\nPlease insert money.\n");}
					
					
			}
					else if (purchaseOptionsString.equals(MAIN_MENU_OPTION_SUBMENU3)) {
						
						//calculate the difference after purchase
						GiveChangeToCustomer giveChange = new GiveChangeToCustomer(balanceAmount);
						giveChange.getDollarAmount();
						giveChange.getCentsAmmount(); 	
						//display the change in denomination
						System.out.println("Your Change is: " + giveChange.getDollarAmount() + " Dollar(s), " + giveChange.printOutChangeAmount());
						System.out.println("Your Current Balance is $0.00");
						balanceAmountFloat = (float)balanceAmount;
						balanceAmountString = String.format("%.02f", balanceAmountFloat);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); 
						LocalDateTime now = LocalDateTime.now(); 
						stringLog += dtf.format(now) + " GIVE CHANGE: $" + balanceAmountString + " $0.00\n";
						
						//WRITING OUT ALL THE TRANSACTIONS THE CUSTOMER MADE TO THE log.txt file under the "java" folder
						File newDesFile = new File("Log.txt");
						PrintWriter writer;
						try {
							writer = new PrintWriter(newDesFile);
							writer.println(stringLog);
							writer.close();
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						////////////////////////////////////////////////////////////////////////////////////////
						
						
						stringLog = ""; //reset the logs of the transactions the customer made when customer exits out of 2)Purchase menu
						balanceAmount = 0;//Reset customer's balance amount to zero when customer exit out of 2)Purchase menu
						totalPurchased = 0;//Reset total purchase to zero when customer exit out of 2)Purchase menu
						
						break;
					}
					
				}

			} 
			//customer chose to end the transaction
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you!  Have a great day.");
				break;
			} 
			//owner update the vending machine inventory
			//int codeInpute = commandLineScanner.nextInt()
			else if (choice.equals(MAIN_MENU_OPTION_UPDATE_INVENTORY)){
				firstVendingMachine.populateMapsInventory();
				firstVendingMachine.displayVendingMachine();
				System.out.println("\nThe machine has been filled!");
			}
			
			
		}
		//close transaction
		commandLineScanner.close();
	}
	

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		backup_VendingMachineCLI cli = new backup_VendingMachineCLI(menu);
		cli.run(); 
	}
}
