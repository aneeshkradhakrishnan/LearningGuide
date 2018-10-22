package com.training.designpatterns.structural.observer;

public interface Observer {
    void update(String name, Double value);
    String getName();
}
