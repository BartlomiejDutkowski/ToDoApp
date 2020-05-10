package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController {

    @FXML
    private JFXListView<String> listTask;

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXTextField listDescriptionField;

    @FXML
    private JFXButton listSaveTaskButton;
    ObservableList<String> listview = FXCollections.observableArrayList("John","Paulo","Bond","Java","Android");

    @FXML
    void initialize() {
        listTask.setItems(listview);

    }
}

