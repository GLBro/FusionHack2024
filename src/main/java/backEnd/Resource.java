package backEnd;
public class Resource {
  private final String name;
  private double cost;
  private double lastCost;


  public Resource(String name){
    this.name = name;
    this.cost = 25.00;
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

  public double calculateChange(){
    /*  TODO: calculate the % change from the ORIGINAL cost, stored in lastCost
          Need to do this to send to the front end
          Will use the function(s) from Event, getResourcesAffected and getResourceAffectChange
     */
    return 0.00;
  }

}
