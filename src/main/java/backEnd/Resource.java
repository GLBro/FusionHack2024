package backEnd;

public class Resource {
  private String name;
  private double price;
  private double lastPrice;
  private double percentChange;

  public double getLastPrice() {
    return lastPrice;
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setLastPrice(double lastPrice) {
    this.lastPrice = lastPrice;
  }


}
