package com.example.cbs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BookingObject {
    private String time;
    private CellView monday;
    private CellView tuesday;
    private CellView wednesday;
    private CellView thursday;
    private CellView friday;
    private CellView saturday;
    private CellView sunday;

    public BookingObject(String time){
        this.time = time;

        monday = new CellView();
        tuesday= new CellView();
        wednesday= new CellView();
        thursday= new CellView();
        friday= new CellView();
        saturday= new CellView();
        sunday= new CellView();

    }

    public void setOnAction(EventHandler<ActionEvent> eventHandler) {

        monday.setOnAction(eventHandler);
        tuesday.setOnAction(eventHandler);
        wednesday.setOnAction(eventHandler);
        thursday.setOnAction(eventHandler);
        friday.setOnAction(eventHandler);
        saturday.setOnAction(eventHandler);
        sunday.setOnAction(eventHandler);

    }
    public void fakeBooked(String day){
        if (day.equals("Monday"))
        {
            monday.setAvailable(false);
        }
        else if (day.equals("Tuesday"))
        {
            tuesday.setAvailable(false);
        }
        else if (day.equals("Wednesday"))
        {
            wednesday.setAvailable(false);
        }
        else if (day.equals("Thursday"))
        {
            thursday.setAvailable(false);
        }
        else if (day.equals("Friday"))
        {
            friday.setAvailable(false);
        }
        else if (day.equals("Saturday"))
        {
            saturday.setAvailable(false);
        }
        else if (day.equals("Sunday"))
        {
            sunday.setAvailable(false);
        }

    }
    public String getTime() {
        return time;
    }
    public CellView getMonday(){
        return this.monday;
    }
    public CellView getTuesday() {
        return tuesday;
    }

    public CellView getWednesday() {
        return wednesday;
    }

    public CellView getThursday() {
        return thursday;
    }

    public CellView getFriday() {
        return friday;
    }

    public CellView getSaturday() {
        return saturday;
    }

    public CellView getSunday() {
        return sunday;
    }

    @Override
    public String toString() {
        return "fakeBook{" +
                "time=" + time +
                ", monday='" + monday + '\'' +
                ", tuesday='" + tuesday + '\'' +
                ", wednesday='" + wednesday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", friday='" + friday + '\'' +
                ", saturday='" + saturday + '\'' +
                ", sunday='" + sunday + '\'' +
                '}';
    }
}
