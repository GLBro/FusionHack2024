package FH.UserInterface;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class RunApplication implements Runnable{

  @Override
  public synchronized void run() {
    TradingWindow.sim.automation.hundredBuy();
    PauseTransition pause = new PauseTransition(Duration.seconds(5));
    pause.setOnFinished(e -> {
      run();
    });
    pause.play();
  }
}
