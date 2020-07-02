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
import com.example.mstcapp.adapters.attendanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragmentAttendance extends Fragment {
    List<String> attendance_titles=new ArrayList<>();
    List<String> attendance_content=new ArrayList<>();
    List<String> attendance_names=new ArrayList<>();
    RecyclerView recyclerView_attendance;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attendance,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView_attendance=view.findViewById(R.id.attendance_recyclerview);
        attendance_titles.add("Attendance List");
        attendance_titles.add("Attendance List");

        attendance_content.add("Attendance names ");
        attendance_content.add("Attendance names ");

        recyclerView_attendance.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_attendance.setAdapter(new attendanceAdapter(attendance_titles,attendance_content,getContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        attendance_titles.clear();
    }
}
