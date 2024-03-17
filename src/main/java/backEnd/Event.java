package backEnd;

import java.util.ArrayList;

public class Event {
  private String name;
  private ArrayList<Resource> resourcesAffected;
  private ArrayList<Double> resourceAffectChange;

  public Event(String name) {
    this.name = name;
    this.resourcesAffected = new ArrayList<>();
    this.resourceAffectChange = new ArrayList<>();
  }

  public Event(String name, ArrayList<Resource> resourcesAffected) {
    this(name);
    this.resourcesAffected.addAll(resourcesAffected);
  }

  public void addResource(Resource resource, double change) {
    this.resourcesAffected.add(resource);
    this.resourceAffectChange.add(change);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Resource> getResourcesAffected() {
    return resourcesAffected;
  }

  public ArrayList<Double> getResourceAffectChange() {
    return resourceAffectChange;
  }
}