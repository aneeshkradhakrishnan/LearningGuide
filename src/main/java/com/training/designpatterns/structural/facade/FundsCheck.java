package com.training.designpatterns.structural.facade;

public class FundsCheck {
    private Double cashInAccount = 1000.0;

    public Double cachBanlanceInAccount() {
        return cashInAccount;
    }

    public void debitFromAccount(Double cashWithdrawn) {
        this.cashInAccount -= cashWithdrawn;
        System.out.println("Amount Successfully debited : " + cashWithdrawn + ", current balance is : " + cachBanlanceInAccount());
    }

    public void creditToAccount(Double cashDeposited) {
        this.cashInAccount += cashDeposited;
        System.out.println("Amount Successfully credited : " + cashDeposited + ", current balance is : " + cachBanlanceInAccount());
    }

    public boolean haveEnoughFund(Double cashWithdrawn) {
        if (cashWithdrawn > cachBanlanceInAccount()) {
            System.out.println("Error : You don't have enough balance in Account, current balance is : " + cachBanlanceInAccount());
        }
        return cachBanlanceInAccount() > cashWithdrawn;
    }
}
