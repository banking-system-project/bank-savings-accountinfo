package com.bank.savings.account.vo;

public class SavingsAccountInfoVO {
    private String currentBal;
    private String currency;
    private String interestRate;
    private String lastTransaction;
    private String lastUpdate;

    public String getCurrentBal() {
        return currentBal;
    }

    public void setCurrentBal(String currentBal) {
        this.currentBal = currentBal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}
