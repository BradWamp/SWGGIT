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
public class FirstLast6 {
        // Given an array of ints, return true if 6 appears as either the 
    // first or last element in the array. The array will be length 1 or more. 
    //
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false
    public boolean firstLast6(int[] numbers) {
        int[] intArray = numbers;
        int firstNumber = intArray[0];
        int lastNumber = intArray[intArray.length-1];
        if (firstNumber == 6 || lastNumber == 6){
            return true;
        } else {
            return false;
        }    
    }
}
