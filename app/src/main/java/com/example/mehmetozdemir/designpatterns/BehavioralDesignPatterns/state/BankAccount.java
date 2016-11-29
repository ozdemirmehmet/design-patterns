package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.state;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class BankAccount {

    private BankAccountState bankAccountState;

    public BankAccount() {
        bankAccountState = new NormalBankAccount();
    }

    public void changeBankAccountState(BankAccountState bankAccountState){
        this.bankAccountState = bankAccountState;
    }

    public void pullMoney(){
        bankAccountState.pullMoney();
    }

    public void payMoney(){
        bankAccountState.payMoney();
    }
}
