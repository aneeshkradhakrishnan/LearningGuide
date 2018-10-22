package com.training.designpatterns.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

    private List<Observer> observers;

    public StockGrabber() {
        observers = new ArrayList<>();
    }
    @Override
    public void register(Observer observer) {
        observers.add(observer);
        System.out.println("Observer : " + observer.getName() + " is registered");
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer : " + observer.getName() + " is unRegistered");
    }

    @Override
    public void notifyObservers(String name, Double value) {
        System.out.println("Updating : " + name + " Value : " + value);
        for(Observer o : observers) {
            o.update(name, value);
        }
    }

    public void setApplePrice(Double price) {
        notifyObservers("apple", price);
    }

    public void setGooglePrice(Double price) {
        notifyObservers("google", price);
    }

    public void setIbmPrice(Double price) {
        notifyObservers("ibm", price);
    }

    public void setFordPrice(Double price) {
        notifyObservers("ford", price);
    }
}
