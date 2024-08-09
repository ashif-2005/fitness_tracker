package com.example.fit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    void handleGetStarted(){
        HelloApplication.stage_var.setTitle("Login");
        HelloApplication.stage_var.setScene(HelloApplication.login);
    }
}