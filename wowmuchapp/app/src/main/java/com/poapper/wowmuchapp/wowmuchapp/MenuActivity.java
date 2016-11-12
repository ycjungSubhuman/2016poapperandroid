package com.poapper.wowmuchapp.wowmuchapp;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.poapper.wowmuchapp.wowmuchapp.math.Adder;
import com.poapper.wowmuchapp.wowmuchapp.math.Subtractor;
import com.poapper.wowmuchapp.wowmuchapp.math.WowFyer;
import com.poapper.wowmuchapp.wowmuchapp.view.adapter.GameLevelViewItemAdapter;
import com.poapper.wowmuchapp.wowmuchapp.view.item.GameLevelViewItem;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //find Recycler View in Layout
        recyclerView = (RecyclerView) findViewById(R.id.rv_levels);

        /* Sets recyclerView's LayoutManager */
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //Default Linear Layout Manager

        /* Sets recyclerView's Data/Adapter*/
        List<GameLevelViewItem> items = new ArrayList<>();
        //put dymmy items into list
        putDummyGameLevels(items);
        GameLevelViewItemAdapter adapter = new GameLevelViewItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private void putDummyGameLevels(List<GameLevelViewItem> items) {
        items.add(new GameLevelViewItem(new Adder()));
        items.add(new GameLevelViewItem(new Subtractor()));
        items.add(new GameLevelViewItem(new WowFyer()));
        items.add(new GameLevelViewItem(new Adder()));
        items.add(new GameLevelViewItem(new WowFyer()));
        items.add(new GameLevelViewItem(new Subtractor()));
        items.add(new GameLevelViewItem(new Subtractor()));
        items.add(new GameLevelViewItem(new Subtractor()));
        items.add(new GameLevelViewItem(new WowFyer()));
        items.add(new GameLevelViewItem(new WowFyer()));
    }
}
