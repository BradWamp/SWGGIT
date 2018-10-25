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
public interface AddressBookDao {
                 
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException;
    public Address removeAddress(String removeName) throws AddressBookDaoException;
    public Address findAddress(String lastName) throws AddressBookDaoException;
    public int countAddress() throws AddressBookDaoException;
    public List<Address> listAddress() throws AddressBookDaoException;
}
