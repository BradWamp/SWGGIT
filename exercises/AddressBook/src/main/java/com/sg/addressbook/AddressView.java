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
public class AddressView {
    //private UserIO io = new UserIOImpl();
    private UserIO io;
    
    public AddressView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Remove Address");
        io.print("3. Count Addresses");
        io.print("4. List Addresses");
        io.print("5. Search Address");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1, 6);
    }
    public Address getAddressInfo() {
	
        Address currentAddress = new Address(); //might need parameters  // creats a new address object 
	
        currentAddress.setFirstName(io.readString("Please enter First Name")); // sets first name of new address object
        currentAddress.setLastName(io.readString("Please enter Last Name"));
        currentAddress.setStreetAddress(io.readString("Please enter the Street Address"));
        currentAddress.setCity(io.readString("Please enter the City"));
        currentAddress.setState(io.readString("Please enter the State"));
        currentAddress.setZip(io.readString("Please enter the Zip"));
	    
        return currentAddress; // returns the fully created new address object
    }
    
    public void displayAddressList(List<Address> listAddress) {
	    for (Address currentAddress : listAddress) {
	        io.print(currentAddress.getFirstName() + " "
	                + currentAddress.getLastName() + "\n"
	                + currentAddress.getStreetAddress() + "\n"
                        + currentAddress.getCity() + ", "
                        + currentAddress.getState() + ", "
                        + currentAddress.getZip()+"\n");
	    }
	    
	}
    public String getLastNameToRemove() {
	    return io.readString("Please enter the Last Name for the record you would like to remove.");
    }
    public void countAddresses(int size) {
        io.print("There are " + size + " addresses in this book");       
    }
    public String searchForAddress(){
        return io.readString("What is the Last name you want to search?");
    }
    public void getAddressByLastName(Address addressForLastName) {
        io.print(addressForLastName.getFirstName() + " "
	                + addressForLastName.getLastName() + "\n"
	                + addressForLastName.getStreetAddress() + "\n"
                        + addressForLastName.getCity() + ", "
                        + addressForLastName.getState() + ", "
                        + addressForLastName.getZip()+"\n");
    }
}
