package backEnd;

import java.util.ArrayList;

public class Simulation {
  private EventPicker eventPicker;
  private ResourceInitialisation resourceInitialisation;
  private Event currentEvent;

  public Simulation(){
    resourceInitialisation = new ResourceInitialisation("resources.txt");
    eventPicker = new EventPicker("eventList.csv", resourceInitialisation);

  }

  // MUST BE CALLED BEFORE getEventResources OTHERWISE currentEvent IS NULL
  public String getEventName(){
    currentEvent = eventPicker.pickEvent();
    return currentEvent.getName();

  }

  public String[] getEventResources(){
    String[] resources = new String[currentEvent.getResourcesAffected().size()];

    for (int i=0; i<currentEvent.getResourcesAffected().size();i++){
      resources[i] = currentEvent.getResourcesAffected().get(i).getName();
    }

    return resources;
  }

  public void changeResourcePrice(){
    int i = 0;
    for(Resource resource: currentEvent.getResourcesAffected()){
      resource.changeCost(currentEvent.getResourceAffectChange()[i]);

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
    return costAndChange;
  }
  // TODO: Need to write simulation functions for selling or buying stocks
  public double buy(Resource resource){
    double price = resource.getCost();
    resource.changeCost(0.5);
    return price;
  }
  public double sell(Resource resource){
    double price = resource.getCost();
    resource.changeCost(-0.5);
    return price;
  }
}
