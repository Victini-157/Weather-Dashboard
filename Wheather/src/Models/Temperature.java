package Models;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Markus
 */
public class Temperature {

    private double Celcius;


    public double getCelcius() {
        return Celcius;
    }

    public void setCelcius(double Celcius) {
        this.Celcius = Celcius;
    }

    
    
    

    public double getFahrenheit() {
        return (getCelcius() * 9 / 5) + 32;
    }

    public double getKelvin() {
        return getCelcius() + 274.15;
    }

}
