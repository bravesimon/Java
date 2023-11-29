package com.example.formula1app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Formula1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Formula1.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 640);

        stage.setTitle("Formula1 adatbazis");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}