package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Active;
import model.Bags;

import java.sql.SQLOutput;

public class Main extends Application {

    static Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/main.fxml"));
        primaryStage.setTitle("My investment");
        Scene scene = new Scene(root, 600,400);
        scene.getStylesheets().add(getClass().getResource("../resources/css/style.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
