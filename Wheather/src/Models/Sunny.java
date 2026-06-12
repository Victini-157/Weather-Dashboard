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
public class Sunny extends Animation {

    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(200, 200, 15, 15);

        for (int i = 0; i < 6; i++) {
            double angle = (i / 6) * 2 * Math.PI;
            double start_x = 220 + 100 * Math.cos(angle);
            double start_y = 220 + 100 * Math.sin(angle);

            double end_x = 220 + 120 * Math.cos(angle);
            double end_y = 220 + 120 * Math.sin(angle);
            
            g.drawLine((int)start_x, (int)start_y, (int)end_x, (int)end_y);
        }

    }

}
