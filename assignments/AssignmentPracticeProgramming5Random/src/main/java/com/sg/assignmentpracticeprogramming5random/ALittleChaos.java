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
 

public class ALittleChaos {
 

    public static void main(String[] args) {
 

        Random randomizer = new Random();
 

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());
       
        int num = randomizer.nextInt(100);
       
        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);
       
        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");
       
        // i assume it would generate random numbers between 0-49 and then add 50
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
    }
}