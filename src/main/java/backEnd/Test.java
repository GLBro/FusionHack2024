package backEnd;

public class Test {
  private EventPicker eventPicker;
  private ResourceInitialisation resourceInitialisation;

  public Test() {
    resourceInitialisation = new ResourceInitialisation("newResources.xml");
    eventPicker = new EventPicker("newEventList.xml", resourceInitialisation);
    System.out.println(this.eventPicker.pickEvent());
  }
  public static void main(String[] args) {
    Test test = new Test();
  }
}
