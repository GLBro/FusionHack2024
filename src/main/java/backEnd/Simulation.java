package backEnd;

import FH.UserInterface.MaterialButton;
import FH.UserInterface.SellButton;

import java.util.ArrayList;

public class Simulation {
  private EventPicker eventPicker;
  private ResourceInitialisation resourceInitialisation;
  private Event currentEvent;
  private int wood = 0;
  private int food = 0;
  private int stone = 0;
  private int cloth = 0;
  private double budget = 1000.00;

  public Simulation(){
    resourceInitialisation = new ResourceInitialisation("newResources.xml");
    eventPicker = new EventPicker("newEventList.xml", resourceInitialisation);
    Automation automation = new Automation(resourceInitialisation.getResources(),this);
  }

  // MUST BE CALLED BEFORE getEventResources OTHERWISE currentEvent IS NULL
  public String getEventName(){
    currentEvent = eventPicker.pickEvent();
    return currentEvent.getName();

  }

  public ArrayList<String> getEventResources(){
    ArrayList<String> eventResources = new ArrayList<>();
    ArrayList<Resource> resourcesAffected = currentEvent.getResourcesAffected();
    for(Resource resource : resourcesAffected) {
      eventResources.add(resource.getName());
    }

    return eventResources;
  }

  public void changeResourcePrice(){
    int i = 0;
    for(Resource resource: currentEvent.getResourcesAffected()){
      resource.changeCost(currentEvent.getResourceAffectChange().get(i));

      i++;
    }
  }

  public String[] getResourceNames(){
    ArrayList<Resource> resources;
    resources = resourceInitialisation.getResources();
    String[] resourceNames = new String[resources.size()];
    for (int i=0;i<resources.size();i++){
      resourceNames[i] = resources.get(i).getName();
    }
    return resourceNames;
  }

  public double[][] getResourceCostAndChange(){
    ArrayList<Resource> resources = resourceInitialisation.getResources();
    double[][] costAndChange = new double[resources.size()][2];
    for (int i =0;i<resources.size();i++){
      costAndChange[i][0] = resources.get(i).getCost();
      costAndChange[i][1] = resources.get(i).getPercentChange();
    }
    return costAndChange;
  }

  public double buy(Resource resource){
    String name = resource.getName();
    double price = resource.getCost();
    resource.changeCost(0.5);
    if (name.equals("Wood")){
      wood++;
      System.out.println(wood);
    } else if (name.equals("Food")) {
      food++;
      System.out.println(food);
    }
    else if (name.equals("Stone")) {
      stone++;
      System.out.println(stone);
    }
    else if (name.equals("Cloth")) {
      cloth++;
      System.out.println(cloth);
    }
    budget -= price;
    return price;
  }
  public double sell(Resource resource){
    String name = resource.getName();
    int count = 0;
    if (name.equals("Wood")){
      count = wood;
      System.out.println(count);
    } else if (name.equals("Food")) {
      count = food;
      System.out.println(count);
    }
    else if (name.equals("Stone")) {
      count = stone;
      System.out.println(count);
    }
    else if (name.equals("Cloth")) {
      count = cloth;
      System.out.println(count);
    }
    if (count>=1){
      double price = resource.getCost();
      resource.changeCost(-0.5);
      if (name.equals("Wood")){
        wood--;
        System.out.println(wood);
      } else if (name.equals("Food")) {
        food--;
        System.out.println(food);

      }
      else if (name.equals("Stone")) {
        stone--;
        System.out.println(stone);
      }
      else if (name.equals("Cloth")) {
        cloth--;
        System.out.println(cloth);
      }

      budget += price;
      return price;
    }
    else{
      return 0;
    }
  }

  public Resource getResource(String name) {
    return resourceInitialisation.fromName(name);
  }
  public double autoBuy(Resource resource){
    double price = resource.getCost();
    resource.changeCost(0.5);
    return price;
  }
  public double autoSell(Resource resource){
    double price = resource.getCost();
    resource.changeCost(-0.5);
    return price;
  }

  public double getBudget() {
    return budget;
  }

  public void setBudget(double budget) {
    this.budget = budget;
  }
}
