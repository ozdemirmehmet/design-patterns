package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.visitor;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Emplooye implements Staff{

    @Override
    public void accept(StaffVisitor staffVisitor) {
        staffVisitor.visit(this);
    }
}
