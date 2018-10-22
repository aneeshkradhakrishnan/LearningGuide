package com.training.designpatterns.structural.proxy;

public class HasPin implements ATMState {
    private ATMMachine atmMachine;

    public HasPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {

    }

    @Override
    public void ejectCard() {

    }

    @Override
    public void insertPin(int pinEntered) {

    }

    @Override
    public void requestCash(int cashToWithdraw) {

    }
}