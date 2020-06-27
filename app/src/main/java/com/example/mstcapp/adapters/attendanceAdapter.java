package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;



import java.util.ArrayList;
import java.util.List;

public class attendanceAdapter extends RecyclerView.Adapter <attendanceAdapter.attendanceViewholer> {
    List<String> list_attendance_titles=new ArrayList<>();
    public attendanceAdapter(List<String> attendance_titles) {
        list_attendance_titles=attendance_titles;
    }

    @NonNull
    @Override
    public attendanceViewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_view,parent,false);
        return new attendanceAdapter.attendanceViewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull attendanceViewholer holder, int position) {
    holder.attendance_title.setText(list_attendance_titles.get(position));
    }

    @Override
    public int getItemCount() {
        return list_attendance_titles.size();
    }

    public class attendanceViewholer extends RecyclerView.ViewHolder{

        TextView attendance_title,attendance_content;
        public attendanceViewholer(@NonNull View itemView) {
            super(itemView);
            attendance_title=itemView.findViewById(R.id.attendance_title);
            attendance_content=itemView.findViewById(R.id.attendance_content);
            attendance_content.setVisibility(View.GONE);
        }
    }
}
