package backEnd;

import java.util.ArrayList;

public class ResourceInitilisation {
  private ArrayList<Resource> resources;

  public ResourceInitilisation(String fileName){

  }

  public Resource fromName(String name){
    for(int i=0; i< resources.size();i++){
      if (resources.get(i).getName() == name){
        return resources.get(i);
      }
    }

    return null;
  }

}
