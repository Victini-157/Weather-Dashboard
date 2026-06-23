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
public class Rain extends Clouds {

    public Rain(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }
    
    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(Color.BLUE);
        g.drawLine(startX, startY, startX + 10, startY+7);//+10 +7
        g.drawLine(startX+8, startY, startX + 12, startY+9);//+8 +12 +9
        g.drawLine(startX+15, startY, startX + 16, startY+10);//+15 +16 +10
    }
            
    
}
