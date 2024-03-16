package FH.UserInterface;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class EventBar extends HBox{
  private final VBox labelBox;
  private final Image image;
  public EventBar(String name, String[] resources, String[] changes) {
    labelBox = new VBox();
    this.setStyle("-fx-background-color: maroon; -fx-border-color: black; -fx-border-width: 5");
    if (name.equals("Fire")) {
      image = new Image("fire.png");
    } else {
      image = new Image("fire.png");
    }
    for (int i=0; i< resources.length; i++) {
      labelBox.getChildren().add(new Label(resources[i]+" has changed by "+changes[i]+"%"));
    }
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(50);
    imageView.setPreserveRatio(true);
    this.getChildren().add(imageView);
    this.getChildren().add(labelBox);
  }
}
