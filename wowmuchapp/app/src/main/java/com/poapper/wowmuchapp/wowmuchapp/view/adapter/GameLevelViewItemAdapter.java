package com.poapper.wowmuchapp.wowmuchapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poapper.wowmuchapp.wowmuchapp.R;
import com.poapper.wowmuchapp.wowmuchapp.view.item.GameLevelViewItem;

import java.util.List;

/**
 * Adapter for GameLevelViewItem to be shown on a recycler view
 */

public class GameLevelViewItemAdapter extends RecyclerView.Adapter<GameLevelViewItemAdapter.ViewHolder>{

    //Actual data
    List<GameLevelViewItem> itemList;

    public GameLevelViewItemAdapter(List<GameLevelViewItem> items) {
        itemList = items;
    }

    //Creates View holder to hold references of view for each item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gamelevel, parent, false);
        return new ViewHolder(v);
    }

    //Assigning data to view.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.difficultyView.setText(String.valueOf(itemList.get(position).getDifficulty()));
        holder.operatorView.setText(itemList.get(position).getOperatorExample());
    }

    //this exists because Adapter an recycler view does not know the internal structure of data.
    //Have to return size of data count this way.
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //Holds references to view inside item view
    //With this holder, we do not need to re-search for the views of items every tiem we use it.
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView difficultyView;
        public TextView operatorView;

        public ViewHolder(View view) {
            super(view);
            difficultyView = (TextView) view.findViewById(R.id.tv_difficulty);
            operatorView = (TextView) view.findViewById(R.id.tv_operator);
        }
    }
}
