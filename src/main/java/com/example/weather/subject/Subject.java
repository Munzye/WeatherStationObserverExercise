package main.java.com.example.weather.subject;

import main.java.com.example.weather.observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
