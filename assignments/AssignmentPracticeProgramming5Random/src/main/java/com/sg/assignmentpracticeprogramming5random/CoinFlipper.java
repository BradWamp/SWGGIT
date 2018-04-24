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
 

public class CoinFlipper {
   public static void main( String args[] ) {
     
      Random randomCoin = new Random();
 

      boolean coinSide = randomCoin.nextBoolean();
     
      System.out.println("Ready, Set, Flip....!!");
     
      if (coinSide == true) {
        System.out.println("You got HEADS");
      } else {
        System.out.println("You got TAILS!");   
      }
   }   
}
