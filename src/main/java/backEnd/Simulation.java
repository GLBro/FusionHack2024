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
    String eventname = currentEvent.getName();
    return eventname;
  }

  public String[] getEventResources(){
    String[] resources = new String[currentEvent.getResourcesAffected().size()];

    for (int i=0; i<currentEvent.getResourcesAffected().size();i++){
      resources[i] = currentEvent.getResourcesAffected().get(i).getName();
    }

    return resources;
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

  public String[][] getResourceCostAndChange(){
    // TODO: Write this, returns the cost and the %change for the resources
    return new String[6][2];
  }
  // TODO: Need to write simulation functions for selling or buying stocks
}
