package com.example.mstcapp.onlineFootprint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.Adapters.eventFragmentAdapter;
import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class eventsFragments extends Fragment {

    private String Header;
    private String Description;
    private int Photo;
    View view;

    //Constructor
    public eventsFragments() {
    }

    private RecyclerView recyclerView;
    private List<eventsFragments> eventsList;


    public eventsFragments(String header,String description,int photo){
        Header=header;
        Description=description;
        Photo=photo;
    }



    //Getter
    public String getHeader() {
        return Header;
    }

    public String getDescription() {
        return Description;
    }

    public int getPhoto() {
        return Photo;
    }

    //Setter
    public void setHeader(String header) {
        Header = header;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.eventsfragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.events_recycler);
        eventFragmentAdapter recyclerAdapter= new eventFragmentAdapter(getContext(),eventsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        eventsList=new ArrayList<>();
        eventsList.add(new eventsFragments("Brew","Our Flagship Event",R.drawable.pp));
        eventsList.add(new eventsFragments("Docker","Another Event",R.drawable.pp));
    }
}
