package com.example.f21comp1011lhassignment2.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class definitionViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Definition!");
    }
}
