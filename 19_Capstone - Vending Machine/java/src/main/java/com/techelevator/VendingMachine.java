package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	public static Map<String, String> itemNameMap = new LinkedHashMap<String, String>();
	public static Map<String, Double> itemPriceMap = new LinkedHashMap<String, Double>();
	public static Map<String, String> itemSoundMap = new LinkedHashMap<String, String>();
	public static Map<String, Integer> itemInventoryMap = new LinkedHashMap<String, Integer>();
	public static Map<String, Integer> totalItemSoldMap = new LinkedHashMap<String, Integer>();
	private Scanner readFileScanner;
	private Integer numberOfItemsAvailableToStart = 5;
	private Integer totalItemSold = 0;

	
	//Method for getting and organizing all items into different maps
	public void getAllItemsIntoAllMaps () {
		
		File nameOfFile = new File("VendingMachine.txt");
		
		try {
			readFileScanner = new Scanner(nameOfFile);
			while(readFileScanner.hasNextLine()) {
				String lineInFile = readFileScanner.nextLine();
				String[] arrayForVendingMachineSetUp = lineInFile.split("\\|");
				
				itemInventoryMap.put(arrayForVendingMachineSetUp[0], numberOfItemsAvailableToStart); //This map is for all items listed, which start out as 5 stocked items per item's category
				itemNameMap.put(arrayForVendingMachineSetUp[0], arrayForVendingMachineSetUp[1]);
				itemPriceMap.put(arrayForVendingMachineSetUp[0], Double.parseDouble(arrayForVendingMachineSetUp[2]));
				itemSoundMap.put(arrayForVendingMachineSetUp[0], arrayForVendingMachineSetUp[3]);
				totalItemSoldMap.put(arrayForVendingMachineSetUp[1], totalItemSold);
				
			}
			
		}
		catch(FileNotFoundException e) { System.out.println("Something went wrong. Check your input file.");	}
		finally { 
			readFileScanner.close(); 
		}	
		
	}
	
	
	
	//Method for printing out Menu List when customer request to do so
	public void printOutMenuOfItemsAndInventory() {
		for (String item : itemInventoryMap.keySet()) {
			if(itemInventoryMap.get(item)>0) {
				System.out.println(item+ " " +itemNameMap.get(item)+ " " +itemPriceMap.get(item) + " " + itemSoundMap.get(item) + "---" + itemInventoryMap.get(item) + " item(s) available");
			}
			else {
				System.out.println(item+ " " +itemNameMap.get(item)+ " " +itemPriceMap.get(item) + " " + itemSoundMap.get(item) + "---ITEM SOLD OUT!");
			}
		}
		
	}
	
	
	
	//Check to see if customer input correct whole number money amount and not some characters or negative numbers
	public static boolean customerInputCorrectMoneyAmount(String customerInputMoney) {
				
			try {
				double amountDeposit = Double.parseDouble(customerInputMoney);	
				
				//check to see that customer need to insert/deposit whole dollar amount and amount needs to be positive & not negative
				if(amountDeposit % 1 == 0.0 && amountDeposit > 0.0) {
					return true;
				}
				else {
					return false;
				}
			}
			catch (NumberFormatException e){
				return false;
			}
	}
	
	
	
	//Check to see if customer input correct Item Slot in the vending machine
	public boolean customerInputCorrectItemSlot(String customerInputItemSlot) {
		if(itemPriceMap.containsKey(customerInputItemSlot)) {
			return true;
		}
	
		return false;
		
	}
	
	
	//Check to see if customer has enough money in their current balance to buy the Item Slot they selected
	public boolean checkIfBalanceAmountEnoughToBuyItem(double customerBalance, String customerInputItemSlot) {
		if(customerBalance >= itemPriceMap.get(customerInputItemSlot)) {
			return true;
		}
	
		return false;
	}
	
	
	
	//This method updates the inventory of the item (by decrementing the map item number down by 1) when the customer buys that item
	public void updateInventoryOfItemBeingBought(String customerInputItemSlot) {

		itemInventoryMap.put(customerInputItemSlot, itemInventoryMap.get(customerInputItemSlot) - 1);

	}
	
	
	
	
	//Print out the sound of the item being bought
	public String printItemSound (String customerInputItemSlot) {

		String ItemCategoryType = itemSoundMap.get(customerInputItemSlot);
		
		//Polymorphism Code: calling the interfaces for each category of item to make the appropriate sound
		ItemsSoundInterface chipMakeSound = new ChipSound();
		ItemsSoundInterface candyMakeSound = new CandySound();
		ItemsSoundInterface drinkMakeSound = new DrinkSound();
		ItemsSoundInterface gumMakeSound = new GumSound();
		
		if(ItemCategoryType.equals("Chip")) {
			return chipMakeSound.makeSound();
		}
		else if(ItemCategoryType.equals("Candy")) {
			return candyMakeSound.makeSound();
		}
		else if(ItemCategoryType.equals("Drink")) {
			return drinkMakeSound.makeSound();
		}
		else if(ItemCategoryType.equals("Gum")) {
			return gumMakeSound.makeSound();
		}
		else {
			return "No Item Type Found!";
		}
		
		
	}
	

	
}
