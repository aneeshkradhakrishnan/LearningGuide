package com.training.designpatterns.structural.prototype;

public class CloneFactory {
    public Animal getClone(Animal animal) {
        return animal.makeCopy();
    }
}
