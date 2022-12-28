package com.example.cbs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

    private Scene mainScene;
    private MainUI mainPage;
    private TextField userField;

    public LoginView(){
        Label welcome = new Label("The University of Saskatchewan CBS");
        welcome.setStyle("-fx-font-weight: bold");
        HBox userBox = new HBox();
        HBox passwordBox = new HBox();
        Button loginButton = new Button("Login");

        Label userName = new Label("Please enter your NSID:");
        userField = new TextField("");
        userField.setPromptText("NSID");

        userBox.getChildren().addAll(userName,userField);

        Label password = new Label("Please enter your password:");
        TextField passwordField = new TextField("");
        passwordField.setPromptText("Password");

        passwordBox.getChildren().addAll(password,passwordField);

        loginButton.setOnAction(e ->loginAction());
        userBox.setSpacing(5);
        userBox.setAlignment(Pos.CENTER);
        passwordBox.setSpacing(5);
        passwordBox.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.getChildren().addAll(welcome,userBox,passwordBox, loginButton);


    }

    public void loginAction(){
//        System.out.println(this.userField.getText());
        this.mainPage.passNSID(this.userField.getText());
        this.mainScene.setRoot(this.mainPage);
    }


    public void passScene(Scene scene) {
        this.mainScene = scene;

    }

    public void storeMainUI(MainUI mainUI) {
        this.mainPage = mainUI;
    }
}
