package main.java.com.example.weather.display;

import main.java.com.example.weather.observer.DisplayElement;
import main.java.com.example.weather.observer.Observer;
import main.java.com.example.weather.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private final Subject subject;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.printf("[CurrentConditions] Temp: %.2f°C | Humidity: %.2f%%%n",
                temperature, humidity);
    }
}
