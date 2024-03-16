package backEnd;

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
    return new String[3];
  }

  public String[][] getResourceCostAndChange(){

    return new String[6][2];
  }
}
