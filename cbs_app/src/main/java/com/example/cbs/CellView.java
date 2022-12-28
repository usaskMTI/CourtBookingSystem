package com.example.cbs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CellView extends HBox {
    private Label status;
    private Button bookButton;

    public CellView(){
        status = new Label("Available");
        bookButton = new Button("Book");
        bookButton.setMinWidth(80);
        bookButton.setPrefWidth(80);

        this.setSpacing(2);
        this.getChildren().addAll(status,bookButton);
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
    }

    public void setOnAction(EventHandler<ActionEvent> eventHandler){

        bookButton.setOnAction(eventHandler);

    }

    public void setAvailable(boolean available) {
        if (!available)
        {
            status.setText("Unavailable");
            bookButton.setText("N/A");
            bookButton.setDisable(true);

        }
        else {
            status.setText("Available");
            bookButton.setText("Book");
            bookButton.setDisable(false);
        }
    }
}
