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
import java.util.Scanner;
 

public class HealthyHearts {
    public static void main(String args[]) {
        Scanner userInput = new Scanner(System.in);
        String userAge;
        int maxRate, targetRate1, targetRate2;
       
        
        System.out.println("What is your age?");
        userAge = userInput.nextLine();
        maxRate = (int) Math.round(220 - Integer.parseInt(userAge));
        targetRate1 = (int) Math.round(.50 * maxRate);
        targetRate2 = (int) Math.round(.85 * maxRate);
       
        
        System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute");
        System.out.println("Your target HR zone is " + targetRate1 + " - " + targetRate2 + " beats per minute");
    }
}
