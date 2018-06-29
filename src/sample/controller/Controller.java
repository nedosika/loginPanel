package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.database.DataBaseHandler;
import sample.database.User;

import java.io.IOException;
import java.util.Optional;

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
        //btnSettings.getScene().getWindow().hide();
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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(280);
        stage.setMinWidth(480);
        stage.showAndWait();
    }

    public void onBtnSignUpAction(ActionEvent actionEvent) {
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
        stage.setOnCloseRequest(e ->{
            e.consume();
            closeApplication(stage);
        });
        stage.showAndWait();
    }

    private void closeApplication(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Do you want to exit?",
                ButtonType.YES, ButtonType.NO);

        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            //... user chose YES
            stage.close();
        } else {
            //... user chose NO or closed the dialog
        }
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
