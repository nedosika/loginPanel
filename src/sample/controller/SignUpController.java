package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.database.DataBaseHandler;
import sample.database.User;

public class SignUpController {

    @FXML
    public TextField txtLogin;

    @FXML
    public TextField txtEmail;

    @FXML
    public PasswordField txtPassword;

    @FXML
    public PasswordField txtRepeatPassword;

    @FXML
    public Button btnSignUp;

    @FXML
    public Button btnCancel;

    @FXML
    public Label lblError;

    public void onSignUpAction(ActionEvent actionEvent) {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        User user = new User(txtLogin.getText().trim(), txtPassword.getText().trim(), txtEmail.getText().trim());

        if (dataBaseHandler.signUpUser(user)){
            btnSignUp.getScene().getWindow().hide();
        }
        else {
            lblError.setText("Error signUp");
        }
    }

    public void onCancelAction(ActionEvent actionEvent) {
        btnCancel.getScene().getWindow().hide();
    }
}
