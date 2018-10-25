/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dto.Change;
import Dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author j1bdw02
 */
public class VendingMachineView {
    UserIO myIO;
  
    public VendingMachineView (UserIO myIO) {
        this.myIO = myIO;
    }
    
    public int userMenu() {
        myIO.print("\n");
        myIO.print("1. View Available Items");
        myIO.print("2. Insert Money");
        myIO.print("3. Vend Item");
        myIO.print("4. Return Money");
        myIO.print("5. Exit Machine");
        return myIO.readInt("Which option would you like to select?", 1, 5);
    }
    public void displayItems(List<Item> listItems) { // this will filter out any items that has 0 inventory
                
        listItems.stream().filter(i -> i.getAmount() != 0).forEach(i -> myIO.print("Item " + i.getItemNumber() + ": " + i.getItem() + 
                " | Price: $" + i.getPrice() + " | Quantity Remaining: " + i.getAmount()));
    }
    public void quitProgram (Change myChange) {
        myIO.print("\n Sorry to see you go take the money you just entered");
        myIO.print("Your change will be $" + myChange.getTotalChange() 
                + ", you will receive: " + myChange.getQuarterCount() + " quarters, " + myChange.getDimeCount()
                + " dimes, " + myChange.getNickelCount() + " nickels, " + myChange.getPennyCount() +" pennies \n" );
    }
    public BigDecimal insertMoney() throws NumberFormatException{
        boolean error = true;
        BigDecimal userMoney = BigDecimal.ZERO; // only way i could get the return statement to be satisfied, otherwise it couldn't find userMoney
       
        while (error) {
            try{
                userMoney = new BigDecimal(myIO.readString("How much money do you have?"));
                break;
            }catch (NumberFormatException e) {
            myIO.print("Wrong format, try again.");
            }
        }
        return userMoney;
    }
    public int selectItem () {
        return myIO.readInt("What is the item number that you would like to select?", 1, 4);
    }
    public void displayChange(Change myChange, String itemName) {
        myIO.print("\n Here is your " + itemName + "\n Your change should be $" + myChange.getTotalChange() 
                + ", you will receive: " + myChange.getQuarterCount() + " quarters, " + myChange.getDimeCount()
                + " dimes, " + myChange.getNickelCount() + " nickels, " + myChange.getPennyCount() +" pennies \n");
    }
    public void insufficientFunds (BigDecimal a) {
        myIO.print("You did not enter enough. You only entered $" + a);
        myIO.print("Try again");
    }
    /*public void insufficientInventory() {
        myIO.print("I am sorry, there is no more of that item left");
    }*/
    public void loadFailed(String message){
        myIO.print("Failed to load items from file.");
    }
    public void displayError (String e) {
        myIO.print(e);
    }
}
