package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Bags;
import repository.EntityManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane mainForm;
    @FXML
    private SplitPane splitPane;
    @FXML
    private Button portfolioButton;
    @FXML
    private Button AddPortfolio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fix divider position
        SplitPane.Divider divider = splitPane.getDividers().get(0);
        divider.positionProperty().addListener((observableValue, number, t1) -> {
            divider.setPosition(0.3);
        });


        portfolioButton.setOnMouseClicked(event -> {
            System.out.println("Нажата кнопка портфели");



            Bags bags = new Bags();
//            try {
//                try {
//                    bags = bags.getBag();
//                    System.out.println(bags.getPortfolioName());
//                    System.out.println(bags.getPortfolioId());
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            // Попытка сделать сериализацию и десериализацию через список ArrayList
//            Bags bagsList = new Bags();
//            try {
//                try {
//                    bagsList.getBag();
//                    System.out.println(bagsList.g);
//                    System.out.println(bags.getPortfolioId());
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Список портфелей:");
//            EntityManager entityManager = new EntityManager();
//            entityManager.GetBagsList();
//        });
        });
        AddPortfolio.setOnMouseClicked(event -> {
            System.out.println("Нажата кнопка добавить портфель");
            Bags bag = new Bags(3L,"Brillianti", System.currentTimeMillis());
//            try {
//                bag.CreateBag(bag);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            // Попытка сделать сериализацию и десериализацию через список ArrayList
//            ArrayList<Object> bags = new ArrayList<Object>();
//            Bags bag1 = new Bags(1L,"Bitcoin", System.currentTimeMillis();
//            bags.add(bag1);
//            Bags bag2 = new Bags(2L,"Brillianti", System.currentTimeMillis());
//            bags.add(bag2);
//            Bags bag3 = new Bags(3L,"Sberbank", System.currentTimeMillis());
//            bags.add(bag3);
//            try {
//                Bags.CreateBagsList(bags);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //this.showPortfolioForm();
        });

        //this.showPortfolioForm();

        Pane pane = new Pane();
//        pane.setStyle("-fx-background-color:red;");
        pane.getStyleClass().add("bag");
        pane.setPrefSize(100,100);
        pane.setLayoutX(600);
        mainForm.getChildren().add(pane);

        //EntityManager.getInstance().updateBag();
    }

    public Controller() {
        Main.controller = this;
    }
}

