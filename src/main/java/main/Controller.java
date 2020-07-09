package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane mainForm;
    @FXML
    private SplitPane splitPane;
    @FXML
    private Button portfolioButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fix divider position
        SplitPane.Divider divider = splitPane.getDividers().get(0);
        divider.positionProperty().addListener((observableValue, number, t1) -> {
                divider.setPosition(0.3);
        });

        portfolioButton.setOnMouseClicked(event -> {
            System.out.println("Кнопка нажата");
        });

    }

    public Controller() {
        Main.controller = this;
    }
}
