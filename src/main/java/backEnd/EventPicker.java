package backEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class EventPicker {
  private ArrayList<Event> events;
  private ResourceInitialisation resourceInitialisation;
  private Random rand = new Random();

  public EventPicker(String fileName, ResourceInitialisation resourceInitialisation){
    this.resourceInitialisation = resourceInitialisation;
    initialiseArray(fileName);
  }

  public ArrayList<Event> initialiseArray(String fileName) {
    events = new ArrayList<>();

    try {
      File file = new File(fileName);
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split(",");
        Event newEvent = new Event(splitLine[0]);

        for(String resourceName : splitLine[1].split(";")) {
          newEvent.addResource(resourceInitialisation.fromName(resourceName));
        }

        events.add(newEvent);
      }

      bufferedReader.close();
    } catch (Exception exception) {
      System.out.println("EventPicker Error");
      exception.printStackTrace();
    }
    return events;
  };

  public Event pickEvent(){
    int i = rand.nextInt(events.size() -1);
    return events.get(i);
  }

}
