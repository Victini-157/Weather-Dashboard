/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Markus
 */
public class API {
    private JsonHandler json= new JsonHandler();

    public void getCelcius() throws MalformedURLException, IOException {

        int celcius = 0;
        String stringURL = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weather_code,sunrise,sunset,daylight_duration,temperature_2m_max,temperature_2m_min&hourly=weather_code,temperature_2m,rain,snowfall,showers,snow_depth&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,rain,showers,snowfall";

        URL url = new URL(stringURL);

        Scanner scanner = new Scanner(url.openStream());
        scanner.useDelimiter("\\A");

        String jsonResponse = null;
        if (scanner.hasNext()) {
            jsonResponse = scanner.next();
           
            
        }
        scanner.close();
        
        JSONObject jo = new JSONObject(jsonResponse);
        JSONArray timeArray = jo.getJSONObject("hourly").getJSONArray("time");
        
        
        json.setTemperature_2m(jo.getJSONObject("current").getDouble("temperature_2m"));
        json.setTime(jo.getJSONObject("hourly").getJSONArray("time"));
        json.setTemperature_2mArray(jo.getJSONObject("hourly").getJSONArray("temperature_2m"));
        json.setCodeForecast(jo.getJSONObject("hourly").getJSONArray("weather_code"));
        json.setTimezone(jo.getString("timezone"));
        json.setRelative_Humidity_2m(jo.getJSONObject("current").getInt("relative_humidity_2m"));
        json.setApparent_Temperature(jo.getJSONObject("current").getDouble("apparent_temperature"));
        json.setIs_Day(jo.getJSONObject("current").getInt("is_day"));
                
       
        
    }

    public JsonHandler getJson() {
        return json;
    }

 

    
    
}
