package com.training.designpatterns.structural.facade;

//pattern adds an interface to existing system to hide its complexities.
public class BankAccountFacade {

    private String accountNumber;
    private String securityCode;
    private AccountNumberCheck accountNumberCheck;
    private SecurityCodeCheck securityCodeCheck;
    private FundsCheck fundsCheck;
    private WelcomeToBank bankWelecome;

    public BankAccountFacade(String accountNumber, String securityCode) {

        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
        this.accountNumberCheck = new AccountNumberCheck();
        this.securityCodeCheck = new SecurityCodeCheck();
        this.fundsCheck = new FundsCheck();
        this.bankWelecome = new WelcomeToBank();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void withdrawCash(double cash) {
       if(accountNumberCheck.activeAccount(getAccountNumber()) &&
               securityCodeCheck.codeCorrect(getSecurityCode()) && fundsCheck.haveEnoughFund(cash)) {
           fundsCheck.debitFromAccount(cash);
           System.out.println("Transaction Completed **");
        } else {
           System.out.println("Transaction Failed !!");
       }
    }

    public void depositCash(double cash) {
        if(accountNumberCheck.activeAccount(getAccountNumber()) &&
                securityCodeCheck.codeCorrect(getSecurityCode())){
            fundsCheck.creditToAccount(cash);
            System.out.println("Transaction Completed **");
        } else {
            System.out.println("Transaction Failed !!");
        }
    }
}
