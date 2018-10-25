/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.controller.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.controller.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bwamp
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;

    @Inject
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    String storedMoney = "0";
    Item storedItem = null;
    Change storedChange = null;
    String message = "";

    @Override
    public void addUserMoney(String money) {
        String totalMoney;
        BigDecimal newMoney = new BigDecimal(money);
        newMoney = newMoney.add(new BigDecimal(storedMoney));
        totalMoney = newMoney.toString();
        this.storedMoney = totalMoney;
    }

    @Override
    public String getUserMoney() {
        return storedMoney;
    }

    @Override
    public void calculateChange(BigDecimal price) {
        BigDecimal userMoney = new BigDecimal(storedMoney);
        BigDecimal change = userMoney.subtract(price);

        BigDecimal quarter = new BigDecimal(".25");
        int countQuarter = 0;
        BigDecimal dime = new BigDecimal(".10");
        int countDime = 0;
        BigDecimal nickel = new BigDecimal(".05");
        int countNickel = 0;
        BigDecimal penny = new BigDecimal(".01");
        int countPenny = 0;

        while (change.compareTo(BigDecimal.ZERO) > 0) {
            if (change.compareTo(quarter) >= 0) {
                while (change.compareTo(quarter) >= 0) {
                    change = change.subtract(quarter);
                    countQuarter++;
                }
            } else if (change.compareTo(dime) >= 0) {
                while (change.compareTo(dime) >= 0) {
                    change = change.subtract(dime);
                    countDime++;
                }
            } else if (change.compareTo(nickel) >= 0) {
                while (change.compareTo(nickel) >= 0) {
                    change = change.subtract(nickel);
                    countNickel++;
                }
            } else if (change.compareTo(penny) >= 0) {
                while (change.compareTo(penny) >= 0) {
                    change = change.subtract(penny);
                    countPenny++;
                }
            }
        }
        Change userChange = new Change();
        userChange.setQuarterCount(countQuarter);
        userChange.setDimeCount(countDime);
        userChange.setNickelCount(countNickel);
        userChange.setPennyCount(countPenny);
        storedChange = userChange;
    }

    @Override
    public String returnChange() {
        if (storedChange != null) {
            int quarter = storedChange.getQuarterCount();
            int dime = storedChange.getDimeCount();
            int nickel = storedChange.getNickelCount();
            int penny = storedChange.getPennyCount();
            storedChange = null;

            return "Quarters:" + quarter + " Dimes:" + dime
                    + " Nickles:" + nickel + " Pennies:" + penny;
        } else {
            return "";
        }

    }

    @Override
    public void clearVariables() {
        storedItem = null;
        storedMoney = "0";
    }

    @Override
    public void createItem(Item item
    ) {
        Item newItem = item;
        storedItem = newItem;
    }

    @Override
    public Item returnItem() {
        return storedItem;
    }

    @Override
    public Item vendItem(Item item) throws InsufficientFundsException, NoItemInventoryException {
        Item newItem = item;

        if (item.getAmount() < 1 || item == null) {
            throw new NoItemInventoryException("SOLD OUT!!!");
        }

        if (new BigDecimal(storedMoney).compareTo(item.getPrice()) < 0) {
            BigDecimal difference = item.getPrice().subtract(new BigDecimal(storedMoney));
            throw new InsufficientFundsException("Please deposit: " + difference);
        }
        newItem.setAmount(newItem.getAmount() - 1);
        dao.updateItem(newItem);
        calculateChange(newItem.getPrice());
        return newItem;
    }

    @Override
    public List getAllItems() {
        List<Item> itemList = dao.getAllItems();
        return itemList;
    }

    @Override
    public Item getItemById(int intNumber) {
        Item item = dao.getItemById(intNumber);
        return item;
    }

    @Override
    public void updateItem(Item item) {
        dao.updateItem(item);
    }

    @Override
    public void createMessage(String newMessage) {
        message = newMessage;
    }

    @Override
    public String displayMessage() {
        return message;
    }

    @Override
    public void clearMessages() {
        message = "";
    }

}
