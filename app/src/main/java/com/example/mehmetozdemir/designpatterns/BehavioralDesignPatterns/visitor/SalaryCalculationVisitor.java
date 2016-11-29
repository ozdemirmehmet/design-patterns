package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.visitor;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class SalaryCalculationVisitor implements StaffVisitor {

    @Override
    public void visit(Emplooye emplooye) {
        Log.d("Visitor => ", "İşçi maaşı hesaplandı.");
    }

    @Override
    public void visit(Manager manager) {
        Log.d("Visitor => ", "Yönetici maaşı hesaplandı.");
    }
}
