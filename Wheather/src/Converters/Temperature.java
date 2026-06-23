package Converters;

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

    private double celcius;


    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getFahrenheit() {
        return (celcius * 9 / 5) + 32;
    }

    public double getKelvin() {
        return celcius + 274.15;
    }

}
