package com.example.mstcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    Context mContext;
    List<eventsFragments> mData;

    public RecyclerViewAdapter(Context mContext, List<eventsFragments> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.items_event,parent,false);
        myViewHolder vHolder=new myViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tv_header.setText(mData.get(position).getHeader());
        holder.tv_descrip.setText(mData.get(position).getDescription());
        holder.image_event.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_header;
        private TextView tv_descrip;
        private ImageView image_event;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_header=(TextView)itemView.findViewById(R.id.name_event);
            tv_descrip=(TextView)itemView.findViewById(R.id.descr_event);
            image_event=(ImageView)itemView.findViewById(R.id.image_event);
        }

    }
}
