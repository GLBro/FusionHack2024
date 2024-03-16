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

  public TradingWindow() {
    var pane = new BorderPane();
    this.scene = new Scene(pane, 600, 500);
    materials = new HBox(50);
    leftMats = new VBox();
    leftMats.setPrefWidth(200);
    leftMats.getChildren().add(new Label("LEFT"));
    leftMats.getChildren().add(new Label("LEFT2"));
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
    pane.setBottom(scroller);
  }

  public Scene getScene() {
    return scene;
  }
}
