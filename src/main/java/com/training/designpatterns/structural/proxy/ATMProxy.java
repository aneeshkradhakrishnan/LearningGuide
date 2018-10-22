package com.training.designpatterns.structural.proxy;

public class ATMProxy implements GetATMData {

    private ATMMachine atmMachine;

    @Override
    public ATMState getATMState() {
        createAtmMachine();
        return atmMachine.getATMState();
    }

    private void createAtmMachine() {
        if(null == atmMachine) {
            atmMachine = new ATMMachine();
        }
    }

    @Override
    public int cachInTheMachine() {
        createAtmMachine();
        return atmMachine.cachInTheMachine();
    }
}
