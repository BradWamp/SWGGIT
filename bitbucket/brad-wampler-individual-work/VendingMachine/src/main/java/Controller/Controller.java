/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.VendingDaoException;
import Dao.VendingDaoFile;
import Dto.Change;
import Dto.Item;
import Service.VendingMachineServiceLayer;
import Service.NoItemInventoryException;
import Service.InsufficientFundsException;
import UI.VendingMachineView;
import java.math.BigDecimal;


/**
 *
 * @author j1bdw02
 */
public class Controller {
    public VendingMachineView view;
    public VendingMachineServiceLayer service;
    
    public Controller(VendingMachineView view, VendingMachineServiceLayer service){
        this.view = view;
        this.service = service;
    }
    
    private boolean keepRunning = true;
    private int userSelection;
    //BigDecimal userMoney;
   
      
    public void runProgram() throws Exception {
        while (keepRunning){
            userSelection = view.userMenu();
            if (userSelection == 1){
                displayVendingItems();
            }else if (userSelection == 2){
                getUserMoney();
            }else if (userSelection == 3){
                vendItem();
            }else if (userSelection == 4) {
                refundMoney();
            }else {
                exitProgram(); //need to reset usermoney to 0 along with everything else
                break;
            }
   
        }
    }
   
    public void displayVendingItems(){
        try{
            view.displayItems(service.getAllItems());
        }catch(VendingDaoException e){
            view.loadFailed(e.getMessage());
        }
    }
    public void getUserMoney() throws NumberFormatException{
        service.addMoney(view.insertMoney());
    }
    public void vendItem() throws Exception {
        
        boolean errorNotThrown = true; 
        Item controllerItem = service.getItemService(view.selectItem());
        
      while(errorNotThrown){
        try{
           service.purchaseItem(controllerItem, service.getBalance());
           view.displayChange(service.calculateChange(controllerItem.getPrice(),service.getBalance()),controllerItem.getItem());
           service.updateInventoryService(controllerItem);
           service.addMoney(BigDecimal.ZERO);
           errorNotThrown = false;
        }catch(NoItemInventoryException | InsufficientFundsException e){
            view.displayError(e.getMessage());
            break;
        }
      }
    }
    public void refundMoney(){
        view.displayChange(service.calculateChange(BigDecimal.ZERO, service.getBalance()), "money back.");
        service.addMoney(BigDecimal.ZERO);
    }
    public void exitProgram(){
        view.quitProgram(service.calculateChange(BigDecimal.ZERO, service.getBalance()));
    }
}
        
