package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class backup_VendingMachine {
	
	//creating variables
	private String nameOfFileString;
	private File nameofFile;
	private String lineInFile;
	protected String nameOfItem;
	protected double priceOfItem;
	protected String itemCategory;
	protected String location;
	protected Map<String, Double> itemPriceMap = new LinkedHashMap<String, Double>();
	protected Map<String, String> itemSoundMap = new LinkedHashMap<String, String>();
	public Map<String, Integer> itemInventoryMap = new LinkedHashMap<String, Integer>();
	protected Map<String, String> itemNameMap = new LinkedHashMap<String, String>();
	protected Map<String, String> itemPurchaseSounds = new LinkedHashMap<String, String>();
	private Scanner inputScanner;
	private Scanner readFileScanner;
	private String[] arrayForVendingMachineSetUp;
	
	
	//method to get the sound of the item chosen
	public String getItemPurchaseSounds(String item) { 
		String category = itemSoundMap.get(item);
		return itemPurchaseSounds.get(category); 
	}

	
	public int getInventory(String location) { return itemInventoryMap.get(location); }


	public void populateMapsInventory (){
		//five item per product in the vending machine
		int itemAmount = 5;
		nameofFile = new File("VendingMachine.txt");
		try {
			readFileScanner = new Scanner(nameofFile);
			while(readFileScanner.hasNextLine()) {
				lineInFile = readFileScanner.nextLine();
				//reading the file and splitting ever
				arrayForVendingMachineSetUp = lineInFile.split("\\|");
					//populate the of items inventory (item location and number of items)
					itemInventoryMap.put(arrayForVendingMachineSetUp[0], itemAmount);
					//populate the item price (location and price)
					itemPriceMap.put(arrayForVendingMachineSetUp[0], Double.parseDouble(arrayForVendingMachineSetUp[2]));
					//populate item sound (item location and item type)
					itemSoundMap.put(arrayForVendingMachineSetUp[0], arrayForVendingMachineSetUp[3]);
					//populate item names (item location and item name)
					itemNameMap.put(arrayForVendingMachineSetUp[0], arrayForVendingMachineSetUp[1]);
					
			}
			//assign sound to items
			for(String item: itemSoundMap.keySet()) {
				if (itemSoundMap.get(item).equals("Chip")) itemPurchaseSounds.put(itemSoundMap.get(item), "\nCrunch Crunch,  Yum!\n");
				else if (itemSoundMap.get(item).equals("Candy")) itemPurchaseSounds.put(itemSoundMap.get(item), "\nMunch Munch, Yum!\n");
				else if (itemSoundMap.get(item).equals("Gum")) itemPurchaseSounds.put(itemSoundMap.get(item), "\nChew Chew, Yum!\n");
				else if (itemSoundMap.get(item).equals("Drink")) itemPurchaseSounds.put(itemSoundMap.get(item), "\nGlug Glug, Yum!\n");
			}
			
			
		}
		catch(FileNotFoundException e) { System.out.println("Something went wrong.");	}
		finally { 
			readFileScanner.close(); 
		}	
	}
	//method to display items
	public void displayVendingMachine() {
				for (String item : itemInventoryMap.keySet()) {
					// print SOLD OUT if item doesn't exist
					if (itemInventoryMap.get(item)==0) {System.out.println(item+ " " +itemNameMap.get(item)+ " " + "SOLD OUT"); }
					else {
					System.out.println(item+ " " +itemNameMap.get(item)+ " " +itemPriceMap.get(item) + "---" + itemInventoryMap.get(item) + " item(s) available");
					}
				}
		}
	
	


	public int numberOfItemAvailable (String nameOfProduct ){
		int result = 0;
		if (itemInventoryMap.get(nameOfProduct)==0){

		}else if(itemInventoryMap.get(nameOfProduct)>0){
			result = itemInventoryMap.put(nameOfProduct, itemInventoryMap.get(nameOfProduct) - 1);
		}
	return result;	
	}

	
	
	
	public double purchaseItem (String item){
		
		double priceOfItem = itemPriceMap.get(item);
		return priceOfItem;
	}
	
	
	
	//Method for getting the map in VendingMachineCLI to know how many items are left in the inventory
	public Map<String, Integer> getItemInventoryMap (){
		return this.itemInventoryMap;
	}
	
	
	
}