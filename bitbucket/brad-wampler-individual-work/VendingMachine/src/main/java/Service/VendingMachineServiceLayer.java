/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.VendingDaoException;
import Dto.Change;
import Dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author bwamp
 */
public interface VendingMachineServiceLayer {
    public List <Item> getAllItems()throws VendingDaoException;
    public Item getItemService (int itemNumber) throws VendingDaoException;
    public void addMoney (BigDecimal userMoney);
    public BigDecimal getBalance();
    public void purchaseItem (Item controllerItem, BigDecimal userMoney) throws InsufficientFundsException, NoItemInventoryException, VendingDaoException;
    public Change calculateChange (BigDecimal cost, BigDecimal userMoney);
    //public void checkInventory(Item controllerItem)throws NoItemInventoryException;
    //public void checkMoney (Item controllerItem, BigDecimal a) throws InsufficientFundsException;
    //public Change calculateCoins(BigDecimal userMoney, BigDecimal itemPrice);
    public void updateInventoryService(Item newItem)throws VendingDaoException;
}
