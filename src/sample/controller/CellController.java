package sample.controller;

import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.model.Task;

import java.io.IOException;

public class CellController extends JFXListCell<Task> {

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ImageView iconImageView;

    @FXML
    private Label taskLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private ImageView deleteButton;

    private FXMLLoader fxmlLoader;
    @FXML
    void initialize() {

    }

    @Override
    public void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);

        if(empty || myTask == null) {
            setText(null);
            setGraphic(null);
        }else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/cell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            taskLabel.setText(myTask.getTask());
            dateLabel.setText(myTask.getDatecreated().toString());
            descriptionLabel.setText(myTask.getDescription());
            iconImageView.setVisible(true);
            deleteButton.setVisible(true);

            setText(null);
            setGraphic(rootAnchorPane);

        }
    }
}
