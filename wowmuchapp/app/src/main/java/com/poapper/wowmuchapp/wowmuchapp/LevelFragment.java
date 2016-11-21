package com.poapper.wowmuchapp.wowmuchapp;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poapper.wowmuchapp.wowmuchapp.math.Adder;
import com.poapper.wowmuchapp.wowmuchapp.math.Subtractor;
import com.poapper.wowmuchapp.wowmuchapp.math.WowFyer;
import com.poapper.wowmuchapp.wowmuchapp.view.adapter.GameLevelViewItemAdapter;
import com.poapper.wowmuchapp.wowmuchapp.view.item.GameLevelViewItem;

import java.util.ArrayList;
import java.util.List;

public class LevelFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    int mode;

    public LevelFragment() {
        // Required empty public constructor
    }

    /** Create a new instance of fragment. If needed, add arguments */
    public static LevelFragment newInstance(int mode) {
        LevelFragment fragment = new LevelFragment();
        Bundle args = new Bundle();
        args.putInt("mode", mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mode = bundle.getInt("mode");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_level, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_levels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); //Default Linear Layout Manager
        /* Sets recyclerView's Data/Adapter*/
        List<GameLevelViewItem> items = new ArrayList<>();
        //put dymmy items into list
        if (mode == 0) {
            putDummyGameLevels(items);
        }
        else if (mode == 1) {
            putDummyHardLevels(items);
            recyclerView.setBackgroundColor(Color.parseColor("#dd3333"));
        }
        GameLevelViewItemAdapter adapter = new GameLevelViewItemAdapter(items);
        recyclerView.setAdapter(adapter);
        return v;
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

    private void putDummyHardLevels(List<GameLevelViewItem> items) {
        items.add(new GameLevelViewItem(new WowFyer()));
        items.add(new GameLevelViewItem(new WowFyer()));
        items.add(new GameLevelViewItem(new WowFyer()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
