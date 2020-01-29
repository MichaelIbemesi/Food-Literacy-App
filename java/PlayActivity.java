package ncl.project.michaelibemesi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *   The play activity class, where can select options to complete a scenario,
 *   and gain/lose points.
 *   @author Michael Ibemesi
 *   @version 1.0
 */
public class PlayActivity extends AppCompatActivity {
    public static int userScore = 0;
    public static String userScenario;
    public static boolean userCorrect = false;
    private String[] userAnswers;

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;



    /*
     *   Creates the visible and interactive features of the user interface.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setUpGame();
    }
    /*
     *   Sets up the interactive elements and the win/lose condition for the game.
     */
    private void setUpGame(){
        Game userGame = new Game();

        Scenario currentScenario = userGame.selectScenario();
        userScenario = currentScenario.getDescription();
        final ArrayList<Food> correctAnswers = currentScenario.getCorrectFoods();

        TextView gameScenario = findViewById(R.id.gameScenario);
        gameScenario.setText(userScenario);

        userAnswers = new String[3];

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( userAnswers[0] != null && userAnswers[1] != null && userAnswers[2] != null){
                    int correctUserAnswers = 0;
                    for(int i = 0; i < correctAnswers.size(); i++){
                        if(correctAnswers.get(i).name == userAnswers[0]){
                            correctUserAnswers = 1;
                            for(int j = 0; j < correctAnswers.size(); j++){
                                if(correctAnswers.get(j).name == userAnswers[1]){
                                    correctUserAnswers = correctUserAnswers + 1;
                                    for(int k = 0; k < correctAnswers.size(); k++){
                                        if(correctAnswers.get(k).name == userAnswers[2]){
                                            correctUserAnswers = correctUserAnswers + 1;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if(correctUserAnswers == 3){
                        userScore = userScore + 10;
                        userCorrect = true;
                        successDialog();
                    } else {
                        failureDialog();
                        if(userScore - 10 < 0){
                            userScore = 0;
                        } else {
                            userScore = userScore - 10;
                        }
                    }

                } else {
                    noSelectionDialog();
                }
            }
        });

        final Button resetButton =  findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAnswers[0] = null;
                userAnswers[1] = null;
                userAnswers[2] = null;
                resetDialog();
                resetImages();
            }
        });

        image1= findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);
        image5 = findViewById(R.id.image_5);
        image6 = findViewById(R.id.image_6);
        image7 = findViewById(R.id.image_7);
        image8 = findViewById(R.id.image_8);


        final Integer selectedImage1 = userGame.selectFoodImage();
        image1.setImageResource(selectedImage1);

        final Integer selectedImage2 = userGame.selectFoodImage();
        image2.setImageResource(selectedImage2);

        final Integer selectedImage3 = userGame.selectFoodImage();
        image3.setImageResource(selectedImage3);

        final Integer selectedImage4 = userGame.selectFoodImage();
        image4.setImageResource(selectedImage4);

        final Integer selectedImage5 = userGame.selectFoodImage();
        image5.setImageResource(selectedImage5);

        final Integer selectedImage6 = userGame.selectFoodImage();
        image6.setImageResource(selectedImage6);

        final Integer selectedImage7 = userGame.selectFoodImage();
        image7.setImageResource(selectedImage7);

        final Integer selectedImage8 = userGame.selectFoodImage();
        image8.setImageResource(selectedImage8);


