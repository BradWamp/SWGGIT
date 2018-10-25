/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author j1bdw02
 */
public class VendingDaoFileImpl implements VendingDaoFile {
    
    public static final String VENDING_FILE = "itemTestFile.txt";
    public static final String DELIMITER = "::";
    
    HashMap <Integer, Item> itemMap = new HashMap<>();
    
    @Override
    public List<Item> displayItems() throws VendingDaoException {
        loadItems();
        return new ArrayList <Item> (itemMap.values());
    }
    
    @Override
    public Item getItem (int itemNumber) throws VendingDaoException{
        loadItems();
        Item serviceItem = itemMap.get(itemNumber);
        return serviceItem;
    }
        
    public void loadItems() throws VendingDaoException{
        Scanner scanner;
	String currentLine;
        String[] currentTokens;
	try {
	    scanner = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
	} catch (FileNotFoundException e) {
	    throw new VendingDaoException("load failed", e);
	}
        
        while (scanner.hasNextLine()) {
	    currentLine = scanner.nextLine();
	    currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item();
	    
	    currentItem.setItem(currentTokens[0]);
	    currentItem.setPrice(new BigDecimal(currentTokens[1]));
	    currentItem.setAmount(Integer.parseInt(currentTokens[2]));
            currentItem.setItemNumber(Integer.parseInt(currentTokens[3]));
	    
            
	    itemMap.put(currentItem.getItemNumber(), currentItem);
	    }
	    
	    scanner.close(); // is this to save memory?
    }
    
   
    public void writeItems() throws VendingDaoException {
            PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(VENDING_FILE));
	    } catch (IOException e) {
	        throw new VendingDaoException(
	                "Could not save data.", e);
	    }
	    
	    List<Item> itemList = this.displayItems();
	    for (Item currentItem : itemList) {
	        // write the Student object to the file
	        out.println(currentItem.getItem() + DELIMITER
	                + currentItem.getPrice()+ DELIMITER 
	                + currentItem.getAmount() + DELIMITER
                        + currentItem.getItemNumber());   
	        out.flush();
	    }
	    out.close();
	}
    @Override
    public Item updateInventory(Item newItem)throws VendingDaoException{
        itemMap.put(newItem.getItemNumber(), newItem);
        writeItems();
        return newItem;
    }
}

