package com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetozdemir on 29/11/16.
 */

public class DocumentWriter {

    private Document document;
    private List<DocumentReminder> historyList = new ArrayList<>();

    public DocumentWriter(Document document) {
        this.document = document;
    }

    public void writeDocument(String content){
        DocumentReminder documentReminder = document.createDocumentReminder();
        historyList.add(documentReminder);
        document.assignContent(content);
        Log.d("Memento => ", "Dokümana yazılan: " + content);
    }

    public void getBack(){
        Log.d("Memento => ", "Dokümandan çıkarılan: " + document.getContent());
        DocumentReminder documentReminder = historyList.remove(historyList.size() - 1);
        document.assignDocumentReminder(documentReminder);
    }
}
