package FH;

import FH.UserInterface.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //var scene = new Scene(new StackPane(label), 640, 480);
        var UiWindow = new TradingWindow();
        stage.setScene(UiWindow.getScene());
        stage.show();
        Alert popUp = new Alert(Alert.AlertType.WARNING);
        popUp.setContentText("WARNING: THIS DOES NOT INVOLVE ACTUAL STOCKS,\nIT IS A SIMULATION SOLELY DESIGNED FOR EDUCATIONAL PURPOSES");
        popUp.show();
    }

    public static void main(String[] args) {
        launch();
    }

}