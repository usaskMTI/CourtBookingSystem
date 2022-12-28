package com.example.cbs;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CourtObjectView extends AnchorPane {
    private Label NSID;
    private Label courtNumber;
    private Label day;
    private Label time;


    public CourtObjectView(String NSID, String time, String day, String courtNumber)
    {
        VBox courtInfoBox = new VBox();

        this.NSID = new Label("NSID: "+NSID);
        this.courtNumber = new Label("Court Number: "+courtNumber);
        this.day = new Label("DATE: "+day);
        this.time = new Label("Time: "+time);
        courtInfoBox.getChildren().addAll(this.NSID, this.courtNumber,this.day, this.time);

        courtInfoBox.setAlignment(Pos.BASELINE_LEFT);


        AnchorPane.setLeftAnchor(courtInfoBox,2.0);
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2));
        this.setBorder(new Border(borderStroke));
        this.setWidth(50);
        this.getChildren().addAll(courtInfoBox);
    }

}
