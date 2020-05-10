package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import sample.model.Task;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ListController {

    @FXML
    private JFXListView<Task> listTask;

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXTextField listDescriptionField;

    @FXML
    private JFXButton listSaveTaskButton;

    private ObservableList<Task> tasks;

    @FXML
    void initialize() {

        Task myTask = new Task();
        myTask.setTask("umyj samochod");
        myTask.setDescription("Dzis!");
        myTask.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));

        Task myTask2 = new Task();
        myTask2.setTask("umyj podłogi");
        myTask2.setDescription("Dzis!");
        myTask2.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));


        tasks =FXCollections.observableArrayList();

        tasks.addAll(myTask, myTask2);


        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());



    }


}


