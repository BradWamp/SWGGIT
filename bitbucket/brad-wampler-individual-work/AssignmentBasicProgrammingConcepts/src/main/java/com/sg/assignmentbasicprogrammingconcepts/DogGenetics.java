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
import java.util.Random;
import java.util.Scanner;
 

public class DogGenetics {
   public static void main( String args[] ) {
     
      Scanner userInput = new Scanner(System.in);
      Random randomDog = new Random();
      String dogName;
      double dogType1 = randomDog.nextInt(101);
      double dogType2 = randomDog.nextInt(101);
      double dogType3 = randomDog.nextInt(101);
      double dogType4 = randomDog.nextInt(101);
      double dogType5 = randomDog.nextInt(101);
      double sumDog = dogType1 + dogType2 + dogType3 + dogType4 + dogType5;
     
      System.out.println("What is your dog's name?");
      dogName = userInput.nextLine();
     
      System.out.println(dogName + " is:");
      System.out.println();
      System.out.println( (double) Math.round((dogType1*100)/sumDog) + "% St. Bernard");
      System.out.println( (double) Math.round((dogType2*100)/sumDog) + "% Chihuahua");
      System.out.println( (double) Math.round((dogType3*100)/sumDog) + "% Dramatic RedNosed Asian Pug");
      System.out.println( (double) Math.round((dogType4*100)/sumDog) + "% Common Cur");
      System.out.println( (double) Math.round((dogType5*100)/sumDog) + "% King Doberman");
      System.out.println();
     
      System.out.println("Wow, that's QUITE the dog!");
   }    
}
