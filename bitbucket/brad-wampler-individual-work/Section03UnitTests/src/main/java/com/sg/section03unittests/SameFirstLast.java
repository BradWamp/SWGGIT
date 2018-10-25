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
public class SameFirstLast {
    // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    public boolean sameFirstLast(int[] numbers) throws ArrayIndexOutOfBoundsException {
        int[] intArray = numbers;
        int firstNumber = intArray[0];
        int lastNumber = intArray[intArray.length-1];
        if (intArray.length > 0 && firstNumber == lastNumber){
            return true;
        } else {
            return false;
        }
    }
}
