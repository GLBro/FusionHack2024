package backEnd;
public class Resource {
  private final String name;
  private double cost;
  private double lastCost;
  private double percentChange;


  public Resource(String name){
    this.name = name;
    this.cost = 25.00;
    this.percentChange = 0.00;
  }

  public void setLastCost() {
    this.lastCost = this.cost;
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
    this.cost *= (1+change/10);
    this.percentChange = (this.cost/this.lastCost)*100;
  }

}
