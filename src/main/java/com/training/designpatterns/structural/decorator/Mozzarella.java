package com.training.designpatterns.structural.decorator;

public class Mozzarella extends ToppingDecorator {
    public Mozzarella(Pizza pizza) {
        super(pizza);
        System.out.println("Adding Dough");
        System.out.println("Adding Mozzarella");
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mozzarella";
    }

    @Override
    public Double getCost() {
        return pizza.getCost() + .50;
    }
}
