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

public class nestedAttendanceadapter extends RecyclerView.Adapter<nestedAttendanceadapter.nestedViewholder>{

    List<String>  names =new ArrayList<>();
    public nestedAttendanceadapter(List<String> list_attendance_content) {
        names=list_attendance_content;
    }

    @NonNull
    @Override
    public nestedViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_recyclerview_attd,parent,false);
        return new nestedAttendanceadapter.nestedViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nestedViewholder holder, int position) {
        holder.textView_attdnames.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class nestedViewholder extends RecyclerView.ViewHolder{
        TextView textView_attdnames;
        public nestedViewholder(@NonNull View itemView) {
            super(itemView);
            textView_attdnames=itemView.findViewById(R.id.nested_rv_text);
        }
    }

}
