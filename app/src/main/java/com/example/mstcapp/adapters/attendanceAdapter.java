package com.example.mstcapp.adapters;

import android.content.Context;
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



import java.util.ArrayList;
import java.util.List;

public class attendanceAdapter extends RecyclerView.Adapter <attendanceAdapter.attendanceViewholer> {
    List<String> list_attendance_titles=new ArrayList<>();
    List<String> list_attendance_content=new ArrayList<>();
    Context context;

    ArrayList<String> attd_names=new ArrayList<>();

    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;
    public attendanceAdapter(List<String> attendance_titles,List <String> attendance_content,Context cont) {
        list_attendance_titles=attendance_titles;
        list_attendance_content=attendance_content;
        context=cont;
    }

    @NonNull
    @Override
    public attendanceViewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_view,parent,false);
        return new attendanceAdapter.attendanceViewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull attendanceViewholer holder, final int position) {
        holder.attendance_title.setText(list_attendance_titles.get(position));
        //holder.attendance_content.setText(list_attendance_content.get(position));
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

    @Override
    public int getItemCount() {
        return list_attendance_titles.size();
    }

    public class attendanceViewholer extends RecyclerView.ViewHolder{


        RecyclerView recyclerView_nest_attd;
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
            recyclerView_nest_attd=itemView.findViewById(R.id.nested_rv);

            recyclerView_nest_attd.setLayoutManager(new LinearLayoutManager(context));
            recyclerView_nest_attd.setAdapter(new nestedAttendanceadapter(list_attendance_content));

            recyclerView_nest_attd.setVisibility(View.GONE);
            attendance_content.setVisibility(View.GONE);
            attendance_imageview.setVisibility(View.GONE);
            date_month.setVisibility(View.GONE);
            date_num.setVisibility(View.GONE);


        }
    }
}
