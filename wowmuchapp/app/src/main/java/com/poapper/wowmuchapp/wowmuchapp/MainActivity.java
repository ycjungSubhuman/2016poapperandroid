package com.poapper.wowmuchapp.wowmuchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //this makes TAG to have "MainActivity". Use it for logging
    final String TAG = MainActivity.class.getSimpleName();

    Button startButton;

    //Our Entry Point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //"setContentView" sets view to "activity_main" layout. But then where is "activity_main"?
        //It is in res/layout/activity_main.xml
        //Every resource files in res folder is indexed into "R" object automatically.
        //So, you can just use it by referencing "R. ..."

        //CAUTION: R.layout.activity_main is not a view data itself.
        //It is just an INT value, which is used as an index number.

        //Find start button.(In activity_main layout, you can find the definition of start button)
        startButton = (Button) findViewById(R.id.btn_start);
        //Set click event handler for this button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //we have (v) as our button
                //These codes will be executed when clicked the button
                Log.d(TAG, "Start Button Clicked"); //You can find this message in android monitor
                proceedToMenu();
            }
        });
    }

    //When called, proceed to MenuActivity.
    private void proceedToMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish(); //finish this activity
    }
}
