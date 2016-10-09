package com.poapper.wowmuchapp.wowmuchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView selectLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        selectLevel = (TextView) findViewById(R.id.tv_select_lvl);
        updateSelectLevelText();
    }

    private void updateSelectLevelText() {
        selectLevel.setText("Select Level");
    }
}
