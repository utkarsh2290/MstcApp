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
    public momRecyclerviewAdapter(List<String> mom_titles) {
        mom_titles_list=mom_titles;
    }

    @NonNull
    @Override
    public momViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mom_view,parent,false);
        return new momRecyclerviewAdapter.momViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull momViewholder holder, int position) {
        holder.textView_mom_title.setText(mom_titles_list.get(position));
    }

    @Override
    public int getItemCount() {
        return mom_titles_list.size();
    }

    public class momViewholder extends RecyclerView.ViewHolder{
        TextView textView_mom_title;
        public momViewholder(@NonNull View itemView) {
            super(itemView);
            textView_mom_title=itemView.findViewById(R.id.mom_title);
        }
    }
}
