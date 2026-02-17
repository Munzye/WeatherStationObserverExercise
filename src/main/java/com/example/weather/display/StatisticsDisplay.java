package main.java.com.example.weather.display;

import main.java.com.example.weather.observer.DisplayElement;
import main.java.com.example.weather.observer.Observer;
import main.java.com.example.weather.subject.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float minTemp = Float.MAX_VALUE;
    private float maxTemp = Float.MIN_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;

    private final Subject subject;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;

        minTemp = Math.min(minTemp, temperature);
        maxTemp = Math.max(maxTemp, temperature);

        display();
    }

    @Override
    public void display() {
        float avg = (numReadings == 0) ? 0.0f : (tempSum / numReadings);
        System.out.printf("[Statistics] Avg/Min/Max Temp: %.2f / %.2f / %.2f °C%n",
                avg, minTemp, maxTemp);
    }
}
