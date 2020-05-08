package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.Database.DatabaseHandler;
import sample.model.Task;

import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class AddItemFormController {

    private DatabaseHandler databaseHandler;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField taskField;

    @FXML
    private JFXTextField descriptionField;

    @FXML
    private JFXButton saveTaskButton;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(event -> {

            Task task = new Task();

            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());


            task.setDatecreated(timestamp);
            task.setDescription("My first task");
            task.setTask("Make this work!");

            databaseHandler.insertTask(task);
        });



    }



}
