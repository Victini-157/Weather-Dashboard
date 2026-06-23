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

    private final int RAYON = 15;
    private final double ANGLE = 7.5;

    public Sunny(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(startX, startY, RAYON, RAYON);

        double centerX = startX + ANGLE;
        double centerY = startY + ANGLE;

        for (int i = 0; i < 6; i++) {
            double angle = (i / 6.0) * 2 * Math.PI;
            double start_x = centerX + 10 * Math.cos(angle);
            double start_y = centerY + 10 * Math.sin(angle);

            double end_x = centerX + 15 * Math.cos(angle);
            double end_y = centerY + 15 * Math.sin(angle);

            g.drawLine((int) start_x, (int) start_y, (int) end_x, (int) end_y);
        }

    }

}
