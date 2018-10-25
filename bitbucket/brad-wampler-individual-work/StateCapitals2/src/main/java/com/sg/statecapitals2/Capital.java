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
public class Capital {
    
    
    private String name;
    private int population;
    private int squareMiles; 
    
    public Capital(){};
    
    public Capital( String name, int population, int squareMiles){
        this.name = name;
        this.population = population;
        this.squareMiles = squareMiles;
        
    };
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareMiles() {
        return squareMiles;
    }

    public void setSquareMiles(int squareMiles) {
        this.squareMiles = squareMiles;
    }    
}