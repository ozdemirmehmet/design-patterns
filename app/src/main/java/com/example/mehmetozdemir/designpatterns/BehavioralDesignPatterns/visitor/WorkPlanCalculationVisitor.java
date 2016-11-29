package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.visitor;

import android.util.Log;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class WorkPlanCalculationVisitor implements StaffVisitor {

    @Override
    public void visit(Emplooye emplooye) {
        Log.d("Visitor => ", "İşçi çalışma saatleri hesaplandı.");
    }

    @Override
    public void visit(Manager manager) {
        Log.d("Visitor => ", "Yönetici çalışma saatleri hesaplandı");
    }
}
