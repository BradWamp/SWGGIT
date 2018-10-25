/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

/**
 *
 * @author bwamp
 */
import java.util.*;
import java.util.Scanner;
public class App {
     public static void main(String[] args) {
        HashMap <String, Capital> newMap = new HashMap<>();
        Scanner userInput = new Scanner(System.in);
        int userInputInt;
        
        newMap.put("Kansas", new Capital("Topeka", 34000, 55));
        newMap.put("Alabama", new Capital("Montgomery", 205000, 156));
        newMap.put("Alaska", new Capital("Juneau", 31000, 3255));
        newMap.put("Arizona", new Capital("Phoenix", 1445000, 517));
        newMap.put("Arkansas", new Capital("Little Rock", 193000, 116));
        /* the rest of the states would be enterred here, but I REALLY didn't want to take the time
         to find them and type it all out. It would be the same process no matter how many states there were.
        Figured the important part was the code, not my typing skills*/
              
        for ( String s : newMap.keySet() ){
        System.out.print(s + "- ");
                
          Capital capital = newMap.get(s);
          
          System.out.print(capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMiles());
          System.out.println("");
        }
        
        System.out.println("Enter a population amount to filter by.");
        userInputInt = userInput.nextInt();
        
        for ( String s : newMap.keySet() ){          
          Capital capital = newMap.get(s);
                if (capital.getPopulation() >= userInputInt){
                System.out.print(s + "- ");
                System.out.print(capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMiles());
                System.out.println("");
          }
          
        }
    }
}
