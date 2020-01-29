package ncl.project.michaelibemesi;

import java.util.ArrayList;
import java.util.Random;

/*
 *   Class which sets up the Scenarios for the game.
 *   @author Michael Ibemesi
 *   @version 1.0
 */
public class Game{

    private ArrayList<Scenario> scenarioList = new ArrayList();
    private Integer[] foodImages;
    private ArrayList<Integer> randomNumbers = new ArrayList();

    public static Food apple = new Food("Apple", "95", "0.5 g", "0.3 g", "19.0 g", "25.0 g", "4.4 g", "0.0 mg", "1.8 mg", "194.7 mg");
    public static Food burger = new Food("Burger", "354", "20.0 g", "17.0 g", "5.0 g", "29.0 g", "1.1 g", "56.4 mg", "496.8 mg", "271.2 mg");
    public static Food coke = new Food("Coke", "139", "0.0 g", "0.0 g", "39.0 g", "39.0 g", "0.0 g", "0.0 mg", "45.0 mg", "0.0 mg");
    public static Food donut = new Food("Donut", "195", "2.1 g", "11.0 g", "11.0 g", "22.0 g", "0.8 g", "8.2 mg", "140.2 mg", "86.4 mg");
    public static Food eggs = new Food("Eggs", "155", "13.0 g", "11.0 g", "1.1 g", "1.1 g", "0.0 g", "373.0 mg", "124.0 mg", "126.0 mg");
    public static Food rice = new Food("Rice", "206", "4.3 g", "0.4 g", "0.1 g", "45.0 g", "0.6 g", "0.0 mg", "1.6 mg", "55.3 mg");
    public static Food steak = new Food("Steak", "679", "62.0 g", "48.0 g", "0.0 g", "0.0 g", "0.0 g", "195.8 mg", "145.6 mg", "700.3 mg");
    public static Food water = new Food("Water", "0.0", "0.0 g", "0.0 g", "0.0 g", "0.0 g", "0.0 g", "0.0 mg", "0.0 mg", "0.0 mg");


    public Game(){
        createScenarios();
        createFoodImages();
    }

    /*
     *   creates the Scenario objects and adds them to the scenarioList ArrayList.
     */
    public void createScenarios(){

        Scenario scen1 = new Scenario("Choose the foods which will make the avatars teeth rot");
        Scenario scen2 = new Scenario("Choose the healthiest foods for the avatar");
        Scenario scen3 = new Scenario("Choose the foods with the highest fat content");
        Scenario scen4 = new Scenario("Choose the foods which will help the avatar gain muscle");
        Scenario scen5 = new Scenario("Choose the most filling foods for the avatar");
        Scenario scen6 = new Scenario("Choose the least nutritious foods for the avatar");

        scen1.addFood(donut, coke, apple);
        scen2.addFood(apple, water, eggs);
        scen3.addFood(donut, burger, steak);
        scen4.addFood(eggs, burger, steak);
        scen5.addFood(burger, rice, steak);
        scen6.addFood(water, donut, coke);

        scenarioList.add(scen1);
        scenarioList.add(scen2);
        scenarioList.add(scen3);
        scenarioList.add(scen4);
        scenarioList.add(scen5);
        scenarioList.add(scen6);

    }

    public void createFoodImages(){
        foodImages = new Integer[]{
                R.drawable.apple,
                R.drawable.burger,
                R.drawable.coke,
                R.drawable.donut,
                R.drawable.eggs,
                R.drawable.rice,
                R.drawable.steak,
                R.drawable.water
        };
    }

    /*
     *   Returns a random Scenario from scenarioList ArrayList.
     *   @return Random Scenario.
     */
    public Scenario selectScenario(){
        Random rN = new Random();
        return scenarioList.get(rN.nextInt(scenarioList.size()));
    }

    public Integer selectFoodImage(){
        Random rN = new Random();
        int chosenNumber = rN.nextInt(foodImages.length);
        if(randomNumbers.contains(chosenNumber)){
            Random rN2 = new Random();
            int newChosenNumber = rN2.nextInt(foodImages.length);
            while(randomNumbers.contains(newChosenNumber)){
                newChosenNumber = rN2.nextInt(foodImages.length);
            }
            randomNumbers.add(newChosenNumber);
            return foodImages[newChosenNumber];
        }
        randomNumbers.add(chosenNumber);
        return foodImages[chosenNumber];
    }

}
