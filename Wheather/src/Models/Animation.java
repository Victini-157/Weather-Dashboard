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
public abstract class Animation {
    
    public abstract void draw(Graphics g);
    public abstract void change();
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;

    public Animation(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    
   
    
}
