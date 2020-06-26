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
import com.example.mstcapp.adapters.updatesAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragmentUpdates extends Fragment {
    List<String> updates_titles=new ArrayList<>();
    RecyclerView recyclerView_updates;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_updates,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView_updates=view.findViewById(R.id.updates_recyclerview);
        updates_titles.add("Update for the day");
        updates_titles.add("Update for the day");

        recyclerView_updates.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_updates.setAdapter(new updatesAdapter(updates_titles));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        updates_titles.clear();
    }
}
