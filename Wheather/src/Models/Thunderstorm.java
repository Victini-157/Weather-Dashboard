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
public class Thunderstorm extends Clouds {

    public Thunderstorm(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.YELLOW);
        g.drawLine(startX, startY, 162, 73);
        g.drawLine(startX, startY, 172, 73);
        g.drawLine(startX, startY, 162, 83);
       
    }
    
}
