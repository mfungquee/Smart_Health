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

    Button buttonConfirm;

    public void functionsUI(){

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
