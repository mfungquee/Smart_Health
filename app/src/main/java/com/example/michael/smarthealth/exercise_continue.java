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
public class exercise_continue extends AppCompatActivity {
    //xml ids
    ListView listViewWorkout;
    Button buttonDone;

    public void functionsUI(){

        listViewWorkout = (ListView)findViewById(R.id.listViewWorkout);

        buttonDone = (Button)findViewById(R.id.buttonDone); //reference by xml id
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: send workout information into database
                Intent intent = new Intent(v.getContext(), exercise_rewards.class); //intent is the link between pages
                startActivity(intent); //when button is pressed, move from activity1 to activity2
                finish(); // take off stack so user can't return with back
            }
        }); //end line of buttonDone


    }

    //creates the initial screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_continue);
        functionsUI();
    }
}
