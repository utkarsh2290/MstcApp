package com.example.mstcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class feedFragment extends Fragment {
    List<Integer> URLS_sample= new ArrayList<>();
    Button stc_feed;

    RecyclerView recyclerView_feed;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        URLS_sample.add(R.drawable.pp);
        URLS_sample.add(R.drawable.pp);
        URLS_sample.add(R.drawable.pp);
        URLS_sample.add(R.drawable.pp);

        recyclerView_feed=(RecyclerView)getView().findViewById(R.id.recyclerview_feed);
        stc_feed=(Button)getView().findViewById(R.id.stc_home);

        //layout for recycler view to have feed images
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1);
        recyclerView_feed.setLayoutManager(gridLayoutManager);
        recyclerView_feed.setAdapter(new FeedAdapter(URLS_sample));

        stc_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SignInActivity.class));
            }
        });

    }
}
