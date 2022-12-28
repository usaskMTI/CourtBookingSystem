package com.example.cbs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class courtObjectView_withDelete extends CourtObjectView {
    private Button deleteButton;
    private String timeString;
    private String dayString;
    private String courtNumberString;

    public courtObjectView_withDelete(String NSID,String time, String day, String courtNumber)
    {
        super(NSID,time,day, courtNumber);
        timeString = time;
        dayString = day;
        courtNumberString = courtNumber;
        HBox deleteBox = new HBox();

        deleteButton = new Button("DELETE");
        BorderStroke borderStroke2 = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.5));
        deleteBox.setBorder(new Border(borderStroke2));
        deleteBox.setAlignment(Pos.CENTER);
        deleteBox.setPadding(new Insets(10,10,10,10));
        deleteButton.setAlignment(Pos.CENTER);

        deleteBox.getChildren().add(deleteButton);
        AnchorPane.setRightAnchor(deleteBox, 2.0);
        AnchorPane.setTopAnchor(deleteBox, 2.0);
        AnchorPane.setBottomAnchor(deleteBox, 2.0);


        this.getChildren().add(deleteBox);

    }

    public String getTimeString() {
        return timeString;
    }

    public String getDayString() {
        return dayString;
    }

    public String getCourtNumberString() {
        return courtNumberString;
    }

    public void setOnAction(EventHandler<ActionEvent> eventHandler){

        deleteButton.setOnAction(eventHandler);

    }
}
