package com.example.mstcapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.exclusiveModels.attendanceModelClass;


import java.util.ArrayList;
import java.util.List;

public class attendanceAdapter extends RecyclerView.Adapter <attendanceAdapter.attendanceViewholer> {
    List<String> list_attendance_titles=new ArrayList<>();
    List<String> list_attendance_content=new ArrayList<>();
    Context context;
    List<attendanceModelClass> attendanceModelClassList=new ArrayList<>();

    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

    public attendanceAdapter(List<attendanceModelClass> attendanceModelClasses_list) {
        attendanceModelClassList=attendanceModelClasses_list;
    }

    @NonNull
    @Override
    public attendanceViewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_view,parent,false);
        return new attendanceAdapter.attendanceViewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull attendanceViewholer holder, final int position) {
        holder.attendance_title.setText(attendanceModelClassList.get(position).getTitle());
        List<String> contents=attendanceModelClassList.get(position).getContent();
        int size=attendanceModelClassList.get(position).getContent().size();
        holder.attendance_content.setText(getData(size,contents));
        Log.i("Size",size+"");

        holder.date_num.setText(attendanceModelClassList.get(position).getDate());
        holder.date_month.setText(attendanceModelClassList.get(position).getMonth());
        final boolean isExpanded = position==mExpandedPosition;
        holder.attendance_content.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_num.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_month.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.attendance_imageview.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
            previousExpandedPosition = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
    }

    private String getData(int n,List<String> arr) {
        String C="";
        for(int i=0;i<n;i++){
            C+=arr.get(i)+"\n";
        }
        return C;
    }

    @Override
    public int getItemCount() {
        return attendanceModelClassList.size();
    }

    public class attendanceViewholer extends RecyclerView.ViewHolder{



        TextView attendance_title,attendance_content;
        ImageView attendance_imageview;
        TextView date_num,date_month;

        public attendanceViewholer(@NonNull View itemView) {
            super(itemView);
            attendance_title=itemView.findViewById(R.id.attendance_title);
            attendance_content=itemView.findViewById(R.id.attendance_content);
            date_month=itemView.findViewById(R.id.attd_month);
            date_num=itemView.findViewById(R.id.attd_date_num);
            attendance_imageview=itemView.findViewById(R.id.attd_image);

            attendance_content.setVisibility(View.GONE);
            attendance_imageview.setVisibility(View.GONE);
            date_month.setVisibility(View.GONE);
            date_num.setVisibility(View.GONE);


        }
    }
}
