package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.database.User;

public class ApplicationController {

    @FXML
    public Label labelStatusBar;

    @FXML
    void initialize() {
        labelStatusBar.setText("Hello " + User.getCurrentUser().getLogin());
    }
}
