/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author Markus
 */
public class Weather {
    
    private Temperature temperature= new Temperature();
    private API api = new API();
    private JsonHandler jsonhandler= new JsonHandler();
    private Sunny sunny= new Sunny();
    
    public double getTemperature(int selected){
        double temp=0;
        System.out.println(selected);
        if(selected==0){
            temp=temperature.getCelcius();
        }else if(selected==1){
            temp=temperature.getFahrenheit();
        }else if(selected==2){
            temp=temperature.getKelvin();
        }
        return temp;
    }
    
    public void update() throws IOException{
       api.getCelcius();
       jsonhandler = api.getJson();
       temperature.setCelcius(jsonhandler.getTemperature_2m());
       
    }
    
    
    public void draw(Graphics g){
        sunny.draw(g);
    }
}
