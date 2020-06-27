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

public class momRecyclerviewAdapter extends RecyclerView.Adapter < momRecyclerviewAdapter.momViewholder > {
    List <String> mom_titles_list=new ArrayList<>();
    List <String> mom_content_list=new ArrayList<>();
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

    public momRecyclerviewAdapter(List<String> mom_titles, List<String> mom_content) {
        mom_titles_list=mom_titles;
        mom_content_list=mom_content;
    }

    @NonNull
    @Override
    public momViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mom_view,parent,false);
        return new momRecyclerviewAdapter.momViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull momViewholder holder, final int position) {
        holder.textView_mom_title.setText(mom_titles_list.get(position));
        holder.textView_mom_content.setText(mom_content_list.get(position));
        final boolean isExpanded = position==mExpandedPosition;
        holder.textView_mom_content.setVisibility(isExpanded?View.VISIBLE:View.GONE);

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
        return mom_titles_list.size();
    }

    public class momViewholder extends RecyclerView.ViewHolder{
        TextView textView_mom_title,textView_mom_content;
        public momViewholder(@NonNull View itemView) {
            super(itemView);
            textView_mom_title=itemView.findViewById(R.id.mom_title);
            textView_mom_content=itemView.findViewById(R.id.mom_content);
            textView_mom_content.setVisibility(View.GONE);
        }
    }
}
