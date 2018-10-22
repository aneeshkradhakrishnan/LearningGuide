package com.training.designpatterns.structural.decorator;

public class RunnerPizzaMaker {

    public static void main(String... args) {
        Pizza basicPizza =new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println(basicPizza.getDescription() + " : "  + basicPizza.getCost());
    }
}
