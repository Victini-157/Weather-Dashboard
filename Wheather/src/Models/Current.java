/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Markus
 */
public class Current {
    private String time;
    private double interval, temperature_2m,apparent_temperature;
    private int is_day,relative_humidity_2m;
    public String getTime() {
        return time;
    }

    public double getInterval() {
        return interval;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public int getRelative_humidity_2m() {
        return relative_humidity_2m;
    }

    public double getApparent_temperature() {
        return apparent_temperature;
    }

    public String getIs_day() {
        String currentState= "Daytime" ;
        if(is_day==0){
            currentState= "Nighttime";
        }
        return currentState;
            
    }
    
    

    public void setTime(String time) {
        this.time = time;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public void setTemperature_2m(double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public void setRelative_humidity_2m(int relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }

    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }
    
    
    
    
     
    
    
    
    
}
