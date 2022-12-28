package com.example.cbs;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class BookingModel {
    private ArrayList<ModelListener> subscribers;
    private ArrayList<BookedInfo> courtDetails;
    private ArrayList<Button> bookedButtons;
    private Button targetButton;
    private String NSID;


    public BookingModel(){
        subscribers = new ArrayList<>();
        courtDetails = new ArrayList<>();
        bookedButtons = new ArrayList<>();
    }

    public void addBooking(ArrayList<String> result, Button targetButton) {

        if (courtDetails.size() <6){
            BookedInfo newBooking = new BookedInfo(result);
            newBooking.setNSID(this.NSID);
            courtDetails.add(newBooking);
            bookedButtons.add(targetButton);
            this.setTargetButton(targetButton);
            //System.out.println(courtDetails.size());
            //System.out.println(newBooking);
            notifySubscribers();
        }

    }
    public void deleteBooking(ArrayList<String> result){

        BookedInfo targetBooking = new BookedInfo(result);

        for (int i = 0; i < courtDetails.size(); i++)
        {

            if (courtDetails.get(i).equals(targetBooking))
            {
                this.setTargetButton(bookedButtons.get(i));
                courtDetails.remove(i);
                bookedButtons.remove(i);

                notifySubscribers();
            }
        }
    }

    public void addSubscriber(ModelListener sub) {
        subscribers.add(sub);
    }

    public void notifySubscribers(){
        subscribers.forEach(s -> {
            s.modelChanged();
        });
    }

    public ArrayList<BookedInfo> getBookings()
    {
        return this.courtDetails;
    }


    public int getTotalBooking() {
        return courtDetails.size();
    }

    public BookedInfo getCourtBooking(int i) {
        return this.courtDetails.get(i);
    }

    public void setTargetButton(Button targetButton) {
        this.targetButton = targetButton;
    }
    public Button getTargetButton() {
        return this.targetButton;
    }
    public void setNSID(String NSID){
        this.NSID = NSID;
    }
}
