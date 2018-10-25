/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignmentbasicprogrammingconcepts;

/**
 *
 * @author bwamp
 */
public class SummativeSums {
    static int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
    static int[] array2 = { 999, -60, -77, 14, 160, 301 };
    static int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                    140, 150, 160, 170, 180, 190, 200, -99 };
    
    public static void main(String args[]) {
       System.out.println("#1 Array sum: " + sumArrays(array1));
       System.out.println("#2 Array sum: " + sumArrays(array2));
       System.out.println("#3 Array sum: " + sumArrays(array3));
    }
   
    public static int sumArrays(int [] arrayInput) {
        int arraySum, x;
        arraySum = 0;
        x = 0;
       
        for (int i = 0; i < arrayInput.length; i++) {
            arraySum += arrayInput[x];
            x++;
        }
       
        return arraySum;
    }
}
