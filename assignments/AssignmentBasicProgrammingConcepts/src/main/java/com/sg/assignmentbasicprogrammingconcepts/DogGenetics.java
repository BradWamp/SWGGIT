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
      int dogType1 = randomDog.nextInt(100) +1;
      int dogType2 = randomDog.nextInt(100 - dogType1) +1;
      int dogType3 = randomDog.nextInt(100 - dogType1 - dogType2) +1;
      int dogType4 = randomDog.nextInt(100 - dogType1 - dogType2 - dogType3) +1;
      int dogType5 = 100 - dogType1 - dogType2 - dogType3 - dogType4;
     
      System.out.println("What is your dog's name?");
      dogName = userInput.nextLine();
     
      System.out.println(dogName + " is:");
      System.out.println();
      System.out.println(dogType1 + "% St. Bernard");
      System.out.println(dogType2 + "% Chihuahua");
      System.out.println(dogType3 + "% Dramatic RedNosed Asian Pug");
      System.out.println(dogType4 + "% Common Cur");
      System.out.println(dogType5 + "% King Doberman");
                 System.out.println();
     
      System.out.println("Wow, that's QUITE the dog!");
   }    
}
