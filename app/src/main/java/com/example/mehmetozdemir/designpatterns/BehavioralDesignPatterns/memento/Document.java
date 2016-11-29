package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class Document {

    private String content;

    public String getContent(){
        return content;
    }

    public void assignContent(String content){
        this.content = content;
    }

    public DocumentReminder createDocumentReminder(){
        return new DocumentReminder(this);
    }

    public void assignDocumentReminder(DocumentReminder documentReminder){
        this.content = documentReminder.getContent();
    }
}
