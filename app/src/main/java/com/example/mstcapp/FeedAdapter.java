package com.example.mstcapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.ImageHeaderParser;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter <FeedAdapter.FeedView>{
    List <Integer> samples=new ArrayList<>();
    public FeedAdapter(List<Integer> urls_sample) {
    samples=urls_sample;
    }

    @NonNull
    @Override
    public FeedView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //fills the view with card view layout made (feed_view)
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_view,parent,false);
        return new FeedView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedView holder, int position) {
        holder.imageView.setImageResource(samples.get(position));
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    public class FeedView extends RecyclerView.ViewHolder{

        ImageView imageView;
        public FeedView(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.feed_image);

        }
    }
}
