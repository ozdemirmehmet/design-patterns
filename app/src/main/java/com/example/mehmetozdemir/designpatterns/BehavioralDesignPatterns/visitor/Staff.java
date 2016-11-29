package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.visitor;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public interface Staff {

    void accept(StaffVisitor staffVisitor);
}
