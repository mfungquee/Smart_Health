package com.example.michael.smarthealth;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
/**
 * Created by Michael on 5/6/2017.
 */
public class exercise_rewards extends AppCompatActivity {

    Button buttonConfirm;   //confirm button
    TextView grade;
    TextView rewards;
    ImageView badge;


    /************ TESTING VARIABLES ***********/
    // these variables are created before this activity: has to persist throughout app
    int method = 0;
    Gamification gamification = new Gamification();
    int numExercises = 4;
    DecisionMatrix[] exercises = new DecisionMatrix[numExercises+1]; //one for each exercise

    /************ END TESTING VARIABLES ***********/


    public void functionsUI(){

        /**** FOR TESTING*****/
        //this should be created at the beginning of app
        for (int i = 1; i<numExercises+1; i++){
            exercises[i] = new DecisionMatrix(1, i);
        }
        /**** END TESTING ****/



        grade = (TextView)findViewById(R.id.grade);
        rewards = (TextView)findViewById(R.id.rewards);
        badge = (ImageView)findViewById(R.id.badge);

        //avg success rate for all exercises done.
        double sum = 0.0;
        for (int i = 1; i<numExercises+1; i++) {
            sum += exercises[i].getCurrentSR() * 100;
        }
        double exerciseGrade = sum / numExercises;
        String gradeAsString = String.format("%.0f", exerciseGrade);
        grade.setText(gradeAsString + "%");


        //rewards textview and badge imageview will be determined by method
        switch (method) {
            case 0:
                int exp = (int)exerciseGrade;
                rewards.setText(gamification.getExpReward(exp));
                break;
            case 1:
                if (exerciseGrade >= 200){
                    rewards.setText("You got badge1!");
                    badge.setImageResource(gamification.getBadgeReward(1));
                }
                else if (exerciseGrade >= 150) {
                    rewards.setText("You got badge2!");
                    badge.setImageResource(gamification.getBadgeReward(2));
                }
                else if (exerciseGrade >= 100) {
                    rewards.setText("You got badge3!");
                    badge.setImageResource(gamification.getBadgeReward(3));
                }
                else if (exerciseGrade >= 50) {
                    rewards.setText("You got badge4!");
                    badge.setImageResource(gamification.getBadgeReward(4));
                }
                else {
                    rewards.setText("You need to do better for a badge!");
                }
        }


        buttonConfirm = (Button)findViewById(R.id.buttonConfirm); //reference by xml id
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: send workout information into database
                Intent intent = new Intent(v.getContext(), main_screen.class); //intent is the link between pages
                startActivity(intent); //when button is pressed, move from activity1 to activity2

                finish(); // take off stack so user can't return to this page
            }
        }); //end line of buttonDone

    }//end functionsUI


    //creates the initial screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_rewards);
        functionsUI(); //functions for UI
    }//end onCreate


}
