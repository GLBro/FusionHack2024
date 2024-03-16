package backEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ResourceInitialisation {
  private ArrayList<Resource> resources;

  public ResourceInitialisation(String fileName){
    resources = new ArrayList<>();

    XMLParser xmlParser = new XMLParser(fileName);
    try {
      NodeList resourceNodes = xmlParser.xPath("//resource");
      for(int i = 0; i < resourceNodes.getLength(); i++) {
        Element resourceElem = (Element) resourceNodes.item(i);
        String resourceName = resourceElem.getElementsByTagName("name").item(0).getTextContent().trim();

        resources.add(new Resource(resourceName));
      }
    } catch (Exception exception) {
      System.out.println("EventPicker Error");
      exception.printStackTrace();
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
