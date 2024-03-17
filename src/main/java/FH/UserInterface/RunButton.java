package FH.UserInterface;

import backEnd.Resource;
import backEnd.Simulation;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class RunButton implements Runnable{
  private Simulation sim;
  public RunButton(Simulation simulation) {
    sim = simulation;
  }
  @Override
  public synchronized void run() {
    for (MaterialButton m : TradingWindow.mButtons) {
      String[] a = m.getText().split("\n");
      String b = a[0];
      String[] c = b.split(" ");
      String name = c[1];
      Resource resource = TradingWindow.sim.getResource(name);
      m.setText("Buy "+name+"\n"+round(resource.getCost(),2)+" coins\n"+round(resource.getPercentChange(), 2)+"% Amount "+sim.getAmount(name));
    }
    for (SellButton s : TradingWindow.sButtons) {
      String[] a = s.getText().split("\n");
      String b = a[0];
      String[] c = b.split(" ");
      String name = c[1];
      Resource resource = TradingWindow.sim.getResource(name);
      s.setText("Sell "+name+"\n"+round(resource.getCost(),2)+" coins\n"+round(resource.getPercentChange(), 2)+"% Amount "+sim.getAmount(name));
    }
    PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
    pause.setOnFinished(e -> run());
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
