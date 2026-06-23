/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converters;

/**
 *
 * @author Markus
 */
public class WeatherCodeConverter {

    public String codeConverter(int weatherCode) {
        String weatherCondition = "CLOUDY"; // Default
        if (weatherCode == 0) {
            weatherCondition = "SUNNY";
        } else if ((weatherCode >= 51 && weatherCode <= 67) || (weatherCode >= 80 && weatherCode <= 82)) {
            weatherCondition = "RAINY";
        } else if ((weatherCode >= 71 && weatherCode <= 77) || (weatherCode >= 85 && weatherCode <= 86)) {
            weatherCondition = "SNOWY";
        } else if (weatherCode >= 95 && weatherCode <= 99) {
            weatherCondition = "THUNDERSTORM";
        }
        return weatherCondition;
    }
}
