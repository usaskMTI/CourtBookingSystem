package com.example.cbs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainUI extends VBox {
    private Button bookBtn;
    private Button cancelBtn;
    private Button viewBtn;
    private Scene mainScene;
    private String NSID;
    private BookingModel model;
    public MainUI(){

        // create MVC components
        BookingTabUI bookView= new BookingTabUI();
        ViewScheduleUI scheduleView = new ViewScheduleUI();
        CancelBookingUI cancelView = new CancelBookingUI();

        model = new BookingModel();
        AppController controller = new AppController();

        // connect components
        bookView.setModel(model);
        bookView.setController(controller);

        scheduleView.setModel(model);
        scheduleView.setController(controller);

        cancelView.setModel(model);
        cancelView.setController(controller);


        model.addSubscriber(bookView);
        model.addSubscriber(scheduleView);
        model.addSubscriber(cancelView);

        controller.setModel(model);
        // end

        bookBtn = new Button("Book");
        bookBtn.setOnMouseClicked(e ->
        {
//            System.out.println("Clicked Booking");
            this.mainScene.setRoot(bookView);
            bookView.passScene_mainPage(this.mainScene, this);
        });

        viewBtn = new Button("View Schedule");
        viewBtn.setOnAction(e ->
        {
//            System.out.println("Clicked View");
            this.mainScene.setRoot(scheduleView);
            scheduleView.passScene_mainPage(this.mainScene, this);
        });

        cancelBtn = new Button("Cancel Booking");
        cancelBtn.setOnAction(e ->
        {
//            System.out.println("Clicked Cancel");
            this.mainScene.setRoot(cancelView);
            cancelView.passScene_mainPage(this.mainScene, this);
        });

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().addAll(bookBtn, viewBtn, cancelBtn);
    }


    public void passScene(Scene passScene) {
        this.mainScene = passScene;
    }

    public void passNSID(String NSID)
    {

        this.NSID = NSID;
        model.setNSID(NSID);


    }
}
