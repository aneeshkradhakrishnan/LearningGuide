package com.training.designpatterns.structural.observer;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers(String name, Double value);
}
