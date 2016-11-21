package com.poapper.wowmuchapp.wowmuchapp.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.poapper.wowmuchapp.wowmuchapp.LevelFragment;

public class MenuPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public MenuPagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        context = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return LevelFragment.newInstance(0);
            case 1:
                return LevelFragment.newInstance(1);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
