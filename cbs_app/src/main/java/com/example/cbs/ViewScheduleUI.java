package com.example.cbs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ViewScheduleUI extends AnchorPane implements ModelListener {
    private VBox todayDate;
    private ListView<CourtObjectView> todayList;
    private VBox futureDate;
    private ListView<CourtObjectView> futureList;
    private Button backButton;
    private Label totalBooking;
    private BookingModel model;
    private AppController controller;
    private Scene scene;
    private MainUI mainPage;


    public ViewScheduleUI(){

        totalBooking = new Label("0/6 Total Booking");
        backButton = new Button("Back");

        todayDate = new VBox();
        todayList = new ListView<>();
        Label todayTitle = new Label("Today's Bookings (Considering Today is Sunday)");

        futureDate = new VBox();
        futureList = new ListView<>();
        Label futureTitle = new Label("Future Bookings (All the other dates)");




        todayList.setMinSize(200,300);
        todayList.setMaxSize(550,650);

        futureList.setMinSize(200,300);
        futureList.setMaxSize(550,650);
        futureList.setPrefSize(500,600);
        todayList.setPrefSize(500,600);




        todayDate.getChildren().addAll(todayTitle,todayList);
        futureDate.getChildren().addAll(futureTitle, futureList);

//        todayDate.setPadding(new Insets(50,10,0,20));
//        futureDate.setPadding(new Insets(50,0,10,20));

        AnchorPane.setLeftAnchor(todayDate,50.0);
        AnchorPane.setTopAnchor(todayDate,80.0);
        AnchorPane.setRightAnchor(todayDate, 500.0);
        AnchorPane.setBottomAnchor(todayDate,70.0);


        AnchorPane.setRightAnchor(futureDate,80.0);
        AnchorPane.setTopAnchor(futureDate,80.0);
        AnchorPane.setLeftAnchor(futureDate, 650.0);
        AnchorPane.setBottomAnchor(futureDate,70.0);

        AnchorPane.setRightAnchor(backButton,50.0);
        AnchorPane.setBottomAnchor(backButton,40.0);

        AnchorPane.setLeftAnchor(totalBooking, 300.0);
        AnchorPane.setRightAnchor(totalBooking, 50.0);
        AnchorPane.setTopAnchor(totalBooking, 50.0);

        backButton.setOnAction(e -> this.scene.setRoot(mainPage));
        this.getChildren().addAll(totalBooking, todayDate,futureDate,backButton);

    }

    public void setModel(BookingModel model) {
        this.model = model;
    }

    public void setController(AppController controller) {
        this.controller = controller;
    }

    @Override
    public void modelChanged() {
        BookedInfo tempInfo;
        todayList.getItems().clear();
        futureList.getItems().clear();
        for (int i= 0; i<model.getTotalBooking(); i++)
        {
            tempInfo = model.getCourtBooking(i);
            if (tempInfo.getDate().equals("Sunday"))
            {
                todayList.getItems().add(new CourtObjectView(tempInfo.getNSID(),tempInfo.getTime(),tempInfo.getDate(),tempInfo.getCourtNumber()));
            }
            else
            {
                futureList.getItems().add(new CourtObjectView(tempInfo.getNSID(),tempInfo.getTime(),tempInfo.getDate(),tempInfo.getCourtNumber()));
            }
        }
        totalBooking.setText(model.getTotalBooking()+"/6 Total Booking");
    }

    public void passScene_mainPage(Scene mainScene, MainUI mainUI) {
        this.scene = mainScene;
        this.mainPage = mainUI;
    }
}
