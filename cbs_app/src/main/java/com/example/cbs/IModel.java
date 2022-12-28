package com.example.cbs;

import java.util.ArrayList;

public class IModel {
    private ArrayList<ModelListener> subscribers;


    public IModel(){
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(ModelListener sub) {
        subscribers.add(sub);
    }

    public void notifySubscribers(){
        subscribers.forEach(s -> {
            s.modelChanged();
        });
    }
}
