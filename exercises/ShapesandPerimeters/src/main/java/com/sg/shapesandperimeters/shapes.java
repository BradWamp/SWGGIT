/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

/**
 *
 * @author bwamp
 */
abstract public class shapes {
    
   private String color;
   
   abstract public void getArea(int length, int width);
   abstract public void getPerimeter(int length, int width);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   
}
