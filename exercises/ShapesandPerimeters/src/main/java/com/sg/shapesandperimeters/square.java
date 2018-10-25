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
public class square extends shapes {

    
    @Override
    public void getArea(int length, int width) {
       int area = width * length;
        System.out.println(area);
    }

    @Override
    public void getPerimeter(int length, int width) {
       int perimeter = length * 4; 
        System.out.println(perimeter);
    }
    
}