        resetImages();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage1);
                recordUserChoice(choice, image1);
            }
        });

        image1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage1);
                foodNameDialog(choice);
                return true;
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage2);
                recordUserChoice(choice, image2);

            }
        });

        image2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage2);
                foodNameDialog(choice);
                return true;
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage3);
                recordUserChoice(choice, image3);
            }
        });

        image3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage3);
                foodNameDialog(choice);
                return true;
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage4);
                recordUserChoice(choice, image4);

            }
        });

        image4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage4);
                foodNameDialog(choice);
                return true;
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage5);
                recordUserChoice(choice, image5);
            }
        });

        image5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage5);
                foodNameDialog(choice);
                return true;
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage6);
                recordUserChoice(choice, image6);
            }
        });

        image6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage6);
                foodNameDialog(choice);
                return true;
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage7);
                recordUserChoice(choice, image7);
            }
        });

        image7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage7);
                foodNameDialog(choice);
                return true;
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice =
                checkImages(selectedImage8);
                recordUserChoice(choice, image8);
            }
        });

        image8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String choice =
                        checkImages(selectedImage8);
                foodNameDialog(choice);
                return true;
            }
        });
    }

    /*
     *   Creates an AlertDialog indicating the player was successful.
     */
    private void successDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.success_dialog, null);

        Button continueBtn = view.findViewById(R.id.continue_button);
        continueBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(playIntent);
            }
        });

        Button backBtn = view.findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(playIntent);
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }

    /*
     *   Creates an AlertDialog indicating the player was unsuccessful.
     */
    private void failureDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.failure_dialog, null);

        Button continueBtn = view.findViewById(R.id.continue_button);
        continueBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(playIntent);
            }
        });

        Button backBtn = view.findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(playIntent);
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }
    /*
     *   Creates an AlertDialog indicating the player has not selected any foods.
     */
    private void noSelectionDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.no_selection_dialog, null);


        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();

        Button okBtn = view.findViewById(R.id.ok_button);
        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }
    /*
     *   Creates an AlertDialog indicating the player's choices have been reset.
     */
    private void resetDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.reset_dialog, null);


        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();

        Button okBtn = view.findViewById(R.id.ok_button);
        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    /*
     *   Creates an AlertDialog indicating that three foods have already been chosen.
     */
    private void arrayFullDialog(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.array_full_dialog, null);


        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();

        Button okBtn = view.findViewById(R.id.ok_button);
        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    /*
     *   Creates an AlertDialog displaying the name of the food item when the user long clicks the
     *   food image.
     */
    private void foodNameDialog(String choice){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.food_name_dialog, null);


        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();

        TextView foodField = view.findViewById(R.id.food_name_text);
        foodField.setText(choice);
        Button okBtn = view.findViewById(R.id.ok_button);
        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }

    /*
     *   resets the food images.
     */
    private void resetImages(){

        image1.setVisibility(View.VISIBLE);
        image1.setClickable(true);

        image2.setVisibility(View.VISIBLE);
        image2.setClickable(true);

        image3.setVisibility(View.VISIBLE);
        image3.setClickable(true);

        image4.setVisibility(View.VISIBLE);
        image4.setClickable(true);

        image5.setVisibility(View.VISIBLE);
        image5.setClickable(true);

        image6.setVisibility(View.VISIBLE);
        image6.setClickable(true);

        image7.setVisibility(View.VISIBLE);
        image7.setClickable(true);

        image8.setVisibility(View.VISIBLE);
        image8.setClickable(true);
    }
/*
*  Adds the user's choice to the userAnswers array depending on whether strings are already
*  in the array.
*
*  @param choice The users choice.
*  @param iV the ImageView to alter according to the user's choice.
*/
    private void recordUserChoice(String choice, ImageView iV){
        if(Arrays.asList(userAnswers).contains(choice)){
        } else {
            if(userAnswers[0] == null) {
                userAnswers[0] = choice;
                iV.setVisibility(View.INVISIBLE);
                iV.setClickable(false);
            } else if(userAnswers[1] == null) {
                userAnswers[1] = choice;
                iV.setVisibility(View.INVISIBLE);
                iV.setClickable(false);
            } else if(userAnswers[2] == null){
                userAnswers[2] = choice;
                iV.setVisibility(View.INVISIBLE);
                iV.setClickable(false);
            } else {
                arrayFullDialog();
            }
        }
    }

    private String checkImages(Integer image){
        String choice = null;
        if(image != null){
            if(image == R.drawable.apple){
                choice = "Apple";
            }
            else if (image == R.drawable.burger){
                choice = "Burger";
            }
            else if (image == R.drawable.coke){
                choice = "Coke";
            }
            else if (image == R.drawable.donut){
                choice = "Donut";
            }
            else if (image == R.drawable.eggs){
                choice = "Eggs";
            }
            else if (image == R.drawable.rice){
                choice = "Rice";
            }
            else if (image == R.drawable.steak){
                choice = "Steak";
            }
            if (image == R.drawable.water){
                choice = "Water";
            }
        }
        return choice;
    }
}


