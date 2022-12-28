package com.example.cbs;

import java.util.ArrayList;

public class BookedInfo {
    private String NSID;
    private String time;
    private String date;
    private String courtNumber;

    public BookedInfo(ArrayList<String> bookingInfo){
        this.time = bookingInfo.get(0);
        this.date = bookingInfo.get(1);
        this.courtNumber = bookingInfo.get(2);
    }

    public boolean equals(BookedInfo bookedInfo)
    {
        if (!this.time.equals(bookedInfo.getTime()))
        {
            return false;
        }
        if (!this.date.equals(bookedInfo.getDate()))
        {
            return false;
        }
        if (!this.courtNumber.equals(bookedInfo.getCourtNumber()))
        {
            return false;
        }
        return true;
    }

    public String getNSID() {
        return NSID;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getCourtNumber() {
        return courtNumber;
    }

    public void setNSID(String NSID){
        this.NSID = NSID;
    }

    @Override
    public String toString() {
        return "BookedInfo{" +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", courtNumber='" + courtNumber + '\'' +
                '}';
    }
}
