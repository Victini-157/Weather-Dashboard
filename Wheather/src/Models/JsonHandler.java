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
public class JsonHandler {

    private double latitude, longtitude, generationtime_ms, utc_offset_seconds,
            elevation, temperature_2m_max, temperature_2m_min;
    private String timezone, timezone_abbreviation, time_daily;

    private Current current = new Current();
    private Hourly hourly = new Hourly();

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public double getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public double getElevation() {
        return elevation;
    }

    public double getInterval() {
        return current.getInterval();
    }

    public double getTemperature_2m() {
        return current.getTemperature_2m();
    }

    public double getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public double getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public String getTime_current() {
        return current.getTime();
    }

    public String getTime_daily() {
        return time_daily;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public void setGenerationtime_ms(double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public void setUtc_offset_seconds(double utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public void setInterval(double interval) {
        current.setInterval(interval);
    }

    public void setTemperature_2m(double temperature_2m) {
        current.setTemperature_2m(temperature_2m);
    }

    public void setTemperature_2m_max(double temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public void setTemperature_2m_min(double temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public void setTime_current(String time_current) {
        current.setTime(time_current);
    }

    public void setTime_daily(String time_daily) {
        this.time_daily = time_daily;
    }

    public void setTime(JSONArray array) {
        hourly.setTime(array);
    }

    public void setTemperature_2mArray(JSONArray array) {
        hourly.setTemperature_2m(array);
    }

    public ArrayList<Integer> getForecast(String date) {
        return hourly.getForecast(date);
    }

    public void setCodeForecast(JSONArray array) {
        hourly.setWeatherCodeForecast(array);
    }
    public ArrayList<Integer> getCodeForecast(String date) {
       return hourly.getCodeForecast(date);
        
    }
    
    public void setRelative_Humidity_2m(int relative_humidity_2m ){
        current.setRelative_humidity_2m(relative_humidity_2m);
    }
    
    public int getRelative_Humidity_2m(){
        return current.getRelative_humidity_2m();
    }
    
    public void setApparent_Temperature(double apparent_temperature){
        current.setApparent_temperature(apparent_temperature);
    }
    
    public double getApparent_Temperature(){
        return current.getApparent_temperature();         
    }
    
    public void setIs_Day(int is_day){
        current.setIs_day(is_day);
    }
    
    public String getIs_Day() {
        return current.getIs_day();
    }
    
    
}
