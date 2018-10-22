package com.training.designpatterns.structural.facade;

public class SecurityCodeCheck {
    private String securityCode = "1234";

    public String getSecurityCode() {
        return this.securityCode;
    }

    public boolean codeCorrect(String verifyCode) {
        return getSecurityCode().equals(verifyCode);
    }
}
