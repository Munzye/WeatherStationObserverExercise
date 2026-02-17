package main.java.com.example.weather.display;

import main.java.com.example.weather.observer.DisplayElement;
import main.java.com.example.weather.observer.Observer;
import main.java.com.example.weather.subject.Subject;

public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 1013.25f;
    private float lastPressure = 1013.25f;

    private final Subject subject;

    public ForecastDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather (pressure rising).";
        } else if (currentPressure < lastPressure) {
            forecast = "Possible rain/cooler weather (pressure falling).";
        } else {
            forecast = "More of the same.";
        }

        System.out.printf("[Forecast] %s (%.2f -> %.2f hPa)%n",
                forecast, lastPressure, currentPressure);
    }
}
