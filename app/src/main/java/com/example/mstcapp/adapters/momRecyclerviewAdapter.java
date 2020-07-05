package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.exclusiveModels.momModelClass;

import java.util.ArrayList;
import java.util.List;

public class momRecyclerviewAdapter extends RecyclerView.Adapter < momRecyclerviewAdapter.momViewholder > {

    List<momModelClass> mom_class_list=new ArrayList<>();
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;



    public momRecyclerviewAdapter(List<momModelClass> momModelClass_list) {
        mom_class_list=momModelClass_list;
    }

    @NonNull
    @Override
    public momViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mom,parent,false);
        return new momRecyclerviewAdapter.momViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull momViewholder holder, final int position) {
        holder.textView_mom_title.setText(mom_class_list.get(position).getTitle());
        holder.textView_mom_content.setText(mom_class_list.get(position).getContent());
        holder.date_month.setText(mom_class_list.get(position).getMonth());
        holder.date_num.setText(mom_class_list.get(position).getDate());
        final boolean isExpanded = position==mExpandedPosition;
        holder.textView_mom_content.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_num.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_month.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.imageView_mom.setVisibility(isExpanded?View.VISIBLE:View.GONE);
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
        return mom_class_list.size();
    }

    public class momViewholder extends RecyclerView.ViewHolder{
        ImageView imageView_mom;
        TextView textView_mom_title,textView_mom_content;
        TextView date_num,date_month;

        public momViewholder(@NonNull View itemView) {
            super(itemView);
            textView_mom_title=itemView.findViewById(R.id.mom_title);
            textView_mom_content=itemView.findViewById(R.id.mom_content);
            imageView_mom=itemView.findViewById(R.id.mom_image);
            date_month=itemView.findViewById(R.id.mom_month);
            date_num=itemView.findViewById(R.id.mom_date_num);

            date_month.setVisibility(View.GONE);
            date_num.setVisibility(View.GONE);
            textView_mom_content.setVisibility(View.GONE);
            imageView_mom.setVisibility(View.GONE);
        }
    }
}
