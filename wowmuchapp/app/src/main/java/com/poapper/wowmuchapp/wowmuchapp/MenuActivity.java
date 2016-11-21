package com.poapper.wowmuchapp.wowmuchapp;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.poapper.wowmuchapp.wowmuchapp.view.adapter.MenuPagerAdapter;

public class MenuActivity extends AppCompatActivity implements LevelFragment.OnFragmentInteractionListener {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MenuPagerAdapter(this));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
