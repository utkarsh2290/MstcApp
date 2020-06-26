package com.example.mstcapp.Exclusive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.momRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragmentMOM extends Fragment {
    List <String> mom_titles=new ArrayList<>();
    RecyclerView recyclerView_mom;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mom,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mom_titles.add("Title for MOM");
        mom_titles.add("Another Title for MOM");
        recyclerView_mom=view.findViewById(R.id.mom_recyclerview);

        recyclerView_mom.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_mom.setAdapter(new momRecyclerviewAdapter(mom_titles));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mom_titles.clear();
    }
}