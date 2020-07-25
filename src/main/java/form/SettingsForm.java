package form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Active;
import model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class SettingsForm {

    public static Node getRoot() {
        AnchorPane root = new AnchorPane();
        VBox vBox = new VBox();
        AnchorPane.setLeftAnchor(root,0.);
        AnchorPane.setTopAnchor(root,0.);
        AnchorPane.setRightAnchor(root,0.);
        AnchorPane.setBottomAnchor(root,0.);

         Button activeButton = new Button("Редактор активов");
        activeButton.setOnMouseClicked(event -> {
            root.getChildren().clear();
            root.getChildren().add(getActiveEditForm());
        });

        vBox.getChildren().add(activeButton);

        root.getChildren().add(vBox);
        return root;
    }

    public static Node getRoot(List<Portfolio> portfolios) {
        Portfolio portfolio = new Portfolio();

        AnchorPane root = new AnchorPane();
        VBox vBox = new VBox();
        AnchorPane.setLeftAnchor(root,0.);
        AnchorPane.setTopAnchor(root,0.);
        AnchorPane.setRightAnchor(root,0.);
        AnchorPane.setBottomAnchor(root,0.);

        Button activeButton = new Button("Редактор активов");
        activeButton.setOnMouseClicked(event -> {
            root.getChildren().clear();
            root.getChildren().add(getActiveEditForm());
        });

        vBox.getChildren().add(activeButton);

        root.getChildren().add(vBox);
        return root;
    }

    private static Node getActiveEditForm() {
        List<String> strings = new ArrayList<>();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.setId("Active getID");
        hBox.setOnMouseEntered(mouseEvent -> {
            hBox.setStyle("-fx-background-color: #ccc;");
        });
        hBox.setOnMouseExited(mouseEvent -> {
            hBox.setStyle("-fx-background-color: transparent;");
        });
        hBox.setOnMouseClicked(mouseEvent -> {
            hBox.setStyle("-fx-border-color: black;-fx-border-width: 1px;");
            strings.add(hBox.getId());
        });
        hBox.getChildren().add(new Label("Редактор "));
        hBox.getChildren().add(new Label("новых "));
        hBox.getChildren().add(new Label("активов"));
        vBox.getChildren().add(hBox);

        HBox buttonBox = new HBox();
        Button createButton = new Button("Создать");
        createButton.setOnMouseClicked(event -> {
            vBox.getChildren().clear();
            vBox.getChildren().add(getCreateActiveForm());
        });

        Button showButton = new Button("Редактировать текущщий актив");
        showButton.setOnMouseClicked(event -> {
            strings.forEach(s -> {
                System.out.println(s);
            });
        });

        buttonBox.getChildren().add(createButton);
        buttonBox.getChildren().add(showButton);
        vBox.getChildren().add(buttonBox);
        return vBox;
    }

    private static Node getCreateActiveForm() {
        VBox vBox = new VBox();
        AnchorPane.setLeftAnchor(vBox,15.);
        AnchorPane.setTopAnchor(vBox,15.);
        AnchorPane.setRightAnchor(vBox,null);
        AnchorPane.setBottomAnchor(vBox,15.);
        Label fundLabel = new Label("Фонд");
        fundLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        TextField fundTF = new TextField();
        Label nameLabel = new Label("Название");
        nameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        TextField nameTF = new TextField();
        Label rateLabel = new Label("Ставка");
        rateLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        TextField rateTF = new TextField();

        vBox.getChildren().add(fundLabel);
        vBox.getChildren().add(fundTF);
        vBox.getChildren().add(nameLabel);
        vBox.getChildren().add(nameTF);
        vBox.getChildren().add(rateLabel);
        vBox.getChildren().add(rateTF);
        return vBox;


    }

    private static Node getEditActiveForm(Active active) {
        VBox vBox = new VBox();
        AnchorPane.setLeftAnchor(vBox,15.);
        AnchorPane.setTopAnchor(vBox,15.);
        AnchorPane.setRightAnchor(vBox,null);
        AnchorPane.setBottomAnchor(vBox,15.);
        Label fundLabel = new Label("Фонд");
        TextField fundTF = new TextField(active.getFund());
        Label nameLabel = new Label("Название");
        TextField nameTF = new TextField();
        Label rateLabel = new Label("Ставка");
        TextField rateTF = new TextField();
        vBox.getChildren().add(fundLabel);
        vBox.getChildren().add(fundTF);
        vBox.getChildren().add(nameLabel);
        vBox.getChildren().add(nameTF);
        vBox.getChildren().add(rateLabel);
        vBox.getChildren().add(rateTF);
        return vBox;
    }

}
