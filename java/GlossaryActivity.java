package ncl.project.michaelibemesi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *   Represents a scenario.
 *   @author Michael Ibemesi
 *   @version 1.0
 */

public class GlossaryActivity extends AppCompatActivity {

    public Food tempChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(playIntent);
            }
        });

        Button searchBtn = findViewById(R.id.search_button);
        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                displayFoods();
            }
        });
    }
/*
*   sets the tempChoice variable to the food object in relation to the user's input.
*/
    public void displayFoods(){
        EditText userFoodInput = findViewById(R.id.glossary_search);
        String userFood = userFoodInput.getText().toString().toLowerCase().trim();
        Game glossaryGame = new Game();

        if(userFood.contains("apple")){
            tempChoice = glossaryGame.apple;
            setData(tempChoice);
        } else if (userFood.contains("burger")){
            tempChoice = glossaryGame.burger;
            setData(tempChoice);
        } else if(userFood.contains("coke")){
            tempChoice = glossaryGame.coke;
            setData(tempChoice);
        } else if(userFood.contains("donut")){
            tempChoice = glossaryGame.donut;
            setData(tempChoice);
        } else if(userFood.contains("eggs")){
            tempChoice = glossaryGame.eggs;
            setData(tempChoice);
        } else if(userFood.contains("rice")){
            tempChoice = glossaryGame.rice;
            setData(tempChoice);
        } else if(userFood.contains("steak")){
            tempChoice = glossaryGame.steak;
            setData(tempChoice);
        } else if(userFood.contains("water")){
            tempChoice = glossaryGame.water;
            setData(tempChoice);
        }
    }
/*
*   displays the food nutrition data to the screen.
*   @param setData the selected food to be displayed.
*/
    public void setData(Food uc){
        TextView calories = findViewById(R.id.calories_data);
        calories.setText(uc.calories);

        TextView fat = findViewById(R.id.fat_data);
        fat.setText(uc.fat);

        TextView sugar = findViewById(R.id.sugar_data);
        sugar.setText(uc.sugar);

        TextView carbs = findViewById(R.id.carbs_data);
        carbs.setText(uc.carbs);

        TextView protein = findViewById(R.id.protein_data);
        protein.setText(uc.protein);

        TextView cholesterol = findViewById(R.id.cholesterol_data);
        cholesterol.setText(uc.cholesterol);

        TextView potassium = findViewById(R.id.potassium_data);
        potassium.setText(uc.potassium);

        TextView sodium = findViewById(R.id.sodium_data);
        sodium.setText(uc.sodium);

        TextView fibre = findViewById(R.id.fibre_data);
        fibre.setText(uc.fibre);
    }
}
