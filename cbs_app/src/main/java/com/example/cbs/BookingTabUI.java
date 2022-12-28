package com.example.cbs;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class BookingTabUI extends AnchorPane implements ModelListener  {
    private TabPane courts;
    private BookingModel model;
    private Button backBtn;
    private Scene scene;
    private Label bookingCounter;
    private Label message;

    private BookingTableUI table1;
    private BookingTableUI table2;
    private BookingTableUI table3;
    private BookingTableUI table4;
    private BookingTableUI table5;
    private BookingTableUI table6;

    private MainUI mainPage;

    public BookingTabUI(){

        Label title = new Label("UofS CBS");
        message = new Label("");
        courts = new TabPane();
        courts.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab court1 = new Tab("Court 1");
        Tab court2 = new Tab("Court 2");
        Tab court3 = new Tab("Court 3");
        Tab court4 = new Tab("Court 4");
        Tab court5 = new Tab("Court 5");
        Tab court6 = new Tab("Court 6");

        table1 = new BookingTableUI("Court 1");
        table2 = new BookingTableUI("Court 2");
        table3 = new BookingTableUI("Court 3");
        table4 = new BookingTableUI("Court 4");
        table5 = new BookingTableUI("Court 5");
        table6 = new BookingTableUI("Court 6");


        court1.setContent(table1);
        court2.setContent(table2);
        court3.setContent(table3);
        court4.setContent(table4);
        court5.setContent(table5);
        court6.setContent(table6);




        courts.getTabs().addAll(court1,court2,court3,court4,court5,court6);

        AnchorPane.setLeftAnchor(title, 10.0);
        AnchorPane.setLeftAnchor(courts, 10.0);
        AnchorPane.setTopAnchor(courts,30.0);
        AnchorPane.setRightAnchor(courts, 10.0);
        AnchorPane.setBottomAnchor(courts,50.0);

        bookingCounter = new Label("0/6 Booking");
//        Button finishButton = new Button("Finish");
        backBtn = new Button("Done");
        backBtn.setOnAction(e -> this.scene.setRoot(mainPage));

        AnchorPane.setBottomAnchor(bookingCounter, 15.0);
        AnchorPane.setRightAnchor(bookingCounter, 200.0);

        AnchorPane.setBottomAnchor(message, 15.0);
        AnchorPane.setRightAnchor(message, 300.0);

//        AnchorPane.setBottomAnchor(finishButton, 10.0);
//        AnchorPane.setRightAnchor(finishButton, 100.0);

        AnchorPane.setBottomAnchor(backBtn, 10.0);
        AnchorPane.setRightAnchor(backBtn, 10.0);
        this.getChildren().addAll(title,courts,message,bookingCounter, backBtn);


    }

    public void setModel(BookingModel model) {
        this.model = model;
        table1.setModel(model);
        table2.setModel(model);
        table3.setModel(model);
        table4.setModel(model);
        table5.setModel(model);
        table6.setModel(model);
    }

    public void setController(AppController controller) {
        // something done in the tutorial codes
//        setOnMouseClicked(controller::handleBookingClick);
        table1.setController(controller);
        table2.setController(controller);
        table3.setController(controller);
        table4.setController(controller);
        table5.setController(controller);
        table6.setController(controller);

    }


    public void passScene_mainPage(Scene scene, MainUI mainPage){
        this.scene = scene;
        this.mainPage = mainPage;

    }

    @Override
    public void modelChanged() {
        if (model.getTotalBooking()<=6){
            if (model.getTotalBooking()==6)
            {
                message.setText("At Booking Limit");
            }
            else if (model.getTotalBooking()<6)
            {
                message.setText("");
            }
            bookingCounter.setText(model.getTotalBooking()+"/6 Bookings");
            ((BookingTableUI) courts.getSelectionModel().getSelectedItem().getContent()).modelChanged();
        }


    }
}
