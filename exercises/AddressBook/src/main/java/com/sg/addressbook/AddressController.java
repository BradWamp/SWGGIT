/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.util.List;

/**
 *
 * @author bwamp
 */
public class AddressController {
    
   // AddressView view = new AddressView();
    AddressView view;
    //AddressBookDao dao = new AddressBookDaoFileImpl();
    AddressBookDao dao;
  
    public AddressController(AddressBookDao dao, AddressView view){
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try{
	while (keepGoing) {

            menuSelection = getMenuSelection();
            if (menuSelection == 1) {
                createAddress();
            } else if (menuSelection == 2) {
                removeAddress();
            }else if (menuSelection == 3){
                countAddress();
            }else if (menuSelection == 4){
                listAddress();
            }else if (menuSelection == 5){
                returnSearch();
            }else if (menuSelection == 6){
                keepGoing = false;
                break;// exit
            }
        }                
	}catch (AddressBookDaoException e) {
            System.out.println("error");
        }
    }
    private int getMenuSelection() {
	    return view.printMenuAndGetSelection();
    }
    private void createAddress() throws AddressBookDaoException{
        Address newAddress = view.getAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
    }
    private void listAddress() throws AddressBookDaoException{
         List<Address> getAddressList = dao.listAddress();
         view.displayAddressList(getAddressList);
    }
    private void removeAddress() throws AddressBookDaoException{
        String lastNameToRemove = view.getLastNameToRemove();
        dao.removeAddress(lastNameToRemove);
    }
    private void countAddress() throws AddressBookDaoException{
        int mapSize = dao.countAddress();
        view.countAddresses(mapSize);
    }
    private void returnSearch() throws AddressBookDaoException{
        String lastName = view.searchForAddress();
        Address addressForLastName = dao.findAddress(lastName);
        view.getAddressByLastName(addressForLastName);
    }
}
    
