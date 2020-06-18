package com.example.mstcapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.onlineFootprint.projectFragment;

import java.util.List;

public class projectRecyclerAdapter extends RecyclerView.Adapter<projectRecyclerAdapter.myViewHolder> {

    Context mContext1;
    List<projectFragment> mData1;

    public projectRecyclerAdapter(Context mContext1, List<projectFragment> mData) {
        this.mContext1 = mContext1;
        this.mData1 = mData;
    }

    @NonNull
    @Override
    public projectRecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext1).inflate(R.layout.items_project, parent, false);
        myViewHolder vHolder = new myViewHolder(v);
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull projectRecyclerAdapter.myViewHolder holder, int position) {
        holder.proj_name.setText(mData1.get(position).getProjHeader());
        holder.proj_descrip.setText(mData1.get(position).getDescriptionProj());
    }

    @Override
    public int getItemCount() {
        return mData1.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        private TextView proj_name;
        private TextView proj_descrip;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            proj_name = (TextView) itemView.findViewById(R.id.name_proj);
            proj_descrip = (TextView) itemView.findViewById(R.id.descrip_proj);


        }
    }
}
