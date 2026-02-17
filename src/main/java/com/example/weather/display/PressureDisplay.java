package main.java.com.example.weather.display;

import main.java.com.example.weather.observer.DisplayElement;
import main.java.com.example.weather.observer.Observer;
import main.java.com.example.weather.subject.Subject;

public class PressureDisplay implements Observer, DisplayElement {

    private float pressure;
    private final Subject subject;

    public PressureDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.printf("[PressureOnly] Pressure: %.2f hPa%n", pressure);
    }
}
