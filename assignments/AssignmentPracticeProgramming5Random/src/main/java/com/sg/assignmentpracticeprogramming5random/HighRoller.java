/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignmentpracticeprogramming5random;

/**
 *
 * @author bwamp
 */
import java.util.Random;
import java.util.Scanner;
 

public class HighRoller {
    public static void main(String args[]) {
        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);
       
        int rollResult, userDice;
        String userDiceString;
       
        System.out.println("How many sides does the dice have. Enter a whole number.");
        userDiceString = userInput.nextLine();
        userDice = Integer.parseInt(userDiceString);
        System.out.println(userDice);
       
        rollResult = diceRoller.nextInt(userDice) + 1;
       
        System.out.println("TIME TO ROOOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);
       
        if (rollResult == 1) {
            System.out.println("You rolled a crit failure! Ouch.");
        } else if (rollResult == userDice) {
            System.out.println("You rolled a Critical! Nice Job!");
        }
       
    }
}
