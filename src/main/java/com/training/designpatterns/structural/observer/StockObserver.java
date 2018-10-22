package com.training.designpatterns.structural.observer;

public class StockObserver implements Observer {

    private String name;
    private Subject subject;
    private Double value;

    public StockObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        System.out.println("New Observer : " + this.getName());
        subject.register(this);
    }

    @Override
    public void update(String name, Double value) {
        if(getName().equals(name)) {
            this.value = value;
        }
        printValue();
    }

    private void printValue() {
        System.out.println("Observer : " + this.getName() + " Value : " + this.value);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
