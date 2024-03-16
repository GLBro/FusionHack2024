package backEnd;

import java.util.ArrayList;

public class Event {
  private String name;
  private ArrayList<Resource> resourcesAffected;

  public Event(String name) {
    this.name = name;
  }

  public Event(String name, ArrayList<Resource> resourcesAffected) {
    this(name);
    this.resourcesAffected = resourcesAffected;
  }

  public void addResource(Resource resource) {
    this.resourcesAffected.add(resource);
  }
}