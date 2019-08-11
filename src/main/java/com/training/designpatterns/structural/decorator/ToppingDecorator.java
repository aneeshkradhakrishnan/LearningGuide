package com.training.designpatterns.structural.decorator;

public abstract class ToppingDecorator implements Pizza {

    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}
