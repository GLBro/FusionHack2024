package FH.UserInterface;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SellButton extends Button {
  private final String buttonName;
  public SellButton(String text, double price, String imageName) {
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
  }

  private void pressed() {
    this.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-border-width: 7");
    PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
    pause.setOnFinished(e -> {
      this.setStyle("-fx-border-color: black; -fx-background-color: pink; -fx-border-width: 7");
    });
    pause.play();
  }

  public void updateCosts(double newCost, double newPercentage ) {
    this.setText(buttonName+"\n"+newCost+" coins\n"+newPercentage+"%");
  }

}
