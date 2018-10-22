package com.training.designpatterns.structural.template;

public abstract class Sandwich {

    public void makeSandwich() {
        cutBun();
        
        if(customerWantsMeat()) {
            addMeat();
        }
        if(customerWantsCheese()) {
            addCheese();
        }
        if(customerWantsVeggie()) {
            addVeggie();
        }
        
        wrapSandwich();
    }

    protected void wrapSandwich(){
        System.out.println("Sandwich is wrapped");
    }

    protected void cutBun() {
        System.out.println("Bun is being cut");
    }

    protected boolean customerWantsVeggie() {
        return true;
    }

    protected boolean customerWantsCheese() {
        return true;
    }

    protected boolean customerWantsMeat() {
        return true;
    }

    protected abstract void addVeggie();

    protected abstract void addCheese();

    protected abstract void addMeat();
}
