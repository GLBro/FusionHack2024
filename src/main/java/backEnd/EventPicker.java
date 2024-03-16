package backEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class EventPicker {
  private ArrayList<Event> events;
  private Random rand = new Random();
  public EventPicker(String file){
    initialiseArray(file);
  }

  public ArrayList<Event> initialiseArray(String fileName) {
    try {
      File file = new File(fileName);
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split(",");
        events.add(new Event(
            splitLine[0]
        ));
      }

      bufferedReader.close();
    } catch (Exception exception) {
      System.out.println("Error");
    }
    return events;
  };

  public Event pickEvent(){
    int i = rand.nextInt(0,events.size() -1);
    return events.get(i);
  }

}
