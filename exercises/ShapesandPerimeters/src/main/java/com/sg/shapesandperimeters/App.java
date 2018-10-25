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
public class App {
    public static void main(String[] args) {
        shapes square1 = new square();
        shapes circle1 = new circle();
        shapes triangle1 = new triangle();
        
        square1.setColor("geen");
        System.out.println(square1.getColor());
        square1.getArea(2,2);
        square1.getPerimeter(2,2);
        circle1.getArea(2, 4);
        circle1.getPerimeter(2,4);
        triangle1.getArea(2,4);
        triangle1.getPerimeter(2,4);
        
    }
}
