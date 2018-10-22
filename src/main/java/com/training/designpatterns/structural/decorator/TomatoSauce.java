package com.training.designpatterns.structural.decorator;

public class TomatoSauce extends ToppingDecorator {
    public TomatoSauce(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Tomato Sauce");
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Tomato Sauce";
    }

    @Override
    public Double getCost() {
        return pizza.getCost() + .35;
    }
}
