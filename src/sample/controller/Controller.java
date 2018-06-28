package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.database.DataBaseHandler;
import sample.database.User;

import java.io.IOException;

public class Controller {
    @FXML
    public TextField txtLogin;

    @FXML
    public PasswordField txtPassword;

    @FXML
    public Label lblError;

    @FXML
    public Button btnSignIn;

    @FXML
    public Button btnSettings;

    public void onBtnSignInAction(ActionEvent actionEvent) {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        User user = new User(txtLogin.getText().trim(), txtPassword.getText().trim());


        if (dataBaseHandler.signInUser(user)){
            System.out.println("login ok!");
            btnSignIn.getScene().getWindow().hide();
            User.setCurrentUser(user);
            showApplication();
        }
        else {
            System.out.println("login failed");
            lblError.setVisible(true);
            lblError.setText("login failed");
        }

    }

    public void onBtnSettingsAction(ActionEvent actionEvent) {
        btnSettings.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/settings.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/sample/assets/settings.png"));
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void onBtnSignUpAction(ActionEvent actionEvent) {
        System.out.println("tst");
    }

    private void showApplication(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/application.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Hello " + User.getCurrentUser().getLogin());
        stage.getIcons().add(new Image("/sample/assets/home.png"));
        stage.setMaximized(true);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void txtLoginPasswordOnKeyPressed(KeyEvent keyEvent) {
        if(!txtLogin.getText().equals("") && !txtPassword.getText().equals("")){
            btnSignIn.setDisable(false);
        }
        else{
            btnSignIn.setDisable(true);
        }
    }
}
