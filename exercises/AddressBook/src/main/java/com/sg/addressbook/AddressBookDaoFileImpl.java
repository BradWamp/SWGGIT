/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bwamp
 */

public class AddressBookDaoFileImpl implements AddressBookDao {

    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";
    
    HashMap <String, Address> addressMap = new HashMap<>();
    
    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException{
        Address daoAddress = addressMap.put(lastName, address);
        writeAddress();
        return daoAddress;
    }

    @Override
    public Address removeAddress(String removeName) throws AddressBookDaoException{
        Address removeAddress = addressMap.remove(removeName);
        writeAddress();
        return removeAddress;
    }

    @Override
    public Address findAddress(String lastName) throws AddressBookDaoException{
        loadAddress();
        Address addressForLastName = addressMap.get(lastName);
        return addressForLastName;
    }

    @Override
    public int countAddress() throws AddressBookDaoException{
        loadAddress();
        return addressMap.size(); 
    }

    @Override
    public List<Address> listAddress() throws AddressBookDaoException {
        loadAddress();
        return new ArrayList<Address>(addressMap.values());
    }
    
    private void loadAddress() throws AddressBookDaoException {
        Scanner scanner;
        try{
        scanner = new Scanner (new BufferedReader(new FileReader(ADDRESS_FILE)));
        }catch (FileNotFoundException e){
            throw new AddressBookDaoException("could not load into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        
            while (scanner.hasNextLine()){
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);

                Address currentAddress = new Address();

                currentAddress.setFirstName(currentTokens[0]);
                currentAddress.setLastName(currentTokens[1]);
                currentAddress.setStreetAddress(currentTokens[2]);
                currentAddress.setCity(currentTokens[3]);
                currentAddress.setState(currentTokens[4]);
                currentAddress.setZip(currentTokens[5]);

                addressMap.put(currentAddress.getLastName(), currentAddress);
        }
        scanner.close();
    }
    private void writeAddress() throws AddressBookDaoException{
        PrintWriter out;
        try{
        out = new PrintWriter(new FileWriter (ADDRESS_FILE));
        }catch (IOException e) {
            throw new AddressBookDaoException("could not save data", e);
        }
        List <Address> addressList = this.listAddress();
            for (Address currentAddress : addressList) {
                out.println(currentAddress.getFirstName() + DELIMITER 
                + currentAddress.getLastName() + DELIMITER
                + currentAddress.getStreetAddress() + DELIMITER
                + currentAddress.getCity() + DELIMITER
                + currentAddress.getState() + DELIMITER
                + currentAddress.getZip() + DELIMITER);
                
                out.flush();
            }
        out.close();
    }
}
