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
public class triangle extends shapes {
        
        public void getArea(int base, int heigth){
            int area = (base * heigth) /2;
            System.out.println(area);
        }
        
        public void getPerimeter(int base, int heigth) {
            int perimeter = (base *2 + heigth*2) / 2;
            System.out.println(perimeter);
        }
}
