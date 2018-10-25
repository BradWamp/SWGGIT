/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.VendingDaoException;
import Dao.VendingDaoFile;
import Dao.VendingLoggingDao;
import Dto.Change;
import Dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    private VendingDaoFile dao;
    private VendingLoggingDao loggingDao;
    BigDecimal userMoney = new BigDecimal("0");
    
    public VendingMachineServiceLayerImpl (VendingDaoFile dao, VendingLoggingDao loggingDao) {
        this.dao=dao;
        this.loggingDao = loggingDao;
    }
    
    //Item myItem = new Item();
    
    @Override
    public List<Item> getAllItems () throws VendingDaoException{ //this does the exact same thing as the dao.
        List <Item> serviceList= dao.displayItems();
        return serviceList;
    }
    @Override
    public Item getItemService (int itemNumber) throws VendingDaoException{ //this does the exact same thing as the dao.
        Item serviceItem = dao.getItem(itemNumber);
        return serviceItem;
    }
    @Override
    public void addMoney(BigDecimal userMoney){
        this.userMoney = userMoney;
    }
    @Override
    public BigDecimal getBalance(){
        return userMoney;
    }
    @Override
    public void purchaseItem (Item controllerItem, BigDecimal userMoney) throws InsufficientFundsException, NoItemInventoryException, VendingDaoException {
        if( controllerItem.getAmount() <= 0) {
            //loggingDao.writeLoggingEntry(" No inventory exception was triggered for " + controllerItem);
            throw new NoItemInventoryException("There is not enough inventory. Try again");
        }else if (controllerItem.getPrice().compareTo(userMoney) > 0) {
            //loggingDao.writeLoggingEntry(" Insufficient funds exception was triggered for " + controllerItem);
            throw new InsufficientFundsException ("You only have $" + userMoney + " that isn't enough");
        } 
    }
    public Change calculateChange(BigDecimal cost, BigDecimal userMoney){
            Change myChange = new Change();       
            BigDecimal quarter = new BigDecimal(".25");
            int countQuarter = 0;
            BigDecimal dime = new BigDecimal(".10");
            int countDime = 0;
            BigDecimal nickel = new BigDecimal(".05");
            int countNickel = 0;
            BigDecimal penny = new BigDecimal(".01");
            int countPenny = 0;

            BigDecimal change = userMoney.subtract(cost);
            BigDecimal originalChange = userMoney.subtract(cost);

            while (change.compareTo(BigDecimal.ZERO) > 0){
              if(change.compareTo(quarter) >= 0) {
                    while (change.compareTo(quarter) >= 0){
                        change = change.subtract(quarter);
                        countQuarter++;
                    }
              }else if (change.compareTo(dime) >= 0) {
                    while ( change.compareTo(dime) >=0){
                        change = change.subtract(dime);
                        countDime++;
                    }
              }else if (change.compareTo(nickel) >= 0) {
                    while (change.compareTo(nickel) >= 0) {
                        change = change.subtract(nickel);
                        countNickel++;
                    }
              }else if (change.compareTo(penny) >= 0){
                    while (change.compareTo(penny) >= 0) {
                        change = change.subtract(penny);
                        countPenny++;
                    } 
                }  
            }
            myChange.setQuarterCount(countQuarter);
            myChange.setDimeCount(countDime);
            myChange.setNickelCount(countNickel);
            myChange.setPennyCount(countPenny);
            myChange.setTotalChange(originalChange);

            return myChange;
        
    }
    
    /*@Override
    public void checkInventory(Item controllerItem)throws NoItemInventoryException{
        if (controllerItem.getAmount() <= 0) {
            throw new NoItemInventoryException("There is not enough inventory. Try again");
        }
    }
    @Override
    public void checkMoney (Item controllerItem, BigDecimal a) throws InsufficientFundsException{
        if (controllerItem.getPrice().compareTo(a) > 0 ){
            throw new InsufficientFundsException("You only have $" + a + " that isn't enough");
        }
    }
    @Override
    public Change calculateCoins(BigDecimal userMoney, BigDecimal itemPrice){           
        BigDecimal quarter = new BigDecimal(".25");
        int countQuarter = 0;
        BigDecimal dime = new BigDecimal(".10");
        int countDime = 0;
        BigDecimal nickel = new BigDecimal(".5");
        int countNickel = 0;
        BigDecimal penny = new BigDecimal(".01");
        int countPenny = 0;
       
        BigDecimal change = userMoney.subtract(itemPrice);
        BigDecimal originalChange = userMoney.subtract(itemPrice);
        
        while (change.compareTo(BigDecimal.ZERO) > 0){
          if(change.compareTo(quarter) >= 0) {
                while (change.compareTo(quarter) >= 0){
                    change = change.subtract(quarter);
                    countQuarter++;
                }
          }else if (change.compareTo(dime) >= 0) {
                while ( change.compareTo(dime) >=0){
                    change = change.subtract(dime);
                    countDime++;
                }
          }else if (change.compareTo(nickel) >= 0) {
                while (change.compareTo(nickel) >= 0) {
                    change = change.subtract(nickel);
                    countNickel++;
                }
          }else if (change.compareTo(penny) >= 0){
                while (change.compareTo(penny) >= 0) {
                    change = change.subtract(penny);
                    countPenny++;
                } 
            }  
        }
        myChange.setQuarterCount(countQuarter);
        myChange.setDimeCount(countDime);
        myChange.setNickelCount(countNickel);
        myChange.setPennyCount(countPenny);
        myChange.setTotalChange(originalChange);
        
        return myChange;
    }*/
    
    @Override
    public void updateInventoryService(Item newItem)throws VendingDaoException{
        Item myItem = newItem;
        myItem.setAmount(newItem.getAmount()-1);
        dao.updateInventory(myItem);
    }
}
