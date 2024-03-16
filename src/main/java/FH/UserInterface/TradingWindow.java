package FH.UserInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    leftMats.getChildren().add(new MaterialButton("Food", 5, "burger.png"));
    centreMats = new VBox();
    centreMats.setPrefWidth(200);
    centreMats.getChildren().add(new Label("CENTRE"));
    centreMats.getChildren().add(new Label("CENTRE2"));
    rightMats = new VBox();
    rightMats.setPrefWidth(200);
    rightMats.getChildren().add(new Label("RIGHT"));
    rightMats.getChildren().add(new Label("RIGHT2"));
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
  }

  public Scene getScene() {
    return scene;
  }
}
