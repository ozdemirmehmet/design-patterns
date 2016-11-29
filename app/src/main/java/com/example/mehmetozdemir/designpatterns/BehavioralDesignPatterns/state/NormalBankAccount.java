package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.state;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class NormalBankAccount implements BankAccountState {


    @Override
    public void pullMoney() {
        Log.d("State => ", "Normal hesaptan para çekildi.");
    }

    @Override
    public void payMoney() {
        Log.d("State => ", "Normal hesaba para yatırıldı.");
    }
}
