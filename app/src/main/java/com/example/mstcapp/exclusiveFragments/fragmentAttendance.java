package com.example.mstcapp.exclusiveFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.attendanceAdapter;
import com.example.mstcapp.exclusiveModels.attendanceModelClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fragmentAttendance extends Fragment {

    List <attendanceModelClass> attendanceModelClasses_list=new ArrayList<>();
    DatabaseReference databaseReference_attd;
    List<String> attendance_titles=new ArrayList<>();
    List<String> content=new ArrayList<>();
    List<String> attendance_names=new ArrayList<>();
    RecyclerView recyclerView_attendance;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View attd_view=inflater.inflate(R.layout.fragment_attendance,container,false);
        recyclerView_attendance=attd_view.findViewById(R.id.attendance_recyclerview);
        recyclerView_attendance.setLayoutManager(new LinearLayoutManager(getContext()));
        initializeData();

        return attd_view;
    }

    private void initializeData() {
        attendanceModelClasses_list=new ArrayList<>();
        databaseReference_attd= FirebaseDatabase.getInstance().getReference().child("Attendance");
        databaseReference_attd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    String title=dataSnapshot1.child("Title").getValue().toString();
                    Log.i("data" ,title);
                    content= (List<String>) dataSnapshot1.child("Content").getValue();
                    String date=dataSnapshot1.child("Date").getValue().toString();
                    String month=dataSnapshot1.child("Month").getValue().toString();
                    attendanceModelClasses_list.add(new attendanceModelClass(content,date,month,title));
                }


                final attendanceAdapter adapter=new attendanceAdapter(attendanceModelClasses_list);
                recyclerView_attendance.setAdapter(adapter);


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
        attendance_titles.clear();
    }
}
