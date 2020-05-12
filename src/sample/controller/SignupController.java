package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpFirstName;

    @FXML
    private JFXTextField signUpLastName;

    @FXML
    private JFXTextField signUpUsername;

    @FXML
    private JFXCheckBox signUpCheckBoxMale;

    @FXML
    private JFXCheckBox signUpCheckBoxFemale;

    @FXML
    private JFXPasswordField signUpPassword;

    @FXML
    private JFXTextField signUpLocation;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event -> {
            createUser();
            AnchorPane formPane = null;
            try {
                formPane = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(formPane);
        });

    }

    private void createUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = signUpFirstName.getText();
        String lastName = signUpLastName.getText();
        String userName = signUpUsername.getText();
        String password = signUpPassword.getText();
        String location = signUpLocation.getText();

        String gender = "";
        if (signUpCheckBoxFemale.isSelected()) {
            gender = "Kobieta";
        } else gender = "Mężczyzna";

        User user = new User(name, lastName, userName, password, location, gender);

        databaseHandler.signUpUser(user);

    }
}
