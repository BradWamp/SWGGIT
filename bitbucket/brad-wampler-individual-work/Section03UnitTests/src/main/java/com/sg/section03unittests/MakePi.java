/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author bwamp
 */
public class MakePi {
        // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        int[] intArray = new int[n];
        int count = 0;
        
        for(int i =0; i < intArray.length; i++){
            int nthPlace = (int)(Math.abs(Math.PI) * Math.pow(10,count)) % 10;
            intArray[i] = nthPlace;
            count++;
        }    
        return intArray;
    }
}
