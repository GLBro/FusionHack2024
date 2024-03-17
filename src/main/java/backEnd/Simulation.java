package backEnd;

import java.util.ArrayList;

public class Simulation {
  private EventPicker eventPicker;
  private ResourceInitialisation resourceInitialisation;
  private Event currentEvent;

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
    double price = resource.getCost();
    resource.changeCost(0.5);
    return price;
  }
  public double sell(Resource resource){
    double price = resource.getCost();
    resource.changeCost(-0.5);
    return price;
  }

  public Resource getResource(String name) {
    return resourceInitialisation.fromName(name);
  }
}
