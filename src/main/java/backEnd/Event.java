package backEnd;

import java.util.ArrayList;

public class Event {
  private String name;
  private ArrayList<Resource> resourcesAffected;

  public Event(String name) {
    this.name = name;
    this.resourcesAffected = new ArrayList<>();
  }

  public Event(String name, ArrayList<Resource> resourcesAffected) {
    this(name);
    this.resourcesAffected.addAll(resourcesAffected);
  }

  public void addResource(Resource resource) {
    this.resourcesAffected.add(resource);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Resource> getResourcesAffected() {
    return resourcesAffected;
  }
}