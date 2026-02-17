package main.java.com.example.weather.observer;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
