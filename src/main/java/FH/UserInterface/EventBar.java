package FH.UserInterface;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class EventBar extends HBox{
  private final VBox labelBox;
  private final Image image;
  private final Label description;
  public EventBar(String name, ArrayList<String> resources, ArrayList<Double> changes) {
    labelBox = new VBox();
    this.setStyle("-fx-background-color: maroon; -fx-border-color: black; -fx-border-width: 5");
    if (name.equals("Fire")) {
      image = new Image("fire.png");
      description = new Label("A forest fire has broken out!");
    } else if (name.equals("Drought")) {
      image = new Image("sun.png");
      description = new Label("A drought has occured!");
    } else if (name.equals("War")) {
      image = new Image("swords.png");
      description = new Label("War has broken out!");
    } else if (name.equals("Tsunami")) {
      image = new Image("wave.png");
      description = new Label("A tsunami has hit!");
    } else if (name.equals("Eruption")) {
      image = new Image("volcano.png");
      description = new Label("A volcano has erupted!");
    } else if (name.equals("PopulationIncrease")) {
      image = new Image("person.png");
      description = new Label("A population boom has occurred, prepare for the next generation!");
    } else if (name.equals("PopulationDecrease")) {
      image = new Image("person.png");
      description = new Label("The population is declining at a rapid rate, everyone is dying!");
    } else if (name.equals("EnvironmentalRiot")) {
      image = new Image("person.png");
      description = new Label("Some vegans are complaining about the environment and causing a ruckus!");
    } else if (name.equals("Disease")) {
        image = new Image("death.png");
        description = new Label("Pandemic Time!");
    } else if (name.equals("Roads")) {
      image = new Image("hammer.png");
      description = new Label("We built some roads!");
    } else if (name.equals("Tornado")) {
      image = new Image("tornado.png");
      description = new Label("A tornado has struck!");
    } else if (name.equals("Technology")) {
      image = new Image("person.png");
      description = new Label("Large technological advances have been made, NERDS!");
    } else if (name.equals("WoodHousing")) {
      image = new Image("hammer.png");
      description = new Label("Some wooden houses have been built, fair enough in this economy!");
    } else if (name.equals("StoneHousing")) {
      image = new Image("hammer.png");
      description = new Label("Some stone houses have been built, the economy is recovering!");
    } else if (name.equals("Meteor")) {
      image = new Image("meteor.png");
      description = new Label("A meteor has struck, try not to go extinct!");
    } else if (name.equals("Farming")) {
      image = new Image("sapling.png");
      description = new Label("Lots of farms have been built, hope you like the countryside!");
    } else if (name.equals("GoodSeason")) {
      image = new Image("sapling.png");
      description = new Label("Farming has been very successful this harvest!");
    } else {
      image = new Image("person.png");
      description = new Label("Something has happened!");
    }
    labelBox.getChildren().add(description);
    for (int i=0; i< resources.size(); i++) {
      labelBox.getChildren().add(new Label(resources.get(i)+" has changed by "+changes.get(i)+"%"));
    }
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(50);
    imageView.setPreserveRatio(true);
    this.getChildren().add(imageView);
    this.getChildren().add(labelBox);
  }
}
