package com.training.designpatterns.structural.prototype;

public class Dog implements Animal {

    public Dog() {
        System.out.println("Dog is made");
    }

    @Override
    public Animal makeCopy() {
        System.out.println("Dog is being copied");
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Dog says bow wow";
    }
}
