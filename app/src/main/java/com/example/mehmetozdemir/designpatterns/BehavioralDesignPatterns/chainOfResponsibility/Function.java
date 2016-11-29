package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public abstract class Function {

    protected Function nextFunction;

    public Function setNextFunction(Function nextFunction){
        this.nextFunction = nextFunction;
        return  nextFunction;
    }

    public void run(String functionData){
        //İşlei gerçekleştir.
        doFunction(functionData);
        //Sonrasına bir işlev daha eklenmişse onu da gerçekleştir.
        if (nextFunction != null)
            nextFunction.run(functionData);
    }

    protected abstract void doFunction(String functionData);

}
