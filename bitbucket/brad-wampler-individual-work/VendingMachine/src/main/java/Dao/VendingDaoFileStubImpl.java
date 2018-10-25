/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author J1BDW02
 */
public class VendingDaoFileStubImpl implements VendingDaoFile {
    
    Item onlyItem = new Item();
    ArrayList <Item> itemList = new ArrayList<>();

    public VendingDaoFileStubImpl() {
        onlyItem.setItem("grapes");
        onlyItem.setItemNumber(1);
        onlyItem.setAmount(11);
        onlyItem.setPrice(BigDecimal.ONE);
        
        itemList.add(onlyItem);
    }
    
    @Override
    public ArrayList<Item> displayItems() throws VendingDaoException {
        return itemList;
    }

    @Override
    public Item getItem(int itemNumber) throws VendingDaoException {
        if (itemNumber == onlyItem.getItemNumber()){
            return onlyItem;
        }else {
            return null;
        }
    }

    @Override
    public Item updateInventory(Item newItem) throws VendingDaoException {
        if (newItem.getItemNumber() == onlyItem.getItemNumber()){
            return newItem;
        }else {
            return null;
        }
    }
    
}
