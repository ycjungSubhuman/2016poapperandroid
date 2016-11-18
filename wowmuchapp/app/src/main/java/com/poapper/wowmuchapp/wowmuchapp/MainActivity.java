package com.poapper.wowmuchapp.wowmuchapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //this makes TAG to have "MainActivity". Use it for logging
    final String TAG = MainActivity.class.getSimpleName();

    Button startButton;

    String KEY = "fe4df8bf5e44ea2078ab0aa8bf9ef451";

    Uri weatherUri = new Uri.Builder()
                .scheme("http")
                .path("api.openweathermap.org/data/2.5/weather")
                .appendQueryParameter("q", "Pohang")
                .appendQueryParameter("APPID", KEY)
                .build();

    boolean isHardMode = false;

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
        checkWeather();
    }

    private void checkWeather() {
        new AsyncTask<Void, Void, String>() {
            //this method is run on Background Thread
            @Override
            protected String doInBackground(Void... params) {
                URL url = null;
                HttpURLConnection conn = null;
                try {
                    url = new URL(weatherUri.toString());
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String buf, res = "";
                    while((buf = in.readLine() )!= null) {
                        res += buf;
                    }
                    Log.d("wow", res);

                    JSONObject obj = new JSONObject(res);
                    JSONObject weather = (JSONObject) obj.getJSONArray("weather").get(0);
                    //current weather
                    String main = weather.getString("main");
                    return main;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    if (conn != null)
                        conn.disconnect();
                }
            }

            //this method is run on UI Thread
            @Override
            protected void onPostExecute(String s) {
                if (s != null && "Clouds".equals(s)) {
                    isHardMode = true;
                    startButton.setText("WELCOME TO HELL");
                }
            }
        }.execute();
    }

    //When called, proceed to MenuActivity.
    private void proceedToMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("hardmode", isHardMode);
        startActivity(intent);
        finish(); //finish this activity
    }
}
