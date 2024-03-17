package backEnd;
import java.util.ArrayList;
import java.util.Random;

public class Automation {
    private ArrayList<Resource> resources;
    private ResourceInitialisation init;
    private Random rand = new Random();
    private Simulation sim;
    public Automation(ArrayList<Resource> list,Simulation sim){
        this.sim = sim;
        resources = list;
    }
    // constructor tht takes the array of resources
    // This thing is instantiated in simulation #
    // it gets sent the array of resources in the constructor

    public void hundredBuy(){
        for(int i=0;i<100;i++){
            int choose = rand.nextInt(4);
            int decision = rand.nextInt(2);
            Resource resource = resources.get(choose);
            if (decision == 0){
                sim.autoBuy(resource);
            }
            else{
                sim.autoSell(resource);
            }
        }

    }

}
