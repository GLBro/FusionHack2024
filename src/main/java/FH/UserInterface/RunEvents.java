package FH.UserInterface;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class RunEvents implements Runnable{
  @Override
  public synchronized void run() {
    TradingWindow.cycleEvents();
    PauseTransition pause = new PauseTransition(Duration.seconds(15));
    pause.setOnFinished(e -> {
      run();
    });
    pause.play();
    TradingWindow.news.setVvalue(TradingWindow.news.getVmax());
  }


}
