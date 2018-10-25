/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

/**
 *
 * @author bwamp
 */
public class App {
    
    public static void main(String[] args) {
        //AddressController runApplication = new AddressController();
        UserIO myIo = new UserIOImpl();
        AddressView myView = new AddressView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressController controller = new AddressController (myDao, myView);
        controller.run();
    }
}
