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
import com.example.mstcapp.exclusiveModels.momModelClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fragmentUpdates extends Fragment {


    List<momModelClass> updatesModelClassList=new ArrayList<momModelClass>();
    RecyclerView recyclerView_updates;
    DatabaseReference databaseReference_updates;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View updates_view=inflater.inflate(R.layout.fragment_updates,container,false);
        recyclerView_updates=updates_view.findViewById(R.id.updates_recyclerview);
        recyclerView_updates.setLayoutManager(new LinearLayoutManager(getContext()));

        initializeData();

        return updates_view;
    }

    private void initializeData() {
        updatesModelClassList=new ArrayList<momModelClass>();

        databaseReference_updates= FirebaseDatabase.getInstance().getReference().child("Updates");
        databaseReference_updates.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    String title=dataSnapshot1.child("Title").getValue().toString();
                    String content=dataSnapshot1.child("Content").getValue().toString();
                    String date=dataSnapshot1.child("Date").getValue().toString();
                    String month=dataSnapshot1.child("Month").getValue().toString();
                    updatesModelClassList.add(new momModelClass(content,date,month,title));
                }
                final momRecyclerviewAdapter adapter=new momRecyclerviewAdapter(updatesModelClassList);
                recyclerView_updates.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
