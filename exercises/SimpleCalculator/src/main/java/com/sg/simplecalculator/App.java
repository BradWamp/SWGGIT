/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

/**
 *
 * @author bwamp
 */


import java.util.Scanner;


public class App {
    public static void main(String[] args) {
     Scanner userInputNumber1 = new Scanner(System.in);
     Scanner userInputNumber2 = new Scanner(System.in);
     Scanner userInputBoolean = new Scanner(System.in);
     Scanner userOperation = new Scanner(System.in);
     
     String userInputNumberString1;
     String userInputNumberString2;
     String userInputBooleanString;
     String userOperationString;
     
     double userInputNumberDouble1;
     double userInputNumberDouble2;
     int userOperationInt;
     
     boolean continueApp = true;
     
     while (continueApp){
         
         System.out.println("What math operation do you want to perform? Please type the number"
                 + " 1.Addition 2.Subtraction 3.Division 4.Multiplication");
         userOperationString = userOperation.nextLine();
         userOperationInt = Integer.parseInt(userOperationString);
         
        System.out.println("Give me operand1");
        userInputNumberString1 = userInputNumber1.nextLine();
        userInputNumberDouble1 = Integer.parseInt(userInputNumberString1);
        
        System.out.println("Give me operand2");
        userInputNumberString2 = userInputNumber1.nextLine();
        userInputNumberDouble2 = Integer.parseInt(userInputNumberString2);
        
        if (userOperationInt == 1){
            System.out.println(SimpleCalculator.addition(userInputNumberDouble1, userInputNumberDouble2));
        }
        else if (userOperationInt == 2){
            System.out.println(SimpleCalculator.subtraction(userInputNumberDouble1, userInputNumberDouble2));
        }
        else if (userOperationInt == 3){
            System.out.println(SimpleCalculator.division(userInputNumberDouble1, userInputNumberDouble2));
        }
        else{
            System.out.println(SimpleCalculator.multiplication(userInputNumberDouble1, userInputNumberDouble2));
        }
        
        System.out.println("would you like to continue with the app: y/n");
        userInputBooleanString = userInputBoolean.nextLine();
        
        if(userInputBooleanString.equals("y")){
            
        }else{
            continueApp = false;
        }
      
     } // end of while loop
        System.out.println("Thank you for playing");
    }
}
