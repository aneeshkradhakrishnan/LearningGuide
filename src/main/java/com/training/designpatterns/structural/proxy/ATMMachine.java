package com.training.designpatterns.structural.proxy;

public class ATMMachine implements GetATMData {

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState atmOutofMoney;

    ATMState atmState;
    boolean correctPinEntered = false;
    int cashInMachine = 2000;

    public ATMMachine() {
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutofMoney = new NoCash(this);
    }

    public ATMState getYesCardState() { return hasCard; }
    public ATMState getNoCardState() { return noCard; }
    public ATMState getHasPin() { return hasCorrectPin; }
    public ATMState getNoCashState() { return atmOutofMoney; }

    @Override
    public ATMState getATMState() {
        return atmState;
    }

    @Override
    public int cachInTheMachine() {
        return cashInMachine;
    }
}
