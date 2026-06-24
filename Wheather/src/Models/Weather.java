/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Converters.Temperature;
import Converters.WeatherCodeConverter;
import GUI.WeatherFrame;
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
    private WeatherFrame.TemperatureUnit mode = WeatherFrame.TemperatureUnit.Celcius;
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

    public void setMode(WeatherFrame.TemperatureUnit mode) {
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

    public void drawCurrent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Current Weather", 0, 10);

        g.drawString("Temperature: " + String.valueOf(getCurrentTemperature()) + degrees, 0, 25);

        g.drawString("Time: " + LocalDateTime.now().toString(), 0, 40);

        g.drawString("Timezone: " + jsonhandler.getTimezone(), 0, 65);

        g.drawString("Humidity: " + String.valueOf(jsonhandler.getRelative_Humidity_2m()) + "%", 0, 80);

        g.drawString("Apparent Temperature: " + String.valueOf(getCurrentApparent_Temperature()) + degrees, 0, 100);

        g.drawString(jsonhandler.getIs_Day(), 0, 115);

    }

    public void drawGraph(Graphics g) {
        ArrayList<Integer> forecast = getForecast();
        int offset = 30;
        g.setColor(Color.BLACK);
        g.drawString("Graph:", 0, 30);
        g.drawLine(30+offset, 240, 750, 240);//X axes
        g.drawLine(30+offset, 240, 30+offset, 80); //y axes

        for (int i = 0; i < forecast.size(); i++) {
            if (i < forecast.size() - 1) {
                g.drawLine(60 + 30 * i+offset, 245, 60 + 30 * i+offset, 235);
            }
            g.drawString(String.valueOf(i) + ":00", 13 + 31 * i + offset, 257); //X line ticks

            if (i < 8) {
                g.drawLine(25 +offset, 220 - 20 * i, 35+offset, 220 - 20 * i );
            }
            if (i < 9) {
                g.drawString(String.valueOf(unitConvertere(5) * i) + degrees, 5, 245 - 20 * i);//Y line ticks
            }
            if (i < forecast.size() - 1) {
                g.drawLine(30 + i * 30 + offset, 240 - (int) Math.round(20 * (forecast.get(i)) / 5.0), //start point
                        30 + (i + 1) * 30 + offset, 240 - (int) Math.round(20 * forecast.get(i + 1) / 5.0)); //end point
            }
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
                Rain rainy = new Rain(13 + i * 45, 35, 0, 0);
                rainy.draw(g);
            } else if (weatherCondition.equals("SNOWY")) {
                Snow snowy = new Snow(13 + i * 45, 35, 0, 0);
                snowy.draw(g);
            } else {
                Thunderstorm thunderstorm = new Thunderstorm(13 + i * 45, 35, 0, 0);
                thunderstorm.draw(g);
            }
        }

    }

    public long getCurrentTemperature() {

        return unitConvertere((int) jsonhandler.getTemperature_2m());

    }

    public long getCurrentApparent_Temperature() {

        return unitConvertere((int) jsonhandler.getApparent_Temperature());

    }
}
