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
import java.util.Random;
 

public class RockPaperScissors {
   public static void main( String args[] ) {
       Scanner userInput = new Scanner(System.in);
       Random randomRPS = new Random();
       String userRoundsString, userRPS, userPlayAgain;
       int userRounds, userRPSInt, tieCounter, winCounter, lossCounter, computerRPSInt;
       userPlayAgain = "y";
      
       while(userPlayAgain.equalsIgnoreCase("y")) {
           tieCounter = 0;
           winCounter = 0;
           lossCounter = 0;
           System.out.println("How many rounds should the game last?");
           userRoundsString = userInput.nextLine();
           userRounds = Integer.parseInt(userRoundsString);
          
           if (userRounds > 10 || userRounds < 1) {
               System.out.println("User selected out of bound range");
               break;
                                               
           } else {  
               while (userRounds > 0){
                   System.out.println("Select Rock, Paper, or Scissors.");
                   userRPS = userInput.nextLine();
                   computerRPSInt = randomRPS.nextInt(3)+1;
                  
                    if(userRPS.equalsIgnoreCase("Rock")) {
                        userRPSInt = 1;
                    }else if (userRPS.equalsIgnoreCase("Paper")) {
                        userRPSInt = 2;
                    }else {
                        userRPSInt = 3;
                    }
                    if (userRPSInt == computerRPSInt) {
                        System.out.println("tie");
                        tieCounter++;
                        userRounds--;
                    }else if (userRPSInt == 1 && computerRPSInt == 3) {
                        System.out.println("user win");
                        winCounter++;
                        userRounds--;
                    }else if (userRPSInt == 2 && computerRPSInt == 1) {
                        System.out.println("user win");
                        winCounter++;
                        userRounds--;
                    }else if (userRPSInt == 3 && computerRPSInt ==2) {
                        System.out.println("user win");
                        winCounter++;
                        userRounds--;
                    }else {
                        System.out.println("computer win");
                        lossCounter++;
                        userRounds--;
                    }
                }
               
                System.out.println();
                System.out.println("Ties: " + tieCounter + " user wins: " + winCounter + " computer wins: " + lossCounter);
               
                if(winCounter > lossCounter) {
                    System.out.println("User is the overall winner");
                }else if (winCounter < lossCounter) {
                    System.out.println("Computer is the overall winner");
                }else {
                    System.out.println("No one was the overall winner");
                }
                                                           
                System.out.println();
                System.out.println("Would you like to play again? (y/n)");
                userPlayAgain = userInput.nextLine();
            }
                              }
    }  
}      
