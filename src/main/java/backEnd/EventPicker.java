package backEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EventPicker {
  private ArrayList<Event> events;
  private ResourceInitialisation resourceInitialisation;
  private Random rand = new Random();

  private ArrayList<Double> resourceAffectChange;
  public EventPicker(String fileName, ResourceInitialisation resourceInitialisation){
    this.resourceInitialisation = resourceInitialisation;
    initialiseArray(fileName);
  }

  public ArrayList<Event> initialiseArray(String fileName) {
    events = new ArrayList<>();

    XMLParser xmlParser = new XMLParser(fileName);
    try {
      NodeList eventNodes = xmlParser.xPath("//event");
      for(int i = 0; i < eventNodes.getLength(); i++) {
        Element eventElem = (Element) eventNodes.item(i);
        String eventName = eventElem.getElementsByTagName("name").item(0).getTextContent().trim();
        Event newEvent = new Event(eventName);

        NodeList resourcesAffected = eventElem.getElementsByTagName("resource");
        for(int j = 0; j < resourcesAffected.getLength(); j++) {
          Element resourceElem = (Element) resourcesAffected.item(j);
          String resourceName = resourceElem.getElementsByTagName("name").item(0).getTextContent().trim();
          boolean resourcePositive = resourceElem.getElementsByTagName("positive").item(0).getTextContent().trim().equals("true");
          int resourceChange = Integer.parseInt(resourceElem.getElementsByTagName("change").item(0).getTextContent().trim());

          resourceChange *= (resourcePositive ? 1 : -1);

          newEvent.addResource(resourceInitialisation.fromName(resourceName), resourceChange);
        }

        events.add(newEvent);
      }
    } catch (Exception exception) {
      System.out.println("EventPicker Error");
      exception.printStackTrace();
    }

    return events;
  };

  public Event pickEvent(){
    int ub = events.size();
    int i = rand.nextInt(ub);

    Event event = events.get(i);
    ArrayList<Resource> resources = event.getResourcesAffected();
    resourceAffectChange = event.getResourceAffectChange();
    for(int j = 0; j < resources.size(); j++) {
      Resource resourceAffected = resources.get(j);
      double affectChange = resourceAffectChange.get(j);
      resourceAffectChange.set(j,resourceAffected.changeCost(affectChange * 0.5 + (Math.random() * affectChange)));
      System.out.println(resourceAffectChange.get(j));
    }

    return event;
  }
  public ArrayList<Double> geResourceAffectChange(){
    return resourceAffectChange;
  }
}
