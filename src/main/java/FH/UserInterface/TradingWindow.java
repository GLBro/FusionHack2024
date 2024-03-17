package FH.UserInterface;

import backEnd.EventPicker;
import backEnd.Simulation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class TradingWindow {

  private final Scene scene;
  private final HBox materials;
  private final VBox leftMats;
  private final VBox centreMats;
  private final VBox rightMats;
  private final ScrollPane scroller;
  private final VBox layout;
  private final HBox userInfo;
  private final ScrollPane news;
  private final VBox eventStorer;
  private final String username = "Guest";
  private double budget = 10000;
  private final Label userLabel;
  private final Label budgetLabel;

  public TradingWindow() {
    var pane = new BorderPane();
    this.scene = new Scene(pane, 600, 500);
    materials = new HBox(50);
    leftMats = new VBox();
    leftMats.setPrefWidth(200);
    leftMats.fillWidthProperty().setValue(true);
    centreMats = new VBox();
    centreMats.setPrefWidth(200);
    rightMats = new VBox();
    rightMats.setPrefWidth(200);
    //materials.setAlignment(Pos.BOTTOM_CENTER);
    materials.getChildren().add(leftMats);
    materials.getChildren().add(centreMats);
    materials.getChildren().add(rightMats);
    materials.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    materials.setPrefHeight(300);
    scroller = new ScrollPane();
    scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    scroller.setContent(materials);
    scroller.fitToWidthProperty().setValue(true);

    news = new ScrollPane();
    news.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    eventStorer = new VBox();
    eventStorer.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
    eventStorer.setPrefHeight(200);
    news.setContent(eventStorer);
    news.fitToWidthProperty().setValue(true);

    userInfo = new HBox(450);
    userInfo.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    userInfo.setPrefHeight(100);
    userLabel = new Label("User: "+username);
    budgetLabel = new Label("Budget: "+budget);
    userInfo.getChildren().add(userLabel);
    userInfo.getChildren().add(budgetLabel);

    layout = new VBox();
    layout.getChildren().add(userInfo);
    layout.getChildren().add(news);
    layout.getChildren().add(scroller);

    pane.setCenter(layout);

    addNewResource("Food", 5);
    addNewResource("Stone", 10);
    addNewResource("Wood", 7);
    addNewResource("Cloth", 9);

    ArrayList<String> resources = new ArrayList<String>();
    resources.add("Wood");
    resources.add("Stone");
    resources.add("Cloth");
    resources.add("Food");
    ArrayList<Double> changes = new ArrayList<Double>();
    changes.add(5.0);
    changes.add(17.0);
    changes.add(12.0);
    changes.add(8.0);
    addNewEvent("Fire",  resources, changes);
    addNewEvent("Drought",  resources, changes);
    addNewEvent("War",  resources, changes);
    addNewEvent("Tsunami",  resources, changes);
    addNewEvent("Eruption",  resources, changes);
    addNewEvent("PopulationIncrease",  resources, changes);
    addNewEvent("PopulationDecrease",  resources, changes);
    addNewEvent("Disease",  resources, changes);
    addNewEvent("EnvironmentalRiot",  resources, changes);
    addNewEvent("WoodHousing",  resources, changes);
    addNewEvent("StoneHousing",  resources, changes);
    addNewEvent("Roads",  resources, changes);
    addNewEvent("Tornado",  resources, changes);
    addNewEvent("Technology",  resources, changes);
    addNewEvent("Meteor",  resources, changes);
    addNewEvent("Farming",  resources, changes);
    addNewEvent("GoodSeason",  resources, changes);

    cycleEvents();
  }

  public Scene getScene() {
    return scene;
  }

  public void addNewResource(String resource, double cost) {
    String imagePath = "burger.png";
    if (resource.equals("Food")) {
      imagePath = "burger.png";
    } else if (resource.equals("Stone")) {
      imagePath = "stone.png";
    } else if (resource.equals("Wood")) {
      imagePath = "tree.png";
    } else if (resource.equals("Cloth")) {
      imagePath = "cloth.png";
    }
    int leftSize = leftMats.getChildren().size();
    int centreSize = centreMats.getChildren().size();
    int rightSize = rightMats.getChildren().size();
    if (leftSize==centreSize && centreSize==rightSize) {
      leftMats.getChildren().add(new MaterialButton(resource, cost, imagePath));
      leftMats.getChildren().add(new SellButton(resource, cost, imagePath));
    } else if (leftSize==centreSize && rightSize==centreSize-2) {
      rightMats.getChildren().add(new MaterialButton(resource, cost, imagePath));
      rightMats.getChildren().add(new SellButton(resource, cost, imagePath));
    } else {
      centreMats.getChildren().add(new MaterialButton(resource, cost, imagePath));
      centreMats.getChildren().add(new SellButton(resource, cost, imagePath));
    }
  }

  public void addNewEvent(String eventType, ArrayList<String> resources, ArrayList<Double> changes) {
    eventStorer.getChildren().add(new EventBar(eventType, resources, changes));
  }

  public void cycleEvents() {
    Simulation sim = new Simulation();
    String event = sim.getEventName();
    System.out.println(event);
    ArrayList<String> resources = sim.getEventResources();
    for (String resource : resources) {
      System.out.println(resource);
    }
  }


}
