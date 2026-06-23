/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Markus
 */
public class Clouds extends Animation{

    /**
     * Constructor of class Clouds.
     * @param startX starting coordinate for x
     * @param startY
     * @param endX
     * @param endY 
     */
    public Clouds(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(startX, startY, 14, 14);
        g.fillOval(startX+15, startY, 14, 14);
        g.fillOval(startX+4, startY-8, 20, 20);
       
    }

    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
