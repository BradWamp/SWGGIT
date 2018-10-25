/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bwamp
 */
public class VendingMachineInMemDao implements VendingMachineDao {
    
    private Map<Integer, Item> itemMap = createMap();
    
    public HashMap<Integer, Item> createMap(){
        HashMap<Integer,Item> newMap = new HashMap<>();
        
        Item item = new Item();
        item.setItemNumber(1);
        item.setItem("Snickers");
        item.setPrice(new BigDecimal("1.50"));
        item.setAmount(10);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);
        
        item = new Item();
        item.setItemNumber(2);
        item.setItem("M&M's");
        item.setPrice(new BigDecimal("1.25"));
        item.setAmount(8);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(3);
        item.setItem("Apple");
        item.setPrice(new BigDecimal("1.25"));
        item.setAmount(11);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(4);
        item.setItem("Skittles");
        item.setPrice(new BigDecimal("1.65"));
        item.setAmount(3);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(5);
        item.setItem("Payday");
        item.setPrice(new BigDecimal("1.75"));
        item.setAmount(2);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(6);
        item.setItem("Oreo");
        item.setPrice(new BigDecimal("1.50"));
        item.setAmount(5);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(7);
        item.setItem("Crackers");
        item.setPrice(new BigDecimal("2.35"));
        item.setAmount(4);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(8);
        item.setItem("Cheese");
        item.setPrice(new BigDecimal("2.00"));
        item.setAmount(6);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);

        item = new Item();
        item.setItemNumber(9);
        item.setItem("Banana");
        item.setPrice(new BigDecimal("1.95"));
        item.setAmount(7);
        newMap.put(Integer.valueOf(item.getItemNumber()), item);
        
        return newMap;
  };

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>(itemMap.values());
        return itemList;
    }

    @Override
    public Item getItemById(int itemInt) {
        Item newItem = itemMap.get(itemInt);
        return newItem;
    }

    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getItemNumber(), item);
    }

    @Override
    public Item submitItem(Item paramItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(int paramInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
