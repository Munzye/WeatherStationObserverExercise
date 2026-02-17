package main.java.com.example.weather.display;

import main.java.com.example.weather.observer.DisplayElement;
import main.java.com.example.weather.observer.Observer;
import main.java.com.example.weather.subject.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private float heatIndexC;
    private final Subject subject;

    public HeatIndexDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.heatIndexC = computeHeatIndexC(temperature, humidity);
        display();
    }

    @Override
    public void display() {
        System.out.printf("[HeatIndex] Heat Index: %.2f°C%n", heatIndexC);
    }

    private float computeHeatIndexC(float tempC, float humidity) {
        // Convert to Fahrenheit for the classic NOAA formula
        float tF = (tempC * 9.0f / 5.0f) + 32.0f;
        float rh = humidity;

        // NOAA heat index approximation (Fahrenheit)
        float hiF = (float)(
                -42.379
                + 2.04901523 * tF
                + 10.14333127 * rh
                - 0.22475541 * tF * rh
                - 0.00683783 * tF * tF
                - 0.05481717 * rh * rh
                + 0.00122874 * tF * tF * rh
                + 0.00085282 * tF * rh * rh
                - 0.00000199 * tF * tF * rh * rh
        );

        // Back to Celsius
        return (hiF - 32.0f) * 5.0f / 9.0f;
    }
}
