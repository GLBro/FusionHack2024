package backEnd;
public class Resource {
  private final String name;
  private double cost;
  private final double lastCost = 25;
  private double percentChange;


  public Resource(String name){
    this.name = name;
    this.cost = 25.00;
    this.percentChange = 0.00;
  }


  public void setCost(double cost) {
    this.cost = cost;
  }

  public double getLastCost() {
    return lastCost;
  }

  public String getName() {
    return name;
  }

  public void changeCost(double change){
    this.cost *= (1+change/100);
    this.percentChange = (this.cost/this.lastCost-1)*100;
  }
  public double getCost(){
    return this.cost;
  }

  public double getPercentChange() {
    return percentChange;
  }
}
