/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Converters.Temperature;
import Converters.WeatherCodeConverter;
import GUI.WheatherFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Markus
 */
public class Weather {

    private Temperature converter = new Temperature();
    private API api = new API();
    private JsonHandler jsonhandler = new JsonHandler();
    private WheatherFrame.TemperatureUnit mode = WheatherFrame.TemperatureUnit.Celcius;
    private String degrees = "°C";
    private WeatherCodeConverter weatherCodeConverter = new WeatherCodeConverter();

    private long unitConvertere(int temperature) {
        converter.setCelcius(temperature);
        long temp = 0;
        switch (mode) {
            case Celcius ->
                temp = Math.round(converter.getCelcius());
            case Fahrenheit ->
                temp = Math.round(converter.getFahrenheit());
            case Kelvin ->
                temp = Math.round(converter.getKelvin());
        }
        return temp;

    }

    public void setMode(WheatherFrame.TemperatureUnit mode) {
        this.mode = mode;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public void update() throws IOException {
        api.getCelcius();
        jsonhandler = api.getJson();

    }

    public ArrayList<Integer> getForecast() {
        return jsonhandler.getForecast(LocalDate.now().toString());

    }

    public ArrayList<Integer> getCodeForecast() {
        return jsonhandler.getCodeForecast(LocalDate.now().toString());
    }

    public void drawGraph(Graphics g) {
        ArrayList<Integer> forecast = getForecast();
        g.setColor(Color.BLACK);
        g.drawLine(30, 240, 750, 240);//X axes
        g.drawLine(30, 240, 30, 80); //y axes

        for (int i = 0; i < forecast.size(); i++) {
            g.drawLine(60 + 30 * i, 245, 60 + 30 * i, 235);
            g.drawString(String.valueOf(i) + ":00", 13 + 31 * i, 257); //X line ticks

            if (i < 8) {
                g.drawLine(25, 220 - 20 * i, 35, 220 - 20 * i);
            }
            if (i < 9) {
                g.drawString(String.valueOf(5 * i) + "°C", 5, 245 - 20 * i);//Y line ticks
            }

            g.drawLine(30 + i * 30, 240 - (int) Math.round(20 * (forecast.get(i) / 5.0)), //start point
                       30 + (i + 1) * 30, 240 - (int) Math.round(20 * (forecast.get(i + 1) / 5.0))); //end point
        }
    }

    public void drawForecast(Graphics g) {
        ArrayList<Integer> forecast = getForecast();
        ArrayList<Integer> weatherCode = getCodeForecast();
        for (int i = 0; i < forecast.size(); i++) {
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i) + ":00", 10 + i * 45, 10);
            g.drawString(String.valueOf(unitConvertere(forecast.get(i))) + degrees, 13 + i * 45, 23);
            String weatherCondition = weatherCodeConverter.codeConverter(weatherCode.get(i));
            if (weatherCondition.equals("SUNNY")) {
                Sunny sunny = new Sunny(13 + i * 45, 35, 0, 0);
                sunny.draw(g);
            } else if (weatherCondition.equals("CLOUDY")) {
                Clouds cloudy = new Clouds(13 + i * 45, 35, 0, 0);
                cloudy.draw(g);
            } else if (weatherCondition.equals("RAINY")) {
                Rain rainy= new Rain(13 + i * 45, 35, 0, 0);
                rainy.draw(g);
            } else if (weatherCondition.equals("SNOWY")) {
                Snow snowy = new Snow(13 + i * 45, 35, 0, 0);
                snowy.draw(g);
            }else{
                Thunderstorm thunderstorm= new Thunderstorm(13 + i * 45, 35, 0, 0);
                thunderstorm.draw(g);
            }
        }

    }

    public long getCurrentTemperature() {
        System.out.println(mode);
        return unitConvertere((int) jsonhandler.getTemperature_2m());

    }
}
