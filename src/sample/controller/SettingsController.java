package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.database.Config;

import java.util.ResourceBundle;

public class SettingsController {

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtDbLogin;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtDbHost;

    @FXML
    private TextField txtDbPassword;

    @FXML
    private TextField txtDbPort;

    @FXML
    private TextField txtDbName;

    @FXML
    void btnSaveAction(ActionEvent event) {
        Config.setProperties(
                txtDbHost.getText(),
                txtDbPort.getText(),
                txtDbName.getText(),
                txtDbLogin.getText(),
                txtDbPassword.getText());
        Config.save();

        btnSave.getScene().getWindow().hide();
    }

    @FXML
    void btnCancelAction(ActionEvent event) {
        btnCancel.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        txtDbHost.setText(Config.DB_HOST);
        txtDbLogin.setText(Config.DB_USER);
        txtDbName.setText(Config.DB_NAME);
        txtDbPassword.setText(Config.DB_USER_PASSWORD);
        txtDbPort.setText("" + Config.DB_PORT);
    }
}
