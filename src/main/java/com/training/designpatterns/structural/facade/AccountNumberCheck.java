package com.training.designpatterns.structural.facade;

public class AccountNumberCheck {

    private String accountNumber = "12345678";

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public boolean activeAccount(String verifyAccountNumber) {
        return getAccountNumber().equals(verifyAccountNumber);
    }
}
