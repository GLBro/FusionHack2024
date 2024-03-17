package FH.UserInterface;

import backEnd.Simulation;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SellButton extends Button {
  private final String buttonName;
  public SellButton(String text, double price, String imageName, Simulation sim, TradingWindow tw) {
    super("Sell "+text+"\n"+price+" coins\n0.0%");
    buttonName = text;
    ImageView imageView = new ImageView();
    Image image = new Image(imageName);
    imageView.setImage(image);
    imageView.setFitHeight(20);
    imageView.setPreserveRatio(true);
    this.setGraphic(imageView);
    this.setContentDisplay(ContentDisplay.LEFT);
    this.setMaxWidth(200);
    this.setStyle("-fx-border-color: black; -fx-background-color: pink; -fx-border-width: 5" );
    this.setOnAction(e -> this.pressed());
    this.setOnMouseEntered(e -> this.setStyle("-fx-border-color: black; -fx-background-color: pink; -fx-border-width: 7"));
    this.setOnMouseExited(e -> this.setStyle("-fx-border-color: black; -fx-background-color: pink; -fx-border-width: 5"));
    this.setOnAction(e -> {
      sim.sell(sim.getResource(text));
      tw.setBudget(sim.getBudget());
      this.setText("Sell "+text+"\n"+round(sim.getResource(text).getCost(),2)+" coins\n"+round(sim.getResource(text).getPercentChange(), 2)+"%");
    });
  }

  private void pressed() {
    this.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-border-width: 7");
    PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
    pause.setOnFinished(e -> {
      this.setStyle("-fx-border-color: black; -fx-background-color: pink; -fx-border-width: 7");
    });
    pause.play();
  }
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }

}
