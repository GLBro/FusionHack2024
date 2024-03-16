package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class EventPicker {
  private ArrayList<Event> events;
  private Random rand = new Random();
  public EventPicker(String file){
    initialiseArray(file);
  }

  public ArrayList<Event> initialiseArray(String FileName){

    return events;
  };

  public Event pickEvent(){
    int i = rand.nextInt(0,events.size() -1);
    return events.get(i);
  }

}
