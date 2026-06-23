/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author Markus
 */
public class Hourly {

    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<Integer> temperature_2m = new ArrayList<>();
    private ArrayList<Integer> dateTemps = new ArrayList<>();
    private ArrayList<Integer> weatherCode = new ArrayList<>();
    private ArrayList<Integer> codeForecast = new ArrayList<>();

    public void setTime(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            time.add(array.getString(i));
        }
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTemperature_2m(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            temperature_2m.add(array.getInt(i));
        }
    }

    public void setWeatherCodeForecast(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            weatherCode.add(array.getInt(i));
        }
    }

    private void filterForDateTemps(String date) {

        for (int i = 0; i < time.size(); i++) {
            if (time.get(i).startsWith(date)) {
                dateTemps.add(temperature_2m.get(i));
                

            }
        }
    }
    
    private void filterForCodeForeCast(String date) {

        for (int i = 0; i < time.size(); i++) {
            if (time.get(i).startsWith(date)) {
                codeForecast.add(weatherCode.get(i));
                

            }
        }
    }

    public ArrayList<Integer> getForecast(String date) {
        clearDateTemps();
        filterForDateTemps(date);
        return dateTemps;

    }

    public ArrayList<Integer> getCodeForecast(String date) {
        clearCodeForecast();
        filterForCodeForeCast(date);
        return codeForecast;

    }

    private void clearDateTemps() {
        dateTemps.clear();
    }

    private void clearCodeForecast() {
        codeForecast.clear();
    }

}
