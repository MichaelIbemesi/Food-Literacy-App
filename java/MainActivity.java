package ncl.project.michaelibemesi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *   The main activity class, where the user can see the avatar, the points they
 *   have gained and start a scenario.
 *   @author Michael Ibemesi
 *   @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    public static ImageView avatar;
    /*
     *   Creates the visible and interactive features of the user interface.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView score = findViewById(R.id.score);
        score.setText(PlayActivity.userScore + "");

        Button playActivityBtn = findViewById(R.id.playButton);
        playActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(playIntent);
            }
        });

        Button resetScoreBtn = findViewById(R.id.reset_points_button);
        resetScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayActivity.userScore = 0;
                Intent playIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(playIntent);
            }
        });

        Button glossaryBtn = findViewById(R.id.glossary_button);
        glossaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(getApplicationContext(), GlossaryActivity.class);
                startActivity(playIntent);
            }
        });

        avatar = findViewById(R.id.avatar);
        changeAvatar();
    }
    /*
     *   Changes the avatar displayed to the user depending on the scenario description
     *   and if the user successfully completes the scenario
     */
    public void changeAvatar(){
        if(PlayActivity.userCorrect == true){
            if(PlayActivity.userScenario == "Choose the foods which will make the avatars teeth rot"){
                avatar.setImageResource(R.drawable.unhealthy);
            } else if(PlayActivity.userScenario == "Choose the healthiest foods for the avatar" || PlayActivity.userScenario == "Choose the most filling foods for the avatar"){
                avatar.setImageResource(R.drawable.happy);
            } else if(PlayActivity.userScenario == "Choose the foods with the highest fat content"){
                avatar.setImageResource(R.drawable.rounder);
            } else if(PlayActivity.userScenario == "Choose the foods which will help the avatar gain muscle"){
                avatar.setImageResource(R.drawable.muscle);
            } else if(PlayActivity.userScenario == "Choose the least nutritious foods for the avatar"){
                avatar.setImageResource(R.drawable.unhappy);
            }

            PlayActivity.userCorrect = false;
        }
    }
}
