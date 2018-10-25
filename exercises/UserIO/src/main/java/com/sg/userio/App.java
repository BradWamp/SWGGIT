/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

/**
 *
 * @author bwamp
 */
public class App {
    public static void main(String[] args) {
        UserIO obj = new UserIOImpl();
        
        obj.print("hello test");
        obj.readString("another test");
        obj.readDouble("give a double");
        
    }
}
