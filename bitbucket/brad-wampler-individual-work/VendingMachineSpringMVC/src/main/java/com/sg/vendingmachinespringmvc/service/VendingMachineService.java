/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.controller.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.controller.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author bwamp
 */
public interface VendingMachineService {
    
    public void addUserMoney(String money);
    public String getUserMoney();
    public void calculateChange(BigDecimal price);
    public String returnChange();
    public void clearVariables();
    public void createItem(Item item);
    public Item returnItem();
    public Item vendItem (Item item) throws InsufficientFundsException, NoItemInventoryException;
    public List getAllItems();
    public Item getItemById(int intNumber);
    public void updateItem(Item item);
    public void createMessage(String message);
    public String displayMessage();
    public void clearMessages();
    
}
