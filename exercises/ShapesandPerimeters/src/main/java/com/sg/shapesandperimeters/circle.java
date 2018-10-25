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
public class circle extends shapes {
        
        public void getArea(int circum, int radius){
            int area = circum + radius;
            System.out.println(area);
        }
        
        public void getPerimeter(int circum, int radius) {
            int perimeter = circum *2 + radius *2;
            System.out.println(perimeter);
        }
}
