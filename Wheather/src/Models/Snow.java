/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Graphics;

/**
 *
 * @author Markus
 */
public class Snow extends Clouds {

    public Snow(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }
    
    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.fillOval(startX, startY, 3, 3);
        g.fillOval(startX, startY, 3, 3);
        g.fillOval(startX, startY, 3, 3);
        g.fillOval(startX, startY, 3, 3);
        g.fillOval(startX, startY, 3, 3);
        
    }
            
    
}
