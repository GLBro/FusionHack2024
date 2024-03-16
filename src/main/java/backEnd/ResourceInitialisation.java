package backEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ResourceInitialisation {
  private ArrayList<Resource> resources;

  public ResourceInitialisation(String fileName){
    resources = new ArrayList<>();

    try {
      File file = new File(fileName);
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

      String line;
      while((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split(",");
        resources.add(new Resource(
            splitLine[0]
        ));
      }

      bufferedReader.close();
    } catch (Exception exception) {
      System.out.println("Resource Init Error");
      System.out.println(exception);
    }
  }

  public Resource fromName(String name){
    for(int i=0; i< resources.size();i++){
      if (resources.get(i).getName().equals(name)){
        return resources.get(i);
      }
    }

    return null;
  }

  public ArrayList<Resource> getResources() {
    return resources;
  }
}
