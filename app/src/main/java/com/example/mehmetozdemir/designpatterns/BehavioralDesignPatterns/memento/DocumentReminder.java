package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class DocumentReminder {

    private String content;

    public DocumentReminder(Document document) {
        this.content = document.getContent();
    }

    public String getContent(){
        return content;
    }
}
