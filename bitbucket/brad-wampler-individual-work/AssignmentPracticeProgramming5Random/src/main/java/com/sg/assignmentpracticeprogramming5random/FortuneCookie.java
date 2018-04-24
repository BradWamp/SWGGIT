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
 

public class FortuneCookie {
 

    public static void main(String[] args) {
        Random randomizer = new Random();
        
        int x = randomizer.nextInt(11);
       
        if (x == 0) {
        System.out.println("Your Geek Fortun : Those aren't the droids you're looking for.");
        } else if (x == 1) {
        System.out.println("Your Geek Fortun : Never go in against a Sicilian when death is on the line!");
        } else if (x == 2) {
        System.out.println("Your Geek Fortun : Goonies never say die.");
        } else if (x == 3) {
        System.out.println("Your Geek Fortun : With great power there must also come - great responsibility.");
        } else if (x == 4) {
        System.out.println("Your Geek Fortun : Never argue with the data.");
        } else if (x == 5) {
        System.out.println("Your Geek Fortun : Try Not. Do, or do not. There is no try.");
        }else if (x == 6) {
        System.out.println("Your Geek Fortun : You are a leaf on the wind, watch how you soar.");
        }else if (x == 7) {
        System.out.println("Your Geek Fortun : Do absolutely nothing, and it will be everything that you thought it could be.");
        }else if (x == 8) {
        System.out.println("Your Geek Fortun : Kneel before Zod.");
        }else if (x == 9) {
        System.out.println("Your Geek Fortun : Make it so.");
        }
    }
}
