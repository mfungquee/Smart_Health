package com.example.michael.smarthealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //xml ids of buttons
    public Button buttonCreateNewAccount;
    public Button buttonLogin;

    //functions for UI interactions
    public void functionsUI(){

        DatabaseHelper db = DatabaseHelper.getInstance(this);
        buttonCreateNewAccount = (Button)findViewById(R.id.buttonCreateNewAccount); //reference to button from xml

        buttonCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(v.getContext(), create_new_account.class); //intent is the link between pages

                startActivity(intent1); //when button is pressed, move from activity1 to activity2

                //Intent intent = create_new_account.makeIntent(MainActivity.this);
                //startActivity(intent);
            }
        }); //end line of buttonCreateNewAccount

        buttonLogin = (Button)findViewById(R.id.buttonLogin); // reference to button from xml

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(v.getContext(), login.class); // intent = link between main and login page

                startActivity(intent2); //move from main to login
            }
        }); //end line of buttonLogin
    }//end functionsUI

    //creates the initial screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        functionsUI(); //UI functionality
    }

}
