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
import java.util.Scanner;
import java.util.Random;

public class GuessMeMore {
    public static void main(String[] args) {
        int guessNumber, pickedNumber;
        String userGuess;
        Random randomNumber = new Random();
        
        pickedNumber = randomNumber.nextInt(100+1+100)-100;
        
        Scanner userInput = new Scanner(System.in); 
        
        System.out.println("I've chosen a number. Betcha can't guess it!");
        do {
            userGuess = userInput.nextLine();
            guessNumber = Integer.parseInt(userGuess);
            System.out.println("Your guess: " + userGuess);
        
        
            if ( guessNumber == pickedNumber) {
                 System.out.println("Wow, nice guess! That was it!");
            } else if (guessNumber > pickedNumber) {
                 System.out.println("Too bad, way to high. Guess again ");
            } else {
                 System.out.println("Ha, nice try too low! Guess again ");
            }
        }while (guessNumber != pickedNumber);
    }
}