package FH.UserInterface;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class RunApplication implements Runnable{

  @Override
  public void run() {
    TradingWindow.sim.automation.hundredBuy();
    PauseTransition pause = new PauseTransition(Duration.seconds(10));
    pause.setOnFinished(e -> {
      System.out.println("LOOOL");
      run();
    });
    pause.play();
  }
}
