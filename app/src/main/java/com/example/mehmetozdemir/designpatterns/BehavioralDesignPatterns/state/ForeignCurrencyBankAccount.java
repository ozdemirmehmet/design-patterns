package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.state;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class ForeignCurrencyBankAccount implements BankAccountState {

    @Override
    public void pullMoney() {
        Log.d("State => ", "Döviz hesabından para çekildi.");
    }

    @Override
    public void payMoney() {
        Log.d("State => ", "Döviz hesabına para yatırıldı.");
    }
}
