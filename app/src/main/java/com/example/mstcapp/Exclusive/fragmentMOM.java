package com.example.mstcapp.Exclusive;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;

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

public class fragmentMOM extends Fragment {


    List <momModelClass> momModelClass_list=new ArrayList<>();
    RecyclerView recyclerView_mom;
    DatabaseReference databaseReference_mom;
    private ProgressBar mProgressCircular;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mom_view=inflater.inflate(R.layout.fragment_mom,container,false);

        mProgressCircular=mom_view.findViewById(R.id.progressBar_mom);
        recyclerView_mom=mom_view.findViewById(R.id.mom_recyclerview);
        recyclerView_mom.setLayoutManager(new LinearLayoutManager(getContext()));


        initializeData();
        return mom_view;
    }

    private void initializeData() {
        momModelClass_list=new ArrayList<>();

        databaseReference_mom= FirebaseDatabase.getInstance().getReference().child("Mom");
        databaseReference_mom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    String title=dataSnapshot1.child("Title").getValue().toString();
                    String content=dataSnapshot1.child("Content").getValue().toString();
                    String date=dataSnapshot1.child("Date").getValue().toString();
                    String month=dataSnapshot1.child("Month").getValue().toString();
                    momModelClass_list.add(new momModelClass(content,date,month,title));
                }
                mProgressCircular.setVisibility(View.INVISIBLE);
                final momRecyclerviewAdapter adapter=new momRecyclerviewAdapter(momModelClass_list);
                recyclerView_mom.setAdapter(adapter);


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
