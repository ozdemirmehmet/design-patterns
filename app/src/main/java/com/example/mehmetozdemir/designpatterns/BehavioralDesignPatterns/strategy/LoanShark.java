package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class LoanShark {

    private DebtCalculationMethod debtCalculationMethod;

    public LoanShark(DebtCalculationMethod debtCalculationMethod) {
        this.debtCalculationMethod = debtCalculationMethod;
    }

    public void calculateDebt(){
        debtCalculationMethod.calculateDebt();
    }
}
