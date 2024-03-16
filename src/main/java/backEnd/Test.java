package backEnd;

public class Test {
  private EventPicker eventPicker;
  private ResourceInitialisation resourceInitialisation;

  public Test() {
    resourceInitialisation = new ResourceInitialisation("resources.txt");
    eventPicker = new EventPicker("eventList.csv", resourceInitialisation);
    System.out.println(this.eventPicker.pickEvent());
  }
  public static void main(String[] args) {
    Test test = new Test();
  }
}
