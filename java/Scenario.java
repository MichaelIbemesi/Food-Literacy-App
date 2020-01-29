package ncl.project.michaelibemesi;

import java.util.ArrayList;

/*
 *   Represents a scenario.
 *   @author Michael Ibemesi
 *   @version 1.0
 */
public final class Scenario {

    private final String description;
    private final ArrayList<Food> correctFoods = new ArrayList();

    /*
     *   Creates a new scenario object.
     *   @param desc The description of the scenario object.
     */
    public Scenario(String desc){
        this.description = desc;
    }
    /*
     *   Adds the correct foods to the scenario ArrayList.
     */
    public void addFood(Food item1, Food item2,Food item3){

        correctFoods.add(item1);
        correctFoods.add(item2);
        correctFoods.add(item3);
    }
    /*
     *   Returns the ArrayList of correct food objects from the scenario.
     *   @return The correctFoods ArrayList
     */
    public ArrayList<Food> getCorrectFoods(){
        return correctFoods;
    }
    /*
    *   Returns the description of the Scenario object.
    *   @return The description or the Scenario.
    */
    public String getDescription(){
        return description;
    }

}
