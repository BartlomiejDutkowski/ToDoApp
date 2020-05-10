package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Database.DatabaseHandler;
import sample.model.Task;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class AddItemFormController {



    private int userId;

    private DatabaseHandler databaseHandler;

    @FXML
    private Label successLabel;

    @FXML
    private JFXButton todosButton;

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

            String taskText = taskField.getText().trim();
            String taskDescription = descriptionField.getText().trim();

            if (!taskText.equals("") || !taskDescription.equals("")){

                System.out.println("User Id: " + AddItemController.userId);
                task.setUserId(AddItemController.userId);
                task.setDatecreated(timestamp);
                task.setDescription(taskDescription);
                task.setTask(taskText);

                databaseHandler.insertTask(task);

                successLabel.setVisible(true);

                todosButton.setVisible(true);
                int taskNumber = 0;
                try {
                    taskNumber = databaseHandler.getAllTask(AddItemController.userId);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                todosButton.setText("My 2Do's: " + "(" + taskNumber + ")");


                taskField.setText("");
                descriptionField.setText("");

                todosButton.setOnAction(event1 -> {


                });

                // System.out.println("Task został dodany prawidlowo");

            }else{
                System.out.println("Nic nie zostalo dodane");
            }



        });



    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        System.out.println(this.userId);
    }

}
