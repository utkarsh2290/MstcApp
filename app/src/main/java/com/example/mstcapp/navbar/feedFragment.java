package com.example.mstcapp.navbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.adapters.FeedAdapter;
import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class feedFragment extends Fragment {
    List<Integer> URLS_sample= new ArrayList<>();
    List <String> Desc_sample=new ArrayList<>();
    List <String> Title_sample=new ArrayList<>();
    List <String> Link_sample=new ArrayList<>();

    RecyclerView recyclerView_feed;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //These below list are fo samples,will be remvoed after ingration with backend

        URLS_sample.add(R.drawable.xbox);
        URLS_sample.add(R.drawable.xbox);
        URLS_sample.add(R.drawable.xbox);
        URLS_sample.add(R.drawable.xbox);

        Desc_sample.add("This the sample description for post  This is clickable and the insta post opens in new browser.");
        Desc_sample.add("This the sample description for post  This is clickable and the insta post opens in new browser.");
        Desc_sample.add("This the sample description for post  This is clickable and the insta post opens in new browser.");
        Desc_sample.add("This the sample description for post  This is clickable and the insta post opens in new browser.");

        Title_sample.add("Did You Know");
        Title_sample.add("Did You Know");
        Title_sample.add("Did You Know");
        Title_sample.add("Did You Know");

        Link_sample.add("Link : "+"instagram.com/p/B8q8TzYhlv8/");
        Link_sample.add("Link : "+"instagram.com/p/B8q8TzYhlv8/");
        Link_sample.add("Link : "+"instagram.com/p/B8q8TzYhlv8/");
        Link_sample.add("Link : "+"instagram.com/p/B8q8TzYhlv8/");

        recyclerView_feed=(RecyclerView)getView().findViewById(R.id.recyclerview_feed);


        //layout for recycler view to have feed images or something

        recyclerView_feed.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_feed.setAdapter(new FeedAdapter(URLS_sample,Desc_sample,Title_sample,Link_sample));



    }
}
