package com.example.cbs;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class AppController
{
    BookingTabUI view;
    BookingModel model;

    public AppController()
    {

    }
    public void setModel(BookingModel newModel) {
        model = newModel;
    }
    public void setView(BookingTabUI newView) {
        view = newView;
    }

    public void handleBookingClick(ArrayList<String> result, Button targetButton)
    {
        model.addBooking(result, targetButton);
//        System.out.println("Using the function handleBookingClick in AppController Class");
    }


    public void handleUnbookingClick(ArrayList<String> result) {

        model.deleteBooking(result);
    }
}
