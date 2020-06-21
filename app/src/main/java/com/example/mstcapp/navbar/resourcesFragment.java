package com.example.mstcapp.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ResourcesAdapter;
import com.example.mstcapp.SignInActivity;

import java.util.ArrayList;
import java.util.List;

public class resourcesFragment extends Fragment {

    RecyclerView recyclerView;  //views on the layout
    TextView tv;

    List<String> domains= new ArrayList<>(); //list for recycler view
    List<Integer> domain_backgroundId=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resources, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        domains.add("Android");
        domains.add("Web Dev");
        domains.add("Front-End Web");
        domains.add("Back-End Web");domains.add("Data Science");domains.add("Competitive coding");

        domain_backgroundId.add(R.drawable.android_symbol_green);
        domain_backgroundId.add(R.drawable.flutter_bg);
        domain_backgroundId.add(R.drawable.webdev_bg);
        domain_backgroundId.add(R.drawable.webdev_bg);
        domain_backgroundId.add(R.drawable.bg_datascience);
        domain_backgroundId.add(R.drawable.competitive_bg);

        recyclerView=(RecyclerView)getView().findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);   //setting layout as grid in the recycler view
        recyclerView.setAdapter(new ResourcesAdapter(domains,domain_backgroundId));//adapter for the recycler view



    }
}
