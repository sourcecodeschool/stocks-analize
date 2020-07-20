package main;

import form.SettingsForm;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Portfolio;
import repository.EntityManager;
import repository.PortfolioRepositoryImpl;
import java.io.IOException;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private AnchorPane rightAnchorPane;
    @FXML
    private Button chartsButton;
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



            Portfolio portfolio = new Portfolio();
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
            EntityManager.getInstance();
            PortfolioRepositoryImpl.getInstance();

           // PortfolioRepositoryImpl.create

            Portfolio portfolio1 = new Portfolio(1L,"Brilliant", System.currentTimeMillis());
            Portfolio portfolio2 = new Portfolio(2L,"Bitcoin", System.currentTimeMillis()+1);

            try {
                portfolio1.create(portfolio1);
                portfolio2.create(portfolio2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(EntityManager.portfolioList.get(1).getPortfolioName().toString());


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
//            System.out.println("Кнопка нажата");
//            rightAnchorPane.getChildren().clear();
//            rightAnchorPane.getChildren().add(new Label(" EntityManager.bags.add(bag);\n" +
//                    "        //serialize this EntityManager.bags"));
            rightAnchorPane.getChildren().clear();
            rightAnchorPane.getChildren().add(SettingsForm.getRoot());
        });

        chartsButton.setOnMouseClicked(event -> {
            rightAnchorPane.getChildren().clear();
            rightAnchorPane.getChildren().add(getChartNode());
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


    public Node getChartNode() {
        final NumberAxis xAxis = new NumberAxis(1, 12, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
        areaChart.setTitle("Revenue");
        areaChart.setLegendSide(Side.LEFT);
        XYChart.Series<Number, Number> series2014 = new XYChart.Series<>();
        series2014.setName("2014");
        series2014.getData().add(new XYChart.Data<>(1, 400));
        series2014.getData().add(new XYChart.Data<>(3, 1000));
        series2014.getData().add(new XYChart.Data<>(4, 1500));
        series2014.getData().add(new XYChart.Data<>(5, 800));
        series2014.getData().add(new XYChart.Data<>(7, 500));
        series2014.getData().add(new XYChart.Data<>(8, 1800));
        series2014.getData().add(new XYChart.Data<>(10, 1500));
        series2014.getData().add(new XYChart.Data<>(12, 1300));

        // Series data of 2015
        XYChart.Series<Number, Number> series2015 = new XYChart.Series<>();
        series2015.setName("2015");
        series2015.getData().add(new XYChart.Data<>(1, 2000));
        series2015.getData().add(new XYChart.Data<>(3, 1500));
        series2015.getData().add(new XYChart.Data<>(4, 1300));
        series2015.getData().add(new XYChart.Data<>(5, 1200));
        series2015.getData().add(new XYChart.Data<>(7, 1400));
        series2015.getData().add(new XYChart.Data<>(8, 1080));
        series2015.getData().add(new XYChart.Data<>(10, 2050));
        series2015.getData().add(new XYChart.Data<>(12, 2005));

        areaChart.getData().addAll(series2014, series2015);

        return areaChart;
    }

}

