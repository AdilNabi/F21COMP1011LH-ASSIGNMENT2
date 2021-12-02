package com.example.f21comp1011lhassignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("word-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(getClass().getResourceAsStream("images/icon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Search Word View");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


// Icon sourced from https://www.iconfinder.com/icons/173928/dictionary_icon

// link for word to populate JSON file if it is filled with invalid data https://api.dictionaryapi.dev/api/v2/entries/en/hello