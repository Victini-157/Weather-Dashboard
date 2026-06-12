/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


/**
 *
 * @author Markus
 */
public class API {
    private JsonHandler json= new JsonHandler();

    public void getCelcius() throws MalformedURLException, IOException {

        int celcius = 0;
        String stringURL = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weather_code,sunrise,sunset,daylight_duration,temperature_2m_max,temperature_2m_min&hourly=temperature_2m,rain,snowfall,showers,snow_depth&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,rain,showers,snowfall";

        URL url = new URL(stringURL);

        Scanner scanner = new Scanner(url.openStream());
        scanner.useDelimiter("\\A");

        String jsonResponse = null;
        if (scanner.hasNext()) {
            jsonResponse = scanner.next();
           
            
        }
        scanner.close();
        
        JSONObject jo = new JSONObject(jsonResponse);
        
        
        json.setTemperature_2m(jo.getJSONObject("current").getDouble("temperature_2m"));
        System.out.println(json.getTemperature_2m());
        
    }

    public JsonHandler getJson() {
        return json;
    }

 

    
    
}
