package com.training.designpatterns.structural.decorator;

public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Normal Pan Crust";
    }

    @Override
    public Double getCost() {
        return 4.0;
    }
}
