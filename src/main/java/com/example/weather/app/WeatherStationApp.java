package main.java.com.example.weather.app;

import main.java.com.example.weather.display.*;
import main.java.com.example.weather.subject.WeatherData;

public class WeatherStationApp {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);

        new PressureDisplay(weatherData);

        //reto
        new HeatIndexDisplay(weatherData);

        //sim
        weatherData.setMeasurements(26.0f, 65.0f, 1013.0f);
        weatherData.setMeasurements(28.5f, 70.0f, 1008.5f);
        weatherData.setMeasurements(24.2f, 90.0f, 1016.2f);
    }
}
