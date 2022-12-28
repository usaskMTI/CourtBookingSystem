package com.example.cbs;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class CancelBookingUI extends AnchorPane implements ModelListener {
    private Button doneButton;
    private Button cancelButton;
    private ListView<courtObjectView_withDelete> mainBox;
    private BookingModel model;
    private AppController controller;
    private Scene scene;
    private MainUI mainPage;
    private Label bookingCounter;



    public CancelBookingUI()
    {

        bookingCounter = new Label("0/6 Bookings");
        mainBox = new ListView<>();
        mainBox.setMinWidth(500);
        doneButton = new Button("Back");
        doneButton.setOnAction(e -> this.scene.setRoot(mainPage));
//        cancelButton = new Button("Cancel");

        // mainBox Resize Handle
        AnchorPane.setTopAnchor(mainBox,100.0);
        AnchorPane.setLeftAnchor(mainBox,100.0);
        AnchorPane.setBottomAnchor(mainBox,100.0);
        AnchorPane.setRightAnchor(mainBox,150.0);


        AnchorPane.setBottomAnchor(doneButton,20.0);
        AnchorPane.setRightAnchor(doneButton, 150.0);

        // booking counter Resize Handle
        AnchorPane.setTopAnchor(bookingCounter,20.0);
        AnchorPane.setLeftAnchor(bookingCounter, 120.0);


//        mainBox.setSpacing(15);
        mainBox.setOnMouseClicked(this::handleClick);

        this.getChildren().addAll(bookingCounter,mainBox, doneButton);
    }

    private void handleClick(MouseEvent event) {
        if (mainBox.getSelectionModel().getSelectedItem() != null)
        {
            mainBox.getSelectionModel().getSelectedItem().setOnAction(this::handleDeleteClick);
        }

    }

    private void handleDeleteClick(ActionEvent actionEvent) {
        ArrayList<String> result = new ArrayList<>();

//        System.out.println(mainBox.getSelectionModel().getSelectedItem().getDayString());

        result.add(mainBox.getSelectionModel().getSelectedItem().getTimeString());
        result.add(mainBox.getSelectionModel().getSelectedItem().getDayString());
        result.add(mainBox.getSelectionModel().getSelectedItem().getCourtNumberString());

        controller.handleUnbookingClick(result);
    }

    public void setModel(BookingModel model) {
        this.model = model;
    }

    public void setController(AppController controller) {
        this.controller = controller;
    }

    public void passScene_mainPage(Scene mainScene, MainUI mainUI) {
        this.scene = mainScene;
        this.mainPage = mainUI;
    }

    @Override
    public void modelChanged() {
        BookedInfo tempInfo;
        mainBox.getItems().clear();
        for (int i= 0; i<model.getTotalBooking(); i++)
        {
            tempInfo = model.getCourtBooking(i);
            mainBox.getItems().add(new courtObjectView_withDelete(tempInfo.getNSID(), tempInfo.getTime(), tempInfo.getDate(), tempInfo.getCourtNumber()));
        }
        bookingCounter.setText(model.getTotalBooking()+"/6 Total Booking");
    }


}
