package com.training.designpatterns.structural.facade;

public class RunnerFacade {

    public static void main(String... args) {

        BankAccountFacade accessingBank = new BankAccountFacade("12345678", "1234");

        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(900.00);

        accessingBank.depositCash(200.00);

        accessingBank.withdrawCash(300.00);
    }
}
