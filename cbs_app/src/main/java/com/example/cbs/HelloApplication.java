package com.example.cbs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainUI myCBS = new MainUI();
        LoginView CBSLogin = new LoginView();
        Scene scene = new Scene(CBSLogin, 1300 , 800);
        myCBS.passScene(scene);
        CBSLogin.passScene(scene);
        CBSLogin.storeMainUI(myCBS);

        stage.setTitle("University of Saskatchewan CBS!");
        stage.setScene(scene);
        stage.setMinWidth(720);
        stage.setMinHeight(500);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}