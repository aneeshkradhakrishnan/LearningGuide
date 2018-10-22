package com.training.designpatterns.structural.observer;

import com.training.designpatterns.structural.prototype.CloneFactory;
import com.training.designpatterns.structural.prototype.Dog;
import com.training.designpatterns.structural.prototype.Sheep;

public class RunnerCloneFactory {

    public static void main(String... args) {
        CloneFactory animalMaler = new CloneFactory();

        Sheep sheep = new Sheep();
        Sheep clonedSheep = (Sheep)animalMaler.getClone(sheep);
        System.out.println(sheep);
        System.out.println(clonedSheep);
        System.out.println("Sheep Hash Code : " +System.identityHashCode(sheep));
        System.out.println("Cloned Sheep Hash Code : " +System.identityHashCode(clonedSheep));

        Dog dog = new Dog();
        Dog clonedDog= (Dog)animalMaler.getClone(dog);
        System.out.println(dog);
        System.out.println(clonedDog);
        System.out.println("Dog Hash Code : " +System.identityHashCode(dog));
        System.out.println("Cloned Dog Hash Code : " +System.identityHashCode(clonedDog));
    }
}
